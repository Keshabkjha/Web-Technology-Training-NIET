-- Declare a block to use the cursor
DECLARE
    -- Declare the cursor to fetch data from the Account table
    CURSOR account_cursor IS
        SELECT AccountID, AccountHolderName, AccountType, Balance
        FROM Account;

    -- Variables to hold fetched data
    v_AccountID Account.AccountID%TYPE;
    v_AccountHolderName Account.AccountHolderName%TYPE;
    v_AccountType Account.AccountType%TYPE;
    v_Balance Account.Balance%TYPE;

BEGIN
    -- Open the cursor
    OPEN account_cursor;

    -- Fetch rows from the cursor one by one
    LOOP
        FETCH account_cursor INTO v_AccountID, v_AccountHolderName, v_AccountType, v_Balance;

        -- Exit the loop when no more rows are fetched
        EXIT WHEN account_cursor%NOTFOUND;

        -- Display fetched data (use DBMS_OUTPUT for displaying in SQL*Plus or similar tools)
        DBMS_OUTPUT.PUT_LINE('AccountID: ' || v_AccountID || 
                             ', Name: ' || v_AccountHolderName || 
                             ', Type: ' || v_AccountType || 
                             ', Balance: ' || v_Balance);
    END LOOP;

    -- Close the cursor
    CLOSE account_cursor;
END;
/


SET SERVEROUTPUT ON;



