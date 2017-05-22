package com.company.task;

abstract class Product implements Comparable<Product> {
    String serialNumber;
    String quality;
    double price;

    @Override
    public int compareTo(final Product product) {
        return Double.compare(this.getPrice(), product.getPrice());
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public double getPrice() {
        calculatePrice();
        return price;
    }

    abstract String getOrigin();

    abstract String getType();

    abstract void calculatePrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (serialNumber != null ? !serialNumber.equals(product.serialNumber) : product.serialNumber != null)
            return false;
        return quality != null ? quality.equals(product.quality) : product.quality == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = serialNumber != null ? serialNumber.hashCode() : 0;
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
