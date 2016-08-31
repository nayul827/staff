package com.project.project.controller;

import com.project.common.Action;
import com.project.project.action.ProjectListAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		
		if(command.equals("ProjectList")) {
			action = new ProjectListAction(); 
		} 
		return action;
	}
}
