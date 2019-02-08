package sorting;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class FlightSorting {
	
	private static void printInfo(FlightInfo flights[]) {
		for (int i = 0; i < flights.length; i++) {
			System.out.println(flights[i]);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<FlightInfo> flights = new ArrayList<>();
		flights.add(new FlightInfo("Chicago", LocalTime.of(9, 21, 5)));
		flights.add(new FlightInfo("Seattle", LocalTime.of(9, 22, 43)));
		flights.add(new FlightInfo("Houston", LocalTime.of(9, 1, 10)));
		flights.add(new FlightInfo("Seattle", LocalTime.of(9, 36, 21)));
		flights.add(new FlightInfo("Phoenix", LocalTime.of(9, 37, 44)));
		flights.add(new FlightInfo("Chicago", LocalTime.of(9, 3, 13)));
		flights.add(new FlightInfo("Seattle", LocalTime.of(9, 10, 11)));
		flights.add(new FlightInfo("Chicago", LocalTime.of(9, 0, 1)));
		flights.add(new FlightInfo("Phoenix", LocalTime.of(9, 0, 3)));
		flights.add(new FlightInfo("Chicago", LocalTime.of(9, 19, 32)));
		flights.add(new FlightInfo("Chicago", LocalTime.of(9, 19, 46)));
		flights.add(new FlightInfo("Chicago", LocalTime.of(9, 25, 52)));
		flights.add(new FlightInfo("Chicago", LocalTime.of(9, 35, 21)));
		flights.add(new FlightInfo("Seattle", LocalTime.of(9, 22, 54)));
		flights.add(new FlightInfo("Houston", LocalTime.of(9, 0, 13)));
		flights.add(new FlightInfo("Seattle", LocalTime.of(9, 10, 25)));
		flights.add(new FlightInfo("Phoenix", LocalTime.of(9, 14, 25)));
		flights.add(new FlightInfo("Chicago", LocalTime.of(9, 0, 59)));
		
		FlightInfo array[] = flights.toArray(new FlightInfo[0]);
		SortingAlgorithms<FlightInfo> algo = new SortingAlgorithms<>(new TimeComparator());
		System.out.println("Sorting by time");
		algo.selectionSort(array);
		printInfo(array);
		algo.setComparator(new CityNameComparator());
//		System.out.println("==========================");
//		System.out.println("Sorting by city by selection sort (unstable)");
//		algo.selectionSort(array);
		System.out.println("==========================");
		System.out.println("Sorting by city by insertion sort (stable)");
		algo.insertionSort(array);
		printInfo(array);
		
	}
	
	static class TimeComparator implements Comparator<FlightInfo> {
		
		@Override
		public int compare(FlightInfo o1, FlightInfo o2) {
			return o1.getTime().compareTo(o2.getTime());
		}
		
	}
	
	static class CityNameComparator implements Comparator<FlightInfo> {

		@Override
		public int compare(FlightInfo o1, FlightInfo o2) {
			return o1.getCity().compareTo(o2.getCity());
		}
		
	}
	
}
