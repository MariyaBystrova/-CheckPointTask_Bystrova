package by.epam.tr.cg.service.impl;

public class Validator {
	
	private Validator(){}
	
	public static boolean nameValidation(String name) {
		if (name == null) {
			return false;
		}
		return true;
	}

	public static boolean categoryValidation(String category) {
		if (category == null) {
			return false;
		}
		return true;
	}
	public static boolean priceValidation(int price) {
		if (price == 0) {
			return false;
		}
		return true;
	}

	public static boolean idValidation(int id) {
		if (id <= 0) {
			return false;
		}
		return true;
	}
}
