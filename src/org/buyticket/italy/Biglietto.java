package org.buyticket.italy;

import java.math.BigDecimal;

public class Biglietto {
	
	private static final BigDecimal PRICE_PER_KM = new BigDecimal(0.21);
	private static final BigDecimal OVER_65_DISCOUNT = new BigDecimal(0.40);
    private static final BigDecimal UNDER_18_DISCOUNT = new BigDecimal(0.20);
	private int km;
	private int age;
	
	public Biglietto(int km, int age) throws Exception {
		
		setKm(km);
		setAge(age);
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) throws Exception {
		
		if (isValidKm(km)) {
			
			this.km = km;
		};
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {
		
		if (isValidEta(age)) {
			
			this.age = age;
		}
	}
	
	
	
	// Exception methods
	
	public boolean isValidKm(int km) throws Exception  {
		
		if (km <= 0) {
			
			throw new Exception("Il percorso deve essere maggiore di 0Km");
		}
		
		return true;
	}
	
	public boolean isValidEta(int age) throws Exception  {
		
		if (age <= 0) {
			
			throw new Exception("L'età deve essere maggiore di 0");
		}
		
		return true;
	}
	
	
	// calculate price & discount methods
	
	private double calculateDiscount(int km, BigDecimal PRICE_PER_KM, BigDecimal OVER_65_DISCOUNT, BigDecimal UNDER_18_DISCOUNT) {
		
		double price = km * PRICE_PER_KM.doubleValue();
		double totalPrice;
		
		if (age < 12) {
			
			totalPrice = 0;
		} else if (age > 13 && age < 18) {
			
			totalPrice = price * UNDER_18_DISCOUNT.doubleValue();
		} else if (age > 65) {
			
			totalPrice = price * OVER_65_DISCOUNT.doubleValue();
		} else {
			
			totalPrice = km * PRICE_PER_KM.doubleValue();
		}
		 		
		return totalPrice;
	}
	
	public double calculatePrice() {
		
		return calculateDiscount(km, PRICE_PER_KM, OVER_65_DISCOUNT, UNDER_18_DISCOUNT);		
	}
	
	
	
	@Override
	public String toString() {
		
		// TODO Auto-generated method stub
		return  "Età passeggero: " + age
				+ "\nKm percorsi: " + km; 
	}
}
