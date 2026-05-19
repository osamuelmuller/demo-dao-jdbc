package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class Program2 {

    static void main() {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }
    }

}
