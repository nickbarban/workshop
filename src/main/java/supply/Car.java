package supply;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Car {
	
	public static Map<String, Brand> allBrands= new TreeMap<>(new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o1.compareToIgnoreCase(o2);
		}
	});
	
	private String carID = null;
	private Brand brand = null;
	

}
