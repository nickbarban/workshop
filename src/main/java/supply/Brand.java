package supply;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Brand {
	
	private Set<Model> models = new TreeSet<>(new Comparator<Model>() {

		@Override
		public int compare(Model o1, Model o2) {
			// TODO Auto-generated method stub
			return o1.getNameModel().compareToIgnoreCase(o2.getNameModel());
		}
	});	
	private String name = null;
	
	private Brand(String nameBrand) {
		name = nameBrand;
		//models.add(model);
		//Car.allBrands.add(this);
	}
	
	public static Brand getBrand(String nameBrand, Model model) {
		Brand brand = Car.allBrands.get(nameBrand);
		if (brand == null) {
			brand = new Brand(nameBrand);
			Car.allBrands.put(nameBrand, brand);
		} 
		brand.models.add(model);
		return brand;
	}

	public Set<Model> getModels() {
		return models;
	}

	public void setModels(Set<Model> models) {
		this.models = models;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	

}
