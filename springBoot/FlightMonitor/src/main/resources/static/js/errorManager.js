$(function(){
	$('#type_select').select2({
		minimumResultsForSearch: -1,
		width:"100px"
	});
	laydate.render({
		  elem: '#start_time_input',
		  type: 'date',
		  format:'yyyy-MM-dd'
	});
	
	laydate.render({
		  elem: '#end_time_input',
		  type: 'date',
		  format:'yyyy-MM-dd'
	});
	
	$("#find_button").click(function(){
		reloadTable();
	});
	
	reloadTable();
});

function reloadTable(){
	var url ="/reloadErrorTable?startTime="+$("#start_time_input").val()+"&endTime="+$("#end_time_input").val()
		+"&type="+$("#type_select").val();
	$("#tbody_content").empty();
	var strs = "";
	$.get(url,function(res,status){
			$.each(res,function(i,item){
				strs += "<tr><td >"+item.type+"</td>"
					+ " <td >"+ new Date(item.createTime).format("yyyy-MM-dd hh:mm") +"</td>"
					+ " <td >"+ item.remark +"</td>"
					+ " <td >"+ item.errorId +"<td></tr>";
			});
			$("#tbody_content").html(strs);
			layui.use('table', function(){
				var table = layui.table;
				table.init('parse-table-demo', { 
					page:true
					,limit:10
					,width:645
					,page:{
						limits:[10,res.length]
					}
				}); 
			});
	});
}

function showContent(id){
	parent.layer.open({
		  type: 2,
		  title: false,
		  area: ['550px', '550px'],
		  shadeClose: true,
		  content: "/showErrorContent?id="+id
	});
}
