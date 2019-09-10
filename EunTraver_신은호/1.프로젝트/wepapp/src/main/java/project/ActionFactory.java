package project;

import project.action.Action;
import project.action.AdminComDeleteAction;
import project.action.AdminDeleteAction;
import project.action.AdminIndexDetailAction;
import project.action.AdminInquiryAction;
import project.action.AdminLoginAction;
import project.action.AdminLoginFormAction;
import project.action.AdminMainAction;
import project.action.AdminMemberAction;
import project.action.AdminMemberDetailAction;
import project.action.AdminQnaDetailAction;
import project.action.AdminQnaReplyAction;
import project.action.ApiExplorer;
import project.action.BusDataForm;
import project.action.ComDeleteAction;
import project.action.CorrectionAction;
import project.action.CorrectionFormAction;
import project.action.FindZipNumAction;
import project.action.FreeDeleteAction;
import project.action.FreeDetailAction;
import project.action.FreeListAction;
import project.action.FreePlusAction;
import project.action.GoodPlusAction;
import project.action.IndexAction;
import project.action.IndexAdminAction;
import project.action.IndexAdminDeleteAction;
import project.action.IndexAdminWriteAction;
import project.action.IndexAdminWriteGoAction;
import project.action.InquiryAction;
import project.action.InquiryDeleteAction;
import project.action.InquiryDetailAction;
import project.action.InquiryWriteAction;
import project.action.JoinAction;
import project.action.JoinFormAction;
import project.action.LoginAction;
import project.action.LogoutAction;
import project.action.MemberDataAction;
import project.action.MemberDeleteAction;
import project.action.MemberResetAction;
import project.action.MyWritingAction;
import project.action.VisitDataAction;
import project.action.VisitDataFormAction;
import project.action.loginFormAction;

// 사용자 요청에 대해서 동적 페이지 등등 분기시키는 것
public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
	 if(command.equals("index")){
		 	action = new IndexAction();
	 }else if(command.equals("bus_GoSearch")) {
			action = new ApiExplorer();
	 }else if(command.equals("busData_Form")) {
		 	action = new BusDataForm();
	 }else if(command.equals("login_Form")) {
		 	action = new loginFormAction();
	 }else if(command.equals("join_Form")) {
		 action = new JoinFormAction();
	 }else if(command.equals("find_zip_num")) {
		 action = new FindZipNumAction();
	 }else if(command.equals("join")) {
		 action = new JoinAction();
	 }else if(command.equals("login")) {
		 action = new LoginAction();
	 }else if(command.equals("logout")) {
		 action = new LogoutAction();
	 }else if(command.equals("visitdata_Form")) {
		 action = new VisitDataFormAction();
	 }else if(command.equals("visitData")) {
		 action = new VisitDataAction();
	 }else if(command.equals("freePlus")) {
		 action = new FreePlusAction();
	 }else if(command.equals("freeList")) {
		 action = new FreeListAction();
	 }else if(command.equals("freeDetail")) {
		 action = new FreeDetailAction();
	 }else if(command.equals("good")) {
		 action = new GoodPlusAction();
	 }else if(command.equals("inquiry")) {
		 action = new InquiryAction();
	 }else if(command.equals("inquiryWrite")) {
		 action = new InquiryWriteAction();
	 }else if(command.equals("inquiryDetail")) {
		 action = new InquiryDetailAction();
	 }else if(command.equals("in_delete")) {
		 action = new InquiryDeleteAction();
	 }else if(command.equals("mypage")) {
		 action = new MemberDataAction();
	 }else if(command.equals("MemReset")) {
		 action = new MemberResetAction();
	 }else if(command.equals("mywrite")) {
		 action = new MyWritingAction();
	 }else if(command.equals("free_delete")) {
		 action = new FreeDeleteAction();
	 }else if(command.equals("com_delete")) {
		 action = new ComDeleteAction();
	 }else if(command.equals("correction")) {
		 action = new CorrectionFormAction();
	 }else if(command.equals("free_correction")) {
		 action = new CorrectionAction();
	 }else if(command.equals("admin_login_Form")) {
		 action = new AdminLoginFormAction();
	 }else if(command.equals("adminLogin")) {
		 action = new AdminLoginAction();
	 }else if(command.equals("adminMain")) {
		 action = new AdminMainAction();
	 }else if(command.equals("admin_com_delete")) {
		 action = new AdminComDeleteAction();
	 }else if(command.equals("admin_inquiry")) {
		 action = new AdminInquiryAction();
	 }else if(command.equals("admin_QnaDetail")) {
		 action = new AdminQnaDetailAction();
	 }else if(command.equals("admin_Qna_Reply")) {
			action = new AdminQnaReplyAction();
	 }else if(command.equals("admin_Member")) {
			action = new AdminMemberAction();
	 }else if(command.equals("admin_Member_Delete")) {
			action = new AdminDeleteAction();
	 }else if(command.equals("Member_Delete")) {
			action = new MemberDeleteAction();
	 }else if(command.equals("admin_MemberDetail")) {
			action = new AdminMemberDetailAction();
	 }else if(command.equals("IndexAdmin")) {
			action = new IndexAdminAction();
	 }else if(command.equals("IndexAdminWrite")) {
			action = new IndexAdminWriteAction();
	 }else if(command.equals("IndexAdminWrite_Go")) {
			action = new IndexAdminWriteGoAction();
	 }else if(command.equals("IndexAdmin_Delete")) {
			action = new IndexAdminDeleteAction();
	 }else if(command.equals("adminIndexDetail")) {
			action = new AdminIndexDetailAction();
	 }
		return action;
	}
}
