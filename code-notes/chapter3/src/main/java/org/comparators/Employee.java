package org.comparators;

public class Employee {
  private final double salary;
  private final String department;

  public Employee(final double theSalary, final String theDepartment) {
    salary = theSalary;
    department = theDepartment;
  }

  public double getSalary() {
    return salary;
  }

  public String getDepartment() {
    return department;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "salary=" + salary +
        ", department='" + department + '\'' +
        '}';
  }
}
