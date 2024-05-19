# Composite

## Description

Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly. This pattern is particularly useful when you need to implement a tree-like structure.

## Java Code Example

```java
import java.util.ArrayList;
import java.util.List;

interface Employee {
    void showEmployeeDetails();
}

class Developer implements Employee {
    private String name;
    private long empId;
    private String position;
    
    public Developer(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }
    
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name);
    }
}

class Manager implements Employee {
    private String name;
    private long empId;
    private String position;
    private List<Employee> employees = new ArrayList<>();
    
    public Manager(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }
    
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
    
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name);
        for (Employee emp : employees) {
            emp.showEmployeeDetails();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Developer dev1 = new Developer(100, "John Doe", "Developer");
        Developer dev2 = new Developer(101, "Jane Doe", "Developer");
        Manager manager = new Manager(200, "Mike", "Manager");
        manager.addEmployee(dev1);
        manager.addEmployee(dev2);
        manager.showEmployeeDetails();
    }
}
```
