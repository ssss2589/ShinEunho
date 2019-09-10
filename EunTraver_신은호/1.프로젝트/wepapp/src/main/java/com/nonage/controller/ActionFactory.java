package com.nonage.controller;

import com.nonage.controller.action.Action;
import com.nonage.controller.action.AdminDetailAction;
import com.nonage.controller.action.AdminItemAction;
import com.nonage.controller.action.AdminItemForm;
import com.nonage.controller.action.AdminItemList;
import com.nonage.controller.action.AdminLogoutAction;
import com.nonage.controller.action.AdminMemberListAction;
import com.nonage.controller.action.AdminOrderListAction;
import com.nonage.controller.action.AdminProductUpdateAction;
import com.nonage.controller.action.AdminProductUpdateFormAction;
import com.nonage.controller.action.AdminQnaDetailAction;
import com.nonage.controller.action.AdminQnaListAction;
import com.nonage.controller.action.AdminQnaWriteAction;
import com.nonage.controller.action.AdminResultSetAction;
import com.nonage.controller.action.AllOrderListAction;
import com.nonage.controller.action.CartDeleteAction;
import com.nonage.controller.action.CartInsertAcrtion;
import com.nonage.controller.action.CartListAction;
import com.nonage.controller.action.ContractAction;
import com.nonage.controller.action.FindZipNumAction;
import com.nonage.controller.action.IdCheckFormAction;
import com.nonage.controller.action.IndexAction;
import com.nonage.controller.action.JoinFormAction;
import com.nonage.controller.action.JoinMemberAction;
import com.nonage.controller.action.LoginAdminAction;
import com.nonage.controller.action.LoginAdminFormAction;
import com.nonage.controller.action.LoginFormAction;
import com.nonage.controller.action.LoginMainFormAction;
import com.nonage.controller.action.LoginMemberAction;
import com.nonage.controller.action.LogoutAction;
import com.nonage.controller.action.MemberDeleteAction;
import com.nonage.controller.action.MyDataAction;
import com.nonage.controller.action.MyPageAction;
import com.nonage.controller.action.OrderInsertAction;
import com.nonage.controller.action.OrderListAction;
import com.nonage.controller.action.OrderListDetailAction;
import com.nonage.controller.action.ProductDetailAction;
import com.nonage.controller.action.ProductKindAction;
import com.nonage.controller.action.ProductSearchAction;
import com.nonage.controller.action.QnaDeleteAction;
import com.nonage.controller.action.QnaListAction;
import com.nonage.controller.action.QnaViewAction;
import com.nonage.controller.action.QnaWriteAction;
import com.nonage.controller.action.QnaWriteFormAction;

import project.action.AdminQnaReplyAction;

// 사용자 요청에 대해서 동적 페이지 등등 분기시키는 것
public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("index")) {
			action = new IndexAction(); // 이 안에서 동적 페이지가 될거에오
		}else if(command.equals("contract")) {
			action = new ContractAction();
		}else if(command.equals("join_form")){
			action = new JoinFormAction();
		}else if(command.equals("join")){
//			action = new JoinAction();
		}else if(command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		}else if(command.equals("find_zip_num")){
			action = new FindZipNumAction();
		}else if(command.equals("joinMember")) {
			action =  new JoinMemberAction();
		}else if(command.equals("login_form")) {
			action = new LoginFormAction();
		}else if(command.equals("loginMember")) {
			action = new LoginMemberAction();
		}else if(command.equals("logout")) {
			action = new LogoutAction();
		}else if(command.equals("catagory")) {
			action = new ProductKindAction();
		}else if(command.equals("detail")) {
			action = new ProductDetailAction();
		}else if(command.equals("cart_list")) {
			action = new CartListAction();
		}else if(command.equals("cart_insert")) {
			action = new CartInsertAcrtion();
		}else if(command.equals("cart_delete")) {
			action = new CartDeleteAction();
		}else if(command.equals("order_insert")) {
			action = new OrderInsertAction();
		}else if(command.equals("mypage")) {
			action= new MyPageAction();
		}else if(command.equals("order_list")) {
			action = new OrderListAction();
		}else if(command.equals("Allorder_list")) {
			action = new AllOrderListAction();
		}else if(command.equals("order_detail")) {
			action = new OrderListDetailAction();
		}else if(command.equals("qna_list")) {
			action = new QnaListAction();
		}else if(command.equals("qna_write_form")) {
			action = new QnaWriteFormAction();
		}else if(command.equals("qna_write")) {
			action = new QnaWriteAction();
		}else if(command.equals("qna_view")) {
			action = new QnaViewAction();
		}else if(command.equals("qna_delete")) {
			action = new QnaDeleteAction();
		}else if(command.equals("loginAdmin")){
			action = new LoginAdminAction();
		}else if(command.equals("admin_login_form")) {
			action = new LoginAdminFormAction();
		}else if(command.equals("adminMain_form")) {
			action = new LoginMainFormAction();
		}else if(command.equals("admin_ItemList")) {
			action = new AdminItemList();
		}else if(command.equals("adminLogout")) {
			action = new AdminLogoutAction();
		}else if(command.equals("Product_Search")) {
			action = new ProductSearchAction();
		}else if(command.equals("admin_Itemplus_form")) {
			action = new AdminItemForm();
		}else if(command.equals("admin_Itemplus")) {
			action = new AdminItemAction();
		}else if(command.equals("admin_ProductDetail")) {
			action = new AdminDetailAction();
		}else if(command.equals("admin_product_update_form")){
			action = new AdminProductUpdateFormAction();
		}else if(command.equals("admin_product_update")){
			action = new AdminProductUpdateAction();
		}else if(command.equals("admin_orderList")) {
			action = new AdminOrderListAction();
		}else if(command.equals("admin_ResultSet")) {
			action = new AdminResultSetAction();
		}else if(command.equals("MyData")) {
			action = new MyDataAction();
		}else if(command.equals("MemberDelete")) {
			action = new MemberDeleteAction();
		}else if(command.equals("admin_memberList")) {
			action = new AdminMemberListAction();
		}else if(command.equals("admin_qnaList")) {
			action = new AdminQnaListAction();
		}else if(command.equals("admin_QnaDetail")) {
			action = new AdminQnaDetailAction();
		}else if(command.equals("admin_QnaDetailche")) {
			action = new AdminQnaDetailAction();
		}else if(command.equals("admin_QnaWrite")) {
			action = new AdminQnaWriteAction();
		}
		return action;
	}
}
