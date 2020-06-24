<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div>
	<div>
		<button type="button" class="btn btn-primary btn-sm" onclick="add()">添加</button>
	</div>
	<table class="table">
		<tr>
			<td>id</td>
			<td>名称</td>
			<td>属性</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageInfo.list}" var="spec">
		<tr>
			<td>${spec.id}</td>
			<td>${spec.specName}</td>
			<td> <c:forEach items="${spec.options}" var="op" varStatus="index" > <c:if test="${index.index!=0}">,</c:if> ${op.optionName}</c:forEach> </td>
			<td>
				<button type="button" class="btn btn-primary btn-sm">修改</button>
				<button type="button" class="btn btn-danger btn-sm">删除</button>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
<script>
	function add(){
		$("#workContent").load('./spec/add');
	}
</script>