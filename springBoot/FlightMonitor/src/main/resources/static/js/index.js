var type = "all";
var reloadFlag = null;
var reloadTime = 3000;
$(function(){
	
	laydate.render({
		  elem: '#start_time_input',
		  type: 'datetime',
		  format:'yyyy-MM-dd HH:mm'
	});
	
	laydate.render({
		  elem: '#end_time_input',
		  type: 'datetime',
		  format:'yyyy-MM-dd HH:mm'
	});
	
	
	$("#find_button").click(function(){
		reloadAirportList();
	});
	
	$("#reload_button").click(function(){
		layer.confirm('确认要导入即时航班数据吗？这将需要一定时间。', {
			  btn: ['确定','取消'] //按钮
			}, function(){
				syncFlight();
			}, function(){
		});
	});
	
	var tabWidth = $("#tab_div").parent().width() / 2 -180;
	$("#tab_div").css("padding-left",tabWidth);
	
	$("#line_button").click(function(){
	    $("#row_div").show();
	});
	
	$("#home_button").click(function(){
	    $("#row_div").hide();
	});
	
	reloadAirportList();
	
	//定时3秒自动刷新数据
	reloadFlag = setTimeout('reload()',reloadTime);
});

function reload(){
	$("#start_time_input").attr("disabled","disabled");
	$("#end_time_input").attr("disabled","disabled");
	$("#start_reload_li").hide();
	$("#stop_reload_li").show();
	$("#start_time_input").val( new Date().format("yyyy-MM-dd hh:mm") );
	$("#end_time_input").val( new Date(new Date().getTime() + (3*3600*1000) ).format("yyyy-MM-dd hh:mm") );
	reloadAirportList();
	reloadFlag = setTimeout('reload()',reloadTime);
}

function stopReload(){
	$("#start_time_input").removeAttr("disabled");   
	$("#end_time_input").removeAttr("disabled");   
	$("#start_reload_li").show();
	$("#stop_reload_li").hide();
	clearTimeout(reloadFlag);
}

function changeType(patten,e){
	$("#global_type_span").html($(e).text().trim());
	type = patten;
	reloadAirportList();
}

function showFlight(id,startName,endName,number){
	layer.open({
		  type: 2,
		  title: "航班 "+number+" 【"+startName+" - "+endName+"】受限情况",
		  area: ['700px', '350px'],
		  shadeClose: true,
		  content: '/index/showFlight?flightId='+id
	});
}

function syncFlight(){
	//loading层
	var lodingIndex = layer.load({
	  shade: [0.1,'#fff'] //0.1透明度的白色背景
	});
	var start_time = $("#start_time_input").val();
	var end_time = $("#end_time_input").val();
	var url = "/index/syncFlight";
	$.post(url,{type:"all",start_time:start_time,end_time:end_time},function(obj,status){
		if(obj.flag){
			reloadAirportList();
			layer.close(lodingIndex);
			layer.msg('导入成功', {icon: 1});
		}else{
			layer.close(lodingIndex);
			layer.msg(obj.msg, {icon: 2});
		}
	});
}


function showAirPort(airport){
	layer.open({
		  type: 2,
		  title: false,
		  area: ['520px', '225px'],
		  shadeClose: true,
		  content: "/index/showAirport/"+airport
	});
}

function showSeatConfig(){
	layer.open({
		  type: 2,
		  title: false,
		  area: ['750px', '530px'],
		  shadeClose: true,
		  content: "/index/showSeatConfig"
	});
}


function reloadAirportList(){
	var start_time = $("#start_time_input").val();
	var end_time = $("#end_time_input").val();
	var url = "/index/ListFlightByTime";
	$.post(url,{type:type,start_time:start_time,end_time:end_time},function(jsonArray,status){
		var strs = "";
		$.each(jsonArray,function(i,item){
			if(item.state ==2 ){
				strs +="<div class='col-lg-2 col-md-2 col-sm-12 col-xs-12' style='cursor:pointer' onclick='showFlight(\""+item.flightId+"\",\""+item.depCityName+"\"," 
					 +"\""+item.arrCityName+"\",\""+item.flightNumber+"\");'><div class='info-box red-bg'>";
			}else
				strs +="<div class='col-lg-2 col-md-2 col-sm-12 col-xs-12' ><div class='info-box green-bg'>";
			strs +=  "<div class='count'>航班 "+ item.flightNumber +"</div>"
					 + "<div class='count'>"+ item.depCityName +" - "+ item.arrCityName +"</div>"
					 + "<div style='padding-top:3px;padding-bottom:3px;'>"
					 + 		"<div class='title' >预计起飞: "+new Date(item.std).format("yyyy-MM-dd hh:mm")+"</div> <div class='title'  >预计到达: "+new Date(item.sta).format("yyyy-MM-dd hh:mm")+"</div>"
					 + "</div>";
			strs += "</div></div><!-- end col-->";
		});
		$("#row_div").html(strs);
	});
}

function logout(){
	url="/logout";
	window.location.href = url;
}

function exportExcel(){
	alert(22);
	var start_time = $("#start_time_input").val();
	var end_time = $("#end_time_input").val();
	var url = "/excel?type="+type+"&start_time="+start_time+"&end_time="+end_time;
	window.location.href = url;
}

