package com.tsanda.employeeApp.service;

import com.tsanda.employeeApp.dao.EmployeeDAO;
import com.tsanda.employeeApp.domain.Employee;
import com.tsanda.employeeApp.exception.NullDomainException;
import com.tsanda.employeeApp.exception.NullKeyException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    private static final Logger log = Logger.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    public void saveEmployee(Employee employee) {
        if (employee == null) {
            throw new NullDomainException("New employee for adding into database is NULL!");
        }

        try {
            employeeDAO.save(employee);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Transactional
    public void deleteEmployee(Integer id) {
        if (id == null) {
            throw new NullKeyException("Identificator for deleting employee from database is NULL!");
        }

        try {
            employeeDAO.delete(id);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        if (employee == null) {
            throw new NullDomainException("Custom employee for updating info into database is NULL!");
        }

        try {
            employeeDAO.update(employee);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Transactional
    public Employee getEmployeeById(Integer id) {
        if (id == null) {
            throw new NullKeyException("Identificator for getting employee from database is NULL!");
        }

        try {
            return employeeDAO.getById(id);
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    @Transactional
    public List<Employee> getAll() {
        try {
            return this.employeeDAO.getAll();
        } catch (Exception e) {
            log.error(e);
            return Collections.<Employee>emptyList();
        }
    }
}
