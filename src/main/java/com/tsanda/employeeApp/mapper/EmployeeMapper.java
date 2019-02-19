package com.tsanda.employeeApp.mapper;

import com.tsanda.employeeApp.domain.Employee;
import com.tsanda.employeeApp.domain.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));
        employee.setDepartment_id(resultSet.getInt("department_id"));
        employee.setJob_title(resultSet.getString("job_title"));
        employee.setGender(Gender.valueOf(resultSet.getInt("gender")));
        employee.setDate_of_birth(resultSet.getDate("date_of_birth"));

        return employee;
    }
}
