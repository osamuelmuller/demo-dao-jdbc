package application;

import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;

public class Program {


    static void main() {
        Seller seller = new Seller(2000.00, LocalDate.now(), new Department(), "samuel@gmail.com", 1, "Samuel");
        System.out.println(seller);
    }

}
