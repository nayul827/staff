package com.project.project.controller;

import com.project.common.Action;
import com.project.project.action.ProjectDeleteAction;
import com.project.project.action.ProjectInsertAction;
import com.project.project.action.ProjectInsertFormAction;
import com.project.project.action.ProjectListAction;
import com.project.project.action.ProjectUpdateAction;
import com.project.project.action.ProjectUpdateFormAction;
import com.project.project.action.ProjectViewAction;

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
		
		if(command.equals("Project_List")) {
			action = new ProjectListAction();
		} else if(command.equals("Project_Insert")) {
			action = new ProjectInsertAction();
		} else if(command.equals("Project_Insert_Form")) {
			action = new ProjectInsertFormAction(); 
		} else if(command.equals("Project_Update")) {
			action = new ProjectUpdateAction();
		} else if(command.equals("Project_Update_Form")) {
			action = new ProjectUpdateFormAction();
		} else if(command.equals("Project_View_Action")) {
			action = new ProjectViewAction();
		} else if(command.equals("Project_Delete_Action")) {
			action = new ProjectDeleteAction();
		}
		return action;
	}
}
