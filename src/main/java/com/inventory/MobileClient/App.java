package com.inventory.MobileClient;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.inventory.MobileClient.command.Command;
import com.inventory.MobileClient.model.CommandBean;

public class App 
{
	private static Logger log=Logger.getLogger(App.class);
	
	public static void displayErrorMessages(List<String> errorMessages){
		for (String str:errorMessages){
			System.out.println(str);
		}
	}
	
    public static void main( String[] args )
    {
		ApplicationContext ctx = new FileSystemXmlApplicationContext( "classpath:META-INF/application-context.xml");
		boolean quit=false;
		while(!quit){
			Scanner input=new Scanner(System.in);
			System.out.print("enter command>");
			String commandLine=input.nextLine();
			if (commandLine.equals("")){
				quit=true;
				continue;
			}
			
			String[] commands=commandLine.split(" ");
			
			if (commands.length==0)
				continue;
			else if (commands.length>0){
				String routeCommand=commands[0].toUpperCase();
				
				CommandBean commandBean=Command.COMMANDLIST.get(routeCommand);
				
				if (commandBean==null){
					System.out.println("Invalid command");
					continue;
				}
				
				Command myCommand=(Command) ctx.getBean(commandBean.getBean());
				
				if (myCommand==null){
					System.out.println("Invalid command");
					continue;
				}
				
				//execute the command
				List<String> errorMessages=myCommand.execute(commands);		
		
				
				if (errorMessages.size()>0)
					//display error messages
					App.displayErrorMessages(errorMessages);
			}			
		}
		System.out.println("Exited!");
    }
}
