package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {


		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>(); 
		
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.print("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char ch = sc.next().charAt(0);
			
			if(ch == 'i') {
				System.out.print("Name:");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price:");
				Double price = sc.nextDouble();
				System.out.print("Customs Fee:");
				Double customsFee = sc.nextDouble();
				
				Product product = new ImportedProduct(name, price, customsFee);
				list.add(product);
			}
			
			if (ch == 'c') {
				System.out.print("Name:");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price:");
				Double price = sc.nextDouble();
			
				Product product = new Product(name, price);
				list.add(product);
			}
			
			if (ch == 'u'){
				System.out.print("Name:");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price:");
				Double price = sc.nextDouble();
				System.out.println("Manufacture date (DD/MM/YYYY)");
				Date manufactureDate = sdf.parse(sc.next());
				
				Product product = new UsedProduct(name, price, manufactureDate);
			}
			
			
			
			
			
		}
		
		for(Product product : list) {
			System.out.println("PRICE TAGS:");
			
			for (Product prod : list) {
				System.out.println(prod.priceTag());
		}
		}

		
		
		
		
		
		
		sc.close();
				
				
	}

}
