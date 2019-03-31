package aakashgupt98.navifragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void login(View v)
    {
     startActivity(new Intent(MainActivity1.this,login.class));
    }


    public void sign(View v)
    {
        startActivity(new Intent(MainActivity1.this,signup.class));
    }

}
