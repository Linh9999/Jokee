package com.example.jokeesingle.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.sax.Element;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jokeesingle.R;
import com.example.jokeesingle.database.ItemDatabase;
import com.example.jokeesingle.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {
    private TextView textMain,btnLike,btnDislike;
    private List<Item> elementList = new ArrayList<>();
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        btnDislike= findViewById(R.id.btnDislike);
        textMain= findViewById(R.id.textMain);
        btnLike= findViewById(R.id.btnLike);
        elementList=ItemDatabase.getInstance(getApplicationContext()).itemDAO().list();
        for (i=0; i<elementList.size();i++){
            Item element = elementList.get(i);
            textMain.setText(element.getStrJoke());
            btnLike.setOnClickListener(v->{
                ItemDatabase.getInstance(getApplicationContext())
                        .itemDAO()
                        .updateData("like",i);
                Toast.makeText(this, "That is funny !", Toast.LENGTH_SHORT).show();
            });

            btnDislike.setOnClickListener(v->{
                ItemDatabase.getInstance(getApplicationContext())
                        .itemDAO()
                        .updateData("dislike",i);
                Toast.makeText(this, "That is not funny !", Toast.LENGTH_SHORT).show();
            });
        }





    }
}