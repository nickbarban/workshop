package supply;

import java.util.Set;
import java.util.TreeSet;

public class Model {	
	
	private String modelID = null;
	private String nameModel = null;
	private Brand parentBrand = null;
	
	public Model(String modelID, String nameBrand, String nameModel) {
		this.modelID = modelID;
		this.nameModel = nameModel;
		parentBrand = Brand.getBrand(nameBrand, this);
	}

	public String getModelID() {
		return modelID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public String getNameModel() {
		return nameModel;
	}

	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}

	public Brand getParentBrand() {
		return parentBrand;
	}

	public void setParentBrand(Brand parentBrand) {
		this.parentBrand = parentBrand;
	}

	@Override
	public String toString() {
		return nameModel;
	}
	
	
	
	
}
