package topcoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OlpMedalTable {
	static class Country implements Comparable<Country> {
		String code;
		int gold, silver, bronze;
		public Country(String code, int g, int s, int b) {
			this.code = code;
			this.gold = g;
			this.silver = s;
			this.bronze = b;
		}

		@Override
		public int compareTo(Country o) {
			int g = o.gold - this.gold;
			if (g == 0) {
				int s = o.silver - this.silver;
				if (s == 0) {
					int b = o.bronze - this.bronze;
					if (b == 0) {
						return this.code.compareTo(o.code);
					}
					return b;
				}
				return s;
			}
			return g;
		}
		
		@Override
		public String toString() {
			return code + " " + gold + " " + silver + " " + bronze;
		}
		
	}
	
	static String[] generate(String results[]) {
		Map<String, Country> map = new HashMap<>();
		for (String result : results) {
			String s[] = result.split(" ");
			if (map.containsKey(s[0])) {
				map.get(s[0]).gold++;
			} else {
				map.put(s[0], new Country(s[0], 1, 0, 0));
			}
			if (map.containsKey(s[1])) {
				map.get(s[1]).silver++;
			} else {
				map.put(s[1], new Country(s[1], 0, 1, 0));
			}
			if (map.containsKey(s[2])) {
				map.get(s[2]).bronze++;
			} else {
				map.put(s[2], new Country(s[2], 0, 0, 1));
			}
		}
		List<Country> countries = new ArrayList<>(map.values());
		Collections.sort(countries);
		String ret[] = new String[countries.size()];
		int i = 0;
		for (Country c : countries) {
			ret[i++] = c.toString();
		}
		return ret;
	}

	public static void main(String[] args) {
		String in[] = {"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"};
		String res[] = generate(in);
		System.out.println(res);
	}

}
