package com.inventory.MobileClient.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inventory.MobileClient.model.CommandBean;

public abstract class Command {
	protected String[] commands;
	protected CommandBean commandBean;

	public static Map<String,CommandBean> COMMANDLIST=new HashMap<String,CommandBean>();
	static {
		//CREATE command
		CommandBean create=new CommandBean();
		create.setId("10000");
		create.setCommandString("CREATE");
		create.setNumOfParameters(4);
		create.setSyntax("Syntax: CREATE <itemName> <costPrice> <sellingPrice> i.e. CREATE Book01 10.50 13.79");
		create.setErrorMessage("Cannot create the product");
		create.setSuccessMessage("Product has been created");
		create.setParamType1("String");
		create.setParamType2("String");
		create.setParamType3("Double");
		create.setParamType4("Double");
		create.setBean("productCommand");
		create.setTransactionType("ADD");
		create.setAddRestPath("http://localhost:8080/product-service/api/product");
		COMMANDLIST.put("CREATE", create);
		
		//UPDATEBUY command
		CommandBean updateBuy=new CommandBean();
		updateBuy.setId("10001");
		updateBuy.setCommandString("UPDATEBUY");
		updateBuy.setNumOfParameters(3);
		updateBuy.setSyntax("Syntax: UPDATEBUY <itemName> <quantity> i.e. UPDATEBUY Tab01 100");
		updateBuy.setErrorMessage("Cannot update quantity");
		updateBuy.setSuccessMessage("Quantity has been added");
		updateBuy.setParamType1("String");
		updateBuy.setParamType2("String");
		updateBuy.setParamType3("Integer");
		updateBuy.setBean("purchaseCommand");
		updateBuy.setTransactionType("ADD");
		updateBuy.setAddRestPath("http://localhost:8080/purchase-service/api/purchase");
		COMMANDLIST.put("UPDATEBUY", updateBuy);
		
		//UPDATESELL command
		CommandBean updateSell=new CommandBean();
		updateSell.setId("10002");
		updateSell.setCommandString("UPDATESELL");
		updateSell.setNumOfParameters(3);
		updateSell.setSyntax("Syntax: UPDATESELL <itemName> <quantity> i.e. UPDATEBUY Food01 1");
		updateSell.setErrorMessage("Cannot update quantity");
		updateSell.setSuccessMessage("Quantity has been sold");
		updateSell.setParamType1("String");
		updateSell.setParamType2("String");
		updateSell.setParamType3("Integer");
		updateSell.setBean("saleCommand");
		updateSell.setTransactionType("ADD");
		updateSell.setAddRestPath("http://localhost:8080/sale-service/api/sale");
		COMMANDLIST.put("UPDATESELL", updateSell);
		
		//REPORT command
		CommandBean report=new CommandBean();
		report.setId("10003");
		report.setCommandString("REPORT");
		report.setNumOfParameters(1);
		report.setSyntax("Syntax: REPORT i.e. REPORT");
		report.setErrorMessage("Cannot generate report");
		report.setSuccessMessage("Report has been generated");
		report.setParamType1("String");
		report.setBean("reportCommand");
		report.setTransactionType("REPORT");
		COMMANDLIST.put("REPORT", report);

		//DELETE command
		CommandBean delete=new CommandBean();
		delete.setId("10004");
		delete.setCommandString("DELETE");
		delete.setNumOfParameters(2);
		delete.setSyntax("Syntax: DELETE <itemName> i.e. DELETE Tab01");
		delete.setErrorMessage("Cannot delete product");
		delete.setSuccessMessage("Product has been deleted");
		delete.setParamType1("String");
		delete.setParamType2("String");
		delete.setBean("productCommand");
		delete.setTransactionType("DELETE");
		delete.setDeleteRestPath("http://localhost:8080/product-service/api/product/{itemName}");		
		COMMANDLIST.put("DELETE", delete);
		
	}
	
	public abstract List<String> execute(String[] commands);
	
	//validate command syntax
	public List<String> validateCommand(){
		
		List<String> errorMessages=new ArrayList<String>();

		if (this.commands.length<commandBean.getNumOfParameters()){
			errorMessages.add("Parameter missing");
			return errorMessages;
		}

		
		String param1=1<commands.length?commands[1]:"0";
		String param2=2<commands.length?commands[2]:"0";
		String param3=3<commands.length?commands[3]:"0";
		String param4=4<commands.length?commands[4]:"0";
		
		try {
			if (commandBean.getParamType1()!=null && commandBean.getParamType1().equals("Double"))
				Double.valueOf(param1);
			else if (commandBean.getParamType1()!=null && commandBean.getParamType1().equals("Integer"))
				Integer.valueOf(param1);
			
			
			if (commandBean.getParamType2()!=null && commandBean.getParamType2().equals("Double"))
				Double.valueOf(param2);
			else if (commandBean.getParamType2()!=null && commandBean.getParamType2().equals("Integer"))
				Integer.valueOf(param2);
			
			
			if (commandBean.getParamType3()!=null && commandBean.getParamType3().equals("Double"))
				Double.valueOf(param3);
			else if (commandBean.getParamType3()!=null && commandBean.getParamType3().equals("Integer"))
				Integer.valueOf(param3);

			
			if (commandBean.getParamType4()!=null && commandBean.getParamType4().equals("Double"))
				Double.valueOf(param4);
			else if (commandBean.getParamType4()!=null && commandBean.getParamType4().equals("Integer"))
				Integer.valueOf(param4);

			
		} catch (Exception e){
			errorMessages.add("Parameters should be numeric");
		}
		
		return errorMessages;
	}
	
}
