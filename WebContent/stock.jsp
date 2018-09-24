<%@ page 
 contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<html>
<head>
	<style>
		#d1{
			width:450px;
			height:380px;
			background-color:black;
			margin-left:350px;
			margin-top:20px;
		}
		#d2{
			height:35px;
			background-color:red;
			color:yellow;
		}
		table{
			color:white;
			font-size:24px;
			font-style:italic;
		}
	</style>
	<script type="text/javascript" 
		src="js/jquery-1.4.3.js">
	</script>
	
	<script type="text/javascript">
		$(function(){
			//整个页面加载完成，执行以下代码
			setInterval(quoto,5000);
		});
		
		/*
			该函数要向服务器发送异步请求(quoto.do),
			并且将服务器返回的数据(股票信息)解析出来,
			然后更新表格。
		*/
		function quoto(){
			$.ajax({
				"url":"quoto.do",
				"type":"post",
				"dataType":"json",
				"success":function(obj){
					/*
						处理服务器返回的数据
						注1：$.ajax方法会将json字符串转换成
							对应的javascript对象。
						注2: obj是服务器返回的数据。
					*/
					$('#tb1').empty();
					for(i = 0; i < obj.length; i ++){
						var s = obj[i];
						//给表格增加新的行
						$('#tb1').append(
							'<tr><td>' + s.code 
							+ '</td><td>' + s.name
							+ '</td><td>' + s.price 
							+ '</td></tr>');
					}
				}
			});
		}
		
	</script>
</head>      
<body style="font-size:30px;">
		<div id="d1">
			<div id="d2">股票实时行情</div>
			<div id="d3">
				<table border="1" 
			>
					<thead>
						<tr>
							<td>代码</td>
							<td>名称</td>
							<td>价格</td>
						</tr>
					</thead>
					<tbody id="tb1">
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>


