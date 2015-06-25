<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <div class="content row row cf">
      <div class="forms">
        <form accept-charset="UTF-8" action="/posts" class="simple_form new_note" id="new_note"
          method="post">
          <div style="display: none">
            <input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token"
              type="hidden" value="UPiDrTAjt2KU/pN2Pk67fOAFuScLNlZ77yx8CJ+TfSE=" />
          </div>

          <div class="form-group hidden note_source">
            <input class="hidden form-control" id="note_source" name="note[source]" type="hidden"
              value="direct" />
          </div>
          <div class="form-group string required note_title">
            <label class="string required" for="note_title">产品名称</label><input aria-required="true"
              autofocus="autofocus" class="string required form-control input-small" id="note_title"
              name="note[title]" placeholder="如：Startup Base" required="required" type="text" />
          </div>
          <div class="form-group url required note_url">
            <label class="url required" for="note_url">产品官网</label><input aria-required="true"
              class="string url required form-control input-small" id="note_url" name="note[url]"
              placeholder="以 http:// 开头的有效网址" required="required" type="url" />
          </div>
          <div class="form-group text required note_summary">
            <label class="text required" for="note_summary">一句话描述这个产品</label>
            <textarea aria-required="true" class="text required form-control input-big"
              id="note_summary" name="note[summary]" required="required">
</textarea>
            <p class="help-block">请精简描述, 36字以内</p>
          </div>

          <input class="btn submit" name="commit" type="submit" value="提交" />
        </form>
      </div>


      <aside class="aside">
        <p>&nbsp;</p>
      </aside>

    </div>
  </div>

  <jsp:include page="../FOOTER.jsp" />

</body>
</html>