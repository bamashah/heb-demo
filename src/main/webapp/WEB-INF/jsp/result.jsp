<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.boot.model.Item"%>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
	<h1>Search Results</h1>    
    
    <Table border=1>
	 <tr>
	   <th>Id</th>
	   <th>description</th>
	   <th>Last Sold</th>
	   <th>Shelf Life</th>
	   <th>Department</th>
	   <th>Price</th>
	   <th>Unit</th>
	   <th>xFor</th>
	   <th>Cost</th>
	 </tr>    
     <c:forEach items="${items}" var="item">
     <tr>
        <td><c:out value="${item.id}"/></td>
        <td><c:out value="${item.description}"/></td>  
        <td><c:out value="${item.lastSold}"/></td>  
        <td><c:out value="${item.shelfLife}"/> days</td>  
        <td><c:out value="${item.department}"/></td>  
        <td>$<c:out value="${item.price}"/></td>  
        <td><c:out value="${item.unit}"/></td>  
        <td><c:out value="${item.xFor}"/></td>  
        <td>$<c:out value="${item.cost}"/></td>  
     </tr>
	 </c:forEach>
	</Table>
	<br>
	<a href="/search">Search again</a>
</body>
</html>