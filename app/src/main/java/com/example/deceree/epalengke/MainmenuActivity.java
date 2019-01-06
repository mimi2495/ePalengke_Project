package com.example.deceree.epalengke;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;

public class MainmenuActivity extends AppCompatActivity implements OnQueryTextListener {

    ListView lv;
    SearchView searchView;
    String items[] = new String[] {"Meat", "Vegetable", "Condiments", "Fruits"};
    int [] images = {R.drawable.meat, R.drawable.veggie, R.drawable.condiments, R.drawable.fruits};
    ArrayAdapter<String> adapter;
    Intent intent;
    Context self = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        lv = findViewById(R.id.idListView);
        searchView = findViewById(R.id.idSearch);
        MyAdapter adapter = new MyAdapter(this, items, images);
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        lv.setAdapter(adapter);
        searchView.setOnQueryTextListener(this);

        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(self, ProductMenuActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.getFilter().filter(newText);
        return false;
    }

    class MyAdapter extends  ArrayAdapter{
        int[] imageArray;
        String[] itemArray;
        public MyAdapter(Context context, String[] meat, int[] image1){
            super(context, R.layout.custlistview_row_mainmenu, R.id.txtTitle, meat);
            this.imageArray = image1;
            this.itemArray = meat;

        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.custlistview_row_mainmenu,parent,false);

            ImageView myImage = (ImageView) row.findViewById(R.id.imgMenu);
            TextView myItem = (TextView) row.findViewById(R.id.txtTitle);

            myImage.setImageResource(imageArray[position]);
            myItem.setText(itemArray[position]);
            return row;
        }
    }
}
