<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.piechart.bean.UserBean" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>
      PieChart Demo
    </title>
    <!-- <script type="text/javascript" src="js/jquery.js"></script> -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <% if(session.getAttribute("user_act")!=null){ 
     UserBean ub=(UserBean)session.getAttribute("user_act"); %>
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
  <form id="frm" action="GetChart">
      <input type="text" name="userid" id="userid" />
      <input type="submit" value="Submit" id="btn" />
    </form>  
   <div id="visualization" style="width:600px; height: 400px;">
    <%-- <jsp:include page="piechart.jsp" /> --%>
   </div> 
  </body>
</html>