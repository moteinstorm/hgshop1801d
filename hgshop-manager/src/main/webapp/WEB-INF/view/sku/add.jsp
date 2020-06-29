<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
    
<div class="container-fluid">
	<form action="" id="spuForm">	
		<div class="form-group row">
		    <label for="goodsName" class="col-sm-2 col-form-label">spu名称</label>
		    <div class="col-sm-4">
		    	<input type="hidden" name="spuId" value="${spu.id}">	
		      <input type="text" class="form-control" id="goodsName" disabled="disabled" name="goodsName" value="${spu.goodsName}" >
		    </div>
		 </div>
		 <div class="form-group row">
		    <label for="skutitle" class="col-sm-2 col-form-label">sku名称</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control"  name="title" >
		    </div>
		 </div>
		 <div class="form-group row">
		    <label for="skutitle" class="col-sm-2 col-form-label">规格</label>
		    <div class="col-sm-4">
		      <table class="table">
		      	<tr>
		      		<th>规格名称</th>
		      		<th>属性值</th>
		      		<th><input type="button" value="添加"></th>
		      	</tr>
		      	<tr>
		      		<td><select>
		      			<c:forEach items="${specList}" var="spec">
		      		 		<option value="${spec.id}">${spec.specName}</option>
		      		 		</c:forEach>
		      		 	</select>
		      		 </td>
		      		<td>
		      			<select></select>
		      		</td>
		      		<td>
		      			
		      		</td>
		      	</tr>
		      </table>
		    </div>
		 </div>
		 
		 
	</form>
		 
</div>    