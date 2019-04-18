<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<title>注册</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/register.css">

	<style rel="stylesheet" type="text/css">

		#submitBtn{
			width:141px;
			height: 51px;
			border:none;
			background: transparent  url("images1/button.gif") no-repeat;
			cursor: pointer;
		}

		.clear:after{

			content: "";
			display: block;
			clear: both;
		}
		/*当鼠标放到文本框时，提示文本的样式*/
		.import_prompt{
			border:solid 1px #ffcd00;
			background-color:#ffffda;
			padding-left:5px;
			padding-right:5px;
			line-height:20px;
			position: relative;
			left: 350px;
			bottom: 35px;
			font-family: 华文行楷;
			font-weight: 700;
			font-size: 12px;
		}
		/*当文本框内容不符合要求时，提示文本的样式*/
		.error_prompt{
			border:solid 1px #ff3300;
			background-color:#fff2e5;
			background-image:url(images1/li_err.gif);
			background-repeat:no-repeat;
			background-position:5px 2px;
			padding:2px 30px 0px 25px;
			position: relative;
			left: 350px;
			bottom: 35px;
			line-height:20px;
			font-family: 华文行楷;
			font-weight: 700;
			font-size: 12px;
		}

		/*当文本框内容输入正确时，提示文本的样式*/
		.ok_prompt{
			border:solid 1px #01be00;
			background-color:#e6fee4;
			background-image:url(images1/li_ok.gif);
			background-repeat:no-repeat;
			background-position:5px 2px;
			padding:2px 30px 0px 25px;
			position: relative;
			left: 350px;
			bottom: 35px;
			line-height:20px;
			font-family: 华文行楷;
			font-weight: 700;
			font-size: 12px;
		}

		.redBorder{
			border:1px solid red;
		}

		.greenBorder{
			border:1px solid green;
		}


		.inputs{
			border:solid 1px #a4c8e0;
			width:150px;
			height:15px;
		}


	</style>
