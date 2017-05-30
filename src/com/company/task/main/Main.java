package com.company.task.main;

import com.company.task.products.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Product> productArrayList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String choice;
        String[] files = {"./files/bread_stock.csv",
                "./files/cheese_stock.csv",
                "./files/tomato_stock.csv",
                "./files/icecream.csv",
                "./files/shampoo.csv"};

        for (String file : files) {
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
                case "0":
                    System.out.println("EXIT");
                    break;
                case "1":
                    for (int i = 0; i < 3; i++) {
                        printProduct(productArrayList.get(i));
                    }
                    break;
                case "2":
                    System.out.println("Total products: " + productArrayList.size());
                    break;
                case "3":
                    List<Product> typeOriginList = findEachProduct(productArrayList, Bread.class, "Corn");
                    for (Product product : typeOriginList) {
                        printProduct(product);
                    }
                    break;
                case "4":
                    List<Product> qualityList = findEachProduct(productArrayList, "3");
                    for (Product product : qualityList) {
                        printProduct(product);
                    }
                    break;
                case "5":
                    List<Product> serialNumbersList = findEachProduct(productArrayList, 1000, 2000);
                    for (Product product : serialNumbersList) {
                        printProduct(product);
                    }
                    break;

                default:
                    System.out.println("Your choice is invalid");
                    break;
            }
        } while (!choice.equals("0"));
    }

    /**
     * Find all products by a given type and origin
     *
     * @param products
     * @param type
     * @param origin
     * @return an array list of all items with the given type and origin
     */
    private static List<Product> findEachProduct(List<Product> products, Class type, String origin) {
        List<Product> arrList = new ArrayList<>();
        for (Product product : products) {
            if (type.isInstance(product) && (origin.equals(product.getFlavour()) || origin.equals(product.getMilk()) ||
                    origin.equals(product.getFlour()) || origin.equals(product.getVariety()) ||
                    origin.equals(product.getSpecialization()))) {
                arrList.add(product);
            }
        }
        return arrList;
    }


    /**
     * Find all products by the given quality
     *
     * @param products
     * @param quality
     * @return an array list of all items with the given quality
     */
    private static List<Product> findEachProduct(List<Product> products, String quality) {
        List<Product> arrList = new ArrayList<>();
        for (Product product : products) {
            if (product.getQuality().equals(quality)) {
                arrList.add(product);
            }
        }
        return arrList;
    }

    /**
     * Find all products with a serial number in the given range
     *
     * @param products
     * @param min
     * @param max
     * @return an array list of all items within the given range
     */
    private static List<Product> findEachProduct(List<Product> products, int min, int max) {
        List<Product> arrList = new ArrayList<>();
        for (Product product : products) {
            if (Integer.parseInt(product.getSerialNumber()) >= min && Integer.parseInt(product.getSerialNumber()) <= max) {
                arrList.add(product);
            }
        }
        return arrList;
    }

    /**
     * Print a product in a readable format
     *
     * @param product
     */
    private static void printProduct(Product product) {
        String type = null;
        if (product instanceof Bread) {
            type = Constants.TYPE_BREAD;
        }
        if (product instanceof Shampoo) {
            type = Constants.TYPE_SHAMPOO;
        }
        if (product instanceof Tomato) {
            type = Constants.TYPE_TOMATO;
        }
        if (product instanceof Cheese) {
            type = Constants.TYPE_CHEESE;
        }
        if (product instanceof Icecream) {
            type = Constants.TYPE_ICECREAM;
        }

        System.out.println("Serial number: " + product.getSerialNumber() + " Type: " + product.getClass().getSimpleName()
                + " Quality: " + product.getQuality() + " Origin: " + type + " Price: " + product.getPrice());
    }

    /**
     * Read csvFile
     *
     * @param csvFile
     * @return A list with the file contents
     */
    private static List<Product> readCSV(String csvFile) {
        ArrayList<Product> productList = new ArrayList<>();
        String line;
        List<String> properties;
        String csvSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            line = br.readLine();
            String[] stockStr = line.split(csvSeparator);
            properties = new ArrayList<>(Arrays.asList(stockStr));

            while ((line = br.readLine()) != null) {
                Product product = null;

                stockStr = line.split(csvSeparator);

                if (properties.contains(Constants.PRODUCT_TYPE)) {
                    switch (stockStr[properties.indexOf(Constants.PRODUCT_TYPE)]) {
                        case Constants.TYPE_BREAD:
                            product = new Bread(stockStr[properties.indexOf(Constants.PRODUCT_SERIAL_NUMBER)],
                                    stockStr[properties.indexOf(Constants.PRODUCT_QUALITY)],
                                    stockStr[stockStr.length - 1]);
                            break;
                        case Constants.TYPE_CHEESE:
                            product = new Cheese(stockStr[properties.indexOf(Constants.PRODUCT_SERIAL_NUMBER)],
                                    stockStr[properties.indexOf(Constants.PRODUCT_QUALITY)],
                                    stockStr[stockStr.length - 1]);
                            break;
                        case Constants.TYPE_TOMATO:
                            product = new Tomato(stockStr[properties.indexOf(Constants.PRODUCT_SERIAL_NUMBER)],
                                    stockStr[properties.indexOf(Constants.PRODUCT_QUALITY)],
                                    stockStr[stockStr.length - 1]);
                            break;
                    }
                } else {
                    String fileName = csvFile.substring(csvFile.lastIndexOf('/') + 1, csvFile.lastIndexOf('.'));
                    switch (fileName) {
                        case Constants.TYPE_SHAMPOO:
                            product = new Shampoo(stockStr[properties.indexOf(Constants.PRODUCT_SERIAL_NUMBER)],
                                    stockStr[properties.indexOf(Constants.PRODUCT_QUALITY)],
                                    stockStr[stockStr.length - 1]);
                            break;
                        case Constants.TYPE_ICECREAM:
                            product = new Icecream(
                                    stockStr[properties.indexOf(Constants.PRODUCT_SERIAL_NUMBER)],
                                    stockStr[properties.indexOf(Constants.PRODUCT_QUALITY)],
                                    stockStr[stockStr.length - 1]);
                            break;
                    }
                }
                productList.add(product);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}

