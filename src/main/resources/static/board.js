/**
 * Created by brallan on 30/06/16.
 */

var isWinner = 'no';

function httpGetSquare(position)
{
    var request = new XMLHttpRequest();
    var response;
    request.onreadystatechange = function() {

        if (request.readyState === 4) {
            if (request.status === 200) {

                document.body.className = 'ok';
                response = request.responseText;
            } else {
                document.body.className = 'error';
            }
        }
    };

    request.open("GET", "http://localhost:8080/play?pos=" + position , false);
    request.send(null);

    return response;
}

function httpGetWinner()
{
    var request = new XMLHttpRequest();
    var response;
    request.onreadystatechange = function() {

        if (request.readyState === 4) {
            if (request.status === 200) {

                document.body.className = 'ok';
                response = request.responseText;
            } else {
                document.body.className = 'error';
            }
        }
    };

    request.open("GET", "http://localhost:8080/winner", false);
    request.send(null);

    return response;
}

function httpRestart()
{
    var request = new XMLHttpRequest();
    var response;
    request.onreadystatechange = function() {

        if (request.readyState === 4) {
            if (request.status === 200) {

                document.body.className = 'ok';
                response = request.responseText;
            } else {
                document.body.className = 'error';
            }
        }
    };

    request.open("GET", "http://localhost:8080/restart", false);
    request.send(null);
}

function play(element, position) {
    var player = httpGetSquare(position);

    if(player === '1') { // it's empty
        element.innerHTML = 'O';
    }
    else if(player === '2') {
        element.innerHTML = 'X';
    }
    else {
        element.innerHTML = '?';
    }

    isWinner = httpGetWinner();

    if(isWinner === "yes") {
        alert("¡Hay ganador!");
    }
}

function drawBoard(element, position) {
    if(isWinner == 'no') {
        play(element, position);
    }

    if (isWinner == 'yes') {
        httpRestart();
        isWinner = 'no';

        var table = document.getElementById("tblBoard");
        var cells = table.getElementsByTagName("td");

        for(var i = 0; i < cells.length; i++) {
            var cell = cells[i];

            cell.innerHTML = '';
        }
    }
}