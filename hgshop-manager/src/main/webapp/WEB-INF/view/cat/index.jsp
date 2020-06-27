<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="./resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet">
<script src="./resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>
    
<div class="container">
	<div class="row">
		<div class="col-md=5" id="tree"></div>
		<div class="col-md=5" >
		</div>
	</div>
	
</div>

<script>
	
	$.post('./cat/data',{},function(data){
		$('#tree').treeview({
			  data: data,         // data is not optional
			  levels: 2,
			});
	})
	
	
</script>