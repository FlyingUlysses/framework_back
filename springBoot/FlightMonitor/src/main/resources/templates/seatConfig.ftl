<!DOCTYPE html>
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
    <link href="/static/css/style.css" rel="stylesheet">
	<link href="/static/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
	<!-- select2 -->
	<link href="/static/lib/select2/css/select2.css" rel="stylesheet">
	<style type="text/css">
		.table-out-div{
		    display: inline-block;
		    overflow: auto;
		    margin-left: 15px;
		    height: 440px;
		    width: 200px;
		    margin-top: 15px;
		    text-shadow: 0 0 black;
		    background-color: white;
		}
		.have-flag{
			background: #009688;
			color:#fff;
		}
		.seatTd-div{
			margin-left: 30px;
		}
	</style>
  </head>
  
  <body>
  	<div >
  		<div style="width: 100%;height: 45px;background: #009688;color: #fff;">
  			<h4 style="padding-top: 0px;padding-left:8px;display: inline-block;">席位选择</h4>
  			<div style="float: right;margin-right: 25px;margin-top: 5px;">
	  			<inpt type="button" id="add_button" class="btn btn-warning  btn-sm" onclick="addSeat();"><i class="fa fa-search"> 新增</i></inpt>
  			</div>
  		</div>
  		<div class="table-out-div" >
	  		<table class="table" id="tableSeat"  style="overflow:auto;">
	  		</table>
  		</div>
  		<div id="edit_div" style="display:none;border: 1px solid;float: right;width: 470px;margin: 15px;height: 445px;">
	  		<input id="seat_id_input" type="hidden" style="width: 95%;margin: 5px;height: 35px;"  lay-verify="required"  >
  			<div>
	  			<div style="margin: 5px;font-size: 15px;"><strong>席位名称:</strong></div>
	  			<input id="seat_name_input" type="text" style="width: 95%;margin: 5px;height: 35px;"  lay-verify="required" placeholder="请输入席位名称" >
	  		</div>
	  		<div>
	  			<div style="margin: 5px;font-size: 15px"><strong>选择机场:</strong></div>
	  			<div style="margin: 5px;">
		  			<select id="listAirport" multiple="multiple">
			  		</select>
	  			</div>
	  			<div style="position: fixed;bottom: 40px;right: 25px;">
	  				<inpt style="display:none;" type="button" id="delete_button" class="btn btn-danger" onclick ="deleteSeat();"  ><i class="fa fa-trash-o"> 删除</i></inpt>
	  				<inpt style="display:none;" type="button" id="save_button" class="btn btn-warning" onclick = "saveOrUpdate()"><i class="fa fa-save"> 保存</i></inpt>	
	  				<inpt style="display:none;" type="button" id="update_button" class="btn btn-warning" onclick = "saveOrUpdate()"><i class="fa fa-save"> 修改</i></inpt>	
	  			</div>
	  		</div>
  		</div>
  	</div>
  </body>
 
	
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
		
		<!-- select2 -->
		<script src="/static/lib/select2/js/select2.js" type="text/javascript"></script>    
		<!-- layer弹出层 -->
	    <script src="/static/lib/layer/layer.js"></script>   
		
    <script src="/static/js/seatConfig.js"></script>
  </html>