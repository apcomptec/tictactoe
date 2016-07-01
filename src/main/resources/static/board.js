/**
 * Created by brallan on 30/06/16.
 */

function detectIndex() {
    var table = document.getElementById("tblBoard");
    var cells = table.getElementsByTagName("td"); //

    for(var i = 0; i < cells.length; i++){
        // Cell Object
        var cell = cells[i];
        // Track with onclick
        cell.onclick = function(){
            var cellIndex  = this.cellIndex;
            var rowIndex = this.parentNode.rowIndex * 3;
            var position = cellIndex + rowIndex;

            alert("position: " + position );
        }
    }
}
