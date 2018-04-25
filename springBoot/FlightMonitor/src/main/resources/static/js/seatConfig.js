var airportSelect = $("#listAirport").select2({
	 placeholder: '请选择机场',
	 width:'97%'
});


$(function(){
	reloadAirport();
	reloadListSeat();
});

function reloadListSeat(name){
	var url="/seat/listAllSeat";
	$.get(url,function(obj,status){
		if( obj != null && obj.length >0 ){
			var strs = "";
			$.each(obj,function(i,item){
				strs += "<tr><td style='cursor: pointer;' onclick='showSeat(this,\""+item.seatId+"\",\""+item.seatName+"\");'><div class='seatTd-div'>"+item.seatName+"</div></td></tr>";
			})
			$("#tableSeat").html(strs);
		}
		if(name != null && name != undefined){
			$("#tableSeat tbody td").each(function(i,item){
				if($(item).text() == name)
					$(item).attr("class","have-flag");
			});
		}
	});
}


function showSeat(e,id,name){
	$("#edit_div").show();
	$("#tableSeat tbody td[class='have-flag']").removeClass("have-flag");
	$(e).attr("class","have-flag");
	var url ="/seat/showSeat?seatId="+id;
	$.get(url,function(res,status){
		$("#seat_name_input").val(name);
		$("#seat_id_input").val(id);
		if(res != null && res.length >0){
			var tempArray = [];
			$.each(res,function(i,item){
				if(item.flag == 1)
					tempArray.push(item.airportId);
			});
			airportSelect.val(tempArray);
			airportSelect.change();
			$("#save_button").hide();
			$("#delete_button").show();
			$("#update_button").show();
		}
	});
}

function reloadAirport(){
	var url = "/seat/listAllAirport";
	var strs = "";
	$.get(url,function(res,status){
		if(res != null && res != undefined && res.length >0){
			$("#listAirport").empty();
			$.each(res,function(i,item){
				strs += "<option value ='"+ item.airportId +"'>"+ item.airport4code +"</option>"
			});
			$("#listAirport").append(strs);
		}
	});
}

function addSeat(){
	$("#edit_div").show();
	$("#tableSeat tbody td[class='have-flag']").removeClass("have-flag");
	$("#seat_name_input").val("");
	$("#seat_id_input").val("");
	airportSelect.val([]);
	airportSelect.change();
	$("#save_button").show();
	$("#delete_button").hide();
	$("#update_button").hide();
}

function saveOrUpdate(){
	var url = "/seat/saveOrUpdate";
	var obj ={};
	obj.name = $("#seat_name_input").val().trim();
	if(airportSelect.val() != null)
		obj.listAirport = airportSelect.val().join(',');
	else 
		obj.listAirport = "";
	obj.id = $("#seat_id_input").val() || "";
	$.post(url,obj,function(res,status){
		if(res!=null && res != undefined){
			if(res.flag){
				layer.msg('配置成功', {icon: 1});
				if(obj.id == ""){
					reloadListSeat(obj.name);
				}
			}else{
				layer.msg(res.msg, {icon: 2});
			}
		}
	});
}

function deleteSeat(){
	var id = $("#seat_id_input").val() || "";
	var url = "/seat/delete?id="+id;
	layer.confirm('确认要删除该条席位配置吗？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			$.get(url,function(res,status){
				if(res.flag){
					layer.msg('删除成功', {icon: 1});
					reloadListSeat();
					$("#edit_div").hide();
				}else{
					layer.msg(res.msg, {icon: 2});
				}
			});
		}, function(){
	});
	
}
