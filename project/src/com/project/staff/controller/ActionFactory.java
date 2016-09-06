package com.project.staff.controller;

import com.project.common.Action;
import com.project.common.ActionUpload;
import com.project.staff.action.addrListAction;
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
		
		if(command.equals("staff_list")){
			action= new staffListAction();
		}
		else if(command.equals("staff_insert_form")){
			action = new staffInsertFormAction();
		}
		else if(command.equals("staff_view")){
			action = new staffViewAction();
		}
		else if(command.equals("staff_update_form")){
			action = new staffUpdateFormAction();
		}
		else if(command.equals("staff_update")){
			action = new staffUpdateAction();
		}
		else if(command.equals("license_list")){
			action = new licenseListAction();
		}
		else if(command.equals("license_insert_action")){
			action = new licenseInsertAction();
		}
		else if(command.equals("license_delete_action")){
			action = new licenseDeleteAction();
		}
		else if(command.equals("degree_list")){
			action = new degreeListAction();
		}
		else if(command.equals("degree_insert_action")){
			action = new degreeInsertAction();
		}
		else if(command.equals("degree_delete_action")){
			action = new degreeDeleteAction();
		}
		else if(command.equals("career_list")){
			action = new careerListAction();
		}
		else if(command.equals("career_insert_action")){
			action = new careerInsertAction();
		}
		else if(command.equals("career_delete_action")){
			action = new careerDeleteAction();
		}
		else if (command.equals("addr_insert")){
			action = new addrListAction();
		}
		return action;
	}
	public ActionUpload getActionUpload(String command){
		ActionUpload actionUpload=null;
		System.out.println("ActionFactory:"+command);
		if(command.equals("staff_insert")){
			actionUpload = new staffInsertAction();
		} 
		
		return actionUpload;
	}
}
