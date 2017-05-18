package com.company.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Product> productArrayList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String choice;
        String [] files= {"./files/bread_stock.csv",
                "./files/cheese_stock.csv",
                "./files/tomato_stock.csv",
                "./files/icecream.csv",
                "./files/shampoo.csv"};

        for (String file: files) {
            productArrayList.addAll(readCSV(file));
        }

        productArrayList.sort(Collections.reverseOrder());

        do {
            System.out.println("Menu: " +
                    "\n 1. Print the three most expensive products" +
                    "\n 2. Print total number of products" +
                    "\n 3. Print every bread with corn" +
                    "\n 4. Print data for all products with quality 3" +
                    "\n 5. Print data for products with serial numbers between 1000 and 2000" +
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
                    findEach(productArrayList, Constants.TYPE_BREAD, Constants.ORIGIN_CORN);
                    break;
                case "4":
                    findEach(productArrayList,"3");
                    break;
                case "5":
                    for(int i=1000;i<=2000;i++) {
                        findEach(productArrayList, i);
                    }
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

    /**
     * Find all products by the given criteria
     * @param products
     * @param type
     * @param origin
     */
    private static void findEach(List<Product> products, String type, String origin) {
        for (Product product:products) {
            if(product.getType().equals(type) && product.getOrigin().equals(origin)) {
                printProduct(product);
            }
        }
    }

    /**
     * Find all products by the given quality
     * @param products
     * @param quality
     */
    private static void findEach(List<Product> products, String quality) {
        for (Product product:products) {
            if(product.getQuality().equals(quality)) {
                printProduct(product);
            }
        }
    }

    /**
     * Find all products by the given quality
     * @param products
     * @param serialNumber
     */
    private static void findEach(List<Product> products, int serialNumber) {
        for (Product product:products) {
            if(Integer.parseInt(product.getSerialNumber())==serialNumber) {
                printProduct(product);
            }
        }
    }

    /**
     * Print a product in a readable format
     * @param product
     */
    private static void printProduct(Product product) {
        System.out.println("Serial number: "+ product.getSerialNumber()+" Type: "+product.getType()
                +" Quality: "+product.getQuality()+" Origin: "+product.getOrigin()+" Price: "+product.getPrice());
    }

    /**
     * Read csvFile
     * @param csvFile
     * @return A list with the file contents
     */
    private static List<Product> readCSV(String csvFile) {
        ArrayList<Product> productList = new ArrayList<>();
        String line;
        List<String> properties=new ArrayList<>();
        String cvsSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean first = true;
            while ((line = br.readLine()) != null) {
                Product product = new Product();
                String[] stockStr = line.split(cvsSeparator);
                if (!first) {
                    if(properties.contains(Constants.PRODUCT_SERIAL_NUMBER)) {
                        product.setSerialNumber(stockStr[properties.indexOf(Constants.PRODUCT_SERIAL_NUMBER)]);
                    }
                    if(properties.contains(Constants.PRODUCT_QUALITY)) {
                        product.setQuality(stockStr[properties.indexOf(Constants.PRODUCT_QUALITY)]);
                    }
                    if(properties.contains(Constants.PRODUCT_TYPE)) {
                        product.setType(stockStr[properties.indexOf(Constants.PRODUCT_TYPE)]);
                    } else {
                        product.setType(csvFile.substring(csvFile.lastIndexOf("/")+1, csvFile.lastIndexOf(".")));
                    }
                    product.setOrigin(stockStr[stockStr.length-1]);

                    productList.add(product);
                } else {
                    properties=new ArrayList<>(Arrays.asList(stockStr));
                    first = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}

