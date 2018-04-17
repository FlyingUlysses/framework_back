<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="img/favicon.png">
    <title>航班监控主页</title>
    <!-- Bootstrap CSS -->    
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="/static/css/bootstrap-theme.css" rel="stylesheet">
    <!-- font icon -->
    <link href="/static/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="/static/css/font-awesome.min.css" rel="stylesheet" />    
    <!-- Custom styles -->
    <link href="/static/css/style.css" rel="stylesheet">
	<link href="/static/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
  </head>

  <style>
  </style>

  <body>
  <!-- container section start -->
  <section id="container" class="">
     
      
      <header class="header dark-bg">
            <div class="toggle-nav">
                <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"></div>
            </div>

            <!--logo start-->
            <a href="index.html" class="logo">航班 <span class="lite">监控</span></a>
            <!--logo end-->
            
            <!-- tab start -->
            <div id="tab_div" style="display: inline-block;padding-top: 10px;padding-left: 550px;"> 
                <ul id="myTab" class="nav nav-tabs">
                    <li class="active">
                        <a id="line_button" href="#line" data-toggle="tab">
                             航班
                        </a>
                    </li>
                    <li><a id="home_button" href="#home" data-toggle="tab">机场</a></li>
                </ul>
            </div>
            <!-- tab end -->
           
            <div class="top-nav notification-row">                
                <!-- notificatoin dropdown start-->
                <ul class="nav pull-right top-menu">
                	<li>
                    	<input id="start_time_input" value="${start_time}" disabled="disabled" style="margin-top: 15px;width: 130px;" />
                	</li>
                	<li>
                    	<input id="end_time_input" value="${end_time}" disabled="disabled" style="margin-top: 15px;width: 130px;" />
                	</li>
                	<li>
                		<inpt type="button" id="find_button"  class="btn btn-info  btn-sm" style="margin-top: 12px;" ><i class="fa fa-search"> 查询</i></a>
                	</li>
                	<li>
                		<inpt type="button" id="reload_button" class="btn btn-danger  btn-sm" style="margin-top: 12px;" onclick=""><i class="fa fa-spinner"> 导入</i></a>
                	</li>
                	<li id="stop_reload_li">
                		<inpt type="button" id="stop_button" class="btn btn-danger  btn-sm" style="margin-top: 12px;" onclick="stopReload();"><i class="fa fa-power-off"> 停止刷新</i></a>
                	</li>
                	<li id="start_reload_li" style="display:none;">
                		<inpt type="button" id="stop_button" class="btn btn-info  btn-sm" style="margin-top: 12px;" onclick="reload();"><i class="fa fa-power-off"> 自动刷新</i></a>
                	</li>
                    <!-- alert notification start-->
                    <li id="alert_notificatoin_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="fa fa-cogs"></i>
                        	 <span id="global_type_span" class="username">查看所有</span>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <div class="notify-arrow notify-arrow-blue"></div>
                            <li>
                                <p class="blue">模式切换</p>
                            </li>
                            <li>
                                <a onclick= 'changeType("all",this);' style="cursor:pointer;" >
                                    <span ><i class="fa fa-cog"></i></span> 
                                                                                               查看所有
                                </a>
                            </li>
                            <li>
                                <a onclick= 'changeType("trouble",this);' style="cursor:pointer;" >
                                    <span ><i class="fa fa-cog"></i></span>  
                                                                                     只看受限
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!-- alert notification end-->
                    <!-- user login dropdown start-->
                    <li class="dropdown" style="margin-top: 7px;">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <i class="fa fa-user"></i>
                            </span>
                            <span class="username">A组</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <li class="eborder-top">
                                <a href="documentation.html"><i class="icon_key_alt"></i> 角色切换</a>
                            </li>
                            <li >
                                <a href="#"><i class="icon_profile"></i>角色配置</a>
                            </li>
                            <li>
                                <a href="login.html"><i class="icon_key_alt"></i>退出登录</a>
                            </li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->
                </ul>
                <!-- notificatoin dropdown end-->
            </div>
      </header>      
      <!--header end-->
      
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">       
           <div class="tab-pane fade in active" id="line">     
            <div id="row_div" class="row">
              
             </div>
         </div> 
         
         <div class="tab-pane fade" id="home">
                <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <table class="table  table-advance table-hover table-bordered">
                               		<tr>
                                       <th style="width:13%;" >机场名称</th>
                                       <th style="width:7%;" >机场编号</th>
                                       <th style="width:11%;text-align:center;">限制开始</th>
                                       <th style="width:11%;text-align:center;">限制结束</th>
                                       <th style="text-align:center;">限制问题</th>
                                       <th style="width:7%;text-align:center;">功能</th>
                                    </tr>
                                    <tbody id="airportTbody">
                                	</tbody>
                              </table>
                            </section>
                        </div>
                    </div>
        </div>
   
        </section>
      </section>
  

  
      <!--main content end-->
  </section>
  <!-- container section start -->
	 <!-- layDate -->
    <script src="/static/lib/laydate/laydate.js"></script>
	
    <!-- javascripts -->
    <script src="/static/lib/jquery.js"></script>
	<script src="/static/lib/jquery-ui-1.10.4.min.js"></script>
    <script src="/static/lib/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/static/lib/jquery-ui-1.9.2.custom.min.js"></script>
    <!-- bootstrap -->
    <script src="/static/lib/bootstrap.min.js"></script>
    <!-- nice scroll -->
    <script src="/static/lib/jquery.scrollTo.min.js"></script>
    <script src="/static/lib/jquery.nicescroll.js" type="text/javascript"></script>
    <!--custome script for all page-->
    <script src="/static/lib/scripts.js"></script>
    <!-- layer弹出层 -->
    <script src="/static/lib/layer/layer.js"></script>
   
    
  	<script src="/static/js/myBase.js"></script>
  	<script src="/static/js/index.js"></script>
  </body>
</html>
