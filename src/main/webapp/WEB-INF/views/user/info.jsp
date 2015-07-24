<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人设置 - TOP</title>

<!-- meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">

<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="icon" />
<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="shortcut icon" />

</head>
<body id="home" class="notes-index">
  <div class="container">
    <jsp:include page="../HEADER.jsp" />
    <div class="content row cf">
      <div class="forms">
        <form accept-charset="UTF-8" action="${root}/register/doRegister"
          class="simple_form form" id="new_user" method="post">
          个人设置
        </form>
      </div>

      <aside class="aside">
        <h4>微信扫一扫：立即登录、快速注册～</h4>
        <img
          src="http://next.36kr.com/users/sign_in_qrcode?t=1435142215.894246"
          alt="微信二维码" id="sign_in_qrcode_image" width="160" height="160"
          data-ok-url="/posts">
        <ul class="aside-tips">
          <li>1.微信授权仅用于获取昵称和头像信息</li>
          <li>2.定制关注和订阅，个性化内容和动态提醒</li>
          <li>3.定向推送最新产品信息，还有更多…</li>
        </ul>
      </aside>

    </div>
  </div>

  <jsp:include page="../FOOTER.jsp" />

</body>
</html>