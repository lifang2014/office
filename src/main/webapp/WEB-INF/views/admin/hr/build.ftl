<!DOCTYPE HTML>
<head>
	<meta charset="utf-8"/>
	<title></title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${base}/resources/back/css/layout.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/resources/back/css/jquery-ui-1.10.4.min.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/resources/back/css/custom/hr-all.css"/>
	<#--<link rel="stylesheet" type="text/css" href="${base}/resources/common/tab/css/tab_select_style.css"/>-->
	<link rel="stylesheet" type="text/css" href="${base}/resources/common/tab/css/tab_styles.css"/>

	<script type="text/javascript" src="${base}/resources/back/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="${base}/resources/back/js/hideshow.js"></script>
	<script type="text/javascript" src="${base}/resources/back/js/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="${base}/resources/back/js/jquery.equalHeight.js"></script>
    <script type="text/javascript" src="${base}/resources/back/js/jquery-ui-1.10.4.min.js"></script>
    <script type="text/javascript" src="${base}/resources/back/js/jquery.ui.datepicker-zh-CN.js"></script>
    <script type="text/javascript" src="${base}/resources/common/layer/layer.js"></script>
	<#--<script type="text/javascript" src="${base}/resources/common/tab/js/tab_select_left_script.js"></script>-->
	<#--<script type="text/javascript" src="${base}/resources/common/tab/js/tab_select_right_script.js"></script>-->
	<script type="text/javascript" src="${base}/resources/common/tab/js/tab_scripts.js"></script>

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

					<div class="container_11">
						<div class="con_nav">
							${msg("hr.title.org.structure")}
						</div>
					</div>

                    <div class="container_12" style="float: right;">
                        <ul class="tabs_12">
                            <li><a href="#tab1_12">${msg("hr.title.msg")}</a></li>
                            <li><a href="#tab2_12">${msg("hr.title.personal")}</a></li>
                            <li><a href="#tab3_12">${msg("hr.title.archives")}</a></li>
                            <li><a href="#tab4_12">${msg("hr.title.salary")}</a></li>
                        </ul>
                        <div class="tab_container_12">
                            <div id="tab1_12" class="tab_content_12">
								<!-- 个人信息 START -->
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
                                        <td class="td_title">${msg("common.field.birthday")}</td>
                                        <td class="td_content">1991-10-01</td>
                                        <td class="td_title">${msg("common.field.age")}</td>
                                        <td class="td_content">23</td>
                                    </tr>
                                    <tr>
                                        <td class="td_title">${msg("common.field.tel")}</td>
                                        <td class="td_content">156 1875 7547</td>
                                        <td class="td_title">${msg("common.field.email")}</td>
                                        <td class="td_content">jerry.2012@qq.com</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td class="td_title">${msg("common.field.qq")}</td>
                                        <td class="td_content">297177122</td>
                                        <td class="td_title">${msg("common.field.msn")}</td>
                                        <td class="td_content">297427434</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td class="td_title">${msg("common.field.phyle")}</td>
                                        <td class="td_content">汉族</td>
                                        <td class="td_title">${msg("common.field.politacal")}</td>
                                        <td class="td_content">群众</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td class="td_title">${msg("common.field.native")}</td>
                                        <td class="td_content">上海闵行</td>
                                        <td class="td_title">${msg("common.field.marriage")}</td>
                                        <td class="td_content">未婚</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td class="td_title">${msg("common.field.address")}</td>
                                        <td class="td_content" colspan="3">江西省赣州市潭口镇XXX大道XXX小区XXX栋XXX室</td>
                                    </tr>
                                    <tr>
                                        <td colspan="5" class="td_row_title">${msg("common.field.emp.status")}</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td class="td_title">${msg("common.field.emp.type")}</td>
                                        <td class="td_content">正式</td>
                                        <td class="td_title">${msg("common.field.emp.status")}</td>
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
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td class="td_title">${msg("common.field.belong.position")}</td>
                                        <td class="td_content">研发部</td>
                                        <td class="td_title">${msg("common.field.belong.job")}</td>
                                        <td class="td_content">研发工程师</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td class="td_title">${msg("common.field.start.position")}</td>
                                        <td class="td_content">2014-06-28</td>
                                        <td class="td_title">${msg("common.field.position.level")}</td>
                                        <td class="td_content">2014-06-28</td>
                                    </tr>
                                    </tbody>
                                </table>
								<!-- 个人信息 END -->
                            </div>
                            <div id="tab2_12" class="tab_content_12">
                                <h2>表单</h2>
                            </div>
                            <div id="tab3_12" class="tab_content_12">
                                <!-- 档案信息 START -->
                                <table class="tablesorter vote_list" id="tb_hr" cellspacing="0">
                                    <tbody id="vote_list">
                                    <tr>
                                        <td colspan="10">${msg("hr.title.edu")}</td>
                                    </tr>
                                    <tr>
										<td>&nbsp;</td>
                                        <td>${msg("common.hr.field.final.edu")}</td>
                                        <td>&nbsp;</td>
                                        <td>${msg("common.hr.field.major")}</td>
                                        <td colspan="2">&nbsp;</td>
                                        <td>${msg("common.hr.field.school")}</td>
                                        <td colspan="3">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>${msg("common.hr.field.school.name")}</td>
                                        <td>${msg("common.hr.field.study.type")}</td>
                                        <td>${msg("common.hr.field.major.bol")}</td>
                                        <td>${msg("common.hr.field.edu")}</td>
                                        <td>${msg("common.hr.field.degree.type")}</td>
                                        <td>${msg("common.hr.field.degree")}</td>
                                        <td>${msg("common.start.time")}</td>
                                        <td>${msg("common.end.time")}</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>财经大学</td>
                                        <td>全日制</td>
                                        <td>计算机</td>
                                        <td>本科</td>
                                        <td>科技类</td>
                                        <td>学士学位</td>
                                        <td>2010-09</td>
                                        <td>2014-06</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>财经大学</td>
                                        <td>全日制</td>
                                        <td>计算机</td>
                                        <td>本科</td>
                                        <td>科技类</td>
                                        <td>学士学位</td>
                                        <td>2010-09</td>
                                        <td>2014-06</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>财经大学</td>
                                        <td>全日制</td>
                                        <td>计算机</td>
                                        <td>本科</td>
                                        <td>科技类</td>
                                        <td>学士学位</td>
                                        <td>2010-09</td>
                                        <td>2014-06</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td colspan="10">${msg("hr.title.work.exp")}</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>${msg("common.hr.field.work.start")}</td>
                                        <td colspan="2">&nbsp;</td>
                                        <td>${msg("common.hr.field.work.count")}</td>
                                        <td colspan="2">&nbsp;</td>
                                        <td colspan="3">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td colspan="2">${msg("common.hr.field.work.company")}</td>
                                        <td colspan="1">${msg("common.hr.field.work.dept")}</td>
                                        <td>${msg("common.hr.field.work.position")}</td>
                                        <td>${msg("common.start.time")}</td>
                                        <td>${msg("common.end.time")}</td>
                                        <td colspan="3">${msg("common.desc")}</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td colspan="2">江西南昌圈圈移动互联</td>
                                        <td colspan="1">移动互联部</td>
                                        <td>Java开发工程师</td>
                                        <td>2013-07-01</td>
                                        <td>2014-06-01</td>
                                        <td colspan="3">--</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td colspan="2">江西南昌圈圈移动互联</td>
                                        <td colspan="1">移动互联部</td>
                                        <td>Java开发工程师</td>
                                        <td>2013-07-01</td>
                                        <td>2014-06-01</td>
                                        <td colspan="3">--</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td colspan="2">江西南昌圈圈移动互联</td>
                                        <td colspan="1">移动互联部</td>
                                        <td>Java开发工程师</td>
                                        <td>2013-07-01</td>
                                        <td>2014-06-01</td>
                                        <td colspan="3">--</td>
                                    </tr>
                                    <tr>
                                        <td colspan="10">${msg("hr.title.train")}</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>${msg("common.start.time")}</td>
                                        <td>${msg("common.end.time")}</td>
                                        <td colspan="2">${msg("common.hr.field.train.company")}</td>
                                        <td colspan="2">${msg("common.hr.field.train.content")}</td>
                                        <td colspan="3">${msg("common.hr.field.train.certification")}</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>2013-10-10</td>
                                        <td>2014-10-10</td>
                                        <td colspan="2">XXXXXXXX</td>
                                        <td colspan="2">XXXXXXXXX</td>
                                        <td colspan="3">$XXXXXXXXX</td>
                                    </tr>

                                    </tbody>
                                </table>
                                <!-- 档案信息 END -->
                            </div>
                            <div id="tab4_12" class="tab_content_12">
                                <h2>表单</h2>
                            </div>
						</div>
					</div>

					<#--<div id="tab_select_right" class="tab_select" style="margin-top:-5px;float:left;width: 100%;min-width: 830px;">-->
                        <#--<div class="tabList">-->
                            <#--<ul class="clearfix">-->
                                <#--<li class="cur">${msg("hr.title.msg")}</li>-->
                                <#--<li>${msg("hr.title.personal")}</li>-->
                                <#--<li>${msg("hr.title.archives")}</li>-->
                                <#--<li>${msg("hr.title.salary")}</li>-->
                            <#--</ul>-->
                        <#--</div>-->
                        <#--<div class="tabCon" style="width: 100%;height: 360px;min-width: 830px;">-->
                            <#--<div class="cur">断桥残雪、千百度、幻听、想象之中</div>-->
                            <#--<div>红尘客栈、牛仔很忙、给我一首歌的时间、听妈妈的话</div>-->
                            <#--<div>被风吹过的夏天、江南、一千年以后</div>-->
                            <#--<div>十年、K歌之王、浮夸</div>-->
                        <#--</div>-->
                    <#--</div>-->

					<!-- 组织架构  -->
					<!--
					<article class="module width_quarter">
				       <header>
				    		<h3 class="tabs_involved">${msg("hr.title.org.structure")}</h3>
				       </header>
				       <table class="tablesorter vote_list" cellspacing="0">
				           <tbody id="vote_list">
				           </tbody>
				       </table>
				    </article>
					-->
					<!-- 基本信息 -->
					<!--
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

				        </div>
				    </article>
					-->
				</div>
		   		<!--活动设置选项卡结束-->
			</div><!-- end of .tab_container -->
		</article><!-- end of content manager article -->
	</section>
</body>

</html>