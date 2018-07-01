package com.inventory.MobileClient.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.inventory.MobileClient.model.CommandBean;
import com.inventory.MobileClient.model.Product;
import com.inventory.MobileClient.model.PurchaseBean;

public class PurchaseCommand extends Command{
		
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
			PurchaseBean purchaseBean=new PurchaseBean(commands[1],Integer.valueOf(commands[2]));
			String restPath=commandBean.getAddRestPath();
			
			try{
				purchaseBean=rest.postForObject(restPath,new HttpEntity<PurchaseBean>(purchaseBean), PurchaseBean.class);
				System.out.println(commandBean.getSuccessMessage());
			} catch(Exception e){
				errorMessages.add(commandBean.getErrorMessage());
			}
		} 
		
		return errorMessages;
	}
}
