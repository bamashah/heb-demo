<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.boot.model.Item"%>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item Search</title>
</head>
<body>
      <h1>Item Search</h1>
      <form:form method = "POST" action = "/result">
         <table>
            <tr>
               <td><form:label path = "id">ID</form:label></td>
               <td><form:input path = "id" /></td>
            </tr>
            <tr>
               <td><form:label path = "description">Description</form:label></td>
               <td><form:input path = "description" /></td>
            </tr>
            <tr>
               <td><form:label path = "lastSold">Last Sold (MM/dd/yyyy)</form:label></td>
               <td><form:input path = "lastSold" /></td>
            </tr>            
            <tr>
               <td><form:label path = "shelfLife">Shelf Life (days)</form:label></td>
               <td><form:input path = "shelfLife" /></td>
            </tr>
            <tr>
               <td><form:label path = "department">Department</form:label></td>
               <td><form:input path = "department" /></td>
            </tr>            
            <tr>
               <td><form:label path = "price">Price ($)</form:label></td>
               <td><form:input path = "price" /></td>
            </tr>    
            <tr>
               <td><form:label path = "cost">Cost ($)</form:label></td>
               <td><form:input path = "cost" /></td>
            </tr>                      
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>    

</body>
</html>