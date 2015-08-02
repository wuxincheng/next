<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录 - TOP</title>

<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="icon" />
<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="shortcut icon" />
<!-- Wechat -->
<script src="http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>
<!-- meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
</head>
<body id="home" class="notes-index">
  <div class="container">
    <jsp:include page="HEADER.jsp" />
    <div class="subcontent login-row cf">
      <div class="forms login-box">
        <form accept-charset="UTF-8" action="${root}/login/doLogin" class="simple_form new_user" id="new_user" method="post" role="form">
          <div style="display: none">
            <input name="utf8" type="hidden" value="✓">
            <input name="authenticity_token" type="hidden" value="+pyNg3ggt3L/IZk4ood3x5j18ChulGazM+BKMuOT/ks=">
          </div>
          <span class="error "> </span>
          <div class="form-group email required user_email">
            <input aria-required="true" class="string email required form-control input-small" maxlength="50"
              id="loginEmail" name="loginEmail" placeholder="邮箱" required="required" type="email" value="">
          </div>
          <div class="form-group password required user_password">
            <input aria-required="true" class="password required form-control input-small" maxlength="50"
              id="password" name="password" placeholder="密码" required="required" type="password">
          </div>
          <button class="btn submit" name="button" type="submit">登录</button>
          &nbsp;&nbsp;
          <a href="${root}/register/">还没有账号，我要注册</a>

          <div class="oauth-panel">
            <ul class="upvote-users cf">
              <li class="product-avatar">
                <div class="user-image"><strong>合作网站账号登录：</strong></div>
              </li>
              <li class="product-avatar">
                <div class="user-image">
                  <a class="user-image-link" href="${root}/oauth/wechat/login">
                    <img src="${root}/assets/img/oauth/icon16_wx_logo.png" />
                  </a>
                </div>
              </li>
              <!-- 
              <li class="product-avatar">
                <div class="user-image">
                  <a class="user-image-link" href="${root}/oauth/qq/login">
                    <img  src="${root}/assets/img/oauth/Connect_logo_1.png" />
                  </a>
                </div>
              </li>
              <li class="product-avatar">
                <div class="user-image">
                  <a class="user-image-link" href="${root}/oauth/weibo/login">
                    <img src="${root}/assets/img/oauth/icon16_weibo_logo.png" />
                  </a>
                </div>
              </li>
               -->
            </ul>
          </div>
          
          <!-- 
          <a href="http://next.36kr.com/users/password/new">忘记密码?</a><br>
          <a href="http://next.36kr.com/users/confirmation/new">没有收到验证邮件?</a><br>
           -->
        </form>
      </div>

      <aside class="aside">
        
      </aside>

    </div>
  </div>

  <jsp:include page="FOOTER.jsp" />

</body>
</html>