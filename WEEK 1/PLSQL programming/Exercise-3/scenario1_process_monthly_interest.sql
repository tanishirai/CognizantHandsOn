-- ============================================================
--  Exercise 3 - Scenario 1
--  ProcessMonthlyInterest: apply 1% interest to all savings accounts
-- ============================================================

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    v_interest_rate CONSTANT NUMBER := 0.01;  -- 1% monthly interest
    v_count         NUMBER := 0;
BEGIN
    FOR acc IN (
        SELECT AccountID, Balance
        FROM   Accounts
        WHERE  AccountType = 'Savings'
    ) LOOP

        UPDATE Accounts
        SET    Balance      = Balance + (Balance * v_interest_rate),
               LastModified = SYSDATE
        WHERE  AccountID    = acc.AccountID;

        v_count := v_count + 1;

        DBMS_OUTPUT.PUT_LINE(
            'Account ' || acc.AccountID ||
            ' | Old Balance: ' || acc.Balance ||
            ' | New Balance: ' || (acc.Balance + (acc.Balance * v_interest_rate))
        );

    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to ' || v_count || ' savings account(s).');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in ProcessMonthlyInterest: ' || SQLERRM);
END ProcessMonthlyInterest;
/

-- ---- How to call it ----
-- SET SERVEROUTPUT ON;
-- EXEC ProcessMonthlyInterest;
