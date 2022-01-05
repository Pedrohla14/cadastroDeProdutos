package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import etities.ImportedProduct;
import etities.Product;
import etities.UsedProduct;

public class program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		
		List<Product>list= new ArrayList<Product>();
		
	
		System.out.println("Enter the number of products : ");
		int number= sc.nextInt();
		
		for(int i=1;i<=number;i++) {
			sc.nextLine();
		System.out.println("name");
		String name= sc.nextLine();
		
		System.out.println("price");
		Double price = sc.nextDouble();
		
		System.out.println("common,used or imported(c/u/i)?");
		char tipoProduct= sc.next().charAt(0);
		
		
		if(tipoProduct=='c') {
		Product product= new Product(name, price);
		
		list.add(product);
		}
		else if(tipoProduct=='i'){
			System.out.print("Customs fee:");
			Double customsFree= sc.nextDouble();
	
			Product product= new ImportedProduct(name, price,customsFree );
			list.add(product);
		}
		else if(tipoProduct=='u') {
			System.out.println("manufacture date (DD/MM/YYYY): ");
			String tempdate= sc.next();
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date  manufacture = formato.parse(tempdate);
			
			Product product= new UsedProduct(name, price, manufacture);	
			list.add(product);
		}
		}
		
		//imprimir produtos da lista 
		System.out.println();
		System.out.println("PRICE TAGS:");
		int ordemProd=1;
		for(Product prod: list) {
		System.out.printf("Product #%d data:",ordemProd);
		System.out.println(prod.priceTag());
		
		ordemProd++;
		}
		sc.close();

	}

}
