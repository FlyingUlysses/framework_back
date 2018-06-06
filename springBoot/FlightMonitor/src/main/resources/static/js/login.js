$(function(){
	var seatSelect = $('#seatSelect').select2({placeholder:'请选择席位...'});
	seatSelect.on("change",function(e){
		$("#seatName").val($("#seatSelect option:selected").text());
		$("#login_form").attr("action","/login");
	});
});

function validate_form(){
	if($('#seatSelect').val() == null || $('#seatSelect').val() == undefined || $('#seatSelect').val() == ""  ){
		layer.alert("请先选择席位！");
		return false;
	}else{
		return true;
	}
}