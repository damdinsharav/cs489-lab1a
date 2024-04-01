package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.*;


public class ProductMgmtApp {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(3128874119L, "Banana", LocalDate.of(2023,1,24), 124, 0.55));
        products.add(new Product(2927458265L, "Apple", LocalDate.of(2022,12,9), 18, 1.09));
        products.add(new Product(9189927460L, "Carrot", LocalDate.of(2023,3,31), 89, 2.99));

        printProducts(products);
    }

    private static void printProducts(ArrayList<Product> products) {
        Collections.sort(products, Comparator.comparing(Product::getName));
        System.out.println("Printed in JSON Format");
        System.out.println("[");
        for(Product product: products) {
            System.out.println("\t{ \"productId\": " + product.getProductId() + ", \"name\":" + product.getName() + ", \"dateSupplied\":" + product.getDateSupplied() + ", \"quantityInStock\":" + product.getQuantityInStock() + ", \"unitPrice\":" + product.getUnitPrice() + "},");
        }
        System.out.println("]");
        System.out.println("----------------------------------");
        System.out.println("Printed in XML Format");
        System.out.println("<?xml version=\"1.0\"?>" +
                "\n<product>");
        for(Product product: products) {
            System.out.println("\t<product \"productId\"= " + product.getProductId() + "\"name\"=" + product.getName() + "\"dateSupplied\"=" + product.getDateSupplied() + "\"quantityInStock\"=" + product.getQuantityInStock() + "\"unitPrice\"=" + product.getUnitPrice() + "</product>");
        }
        System.out.println("</products>");
        System.out.println("----------------------------------");
        System.out.println("Printed in CSV Format");
        for(Product product: products) {
            System.out.println(product.getProductId() + "," + product.getName() + "," + product.getDateSupplied() + "," + product.getQuantityInStock() + "," + product.getUnitPrice());
        }

    }


}