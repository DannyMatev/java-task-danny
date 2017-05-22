package com.company.task;

class Product implements Comparable<Product> {
    private String serialNumber;
    private String type;
    private String quality;
    private String origin;
    private double price;

    @Override
    public int compareTo( final Product product) {
        return Double.compare(this.getPrice(), product.getPrice());
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        calculatePrice();
        return price;
    }

    private void calculatePrice() {
        switch (type) {
            case Constants.TYPE_BREAD:
                switch (quality) {
                    case "1":
                        price = 2.00;
                        break;
                    case "2":
                        price = 1.50;
                        break;
                    case "3":
                        price = 1.00;
                        break;
                }
                break;
            case Constants.TYPE_CHEESE:
                switch (quality) {
                    case "1":
                        price = 15.00;
                        break;
                    case "2":
                        price = 12.00;
                        break;
                    case "3":
                        price = 6.00;
                        break;
                }
                break;
            case Constants.TYPE_TOMATO:
                switch (quality) {
                    case "1":
                        price = 6.00;
                        break;
                    case "2":
                        price = 4.50;
                        break;
                    case "3":
                        price = 2.00;
                        break;
                }
                break;
            case Constants.TYPE_ICECREAM:
                switch(quality) {
                    case "1":
                        price = 15.00;
                        break;
                    case "2":
                        price = 12.00;
                        break;
                    case "3":
                        price = 6.00;
                        break;
                }
                break;
            case Constants.TYPE_SHAMPOO:
                switch(quality) {
                    case "1":
                        price = 12.00;
                        break;
                    case "2":
                        price = 8.00;
                        break;
                    case "3":
                        price = 4.50;
                        break;
                }
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (serialNumber != null ? !serialNumber.equals(product.serialNumber) : product.serialNumber != null)
            return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        if (quality != null ? !quality.equals(product.quality) : product.quality != null) return false;
        return origin != null ? origin.equals(product.origin) : product.origin == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = serialNumber != null ? serialNumber.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
