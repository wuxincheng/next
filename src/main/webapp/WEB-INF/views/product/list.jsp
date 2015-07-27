<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hfn" uri="/WEB-INF/hfn.tld"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">

<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="icon" />
<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="shortcut icon" />

<meta name="author" content="36Kr">
<meta name="description" content="NEXT - 不错过任何一个新产品">
<meta name="keywords" content="NEXT，新产品，创业，互联网产品，Startup">

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
              <!-- 使用voted样式, 表示用户已经赞这个产品 -->
              <div class="upvote <c:if test="${not empty obj.likeState}">voted</c:if>" id="prodlike${obj.prodid}">
                <a class="upvote-link vote-up" onclick="likeProduct('${obj.prodid}')"> 
                  <i class="upvote-arrow"></i> 
                  <span class="vote-count" id="span${obj.prodid}">${obj.score}</span>
                </a>
              </div>

              <div class="product-url">
                <a class="post-url" data-client="null" href="${obj.prodUrl}"
                  ref="nofollow" target="_blank" title="html-js.com">${obj.prodName}</a> <br> <span
                  class="post-tagline">${obj.memo}</span>
              </div>
              <ul class="product-meta right">
                <li class="product-avatar">
                  <div class="user-image">
                    <a class="user-image-link" href="#">
                      <img class="avatar" height="60" src="${obj.socialPicPath}" width="60" />
                    </a>
                  </div>

                  <div class="user-tooltip">
                    <a class="user-image-link" href="#">
                      <img class="avatar avatar-big" height="120" src="${obj.socialPicPath}" width="120" />
                    </a>
                    <h3 class="user-nickname">${obj.nickName}</h3>
                    <h4 class="user-title">${user.userGroup} - ${user.position}<br></h4>
                    <p class="user-bio">${obj.userMemo}</p>
                  </div>

                  <div class="product-comment">
                    <a class="product-comments" href="#"> ${obj.commentSum} </a>
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
  
  <script type="text/javascript">
  	function likeProduct (prodid) {
	  var url = "${root}/product/like";
	  
	  $.ajax({
	  	url : url, // 跳转到 action    
	  	data : {prodid : prodid},
	  	type : 'post',
	  	beforeSend:function(){
	  	},
	  	cache : false,
	  	dataType : 'json',
	  	success : function(data) {
			var result = data;
			var clazz = 'voted'; // 样式
			var divname = '#prodlike'+result.prodid; // 产品div
			var scorespan = '#span'+result.prodid; // 产品关注度div
			if ('1' == result.flag) { // 点赞标志
				$(divname).addClass(clazz);
			} else {
				$(divname).removeClass(clazz);
			}
			$(scorespan).text(result.score); // 产品关注度
	  	},
	  	error : function() {
	  		alert("友情提示：您还未登录!");
	  	}
	  });
	}  
  </script>

</body>
</html>