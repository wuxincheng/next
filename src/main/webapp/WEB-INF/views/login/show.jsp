<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<!-- saved from url=(0050)http://next.36kr.com/users/sign_in?ok_url=%2Fposts -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录 - NEXT</title>
<link data-turbolinks-track="true" href="${root}/assets/css/application.css" media="all" rel="stylesheet">
<script async="" src="http://www.google-analytics.com/analytics.js"></script>
<script data-turbolinks-track="true" src="${root}/assets/js/application.js"></script>

<!-- meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<link rel="shortcut icon" href="http://next.36kr.com/favicon.ico">

<!-- info -->
<meta name="author" content="36Kr">
<meta name="description" content="登录 - NEXT">
<meta name="keywords" content="NEXT，新产品，创业，互联网产品，Startup">
<link rel="author" href="http://next.36kr.com/humans.txt">

<!--iOS -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-title" content="Title">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">

<!-- iOS Icons -->
<link rel="apple-touch-icon-precomposed"
	href="https://rs-assets.b0.upaiyun.com/assets/apple-touch-icon-57x57-precomposed-2fd5ce12b9af673bd9df9f6814cb3bf6.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="https://rs-assets.b0.upaiyun.com/assets/apple-touch-icon-72x72-precomposed-0133d9588b514668a844dace5386edab.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="https://rs-assets.b0.upaiyun.com/assets/apple-touch-icon-114x114-precomposed-25ce253a44714d950906df1f51b5d76f.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="https://rs-assets.b0.upaiyun.com/assets/apple-touch-icon-144x144-precomposed-1f35bb75f6aadd07750e73a4ba893f8b.png">
<link rel="apple-touch-icon-precomposed" sizes="180x180"
	href="https://rs-assets.b0.upaiyun.com/assets/apple-touch-icon-180x180-precomposed-97d0466995f859705d4166fa27f84643.png">

<!-- Prefetch -->
<link rel="dns-prefetch" href="http://fonts.googleapis.com/">
<link rel="dns-prefetch" href="http://google-analytics.com/">
<link rel="dns-prefetch" href="http://www.google-analytics.com/">
<link rel="dns-prefetch" href="http://platform.twitter.com/">

<meta property="og:type" content="webpage">



<meta content="authenticity_token" name="csrf-param">
<meta content="+pyNg3ggt3L/IZk4ood3x5j18ChulGazM+BKMuOT/ks="
	name="csrf-token">

</head>
<body class="">
	<!--[if lt IE 9]>
  <div class="for-ie-suckers">
    <div class="row">
      <b>36<del>0</del>氪安全卫士提醒您：</b>您的 IE 浏览器不被支持。试试其他的：<a href="http://www.google.com/chrome">Google 浏览器</a>、<a href="http://firefox.com.cn/">火狐浏览器</a>、<a href="http://www.apple.com.cn/safari/">Safari</a>
    </div>
  </div>
