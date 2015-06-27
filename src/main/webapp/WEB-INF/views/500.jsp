<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>新成博客 - 对不起，服务器异常</title>
<meta name="description" content="Your description">
<meta name="keywords" content="Your,Keywords">
<meta name="author" content="ResponsiveWebInc">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
	<div class="wrapper">
		
		<div class="container">
			<div class="top-container">
				<div class="badger-left badger-notice" data-badger="新成提示">
					<br>
					<div class="row">
						<div class="col-sm-3"></div>
        				<div class="col-sm-2" style="text-align: center;">
        					<img src="<%=request.getContextPath()%>/assets/img/sorry.png">
        				</div>
        				<div class="col-sm-7">
	        				<br>
							<p>
				        	<h4>啊噢，对不起，服务器异常耶，请您稍后再试！</h4>
				        	<p>&nbsp;</p>
        				</div>
        			</div>
		        </div>
		        <hr>
		        <p>&nbsp;</p>
	        </div>
		</div>
		
	</div>
</body>
</html>
