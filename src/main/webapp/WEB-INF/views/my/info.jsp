<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资料设置 - TOP</title>

<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon"
  rel="icon" />
<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon"
  rel="shortcut icon" />

<!-- meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">

</head>
<body id="home" class="notes-index">
  <jsp:include page="../HEADER.jsp" />

  <div class="content row cf">
    <div class="forms">
      <form accept-charset="UTF-8" action="${root}/my/info/modify"
        class="simple_form settings-profile"
        enctype="multipart/form-data" id="edit_user" method="post"
        role="form">
        <h2>修改个人信息</h2>
        <input id="ok_url" name="ok_url" type="hidden" value="/posts" />
        <div class="form-group string required user_nickname">
          <label class="string required" for="user_nickname">昵称</label><input
            aria-required="true"
            class="string required form-control input-small"
            id="nickName" name="nickName" required="required"
            type="text" value="${user.nickName}" />
        </div>
        <div class="form-group file optional user_avatar">
          <label class="file optional" for="user_avatar">头像</label>
          <div class="avatar-wrapper cf ">
            <img alt="2e319c99 9ca7 4576 bb10 28bde38c9084"
              src="https://rs-images.b0.upaiyun.com/uploads/user/avatar/39627/2e319c99-9ca7-4576-bb10-28bde38c9084.jpg!50x50" />
            <input class="upload" id="user_avatar" name="user[avatar]"
              type="file" />
          </div>
          <div class="checkbox">
            <input name="user[wechat_avatar_as_default]" type="hidden"
              value="0" /><input class="boolean optional form-control"
              id="user_wechat_avatar_as_default"
              name="user[wechat_avatar_as_default]" type="checkbox"
              value="1" /> 优先使用微信头像
          </div>
        </div>
        <div class="form-group text required user_tagline">
          <label class="text required" for="user_tagline">一句话简介</label>
          <textarea aria-required="true"
            class="text required form-control input-big"
            id="memo" name="memo" required="required">${user.memo}</textarea>
        </div>

        <div class="form-group string required user_organization">
          <label class="string required" for="user_organization">组织</label><input
            aria-required="true"
            class="string required form-control input-small"
            id="userGroup" name="userGroup"
            required="required" type="text" value="${user.userGroup}" />
        </div>
        <div class="form-group string required user_job_title">
          <label class="string required" for="user_job_title">职位</label><input
            aria-required="true"
            class="string required form-control input-small"
            id="position" name="position"
            required="required" type="text" value="${user.position}" />
        </div>
        <button name='submit' value="profile" class="btn submit">更新设置</button>
      </form>
      <hr>
      <form accept-charset="UTF-8" action="${root}/my/info/password"
        class="simple_form settings-password" id="edit_user"
        method="post">
        <div style="display: none">
          <input name="utf8" type="hidden" value="&#x2713;" /><input
            name="_method" type="hidden" value="put" /><input
            name="authenticity_token" type="hidden"
            value="tn/vd/0/G9bFCz1r8mzZJ57Z4MmZ7VdzfbAn3Ne7d88=" />
        </div>
        <h2>修改密码</h2>
        <input id="ok_url" name="ok_url" type="hidden" value="/posts" />
        <div class="form-group email optional disabled user_email">
          <label class="email optional" for="user_email">邮箱</label><input
            class="string email optional disabled form-control input-small"
            disabled="disabled" id="user_email" name="user[email]"
            placeholder="邮箱" type="email" value="${user.loginEmail}" />
        </div>
        <div class="form-group password optional user_password">
          <label class="password optional" for="user_password">密码</label><input
            class="password optional form-control input-small"
            id="password1" name="password1" type="password" />
          <p class="help-block">不更改密码请留空</p>
        </div>
        <div
          class="form-group password optional user_password_confirmation">
          <label class="password optional"
            for="user_password_confirmation">确认密码</label><input
            class="password optional form-control input-small"
            id="password2" name="password2" type="password" />
        </div>
        <div class="form-group password required user_current_password">
          <label class="password required" for="user_current_password">当前密码</label><input
            aria-required="true"
            class="password required form-control input-small"
            id="password" name="password"
            required="required" type="password" />
          <p class="help-block">更新以上信息，请输入密码</p>
        </div>

        <button name='submit' value="password" , class="btn submit">修改密码</button>
      </form>
    </div>

    <aside class="aside">
      <h4>如何解绑微信帐号</h4>
      <br>
      <ul class="aside-tips">
        <li>1.微信中发送[解除绑定]</li>
        <li>2.根据流程解除绑定</li>
      </ul>
    </aside>

  </div>

  <jsp:include page="../FOOTER.jsp" />
</body>
</html>