<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'dividePage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
    <div class="pages">
                <c:if test="${pages.currentPageNo>1}">
				<a href="${pageContext.request.contextPath}/servlet/Orderdetail?flag=${flag}&&currentPage=${pages.currentPageNo-1}" class="p_pre">上一页</a>
				</c:if>
				<c:forEach var="i" begin="1" end="${pages.totalPageCount}">
				 <c:if test="${pages.currentPageNo!=i}">
				 <a href="${pageContext.request.contextPath}/servlet/Orderdetail?flag=${flag}&&currentPage=${i}" class="cur">
				${i}</a>
				</c:if>
				<c:if test="${pages.currentPageNo==i}">
				 <a href="javascript:return false;" class="cur">
				${i}
				</a>
				</c:if>
				</c:forEach>
				<c:if test="${pages.currentPageNo<pages.totalPageCount}">
				<a href="${pageContext.request.contextPath}/servlet/Orderdetail?flag=${flag}&&currentPage=${pages.currentPageNo+1}" class="p_pre">下一页</a>
				</c:if>
 </div>
  </body>
</html>
