package com.unicornunicode.stephenkairos.ymcavolunteer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;

public class TabbedActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position <= 0) {
                return HoursFragment.newInstance();
            } else if(position == 1) {
                return VolunteerFragment.newInstance();
            } else {
                return AboutFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Hours Log";
                case 1:
                    return "Volunteer";
                case 2:
                    return "About Us";
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class HoursFragment extends Fragment {

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static HoursFragment newInstance() {
            HoursFragment fragment = new HoursFragment();
            return fragment;
        }

        public HoursFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);

            ParseUser user = ParseUser.getCurrentUser();
            ArrayList<ParseObject> activityList = new ArrayList<ParseObject>();
            if (user != null){
                if( user.get("activitiesLog") != null) {
                    activityList = (ArrayList<ParseObject>) user.get("activitiesLog");
                }
            }else{
                Toast toast = Toast.makeText(getActivity(), "failed", Toast.LENGTH_SHORT);
                toast.show();
            }

//            ParseObject myActivity = new ParseObject("Activity");
//            myActivity.put("activityName", "a");
//            ParseRelation<ParseObject> relation = user.getRelation("activityList");
//            relation.add(myActivity);

//            activityList.add(myActivity);
//            ParseObject a = new ParseObject("Activity");
//            a.put("activityName", "a");
//            activityList.add(a);
//            ParseObject b = new ParseObject("Activity");
//            b.put("activityName", "b");
//            activityList.add(b);
//            ParseObject c = new ParseObject("Activity");
//            c.put("activityName", "c");
//            activityList.add(c);
//            ParseObject d = new ParseObject("Activity");
//            d.put("activityName", "d");
//            activityList.add(d);
//
//            ParseUser.getCurrentUser().put("activitiesLog", activityList);
//
//            myActivity.saveInBackground();
//            a.saveInBackground();
//            b.saveInBackground();
//            c.saveInBackground();
//            d.saveInBackground();
//
//             user.saveInBackground();
//
//            ArrayList<String> titles = new ArrayList<String>();
//            for(ParseObject act : activityList) {
//                titles.add(act.getString("activityName"));
//            }
//
//            ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.hour_item, R.id.hour_item_textview, titles);
//            ListView lv = (ListView) rootView.findViewById(R.id.listView);
//            lv.setAdapter(mArrayAdapter);
            return rootView;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class VolunteerFragment extends Fragment {
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static VolunteerFragment newInstance() {
            VolunteerFragment fragment = new VolunteerFragment();
            return fragment;
        }

        public VolunteerFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            ArrayList<String> values = new ArrayList<String>();

            for(int i = 0; i < 10; i++) {
                values.add("test");
            }

            ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.hour_item, R.id.hour_item_textview, values);
            ListView lv = (ListView) rootView.findViewById(R.id.listView);
            lv.setAdapter(mArrayAdapter);
            return rootView;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class AboutFragment extends Fragment {

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static AboutFragment newInstance() {
            AboutFragment fragment = new AboutFragment();
            return fragment;
        }

        public AboutFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            ArrayList<String> values = new ArrayList<String>();

            values.add("");


            ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.hour_item, R.id.hour_item_textview, values);
            ListView lv = (ListView) rootView.findViewById(R.id.listView);
            lv.setAdapter(mArrayAdapter);
            return rootView;
        }
    }
}
