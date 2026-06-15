-- Create the students table
CREATE TABLE cstudents (
    student_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    major VARCHAR2(50),
    university VARCHAR2(100),
    year NUMBER,
    skills VARCHAR2(200)
);

-- Insert your details into the cstudents table
INSERT INTO cstudents (student_id, name, major, university, year, skills) 
VALUES (1, 'Keshab Kumar', 'Computer Science and Engineering', 'Noida Institute of Engineering and Technology', 3, 'Data Science, Machine Learning, Web Technologies');

INSERT INTO cstudents (student_id, name, major, university, year, skills) 
VALUES (2, 'Ravan Jha', 'Computer Science and Engineering', 'Noida Institute of Engineering and Technology', 3, 'Artificial Intelligence, Machine Learning, BlockChain');

-- Select all records from the students table
SELECT * FROM cstudents;


-- Create the projects table
CREATE TABLE projectss (
    project_id NUMBER PRIMARY KEY,
    student_id NUMBER,
    project_name VARCHAR2(100),
    description VARCHAR2(255),
    FOREIGN KEY (student_id) REFERENCES cstudents(student_id)
);

-- Insert project details into the projects table
INSERT INTO projectss (project_id, student_id, project_name, description) VALUES (1, 1, 'PG-Life', 'A platform for booking paying guest accommodations.');
INSERT INTO projectss (project_id, student_id, project_name, description) VALUES (2, 2, 'ProfsPortail', 'A collaborative tool for academic communication.');
INSERT INTO projectss (project_id, student_id, project_name, description) VALUES (3, 1, 'SamvadHub', 'A dynamic social media platform for user engagement and interaction.');
INSERT INTO projectss (project_id, student_id, project_name, description) VALUES (4, 2, 'Weather App', 'An application providing real-time weather information with a chatbot.');
INSERT INTO projectss (project_id, student_id, project_name, description) VALUES (5, 1, 'Air Quality Predictive Model', 'Predicts air quality levels using advanced machine learning techniques.');

-- Select all records from the projects table
SELECT * FROM projectss;

-- Nested Subquery
SELECT name 
FROM cstudents 
WHERE student_id IN (SELECT student_id FROM projectss WHERE project_name LIKE '%Weather%');

-- Correlated Subquery
SELECT s.name
FROM cstudents s
WHERE (SELECT COUNT(*) FROM projectss p WHERE p.student_id = s.student_id) > 1;

-- Inner Join
SELECT s.name, p.project_name
FROM cstudents s
INNER JOIN projectss p ON s.student_id = p.student_id;

-- Outer Join
SELECT s.name, p.project_name
FROM cstudents s
LEFT OUTER JOIN projectss p ON s.student_id = p.student_id;

-- Equi Join
SELECT s.name, p.project_name
FROM cstudents s, projectss p
WHERE s.student_id = p.student_id;


