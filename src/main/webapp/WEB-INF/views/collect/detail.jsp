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
</head>
<body id="home" class="notes-index">
  <div class="container">
    <jsp:include page="../HEADER.jsp" />

    <section class="list-header">
      <div class="list-header-cover" style="background-image: url(https://rs-images.b0.upaiyun.com/uploads/note_collection/feature_image/283/464c33a8-cd4c-48f0-8edc-3e1386fdf618.jpg!1600x1600);">
      </div>
      <div class="list-header-info row">
        <h2>${collect.collectName}</h2>
        <div class="list-stats">
          <span></span><span>最后更新于 ${collect.updateTime}</span>
        </div>
        <p class="list-bio">${collect.memo}</p>
        <div class="list-header-meta cf">
          <div class="list-fav-btn ">
              <a class="btn " data-disfav-text="收藏" data-faved-text="已收藏" data-method="put" data-remote="true" href="/posts/collections/283/like" rel="nofollow">收藏</a>
            <span class="fav-number"><span class='total-count'>5</span> 人已收藏</span>
          </div>
          <div class="share">
            <div class="share-weibo">
              <a href="http://service.weibo.com/share/share.php?searchPic=false&amp;title=%E4%B8%AD%E5%B0%8F%E4%BC%81%E4%B8%9A%E6%B3%95%E5%BE%8B%E6%9C%8D%E5%8A%A1+O2O+-+%E8%B0%81%E6%98%AF%E4%B8%8B%E4%B8%80%E5%9D%97+B2B+%E5%9E%82%E7%9B%B4%E6%B3%95%E5%BE%8B%E6%9C%8D%E5%8A%A1%E7%9A%84%E6%9C%80%E5%A4%A7%E8%9B%8B%E7%B3%95%EF%BC%9F+-+NEXT&amp;url=http%3A%2F%2Fnext.36kr.com%2Fposts%2Fcollections%2F283%3Ft%3D2015-07-05T20%253A55%253A11%252B08%253A00%26uid%3D39627%26utm_campaign%3Dpost_show%26utm_content%3Dshare_button%26utm_medium%3Dnext%26utm_source%3Dweibo" target="_blank" title="点击分享到微博">
                <i class="svg-weibo"></i> <span>微博</span>
              </a>
            </div>
            <div class="share-wechat">
              <a title="微信扫码后分享" href="javascript:void(0)">
                <i class="svg-wechat"></i> <span>微信</span>
              </a>
              <div class="dropdown share-dropdown">
                <img alt="Qrcode.php?url=http%3a%2f%2fnext.36kr" height="156" src="http://s.jiathis.com/qrcode.php?url=http%3A%2F%2Fnext.36kr.com%2Fposts%2Fcollections%2F283%3Fshow_wechat_share_tip%3Dtrue" width="156" />
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
        <a class="btn submit-btn right" href="${root}/product/postUI?collectid=${collect.collectid}" target="_blank">补充好产品</a>
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