<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>schoolmate.help</title>
<#include "/templates/admin/head.ftl"/>
<script type="text/javascript">
$(function(){
        Cms.lmenu('lmenu');
    });
</script>
<style>
h3{ padding:0; margin:0; font-weight:normal; font-size:12px;}
</style>
</head>
<body class="lbody">
<div class="left">
<#include "/templates/admin/date.ftl"/>
     <ul class="w-lful"><li><a href="user_right.rk" target="rightFrame"><@s.m "global.admin.index"/></a></li></ul>
	<@perm_chow perm="user">
	<h3>基础数据管理</h3>
	<div style="margin:0; padding:0;">
		<div class="leftmenuBG"><a href="../dic/school/list" target="rightFrame"><@s.m "admin.global.dic.school.list"/></a></div>
        <div class="leftmenuBG"><a href="../dic/area/list" target="rightFrame"><@s.m "admin.global.dic.area.list"/></a></div>
	</div>
        <div style="margin:0; padding:0;">
            <div class="leftmenuBG"><a href="../dic/list" target="rightFrame">aaaaaaa</a></div>
        </div>
	</@perm_chow>
</div>
</body>
</html>