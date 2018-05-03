<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Login Page 2 | Creative - Bootstrap 3 Responsive Admin Template</title>

    <!-- Bootstrap CSS -->    
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="/static/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="/static/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="/static/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="/static/css/style.css" rel="stylesheet">
    <link href="/static/css/style-responsive.css" rel="stylesheet" />
	<!-- select2 -->
	<link href="/static/lib/select2/css/select2.css" rel="stylesheet">
</head>

  <body class="login-img3-body">

    <div class="container">

      <form id="login_form" class="login-form" action="#" method="post">        
        <div class="login-wrap">
            <p class="login-img"><i class="icon_lock_alt"></i></p>
            <div class="input-group">
              <span class="input-group-addon"><i class="icon_profile"></i></span>
              <input type="text" class="form-control" placeholder="用户名" autofocus>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input type="password" class="form-control" placeholder="密码">
            </div>
            <div  >
                <select id="seatSelect" name="seatId" style="min-width:310px;min-height:50px;"> 
                	<option></option>
                	<#assign slist=Map["list"]/>
					 <#list slist as item>
					 	<option value='${item.getSeatId()}'>${item.getSeatName()}</option>;
				  	 </#list>   
				</select> 
				<input type="hidden" id="seatName" name="seatName" >
			</div>	
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> 记住我
                <span class="pull-right"> <a href="#"> 忘记密码?</a></span>
            </label>
            <button id="login_button" class="btn btn-primary btn-lg btn-block" type="submit">登录</button>
        </div>
      </form>
	
    <!-- javascripts -->
    <script src="/static/lib/jquery.js"></script>
	<script src="/static/lib/jquery-ui-1.10.4.min.js"></script>
    <script src="/static/lib/jquery-1.8.3.min.js"></script>
	<!-- select2 -->
	<script src="/static/lib/select2/js/select2.js" type="text/javascript"></script> 
	<!-- layer弹出层 -->
    <script src="/static/lib/layer/layer.js"></script>
	<script>
		$(function(){
			var seatSelect = $('#seatSelect').select2({placeholder:'请选择席位...'});
			seatSelect.on("change",function(e){
				$("#seatName").val($("#seatSelect option:selected").text());
				$("#login_form").attr("action","/login");
			});
		});
	</script>
  </body>
</html>
