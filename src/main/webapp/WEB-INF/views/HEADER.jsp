<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<!-- saved from url=(0026)http://next.36kr.com/posts -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TOP | 找到你喜欢的理财产品</title>
<link data-turbolinks-track="true" href="${root}/assets/css/application.css" media="all" rel="stylesheet">
<script async="" src="http://www.google-analytics.com/analytics.js"></script>
<script data-turbolinks-track="true" src="${root}/assets/js/application.js"></script>

<!-- meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">

<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="icon" />
<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="shortcut icon" />

<!-- info -->
<meta name="author" content="36Kr">
<meta name="description" content="NEXT - 找到你喜欢的理财产品">
<meta name="keywords" content="NEXT，新产品，创业，互联网产品，Startup">
<link rel="author" href="http://next.36kr.com/humans.txt">

<!--iOS -->
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
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
<meta content="+pyNg3ggt3L/IZk4ood3x5j18ChulGazM+BKMuOT/ks=" name="csrf-token">
<link href="http://next.36kr.com/feed" rel="alternate" title="ATOM" type="application/atom+xml">
</head>
<body id="home" class="notes-index">
  <!--[if lt IE 9]>
  <div class="for-ie-suckers">
    <div class="row">
      <b>36<del>0</del>TOP安全卫士提醒您：</b>您的 IE 浏览器不被支持。试试其他的：
      <a href="http://www.google.com/chrome">Google 浏览器</a>、
      <a href="http://firefox.com.cn/">火狐浏览器</a>、
      <a href="http://www.apple.com.cn/safari/">Safari</a>
    </div>
  </div>
<![endif]-->

  <header class="topbar cf">
    <h1 class="brand">
      <a href="${root}/product/list" class="logo" id="logo">TOP</a> <span class="slogan">找到你喜欢的理财产品</span>
    </h1>
    <nav class="navigation text-center">
      <ul>
        <!-- 
        <li><a class="main-nav " href="http://www.zhuanlemei.com" target="_blank">赚了没</a></li>
        <li><a class="main-nav " href="http://www.zhuanlemei.com/news" target="_blank">咖啡日报</a></li>
         -->
        <li><a class="main-nav " href="${root}/collect/list">产品集</a></li>
        
        <c:choose>
        <c:when test="${not empty user}">
        <li class="account login-menu">
          <a class="account-menu main-nav" href="javascript:">
            <c:choose>
            <c:when test="${not empty user.socialPicPath}">
            <img class="avatar" height="30" src="${user.socialPicPath}" width="30" />
            </c:when>
            <c:otherwise>
            <img class="avatar" height="30" src="${root}/assets/img/logo/toplogo.png" width="30" />
            </c:otherwise>
            </c:choose>
          </a>
          <ul class="dropdown login-dropdown">
            <!-- 
            <li><a href="${root}/user/main">我的主页</a></li>
            <li><a href="${root}/user/collect">我的收藏</a></li>
            <li><a href="${root}/user/info">个人设置</a></li>
             -->
            <li><a data-method="delete" href="${root}/logout/" rel="nofollow">退出登录</a></li>
          </ul>
        </li>        
        </c:when>
        <c:otherwise>
        <li class="account login-wechat">
          <a class="login-btn main-nav" href="${root}/login/">登录</a>
        </li> 
        </c:otherwise>
        </c:choose>
      </ul>
    </nav>
  </header>
  
  <c:if test="${not empty success}">
  <div id="msg-alert" class="alert alert-success fade in row" style="margin-top: 30px;">
    <h4>${success}</h4>
  </div>
  </c:if>
  
  <c:if test="${not empty info}">
  <div id="msg-alert" class="alert alert-info fade in row" style="margin-top: 30px;">
    <h4>${info}</h4>
  </div>
  </c:if>

  <c:if test="${not empty warning}">
  <div id="msg-alert" class="alert alert-warning fade in row" style="margin-top: 30px;">
    <h4>${warning}</h4>
  </div>
  </c:if>

  <c:if test="${not empty danger}">
  <div id="msg-alert" class="alert alert-danger fade in row" style="margin-top: 30px;">
    <h4>${danger}</h4>
  </div>
  </c:if>
</body>
</html>