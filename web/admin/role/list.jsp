<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="u" uri="utils" %>
<%--
  User: Fish
  Date: 2015/11/12
  Time: 16:14
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>角色管理</title>
  <link href='<c:url value="/admin/css/style.css"/>' rel="stylesheet" type="text/css" />
  <script type="text/javascript" src='<c:url value="/admin/js/jquery.js"/>'></script>
</head>


<body>

<div class="place">
  <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">系统管理</a></li>
    <li><a href="#">角色管理</a></li>
  </ul>
</div>

<div class="rightinfo">

  <div class="tools">
    <ul class="toolbar">
      <li class="click"><a href="/role/create"><span><img alt="添加" src="/admin/images/t01.png" /></span>添加</a></li>
      <li><a href="/role/create"><span><img src="/admin/images/t02.png" /></span>修改</a></li>
      <li><a href="/role/delete"><span><img src="/admin/images/t03.png" /></span>删除</a></li>
      <li><a href="/role/create"><span><img src="/admin/images/t04.png" /></span>统计</a></li>
    </ul>
    <ul class="toolbar1">
      <li><span>${param.resultMsg}</span></li>
      <li><span><img src="/admin/images/t05.png" /></span>高级查询</li>
    </ul>
  </div>

  <table class="tablelist">
    <thead>
    <tr>
      <th><input name="" type="checkbox" value="" checked="checked"/></th>
      <th>编号<i class="sort"><img src="/admin/images/px.gif" /></i></th>
      <th>标题</th>
      <th>状态</th>
      <th>发布时间</th>
      <th>修改时间</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
      <c:forEach var="record" items="${pager.records}">
    <tr>
      <td><input name="id" type="checkbox" value="${record.id}" /></td>
      <td>${record.id}</td>
      <td>${record.name}</td>
      <td>${record.state}</td>
      <td><fmt:formatDate value="${record.dateCreated}"  type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
      <td><fmt:formatDate value="${record.dateModified}"  type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
      <td><a href="/role/edit/${record.id}" class="tablelink">修改</a>&nbsp;|&nbsp;<a class="tablelink" href="/role/delete/${record.id}">删除</a></td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
  <u:paging page="1" pageSize="20" href="/article/list/{page}/{pageSize}" paras="a=1&b=2" totalRecords="100" pageCount="5"/>
  <div class="tip">
    <div class="tiptop"><span>提示信息</span><a></a></div>

    <div class="tipinfo">
      <span><img src="/admin/images/ticon.png" /></span>
      <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
      </div>
    </div>

    <div class="tipbtn">
      <input name="" type="button"  class="sure" value="确定" />&nbsp;
      <input name="" type="button"  class="cancel" value="取消" />
    </div>

  </div>
</div>
<script type="text/javascript">
  $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
