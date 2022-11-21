package org.buyticket.italy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {
	
	private static final BigDecimal PRICE_PER_KM = new BigDecimal(0.21);
	private static final BigDecimal OVER_65_DISCOUNT = new BigDecimal(0.40);
    private static final BigDecimal UNDER_18_DISCOUNT = new BigDecimal(0.20);
    private static final int NORMAL_DUR = 30;
    private static final int FLESSIBLE_DUR = 90;
	private LocalDate data;
    private boolean flessible;
	private int km;
	private int age;
	
	public Biglietto(int km, int age, LocalDate data, boolean flessible) throws Exception {
		
		setKm(km);
		setAge(age);
		this.data = LocalDate.now();
		this.flessible = flessible;
		
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
	
	private double calculateDiscount(int km, BigDecimal PRICE_PER_KM, BigDecimal OVER_65_DISCOUNT, BigDecimal UNDER_18_DISCOUNT, boolean flessible) {
		
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
				 		
		if (flessible == true) {
			
			return totalPrice + (totalPrice * 0.10);
		} else {
			
			return totalPrice;
		}
	}
	
	public double calculatePrice() {
		
		return calculateDiscount(km, PRICE_PER_KM, OVER_65_DISCOUNT, UNDER_18_DISCOUNT, flessible);		
	}
	
	
	
	// calculate expiring methods
	
	public LocalDate calcolaDataScadenza(LocalDate data, boolean flessible,int NORMAL_DUR, int FLESSIBLE_DUR) {
		
		if (flessible == true) {
		 
			return data.plusDays(FLESSIBLE_DUR);
		} else {
			
			return data.plusDays(NORMAL_DUR);
		}
	}
	
	
	
	
	@Override
	public String toString() {
		
		// TODO Auto-generated method stub
		return  "Età passeggero: " + age
				+ "\nKm percorsi: " + km
				+ "\nKm Data: " + data
				+ "\nKm flessibile: " + flessible
				+ "\nScadenza Biglietto: " + calcolaDataScadenza(data, flessible, NORMAL_DUR, FLESSIBLE_DUR);
		
	}
}
