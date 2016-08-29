package com.project.notice.controller;

import com.project.controller.action.Action;
import com.project.controller.action.NoticeCheckPassAction;
import com.project.controller.action.NoticeCheckPassFormAction;
import com.project.controller.action.NoticeDeleteAction;
import com.project.controller.action.NoticeListAction;
import com.project.controller.action.NoticeUpdateAction;
import com.project.controller.action.NoticeUpdateFormAction;
import com.project.controller.action.NoticeViewAction;
import com.project.controller.action.NoticeWriteAction;
import com.project.controller.action.NoticeWriteFormAction;

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
		
		if(command.equals("notice_list")){
			action= new NoticeListAction();
		}
		else if(command.equals("notice_write_form")){
			action=new NoticeWriteFormAction();
		}
		else if(command.equals("notice_write")){
			action= new NoticeWriteAction();
		}
		else if(command.equals("notice_view")){
			action= new NoticeViewAction();
		}
		else if(command.equals("notice_check_pass_form")){
			action= new NoticeCheckPassFormAction();
		}
		else if(command.equals("notice_check_pass")){
			action= new NoticeCheckPassAction();
		}
		else if(command.equals("notice_update_form")){
			action= new NoticeUpdateFormAction();
		}
		else if(command.equals("notice_upadate")){
			action = new NoticeUpdateAction();
		}
		else if(command.equals("notice_delete")){
			action = new NoticeDeleteAction();
		}
		return action;
	}
}
