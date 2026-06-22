-- ============================================================
--  Exercise 3 - Scenario 3
--  TransferFunds: move money between two accounts, with balance check
-- ============================================================

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account  IN NUMBER,
    p_to_account    IN NUMBER,
    p_amount        IN NUMBER
)
IS
    v_from_balance NUMBER;
    v_account_exists NUMBER;
BEGIN
    IF p_amount <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Transfer amount must be greater than 0.');
        RETURN;
    END IF;

    -- Check that the destination account actually exists
    SELECT COUNT(*) INTO v_account_exists FROM Accounts WHERE AccountID = p_to_account;
    IF v_account_exists = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Destination account ' || p_to_account || ' does not exist.');
        RETURN;
    END IF;

    -- Lock and read the source account balance
    SELECT Balance INTO v_from_balance
    FROM   Accounts
    WHERE  AccountID = p_from_account
    FOR UPDATE;

    IF v_from_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE(
            'Transfer failed: Account ' || p_from_account ||
            ' has insufficient balance (Available: ' || v_from_balance ||
            ', Required: ' || p_amount || ').'
        );
        ROLLBACK;
        RETURN;
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET    Balance      = Balance - p_amount,
           LastModified = SYSDATE
    WHERE  AccountID    = p_from_account;

    -- Add to destination
    UPDATE Accounts
    SET    Balance      = Balance + p_amount,
           LastModified = SYSDATE
    WHERE  AccountID    = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Transfer successful: $' || p_amount ||
        ' moved from Account ' || p_from_account ||
        ' to Account ' || p_to_account || '.'
    );

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Source account ' || p_from_account || ' does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in TransferFunds: ' || SQLERRM);
END TransferFunds;
/

-- ---- How to call it ----
-- SET SERVEROUTPUT ON;
-- EXEC TransferFunds(1, 2, 300);   -- transfer $300 from Account 1 to Account 2
-- EXEC TransferFunds(1, 2, 99999); -- should fail: insufficient balance
