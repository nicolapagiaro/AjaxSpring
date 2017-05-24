$(document).ready(function () {
    ajax("");
    
    // on key press sulla ricerca
    $('#ricerca').keyup(function (e) {
        var txt = $('#ricerca').val();
        // ajax 
        ajax(txt);
    });
});

// funzione per ajax
function ajax(txt) {
    console.log(txt);
    $.ajax({
            type: "POST",
            url: "/ajaxSpring1/search",
            data: "text=" + txt,
            success: function (msg) {
                var obj = JSON.parse(msg);
                var s = "";
                for (var i = 0; i < obj.length; i++) {
                    s += "<tr> " +
                            "<td>"+ obj[i].id + "</td>" +
                            "<td>"+ obj[i].nome + "</td>" +
                            "<td>"+ obj[i].dipartimento.nome + "</td>" +
                            "<td>";
                            
                            // lavori fatti
                            for (var j = 0; j < obj[i].jobs.length; j++) {
                                s += obj[i].jobs[j].nome;
                                if(obj[i].jobs.length > j+1)
                                    s += ", ";
                            }
                            
                            s += "</td>" +
                            "<td>" +
                            "<a href=''><i class='material-icons'>mode_edit</i></a>" +
                            "<a href=''><i class='material-icons'>delete</i></a>" +
                            "</td>" +
                            "</tr>";
                }
                if(obj.length === 0) {
                    s += "<tr>"+
                         "<td colspan='5' class='center-align'>Nessun risultato</td>" + 
                         "</tr>";
                }
                $('#container').html(s);
            },
            error: function (msg) {
                console.log("Error: " + msg);
            }
        });
}

