package com.project.staff.controller;

import com.project.common.Action;
import com.project.common.ActionUpload;
import com.project.staff.action.careerDeleteAction;
import com.project.staff.action.careerInsertAction;
import com.project.staff.action.careerListAction;
import com.project.staff.action.degreeDeleteAction;
import com.project.staff.action.degreeInsertAction;
import com.project.staff.action.degreeListAction;
import com.project.staff.action.licenseDeleteAction;
import com.project.staff.action.licenseInsertAction;
import com.project.staff.action.licenseListAction;
import com.project.staff.action.staffInsertAction;
import com.project.staff.action.staffInsertFormAction;
import com.project.staff.action.staffListAction;
import com.project.staff.action.staffUpdateAction;
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
		else if(command.equals("staffUpdate")){
			action = new staffUpdateAction();
		}
		else if(command.equals("licenseList")){
			action = new licenseListAction();
		}
		else if(command.equals("licenseInsertAction")){
			action = new licenseInsertAction();
		}
		else if(command.equals("licenseDeleteAction")){
			action = new licenseDeleteAction();
		}
		else if(command.equals("degreeList")){
			action = new degreeListAction();
		}
		else if(command.equals("degreeInsertAction")){
			action = new degreeInsertAction();
		}
		else if(command.equals("degreeDeleteAction")){
			action = new degreeDeleteAction();
		}
		else if(command.equals("careerList")){
			action = new careerListAction();
		}
		else if(command.equals("careerInsertAction")){
			action = new careerInsertAction();
		}
		else if(command.equals("careerDeleteAction")){
			action = new careerDeleteAction();
		}
		return action;
	}
	public ActionUpload getActionUpload(String command){
		ActionUpload actionUpload=null;
		System.out.println("ActionFactory:"+command);
		if(command.equals("staffInsert")){
			actionUpload = (ActionUpload) new staffInsertAction();
		}
		return actionUpload;
	}
}
