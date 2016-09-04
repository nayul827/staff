package com.project.project.controller;

import com.project.common.Action;
import com.project.project.action.CrojectDeleteAction;
import com.project.project.action.CrojectInsertAction;
import com.project.project.action.CrojectInsertFormAction;
import com.project.project.action.CrojectListAction;
import com.project.project.action.CrojectUpdateAction;
import com.project.project.action.CrojectUpdateFormAction;
import com.project.project.action.CrojectViewAction;
import com.project.project.action.ProjectCheckPassAction;
import com.project.project.action.ProjectCheckPassFormAction;
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
		
		if (command.equals("project_list")) {
			action = new ProjectListAction();
		} else if (command.equals("project_insert")) {
			action = new ProjectInsertAction();
		} else if (command.equals("project_insert_form")) {
			action = new ProjectInsertFormAction(); 
		} else if (command.equals("project_update")) {
			action = new ProjectUpdateAction();
		} else if (command.equals("project_update_form")) {
			action = new ProjectUpdateFormAction();
		} else if (command.equals("project_view_action")) {
			action = new ProjectViewAction();
		} else if (command.equals("project_delete_action")) {
			action = new ProjectDeleteAction();
		} else if (command.equals("project_check_pass")) {
			action = new ProjectCheckPassAction();
		} else if (command.equals("project_check_pass_form")) {
			action = new ProjectCheckPassFormAction();
		}
		
		if (command.equals("croject_list")) {
			action = new CrojectListAction();
		} else if (command.equals("croject_insert")) {
			action = new CrojectInsertAction();
		} else if (command.equals("croject_insert_form")) {
			action = new CrojectInsertFormAction();
		} else if (command.equals("croject_update")) {
			action = new CrojectUpdateAction();
		} else if (command.equals("croject_update_form")) {
			action = new CrojectUpdateFormAction();
		} else if (command.equals("croject_view_action")) {
			action = new CrojectViewAction();
		} else if (command.equals("croject_delete_action")) {
			action = new CrojectDeleteAction();
		} else if (command.equals("project_check_pass")) {
			action = new ProjectCheckPassAction();
		} else if (command.equals("project_check_pass_form")) {
			action = new ProjectCheckPassFormAction();
		}
		return action;
	}
}
