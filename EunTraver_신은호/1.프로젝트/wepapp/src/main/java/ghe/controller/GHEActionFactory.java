package ghe.controller;

import gheAction.GHEAction;
import gheAction.IndexFormAction;
import gheAction.JoinAction;
import gheAction.LoginAction;
import gheAction.LogoutAction;

public class GHEActionFactory {
	private static GHEActionFactory instance = new GHEActionFactory();
	public static GHEActionFactory getInstance() {
		return instance;
	}
	
	public GHEAction getAction(String command) {
		GHEAction action =null;
		if(command.equals("join")) {
			action = new JoinAction();
		}else if(command.equals("login")) {
			action = new LoginAction();
		}else if(command.equals("index")) {
			action = new IndexFormAction();
		}else if(command.equals("logout")) {
			action = new LogoutAction();
		}
		return action;
	}
}
