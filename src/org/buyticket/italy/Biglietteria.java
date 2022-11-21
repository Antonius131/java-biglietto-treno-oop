package org.buyticket.italy;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("inserisci i km da percorrere: ");
		int km = sc.nextInt();
		System.out.print("inserisci l'età del passeggero: ");
		int age = sc.nextInt();
		System.out.print("Vuoi un biglietto flessibile? ");
		boolean flessible = sc.nextBoolean();
		
		sc.close();
		
		try {
			
			Biglietto ticket = new Biglietto(km, age, LocalDate.now(), flessible);
			
			FileWriter myWriter = new FileWriter("biglietto.txt"); 
			myWriter.write(ticket.toString());
			myWriter.close();
			
			System.out.println(ticket);
			System.out.println("Prezzo biglietto: " + ticket.calculatePrice() + "€");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} 
	}
}
