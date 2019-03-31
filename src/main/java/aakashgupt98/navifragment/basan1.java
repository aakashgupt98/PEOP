/*package aakashgupt98.navifragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class basan1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
*/
package aakashgupt98.navifragment;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class basan1 extends AppCompatActivity {

    ViewPager pager;
    FragmentAdapter adapter;
    CharSequence name[]={"Topic1","Topic2","Topic3","Topic4","Topic5","Topic6","Topic7"};
    int tab=7;
    SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);

        slidingTabLayout=(SlidingTabLayout)findViewById(R.id.tabs);
        pager=(ViewPager)findViewById(R.id.pager);

        adapter= new FragmentAdapter(getSupportFragmentManager(),name,tab);
        pager.setAdapter(adapter);

        slidingTabLayout.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorPrimary);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        slidingTabLayout.setViewPager(pager);
    }
    public void title(View v)
    {
        startActivity(new Intent(basan1.this,InfofacultyActivity.class));
    }





}
