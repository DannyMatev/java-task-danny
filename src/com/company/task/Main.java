package com.company.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Product> productArrayList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String choice = "";

        productArrayList.addAll(ReadCSV("/java-task/files/bread_stock.csv"));
        productArrayList.addAll(ReadCSV("/java-task/files/cheese_stock.csv"));
        productArrayList.addAll(ReadCSV("/java-task/files/tomato_stock.csv"));

        sortProducts(0, productArrayList.size()-1,productArrayList);

        do {
            System.out.println("Menu: " +
                    "\n 1. Print the three most expensive products" +
                    "\n 2. Print total number of products" +
                    "\n 3. Print every bread with corn" +
                    "\n 0. EXIT");

            choice = s.next();
            switch (choice) {
                case "1":
                    for(int i=0;i<3;i++) {
                        printProduct(productArrayList.get(i));
                    }
                    break;
                case "2":
                    System.out.println("Total products: "+ productArrayList.size());
                    break;
                case "3":
                    findEach(productArrayList, "Bread", "Corn");
                    break;
                case "0":
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Your choice is invalid");
                    break;
            }
        } while (!choice.equals("0"));
    }

    //Find all products by the given criteria
    private static void findEach(ArrayList<Product> products, String type, String origin) {
        for (Product product:products) {
            if(product.getType().equals(type) && product.getOrigin().equals(origin)) {
                printProduct(product);
            }
        }
    }

    //Print a product in a readable format
    private static void printProduct(Product product) {
        System.out.println("Serial number: "+ product.getSerialNumber()+" Type: "+product.getType()
                +" Quality: "+product.getQuality()+" Origin: "+product.getOrigin()+" Price: "+product.getPrice());
    }

    private static void sortProducts(int lowerIndex, int higherIndex, ArrayList<Product> array) {

        int i = lowerIndex;
        int j = higherIndex;
        Product pivot = array.get(lowerIndex + (higherIndex - lowerIndex) / 2);

        while (i <= j) {
            while (array.get(i).getPrice() > pivot.getPrice()) {
                i++;
            }
            while (array.get(j).getPrice() < pivot.getPrice()) {
                j--;
            }
            if (i <= j) {
                Product temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }
        if (lowerIndex < j) {
            sortProducts(lowerIndex, j, array);
        }
        if (i < higherIndex) {
            sortProducts(i, higherIndex, array);
        }

    }

    //Return an ArrayList with the csv contents
    private static ArrayList<Product> ReadCSV(String csvFile) {
        ArrayList<Product> productList = new ArrayList<>();
        String line = "";
        String cvsSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean first = true;
            while ((line = br.readLine()) != null) {
                Product product = new Product();
                String[] stockStr = line.split(cvsSeparator);
                if (first != true) {
                    product.setSerialNumber(stockStr[0]);
                    product.setType(stockStr[1]);
                    product.setQuality(stockStr[2]);
                    product.setOrigin(stockStr[3]);
                    product.calculatePrice();
                    productList.add(product);
                } else {
                    first = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}

