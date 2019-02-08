package sorting;

import java.time.LocalTime;

public class FlightInfo implements Comparable<FlightInfo> {
	private String city;
	private LocalTime time;
	
	public FlightInfo(String city, LocalTime time) {
		this.setCity(city);
		this.setTime(time);
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public int compareTo(FlightInfo o) {
		return this.time.compareTo(o.time);
	}
	
	@Override
	public String toString() {
		return city + " " + time.toString();
	}
}
