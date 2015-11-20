<%--
  User: Fish
  Date: 2015/11/12
  Time: 16:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title></title>
</head>
<body>
<form action="${action}" method="post" modelAttribute="role">
  <input type="hidden" name="id" value="${entity.id}"/>
  <table>
    <tr>
      <th>角色名称:</th>
      <td><input type="text" name="name" size="20" value="${entity.name}"/></td>
    </tr>
    <tr>
      <th>角色状态:</th>
      <td>
        <select name="state">
          <option value="0">禁用</option>
          <option value="1">启用</option>
        </select>
      </td>
    </tr>
    <tr>
      <th>角色描述:</th>
      <td><textarea name="description">${entity.description}</textarea></td>
    </tr>

    <tr>
      <td colspan="2"><input type="submit" value="保存"/></td>
    </tr>
  </table>
</form>
</body>
</html>
