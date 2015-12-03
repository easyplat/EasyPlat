<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  User: Fish
  Date: 2015/11/12
  Time: 16:15
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>角色新增</title>
  <link href='<c:url value="/admin/css/style.css"/>' rel="stylesheet" type="text/css" />
  <script type="text/javascript" src='<c:url value="/admin/js/jquery.js"/>'></script>
</head>
<body>

<div class="place">
  <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">系统管理</a></li>
    <li><a href="#">角色管理</a></li>
    <li><a href="#">角色新增</a></li>
  </ul>
</div>

<div class="formbody">
  <div class="formtitle"><span>基本信息</span></div>
  <form action="${action}" method="post" modelAttribute="role">
    <input type="hidden" name="id" value="${entity.id}"/>
  <ul class="forminfo">
    <li><label>角色名称</label><input name="name" value="${entity.name}" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    <li><label>角色状态<b>*</b></label>
      <div class="vocation">
        <select class="state">
          <option value="0">禁用</option>
          <option value="1">启用</option>
        </select>
      </div>
    </li>
    <li><label>是否审核</label><cite><input name="" type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />否</cite></li>
    <li><label>角色描述</label><textarea name="description" cols="" rows="" class="textinput">${entity.description}</textarea></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/>&nbsp;&nbsp;<input name="" type="button" class="btn" value="返回"/></li>
  </ul>
  </form>
</div>

</body>
</html>
