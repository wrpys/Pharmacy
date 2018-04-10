<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="common/backend_common.jsp" />
<jsp:include page="common/page.jsp" />
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="login.css" />
</head>
<body>
	<div id="login_frame">
		<form id="form_login" class="form-horizontal" role="form"
			onsubmit="return false;">
			<p id="image_logo">
				<img src="images/1.png" style="width:60px;height:60px;">
			</p>
			<p>
				<label for="username" class="label_input">账号</label><input
					type="text" class="text_field" id="yonghuname" name="yonghuname"
					placeholder="请输入账号" />
			</p>
			<p>
				<label for="password" class="label_input">密码</label><input
					type="password" class="text_field" id="password" name="password"
					placeholder="请输入密码" />
			</p>

			<input type="hidden" name="cls" value="UserController" /> <input
				type="hidden" name="mtd" value="login" />
			<div id="login_control">
				<input type="button" id="btn_login" class="user-add" value="登录" />
			</div>
		</form>
	</div>
</body>
<style type="text/css">
input::-webkit-input-placeholder {
	color: #DCDCDC;
}

input::-moz-input-placeholder {
	color: #DCDCDC;
}

input::-ms-input-placeholder {
	color: #DCDCDC;
}
</style>
<script type="text/javascript">
$(function () {
    $(".user-add").click(function () {
        var url = "${pageContext.request.contextPath }/cs";
		var username=$("#yonghuname").val()  ;
		var password=$("#password").val()  ;
        $.ajax({
        	url: url,
        	data:{
				cls:'YonghuController',
				mtd:'login',
				yonghuname:username,
				password:password
			},
            success: function (result) {
            	if(result.falseMe){
           			window.location.href = "admin.jsp?nolook="+result.duties;
            	}
            }
        });
    });
 });
</script>
</body>
</html>
