package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Product;
import entities.UsedProduct;
import entities.importedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
			List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		 System.out.println("Enter the number of products: ");
		 int n = sc.nextInt();
		 
		 for(int i = 0; i<n;i++) {
			 System.out.println("Product #" + i + " data: ");
			 System.out.println("Common, used or imported (c/u/i)?");
			 char ch = sc.next().charAt(0);
			 System.out.println("Name: ");
			 String name = sc.next();
			 System.out.println("Price: ");
			 double price = sc.nextDouble();
			 if(ch == 'c') {
				 list.add(new Product(name, price));
			 }else if (ch == 'i') {
				 System.out.println("Customs fee: ");
				 double customsFee = sc.nextDouble();
				 list.add(new importedProduct(name, price, customsFee));
			 }else if (ch == 'u') {
				 System.out.println("Manufacture data: ");
				 Date manufactureDate = sdf.parse(sc.next());
				 list.add(new UsedProduct(name, price, manufactureDate));
			 }
			}
		 System.out.println("Price tags: ");
		 for (Product p: list) {
			 System.out.println(p.priceTag());
		 }

	}

}
