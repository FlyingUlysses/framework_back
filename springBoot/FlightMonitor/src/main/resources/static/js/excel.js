$(function(){
	$('#type_select').select2({
		minimumResultsForSearch: -1
	});
	$('#is_started_select').select2({
		minimumResultsForSearch: -1
	});
	 $("#download_select").select2({
		 minimumResultsForSearch: -1
	});
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
		reloadTable();
	});
	
	$("#export_button").click(function(){
		var url ="/excel/export?start_time="+$("#start_time_input").val()+"&end_time="+$("#end_time_input").val()+"&downloadType="+$("#download_select").val()
				+"&type="+$("#type_select").val()+"&is_start="+$("#is_started_select").val();
		window.location.href = url;
		setTimeout('reloadTable()',1500);
	});
	
	reloadTable();
});

function reloadTable(){
	var url ="/excel/reloadTable?start_time="+$("#start_time_input").val()+"&end_time="+$("#end_time_input").val()+"&downloadType="+$("#download_select").val()
			+"&type="+$("#type_select").val()+"&is_start="+$("#is_started_select").val();
	$.get(url,function(res,status){
		$("#tbody_content").empty();
		if(res != null && res.length >0){
			$("#content_div").show();
			var strs = "";
			$.each(res,function(i,item){
				if(item.isLimited == 1)
					strs += "<tr style = 'background-color:#d67373'>" ;
				else
					strs += "<tr>";
				strs += "<td >"+item.flightId+"</td>"
					+ " <td >"+ item.downloadType +"</td>"
					+ " <td >"+item.flightNumber+"</td>"
					+ " <td >"+ new Date(item.std).format("yyyy-MM-dd hh:mm") +"</td>"
					+ " <td >"+ new Date(item.sta).format("yyyy-MM-dd hh:mm") +"</td>"
					+ " <td >"+ item.dep4code +"</td>"
					+ " <td >"+ item.arr4code +"</td>"
					+ " <td >"+ item.isLimited +"</td>"
					+ " <td >"+ item.isStart +"</td></tr>";
			});
			$("#tbody_content").html(strs);
			layui.use('table', function(){
			  var table = layui.table;
		      table.init('parse-table-demo', { 
		    	  page:true
		    	  ,limit:10
		    	  ,width:997
		    	  ,page:{
		    		  limits:[10,res.length]
		    	  }
		      }); 
			});
		}else{
			$("#content_div").hide();
		}
	});
}
