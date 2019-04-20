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
		<div class="mem_tit">全部分类信息<input type="button" style="margin-left:600px" id="bt1" value="增加分类" class="btn_tj" /></div>
         
        <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
        <tbody>
        <tr>
          <td width="5%">选择</td>
          <td width="20%">分类名称</td>
          <td width="25%">分类级别</td>
          <td width="25%">父级分类</td>
          <td width="25%" >操作</td>
        </tr>
        <c:forEach items="${pages.list}" var="temp">
          <tr>
            <td width="5%"><input type="radio" value="${temp.id}" name="select"/></td>
            <td>${temp.name}</td>
            <td>
            <c:choose>
               <c:when test="${temp.type==1}">一级分类</c:when>
               <c:when test="${temp.type==2}">二级分类</c:when>
               <c:when test="${temp.type==3}">三级分类</c:when>
            </c:choose>
            </td>
            <td>
            <c:if test="${empty temp.parentName}">
            	无
            </c:if>
            <c:if test="${not empty temp.parentName}">
            	${temp.parentName}
            </c:if>
            </td>
            <td><a href="javascript:if(confirm('确认是否删除此分类？')) location='${pageContext.request.contextPath}/servlet/DeleteCategory?id=${temp.id}'" >删除</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
            
             <div class="pages">
                <c:if test="${pages.currentPageNo>1}">
				<a href="${pageContext.request.contextPath}/servlet/CategoryList?flag=${flag}&&currentPage=${pages.currentPageNo-1}" class="p_pre">上一页</a>
				</c:if>
				<c:forEach var="i" begin="1" end="${pages.totalPageCount}">
				 <c:if test="${pages.currentPageNo!=i}">
				 <a href="${pageContext.request.contextPath}/servlet/CategoryList?flag=${flag}&&currentPage=${i}" class="cur">
				${i}</a>
				</c:if>
				<c:if test="${pages.currentPageNo==i}">
				 <a href="javascript:return false;" class="cur">
				${i}
				</a>
				</c:if>
				</c:forEach>
				<c:if test="${pages.currentPageNo<pages.totalPageCount}">
				<a href="${pageContext.request.contextPath}/servlet/CategoryList?flag=${flag}&&currentPage=${pages.currentPageNo+1}" class="p_pre">下一页</a>
				</c:if>
 </div>
            
            <div id="addcategory">
            
            
            <form action="${pageContext.request.contextPath}/servlet/addCategory" method="post">
             <table  border="0" style="width:880px; margin-top:20px;"  cellspacing="0" cellpadding="0">
             
            <tr height="45">
                <td align="right">选择分类&nbsp; &nbsp;</td>
                <td>
                <select id="sele" name="sele">
					<option>--请选择--</option>
					<option  value="1">一级分类</option>
					<option  value="2">二级分类</option>
					<option   value="3">三级分类</option>
				</select>
                
                </td>
              </tr> 
              <tr height="45">
                <td align="right">一级分类&nbsp; &nbsp;</td>
                <td>
                <select id="one" name="one">
					<option>--请选择--</option>
					
					 <c:forEach items="${pclist}" var="list" varStatus="i">
					
					<option id="${list.pc.id}" value="${list.pc.id}">${list.pc.name}</option>
					</c:forEach>
				</select>
                
                </td>
              </tr>
              <tr height="45">
                <td align="right">二级分类&nbsp; &nbsp;</td>
                <td>
                <select id="two" name="two">
					<option>--请选择--</option>
				</select>
                </td>
              </tr>
              <tr height="45">
                <td align="right">三级分类&nbsp; &nbsp;</td>
                <td>
                <select id="three" name="three">
					<option>--请选择--</option>
				</select>
                </td>
              </tr>
              
               <tr height="45">
                <td align="right">分类名称:&nbsp; &nbsp;</td>
                <td>
               <input type="text" name="categoryname"/>
                </td>
              </tr>
              
              
              </table>
              <input type="submit" style="margin-left:600px"  value="增加分类" class="btn_tj" />
              </form>
              </div>
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <%@include file="../common/footer2.jsp" %>  
   <%@include file="../common/footer.jsp" %>
    <!--End Footer End -->    
</div>

<script>

  jQuery("#addcategory").hide();

jQuery("#bt1").click(function(){
jQuery("#addcategory").show();
jQuery("#addcategory tr:eq(1)").hide();
jQuery("#addcategory tr:eq(2)").hide();
jQuery("#addcategory tr:eq(3)").hide();
})
jQuery("#sele").change(function(){
var vall=jQuery(this).val();

if(vall==1)
{
jQuery("#addcategory tr:eq(2)").hide();
jQuery("#addcategory tr:eq(1)").hide();

}
if(vall==2)
{
jQuery("#addcategory tr:eq(2)").hide();
jQuery("#addcategory tr:eq(1)").show();
}
if(vall==3)
{
jQuery("#addcategory tr:eq(1)").show();
jQuery("#addcategory tr:eq(2)").show();

}

})

jQuery("#one").change(function(){
		var id=jQuery(this).find("option:selected").attr("id");
		 jQuery("#two").html("<option>--请选择--</option>");
		jQuery.ajax({
			"url" : "${pageContext.request.contextPath}/servlet/one",
			"type" : "post",
			"data" : {"id":id},
			"dataType" : "Json",
			"success" : function(result){
			jQuery.each(result,function(i,n){
			jQuery("#two").append("<option id='"+n.id+"'value='"+n.id+"'>"+n.name+"</option>");
			})
			}
		}) 
		})
jQuery("#two").change(function(){
		var id=jQuery(this).find("option:selected").attr("id");
		
		 jQuery("#three").html("<option>--请选择--</option>");
		jQuery.ajax({
			"url" : "${pageContext.request.contextPath}/servlet/one",
			"type" : "post",
			"data" : {"id":id},
			"dataType" : "Json",
			"success" : function(result){
			jQuery.each(result,function(i,n){
			jQuery("#three").append("<option id='"+n.id+"'value='"+n.id+"'>"+n.name+"</option>");
			})
			}
		}) 
		})
</script>

<script>

</script>
</body>




<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
