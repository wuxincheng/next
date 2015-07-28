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
<link rel="author" href="http://next.36kr.com/humans.txt">

</head>
<body id="home" class="notes-index">
  <div class="container">

    <jsp:include page="../HEADER.jsp" />

    <div class="content row ">
      <section class="product cf">
        <ul class="product-list">
          <li class="product-item">
            <div class="posts-group cf row">
              <div class="upvote <c:if test="${not empty product.likeState}">voted</c:if>" id="prodlike${product.prodid}">
                  <a class="upvote-link vote-up" onclick="likeProduct('${product.prodid}')">
                    <i class="upvote-arrow"></i>
                    <span class="vote-count">${product.score}</span>
                  </a>        
              </div>
              <div class="product-url">
                <a class="post-url" href="${product.prodUrl}" ref="nofollow" target="_blank" title="App Store">${product.prodName}</a>
                <br>
                <span class="post-tagline">${product.memo}</span>
              </div>
              <ul class="product-meta right">
                <li class="product-avatar">
                  <div class="user-image">
                    <a class="user-image-link" href="#">
                      <img alt="0" class="avatar" height="60" src="${product.socialPicPath}" width="60" />
                    </a>
                  </div>
                  <div class="user-tooltip">
                    <a class="user-image-link" href="#">
                      <img alt="0" class="avatar avatar-big" height="120" src="${product.socialPicPath}" width="120" />
                    </a>
                    <h3 class="user-nickname">${product.nickName}</h3>
                    <h4 class='user-title'>${product.userGroup} - ${product.position}<br></h4>
                    <p class="user-bio"> ${product.userMemo} </p>
                  </div>
                </li>
              </ul>
            </div>
          </li>
        </ul>
      
        <c:if test="${not empty prodLikes}">
        <div class="upvotes">
          <h2>${product.likeSum}人觉得很赞：</h2>
          <c:forEach items="${prodLikes}" var="prodLike">
          <ul class="upvote-users cf">
            <li class="product-avatar">
              <div class="user-image">
                <a class="user-image-link" href="#">
                  <img class="avatar" height="60" src="${prodLike.socialPicPath}" width="60" />
                </a>
              </div>
              <div class="user-tooltip">
                <a class="user-image-link" href="#">
                  <img class="avatar avatar-big" height="120" src="${prodLike.socialPicPath}" width="120" />
                </a>
                <h3 class="user-nickname">${prodLike.nickName}</h3>
                <h4 class="user-title">${prodLike.userGroup} - ${prodLike.position}<br></h4>
                <p class="user-bio">${prodLike.memo}</p>
              </div>
            </li>
          </ul>
          </c:forEach>
        </div>
        </c:if>
      
        <div class="share">
          <h3>分享到</h3>
          <div class="share-weibo">
            <a href="http://service.weibo.com/share/share.php?searchPic=false&amp;title=${product.prodName} - ${product.memo}&amp;url=http://www.zhuanlemei.com/top/product/detail?prodid=${product.prodid}" target="_blank" title="点击分享到微博">
              <i class="svg-weibo"></i> <span>微博</span>
            </a>
          </div>
          <div class="share-wechat">
            <a title="微信扫码后分享" href="javascript:void(0)">
              <i class="svg-wechat"></i> <span>微信</span>
            </a>
            <div class="dropdown share-dropdown">
              <img height="156" src="http://s.jiathis.com/qrcode.php?url=http://www.zhuanlemei.com/top/product/detail?prodid=${product.prodid}" width="156" />
              <span>微信扫一扫：分享</span>
            </div>
          </div>
        </div>
      </section>
      
      <section class="comments row" id="comments">
        <h4>评论 (${product.commentSum})</h4>
        <c:if test="${empty user}">
        <form accept-charset="UTF-8" action="" class="simple_form comment" method="post">
          <a href="${root}/login/">登录后发表评论</a></form>
        </c:if>
        <c:if test="${not empty user}">
        <form accept-charset="UTF-8" action="${root}/comment/post" class="simple_form comment" method="post">
          <input id="productid" name="productid" type="hidden" value="${product.prodid}" />
          <div style="display:none">
            <input name="utf8" type="hidden" value="&#x2713;" />
            <input name="authenticity_token" type="hidden" value="ANEyEpJJ68CL9sOaM+TBgWkLVrJ+y6mWIHYHa5OiijI=" />
          </div>
          <input id="ok_url" name="ok_url" type="hidden" value="/posts/14905#comments" />
          <div class="form-group hidden comment_content">
          <input class="hidden form-control input-big" id="comment_content" name="content" type="hidden" />
          </div>
          <div contenteditable="true" class="input-big mention editable-comment form-control" disabled="disabled"
            data-for="content" required="required" mentionable="true">
          </div>
          <input class="btn submit" name="commit" type="submit" value="发表评论" />
          <span class='help-inline'>支持Markdown语法</span>
        </form>
        </c:if>
        
        <!-- 评论 -->
        <c:if test="${not empty comments}">
        <c:forEach items="${comments}" var="comment">
        <div class="media comment" id="comment_25191">
          <div class="comment-avatar">
            <div class="user-image">
              <a class="user-image-link" href="#">
                <img class="avatar" height="60" src="${comment.socialPicPath}" width="60" />
              </a>
            </div>
            <div class="user-tooltip">
              <a class="user-image-link" href="#">
                <img class="avatar avatar-big" height="120" src="${comment.socialPicPath}" width="120" />
              </a>
              <h3 class="user-nickname">${comment.nickName}</h3>
              <h4 class='user-title'>${comment.userGroup} - ${comment.position}<br></h4>
              <p class="user-bio">${comment.userMemo}</p>
            </div>
          </div>
          <div class="media-body">
            <div class="comment-details">
              <div class='comment-meta cf'>
                <h3 class="user-nickname"><a href="#">${comment.nickName}</a></h3>
                <span class="user-bio">${comment.userMemo}</span>
              </div>
              <div class="comment-content">
                <p>${comment.content}</p>
                <em>${hfn:relativeDateFormat(comment.createTime)}</em>
              </div>
              <!-- 
              <p>- <a class="reply" href="">回复</a><span class="reply">(1)</span></p>
               -->
            </div>
          </div>
        </div>        
        </c:forEach>
        </c:if>
      
        <div id="mention_wrapper" data-note-id="14941">
          <input type="text" id="mention_user_selector">
        </div>
      </section>
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