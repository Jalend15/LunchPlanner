package com.example.app;

public class listItem {

    // List View - - -  Provide Brief Details of Location - - - - - - - -
    // Location ID
    private String idOfLocation;

    // Name of Location
    private String title;
    private String nameOfLocation;

    // Formatted Address of Location
    private String addressOfLocation;

    // Latitude of Location
    private Double latOfLocation;

    // Longitude of Location
    private Double longOfLocation;

    // Distance of Location
    private int distanceOfLocation;

    // Category Name of Location (ex. Pizza Place )
    private String categoryOfLocation;

    // Category Icon of Location
    private String categoryIconOfLocation;

    // Detailed View - - - Utilizing second JSON Request w/ Location ID - - - - - - - - - - - - -
    // Formatted Phone Number of Location
    private String phoneNumberOfLocation;

    // Website URL of Location
    private String websiteOfLocation;

    // Hours of Operation of given Location
    private String hoursOfOperationOfLocation;

    // Price Tier of Location
    private String priceOfLocation;

    // Numerical Rating of given Location
    private String ratingOfLocation;

    // Description of Location
    private String description;

    // Photo for given Location
    private String photoOfLocation;


    // Constructor
    public listItem(String idOfLocation, String nameOfLocation, String addressOfLocation, Double latOfLocation, Double longOfLocation, int distanceOfLocation, String categoryOfLocation) {
        this.idOfLocation = idOfLocation;
        this.nameOfLocation = nameOfLocation;
        this.addressOfLocation = addressOfLocation;
        this.latOfLocation = latOfLocation;
        this.longOfLocation = longOfLocation;
        this.distanceOfLocation = distanceOfLocation;
        this.categoryOfLocation = categoryOfLocation;
    }

    // Getter & Setter Methods for Location Details

    public String getIdOfLocation() {
        return idOfLocation;
    }

    public void setIdOfLocation(String idOfLocation) {
        this.idOfLocation = idOfLocation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameOfLocation() {
        return nameOfLocation;
    }

    public void setNameOfLocation(String nameOfLocation) {
        this.nameOfLocation = nameOfLocation;
    }

    public String getAddressOfLocation() {
        return addressOfLocation;
    }

    public void setAddressOfLocation(String addressOfLocation) {
        this.addressOfLocation = addressOfLocation;
    }

    public Double getLatOfLocation() {
        return latOfLocation;
    }

    public void setLatOfLocation(Double latOfLocation) {
        this.latOfLocation = latOfLocation;
    }

    public Double getLongOfLocation() {
        return longOfLocation;
    }

    public void setLongOfLocation(Double longOfLocation) {
        this.longOfLocation = longOfLocation;
    }

    public int getDistanceOfLocation() {
        return distanceOfLocation;
    }

    public void setDistanceOfLocation(int distanceOfLocation) {
        this.distanceOfLocation = distanceOfLocation;
    }

    public String getCategoryOfLocation() {
        return categoryOfLocation;
    }

    public void setCategoryOfLocation(String categoryOfLocation) {
        this.categoryOfLocation = categoryOfLocation;
    }

    public String getCategoryIconOfLocation() {
        return categoryIconOfLocation;
    }

    public void setCategoryIconOfLocation(String categoryIconOfLocation) {
        this.categoryIconOfLocation = categoryIconOfLocation;
    }

    public String getPhoneNumberOfLocation() {
        return phoneNumberOfLocation;
    }

    public void setPhoneNumberOfLocation(String phoneNumberOfLocation) {
        this.phoneNumberOfLocation = phoneNumberOfLocation;
    }

    public String getWebsiteOfLocation() {
        return websiteOfLocation;
    }

    public void setWebsiteOfLocation(String websiteOfLocation) {
        this.websiteOfLocation = websiteOfLocation;
    }

    public String getHoursOfOperationOfLocation() {
        return hoursOfOperationOfLocation;
    }

    public void setHoursOfOperationOfLocation(String hoursOfOperationOfLocation) {
        this.hoursOfOperationOfLocation = hoursOfOperationOfLocation;
    }

    public String getPriceOfLocation() {
        return priceOfLocation;
    }

    public void setPriceOfLocation(String priceOfLocation) {
        this.priceOfLocation = priceOfLocation;
    }

    public String getRatingOfLocation() {
        return ratingOfLocation;
    }

    public void setRatingOfLocation(String ratingOfLocation) {
        this.ratingOfLocation = ratingOfLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoOfLocation() {
        return photoOfLocation;
    }

    public void setPhotoOfLocation(String photoOfLocation) {
        this.photoOfLocation = photoOfLocation;
    }
}
