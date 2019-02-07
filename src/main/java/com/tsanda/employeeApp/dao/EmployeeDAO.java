package com.tsanda.employeeApp.dao;

import com.tsanda.employeeApp.domain.Employee;
import com.tsanda.employeeApp.exception.DatabaseException;
import com.tsanda.employeeApp.exception.ErrorQueryException;
import com.tsanda.employeeApp.exception.NullDomainException;
import com.tsanda.employeeApp.exception.NullKeyException;
import com.tsanda.employeeApp.util.QueryManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeDAO implements DAO<Employee, Integer> {

    private static final Logger log = Logger.getLogger(EmployeeDAO.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryManager queryManager;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(final Employee employee) throws DatabaseException {
        if (employee == null) {
            throw new NullDomainException("Employee domain is null!");
        }
        try {
            this.jdbcTemplate.update(queryManager.getQuery("employee.save"), new Object[]{
                    employee.getFirst_name(),
                    employee.getLast_name(),
                    employee.getDepartment_id(),
                    employee.getJob_title(),
                    employee.getGender(),
                    employee.getDate_of_birth()
            });
        } catch (Exception e) {
            log.error(e);
            throw new ErrorQueryException("Failed to execute the request for adding new employee into database!");
        }
    }

    @Override
    public void delete(final Integer id) throws DatabaseException {
        if (id == null) {
            throw new NullKeyException("Id for delete employee from database is NULL!");
        }

        try {
            this.jdbcTemplate.update(queryManager.getQuery("employee.delete.id"), id);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorQueryException("Failed to execute the request on delete employee from database!");
        }
    }

    @Override
    public void update(final Employee employee, final Integer id) throws DatabaseException {
        if (employee == null) {
            throw new NullDomainException("Employee domain is null!");
        }

        try {
            this.jdbcTemplate.update(queryManager.getQuery("employee.update.id"), new Object[]{
                    employee.getFirst_name(),
                    employee.getLast_name(),
                    employee.getDepartment_id(),
                    employee.getJob_title(),
                    employee.getGender(),
                    employee.getDate_of_birth(),
                    id
            });
        } catch (Exception e) {
            log.error(e);
            throw new ErrorQueryException("Failed to execute the request for update employee into database!");
        }
    }

    @Override
    public Employee getById(final Integer id) throws DatabaseException {
        if (id == null) {
            throw new NullKeyException("Id for getting employee from database is null!");
        }

        Employee employee;
        try {
            employee = this.jdbcTemplate.queryForObject(queryManager.getQuery("employee.get.id"), new Object[] {id}, new BeanPropertyRowMapper<Employee>(Employee.class));
            return employee;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public List<Employee> getAll() throws DatabaseException {
        try{
            return this.jdbcTemplate.query(queryManager.getQuery("employee.getAll"), new BeanPropertyRowMapper<Employee>(Employee.class));
        } catch (Exception e) {
            log.error("Failed to execute the request for getting all employee from database!");
            return Collections.<Employee>emptyList();
        }
    }
}
