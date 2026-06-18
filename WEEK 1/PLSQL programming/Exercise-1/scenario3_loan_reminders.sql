-- ============================================================
--  Exercise 1 - Scenario 3
--  Send reminders for loans due within the next 30 days
-- ============================================================

-- The block uses a FOR loop over a cursor that joins Loans with Customers
-- so we can print the customer name in the reminder message.
-- Only loans whose EndDate falls between today and today+30 are fetched.

DECLARE
    v_days_left NUMBER;
BEGIN
    FOR loan_rec IN (
        SELECT l.LoanID,
               l.LoanAmount,
               l.EndDate,
               c.Name       AS CustomerName,
               c.CustomerID
        FROM   Loans     l
        JOIN   Customers c ON l.CustomerID = c.CustomerID
        WHERE  l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
        ORDER  BY l.EndDate
    ) LOOP

        v_days_left := TRUNC(loan_rec.EndDate - SYSDATE);

        DBMS_OUTPUT.PUT_LINE(
            'REMINDER >> Customer: '  || loan_rec.CustomerName  ||
            ' | Loan ID: '            || loan_rec.LoanID        ||
            ' | Amount Due: $'        || loan_rec.LoanAmount    ||
            ' | Due Date: '           || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY') ||
            ' | Days Left: '          || v_days_left
        );

    END LOOP;

    DBMS_OUTPUT.PUT_LINE('--- Scenario 3 complete ---');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
