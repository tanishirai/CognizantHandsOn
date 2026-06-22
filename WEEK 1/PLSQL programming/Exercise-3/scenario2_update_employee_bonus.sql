-- ============================================================
--  Exercise 3 - Scenario 2
--  UpdateEmployeeBonus: add a bonus % to salary, for one department
-- ============================================================

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department      IN VARCHAR2,
    p_bonus_percent   IN NUMBER
)
IS
    v_count NUMBER := 0;
BEGIN
    IF p_bonus_percent <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Bonus percentage must be greater than 0.');
        RETURN;
    END IF;

    FOR emp IN (
        SELECT EmployeeID, Name, Salary
        FROM   Employees
        WHERE  Department = p_department
    ) LOOP

        UPDATE Employees
        SET    Salary     = Salary + (Salary * p_bonus_percent / 100)
        WHERE  EmployeeID = emp.EmployeeID;

        v_count := v_count + 1;

        DBMS_OUTPUT.PUT_LINE(
            emp.Name ||
            ' | Old Salary: ' || emp.Salary ||
            ' | New Salary: ' || (emp.Salary + (emp.Salary * p_bonus_percent / 100))
        );

    END LOOP;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    ELSE
        COMMIT;
        DBMS_OUTPUT.PUT_LINE(v_count || ' employee(s) updated with ' || p_bonus_percent || '% bonus.');
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in UpdateEmployeeBonus: ' || SQLERRM);
END UpdateEmployeeBonus;
/

-- ---- How to call it ----
-- SET SERVEROUTPUT ON;
-- EXEC UpdateEmployeeBonus('IT', 10);   -- gives 10% bonus to all IT dept employees
