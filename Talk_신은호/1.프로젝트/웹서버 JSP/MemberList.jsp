<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
${protocol}
<%-- {"info":[{"member":[
<c:forEach items="${memberList}" var="mem" varStatus="i">
{"id":"${mem.id}","pw":"${mem.pw}","name":"${mem.name}"}<c:if test="${i.last eq false}">,</c:if></c:forEach>
<c:if test="${size ne 0}">
]},{"friend":[
<c:forEach items="${FriendList}" var="fri" varStatus="j">
{"${fri.mid}":"${fri.fid}<c:if test="${j.last eq false}">.</c:if></c:forEach>
"}]}]}
</c:if>
<c:if test="${size eq 0}">
]}]}
</c:if> --%>
