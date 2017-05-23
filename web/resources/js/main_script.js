$(document).ready(function () {
// on key press sulla ricerca
$('#ricerca').keypress(function (e) {
var txt = $('#ricerca').val();
        // ajax 
        $.ajax({
        type: "POST",
                url: "/ajaxSpring1/search",
                data: "text=" + txt,
                success: function (msg) {
                var obj = JSON.parse(msg);
                        var s = "";
                        for (var i = 0; i < obj.length; i++) {
                s += "<tr>
                        < td > ${item.id} < /td>
                        < td > ${item.nome} < /td>
                        < td > ${item.dipartimento.nome} < /td>
                        < td >
                        < c:set var = 'count' value = '${count + 1}' scope = 'page' / >
                        ${j.nome} < c:if test = '${item.jobs.size() != count}' > ,
                        < /td>
                        < td >
                        < a href = '<c:url value=''/>' > < i class = 'material-icons' > mode_edit < /i></a >
                        < a href = '<c:url value=''/>' > < i class = 'material-icons' > delete < /i></a >
                        < /td>
                        < /tr>"
                }
                },
                error: function (msg) {
                console.log("Error: " + msg);
                }
        });
});
        });

