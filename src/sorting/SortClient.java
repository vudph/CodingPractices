package sorting;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class SortClient {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Integer A[] = new Integer[]{5, 6, 5, 3, 1, 8, 7, 2, 4};
		
		SortStrategy<Integer> selection = new SelectionSort();
		Sorter sorter = new Sorter(selection);
		sorter.sort(A);
		sorter.print(A);
		
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
		Comparator<FlightInfo> nameComparator = new CityNameComparator();
		Comparator<FlightInfo> timeComparator = new TimeComparator();
		
		SortStrategy<FlightInfo> quick = new QuickSort(timeComparator);
		sorter.setSort(quick);
		sorter.sort(array);
		System.out.println("QuickSort:");
		sorter.print(array);
		
		SortStrategy<FlightInfo> insertion = new InsertionSort(nameComparator);
		sorter.setSort(insertion);
		sorter.sort(array);
		System.out.println("Insertion sort:");
		sorter.print(array);
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
