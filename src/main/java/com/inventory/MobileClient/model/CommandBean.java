package com.inventory.MobileClient.model;

public class CommandBean {
	private String id;
	private String commandString;
	private Integer numOfParameters;
	private String syntax;
	private String errorMessage;
	private String successMessage;
	private String paramType1;
	private String paramType2;
	private String paramType3;
	private String paramType4;
	private String bean;
	private String transactionType;
	private String addRestPath;
	private String editRestPath;
	private String deleteRestPath;
	private String listRestPath;
	private String searchRestPath;
	
	public CommandBean(){
		
	}
	
	public CommandBean(String id, String commandString, Integer numOfParameters, String syntax, String errorMessage,
			String paramType1, String paramType2, String paramType3) {
		super();
		this.id = id;
		this.commandString = commandString;
		this.numOfParameters = numOfParameters;
		this.syntax = syntax;
		this.errorMessage = errorMessage;
		this.paramType1 = paramType1;
		this.paramType2 = paramType2;
		this.paramType3 = paramType3;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCommandString() {
		return commandString;
	}
	public void setCommandString(String commandString) {
		this.commandString = commandString;
	}
	public Integer getNumOfParameters() {
		return numOfParameters;
	}
	public void setNumOfParameters(Integer numOfParameters) {
		this.numOfParameters = numOfParameters;
	}
	public String getSyntax() {
		return syntax;
	}
	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getParamType1() {
		return paramType1;
	}
	public void setParamType1(String paramType1) {
		this.paramType1 = paramType1;
	}
	public String getParamType2() {
		return paramType2;
	}
	public void setParamType2(String paramType2) {
		this.paramType2 = paramType2;
	}
	public String getParamType3() {
		return paramType3;
	}
	public void setParamType3(String paramType3) {
		this.paramType3 = paramType3;
	}

	public String getParamType4() {
		return paramType4;
	}

	public void setParamType4(String paramType4) {
		this.paramType4 = paramType4;
	}

	public String getBean() {
		return bean;
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getAddRestPath() {
		return addRestPath;
	}

	public void setAddRestPath(String addRestPath) {
		this.addRestPath = addRestPath;
	}

	public String getEditRestPath() {
		return editRestPath;
	}

	public void setEditRestPath(String editRestPath) {
		this.editRestPath = editRestPath;
	}

	public String getDeleteRestPath() {
		return deleteRestPath;
	}

	public void setDeleteRestPath(String deleteRestPath) {
		this.deleteRestPath = deleteRestPath;
	}

	public String getListRestPath() {
		return listRestPath;
	}

	public void setListRestPath(String listRestPath) {
		this.listRestPath = listRestPath;
	}

	public String getSearchRestPath() {
		return searchRestPath;
	}

	public void setSearchRestPath(String searchRestPath) {
		this.searchRestPath = searchRestPath;
	}
}
