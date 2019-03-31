package aakashgupt98.navifragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MajorminorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majorminor);
    }

    public void major(View v)
    {
        startActivity(new Intent(MajorminorActivity.this,AIActivity.class));
    }

    public void minor(View v)
    {
        startActivity(new Intent(MajorminorActivity.this,AIActivity.class));
    }
}
