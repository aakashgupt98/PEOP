package aakashgupt98.navifragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InfostudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infostudent);
    }

    public void mentor(View v)
    {
        startActivity(new Intent(InfostudentActivity.this,InfofacultyActivity.class));
    }


}
