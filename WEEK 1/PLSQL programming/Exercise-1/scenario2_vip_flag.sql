-- ============================================================
--  Exercise 1 - Scenario 2
--  Promote customers with balance > $10,000 to VIP status
-- ============================================================

-- IsVIP is stored as VARCHAR2(5) ('TRUE'/'FALSE') since standard
-- Oracle SQL does not have a native BOOLEAN column type.
-- The block iterates over all customers and sets the flag accordingly.

DECLARE
    v_status VARCHAR2(5);
BEGIN
    FOR cust IN (SELECT CustomerID, Name, Balance FROM Customers) LOOP

        IF cust.Balance > 10000 THEN
            v_status := 'TRUE';
        ELSE
            v_status := 'FALSE';
        END IF;

        UPDATE Customers
        SET    IsVIP        = v_status,
               LastModified = SYSDATE
        WHERE  CustomerID   = cust.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            cust.Name ||
            ' | Balance: $' || cust.Balance ||
            ' | IsVIP: '    || v_status
        );

    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('--- Scenario 2 complete ---');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
