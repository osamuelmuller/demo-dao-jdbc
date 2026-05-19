package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {

    static void main() {

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }

        System.out.println("=== TEST 2: findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        /*
        System.out.println("=== TEST 3: insert ===");
        Department newDepartment = new Department(null, "Clothes");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());
        */

        System.out.println("=== TEST 4: update ===");
        Department department1 = departmentDao.findById(2);
        department1.setName("Phones");
        departmentDao.update(department1);
        System.out.println("Update completed");

        System.out.println("=== TEST 5: delete ===");
        System.out.print("Enter Id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Department deleted");

        sc.close();
    }

}
