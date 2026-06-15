-- Create the population table with constraints
CREATE TABLE population (
    district_id INT PRIMARY KEY,
    district_name VARCHAR(100) NOT NULL,
    population INT CHECK (population > 0),
    literacy_rate DECIMAL(4, 2) CHECK (literacy_rate BETWEEN 0 AND 100),
    area_sq_km INT,
    sex_ratio INT,
    UNIQUE (district_name) -- Ensures district names are unique
);

-- Insert sample data into the population table
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (1, 'Patna', 5838465, 70.9, 3202, 890);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (2, 'Gaya', 4379383, 66.4, 4976, 936);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (3, 'Bhagalpur', 3032226, 63.1, 2694, 880);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (4, 'Muzaffarpur', 4778610, 60.6, 3173, 920);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (5, 'Darbhanga', 3937385, 61.8, 2279, 902);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (6, 'Samastipur', 4261565, 64.2, 2904, 916);

SELECT * FROM population;
-- 1. Using ANY
SELECT district_name, population
FROM population
WHERE population > ANY (SELECT population FROM population WHERE literacy_rate < 65);

-- 2. Using ALL
SELECT district_name, population
FROM population
WHERE population > ALL (SELECT population FROM population WHERE literacy_rate < 65);

-- 3. Using IN
SELECT district_name, literacy_rate
FROM population
WHERE literacy_rate IN (70.9, 66.4);

-- 4. Using EXISTS
SELECT district_name, population
FROM population p
WHERE population > 4000000 AND EXISTS (SELECT 1 FROM population WHERE literacy_rate > 65);

-- 5. Using NOT EXISTS
SELECT district_name, literacy_rate
FROM population p
WHERE NOT EXISTS (SELECT 1 FROM population h WHERE h.district_name = p.district_name AND h.literacy_rate > 70);

-- 6. Using UNION
SELECT district_name
FROM population
WHERE population > 4000000
UNION
SELECT district_name
FROM population
WHERE literacy_rate > 65;

-- 7. Using INTERSECT
SELECT district_name
FROM population
WHERE population > 4000000
INTERSECT
SELECT district_name
FROM population
WHERE literacy_rate > 65;


SELECT sys_context('USERENV', 'SID') AS SID FROM dual;
