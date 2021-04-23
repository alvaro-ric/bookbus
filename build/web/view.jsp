<%-- 
    Document   : view
    Created on : Apr 12, 2021, 4:04:23 PM
    Author     : Philip
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="dao.GeneralDao"%>
<%@page import="model.Route"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        
    </head>
    <body>
        <%
            GeneralDao<Route> routeDao = new GeneralDao<>();
            List<Route> routes = routeDao.findAll(new Route());
//            String json = new Gson().toJson(routes);
            for(Route route: routes){
                out.println(route.getId());
            }
            
        %>
        <table>
            <tr>
                <td>new</td>
            </tr>
        </table>
    </body>
</html>
