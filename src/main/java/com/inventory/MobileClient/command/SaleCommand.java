package com.inventory.MobileClient.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.inventory.MobileClient.model.CommandBean;
import com.inventory.MobileClient.model.PurchaseBean;
import com.inventory.MobileClient.model.SaleBean;

public class SaleCommand extends Command{
	
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
			SaleBean saleBean=new SaleBean(commands[1],Integer.valueOf(commands[2]));
			String restPath=commandBean.getAddRestPath();
			
			try{
				saleBean=rest.postForObject(restPath,new HttpEntity<SaleBean>(saleBean), SaleBean.class);
				System.out.println(commandBean.getSuccessMessage());
			} catch(Exception e){
				errorMessages.add(commandBean.getErrorMessage());
			}
		} 
		
		return errorMessages;
	}

}
