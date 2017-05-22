$(document).ready(function () {
    $('#ricerca').keypress(function (e) {
        var txt = $('#ricerca').val();
        
        // ajax 
        $.ajax({
            type: "POST",
            url: "/ajaxSpring1/search",
            data: "text=" + txt,
            success: function (msg) {
                console.log(msg);
            },
            error: function (msg) {
                console.log("Error: " + msg);
            }
        });
    });
});

