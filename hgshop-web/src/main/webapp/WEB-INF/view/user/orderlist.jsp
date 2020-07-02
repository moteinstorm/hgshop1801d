<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<div class="container-fluid">
	<!-- 查询结果 -->
	 <div>
	 	<table class="table">
	 		<tr>
	 			<th>id <input id="ids" type="checkbox"> </th>
	 			<th>配送地址</th>
	 			<th>总价格</th>
	 			<th>下单时间</th>
	 		</tr>
	 		<c:forEach items="${pageInfo.list}" var="ord">
	 			<tr>
	 				<td>${ord.oid}</td>
	 				<td>${ord.address}</td>
	 				<td>${ord.sumtotal}</td>
	 				<td>${cart.createTime}</td>
	 			</tr>
	 		</c:forEach>
	 	</table>
	 </div>
</div>  
<script>
		

</script>
  