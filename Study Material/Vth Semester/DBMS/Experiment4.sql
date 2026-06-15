CREATE TABLE STUDENT (
    RNO NUMBER(10),
    NAME CHAR(20),
    AGE NUMBER(2),
    CITY CHAR(10),
    MARKS NUMBER(3)
);

INSERT INTO STUDENT VALUES(1, 'Keshab', 19, 'Samastipur', 80);
INSERT INTO STUDENT VALUES(2, 'Ravan', 18, 'Patna', 91);
INSERT INTO STUDENT VALUES(3, 'Kunal', 17, 'Chakshekhu', 86);
INSERT INTO STUDENT VALUES(4, 'Krishna', 16, 'Bihar', 79);
INSERT INTO STUDENT VALUES(5, 'Ankul', 18, 'Noida', 80);

-- Display the table
SELECT * FROM STUDENT;


-- Grant SELECT, INSERT, UPDATE, DELETE permissions to C##Keshabsys
GRANT SELECT, INSERT, UPDATE, DELETE ON STUDENT TO C##Keshabsys;

-- Grant ALL permissions to user_1
GRANT ALL ON STUDENT TO C##Keshabsys;


-- Revoke SELECT, INSERT, UPDATE, DELETE from user_2
REVOKE SELECT, INSERT, UPDATE, DELETE ON STUDENT FROM C##Keshabsys;

-- Revoke all permissions from user_1
REVOKE ALL ON STUDENT FROM C##Keshabsys;

CREATE TABLE class (
    id INT,
    name VARCHAR(50)
);

INSERT INTO class VALUES (1, 'Akrati');
INSERT INTO class VALUES (2, 'Aanchal');
INSERT INTO class VALUES (4, 'Rohit');

-- Display the table
SELECT * FROM class;

-- Insert a new record and commit the changes
INSERT INTO class VALUES (5, 'Jha');
COMMIT;

-- Update a record and set a savepoint
UPDATE class SET name = 'Apoorva' WHERE id = 5;
SAVEPOINT A;

-- Insert more data and set savepoints
INSERT INTO class VALUES (6, 'Arpit');
SAVEPOINT B;

INSERT INTO class VALUES (7, 'Jha');
SAVEPOINT C;

-- Display the updated table
SELECT * FROM class;

-- Rollback to savepoint B
ROLLBACK TO B;

-- Display the table after rollback
SELECT * FROM class;


-- Rollback to savepoint A
ROLLBACK TO A;

-- Display the table after rollback
SELECT * FROM class;
--Implement different type key: -Primary Key, Foreign Key and Unique etc.
CREATE TABLE department (
    department_id INT PRIMARY KEY,   -- Primary Key for department table
    department_name VARCHAR(100)
);

CREATE TABLE employee (
    employee_id INT PRIMARY KEY,        -- Primary Key
    department_id INT,                  -- Foreign Key
    email VARCHAR(100) UNIQUE,          -- Unique Key
    name VARCHAR(50),
    phone_number VARCHAR(15),
    CONSTRAINT fk_department
        FOREIGN KEY (department_id) REFERENCES department(department_id)   -- Foreign Key
);
INSERT INTO department (department_id, department_name) VALUES (101, 'Pharmacy');
INSERT INTO department (department_id, department_name) VALUES (102, 'Engineering');

SELECT * FROM department;
INSERT INTO employee (employee_id, department_id, email, name, phone_number) 
VALUES (1, 101, 'keshabkjha11@gmail.com', 'Keshab Kumar', '8002648473');

INSERT INTO employee (employee_id, department_id, email, name, phone_number) 
VALUES (2, 102, 'Developerkeshab@gmail.com', 'Developer Keshab', '9934271270');

SELECT * FROM employee;

