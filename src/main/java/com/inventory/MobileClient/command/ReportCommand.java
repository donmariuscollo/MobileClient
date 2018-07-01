package com.inventory.MobileClient.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.inventory.MobileClient.model.CommandBean;
import com.inventory.MobileClient.model.Product;
import com.inventory.MobileClient.model.SaleBean;

public class ReportCommand extends Command {
	public List<String> execute(String[] commands) {
		//initialize variables
		this.commands=commands;
		this.commandBean=(CommandBean) Command.COMMANDLIST.get(commands[0].toUpperCase());
				
		List<String> errorMessages=new ArrayList<String>();

		if (this.commandBean==null){
			errorMessages.add("Invalid command");
			return errorMessages;
		}

		errorMessages=super.validateCommand();
			
		if (errorMessages.size()>0){
			errorMessages.add(commandBean.getSyntax());
			return errorMessages;
		}
		
		RestTemplate rest=new RestTemplate();
		if (commandBean.getTransactionType().equals("REPORT")){
			String productListPath="http://localhost:8080/product-service/api/products";
			String saleListPath="http://localhost:8080/sale-service/api/sales";
			List<Product> products;
			List<SaleBean> sales;

			//get list of products
			try{
				ResponseEntity<Product[]> response=rest.exchange(productListPath,HttpMethod.GET, null, Product[].class);
				products=Arrays.asList(response.getBody());				
			} catch(Exception e){
				errorMessages.add(commandBean.getErrorMessage());
				return errorMessages;
			}

			//get list of sales
			try{
				ResponseEntity<SaleBean[]> response=rest.exchange(saleListPath,HttpMethod.GET, null, SaleBean[].class);
				sales=Arrays.asList(response.getBody());				
			} catch(Exception e){
				e.printStackTrace();
				errorMessages.add(commandBean.getErrorMessage());
				return errorMessages;
			}
			
			if (generateReport(products,sales))	{
				System.out.println(commandBean.getSuccessMessage());
			}
		}
		
		return errorMessages;
	}
	
	public boolean generateReport(List<Product> products,List<SaleBean> sales){
		boolean success=true;
		
		String title=			"                            INVENTORY REPORT";
		String header=			"Item Name       Bought At      Sold At        Available Qty        Value ";
		String headerSeparator=	"---------       ---------      --------       ------------        -------";
		String footerSeparator=	"-------------------------------------------------------------------------";
		String footer1=			"Total Value";
		String footer2=			"Profit since previous report";
		System.out.println(title);
		System.out.println(header);
		System.out.println(headerSeparator);
		
		Double totalValue=0.0;
		for (Product product:products){
			String itemName=String.format("%-14s ", product.getItemName());
			String costPrice=String.format("%,10.2f    ", product.getCostPrice());
			String sellingPrice=String.format("%,10.2f       ", product.getSellingPrice());
			String quantity=String.format("%10d    ", product.getQuantity());
			String value=String.format("%,13.2f", product.getCostPrice()*product.getQuantity());
			String lineItem=itemName+costPrice+sellingPrice+quantity+value;
			totalValue=totalValue+(product.getCostPrice()*product.getQuantity());
			System.out.println(lineItem);
		}
		
		Double totalSale=0.0;
		for (SaleBean sale:sales){
			totalSale=totalSale+((sale.getSellingPrice()-sale.getCostPrice()) * sale.getQuantity());
		}
		
		
		System.out.println(footerSeparator);
		System.out.println(footer1+String.format("%,62.2f", totalValue));
		System.out.println(footer2+String.format("%,45.2f", totalSale));
		return success;
	}
}
