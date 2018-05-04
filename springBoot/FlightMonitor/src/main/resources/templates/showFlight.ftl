<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <!-- Bootstrap CSS -->    
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="/static/css/bootstrap-theme.css" rel="stylesheet">
    <!-- font icon -->
    <link href="/static/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="/static/css/font-awesome.min.css" rel="stylesheet" />    
    <!-- Custom styles -->
	<link href="/static/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
	    <link href="/static/css/style.css" rel="stylesheet">	
  </head>
  <style>
	*, *:before, *:after {
	    -webkit-box-sizing: inherit;
	    -moz-box-sizing:inherit;
	    box-sizing: inherit;
	}
  </style>
  <script >
  </script>
  <body>
  	<section class="panel" style="margin-top: 15px;">
         <header class="panel-heading tab-bg-primary ">
             <ul class="nav nav-tabs">
                 <li class="active">
                     <a data-toggle="tab" href="#notam">通告</a>
                 </li>
                 <li class="">
                     <a data-toggle="tab" href="#route">航路</a>
                 </li>
             </ul>
         </header>
         <#assign rest=Map["rest"]/>  
             <div class="tab-content" style="maggin: 5px;">
             <!------------------------------------------ notam div ----------------------------------------------------->
                 <div id="notam" class="tab-pane active">
				  		<table id='notamTable' class='table table-hover table-advance table-hover table-bordered' style="padding: 15px">
				  				<tr>
								  	<th style='width:10%;' >四码</th> 
									<th style='width:20%;text-align:center;'>开始时间</th> 
									<th style='width:20%;text-align:center;'>结束时间</th> 
									<th >限制问题</th></tr>
								</tr>
				  			<tbody>
				  				<#if rest.notamList??>
				  					 <#list rest.notamList as item>  
								   		<tr>
								   			<td>${item.getAirport4code()}</td>
								   			<td>${item.getStartTime()?string('yyyy-MM-dd HH:mm')}</td>
								   			<td>${item.getEndTime()?string('yyyy-MM-dd HH:mm')}</td>
								   			<td>${item.getContent()}</td>
								   		</tr>
								   </#list> 
				  				</#if>
							<tbody>
						</table>
                 </div>
                  <!------------------------------------------ route div ----------------------------------------------------->
                 <div id="route" class="tab-pane">
                 		<table id='routeTable' class='table table-hover table-advance table-hover table-bordered' style="padding: 15px">
				  				<tr>
								  	<th style='width:20%;' >航路名称</th> 
									<th style='width:20%;text-align:center;'>内容</th> 
								</tr>
				  			<tbody>
				  			<#if rest.routeList??>
								   <#list rest.routeList as item>  
									   <#if item.state>
								   			<tr style="background: #d67373;">
								   		</#if>
								   		<#if !item.state>
								   			<tr >
								   		</#if>
									   			<td>${item.getCode()}</td>
									   			<td>${item.getCfp()}</td>
									   		</tr>
								   </#list> 
							</#if>
							<tbody>
						</table>
                 </div>
             </div>
     </section>
  
  
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
  </body>
  </html>