<![endif]-->

	<div class="container">
		<header class="topbar cf">
			<h1 class="brand">
				<a href="http://next.36kr.com/" class="logo" id="logo">NEXT</a> <span
					class="slogan">不错过任何一个新产品</span>
			</h1>
			<nav class="navigation text-center">
				<ul>
					<li><a class="main-nav "
						href="http://next.36kr.com/posts/collections">产品集</a></li>
					<li><a class="main-nav " href="http://next.36kr.com/about">FAQ</a></li>
				</ul>
			</nav>
		</header>



		<div class="content row cf">



			<div class="forms">
				<form accept-charset="UTF-8"
					action="./登录 - NEXT_files/登录 - NEXT.html"
					class="simple_form new_user" id="new_user" method="post"
					role="form">
					<div style="display: none">
						<input name="utf8" type="hidden" value="✓"><input
							name="authenticity_token" type="hidden"
							value="+pyNg3ggt3L/IZk4ood3x5j18ChulGazM+BKMuOT/ks=">
					</div>
					<span class="error "> </span>
					<div class="form-group email required user_email">
						<input aria-required="true"
							class="string email required form-control input-small"
							id="user_email" name="user[email]" placeholder="邮箱"
							required="required" type="email" value="">
					</div>
					<div class="form-group password required user_password">
						<input aria-required="true"
							class="password required form-control input-small"
							id="user_password" name="user[password]" placeholder="密码"
							required="required" type="password">
					</div>
					<button class="btn submit" name="button" type="submit">登录</button>

					<hr>


					<a href="http://next.36kr.com/users/sign_up">注册</a><br> <a
						href="http://next.36kr.com/users/password/new">忘记密码?</a><br>

					<a href="http://next.36kr.com/users/confirmation/new">没有收到验证邮件?</a><br>



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

	<footer class="footer">
		<div class="subscribe-email row text-center">
			<h3>您也可以通过电子邮件订阅每周的更新，不错过任何一个好产品</h3>
			<p>我们不会公开您的邮箱，您可以随时取消订阅</p>
			<form accept-charset="UTF-8"
				action="http://next.36kr.com/subscriptions"
				class="simple_form form-email" id="mc-embedded-subscribe-form"
				method="post">
				<div style="display: none">
					<input name="utf8" type="hidden" value="✓"><input
						name="authenticity_token" type="hidden"
						value="+pyNg3ggt3L/IZk4ood3x5j18ChulGazM+BKMuOT/ks=">
				</div>
				<input class="input-email" id="subscription_email"
					name="subscription[email]" placeholder="输入您的邮箱" required="required"
					type="email"> <input class="input-subscribe btn"
					name="commit" type="submit" value="订阅">
			</form>
		</div>
		<div class="row cf">
			<div class="copyright">
				<p>
					© 2014-2015 <strong>NEXT</strong>. All Rights Reserved. A <a
						href="http://www.36kr.com/">36Kr</a> product.
				</p>
				<p class="">
					上 NEXT，每天刷新更酷的生活方式。查看 <a href="http://next.36kr.com/about">FAQ</a>
					/ <a href="http://next.36kr.com/feedback">反馈建议</a>
				</p>
			</div>

			<div class="footer-follow">
				<ul class="cf">
					<li><a class="icons-weibo" href="http://weibo.com/36krnext"
						title="Weibo" target="_blank">Weibo</a></li>
					<li><a class="icons-twitter"
						href="https://twitter.com/36krNEXT" title="Twitter"
						target="_blank">Twitter</a></li>
					<li><a class="icons-blog"
						href="http://zhuanlan.zhihu.com/NEXTBlog" title="博客"
						target="_blank">博客</a></li>
					<li><a class="icons-rss" href="http://next.36kr.com/feed"
						title="RSS 订阅" target="_blank">RSS Feed</a></li>
				</ul>
			</div>
		</div>

		<script>
			(function(i, s, o, g, r, a, m) {
				i['GoogleAnalyticsObject'] = r;
				i[r] = i[r] || function() {
					(i[r].q = i[r].q || []).push(arguments)
				}, i[r].l = 1 * new Date();
				a = s.createElement(o), m = s.getElementsByTagName(o)[0];
				a.async = 1;
				a.src = g;
				m.parentNode.insertBefore(a, m)
			})(window, document, 'script',
					'//www.google-analytics.com/analytics.js', 'ga');
			ga('create', 'UA-1268479-18', {
				'userId' : '0'
			});
			window.ga_user_id = '0'
		</script>
		<div id="Intercom" class="hide"></div>
		<script data-turbolinks-track="true" src="./登录 - NEXT_files/faye.js"></script>
	</footer>
	<a href="javascript:" class="back-top"
		title="更多快捷键:
  j: 下翻页,
  k: 上翻页,
  f: 搜索,
  t: 返回顶部
您还可以按下键盘空格键自动翻页">返回顶部</a>

</body>
</html>