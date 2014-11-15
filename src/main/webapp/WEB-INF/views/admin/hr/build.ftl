<!DOCTYPE HTML>
<head>
	<meta charset="utf-8"/>
	<title></title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${base}/resources/back/css/layout.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/resources/back/css/jquery-ui-1.10.4.min.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/resources/back/css/custom/hr-all.css"/>

	<script type="text/javascript" src="${base}/resources/back/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="${base}/resources/back/js/hideshow.js"></script>
	<script type="text/javascript" src="${base}/resources/back/js/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="${base}/resources/back/js/jquery.equalHeight.js"></script>
    <script type="text/javascript" src="${base}/resources/back/js/jquery-ui-1.10.4.min.js"></script>
    <script type="text/javascript" src="${base}/resources/back/js/jquery.ui.datepicker-zh-CN.js"></script>
    <script type="text/javascript" src="${base}/resources/common/layer/layer.js"></script>

	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".tablesorter").tablesorter();
			$(".tab_content").hide(); //Hide all content
			$("ul.tabs li:first").addClass("active").show(); //Activate first tab
			$(".tab_content:first").show(); //Show first tab content
			$("ul.tabs li").click(function() {
				$("ul.tabs li").removeClass("active"); //Remove any "active" class
				$(this).addClass("active"); //Add "active" class to selected tab
				$(".tab_content").hide(); //Hide all tab content
				var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
				$(activeTab).fadeIn(); //Fade in the active ID content
				resizeMain();
				return false;
			});	
			function resizeMain(){
				var main = $(window.parent.document).find("#main");
				var thisheight = $(document).height()+30;
				main.height(thisheight);
			}
		});
	</script>


</head>


<body style="overflow-y:hidden">	
	<section id="main" class="column" style="width:100%;min-width:980px;">
		<article class="module width_full">
			<header>
				<h3 class="tabs_involved">${msg("hr.title.name")}</h3>
				<#--<ul class="tabs">-->
					<#--<li><a href="#tab1">1、${msg("menu.title.add")}</a></li>-->
				<#--</ul>-->
			</header>
			<div class="tab_container">

				<div id="tab1" class="tab_content">
					<!-- 组织架构  -->
					<article class="module width_quarter">
				       <header>
				    		<h3 class="tabs_involved">${msg("hr.title.org.structure")}</h3>
				       </header>
				       <table class="tablesorter vote_list" cellspacing="0">
				           <tbody id="vote_list">
				           </tbody>
				       </table>
				    </article>
				
					<!-- 基本信息 -->
					<article class="module width_3_quarter">
						<header>
							<h3 id="vote_title" class="tabs_involved">${msg("hr.title.name")}</h3>
							<ul class="tabs">
								<li><a href="#tab_msg1">1、${msg("hr.title.msg")}</a> </li>
                                <li><a href="#tab_msg2">2、${msg("hr.title.personal")}</a> </li>
                                <li><a href="#tab_msg3">3、${msg("hr.title.archives")}</a> </li>
								<li><a href="#tab_msg4">4、${msg("hr.title.salary")}</a> </li>
							</ul>
						</header>
						<div style="overflow-y: scroll;max-height: 330px;">
							<table class="tablesorter vote_list" id="tb_hr" cellspacing="0">
					           <tbody id="vote_list">
                               		<tr>
										<td class="td_face" rowspan="5">
											<img src="${base}/resources/common/images/default_face_110_135.gif" alt="username"/>
										</td>
                               		</tr>
                               		<tr>
                                        <td class="td_title">${msg("common.field.name")}</td>
                                        <td class="td_content">李四</td>
										<td class="td_title">${msg("common.field.before.name")}</td>
										<td class="td_content">- -</td>
                               		</tr>
                               		<tr>
                                        <td class="td_title">${msg("common.field.no")}</td>
                                        <td class="td_content">AJ10001</td>
                                        <td class="td_title">${msg("common.field.sex")}</td>
                                        <td class="td_content">男</td>
                               		</tr>
                                    <tr>
                                        <td class="td_title">${msg("common.field.phyle")}</td>
                                        <td class="td_content">汉族</td>
                                        <td class="td_title">${msg("common.field.politacal")}</td>
                                        <td class="td_content">群众</td>
                                    </tr>
                                    <tr>
                                        <td class="td_title">${msg("common.field.tel")}</td>
                                        <td class="td_content">156 1875 7547</td>
                                        <td class="td_title">${msg("common.field.email")}</td>
                                        <td class="td_content">jerry.2012@qq.com</td>
                                    </tr>
                                    <tr>
                                        <td colspan="5" class="td_row_title">${msg("common.field.emp.status")}</td>
                                    </tr>
							   		<tr>
                                        <td>&nbsp;</td>
										<td class="td_title">${msg("common.field.emp.type")}</td>
										<td class="td_content">正式</td>
										<td class="td_title">${msg("common.field.emp.status")}:</td>
										<td class="td_content">在职</td>
							   		</tr>
							   		<tr>
										<td>&nbsp;</td>
										<td class="td_title">${msg("common.field.start.date")}</td>
										<td class="td_content">2014-06-28</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
							   		</tr>
                                    <tr>
                                        <td colspan="5" class="td_row_title">${msg("common.field.position")}</td>
                                    </tr>
					           </tbody>
					       </table>
				       <div>
				    </article>
			    
				</div>
		   		<!--活动设置选项卡结束-->
			</div><!-- end of .tab_container -->
		</article><!-- end of content manager article -->
	</section>
</body>

</html>