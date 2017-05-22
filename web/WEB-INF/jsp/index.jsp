<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esempio Ajax</title>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link href="<c:url value="/resources/css/materialize.min.css" />" rel="stylesheet" media="screen,projection">
        <!--Import main_css.css-->
        <link href="<c:url value="/resources/css/main_css.css" />" rel="stylesheet" media="screen,projection">
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/> 
    </head>
    <body>
        <nav class=" blue lighten-2">
            <div class="nav-wrapper container blue lighten-2">
                <a href="#!" class="brand-logo right">First application with my friend in Ajax</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="#!">Sass</a></li>
                    <li><a href="#!">Components</a></li>
                    <li><a href="#!">JavaScript</a></li>
                </ul>
            </div>
        </nav>

        <br>
        <div class="container">
            <div class="card">
                <div class="card-content">
                    <div class="row">
                        <div class="col l9">
                            <span class="card-title">Lista persone</span>
                        </div>
                        <div class="col l3 right-align">
                            <div class="input-field">
                                <input id="ricerca" type="text">
                                <label for="ricerca">Cerca</label>
                            </div>
                        </div>
                        <div class="col l12">
                            <table class="highlight">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nome</th>
                                        <th>Dipartimento</th>
                                        <th>Lavori</th>
                                        <th>Azioni</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listaP}" var="item">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.nome}</td>
                                            <td>${item.dipartimento.nome}</td>
                                            <td>
                                                <c:set var="count" value="0" scope="page" />
                                                <c:forEach items="${item.jobs}" var="j">
                                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                                    ${j.nome}<c:if test="${item.jobs.size() != count}">, </c:if>
                                                </c:forEach>
                                                <c:if test="${item.jobs.size() == 0}">-</c:if>
                                                </td>
                                                <td>
                                                    <a href="<c:url value=""/>"><i class="material-icons">mode_edit</i></a>
                                                    <a href="<c:url value=""/>"><i class="material-icons">delete</i></a>
                                                </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- page fast loading -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js" />"></script>
        <script src="<c:url value="/resources/js/main_script.js"/>"   type="text/javascript"></script>
    </body>
</html>