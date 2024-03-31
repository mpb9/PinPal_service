package com.bb.places.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "PLACE_DETAILS", schema = "PUBLIC")
public class PlaceDetails implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    @Column(name = "PLACE_ID", nullable = false, length = 512)
    private String placeId;
    @NotBlank
    @Column(name = "NAME", nullable = false, length = 64)
    private String name;
    @NotNull
    @Column(name = "LAT", nullable = false)
    private Long lat;
    @NotNull
    @Column(name = "LNG", nullable = false)
    private Long lng;
    @Column(name = "ADDRESS", length = 256)
    private String address;
    @Column(name = "COUNTRY", length = 56)
    private String country;
    @Column(name ="WEBSITE", length = 256)
    private String website;
    @Column(name = "PHONE", length = 24)
    private String phone;
    @Column(name = "BUSINESS_STATUS", length = 24)
    private String businessStatus;
    @Column(name ="OPENING_HOURS", length = 256)
    private String openingHours;
    @Min(0)
    @Max(5)
    @Column(name = "RATING")
    private Long rating;
    @Min(0)
    @Column(name = "RATINGS_COUNT")
    private Long ratingsCount;
    @Column(name = "SUMMARY", length = 150)
    private String summary;
    @Column(name = "TYPES", length = 256)
    private String types;
    @Column(name = "PHOTOS", length = 256)
    private String photos;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLng() {
        return lng;
    }

    public void setLng(Long lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Long ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    @Override
    public int hashCode() {
        return placeId != null ? placeId.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlaceDetails placeDetails = (PlaceDetails) obj;
        return placeId != null ? placeId.equals(placeDetails.placeId) : placeDetails.placeId == null;
    }

    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder();
        strBld.append("\n");
        strBld.append("***** PLACE_DETAILS *****");
        strBld.append("\n");
        strBld.append("PLACE_ID: ").append(this.placeId);
        strBld.append("\n");
        strBld.append("NAME: ").append(this.name);
        strBld.append("\n");
        strBld.append("LAT: ").append(this.lat);
        strBld.append("\n");
        strBld.append("LNG: ").append(this.lng);
        strBld.append("\n");
        strBld.append("ADDRESS: ").append(this.address);
        strBld.append("\n");
        strBld.append("COUNTRY: ").append(this.country);
        strBld.append("\n");
        strBld.append("WEBSITE: ").append(this.website);
        strBld.append("\n");
        strBld.append("PHONE: ").append(this.phone);
        strBld.append("\n");
        strBld.append("BUSINESS_STATUS: ").append(this.businessStatus);
        strBld.append("\n");
        strBld.append("OPENING_HOURS: ").append(this.openingHours);
        strBld.append("\n");
        strBld.append("RATING: ").append(this.rating);
        strBld.append("\n");
        strBld.append("RATINGS_COUNT: ").append(this.ratingsCount);
        strBld.append("\n");
        strBld.append("SUMMARY: ").append(this.summary);
        strBld.append("\n");
        strBld.append("TYPES: ").append(this.types);
        strBld.append("\n");
        strBld.append("PHOTOS: ").append(this.photos);
        strBld.append("\n");
        strBld.append("***** END PLACE_DETAILS *****");
        return strBld.toString();

    }
}
