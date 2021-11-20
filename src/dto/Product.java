package dto;

public class Product {

    String productID;
    String productName;
    String unit;
    float price;
    int quantity;
    String categoryid;

    public Product(String productID, String productName, String unit, float price, int quantity, String categoryid) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.categoryid = categoryid;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }
}
