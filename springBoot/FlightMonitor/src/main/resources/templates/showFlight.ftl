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
  </head>
  <script >
  </script>
  <body>
  	<div id="notamTable_div">
  		<table id='infoTable' class='table table-hover table-advance table-hover table-bordered'>
  				<tr>
				  	<th style='width:10%;' >四码</th> 
					<th style='width:20%;text-align:center;'>开始时间</th> 
					<th style='width:20%;text-align:center;'>结束时间</th> 
					<th >限制问题</th></tr>
				</tr>
  			<tbody>
  				<#assign slist=Map["list"]/>     
				   <#list slist as item>  
				   		<tr>
				   			<td>${item.getAirport4code()}</td>
				   			<td>${item.getStartTime()?string('yyyy-MM-dd HH:mm')}</td>
				   			<td>${item.getEndTime()?string('yyyy-MM-dd HH:mm')}</td>
				   			<td>${item.getContent()}</td>
				   		</tr>
				   </#list>  
			<tbody>
		</table>
  	</div>
  
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