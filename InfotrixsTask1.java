//Employee Management System


import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private String department;

    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }
}

public class InfotrixsTask1 {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.next();
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter employee department: ");
        String department = scanner.next();

        Employee employee = new Employee(name, id, department);
        employees.add(employee);

        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println("Name: " + employee.getName());
                System.out.println("ID: " + employee.getId());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("---------------------");
            }
        }
    }

    private static void updateEmployee(Scanner scanner) {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();

        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.print("Enter new employee name: ");
                String name = scanner.next();
                System.out.print("Enter new employee department: ");
                String department = scanner.next();

                employee = new Employee(name, id, department);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();

        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }
}