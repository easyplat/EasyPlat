<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Fish
  Date: 2015/11/12
  Time: 16:14
--%>
<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<html>
<head>
	<title></title>
</head>
<body>
<table>
  <tr>
    <th>角色编号</th>
    <th>角色名称</th>
    <th>角色状态</th>
    <th>建档时间</th>
    <th>修改时间</th>
    <th>操作</th>
  </tr>
  <c:forEach var="record" items="${pager.records}">
    <tr>
      <td>${record.id}</td>
      <td>${record.name}</td>
      <td>${record.state}</td>
      <td>${record.dateCreated}</td>
      <td>${record.dateModified}</td>
      <td><a href="/role/edit/${record.id}">修改</a>&nbsp;|&nbsp;<a href="/role/delete/${record.id}">删除</a></td>
    </tr>
  </c:forEach>
</table>
<ul class="pager">
  <li><a href='/role/list/${pager.page-1}/${pager.pageSize}'>←上一页</a></li>
  <c:forEach varStatus="i" begin="1" end="${pager.pageCount}">
    <c:choose>
      <c:when test="${pager.page==i.count}">
        <li class='disabled'>${i.count}</li>
      </c:when>
      <c:otherwise>
        <li  class='active'><a href='/role/list/${i.count}/${pager.pageSize}'>${i.count}</a></li>
      </c:otherwise>
    </c:choose>
  </c:forEach>
  <li><a href='/role/list/${pager.page+1}/${pager.pageSize}'>下一页→</a></li>
</ul>
</body>
</html>
