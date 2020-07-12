<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>


<html>
<head>
<title>Temperature Converter</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<meta charset="UTF-8">
<body>
<security:authorize access="isAuthenticated()">
        Welcome <security:authentication property="principal.username" />
</security:authorize>

<form name="Temperature Converter" action="convert">
<h2 style="font-family: arial; color: red">Temperature Calculator</h2>

<table border="1">
<tbody>
<tr>
<!--  <td>Enter a temperature in number form:</td>-->

<!-- <td>Degrees Celsius (°C)</td>
<td>Degrees Fahrenheit (°F)</td>
</tr>
<tr>
<td><input type="text" name="cTemp" id="cTemp" /></td> -->
<td><input type="text" name="fTemp" id="fTemp" /></td>
<td>
<input type="radio" name="temp" value="Celsius">Convert to Fahrenheit
<br>
<input type="radio" name="temp" value="Fahrenheit">Convert to Celsius
</td>
</tr>
<tr>
<td>
<input type="submit" value="Convert!">
<!-- <input
						type="submit" name="Convert to Fahrenheit" class="button"
        value="Convert to Fahrenheit" />

</td>
<td><input type="submit" name="Convert to Celsius"
class="button" value="Convert to Celsius" /> -->
</td>
</tr>

<a href="/logout">Logout</a>
</tbody>
</table>
</form>
</body>
</html>