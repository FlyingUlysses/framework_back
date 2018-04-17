var type = "all";
var reloadFlag = null;
var reloadTime = 5000;
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
		layer.confirm('确认要导入即时数据吗？这将需要一定时间。', {
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
	reloadAirPortTable();
	
	//定时30秒自动刷新数据
	reloadFlag = setTimeout('reload()',reloadTime);
});

function reload(){
	$("#start_time_input").attr("disabled","disabled");
	$("#end_time_input").attr("disabled","disabled");
	$("#start_reload_li").hide();
	$("#stop_reload_li").show();
	$("#start_time_input").val( new Date().format("yyyy-MM-dd hh:mm") );
	$("#end_time_input").val( new Date(new Date().getTime() + 6*3600*1000).format("yyyy-MM-dd hh:mm") );
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

function showFlight(start,end,startName,endName,number){
	layer.open({
		  type: 2,
		  title: "航班 "+number+" 【"+startName+" - "+endName+"】受限情况",
		  area: ['700px', '350px'],
		  shadeClose: true,
		  content: '/index/showFlight?start='+start+"&end="+end+"&start_name="+startName+"&end_name="+endName
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
	$.post(url,{type:"all",start_time:start_time,end_time:end_time},function(jsonStr,status){
		var obj = JSON.parse(jsonStr);
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

function reloadAirportList(){
	var start_time = $("#start_time_input").val();
	var end_time = $("#end_time_input").val();
	var url = "/index/getFlightListByTime";
	$.post(url,{type:type,start_time:start_time,end_time:end_time},function(jsonStr,status){
		var jsonArray = JSON.parse(jsonStr);
		var strs = "";
		$.each(jsonArray,function(i,item){
			if(item.flag){
				strs +="<div class='col-lg-2 col-md-2 col-sm-12 col-xs-12' style='cursor:pointer' onclick='showFlight(\""+item.dep4code+"\","
				+ "\""+item.arr4code+"\","+"\""+item.departureAirportName+"\","+"\""+item.arrivalAirportName+"\","+"\""+item.flightNumber+"\");'><div class='info-box red-bg'>";
			}else
				strs +="<div class='col-lg-2 col-md-2 col-sm-12 col-xs-12' ><div class='info-box green-bg'>";
			strs +=  "<div class='count'>航班 "+ item.flightNumber +"</div>"
					 + "<div class='count'>"+ item.departureAirportName +" - "+ item.arrivalAirportName +"</div>"
					 + "<div style='padding-top:3px;padding-bottom:3px;'>"
					 + 		"<div class='title' >预计起飞: "+item.stdStr+"</div> <div class='title'  >预计到达: "+item.staStr+"</div>"
					 + "</div>";
			strs += "</div></div><!-- end col-->";
		});
		$("#row_div").html(strs);
	});
}

function reloadAirPortTable(){
	var url = "/index/reloadAirPortTable";
	$.get(url,function(jsonStr,status){
		var res = JSON.parse(jsonStr);
		var strs = "";
		if(res && res.length >0){
			$.each(res,function(i,item){
				if(item.notam_list.length >0 ){
					strs +="<tr><td style='vertical-align:middle;' rowspan='"+item.notam_list.length+"'>"+item.airport_name+"</td>"
					 	 + "<td style='vertical-align:middle;' rowspan='"+item.notam_list.length+"'>"+item.airport+"</td>"
						 + "<td style='vertical-align:middle;background-color: #d67373;color: #fff;' >"+item.notam_list[0].start_time+"</td>"
						 + "<td style='vertical-align:middle;background-color: #d67373;color: #fff;' >"+item.notam_list[0].end_time+"</td>"
						 + "<td style='vertical-align:middle;background-color: #d67373;color: #fff;' >"+item.notam_list[0].content+"</td>"
						 + "<td style='vertical-align:middle;background-color: #d67373;color: #fff;' >	" 
						 +		"<a class='btn btn-info  btn-sm' onclick='showAirPort(\""+item.airport+"\")'><i class='fa fa-search'>受限航班</i></a></td></tr>";
				}else{
					strs +="<tr><td style='vertical-align:middle;'>"+item.airport_name+"</td>"
						 + "<td style='vertical-align:middle;' >"+item.airport+"</td>"
						 +"<td></td><td></td><td></td><td></td></tr>";
				}
				if(item.notam_list.length >1){
					$.each(item.notam_list,function(i,item){
						if(i>0){
							strs +="<tr><td style='vertical-align:middle;background-color: #d67373;color: #fff;' >"+item.start_time+"</td>"
							 + "<td style='vertical-align:middle;background-color: #d67373;color: #fff;' >"+item.end_time+"</td>"
							 + "<td style='vertical-align:middle;background-color: #d67373;color: #fff;' >"+item.content+"</td>"
							 + "<td style='vertical-align:middle;background-color: #d67373;color: #fff;' >	" 
							 +		"<a class='btn btn-info  btn-sm' onclick='showAirPort(\""+item.airport+"\")'><i class='fa fa-search'>受限航班</i></a></td></tr>";
						}
					});
				}
			})
		}
		$("#airportTbody").html(strs);
	});
}
