<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.piechart.bean.UserBean" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% if(session.getAttribute("user_act")!=null){ %>
    <% UserBean ub=(UserBean)session.getAttribute("user_act"); %>
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
    <script type="text/javascript">
      function drawVisualization() {
        // Create and populate the data table.
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work', <%= ub.getUserWork() %>],
          ['Eat', <%= ub.getUserEat() %>],
          ['Commute', <%= ub.getUserCommute() %>],
          ['Watch TV', <%= ub.getUserWatchTv() %>],
          ['Sleep', <%= ub.getUserSleep() %>]
        ]);
      
        // Create and draw the visualization.
        new google.visualization.PieChart(document.getElementById('visualization')).
            draw(data, {title:"So, how was your day?"});
      }
      
      google.setOnLoadCallback(drawVisualization);
    </script>
     <%} %>
</head>
<body style="font-family: Arial;border: 0 none;">
  <div id="visualization" class="visual" style="width: 600px; height: 400px;">
    </div>
</body>
</html>