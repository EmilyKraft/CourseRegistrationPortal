package com.claim.entity;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

//import com.google.maps.GeoApiContext;
//import com.google.maps.GeocodingApi;
//import com.google.maps.errors.ApiException;
//import com.google.maps.model.GeocodingResult;
//import com.google.maps.model.LatLng;

//@Data
//@Table(name="Address")
@Embeddable
public class Address {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="addressID")
//	private int addressID;
	
	@Column(name="poBox")
	private String poBox;
	
	@Column(name="streetAddress")
	private String streetAddress;
	
	@Column(name="city")
   // @NotEmpty(message = "City required")
	private String city;
    
	//@Pattern(regexp = "([a-zA-Z0-9]+([ ][a-zA-Z0-9])*)+",message="Please select State")
	@Column(name="state")
	private String state;
	
    //@NotEmpty(message = "Zip required")
	@Column(name="zip")
	private String zip;
	//private String lat; //Google Geocoding API
	//private String lng; //Google Geocoding API

	public Address(){}
	
//	public Location(String streetAddress, String city, String state, String zip) { //throws ApiException, InterruptedException, IOException {
//		this.streetAddress = streetAddress;
//		this.city = city;
//		this.state = state;
//		this.zip = zip;
		
//	GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBxAPcuXYCcDGRNaVPyG9Ihf4pHAHyPnz0");
//	GeocodingResult[] results =  GeocodingApi.geocode(context,
//			     (streetAddress + ", " + city + ", " + state + ", " + zip)).await();
//	LatLng location = results[0].geometry.location;
//	this.lat = location.toString();
//	}

//	public int getLocationID() {
//		return addressID;
//	}
//
//	public void setLocationID(int locationID) {
//		this.addressID = locationID;
//	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

//	public long getLat() {
//		return lat;
//	}
//
//	public void setLat(long lat) {
//		this.lat = lat;
//	}
//
//	public long getLng() {
//		return lng;
//	}
//
//	public void setLng(long lng) {
//		this.lng = lng;
//	}
	
}
