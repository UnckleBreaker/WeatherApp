package com.example.weatherapp.screen.pageindicatorview.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.weatherapp.R;
import com.example.weatherapp.data.DataProvider;
import com.example.weatherapp.domain.WeatherResponce;
import com.example.weatherapp.domain.WeatherUseCase;
import com.example.weatherapp.screen.WeatherPresenter;
import com.example.weatherapp.screen.WeatherView;
import com.example.weatherapp.screen.pageindicatorview.base.BaseActivity;
import com.example.weatherapp.screen.pageindicatorview.customize.CustomizeActivity;
import com.example.weatherapp.screen.pageindicatorview.data.Customization;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends BaseActivity implements WeatherView {
    public TextView T_City_name;
    public TextView T_City_temp;
    public TextView T_City_temp1;
    public TextView T_City_pressue;
    public TextView T_City_humidity;
    public TextView T_City_visability;
    public TextView T_City_description;
    public TextView T_City_main;
    private PageIndicatorView pageIndicatorView;
    private Customization customization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_home);
        customization = new Customization();

        T_City_name = findViewById(R.id.city_name);
        T_City_temp = findViewById(R.id.city_temperature);
        T_City_temp1 = findViewById(R.id.temp);
        T_City_pressue =findViewById(R.id.pressue);
        T_City_humidity= findViewById(R.id.humidity);
        T_City_visability= findViewById(R.id.visability);
        T_City_description= findViewById(R.id.description);
        T_City_main= findViewById(R.id.main);

        initToolbar();
        initViews();

        WeatherUseCase weatherUseCase = new WeatherUseCase(DataProvider.getWeatherProvider());
        WeatherPresenter weatherPresenter = new WeatherPresenter(this,weatherUseCase);
        weatherPresenter.init();

        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        boolean customization = requestCode == CustomizeActivity.EXTRAS_CUSTOMIZATION_REQUEST_CODE && resultCode == RESULT_OK;
        if (customization && intent != null) {
            this.customization = intent.getParcelableExtra(CustomizeActivity.EXTRAS_CUSTOMIZATION);
            updateIndicator();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_customize, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionCustomize:
                CustomizeActivity.start(this, customization);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("ConstantConditions")
    private void initViews() {
        HomeAdapter adapter = new HomeAdapter();
        adapter.setData(createPageList());

        final ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(adapter);

        pageIndicatorView = findViewById(R.id.pageIndicatorView);
    }

    @NonNull
    private List<View> createPageList() {
        List<View> pageList = new ArrayList<>();
        pageList.add(createPageView(R.color.google_red));
        pageList.add(createPageView(R.color.google_blue));
        pageList.add(createPageView(R.color.google_yellow));
        pageList.add(createPageView(R.color.google_green));

        return pageList;
    }

    @NonNull
    private View createPageView(int color) {
        View view = new View(this);
        view.setBackgroundColor(getResources().getColor(color));

        return view;
    }

    private void updateIndicator() {
        if (customization == null) {
            return;
        }

        pageIndicatorView.setAnimationType(customization.getAnimationType());
        pageIndicatorView.setOrientation(customization.getOrientation());
        pageIndicatorView.setRtlMode(customization.getRtlMode());
        pageIndicatorView.setInteractiveAnimation(customization.isInteractiveAnimation());
        pageIndicatorView.setAutoVisibility(customization.isAutoVisibility());
        pageIndicatorView.setFadeOnIdle(customization.isFadeOnIdle());
    }

    @Override
    public void showdata(WeatherResponce weatherResponce) {
        T_City_temp1.setText(String.valueOf(weatherResponce.getTemperature() +"C"));
        T_City_name.setText(weatherResponce.getName());
        T_City_temp.setText(String.valueOf(weatherResponce.getTemperature()));
        T_City_description.setText(weatherResponce.getWeatherdescription());
        T_City_humidity.setText(String.valueOf(weatherResponce.getHumidity()));
        T_City_main.setText(weatherResponce.getWeathermain());
        T_City_visability.setText(String.valueOf(weatherResponce.getVisibility()));
        T_City_pressue.setText(String.valueOf(weatherResponce.getPressure()));


    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,"Something went wrong",Toast.LENGTH_LONG).show();

    }
}
