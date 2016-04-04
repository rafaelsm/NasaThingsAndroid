package br.com.rads.nasathings.apod.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.samsistemas.calendarview.widget.CalendarView;
import com.samsistemas.calendarview.widget.DayView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import br.com.rads.nasathings.R;
import br.com.rads.nasathings.apod.ApodResponse;
import br.com.rads.nasathings.service.NasaInterceptor;
import br.com.rads.nasathings.service.NasaService;
import br.com.rads.nasathings.util.DateUtil;
import br.com.rads.nasathings.util.NasaUtil;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApodFragment extends Fragment {

    @Bind(R.id.apod_image)
    ImageView imageView;

    @Bind(R.id.apod_title_text_view)
    TextView nameTextView;

    @Bind(R.id.apod_description_text_view)
    TextView descriptionTextView;

    ProgressBar progressBar;
    CalendarView calendarView;

    public ApodFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apod, container, false);
        ButterKnife.bind(this, view);

        setupViews();
        loadImage(new Date());

        return view;
    }

    private void setupViews() {
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progress_load);
        calendarView = (CalendarView) getActivity().findViewById(R.id.calendar_view);

        final DayView dayView = calendarView.findViewByDate(new Date(System.currentTimeMillis()));
        dayView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccentFade));

        calendarView.setIsOverflowDateVisible(true);
        calendarView.refreshCalendar(Calendar.getInstance(Locale.getDefault()));
        calendarView.setOnDateSelectedListener(new CalendarView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull Date date) {
                correctBackgroundForDate(date);

                if (!DateUtil.afterDay(new Date(), date)){
                    loadImage(date);
                }
            }

            private void correctBackgroundForDate(@NonNull Date date) {
                Date today = new Date();
                DayView todayView = calendarView.findViewByDate(today);
                if (DateUtils.isToday(date.getTime())) {
                    todayView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
                } else {
                    if (DateUtil.sameMonth(today, date)) {
                        todayView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccentFade));
                    }
                }
            }
        });

    }

    private void loadImage(Date date) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(NasaInterceptor.client())
                .build();

        updateLoadingViews(true);

        NasaService nasaService = retrofit.create(NasaService.class);
        nasaService.apod(NasaUtil.apodDateQueryString(date))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ApodResponse>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(final ApodResponse apodResponse) {
                        Picasso.with(getActivity()).load(apodResponse.getImageUrl()).into(
                                imageView, new Callback() {
                                    @Override
                                    public void onSuccess() {
                                        nameTextView.setText(apodResponse.getTitle());
                                        descriptionTextView.setText(apodResponse.getDescription());
                                        updateLoadingViews(false);
                                    }

                                    @Override
                                    public void onError() {
                                        //TODO: set bad image
                                    }
                                });

                    }

                });
    }

    private void updateLoadingViews(boolean loading) {
        progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
        imageView.setVisibility(loading ? View.GONE : View.VISIBLE);
        nameTextView.setVisibility(loading ? View.GONE : View.VISIBLE);
        descriptionTextView.setVisibility(loading ? View.GONE : View.VISIBLE);
    }

}
