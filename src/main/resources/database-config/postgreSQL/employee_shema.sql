
CREATE SCHEMA IF NOT EXISTS employeedb AUTHORIZATON root;

CREATE TABLE IF NOT EXISTS employeedb.employee
(
    employee_id SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    department_id INTEGER,
    job_title VARCHAR(64),
    gender INT,
    date_of_birth DATE
);