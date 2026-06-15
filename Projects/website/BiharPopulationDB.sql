-- 1. DDL Commands (Create, Alter, Drop)
-- Create User and Database
CREATE USER C##BiharPopulationDB IDENTIFIED BY password;
GRANT CONNECT, RESOURCE TO C##BiharPopulationDB;

-- Use BiharPopulationDB Schema
ALTER SESSION SET CURRENT_SCHEMA = C##BiharPopulationDB;
ALTER USER C##BiharPopulationDB QUOTA UNLIMITED ON USERS;

-- Create Table with Primary Key, Unique, Foreign Key Constraints
CREATE TABLE Population (
    id NUMBER PRIMARY KEY,
    district_name VARCHAR2(50) NOT NULL,
    population NUMBER NOT NULL,
    literacy_rate NUMBER(5, 2),
    population_density NUMBER,
    area NUMBER(10, 2),
    male_population NUMBER,
    female_population NUMBER,
    growth_rate NUMBER(5, 2),
    region_id NUMBER,
    CONSTRAINT unique_district_name UNIQUE (district_name),
    CONSTRAINT fk_region FOREIGN KEY (region_id) REFERENCES Region(region_id)
);

-- Create Sequence for id field
CREATE SEQUENCE population_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Alter Table Example
ALTER TABLE Population MODIFY (literacy_rate NUMBER(5, 2) DEFAULT 0);

-- Drop Table Example
-- DROP TABLE Population;

-- 2. DML Commands (Insert, Select, Update, Delete)
-- Insert Records
INSERT INTO Population (id, district_name, population, literacy_rate, population_density, area, male_population, female_population)
VALUES 
    (population_seq.NEXTVAL, 'Patna', 5838465, 72.47, 1823, 3202.56, 3050400, 2788065);

INSERT INTO Population (id, district_name, population, literacy_rate, population_density, area, male_population, female_population)
VALUES 
    (population_seq.NEXTVAL, 'Gaya', 4379398, 63.67, 883, 4976.23, 2270100, 2109298);

-- Update Query
UPDATE Population
SET literacy_rate = 74.00
WHERE district_name = 'Patna';

-- Delete Query
DELETE FROM Population
WHERE district_name = 'Gaya';

-- 3. DCL Commands (Grant and Revoke)
CREATE ROLE C##district_manager;
GRANT SELECT, INSERT ON Population TO C##district_manager;
GRANT C##district_manager TO C##BiharPopulationDB;
REVOKE SELECT ON Population FROM C##district_manager;

-- 4. TCL Commands (Rollback, Commit, Savepoint)
SAVEPOINT BeforeUpdate;
UPDATE Population
SET population = 6000000
WHERE district_name = 'Patna';
ROLLBACK TO BeforeUpdate;
COMMIT;

-- 6. Aggregate Functions (COUNT, SUM, AVG, MAX, MIN), Group By, Having, Views
-- Aggregate Functions
SELECT COUNT(*) FROM Population;
SELECT SUM(population) AS total_population FROM Population;
SELECT AVG(literacy_rate) AS avg_literacy_rate FROM Population;
SELECT MAX(population) AS max_population FROM Population;
SELECT MIN(population) AS min_population FROM Population;

-- Group By and Having
SELECT population_density, AVG(literacy_rate)
FROM Population
GROUP BY population_density
HAVING AVG(literacy_rate) > 50;

-- View Creation and Dropping
CREATE VIEW PopulationView AS
SELECT district_name, population, literacy_rate FROM Population;

-- DROP VIEW PopulationView;

-- 7. Queries using ANY, ALL, IN, EXISTS, NOT EXISTS, UNION, INTERSECT, CONSTRAINTS
-- ANY, ALL, IN, EXISTS
SELECT district_name FROM Population WHERE population_density > ALL (SELECT population_density FROM Population WHERE population_density < 1000);
SELECT district_name FROM Population WHERE district_name IN ('Patna', 'Gaya');
SELECT district_name FROM Population WHERE EXISTS (SELECT 1 FROM C##BiharPopulationDB.Region WHERE region_id = Population.region_id);


-- UNION, INTERSECT
SELECT district_name FROM Population WHERE literacy_rate > 70
UNION
SELECT district_name FROM Population WHERE population > 5000000;

-- 8. Subqueries (Nested, Correlated) and Joins (Inner, Outer, Equi)
-- Nested Subquery
SELECT district_name FROM Population WHERE population = (SELECT MAX(population) FROM Population);

-- Correlated Subquery
--SELECT district_name, population
--FROM Population AS P1
--WHERE population > (SELECT AVG(population) FROM Population AS P2 WHERE P2.population_density = P1.population_density);

-- Inner Join
SELECT P.district_name, R.region_name
FROM Population P
INNER JOIN Region R ON P.id = R.region_id;

-- Outer Join
SELECT P.district_name, R.region_name
FROM Population P
LEFT OUTER JOIN Region R ON P.id = R.region_id;

-- Equi Join
SELECT P.district_name, R.region_name
FROM Population P, Region R
WHERE P.id = R.region_id;

-- 9. Triggers (Create, Insert, Delete, Update)
-- Trigger to update growth rate before updating population
CREATE OR REPLACE TRIGGER UpdateGrowthRate
BEFORE UPDATE OF population ON Population
FOR EACH ROW
BEGIN
    IF :OLD.population > 0 THEN
        :NEW.growth_rate := ((:NEW.population - :OLD.population) / :OLD.population) * 100;
    ELSE
        :NEW.growth_rate := NULL;
    END IF;
END;
/

-- 10. Stored Procedures (Create, Execute, Modify)
CREATE OR REPLACE PROCEDURE AddDistrict (
    district_name IN VARCHAR2,
    population IN NUMBER,
    literacy_rate IN NUMBER,
    population_density IN NUMBER,
    area IN NUMBER,
    male_population IN NUMBER,
    female_population IN NUMBER
) AS
BEGIN
    INSERT INTO Population (id, district_name, population, literacy_rate, population_density, area, male_population, female_population)
    VALUES (population_seq.NEXTVAL, district_name, population, literacy_rate, population_density, area, male_population, female_population);
END;
/

-- Modify Procedure
CREATE OR REPLACE PROCEDURE UpdateDistrictPopulation (
    district_name IN VARCHAR2,
    new_population IN NUMBER
) AS
BEGIN
    UPDATE Population SET population = new_population WHERE district_name = district_name;
END;
/

-- 11. Cursors (Declare, Open, Fetch, Close)
DECLARE
    CURSOR district_cursor IS
        SELECT district_name, population FROM Population;
    district_name Population.district_name%TYPE;
    population Population.population%TYPE;
BEGIN
    OPEN district_cursor;
    LOOP
        FETCH district_cursor INTO district_name, population;
        EXIT WHEN district_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('District: ' || district_name || ', Population: ' || population);
    END LOOP;
    CLOSE district_cursor;
END;
/

-- Sample Query - SUM and AVG
SELECT SUM(population) AS total_population, AVG(literacy_rate) AS avg_literacy_rate FROM Population;

-- COUNT, MAX, MIN Functions with GROUP BY
SELECT region_id, COUNT(id) AS district_count, MAX(population) AS max_population, MIN(population) AS min_population
FROM Population
GROUP BY region_id;

-- CASE Statement for Literacy Category
SELECT district_name,
       population,
       CASE 
           WHEN literacy_rate > 70 THEN 'High Literacy'
           WHEN literacy_rate BETWEEN 50 AND 70 THEN 'Medium Literacy'
           ELSE 'Low Literacy'
       END AS literacy_category
FROM Population;
