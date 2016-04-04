package br.com.rads.nasathings.patents.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

import br.com.rads.nasathings.BR;

/**
 * Created by Rafael on 3/27/16.
 */
public class Patent extends BaseObservable implements Serializable{

    private String title;
    private String description;

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }
}
