<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav id="sub_menu">
	 <ul>
        <li>
          <a href="NonageServlet?command=admin_ItemList">상품리스트</a>
        </li>  
        <li>
          <a href="NonageServlet?command=admin_orderList&id= ">주문리스트</a>
        </li>  
        <li>
          <a href="NonageServlet?command=admin_memberList">회원리스트</a>
        </li> 
        <li>
          <a href="NonageServlet?command=admin_qnaList">Q&A리스트</a>
        </li>
      </ul>
</nav>
</body>
</html>