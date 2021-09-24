package com.example.db_spring_data_mvc_project.dto;

public class ExportedEmployeeDto {

    private String firstName;
    private String lastName;
    private String projectName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + this.getFirstName() + this.getLastName() + "\n" +
                "\tAge: " + this.getAge() + "\n" +
                "\tProject name: " + this.getProjectName();
    }
}
