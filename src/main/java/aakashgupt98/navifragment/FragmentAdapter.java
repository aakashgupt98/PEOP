package aakashgupt98.navifragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by abhisharma on 22-11-2016.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    CharSequence[]name;
    int tab;


    public FragmentAdapter(FragmentManager fm, CharSequence[] mname, int mtab) {

        super(fm);
        this.name=mname;
        this.tab=mtab;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
        {
            CallFragment callFragment=new CallFragment();
            return callFragment;
        }
        else if(position==1)
        {
            ChatFragment chatFragment=new ChatFragment();
            return chatFragment;

        }
        else {
            ContactFragment contactFragment=new ContactFragment();
            return contactFragment;
        }

    }

    @Override
    public int getCount() {
        return tab;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return name[position];
    }
}
