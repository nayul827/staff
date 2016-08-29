package com.project.staff.controller;

import com.project.common.Action;
import com.project.staff.action.staffInsertAction;
import com.project.staff.action.staffInsertFormAction;
import com.project.staff.action.staffListAction;
import com.project.staff.action.staffUpdateFormAction;
import com.project.staff.action.staffViewAction;

public class ActionFactory {
	private static ActionFactory instance= new ActionFactory();
	
	private ActionFactory(){
		super();
	}
	public static ActionFactory getInstance(){
		return instance;
	}
	public Action getAction(String command){
		Action action=null;
		System.out.println("ActionFactory:"+command);
		
		if(command.equals("staffList")){
			action= new staffListAction();
		}
		else if(command.equals("staffInsert")){
			action = new staffInsertAction();
		}
		else if(command.equals("staffInsertForm")){
			action = new staffInsertFormAction();
		}
		else if(command.equals("staffView")){
			action = new staffViewAction();
		}
		else if(command.equals("staffUpdateForm")){
			action = new staffUpdateFormAction();
		}
		return action;
	}
}
