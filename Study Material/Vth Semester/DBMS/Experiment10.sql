DROP PROCEDURE SYS.InsertAccountData;
ALTER SESSION SET CURRENT_SCHEMA = C##Keshabkjha;

-- Create a stored procedure to insert data into the Account table
CREATE OR REPLACE PROCEDURE InsertAccountData (
    p_AccountID INT,
    p_AccountHolderName VARCHAR,
    p_AccountType VARCHAR,
    p_Balance DECIMAL
)
AS
BEGIN
    -- Insert into Account table
    INSERT INTO Account (AccountID, AccountHolderName, AccountType, Balance)
    VALUES (p_AccountID, p_AccountHolderName, p_AccountType, p_Balance);
    
    -- Log the insertion into AuditLog table
    INSERT INTO AuditLog (ActionType, AccountID, Details)
    VALUES (
        'INSERT',
        p_AccountID,
        'New account created: ' || p_AccountHolderName || ', Type: ' || p_AccountType || ', Balance: ' || p_Balance
    );
END;
/
-- Execute the stored procedure to insert data
EXEC InsertAccountData(105, 'Amit Singh', 'Checking', 8000.00);
EXEC InsertAccountData(106, 'Sunita Devi', 'Savings', 12000.00);
EXEC InsertAccountData(107, 'Rahul Yadav', 'Business', 20000.00);
EXEC InsertAccountData(101, 'Keshab Kumar', 'Checking', 8000.00);
EXEC InsertAccountData(102, 'Ravan jha', 'Savings', 12000.00);
EXEC InsertAccountData(103, 'Rishu Choudhary', 'Business', 20000.00);

-- Display Account table after insertion
SELECT * FROM Account;

-- Display AuditLog table after insertion
SELECT * FROM AuditLog;

--Modify the stored procedure to check for negative balance
CREATE OR REPLACE PROCEDURE InsertAccountData (
    p_AccountID INT,
    p_AccountHolderName VARCHAR,
    p_AccountType VARCHAR,
    p_Balance DECIMAL
)
AS
BEGIN
    -- Check if balance is negative
    IF p_Balance < 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Balance cannot be negative');
    END IF;
    
    -- Insert into Account table
    INSERT INTO Account (AccountID, AccountHolderName, AccountType, Balance)
    VALUES (p_AccountID, p_AccountHolderName, p_AccountType, p_Balance);
    
    -- Log the insertion into AuditLog table
    INSERT INTO AuditLog (ActionType, AccountID, Details)
    VALUES (
        'INSERT',
        p_AccountID,
        'New account created: ' || p_AccountHolderName || ', Type: ' || p_AccountType || ', Balance: ' || p_Balance
    );
END;
/

--Execute the modified procedure with a negative balance (to raise an error)
BEGIN 
    InsertAccountData(108, 'Arsalan', 'Checking', -500.00); 
END;


-- Display Account table after failed insertion (no record should be inserted)
SELECT * FROM Account;

-- Display AuditLog table after failed insertion (no log should be added)
SELECT * FROM AuditLog;


SELECT OBJECT_NAME, OBJECT_TYPE, OWNER
FROM ALL_OBJECTS
WHERE OBJECT_NAME = 'INSERTACCOUNTDATA';
