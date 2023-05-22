package com.example.ebass.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ebass.R;

import java.util.ArrayList;

public class Problem_RequestDetails extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private IntroManager introManager;
    private int[] layouts;
    private TextView dots[];
    private LinearLayout dotsLayout;
    private Button next, back;
    private String jobName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.problem_actionbar);

        jobName = getIntent().getStringExtra("job");


        introManager = new IntroManager(this);
        if(!introManager.check()){
            introManager.setFirst(false);
            Intent i = new Intent(Problem_RequestDetails.this,empty.class );
            startActivity(i);
            finish();
        }

        if(Build.VERSION.SDK_INT >= 21 ){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.problem_request_details);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout)findViewById(R.id.layoutDots);
        next = (Button)findViewById(R.id.next);
        back = (Button)findViewById(R.id.back);


//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.MATCH_PARENT
//        );
//        params.setMargins(0, height, 0, 0);
//        viewPager.setLayoutParams(params);


        layouts = new int[]{R.layout.problem_which_work,R.layout.problem_select_company,R.layout.problem_enter_problem,R.layout.problem_enter_location,R.layout.problem_confirm_request};

        addBottomDots(0);
        changeStatusBarColor();
        back.setVisibility(View.GONE);

        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewListener);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int current = viewPager.getCurrentItem()-1;

                if(current<layouts.length){

                    viewPager.setCurrentItem(current);
                }else{
                    Intent i = new Intent(Problem_RequestDetails.this,empty.class );
                    startActivity(i);
                    finish();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int current = viewPager.getCurrentItem()+1;

                if(current<layouts.length){

                    viewPager.setCurrentItem(current);
                }else{
                    Intent i = new Intent(Problem_RequestDetails.this,empty.class );
                    startActivity(i);
                    finish();
                }
            }
        });

    }


    private void addBottomDots(int position){

        dots = new TextView[layouts.length];
        int[] colorActive = getResources().getIntArray(R.array.dot_active);
        int[] colorInactive = getResources().getIntArray(R.array.dot_inactive);
        dotsLayout.removeAllViews();

        for(int i = 0; i<dots.length; i++ ){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInactive[position]);
            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0 ){
            dots[position].setTextColor(colorActive[position]);
        }
    }


    private int getItem(int i){

        return viewPager.getCurrentItem()+i;
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addBottomDots(position);
            if(position == layouts.length-1){

                next.setVisibility(View.GONE);
                back.setVisibility(View.VISIBLE);
            }else{
                next.setVisibility(View.VISIBLE);
                next.setText("NEXT");
                back.setVisibility(View.VISIBLE);
            }
            if(position==0){

                back.setVisibility(View.GONE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



    private void changeStatusBarColor(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    ArrayList<String> answers = new ArrayList<String>();
    ArrayList<ProblemCompanyModel> companyModels = new ArrayList<ProblemCompanyModel>();

public class ViewPagerAdapter extends PagerAdapter{

    LayoutInflater layoutInflater;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View v = layoutInflater.inflate(layouts[position],container,false);
        container.addView(v);
        switch (position) {
            case 0:
                ListView answersList = (ListView) v.findViewById(R.id.workAnswersList);

                answers.clear();
                switch (jobName) {
                    case "electrical":
                    answers.add("Not Selected");
                    answers.add("Installations");
                    answers.add("Repair");
                    answers.add("Replace");
                    answers.add("Remove");
                    answers.add("Other");
                    break;

                    default:
                    answers.add("Not Selected");
                    break;
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_single_choice, answers);

                answersList.setAdapter(arrayAdapter);
                answersList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                answersList.setItemChecked(0,true);


            answersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   String value =  (String)parent.getItemAtPosition(position);
                    Toast.makeText(v.getContext(),jobName+" "+value,Toast.LENGTH_LONG).show();
                }
            });


            return v;

            case 1:

             companyModels.clear();
             ListView compamyList = v.findViewById(R.id.problemCompanyList);
             companyModels.add(new ProblemCompanyModel(R.drawable.test1,"Tecla","Electrical","Kadawatha",5.0f));
             companyModels.add(new ProblemCompanyModel(R.drawable.test2,"Fixma","Electrical","Kiribathgoda",3.5f));
             companyModels.add(new ProblemCompanyModel(R.drawable.test3,"Delo","Electrical","Biyagama",3.0f));
             companyModels.add(new ProblemCompanyModel(R.drawable.test4,"Jepse","Electrical","Kottawa",2.5f));
             companyModels.add(new ProblemCompanyModel(R.drawable.test5,"Helvon","Electrical","Maharagama",2.0f));
             companyModels.add(new ProblemCompanyModel(R.drawable.test1,"Selth","Electrical","Pnadura",1.5f));

             final ProblemCompanyAdapter companySearchAdapter = new ProblemCompanyAdapter(v.getContext(),companyModels);
             compamyList.setAdapter(companySearchAdapter);


             compamyList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                 @Override
                 public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                     companySearchAdapter.setCheckItem(((CheckedTextView)view.findViewById(R.id.problemCompanyRadio)));
                     Toast.makeText(view.getContext(),((TextView)view.findViewById(R.id.problemCompanyName)).getText(),Toast.LENGTH_LONG).show();
                     return true;
                 }
             });

             compamyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     companySearchAdapter.setCheckItem(((CheckedTextView)view.findViewById(R.id.problemCompanyRadio)));
                 }

             });

//             compamyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                 @Override
//                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                 }
//             });
                return v;
            case 2:
                return v;
            case 3:
                return v;
            case 4:
                return v;
             default:
                 break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View v = (View)object;
        container.removeView(v);

    }
}
}