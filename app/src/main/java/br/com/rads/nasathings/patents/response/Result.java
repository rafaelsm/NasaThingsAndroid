package br.com.rads.nasathings.patents.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael on 3/27/16.
 */
public class Result {

    @SerializedName("category")
    public String category;

    @SerializedName("client_record_id")
    public String clientRecordId;

    @SerializedName("center")
    public String center;

    @SerializedName("eRelations")
    public List<Object> eRelations = new ArrayList<>();

    @SerializedName("reference_number")
    public String referenceNumber;

    @SerializedName("expiration_date")
    public String expirationDate;

    @SerializedName("abstract")
    public String _abstract;

    @SerializedName("title")
    public String title;

    @SerializedName("innovator")
    public List<Innovator> innovator = new ArrayList<>();

    @SerializedName("contact")
    public Contact contact;

    @SerializedName("publication")
    public Object publication;

    @SerializedName("concepts")
    public Concepts concepts;

    @SerializedName("serial_number")
    public String serialNumber;

    @SerializedName("_id")
    public String Id;

    @SerializedName("patent_number")
    public String patentNumber;

    @SerializedName("id")
    public String id;

    @SerializedName("trl")
    public String trl;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClientRecordId() {
        return clientRecordId;
    }

    public void setClientRecordId(String clientRecordId) {
        this.clientRecordId = clientRecordId;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public List<Object> geteRelations() {
        return eRelations;
    }

    public void seteRelations(List<Object> eRelations) {
        this.eRelations = eRelations;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String get_abstract() {
        return _abstract;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Innovator> getInnovator() {
        return innovator;
    }

    public void setInnovator(List<Innovator> innovator) {
        this.innovator = innovator;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Object getPublication() {
        return publication;
    }

    public void setPublication(Object publication) {
        this.publication = publication;
    }

    public Concepts getConcepts() {
        return concepts;
    }

    public void setConcepts(Concepts concepts) {
        this.concepts = concepts;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTrl() {
        return trl;
    }

    public void setTrl(String trl) {
        this.trl = trl;
    }

    public String getPatentNumber() {
        return patentNumber;
    }

    public void setPatentNumber(String patentNumber) {
        this.patentNumber = patentNumber;
    }
}
