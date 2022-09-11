package com.example.retrofit_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retrofit_api.Models.Hero;
import com.example.retrofit_api.Models.ListViewAdapter;
import com.example.retrofit_api.Models.RecyViewAdapter;
import com.example.retrofit_api.Models.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter listViewAdapter;
    RecyViewAdapter recyViewAdapter;
    RecyclerView listViewHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // listView = findViewById(R.id.listViewHeroes);
        listViewHeroes=findViewById(R.id.listViewHeroes);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);
        //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        listViewHeroes.setLayoutManager(layoutManager);


        //calling the method to display the heroes
        getHeroes();


    }


    private void getHeroes() {
        Call<List<Hero>> call = RetrofitClient.getInstance().getMyApi().getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroList = response.body();

                //Creating an String array for the ListView
                String[] heroes = new String[heroList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getName();
                    Log.e("aaa",heroList.get(i).getName());
                }
                recyViewAdapter = new RecyViewAdapter(getApplicationContext(),heroList);
                listViewHeroes.setAdapter(recyViewAdapter);

                //displaying the string array into listview
               // listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));
             //   listView.setAdapter(new ListViewAdapter(getApplicationContext(),heroList));
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}