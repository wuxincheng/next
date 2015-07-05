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

    <div class="content row ">
      <section class="main-header cf row">
        <div class="list-sort left">
          <a class="list-all active" href="/posts/collections">最新</a>
          <a class="list-faved " href="/posts/collections/hot">热门</a>  </div>
        <a class="btn submit-btn right" href="${root}/collect/edit">创建产品集</a>
      </section>
      <section class="list">
        <ul class="list-grid cf">
          <c:if test="${not empty collects}">
          <c:forEach items="${collects}" var="collect">
          <li class="list-item">
            <a class="cover" href="${root}/collect/detail?collectid=${collect.collectid}" target="_blank" style="background-image: url(https://rs-images.b0.upaiyun.com/uploads/note_collection/feature_image_preview/1/e4f71a82-4bae-4b02-9bfe-50a20a2b476a.png!160x160)">
              <div class="cover-meta">
                <h3>${collect.collectName}</h3>
                <ul class="list-meta">
                  <li><span>45</span>个产品</li>
                  <li><span class="liked-count">909</span>人收藏</li>
                </ul>
              </div>
            </a>
            <a class="list-fav-trigger" data-method="put" data-remote="true" href="/posts/collections/1/like" rel="nofollow">
              <span class="list-fav "></span>
            </a>
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