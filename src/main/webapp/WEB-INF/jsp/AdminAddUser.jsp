<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<html>
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
        
    
<title>尤洪</title>
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
         
  
		 <div class="mem_tit">
                <c:choose>
                    <c:when test="${empty user.id || user.id==0}">
                        添加用户
                    </c:when>
                    <c:otherwise>
                        修改用户
                    </c:otherwise>
                </c:choose>
            </div>
            <br>
            <form action="${pageContext.request.contextPath}/servlet/addUserServlet?action=updateUser" method="post" id="userAdd" onsubmit="return checkUser();">
                <table border="0" class="add_tab" style="width:930px;" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="135" align="right">用户姓名</td>
                        <td colspan="3" style="font-family:'宋体';">
                            <input type="text" value="${user.loginName}" class="add_ipt" name="loginName"/>
                            <input type="hidden" value="${user.id}" name="id">
                        </td>
                    </tr>
                    <tr>
                        <td width="135" align="right">真实姓名</td>
                        <td>
                            <input type="text" value="${user.userName}" class="add_ipt" name="userName"/>
                        </td>
                    </tr>
                    <c:if test="${empty user.id ||  user.id==0}">
                        <tr>
                            <td width="135" align="right">密码</td>
                            <td>
                                <input type="password" value="" class="add_ipt" name="password"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="135" align="right">确认密码</td>
                            <td>
                                <input type="password" value="" class="add_ipt" name="repPassword"/>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td width="135" align="right">身份证号</td>
                        <td>
                            <input type="text" value="${user.identityCode}" class="add_ipt" name="identityCode"
                                   id="identityCode"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="135" align="right">电子邮箱</td>
                        <td>
                            <input type="text" value="${user.email}" class="add_ipt" name="email" id="email"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="135" align="right">手机</td>
                        <td>
                            <input type="text" value="${user.mobile}" class="add_ipt" name="mobile" id="mobile"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="135" align="right">用户类型</td>
                        <td>
                            <select name="type">
                                <option value="1" <c:if test="${user.type==1}">selected="selected"</c:if>>管理员</option>
                                <option value="0" <c:if test="${user.type==0}">selected="selected"</c:if>>普通用户</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <c:choose>
                                <c:when test="${empty user.id || user.id==0}">
                                    <input type="submit" value="添加用户" class="s_btn">
                                </c:when>
                                <c:otherwise>
                                    <input type="submit" value="修改信息" class="s_btn">
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </table>
            </form>
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
