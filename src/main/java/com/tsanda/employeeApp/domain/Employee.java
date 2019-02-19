package com.tsanda.employeeApp.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of employee", name = "id")
    @Column(name = "employee_id")
    private Integer id;

    @ApiModelProperty(notes = "First name", name = "first_name", required = true)
    @Column(name = "first_name")
    private String first_name;

    @ApiModelProperty(notes = "Last name", name = "last_name", required = true)
    @Column(name = "last_name")
    private String last_name;

    @ApiModelProperty(notes = "Id of department from department's table", name = "department_id")
    @Column(name = "department_id")
    private Integer department_id;

    @ApiModelProperty(notes = "Job title", name = "job_title")
    @Column(name = "job_title")
    private String job_title;

    @ApiModelProperty(notes = "Gender", name = "gender", allowableValues = "MALE,FEMALE")
    @Column(name = "gender")
    private Gender gender;

    @ApiModelProperty(notes = "Date of birth", name = "date_of_birth")
    @Column(name = "date_of_birth")
    private Date date_of_birth;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getJob_title() {
        return job_title;
    }
    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }
    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", department_id=" + department_id +
                ", job_title='" + job_title + '\'' +
                ", gender='" + gender + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
