<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${manager.title}</title>
	</head>
	
	<body>
		
		<c:choose>
			<c:when test="${manager.sended}">
				Message sended!
			</c:when>
			<c:otherwise>
				Please, send new message!
			</c:otherwise>
		</c:choose>
		
		<form action="#" method="post">
		    Name <input type="text" name="nameField">
		    Mesage <input type="text" name="msgField">
		    
		    <input name="sendMsg" type="submit">
	  	</form>
	  	
	  	<a href="/rez">go to page with messages...</a>
	</body>
</html>