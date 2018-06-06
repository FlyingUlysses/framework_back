$(function(){
	laydate.render({
		  elem: '#started_interval',
		  type: 'time',
		  format:'HH:mm:ss'
	});
	laydate.render({
		elem: '#started_first',
		type: 'time',
		format:'HH:mm:ss'
	});
	laydate.render({
		elem: '#wait_interval',
		type: 'time',
		format:'HH:mm:ss'
	});
	laydate.render({
		elem: '#wait_first',
		type: 'time',
		format:'HH:mm:ss'
	});
	laydate.render({
		elem: '#getFlight_interval',
		type: 'time',
		format:'HH:mm:ss'
	});
	laydate.render({
		elem: '#pageTimeGetFlight',
		type: 'time',
		format:'HH:mm:ss'
	});
});

function save(){
	layer.confirm('是否确认保存修改?', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			var url = "/config/saveAnnalyze";
			var obj = {
					getInterval : $("#getFlight_interval").val()|| "",
					pageTimeGetFlight : $("#pageTimeGetFlight").val() || "",
					waitInterval : $("#wait_interval").val() || "",
					waitInit : $("#wait_first").val() || "",
					startedInterval : $("#started_interval").val() || "",
					startedInit : $("#started_first").val() || ""
			};
			console.log(obj);
			$.post(url,obj,function(res,status){
				if(res.flag){
					layer.msg('保存成功，设置将从下次生效', {icon: 1});
					window.location.href = "/config/showAnnalyzeConfig";
				}else{
					layer.msg(rea.msg, {icon: 2});
				}
			});
		}, function(){
	});
}