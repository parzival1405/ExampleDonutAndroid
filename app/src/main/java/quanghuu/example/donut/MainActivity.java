package quanghuu.example.donut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import quanghuu.example.donut.adapter.DonutAdapter;
import quanghuu.example.donut.model.Donut;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DonutAdapter.RecyclerViewClickListener recyclerViewClickListener;
    ArrayList<Donut> listDonut;
    TextInputEditText edt_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        addAction();
        listDonut.add(new Donut(R.drawable.donut_yellow_1,"Tasty Donut","Spicy tasty donut family",10.00));
        listDonut.add(new Donut(R.drawable.tasty_donut_1,"Pink Donut","Spicy tasty donut family",10.00));
        listDonut.add(new Donut(R.drawable.green_donut_1,"Floating Donut","Spicy tasty donut family",10.00));
        listDonut.add(new Donut(R.drawable.donut_red_1,"Tasty Donut","Spicy tasty donut family",10.00));

        setAdapter(listDonut);
    }

    private void mapping(){
        listDonut = new ArrayList<>();
        edt_search = findViewById(R.id.edt_search);
    }

    private void setAdapter(ArrayList<Donut> list){
        setOnClickListener();

        DonutAdapter donutAdapter = new DonutAdapter(getApplicationContext(),list,recyclerViewClickListener);
        recyclerView = findViewById(R.id.recylerView);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(donutAdapter);
    }

    private void setOnClickListener() {
        recyclerViewClickListener = new DonutAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(),secondActivity.class);
                intent.putExtra("cake",listDonut.get(position));
                startActivity(intent);
            }
        };
    }

    private void addAction(){
        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() != 0){
                    ArrayList<Donut> list = new ArrayList<>();
                    String textSearch = edt_search.getText().toString();
                    for (Donut donut: listDonut) {
                        String title = donut.getTitle();
                        if(title.contains(textSearch) == true){
                            list.add(donut);
                        }
                    }
                    setAdapter(list);
                }else{
                    setAdapter(listDonut);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}