<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册 - TOP</title>

<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="icon" />
<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="shortcut icon" />

<!-- meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">

</head>
<body id="home" class="notes-index">
  <jsp:include page="HEADER.jsp" />
  
  <div class="container">
    <div class="subcontent login-row cf">
      <div class="forms login-box">
        <form accept-charset="UTF-8" action="${root}/register/doRegister" class="simple_form form" id="new_user" method="post">
          <div style="display: none">
            <input name="utf8" type="hidden" value="&#x2713;" />
            <input name="authenticity_token" type="hidden" value="yXHXPCuoke25kYrOhAbhrrdplZICg6L01fjRe3X6+Q4=" />
          </div>
          <div class="form-group email optional user_email">
            <label class="email optional" for="loginEmail">邮箱</label>
            <input class="string email optional form-control input-small" id="loginEmail" name="loginEmail"
              placeholder="name@your_company.com" type="email" value="" maxlength="50" />
          </div>
          <div class="form-group password required user_password">
            <label class="password required" for="password">密码</label>
            <input aria-required="true" class="password required form-control input-small" maxlength="50"
              id="password" name="password" placeholder="密码" required="required" type="password" />
          </div>
          <div class="form-group password required user_password">
            <label class="password required" for="password">重新输入密码</label>
            <input aria-required="true" class="password required form-control input-small" maxlength="50"
              id="password2" name="password2" placeholder="重新输入密码" required="required" type="password" />
          </div>
          <input class="btn submit" name="commit" type="submit" value="完成注册" />
          &nbsp;&nbsp;
          <a href="${root}/login/">我已注册，立即登录</a>
          <p>&nbsp;</p><p>&nbsp;</p>
        </form>
      </div>
    </div>
  </div>

  <jsp:include page="FOOTER.jsp" />
</body>
</html>