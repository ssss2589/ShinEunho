<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<c:if test="${size == 0 }">
{"info":[{"msg":"로그인 실패"}]}
</c:if>
 <c:if test="${size == 1 }">
 {"info":[{"msg":"로그인 성공","name":"${mem.name }"}]}
</c:if>