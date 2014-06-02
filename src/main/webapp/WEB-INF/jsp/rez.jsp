<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${manager.title}</title>
	</head>
	
	<body>
		RESULTS
		<form method="post">
			<c:forEach items="${manager.messages}" var="messageObj">
				<div>
					<b>${messageObj.userName}</b> : ${messageObj.userMessage} (time - ${messageObj.createTime})
				</div>
			</c:forEach>
			
			<input name="sortByName" type="submit" value="sortByName">
			<input name="sortByTime" type="submit" value="sortByTime">
		</form>
	</body>
</html>