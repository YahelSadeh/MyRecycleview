package com.example.myrrrr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickInterface {

    Adapter adapter;
    public ArrayList<DataModel> dataModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.resView);
        SearchView searchView = findViewById(R.id.searchBar);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        setDataModels();

        adapter = new Adapter(this, dataModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filteredList(newText);
                return true;
            }
        });

        adapter = new Adapter(this, dataModels);
        recyclerView.setAdapter(adapter);
    }
    public void clickOnCharacter(View view){
        String name;

        Toast.makeText(this,"No Data found", Toast.LENGTH_SHORT).show();
    }
    private void filteredList(String text) {
        List<DataModel> filteredList= new ArrayList<>();
        for( DataModel item: dataModels ){
            if (item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(this,"No Data found", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filteredList);
        }
    }
    private void setDataModels(){
        for (int i = 0;i < MyData.drawableArray.length; i++) {
            dataModels.add(new DataModel(MyData.nameArray[i], MyData.description[i], MyData.drawableArray[i]));
        }
    }
    @Override
    public void onItemClick(int position) {
        String name= dataModels.get(position).getName();
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();
    }
}