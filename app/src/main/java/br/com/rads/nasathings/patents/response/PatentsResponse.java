package br.com.rads.nasathings.patents.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import br.com.rads.nasathings.patents.response.Result;

/**
 * Created by Rafael on 3/27/16.
 */
public class PatentsResponse {

    @SerializedName("count")
    public long count;

    @SerializedName("results")
    public List<Result> results = new ArrayList<>();

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
