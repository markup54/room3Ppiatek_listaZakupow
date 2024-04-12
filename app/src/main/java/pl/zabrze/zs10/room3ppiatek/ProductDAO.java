package pl.zabrze.zs10.room3ppiatek;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {

    @Insert
    public  void insertProduct(Product product);

    @Delete
    public void deleteProduct(Product product);

    @Update
    public void updateProduct(Product product);

    @Query("Select * from products")
    public List<Product> getAllProduct();

}
