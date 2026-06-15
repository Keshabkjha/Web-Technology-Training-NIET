--using F9 (for single statements) and F5 (for entire script).
-- Step 1: Create a table named Employees
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR2(50),
    LastName VARCHAR2(50),
    BirthDate DATE,
    Salary NUMBER(10, 2)
);

-- Step 2: Insert sample data into the Employees table
INSERT INTO Employees (EmployeeID, FirstName, LastName, BirthDate, Salary)
VALUES (1, 'Keshab', 'Kumar', TO_DATE('2026-01-15', 'YYYY-MM-DD'), 55000.00);
INSERT INTO Employees (EmployeeID, FirstName, LastName, BirthDate, Salary)
VALUES (2, 'Ravan', 'Jha', TO_DATE('2026-05-10', 'YYYY-MM-DD'), 60000.00);
INSERT INTO Employees (EmployeeID, FirstName, LastName, BirthDate, Salary)
VALUES (3, 'Aman', 'Jishan', TO_DATE('2026-09-23', 'YYYY-MM-DD'), 72000.00);

-- Step 3: Add an Email column to the Employees table
ALTER TABLE Employees ADD Email VARCHAR2(100);

-- Step 4: Update the Email column with data
UPDATE Employees SET Email = 'Keshabkumarjha876@gmail.com' WHERE EmployeeID = 1;
UPDATE Employees SET Email = 'Ravanjha876@gmail.com' WHERE EmployeeID = 2;
UPDATE Employees SET Email = 'mdaman1017@gmail.com' WHERE EmployeeID = 3;

-- Step 5: Modify the Salary column to increase precision
ALTER TABLE Employees MODIFY Salary NUMBER(12, 2);

-- Step 6: Drop the BirthDate column
ALTER TABLE Employees DROP COLUMN BirthDate;

-- Step 7: Rename the Email column to ContactEmail
ALTER TABLE Employees RENAME COLUMN Email TO ContactEmail;

-- Step 8: Modify the FirstName column data type from VARCHAR2 to CHAR
ALTER TABLE Employees MODIFY FirstName CHAR(30);

-- Step 9: Update the salary values for a raise
UPDATE Employees SET Salary = Salary + 5000 WHERE EmployeeID = 1;
UPDATE Employees SET Salary = Salary + 3000 WHERE EmployeeID = 2;
UPDATE Employees SET Salary = Salary + 2000 WHERE EmployeeID = 3;

-- Step 10: Delete a specific record from the Employees table
DELETE FROM Employees WHERE EmployeeID = 1;

-- Step 11: Truncate the Employees table (removes all rows, keeps structure)
TRUNCATE TABLE Employees;

-- Step 12: Drop the Employees table (removes table structure and data)
DROP TABLE Employees;

