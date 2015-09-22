package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import supply.Brand;
import supply.Car;
import supply.Model;
import supply.SupplyClient;

public final class Parser {

	private final static String audaFilePath = "D:\\razbor\\каталоги\\audatex.txt";

	// read file with specific structure for temporary usage
	public final static void readAuda() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(audaFilePath)));
		} catch (FileNotFoundException e) {
			if (SupplyClient.DEBUG) {
				e.printStackTrace();
			} else {
				JOptionPane.showMessageDialog(null, "File: " + audaFilePath + " not found",
						"Parser: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
			}
		}

		try {
			String strFromFile = reader.readLine();
			while (reader != null && strFromFile != null) {
				String[] arrFromStr = strFromFile.trim().split("\t");
				String modelName = getModelName(arrFromStr[2].trim());
				if (SupplyClient.DEBUG) {
					System.out.println(arrFromStr[0] + "||" + arrFromStr[1] + "||" + modelName);
				}
				Model model = new Model(arrFromStr[0], arrFromStr[1], modelName);
				System.out.println(model);
				System.out.println(Car.allBrands.size() + "||" + model.getParentBrand().getModels().size());
				strFromFile = reader.readLine();
			}
		} catch (IOException e) {
			if (SupplyClient.DEBUG) {
				e.printStackTrace();
			} else {
				JOptionPane.showMessageDialog(null, "Parser can't read file: " + audaFilePath, "Parser: IOException",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private static String getModelName(String fullModelName) {
		String[] nameParts = fullModelName.split(" ");
		System.out.println("fullModelName: " + fullModelName);
		StringBuilder result = new StringBuilder(nameParts[0]);
		for (int i = 1; i < nameParts.length; i++) {
			if (nameParts[i].trim().startsWith("(")) {
				break;
			} else {
				result.append(" " + nameParts[i].trim());
			}
		}
		return result.toString();
	}

	/*public static void main(String[] args) {
		Parser.readAuda();
		for (String string : Car.allBrands.keySet()) {
			//System.out.println(string + "---------------------");
			//System.out.println(Car.allBrands.get(string).getModels());
			for (Model model : Car.allBrands.get(string).getModels()) {
				System.out.println(model.getNameModel());
			}
		}
	}*/

}
