var contador = 1;

function insertar(){
    var tabla = document.getElementById("tabla");
    var fila = tabla.insertRow(contador);
    var celda1 = fila.insertCell(0);
    var celda2 = fila.insertCell(1);
    celda1.innerHTML = "Celda[" + contador + "][0]";
    celda2.innerHTML = "Celda[" + contador + "][1]";
    contador++;
}

function eliminar(){
    if(contador > 0){
        document.getElementById("tabla").deleteRow(contador-1);
        contador--;
    }
}