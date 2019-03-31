package aakashgupt98.navifragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Project_list extends AppCompatActivity {
    RecyclerView recyclerView;
    Project_list_Adapter adapter;
    List<Project_list_Feeds> feedsList = new ArrayList<Project_list_Feeds>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);


        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_news);
        adapter = new Project_list_Adapter(feedsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);



    }
}
