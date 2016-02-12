<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>购物车</h3>
	<%
		
	//拿到购物车
		HashMap<String,Integer> cart =(HashMap<String,Integer>) request.getSession().getAttribute("cart");
	
	if(cart == null){
	
		out.print("您还没有购买任何商品... <a href='/Day11_Session/products.jsp'>去购买</a>");
		
	}else{
		
		// 遍历 购物车 ,取出 商品信息
		
		Set<String> keys = cart.keySet();
		
		for(String key: keys){
			out.print("商品名称 : " + key + ", 数量: " +cart.get(key)+"<br/>");
		}
	}
	
	%>
	<br/>
	<br/>
	<a href="/Day11_Session/clearCartServlet">清空购物车</a>

</body>
</html>