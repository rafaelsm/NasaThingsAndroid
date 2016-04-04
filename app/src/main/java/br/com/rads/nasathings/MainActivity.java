package br.com.rads.nasathings;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import br.com.rads.nasathings.apod.view.ApodFragment;
import br.com.rads.nasathings.patents.model.Patent;
import br.com.rads.nasathings.patents.response.PatentsResponse;
import br.com.rads.nasathings.patents.response.Result;
import br.com.rads.nasathings.patents.view.PatentsFragment;
import br.com.rads.nasathings.service.NasaInterceptor;
import br.com.rads.nasathings.service.NasaService;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends NasaActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Bind(R.id.app_bar)
    AppBarLayout appBarLayout;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;

    @Bind(R.id.nav_view)
    NavigationView navigationView;

    private ProgressDialog progressDialog;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupToolbar();
        setupDrawer();

        buildRetrofit();

        loadApodFragment();
    }

    private void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);
        appBarLayout.setExpanded(false);
    }

    private void loadApodFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ApodFragment())
                .commit();
    }

    private void buildRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(NasaInterceptor.client())
                .build();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_apod:

                loadApodFragment();
                break;

            case R.id.nav_patents:
                showPatents();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showPatents(){
        progressDialog = ProgressDialog.show(this, null, "Loading patents", true, false);
        NasaService service = retrofit.create(NasaService.class);
        service.patents("gravity")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PatentsResponse>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(PatentsResponse patentsResponse) {
                        Log.d(TAG, patentsResponse.getResults().get(0).get_abstract());
                        Result r = patentsResponse.getResults().get(0);
                        Patent p = new Patent();
                        p.setTitle(r.getTitle());
                        p.setDescription(r.get_abstract());
//
                        PatentsFragment fragment = PatentsFragment.newInstance(p);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,fragment)
                                .commit();
                    }
                });

    }
}
