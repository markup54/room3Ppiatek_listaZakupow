package pl.zabrze.zs10.room3ppiatek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ShoppingDatabase database;
    Button button;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextTextPersonName);
        listView = findViewById(R.id.listView);
        RoomDatabase.Callback callback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };
        database = Room.databaseBuilder(getApplicationContext(),
                ShoppingDatabase.class,
                "Shopping_database").addCallback(callback).build();

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String productName = editText.getText().toString();
                        Product product = new Product(productName,10);
                        insertNewProductToDabaseInBackGround(product);
                    }
                }
        );
    }
        private void  insertNewProductToDabaseInBackGround(Product product){
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executorService.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            database.getProductDAO().insertProduct(product);
                            handler.post(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(MainActivity.this,
                                                    "Dodano do bazy",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                            );
                        }
                    }
            );

        }
}