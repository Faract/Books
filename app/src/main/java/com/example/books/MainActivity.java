package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String, String>> books;

    SimpleAdapter adapter;

    EditText editName, editGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        editGenre = findViewById(R.id.edit_genre);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString().trim();
                String genre = editGenre.getText().toString().trim();

                if (name.isEmpty() || genre.isEmpty()) return;

                HashMap<String, String> book = new HashMap<>();
                book.put("name", name);
                book.put("genre", genre);
                books.add(book);

                adapter.notifyDataSetChanged();

                editName.getText().clear();
                editGenre.getText().clear();
            }
        });

        books = new ArrayList<>();

        HashMap<String, String> book = new HashMap<>();
        book.put("name", "Книга №1");
        book.put("genre", "ужасы");
        books.add(book);

        book = new HashMap<>();
        book.put("name", "Книга №2");
        book.put("genre", "фантастика");
        books.add(book);

        book = new HashMap<>();
        book.put("name", "Книга №3");
        book.put("genre", "сборник стихов");
        books.add(book);

        book = new HashMap<>();
        book.put("name", "Книга №4");
        book.put("genre", "рассказы");
        books.add(book);

        book = new HashMap<>();
        book.put("name", "Книга №5");
        book.put("genre", "сказки");
        books.add(book);

        String[] from = new String[2];
        from[0] = "name";
        from[1] = "genre";

        int[] to = new int[2];
        to[0] = R.id.txt_name;
        to[1] = R.id.txt_genre;

        adapter = new SimpleAdapter(this, books, R.layout.item_book, from, to);

        ListView lv = findViewById(R.id.list_books);
        lv.setAdapter(adapter);
    }
}