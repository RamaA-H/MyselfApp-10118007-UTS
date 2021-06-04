package com.example.myselfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
//Tanggal Pengerjaan : 25 Mei 2021
//NIM   : 10118007
//Nama  : Rama Al Halik
//Kelas : IF-1
public class MainActivity extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;
    private MaterialButton buttonOnboardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicators);
        buttonOnboardingAction = findViewById(R.id.buttonOnBoardingAction);

        setupOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingIndicators();
        setCurrentOnBoardIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardIndicator(position);
            }
        });

        buttonOnboardingAction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()) {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), Drawer.class));
                    finish();
                }
            }
        });

    }
    private void  setupOnboardingItems(){

        List<OnboardingItem> onboardingItems = new ArrayList<>();
        OnboardingItem item1 = new OnboardingItem();
        item1.setTitle("Selamat Datang");
        item1.setDescription("Di Myself App");
        item1.setImage(R.drawable.selamatdatang);

        OnboardingItem item2 = new OnboardingItem();
        item2.setTitle("Myself App");
        item2.setDescription("Merupakan Aplikasi Biodata Saya");
        item2.setImage(R.drawable.icon);

        OnboardingItem item3 = new OnboardingItem();
        item3.setTitle("Selamat ");
        item3.setDescription("Berseluncur");
        item3.setImage(R.drawable.silahkan);

        onboardingItems.add(item1);
        onboardingItems.add(item2);
        onboardingItems.add(item3);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
    }
    private void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i = 0; i< indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
            }
        }
        private void setCurrentOnBoardIndicator(int index){
            int childCount = layoutOnboardingIndicators.getChildCount();
            for (int i = 0; i<childCount; i++) {
                ImageView imageView = (ImageView) layoutOnboardingIndicators.getChildAt(i);
                if (i == index) {
                    imageView.setImageDrawable(
                            ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active)
                    );
                }else {
                    imageView.setImageDrawable(
                            ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive)
                    );
                }
            }
            if(index == onboardingAdapter.getItemCount() - 1) {
                buttonOnboardingAction.setText("Start");
            }else{
                buttonOnboardingAction.setText("Next");
            }
        }
    }
