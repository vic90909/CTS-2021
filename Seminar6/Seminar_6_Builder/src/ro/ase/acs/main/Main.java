package ro.ase.acs.main;

import java.util.Date;

import ro.ase.acs.builder.Product;
import ro.ase.acs.builder.Product.ProductBuilderV2;

public class Main {

	public static void main(String[] args) {
//		Product product = new Product("Milk",10,12345,55,null,0,false,true,true);
//		Product product2=new Product("ciocolata",6);
//		product2.setQuantity(10);
//		product2.setBarCode(1232132);
//		//...
//		product2.setExpireDate(new Date());

		Product product3 = new Product.ProductBuilderV2().addName("Milk").addBarCode(123456)
				.addDate(new Date(2021, 3, 21)).addQuantity(23).addIsVegetarianFriendly(true).addIsGlutenFree(true)
				.build();

		ProductBuilderV2 builder = new ProductBuilderV2();
		builder.addName("chocolate");
		builder.addPrice(7);
		builder.addQuantity(10);
		builder.addBarCode(123123);
		Product product4 = builder.build();
	}

}
