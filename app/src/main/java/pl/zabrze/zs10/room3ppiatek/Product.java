package pl.zabrze.zs10.room3ppiatek;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "products")
public class Product {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_product")
    int id;

    @ColumnInfo(name = "product_name")
    private String name;
    private double price;

    @ColumnInfo(name = "is_available")
    private boolean isInList;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        isInList = false;
        id=0;
    }
    @Ignore
    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInList() {
        return isInList;
    }

    public void setInList(boolean inList) {
        isInList = inList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name  +
                ", price=" + price +
                '}';
    }
}
