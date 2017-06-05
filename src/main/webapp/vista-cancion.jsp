<%-- 
    Document   : vista-cancion
    Created on : 03-jun-2017, 19:03:37
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
        #btns{
            float: right;
        }
        .btn{
            background: steelblue;
            padding: 10px 20px;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: .9em;
        }
        table {
            margin-top: 60px;
            width: 100%;
            border-collapse: collapse;
            border: 1px solid #38678f;
            background: white;
            margin-bottom: 30px;
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
        input[type="text"]:disabled {
            background: #dddddd;
        }


    </style>
    <body>
        <div id="content">
            <h1>Canciones</h1>
            <form action="Canciones" method="POST">
                <div class="in">
                    <label>Artista</label>
                    <input type="text" name="artista" value="${inNombre}" disabled><br>
                </div>
                <div class="in">
                    <label>Cancion</label>
                    <input type="text" name="cancion" value="${inCancion}"><br>
                </div>
                <div class="in">
                    <label>Duracion</label>
                    <input type="text" name="duracion" value="${inDuracion}"><br>
                </div>
                <div id="btns">
                    <input type="hidden" name="indexEdit" value="${indexEdit}">
                    <input type="hidden" name="postAction" value="${inAction}">
                    <!--<input class="btn" type="submit" value="Cancelar">-->
                    <input class="btn" type="submit" value=${inAction}>
                </div>
                
            </form>
   
            <table>
                <thead>
                    <tr>
                        <th>Cancion</th>
                        <th>Duracion</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${canciones}" var="cancion" varStatus="loop">
                        <tr>
                            <th>${cancion.nombre}</th>
                            <th>${cancion.duracion}</th>
                            <th>
                                <a href="Canciones?action=edit&idcancion=${loop.index}">Editar</a>
                                <a href="Canciones?action=delete&idcancion=${loop.index}">Borrar</a>
                            </th>
                        <tr>
                    </c:forEach>
                </tbody>
            </table>
             <input class="btn" type="submit" value="Volver">
        </div>
    </body>
</html>
