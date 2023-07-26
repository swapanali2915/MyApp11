package com.sveri.myapp11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class GroceryActivity extends AppCompatActivity {

    ListView lvGrocery;
    String[]Grocery={
            "Basmati Rice","Brocooli","Potatoes","Peanut Butter","Jam","Soap","Apple","Cherry","Suger","Cheese"
    };
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        lvGrocery=findViewById(R.id.ListGrocery);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Grocery);
        lvGrocery.setAdapter(adapter);

        registerForContextMenu(lvGrocery);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select an action");
        menu.add(0,v.getId(),0,"Order");
        menu.add(0,v.getId(),0,"Order Cancel");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.ListGrocery){

            Toast.makeText(this, " You Selected "+item.getTitle(),Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}