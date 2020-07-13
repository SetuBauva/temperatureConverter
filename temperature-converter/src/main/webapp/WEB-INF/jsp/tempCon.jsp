<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<script type="text/javascript">

function sendAjax() {
    var ftemp= $("#fTemp").val();
    //var checkOutDate= $("#checkOutDate").val();
alert("Success : "+in function);
    $.ajax({
        type: "GET",
        url: "${home}/TemperatureConverterController/convert',
        data: "temp=Celsius&ftemp="+ftemp,
        dataType: "json",
        success: function(response) {

            alert("Success : "+response);
            if(response != null && response !="" && response !="null"){
                //do you stuff here
            }

        },
        error: function(e) {
            alert('Error: ' + e.message);
        },
    });
}
</script>
<html>
<head>
<title>Temperature Converter</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<meta charset="UTF-8">
<body>

	<form name="Temperature Converter" action="convert">
		<h2 style="font-family: arial">
			<a href="/logout" style="font-family: arial; float: right"><b>Logout</b></a>
		</h2>
		<h2 style="font-family: arial; color: blue">
			<security:authorize access="isAuthenticated()">
				<b> Welcome <security:authentication
						property="principal.username" /></b>
			</security:authorize>
		</h2>

		<h2 style="font-family: arial; color: red">Temperature Calculator</h2>
		<table border="1">
			<tbody>
				<tr>
					<!-- <td>Enter a temperature in number form:</td> -->

					<td>Celsius (°C):</td>
					<td><input type="text" name="celsiusTemp" id="celsiusTemp"
						value="${Celcius}"  onkeyup="this.value=this.value.replace(/[^\d]/,'')"/></td>
					<td><input type="radio" name="temperature" value="Celsius">Convert
						to Fahrenheit</td>
				</tr>
				<tr>
					<td>Fahrenheit (°F):</td>

					<td><input type="text" name="fahrenheitTemp" id="fahrenheitTemp"
						value="${Farenheit}"  onkeyup="this.value=this.value.replace(/[^\d]/,'')"/></td>
					<td><input type="radio" name="temperature" value="Fahrenheit">Convert
						to Celsius</td>
				</tr>
				<tr>
					<td><input type="submit" value="Convert!"></td>
				</tr>


			</tbody>
		</table>
	</form>
</body>
</html>