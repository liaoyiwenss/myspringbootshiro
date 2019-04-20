<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
        
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
        
    
<title>liaoyiwen</title>
</head>
<body>  
<!--Begin Header Begin-->

<%@include file="../common/header.jsp" %>
<%@include file="../common/Search.jsp" %>
<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
   		<%@ include file="../prepublicpage/LeftBar.jsp" %>
		<div class="m_right">
            <p></p>
          <div class="mem_tit">全部用户信息 <input type="button" style="margin-left:600px" onclick="location.href='${pageContext.request.contextPath}/page/AdminAddUser.jsp'" value="增加用户" class="btn_tj" /></div>
         
   <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;"
                   cellspacing="0" cellpadding="0">
                <tbody>
                <tr  style="background:#bababa">
                    <td width="20%">用户名称</td>
                    <td width="20%">真实姓名</td>
                    <td width="15%">性别</td>
                    <td width="15%">类型</td>
                    <td width="20%" colspan="2">操作</td>
                </tr>
                <c:forEach items="${pages.list}" var="temp">
                    <tr>
                        <td>${temp.loginName}</td>
                        <td>${temp.userName}</td>
                        <td>
                            <c:choose>
                                <c:when test="${temp.sex==1}">
                                    男
                                </c:when>
                                <c:otherwise>
                                    女
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${temp.type==1}">
                                    管理员
                                </c:when>
                                <c:otherwise>
                                    用户
                                </c:otherwise>
                            </c:choose>
                        </td>
                        
                        
                         <c:if test="${temp.type==1}">
                        <td colspan="2">
                            <a href="${pageContext.request.contextPath}/servlet/UpdateUser?id=${temp.id}">修改</a>
                        </td>
                          </c:if>
                        
                        <c:if test="${temp.type==0}">
                        <td>
                            <a href="${pageContext.request.contextPath}/servlet/UpdateUser?id=${temp.id}">修改</a>
                        </td>
                        <td>
                           	 <a href="javascript:if(confirm('确认是否删除此用户？')) location='${pageContext.request.contextPath}/servlet/DeleteUser?id=${temp.id}'"  target="_blank">删除</a>
                        </td>
                          </c:if>
                        
                    </tr>
                </c:forEach>
                </tbody>
</table>


    <div class="pages">
                <c:if test="${pages.currentPageNo>1}">
				<a href="${pageContext.request.contextPath}/servlet/AllUser?flag=${flag}&&currentPage=${pages.currentPageNo-1}" class="p_pre">上一页</a>
				</c:if>
				<c:forEach var="i" begin="1" end="${pages.totalPageCount}">
				 <c:if test="${pages.currentPageNo!=i}">
				 <a href="${pageContext.request.contextPath}/servlet/AllUser?flag=${flag}&&currentPage=${i}" class="cur">
				${i}</a>
				</c:if>
				<c:if test="${pages.currentPageNo==i}">
				 <a href="javascript:return false;" class="cur">
				${i}
				</a>
				</c:if>
				</c:forEach>
				<c:if test="${pages.currentPageNo<pages.totalPageCount}">
				<a href="${pageContext.request.contextPath}/servlet/AllUser?flag=${flag}&&currentPage=${pages.currentPageNo+1}" class="p_pre">下一页</a>
				</c:if>
 </div>
            
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <%@include file="../common/footer2.jsp" %>  
   <%@include file="../common/footer.jsp" %>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
