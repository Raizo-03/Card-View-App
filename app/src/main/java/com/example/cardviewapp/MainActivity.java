package com.example.cardviewapp;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    //1 - AdapterView : Recycler View
    private RecyclerView recyclerView;

    //2- DataSource - List
    private List<Sport> sportList;

    //3- Adapter
    private MyCustomAdapter adapter = new MyCustomAdapter(sportList);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView title = findViewById(R.id.textHeader);
        ImageView header = findViewById(R.id.imageHeader);
        recyclerView = findViewById(R.id.recyclerview);


        sportList = new ArrayList<>();


        Sport s1 = new Sport(R.drawable.basketball, "Basketball", "Learn Basketball");
        Sport s2 = new Sport(R.drawable.soccer, "Soccer", "Learn Soccer");
        Sport s3 = new Sport(R.drawable.volleyball, "Volleyball", "Learn Volleyball");
        Sport s4 = new Sport(R.drawable.tennis, "Tennis", "Learn Tennis");
        Sport s5 = new Sport(R.drawable.pingpong, "PingPong", "Learn PingPong");

        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);

        adapter.setClickListener(this);

        adapter = new MyCustomAdapter(sportList);

        //Vertical
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //Horizontal
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(
                this,
                "You Chose " + sportList.get(position).getSportTitle(),
                Toast.LENGTH_SHORT).show();
    }
}