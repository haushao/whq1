package com.example.wlw.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList=new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter=new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Fruit fruit=(Fruit) adapterView.getItemAtPosition(i);
                String title=fruit.getTitle();
                Toast.makeText(MainActivity.this,title,Toast.LENGTH_LONG).show();
            }
        });
    }
    private void initFruits(){
        Fruit fruit;
        fruit=new Fruit(R.drawable.apple_pic,"苹果","这是一只苹果");
        fruitList.add(fruit);
        fruit=new Fruit(R.drawable.orange_pic,"橙子","这是一只橙子");
        fruitList.add(fruit);
        fruit=new Fruit(R.drawable.banana_pic,"香蕉","这是一只香蕉");
        fruitList.add(fruit);

    }
}
