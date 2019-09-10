<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, project.*" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eun travel</title>
<link href="/wepapp/boot/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/wepapp/boot/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="/wepapp/boot/css/E.css">
</head>
<body>
<%@ include file="header.jsp" %>
<c:choose>
<c:when test="${indexsize==0 }">
<h1>등록된 축제가 없습니다</h1>
</c:when>
<c:otherwise>
<c:forEach items="${indexlist}" var="item">
      <div class="carousel-inner">
        <div class="item active">
          <img src="/wepapp/boot/img/${item.image }" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1 style="color: #FFFFFF">${item.subject }</h1>
              <p class="lead">${item.content }</p>
            </div>
          </div>
        </div>
      </c:forEach>
      </c:otherwise>
      </c:choose>
     <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>