<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的主页 - NEXT</title>

<!-- meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">

</head>
<body id="home" class="notes-index">
  <div class="container">
    <jsp:include page="../HEADER.jsp" />
    <div class="content row cf">
      我的主页
    </div>
  </div>

  <jsp:include page="../FOOTER.jsp" />

</body>
</html>