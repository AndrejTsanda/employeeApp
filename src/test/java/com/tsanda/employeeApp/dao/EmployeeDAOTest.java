package com.tsanda.employeeApp.dao;

import com.tsanda.employeeApp.domain.Employee;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@ContextConfiguration(locations = "classpath:spring-config/applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDAOTest {

    private static final Logger log = Logger.getLogger(EmployeeDAOTest.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    private Employee employee = null;
    private Integer count = null;

    @Test
    @Transactional
    @Rollback(true)
    public void getByIdTest() {
        log.info(">> Test 1: testing method for get employee by id from database >");

        Employee employeeTest = null;

        Assert.assertNotNull(employeeDAO);
        Assert.assertNull(employee);

        employeeTest = new Employee();
        employeeTest.setId(2);
        employeeTest.setFirst_name("Mariya");
        employeeTest.setLast_name("Nesterova");
        employeeTest.setDepartment_id(2);
        employeeTest.setGender("Female");
        employeeTest.setJob_title("Accountant");
        employeeTest.setDate_of_birth(Date.valueOf("1997-04-14"));

        Assert.assertNotNull(employeeTest);

        employee = employeeDAO.getById(2);
        Assert.assertNotNull(employee);
        String employeeTestString = employeeTest.toString();
        String employeeString = employee.toString();
        Assert.assertEquals(employeeString, employeeTestString);

        log.debug("Employee from database: " + employee.toString());
        log.debug("<< Test is OK!");
    }

    @Test
    @Transactional
    @Rollback(true)
    public void getAllTest() {
        log.info(">> Test 2: testing method for get all employees from database >");

        List<Employee> employeeList = null;

        Assert.assertNotNull(employeeDAO);
        Assert.assertNull(employeeList);

        employeeList = employeeDAO.getAll();

        Assert.assertNotNull(employeeList);
        Assert.assertTrue(employeeList.size() == 2);

        log.debug("Size list with employee: " + employeeList.size());
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

        log.debug("<< Test is OK!");
    }
    @Test
    @Transactional
    @Rollback(true)
    public void saveTest() {
        log.info(">> Test 3: testing method for save new employee in database >");

        Employee employee = new Employee();

        Assert.assertNull(count);
        Assert.assertNotNull(employeeDAO);

        employee.setFirst_name("Andrej");
        employee.setLast_name("Tsanda");

        List<Employee> employeeList = employeeDAO.getAll();
        count = employeeList.size();
        Assert.assertNotNull(employee);
        Assert.assertNotNull(count);
        Assert.assertTrue(count > 0);
        Assert.assertTrue(count == 2);

        log.debug("Number employee before save: " + count);

        employeeDAO.save(employee);

        employeeList = employeeDAO.getAll();
        count = employeeList.size();
        Assert.assertTrue(count > 0);
        Assert.assertTrue(count == 3);
        Assert.assertEquals(employee.getFirst_name(), employeeList.get(2).getFirst_name());

        log.debug("Number employee after save: " + count);
        log.debug("<< Test is OK!");
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteTest() {
        log.info(">> Test 4: testing method for delete by id from database >");

        List<Employee> employeeList = null;

        Assert.assertNotNull(employeeDAO);
        Assert.assertNull(employee);
        Assert.assertNull(employeeList);
        Assert.assertNull(count);

        employeeList = employeeDAO.getAll();
        count = employeeList.size();

        Assert.assertTrue(count > 0);
        Assert.assertTrue(count == 2);

        log.debug("Number employee before delete: " + count);

        employeeDAO.delete(2);

        employeeList = employeeDAO.getAll();
        count = employeeList.size();

        Assert.assertTrue(count > 0);
        Assert.assertTrue(count == 1);

        log.debug("Number employee after delete: " + count);
        log.debug("<< Test is OK!");
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateTest() {
        log.info(">> Test 5: testing method for update employee >");

        Assert.assertNotNull(employeeDAO);
        Assert.assertNull(employee)
        ;
        Employee employee = new Employee();

        employee.setFirst_name("Andrej");
        employee.setLast_name("Tsanda");
        List<Employee> employeeList = employeeDAO.getAll();

        Assert.assertNotNull(employee);
        Assert.assertNotEquals(employee.getFirst_name(), employeeList.get(1).getFirst_name());

        employeeDAO.update(employee, 2);

        employeeList = employeeDAO.getAll();

        Assert.assertEquals(employee.getFirst_name(), employeeList.get(1).getFirst_name());

        log.debug("<< Test is OK!");
    }

}
