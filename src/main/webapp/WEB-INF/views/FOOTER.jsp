<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
</head>
<body id="home" class="notes-index">

  <footer class="footer">
    <div class="row text-center">
      <div class="copyright">
        <p>
          © 2014-2015 <strong>TOP</strong>. All Rights Reserved. A <a href="http://www.zhuanlemei.com/">zhuanlemei</a>
          product.
        </p>
        <!-- 
        <p class="">
          <span>上 TOP，每天刷新更酷的生活方式。</span>
        </p>
         -->
      </div>
    </div>

    <script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments);
			}, i[r].l = 1 * new Date();
			a = s.createElement(o),
					m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m);
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-1268479-18', {
			'userId' : '0'
		});
		window.ga_user_id = '0';
	</script>
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
</html>