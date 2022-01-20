
<%@page import="com.grocery.model.Feature"%>
<%@page import="com.grocery.daoimpl.OrderDaoImpl"%>
<%@page import="com.grocery.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.grocery.daoimpl.ProductDaoImpl"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<html>
<% OrderDaoImpl obj =new OrderDaoImpl();
          List<Feature> sale =obj.todaySale(); 
       
          %>
<head>




<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
   
      function drawChart() {
    	  var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	  <%for(Feature feature:sale){ %>
        	  [ '<%=feature.getProductName() %>', <%=feature.getQuantity() %> ],
        	  
        	  <%} %>
          ]);


  
          
     
 
        
        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div id="piechart" style="width: 900px; height: 500px;"></div>
</body>
</html>