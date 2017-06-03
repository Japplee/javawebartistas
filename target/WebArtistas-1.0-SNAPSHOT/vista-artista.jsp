<%-- 
    Document   : vista-artista
    Created on : 03-jun-2017, 18:47:00
    Author     : heberarratia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
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
        .in select{
            height: 35px;
        }
        .in select option{
            padding-top: 20px;
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
            border-radius: 5px;
            font-size: .9em;
            float: right;
        }
        table {
            margin-top: 60px;
            width: 100%;
            border-collapse: collapse;
            border: 1px solid #38678f;
            background: white;
        }
        thead th {
            background: steelblue;
            height: 54px;
            color: white;
            border: 1px solid #38678f;
        }
        thead tr {
            border-bottom: 1px solid #cccccc;
        }
        thead td {
            border-right: 1px solid #cccccc;
            padding: 10px;
        }
        tbody th{
            font-weight: 300;
            border: 1px solid #38678f;
            height: 30px;
        }


    </style>
    <body>
        <div id="content">
            <h1>Artistas</h1>
            <form action="Artistas" method="POST">
                <div class="in">
                    <label>Nombre</label>
                    <input type="text" name="nombre" value="${inNombre}"><br>
                </div>
                <div class="in">
                    <label>Estilo</label>
                    <select name="estilo">
                        <option value="ROCK">Rock</option>
                        <option value="POP">Pop</option>
                        <option value="FOLK">Folk</option>
                    </select>
                </div>
                <input type="hidden" name="postAction" value="${inAction}">
                <input type="hidden" name="indexEdit" value="${indexEdit}">
                <input id="btn" type="submit" value="${inAction}">
            </form>
   
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Estilo</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${artistas}" var="artista" varStatus="loop">
                        <tr>      
                            <th>${artista.nombre}</th>
                            <th>${artista.estilo}</th>
                            <th>
                                <a href="Artistas?action=edit&id=${loop.index}">Editar</a>
                                <a href="Artistas?action=delete&id=${loop.index}">Borrar</a>
                                <a href="#">Canciones</a>
                            </th>  
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
