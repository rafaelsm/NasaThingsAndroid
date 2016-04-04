package br.com.rads.nasathings.patents.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rafael on 3/27/16.
 */
public class Innovator {

    @SerializedName("lname")
    public String lname;

    @SerializedName("mname")
    public String mname;

    @SerializedName("company")
    public String company;

    @SerializedName("order")
    public String order;

    @SerializedName("fname")
    public String fname;

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
