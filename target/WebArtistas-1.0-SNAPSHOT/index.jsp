<%-- 
    Document   : prueba
    Created on : 31-05-2017, 17:47:57
    Author     : Jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                font-family: Helvetica;
            }
            .in{
                margin-bottom: 7px;
            }
            .in input, .in select{
                width: 100%;
                padding-top: 5px;
                padding-bottom: 5px;
                display: block;
                height: 20px;
                font-size: 14px;
                line-height: 1.42857143;
                color: #555;
                background-color: #fff;
                background-image: none;
                border: 1px solid #ccc;
                border-radius: 4px;
                margin-top: 10px;
            }
            #content{
                width: 50%;
                margin: 0 auto;
            }
            #btn{
                background: steelblue;
                padding: 10px 20px;
                color: white;
                border: none;
            }
            table{
                margin-top: 20px;
            }
            table, th, td{
                border: 1px black solid;
            }
        </style>
    </head>
    <body>
        <div id="content">
            <h1>Artistax</h1>
            <form action="Manager" method="POST">
                <div class="in">
                    <label>Nombre</label>
                    <input type="text" name="nombre"><br>
                </div>
                <div class="in">
                    <label>Estilo</label>
                    <select>
                        <option value="rock">Rock</option>
                        <option value="pop">Pop</option>
                        <option value="metal">Metal</option>
                        <option value="folk">Folk</option>
                    </select>
                </div>
                <input type="hidden" name="action" value="agregar">
                <input type="hidden" name="nopasar" value="true">
                <input id="btn" type="submit" value="Enviar">
            </form>
   
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Estilo</th>
                        <th>Editar</th>
                        <th>Borrar</th>
                        <th>Agregar</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach items="${artistas}" var="artista" varStatus="loop">
                    <tr>
                        <th>${artistas.nombre}</th>
                        <th>${artistas.estilo}</th>
                        <th><a href="Manager?id=${loop.index}&editar=true"></th>
                        <th><a href="Manager?id=${loop.index}&action=borrar"></th>
                        <th></th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>