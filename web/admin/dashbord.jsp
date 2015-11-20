<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jsapi.js"></script>
<script type="text/javascript" src="js/format+zh_CN,default,corechart.I.js"></script>		
<script type="text/javascript" src="js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="js/jquery.ba-resize.min.js"></script>

<script type="text/javascript">
		gvChartInit();
		jQuery(document).ready(function(){

		jQuery('#myTable5').gvChart({
				chartType: 'PieChart',
				gvSettings: {
					vAxis: {title: 'No of players'},
					hAxis: {title: 'Month'},
					width: 650,
					height: 250
					}
			});
		});
		</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">工作台</a></li>
    </ul>
    </div>
    
    
    <div class="mainbox">
    
    <div class="mainleft">
    
    
    <div class="leftinfo">
    <div class="listtitle"><a href="#" class="more1">更多</a>数据统计</div>
        
    <div class="maintj">  
    <table id='myTable5'>
				<caption>uimaker.com players count</caption>
				<thead>
					<tr>
						<th></th>
						<th>Jan</th>
						<th>Feb</th>
						<th>Mar</th>
						<th>Apr</th>
						<th>May</th>
						<th>Jun</th>
						<th>Jul</th>
						<th>Aug</th>
						<th>Sep</th>
						<th>Oct</th>
						<th>Nov</th>
						<th>Dec</th>
					</tr>
				</thead>
					<tbody>
					<tr>
						<th>2010</th>
						<td>125</td>
						<td>185</td>
						<td>327</td>
						<td>359</td>
						<td>376</td>
						<td>398</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>
				</tbody>
			</table>  
    </div>
    
    </div>
    <!--leftinfo end-->
    
    
    <div class="leftinfos">
    
   
    <div class="infoleft">
    
    <div class="listtitle"><a href="#" class="more1">更多</a>待办事项</div>    
    <ul class="newlist">
        <c:forEach var="record" items="${tasks.records}">
            <tr>
                <li><a href="#">${record.title}</a><b>${record.dateCreated}</b></li>
            </tr>
        </c:forEach>
    </ul>   
    
    </div>
    
    
    <div class="inforight">
    <div class="listtitle"><a href="#" class="more1">添加</a>常用工具</div>
    
    <ul class="tooli">
    <li><span><img src="images/d01.png" /></span><p><a href="#">信息资料</a></p></li>
    <li><span><img src="images/d02.png" /></span><p><a href="#">编辑</a></p></li>
    <li><span><img src="images/d03.png" /></span><p><a href="#">记事本</a></p></li>
    <li><span><img src="images/d04.png" /></span><p><a href="#">任务日历</a></p></li>
    <li><span><img src="images/d05.png" /></span><p><a href="#">图片管理</a></p></li>
    <li><span><img src="images/d06.png" /></span><p><a href="#">交易</a></p></li>
    <li><span><img src="images/d07.png" /></span><p><a href="#">档案袋</a></p></li>    
    </ul>
    
    </div>

    </div>

    </div>
    <!--mainleft end-->
    
    <div class="mainright">

    <div class="dflist">
    <div class="listtitle"><a href="#" class="more1">更多</a>最新信息</div>    
    <ul class="newlist">
        <c:forEach var="record" items="${articles.records}">
            <tr>
                <li><a href="#">${record.title}</a><b>${record.dateCreated}</b></li>
            </tr>
        </c:forEach>
    </ul>        
    </div>
    
    <div class="dflist1">
    <div class="listtitle"><a href="#" class="more1">更多</a>信息统计</div>    
    <ul class="newlist">
    <li><i>会员数：</i>2535462</li>
    <li><i>文档数：</i>5546</li>
    <li><i>普通文章：</i>2315</li>
    <li><i>软件：</i>1585</li>
    <li><i>评论数：</i>5342</li>
    </ul>        
    </div>

    </div>
    <!--mainright end-->

    </div>
</body>
<script type="text/javascript">
	setWidth();
	$(window).resize(function(){
		setWidth();	
	});
	function setWidth(){
		var width = ($('.leftinfos').width()-12)/2;
		$('.infoleft,.inforight').width(width);
	}
</script>
</html>