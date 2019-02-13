package com.tsanda.employeeApp.controller;

import com.tsanda.employeeApp.domain.Employee;
import com.tsanda.employeeApp.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "EmployeeController", description = "REST APIs related to Employee Entity.")
@RestController
public class EmployeeController {

    private static final Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Get all Employees.")
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        try {
            return this.employeeService.getAll();
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    @ApiOperation(value = "Save the Employee.")
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public void saveEmployee(@RequestBody Employee employee) {
        try {
            this.employeeService.saveEmployee(employee);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @ApiOperation(value = "Delete Employee by ID.")
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("id") String id) {
        try {
            this.employeeService.deleteEmployee(Integer.parseInt(id));
        } catch (Exception e) {
            log.error(e);
        }
    }

    @ApiOperation(value = "Update Employee by ID.")
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee employee, @PathVariable("id") String id) {
        try {
            this.employeeService.updateEmployee(employee, Integer.parseInt(id));
        } catch (Exception e) {
            log.error(e);
        }
    }

    @ApiOperation(value = "Get Employee by ID.")
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") String id) {
        try {
            return this.employeeService.getEmployeeById(Integer.parseInt(id));
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }
}
