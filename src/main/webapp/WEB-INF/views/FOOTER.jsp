<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
</head>
<body id="home" class="notes-index">

  <footer class="footer">
    <div class="row text-center">
      <div class="copyright">
        <p>
          © 2014-2015 <strong>TOP</strong>. All Rights Reserved. A <a href="http://www.zhuanlemei.com/">zhuanlemei</a> product.
        </p>
      </div>
    </div>
    
    <div id="Intercom" class="hide"></div>
    <script data-turbolinks-track="true" src="${root}/assets/js/faye.js"></script>
  </footer>
  <a href="javascript:" class="back-top"
    title="更多快捷键:
  j: 下翻页,
  k: 上翻页,
  t: 返回顶部
    您还可以按下键盘空格键自动翻页">返回顶部</a>

</body>

<!-- 百度统计 -->
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?dd71b165a006d5e6f7e464b857fca722";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
</html>