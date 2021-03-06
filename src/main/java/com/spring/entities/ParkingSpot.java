package com.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingSpot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String area;
	private String pincode;
	private String latitude;
	private String longitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "ParkingSpot [id=" + id + ", area=" + area + ", pincode=" + pincode + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

}
