/**
 * @author Administrator
 */
function userBack(ctx) {
	// 导航栏点击事件
	$(".userpower").click(function() {
		addtabs("loginPanel");
	});
	$(".powerchange").click(function() {
		addtabs("loginPanel");
	});

	// 添加tab页面
	function addtabs(tittle) {
		var index = 0;
		index++;
		$('#tt')
				.tabs(
						'add',
						{
							title : '用户管理',
							content : '<iframe scrolling="yes" framebirder="0" src="/exceltodatabase/user/redirct.list?address=user/userdata" style="width:100%;height:100%;"/>',
							iconCls : 'icon-save',
							closable : true
						});
	}
}