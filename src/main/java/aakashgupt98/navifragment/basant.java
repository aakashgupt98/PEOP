package aakashgupt98.navifragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class basant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

    }

    public void Artificial(View v)
    {
        startActivity(new Intent(basant.this,basan1.class));
    }


}


