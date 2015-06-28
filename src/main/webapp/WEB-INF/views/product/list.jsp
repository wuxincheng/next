<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hfn" uri="/WEB-INF/hfn.tld"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NEXT | 不错过任何一个新产品</title>

<meta charset="utf-8">
<link rel="shortcut icon" href="http://next.36kr.com/favicon.ico">

<meta name="author" content="36Kr">
<meta name="description" content="NEXT - 不错过任何一个新产品">
<meta name="keywords" content="NEXT，新产品，创业，互联网产品，Startup">
<link rel="author" href="http://next.36kr.com/humans.txt">

</head>
<body id="home" class="notes-index">
  <div class="container">

    <jsp:include page="../HEADER.jsp" />

    <div class="content row ">
      <section class="main-header cf">
        <a class="btn submit-btn right" href="${root}/product/postUI">分享新产品</a>
      </section>

      <c:choose>
      <c:when test="${not empty pager.productMapList}">
      <c:forEach items="${pager.productMapList}" var="productMap">
      <c:forEach items="${productMap}" var="map">
      <section class="post">
        <div class="date row">
          <span class="cal"> <i class="month">${hfn:engMonth(map.key)}</i> <i class="day">${hfn:simpleDay(map.key)}</i>
          </span> <small>${hfn:monthDay(map.key)}，${hfn:weekday(map.key)}</small>
        </div>
        <ul>
          <c:forEach items="${map.value}" var="obj">
          <li class="product-item ">
            <div class="posts-group cf">
              <div class="upvote ">
                <a class="upvote-link vote-up"
                  href="http://next.36kr.com/users/sign_in?ok_url=%2Fposts"> <i
                  class="upvote-arrow"></i> <span class="vote-count">75</span>
                </a>
              </div>

              <div class="product-url">
                <a class="post-url" data-client="null" href="${obj.prodUrl}"
                  ref="nofollow" target="_blank" title="html-js.com">${obj.prodName}</a> <br> <span
                  class="post-tagline">${obj.memo}</span>
              </div>
              <ul class="product-meta right">
                <li class="product-mark">
                  <div class="mark" title="二十一点睡前故事 的团队成员已经入驻 NEXT，你的评论反馈会被关注和回复">
                    <i class="marks mark-founder"></i>
                  </div>
                </li>

                <li class="product-mark">
                  <div class="mark" title="二十一点睡前故事 适用于 iOS 平台">
                    <i class="marks mark-ios"></i>
                  </div>
                </li>

                <li class="product-avatar">
                  <div class="user-image">
                    <a class="user-image-link" href="http://next.36kr.com/users/6322"> <img
                      alt="806c1ab9 5ac2 497f aa03 f44fd3b0a56e" class="avatar" height="60"
                      src="${root}/assets/images/mock/806c1ab9-5ac2-497f-aa03-f44fd3b0a56e.png!50x50"
                      width="60">
                    </a>
                  </div>

                  <div class="user-tooltip">
                    <a class="user-image-link" href="http://next.36kr.com/users/6322"> <img
                      alt="806c1ab9 5ac2 497f aa03 f44fd3b0a56e" class="avatar avatar-big"
                      height="120"
                      src="${root}/assets/images/mock/806c1ab9-5ac2-497f-aa03-f44fd3b0a56e.png!160x160"
                      width="120">
                    </a>
                    <h3 class="user-nickname">芋头君</h3>
                    <h4 class="user-title">
                      颜文字输入法 - 创始人<br>
                    </h4>
                    <p class="user-bio">颜文字输入法独立开发者。大搜车前端团队负责人，前端乱炖社区创始人。</p>
                  </div>

                  <div class="product-comment">
                    <a class="product-comments" href="http://next.36kr.com/posts/14782#comments"
                      target="_blank"> 9 </a>
                  </div>
                </li>
              </ul>
            </div> <a class="product-link" href="${root}/product/detail?prodid=${obj.prodid}" target="_blank"></a>
          </li>
          </c:forEach>
        </ul>
        
        <!-- 
        <div class="showmore text-center">
          <a href="javascript:void(0)">展开其余 29 个产品</a>
        </div>
         -->
      </section>
      <section class="featured cf">
        <a class="featured-item" href="http://next.36kr.com/posts/collections/273"
          style="background-image: url(https://rs-images.b0.upaiyun.com/uploads/note_collection/feature_image/273/33bd3c7c-0ef5-49df-8aee-108ad05bad6d.jpg!800x800)"
          target="_blank">
          <div class="featured-meta">
            <h3>私人助理应用</h3>
            <p>歪国人是怎样玩转私人助理应用的</p>
          </div>
        </a>
      </section>
      </c:forEach>
      </c:forEach>
      </c:when>
      <c:otherwise>
      </c:otherwise>
      </c:choose>

      <!-- 
      <div class="pagination cf more-notes">
        <a class="load-more-notes" data-remote="true"
          href="http://next.36kr.com/posts.html?start_on=2015-06-21">OK, NEXT</a>
      </div>
       -->
      <div class="pagination cf more-notes">
        <a href="#">已经加载全部</a>
      </div>
    </div>
  </div>

  <jsp:include page="../FOOTER.jsp" />

</body>
</html>