</head>
<body>
	<header id="headNav">
		<div class="innerNav cf">
			<a class="fl" href="#"><img src="image1/logo.jpg" alt=""></a>
			<div class="headFont fr">
				<span>您好，欢迎光临纸书！<a href="loadpage.jsp">请登录</a></span>
				<a class="helpLink" href="#"><i class="runbun"></i>帮助中心<i class="turnb"></i></a>
			</div>
			<div class="outHelp">
				<ul class="helpYou" style="display: none;">
					<li><a href="#">包裹跟踪</a></li>
					<li><a href="#">常见问题</a></li>
					<li><a href="#">在线退换货</a></li>
					<li><a href="#">在线投诉</a></li>
					<li><a href="#">配送范围</a></li>
				</ul>
			</div>
		</div>
	</header>
	<section id="secTab">
		<form action="/ReplaceBook/servlet/registerpage" method="post" id="registerForm">
			<div class="innerTab">
		<h2>纸书注册</h2>

		<div class="tableItem">
			<input type="text" name="userName" id="userName"
				   onfocus="focusShow('userName','1、由字母、数字、下划线、点、减号组成<br/>2、只能以数字、字母开头或结尾，且长度为4-18')"
				   onblur="checkUserName()"
				   required placeholder="通行证用户名" pattern="^[a-zA-Z0-9][a-zA-Z0-9\-\._]{2,16}[a-zA-Z0-9]$"/>
			<div id="userNameId"></div>
		</div>

		<div class="tableItem">
	        <input type="text" id="tel" name="phone" onfocus="focusShow('tel','1、手机号码以13，15，18开头<br/>2、手机号码由11位数字组成')" onblur="checkTel()" required placeholder="手机号码" pattern="^1[3578]\d{9}$"/>
			<div id="telId"></div>
	     </div>
				<div class="tableItem">
					<input type="text" id="nickName" name="nickName" onfocus="focusShow('nickName','1、包含汉字、字母、数字、下划线以及@!#$%&*<br/>特殊字符<br/>2、长度为4－20个字符<br/>3、一个汉字占两个字符')" onblur="checkNikeName()"  required placeholder="昵称"  pattern="^([\u4e00-\u9fa5]|\w|[@!#$%&*])+$"/>
					<div id="nickNameId"></div>
				</div>
				<div class="tableItem">
					<input type="text" id="email" name="email" onfocus="focusShow('email','请输入您常用的电子邮箱，邮箱应包含@和.符号')" onblur="checkEmail()"  required placeholder="保存邮箱"  pattern="^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$"/>
					<div id="emailId"></div>
				</div>
	    <div class="cf">
			<div class="tableItem onlyItem fl">
				<input class="yanzheng" type="text" name="yanzheng" placeholder="验证码" />
		    </div>
	    	<a class="tableText fr" disabled="disabled"  href="#">获取验证码</a>
	    </div>


		<div class="tableItem">
	        <input type="password" id="pwd" name="password" onfocus="focusShow('pwd','密码应为6-16个字符')" onblur="checkPwd()"  required placeholder="设置密码"  pattern="^\w{6,16}$"/>
			<div id="pwdId"></div>
		</div>
		<div class="tableItem">
	        <input type="password" id="repwd" name="rePassword" onfocus="focusShow('repwd','请再次输入密码')" onblur="checkRepwd()" required placeholder="确认密码" pattern="^\w{6,16}$"/>
			<div id="repwdId"></div>
	    </div>
	    <p class="clickRegist">点击注册，表示您同意共享书店 <a href="#">《服务协议》</a></p>
	    <input type="submit" class="tableBtn" value="同意协议并注册" >
	</div>
		</form>
	</section>
	<footer id="footNav">
		<p><a href="#">沪ICP备13044278号</a>|&nbsp;&nbsp;合字B1.B2-20130004&nbsp;&nbsp;|<a href="#">营业执照</a></p>
		<p>Copyright © 1号店网上超市 2007-2016，All Rights Reserved</p>
	</footer>


	<script src="js/jquery-1.11.1.min.js"></script>
	<script>



		/*$(".tableText").click(function () {
			function time() {
				var i=59;
				var id=window.setInterval(function () {
					$(".yanzheng").attr("placeholder",i+"s");
					i--;

					if(i==0)
					{
						window.clearInterval(id);
					}
				},1000)

			}
			time();
		});


		$("input[name='username']").focus(function(){
			$(this).parent().next().show()
		}).blur(function(){
			$(this).parent().next().hide();
		})
		$("input[name='phone']").focus(function(){
			$(this).parent().next().show();
		}).blur(function(){
			$(this).parent().next().hide();
		})

		$("input[name='password']").focus(function(){
			$(this).parent().next().show();
		}).blur(function(){
			$(this).parent().next().hide();
		})



		$("input[name='repassword']").focus(function(){
			$(this).parent().next().show();
		}).blur(function(){
			$(this).parent().next().hide();
		})*/
		$(".tableBtn").click(function () {
			var u = $(" :text").get(0);

			if (u.validity.valueMissing == true) {
				u.setCustomValidity("用户名不能为空");
			}
			else if (u.validity.patternMismatch == true) {
				u.setCustomValidity("1、由字母、数字、下划线、点、减号组成<br/>2、只能以数字、字母开头或结尾，且长度为4-18");
			} else {
				u.setCustomValidity("");
			}


			var uu = $(" :text").get(1);
			if (uu.validity.valueMissing == true) {
				uu.setCustomValidity("绑定的手机号");
			} else if (uu.validity.patternMismatch == true) {
				uu.setCustomValidity("手机号码，以13，15，17，18开头的11为数字");
			} else {
				uu.setCustomValidity("");
			}
			var u2 = $(" :password").get(0);
			if (u2.validity.valueMissing == true) {
				u2.setCustomValidity("不能为空");
			} else if (u2.validity.patternMismatch == true) {
				u2.setCustomValidity("密码应为6-16个字符");
			} else {
				u2.setCustomValidity("");
			}
			var u3 = $(" :password").get(1);
			if (u3.validity.patternMismatch == true) {
				u3.setCustomValidity("密码不匹配");
			} else {
				u3.setCustomValidity("");
			}

		})


		function time() {


			var i=59;
			$(".tableText").attr("disabled","disabled");
			var id=window.setInterval(function () {
				$(".tableText").text(i+"s");
				i--;
				flag=false;
				if(i==0)
				{

					$(".tableText").text("获取验证码");
					flag=true;
					window.clearInterval(id);
					$(".tableText").attr("disable","able");
				}
			},1000)

		}
		var flag=true;

		$(".tableText").click(function () {

			if(flag)
			{
				time();
			}

		});






		function e(str){
			return document.getElementById(str);
		}
		//动态添加有样式的内容
		function appendHtml(obj,str,className){
			obj.innerHTML = str;
			obj.className  = className;
		}
		//验证表单
		function checkForm(){
			var ids  = ["checkUserName()","checkPwd()","checkRepwd()","checkNikeName()","checkTel()","checkEmail()"];
			var sum = 0;
			for(var i = 0; i<ids.length ;i++){
				if ( eval(ids[i]) )sum++;
			}
			return ids.length == sum ? true : false;
		}

		function focusShow(inputId,msg){
			var odom = e(inputId);//输入框DOM对象
			var omsg = e(inputId+"Id");//信息提示DOM对象
			odom.style.borderColor = "red";
			appendHtml(omsg,msg,"import_prompt");

		}
		//验证用户名输入
		function checkUserName(){
			var flag = true;
			var odom = e("userName");//输入框DOM对象
			var omsg = e("userNameId");//信息提示DOM对象
			var reg = new RegExp("^[a-zA-Z0-9][a-zA-Z0-9\-\._]{2,16}[a-zA-Z0-9]$");
			if(odom.value == ""){
				odom.style.borderColor = "red";
				appendHtml(omsg,"通行证用户名不能为空，请输入通行证用户名","error_prompt");
				flag =  false;
			}else if( odom.value.match(reg) == null  ){
				odom.style.borderColor = "red";
				appendHtml(omsg,"请输入正确的通行证用户名","error_prompt");
				flag =  false;
			}else{
				odom.style.borderColor = "green";
				appendHtml(omsg,"输入正确","ok_prompt");
				flag =  true;
			}
			return flag;
		}

		//验证密码
		function checkPwd(){
			var flag = true;
			var odom = e("pwd");//输入框DOM对象
			var omsg = e("pwdId");//信息提示DOM对象
			if( odom.value == ""){
				odom.style.borderColor = "red";
				appendHtml(omsg,"请输入密码","error_prompt");
				flag =  false;
			}else if( odom.value.length < 6 || odom.value.length > 16 ){
				odom.style.borderColor = "red";
				appendHtml(omsg,"密码长度为6-16个字符","error_prompt");
				flag =  false;
			}else{
				odom.style.borderColor = "green";
				appendHtml(omsg,"输入正确","ok_prompt");
				flag =  true;
			}
			return flag;
		}
		//验证重复密码
		function checkRepwd(){
			var flag = true;
			var odom = e("repwd");//输入框DOM对象
			var omsg = e("repwdId");//信息提示DOM对象
			if(odom.value == ""){
				odom.style.borderColor = "red";
				appendHtml(omsg,"确认密码不能为空","error_prompt");
				flag =  false;
			}else if(odom.value !=  e("pwd").value){
				odom.style.borderColor = "red";
				appendHtml(omsg,"两次输入的密码不一致","error_prompt");
				flag =  false;
			} else{
				odom.style.borderColor = "green";
				appendHtml(omsg,"输入正确","ok_prompt");
				flag =  true;
			}
			return flag;
		}

		//验证昵称
		function checkNikeName(){
			var flag = true;
			var odom = e("nickName");//输入框DOM对象
			var omsg = e("nickNameId");//信息提示DOM对象
			var reg = /^([\u4e00-\u9fa5]|\w|[@!#$%&*])+$/;   // 匹配昵称
			var chinaReg = /[\u4e00-\u9fa5]/g;   //匹配中文字符
			var len = odom.value.replace(chinaReg, "ab").length;  //把中文字符转换为两个字母，以计算字符长度

			if(odom.value == "") {
				odom.style.borderColor = "red";
				appendHtml(omsg, "昵称不能为空，请输入昵称", "error_prompt");
				flag = false;
			}else  if(odom.value.match(reg)==null) {
				odom.style.borderColor = "red";
				appendHtml(omsg, "只能由汉字、字母、数字、下划线以及@!#$%&*特殊字符组成", "error_prompt");
				flag = false;
			}else if(len<4||len>16 ){
				appendHtml(omsg, "昵称为4-16个字符", "error_prompt");
			}else{
				odom.style.borderColor = "green";
				appendHtml(omsg,"输入正确","ok_prompt");
				flag =  true;
			}
			return flag;
		}

		//验证手机
		function checkTel(){
			var flag = true;
			var odom = e("tel");//输入框DOM对象
			var omsg = e("telId");//信息提示DOM对象
			var reg=/^(13|15|18)\d{9}$/;
			if( odom.value == "" ) {
				odom.style.borderColor = "red";
				appendHtml(omsg, "关联手机号码不能为空，请输入关联手机号码", "error_prompt");
				flag = false;

			}else if(odom.value.match(reg) == null){
				odom.style.borderColor = "red";
				appendHtml(omsg, "关联手机号码输入不正确，请重新输入", "error_prompt");
				flag = false;
			}else{
				odom.style.borderColor = "green";
				appendHtml(omsg,"输入正确","ok_prompt");
				flag =  true;
			}
			return flag;
		}
		//验证邮箱
		function checkEmail(){
			var flag = true;
			var odom = e("email");//输入框DOM对象
			var omsg = e("emailId");//信息提示DOM对象
			var reg=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
			if(odom.value == ""){
				odom.style.borderColor = "red";
				appendHtml(omsg,"保密邮箱不能为空，请输入保密邮箱","error_prompt");
				flag =  false;
			}else if( odom.value.match(reg) ==null ){
				odom.style.borderColor = "red";
				appendHtml(omsg,"邮件格式不正确","error_prompt");
				flag =  false;
			}else{
				odom.style.borderColor = "green";
				appendHtml(omsg,"输入正确","ok_prompt");
				flag =  true;
			}
			return flag;
		}
	</script>


</body>
</html>