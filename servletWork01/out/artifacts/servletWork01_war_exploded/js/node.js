$(function() {

	// 添加一行
	$(".add").click(function() {
		// 创建td
		var $td1 = $("<td><input name='check' type='checkbox' value='' /></td>");
		var $td2 = $('<td><img src="img/iphone.gif" class="products" /><a href="#">苹果手机iphone5</a></td>');
		var $td3 = $("<td>￥3339元</td>");
		var $td4 = $(
			'<td><img src="img/subtraction.gif" width="20" height="20" /><input type="text" class="quantity" value="1" /><img src="img/add.gif" width="20" height="20" /></td>'
		);
		var $td5 = $('<td><a href="#" class="del">删除</a></td>');

		// 创建tr
		var $tr = $("<tr></tr>");
		// 将td加载到tr中
		$tr.append($td1).append($td2).append($td3).append($td4).append($td5);
		// 将tr加载到table中
		$("table").append($tr);
	});

	// 删除一行
	// $(".del").click(function() {
	// 	var $tr = $(this).parent().parent();
	// 	// console.log(obj[0]);
	// 	$tr.remove()
	// })
	$("table").on("click", "tr td a.del", function() {
		var $tr = $(this).parent().parent();
		// console.log(obj[0]);
		$tr.remove()
	});

	// 全选
	// $("#checkAll").click(function() {
	// 	// 获取checkAll的选择状态
	// 	var checked = $(this)[0].checked;
	// 	// console.log(checked);
	// 	// 设置其他的checkbox的checked
	// 	var $checkboxes = $("[type=checkbox]:not(#checkAll)");
	// 	for (var index = 0; index < $checkboxes.length; index++) {
	// 		// 获取的对象的类型为dom
	// 		var checkbox = $checkboxes[index];
	// 		// 设置checkbox的checked 
	// 		checkbox.checked = checked;
	// 	}
	// });
	$("#checkAll").click(function() {
		// 获取checkAll的选择状态
		// var checked = $(this).attr("checked");
		var checked = $(this).prop("checked");
		// console.log(checked)
		// 设置其他的checkbox的checked
		var $checkboxes = $("[type=checkbox]:not(#checkAll)");

		$checkboxes.each(function(index, obj) { // index：下标   obj：元素对象
			// alert(obj);// HTMLInputElement
			// $(obj).attr("checked", checked);

			// 设置checkbox的checked 
			$(obj).prop("checked", checked);
		});

	});

	// 删除多行
	$(".delete").click(function() {
		// 获取所有选择选中的checkbox（除了 id = checkAll）
		var $checkboxes = $("[type=checkbox]:not(#checkAll)");
		$checkboxes.each(function(index, obj) {
			if ($(obj).prop("checked")) {
				$(obj).parent().parent().remove();
			}
		});
	})

})
