<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hfn" uri="/WEB-INF/hfn.tld"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>TOP - 产品集</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="author" content="36Kr">
<meta name="description" content="NEXT - 不错过任何一个新产品">
<meta name="keywords" content="NEXT，新产品，创业，互联网产品，Startup">

<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="icon" />
<link href="${root}/assets/img/logo/toplogo.png" type="image/x-icon" rel="shortcut icon" />

</head>
<body id="home" class="notes-index">
  <div class="container">
    <jsp:include page="../HEADER.jsp" />

    <section class="list-header">
      <div class="list-header-cover" style="background-image: url(${root}/collect/coverbg/${collect.coverImgPath});">
      </div>
      <div class="list-header-info row">
        <h2>${collect.collectName}</h2>
        <div class="list-stats">
          <span></span><span>最后更新于 ${collect.updateTime}</span>
        </div>
        <p class="list-bio">${collect.memo}</p>
        <div class="list-header-meta cf">
          <div class="list-fav-btn <c:if test="${not empty collectUser}">faved</c:if>">
            <c:if test="${empty collectUser}">
            <a class="btn " href="${root}/collect/collect?collectid=${collect.collectid}&userid=${user.userid}">收藏</a>
            </c:if>
            
            <c:if test="${not empty collectUser}">
            <a class="btn fav" href="${root}/collect/collect?collectid=${collect.collectid}&userid=${user.userid}">已收藏</a>
            </c:if>
            <span class="fav-number"><span class='total-count'>${collect.collectSum}</span> 人已收藏</span>
          </div>
          <div class="share">
            <div class="share-weibo">
              <a href="http://service.weibo.com/share/share.php?searchPic=false&amp;title=${collect.collectName} - ${collect.memo}&amp;url=http://www.zhuanlemei.com/top/collect/detail?collectid=${collect.collectid}" target="_blank" title="点击分享到微博">
                <i class="svg-weibo"></i> <span>微博</span>
              </a>
            </div>
            <div class="share-wechat">
              <a title="微信扫码后分享" href="javascript:void(0)">
                <i class="svg-wechat"></i> <span>微信</span>
              </a>
              <div class="dropdown share-dropdown">
                <img height="156" src="http://s.jiathis.com/qrcode.php?url=http://www.zhuanlemei.com/top/collect/detail?collectid=${collect.collectid}" width="156" />
                <span>微信扫一扫：分享</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <div class="content row ">
      <section class="main-header cf row">
        <div class="list-tip left">
          <p><p>还有更好的产品没出现在这里？点击右边的按钮添加吧！</p>
        </div>
        <a class="btn submit-btn right" href="${root}/product/postUI?collectid=${collect.collectid}">补充好产品</a>
      </section>
      <section class="post">
        <ul class="product-list">
          <c:if test="${not empty products}">
          <c:forEach items="${products}" var="product">
          <li class="product-item">
            <div class="posts-group cf">
              <div class="upvote ">
                <a class="upvote-link vote-up" data-method="put" data-remote="true" href="/posts/8189/vote.html" rel="nofollow">
                  <i class="upvote-arrow"></i>
                  <span class="vote-count">61</span>
                </a>
              </div>
              <div class="product-url">
                <a class="post-url" data-client="null" href="/posts/8189/hit" ref="nofollow" target="_blank" title="lvzheng.com">${product.prodName}</a>
                <br>
                <span class="post-tagline">${product.memo}</span>
              </div>
              <ul class="product-meta right">
                <li class="product-mark">
                  <div class="mark" title="小微律政 的团队成员已经入驻 NEXT，你的评论反馈会被关注和回复">
                    <i class="marks mark-founder"></i>
                  </div>
                </li>
                <li class="product-avatar">
                  <div class="user-image">
                    <a class="user-image-link" href="/users/17682">
                      <img alt="0" class="avatar" height="60" src="http://wx.qlogo.cn/mmopen/2pm5Nb2cMaPm9TsSIDaic2YGf2ckV6YqEbcFzmsuTiaOEiaYx4f0pxiczLUTdZ63gNMa9yz0XiarZ3lEzcxjeQKVGeA/0" width="60" />
                    </a>
                  </div>
                  <div class="user-tooltip">
                    <a class="user-image-link" href="/users/17682">
                      <img alt="0" class="avatar avatar-big" height="120" src="http://wx.qlogo.cn/mmopen/2pm5Nb2cMaPm9TsSIDaic2YGf2ckV6YqEbcFzmsuTiaOEiaYx4f0pxiczLUTdZ63gNMa9yz0XiarZ3lEzcxjeQKVGeA/0" width="120" />
                    </a>
                    <h3 class="user-nickname">崔东蛟</h3>
                    <p class="user-bio"></p>
                  </div>
                  <div class="product-comment">
                    <a class="product-comments" href="/posts/8189#comments" target="_blank">4</a>      
                  </div>
                </li>
              </ul>
          </div>
          <a class="product-link" href="/posts/8189" target="_blank"></a>
          </li>          
          </c:forEach>
          </c:if>
        </ul>
      </section>
    </div>
  </div>    

  <jsp:include page="../FOOTER.jsp" />

</body>
</html>