package com.example.jokeesingle.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jokeesingle.R;
import com.example.jokeesingle.adapter.JokeAdapter;
import com.example.jokeesingle.animation.DepthTransformer;
import com.example.jokeesingle.database.ItemDatabase;
import com.example.jokeesingle.model.Item;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    public Toolbar toolbar;
    public CircleImageView imgAvatar;
    public ViewPager2 viewPager;
    View view;
    private JokeAdapter jokeAdapter;
    private List<Item> elementList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        elementList= new ArrayList<>();
//        addList();
        getList();
        eventClickLike();
        DepthTransformer depthTransformer = new DepthTransformer();
        viewPager.setPageTransformer(depthTransformer);
        jokeAdapter.setData(elementList);
        viewPager.setAdapter(jokeAdapter);
        setSupportActionBar(toolbar);
    }
    public void addList(){
        Item element1 = new Item("Joke 4","A housewife, an accountant and a lawyer were asked \"How much is 2+2?\" The housewife replies: \"Four!\". The accountant says: \"I think it's either 3 or 4. Let me run those figures through my spreadsheet one more time.\" The lawyer pulls the drapes, dims the lights and asks in a hushed voice, \"How much do you want it to be?\"",
                null
                );

        ItemDatabase.getInstance(getApplicationContext())
                .itemDAO()
                .insertData(element1);
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
    }
    public void getList(){
        elementList=ItemDatabase.getInstance(getApplicationContext())
                .itemDAO().list();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);

        MenuItem menuItem = menu.findItem(R.id.viewTwo);
        view = MenuItemCompat.getActionView(menuItem);
        imgAvatar = view.findViewById(R.id.image);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.viewOne:
                Toast.makeText(this, "menu One", Toast.LENGTH_SHORT).show();
                break;
            case R.id.viewTwo:
                Toast.makeText(this, "menu Two", Toast.LENGTH_SHORT).show();
                break;
            case R.id.viewThree:
                Toast.makeText(this, "menu Three", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void eventClickLike(){
        String isLike ="like";
        String isDislike ="dislike";
        jokeAdapter = new JokeAdapter(elementList, new JokeAdapter.isActive() {
            @Override
            public void clickLike(int position) {
                Log.e("TAG", "clickLike: "+position );
                ItemDatabase.getInstance(getApplicationContext())
                        .itemDAO()
                        .updateData("like",position);
                getList();

            }

            @Override
            public void clickDisLike(int position) {
                Log.e("TAG", "clickLike: "+position );
                ItemDatabase.getInstance(getApplicationContext())
                        .itemDAO()
                        .updateData("dislike",position);
                getList();
            }
        });


    }
}