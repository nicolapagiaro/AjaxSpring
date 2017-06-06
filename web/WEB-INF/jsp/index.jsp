<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esempio Ajax</title>
        <!-- icon -->
        <link rel="icon" href="<c:url value="/resources/images/logo.ico" />"/>
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
                            <div class="input-field col s12">
                                <input id="ricerca" type="text" class="autocomplete">
                                <label for="ricerca">Cerca persone</label>
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
                                <tbody id="container">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="card" id="modifica_card">
                <div class="card-content">
                    <div class="row">
                        <div class="col l11">
                            <span class="card-title">Modifica</span>
                        </div>
                        <div class="col l1 right-align">
                            <a href="#!" id="close_card"><i class="material-icons">close</i></a>
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