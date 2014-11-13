

$(document).ready(function(){
		var count = 1000;
		$("#tb_small_menu").click(function(e){
			var $current_tr = $(e.target).parents("tr");
			var $tr_obj = $current_tr.parent();
			var tr_current_count = $(e.target).closest("tr").index() + 0 + 1;
			if(e.target.id=='list_icon_add'){
				var $menuIsSystem = $("input[name=menu_system]:checked").val();
				var $smallMenuName = $current_tr.find("#smallmenu_name").val();
				var $smallMenuPath = $current_tr.find("#smallmenu_path").val();
				var $smallMenuIsSystem = $current_tr.find("input[name=smallmenu_system_" + count +"]:checked").val();
				count ++;
				if(tr_current_count==1){
					var $menuName = $("#menu_name").val();
					var $menuRank = $("#menu_rank").val()
					//保存菜单
					saveMenu($menuName, $menuRank, $menuIsSystem, $smallMenuName, $smallMenuPath, $smallMenuIsSystem,count,$tr_obj,$current_tr,e);
				}else{
					var menu_id = $("#menu_id").val();
					saveSubMenu(menu_id,$smallMenuName, $smallMenuPath, $smallMenuIsSystem,count,$tr_obj,$current_tr,e);
				}
			}else if(e.target.id=='list_icon_del'){
				var submenu_id = $current_tr.find("#submenu_id").val();
				if(tr_current_count > 1){
					delSmallMenu(submenu_id);
					//$current_tr.remove();
				}else{
					delSmallMenu(submenu_id);
				}
			}else if(e.target.id=='list_icon_edit'){
				
			}else if(e.target.id=='list_icon_save'){
				
			}else if(e.target.id=='edit_icon_add'){
				var html = addSmallMenuHtml(count);
				$tr_obj.append(html);
			}else if(e.target.id=='edit_icon_edit'){
				
			}else if(e.target.id=='edit_icon_del'){
				
			}else if(e.target.id=='edit_icon_save'){
				
			}
			
		
		function saveSubMenu($menu_id,$smallMenuName,$smallMenuPath,$smallMenuIsSystem,count,$tr_obj,$current_tr,e){
			if(isEmpty($menu_id)){
				layer.msg("系统异常,请稍后再试...",1,{type:8,shade:false});
				return;
			}
			if(isEmpty($smallMenuName)){
				layer.msg("子菜单名称不允许为空",1,{type:8,shade:false});
				return;
			}
			if(isEmpty($smallMenuPath)){
				layer.msg("访问链接不允许为空",1,{type:8,shade:false});
				return;
			}
			$.ajax({
				type:'POST',
				url:'../../admin/submenu/save.html',
				data:{menuId:$menu_id,subMenuName:$smallMenuName,subMenuPath:$smallMenuPath,subMenuIsSystem:$smallMenuIsSystem},
				dataType:'json',
				success:function(data){
					if(data.error_code==1000){
						layer.msg("保存成功",1,{type:1,shade:false});
						var content = $.parseJSON(data.content);
						$current_tr.find("#submenu_id").val(content.submenu_id);
						var html = addSmallMenuHtml(count);
						$tr_obj.append(html);
						$(e.target).css("display","none");
						$current_tr.find("#list_icon_edit").css("display","inline");
					}else{
						layer.msg(data.error_text,1,{type:8,shade:false});
					}
				}
			});
		}	
	
		function saveMenu($menuName, $menuRank, $menuIsSystem, $smallMenuName, $smallMenuPath, $smallMenuIsSystem,count,$tr_obj,$current_tr,e){
			if(isEmpty($menuName)){
				layer.msg("菜单名称不允许为空",1,{type:8,shade:false});
				return;
			}
			if(isEmpty($menuRank)){
				$menuRank = 0;
			}
			if(isEmpty($smallMenuName)){
				layer.msg("子菜单名称不允许为空",1,{type:8,shade:false});
				return;
			}
			if(isEmpty($smallMenuPath)){
				layer.msg("访问链接不允许为空",1,{type:8,shade:false});
				return;
			}
			$.ajax({
				type:'POST',
				url:'../../admin/menu/save.html',
				data:{menuName:$menuName, menuRank:$menuRank, menuIsSystem:$menuIsSystem, subMenuName:$smallMenuName, subMenuPath:$smallMenuPath, subMenuIsSystem:$smallMenuIsSystem},
				dataType:'json',
				success:function(data){
					if(data.error_code==1000){
						layer.msg("保存成功",1,{type:1,shade:false});
						var content = $.parseJSON(data.content);
						$("#menu_id").val(content.menu_id);
						$current_tr.find("#submenu_id").val(content.submenu_id);
						var html = addSmallMenuHtml(count);
						$tr_obj.append(html);
						$(e.target).css("display","none");
						$current_tr.find("#list_icon_edit").css("display","inline");
					}else{
						layer.msg(data.error_text,1,{type:8,shade:false});
					}
				}
			});
			
		}
		
		
		function delSmallMenu(submenu_id){
			$.ajax({
				url:'../submenu/delete.html',
				type:'POST',
				data:{subMenuId:submenu_id},
				dataType:'json',
				success:function(data){
					if(data.error_code==1000){
						layer.msg(data.error_text,1,{type:1,shade:false});
					}else{
						layer.msg(data.error_text,1,{type:8,shade:false});
					}
				}
			});
		}

		function addSmallMenuHtml(count){
			var menu_title_name = "菜单名称";
			var menu_small_title_path = "访问路径";
			var menu_title_status = "菜单类型";
			var common_status_enabled = "系统菜单";
			var common_status_disabled = "普通菜单";
			var common_title_add = "新增";
			var common_title_edit = "编辑";
			var common_title_delete = "删除";
			var common_title_save = "保存";
	   		var html = "<tr>"+
				"<td class='vote_list_td'>"+
				"	<div style='min-width:450px;height:30px;line-height:30px;'>"+
				"		<span class='td_span'>"+ menu_title_name +"</span>"+
				"		<input type='text' placeholder='' name='smallmenu_name' id='smallmenu_name'/>"+
				"		<input type='hidden' id='submenu_id'/>" +
				"	</div>"+
				"	<div style='min-width:450px;height:30px;line-height:30px;'>"+
				"		<span class='td_span'>"+menu_small_title_path+"</span>"+
				"		<input type='text' placeholder='' name='smallmenu_name' id='smallmenu_path'/>"+
						
				"	<span class='td_span' style='margin-left:25px;'>"+menu_title_status+"</span>"+
				"	<input type='radio' checked name='smallmenu_system_" + count + "' value='true' id='smallmenu_system_"+ count +"'>"+
				"	<label for='smallmenu_system_1" + count +"'>" + common_status_enabled +"</label>"+
				"	&nbsp;&nbsp;"+
				"	<input type='radio' name='smallmenu_system_" + count + "' value='false' id='smallmenu_system_2"+ count +"'>"+
				"	<label for='smallmenu_system_2" + count +"'>" + common_status_disabled +"</label>"+
					
				"	<div class='vote_list_td_div'>"+
	        	"		<input type='image' id='list_icon_add' title='"+common_title_add+"' class='icon' src='../../resources/common/images/icon/ico_add.gif'>"+
	        	"		<input type='image' id='list_icon_edit' title='"+common_title_edit+"' class='icon' src='../../resources/common/images/icon/ico_edit.png'>"+
	        	"		<input type='image' id='list_icon_del' title='"+common_title_delete+"' class='icon' src='../../resources/common/images/icon/ico_delete.png'>"+
	        	"		<input type='image' id='list_icon_save' title='"+common_title_save+"' class='icon' src='../../resources/common/images/icon/ico_save.png'>"+
				"		<div>"+
				"	</div>"+
				"</td>"+
			"</tr>";
	   		return html;
		}
	
		function isEmpty(obj){
			if(obj==null || obj==''){
				return true;
			}else{
				return false;
			}
		}

	});
	
});



	
