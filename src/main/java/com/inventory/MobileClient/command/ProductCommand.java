package com.inventory.MobileClient.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.inventory.MobileClient.model.CommandBean;
import com.inventory.MobileClient.model.Product;

public class ProductCommand extends Command {
		
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
		if (commandBean.getTransactionType().equals("ADD")){
			Product product=new Product(commands[1],Double.valueOf(commands[2]),Double.valueOf(commands[3]));
			String restPath=commandBean.getAddRestPath();
			try{
				product=rest.postForObject(restPath,new HttpEntity<Product>(product), Product.class);
				System.out.println(commandBean.getSuccessMessage());
			} catch(Exception e){
				errorMessages.add(commandBean.getErrorMessage());
			}
		} else if (commandBean.getTransactionType().equals("DELETE")){
			String restPath=commandBean.getDeleteRestPath();
			try{
				rest.delete(restPath, commands[1]);
				System.out.println(commandBean.getSuccessMessage());
			} catch(Exception e){
				errorMessages.add(commandBean.getErrorMessage());
			}
		}
		
		return errorMessages;
	}
}
