package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Program {


    static void main() {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1 : seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2 : seller findByDepartmentId ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartmentId(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3 : seller findAll ===");
         list = sellerDao.findAll();
         for (Seller obj : list) {
             System.out.println(obj);
         }

        System.out.println("\n=== TEST 4 : seller insert ===");
        Seller newSeller = new Seller(4000.00, LocalDate.now(), department, "greg@gmail.com", null, "Greg");
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 4 : seller insert ===");
        seller = sellerDao.findById(1);
        System.out.println(seller);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");
    }

}
