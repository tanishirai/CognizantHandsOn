-- ============================================================
--  Exercise 1 - Scenario 1
--  Apply 1% discount on loan interest rate for customers above 60
-- ============================================================

-- The block loops through every customer using a FOR loop over a cursor.
-- For each customer it calculates their age from DOB.
-- If age > 60, every loan linked to that customer gets a 1% reduction
-- in interest rate, but we make sure it never goes below 0.

DECLARE
    v_age      NUMBER;
BEGIN
    FOR cust IN (SELECT CustomerID, Name, DOB FROM Customers) LOOP

        -- Calculate age in years from date of birth
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12);

        IF v_age > 60 THEN
            -- Apply 1% discount to all loans belonging to this customer
            UPDATE Loans
            SET    InterestRate = GREATEST(InterestRate - 1, 0)
            WHERE  CustomerID = cust.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount applied for: ' || cust.Name ||
                ' (Age: ' || v_age || ')' ||
                ' | Loans updated: ' || SQL%ROWCOUNT
            );
        ELSE
            DBMS_OUTPUT.PUT_LINE(
                'No discount for: ' || cust.Name ||
                ' (Age: ' || v_age || ')'
            );
        END IF;

    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('--- Scenario 1 complete ---');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
