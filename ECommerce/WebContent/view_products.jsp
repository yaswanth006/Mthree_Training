<%@page import="com.mthree.models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products Page</title>
</head>
<body>





<%!

List<Product> products;



%>


<table border="1">
<tr>
	<th> Product ID </th>
	<th> Product Title </th>
	<th> Product Price </th>
	<th>No of Items</th>
	<th> Action </th>
	<th>Cart Value</th>
</tr>
<%

	products = (List<Product>) session.getAttribute("productList");
int a=1,b=1000;
	for(Product p : products)
	{ 
		
%>
  
		<tr> 
		  
	      <td> <%=p.getProductId() %> </td>
	      <td> <%=p.getProductTitle() %> </td>
	      <td> <%=p.getProductPrice() %> </td>
	      <td><input type="text" id=<%=b %> name="noOfProducts"></td>
	      <td> <input type="button"  onClick="myFunction(<%=p.getProductPrice() %>,<%=a %>,<%=b %>)" value="Add to Cart"/></td>
	      <td><input type="text" id="<%=a %>" name="cartValue"></td>
	      
	      
	     </tr>

<% 
a++;
b++;
}
%>
</table>
<h3>Total Amount</h3>
<input type="text" id="amount" value="0" name="amount">
<form method="post" action="CheckOut.jsp">
<input type="submit"  value="Check Out" >
</form>
<script >
function myFunction(price,id,id2)
{
	//alert(id2+" "+price+" "+id);
	var noOfProducts=document.getElementById(id2).value;
	var amount=document.getElementById(id).value=noOfProducts*price;
	document.getElementById("amount").value = +document.getElementById("amount").value + +amount;
	
	
}
</script>
</body>
</html>