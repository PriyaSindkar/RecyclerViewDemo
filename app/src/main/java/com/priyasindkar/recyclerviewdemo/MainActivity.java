package com.priyasindkar.recyclerviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Objects;

import adapter.MyRecyvlerViewAdapter;
import model.DataObject;


public class MainActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private MyRecyvlerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";

    private  ArrayList<DataObject> list = new ArrayList<>();
    Button btn, btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(0);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        list =  getDataSet();

        mAdapter = new MyRecyvlerViewAdapter(this,list);
        mAdapter.setType(0);
        mRecyclerView.setAdapter(mAdapter);
      /*  RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);*/

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);


        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("CLICK", "click");
                addV1ToList();
            }
        });

        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("CLICK", "click");
                addV2ToList();
            }
        });

        btn2 = (Button) findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("CLICK3", "click3");
                addV3ToList();
            }
        });


    }

    /*@Override
    protected void onResume() {
        super.onResume();
        ((MyRecyvlerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyvlerViewAdapter.MyClickListener() {
                  @Override
                  public void onItemClick(int position, View v) {
                      Log.i(LOG_TAG, " Clicked on Item " + position);
                  }
              });
    }*/

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 3; index++) {
            DataObject obj = new DataObject("Primary Text " + index, "Secondary " + index, 0);
            results.add(index, obj);
        }
        return results;
    }

    private void addV1ToList() {
        mAdapter.add(list.size(), new DataObject("Primary Text " + list.size(), "Secondary " + list.size(), 0));
        mAdapter.setType(0);
       // mAdapter.add(list.size(), );
    }

    private void addV2ToList() {
        mAdapter.add(list.size(), new DataObject("Primary Text " + list.size(), "Secondary " + list.size(), 1));
        //mAdapter.add(list.size(),"Priya" + list.size());
        mAdapter.setType(1);
        // mAdapter.add(list.size(), );
    }

    private void addV3ToList() {
        mAdapter.add(list.size(), new DataObject("Some Primary Text " + list.size(), "Secondary " + list.size(), 2));
        //mAdapter.add(list.size(),"Priya" + list.size());
        mAdapter.setType(2);
        // mAdapter.add(list.size(), );
    }
}
