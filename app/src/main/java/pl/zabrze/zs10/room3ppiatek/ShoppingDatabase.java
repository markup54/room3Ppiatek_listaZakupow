package pl.zabrze.zs10.room3ppiatek;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class} , version = 1)
public abstract class ShoppingDatabase extends RoomDatabase {
    abstract ProductDAO getProductDAO();
}
