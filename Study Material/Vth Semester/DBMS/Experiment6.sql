-- Step 1: Create the Table
CREATE TABLE population (
    district_id INT PRIMARY KEY,
    district_name VARCHAR(100),
    population INT,
    literacy_rate DECIMAL(4, 2),
    area_sq_km INT,
    sex_ratio INT
);

-- Step 2: Insert Data 
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (1, 'Patna', 5838465, 70.9, 3202, 890);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (2, 'Gaya', 4379383, 66.4, 4976, 936);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (3, 'Bhagalpur', 3032226, 63.1, 2694, 880);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (4, 'Muzaffarpur', 4778610, 60.6, 3173, 920);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (5, 'Darbhanga', 3937385, 61.8, 2279, 902);
INSERT INTO population (district_id, district_name, population, literacy_rate, area_sq_km, sex_ratio) VALUES (6, 'Samastipur', 4261565, 64.2, 2904, 916);


SELECT * FROM population;


-- Step 3: Queries

-- 1. Count the number of districts
SELECT COUNT(district_id) AS total_districts
FROM population;

-- 2. Find the total population of Bihar
SELECT SUM(population) AS total_population
FROM population;

-- 3. Calculate the average literacy rate in Bihar
SELECT AVG(literacy_rate) AS avg_literacy_rate
FROM population;

-- 4. Find the district with the highest population
SELECT district_name, population AS highest_population
FROM population
WHERE population = (SELECT MAX(population) FROM population);

-- 5. Find the district with the lowest literacy rate
SELECT district_name, literacy_rate AS lowest_literacy_rate
FROM population
WHERE literacy_rate = (SELECT MIN(literacy_rate) FROM population);

-- 6. Group districts by sex ratio and count how many districts fall under each sex ratio
SELECT sex_ratio, COUNT(district_id) AS district_count
FROM population
GROUP BY sex_ratio;

-- 7. Find districts with population greater than 4 million, grouped by area and having a sex ratio greater than 900
SELECT area_sq_km, SUM(population) AS total_population
FROM population
WHERE population > 4000000 AND sex_ratio > 900
GROUP BY area_sq_km;


-- Step 4: View Creation and Dropping

-- Create a view for districts with high literacy rate (>65%)
CREATE VIEW high_literacy_districts AS
SELECT district_name, literacy_rate
FROM population
WHERE literacy_rate > 65;

-- Drop the view if it exists
DROP VIEW high_literacy_districts;
