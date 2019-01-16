package com.tsanda.employeeApp.controller;

import com.tsanda.employeeApp.domain.Employee;
import com.tsanda.employeeApp.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private static final Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployees() {
        try {
            return this.employeeService.getAll();
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    @ResponseBody
    public void saveEmployee(@RequestBody Employee employee) {
        try {
            this.employeeService.saveEmployee(employee);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteEmployee(@RequestBody Integer id) {
        try {
            this.employeeService.deleteEmployee(id);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    @ResponseBody
    public void updateEmployee(@RequestBody Employee employee) {
        try {
            this.employeeService.updateEmployee(employee);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
        try {
            return this.employeeService.getEmployeeById(id);
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }
}
