function calcularDias(){
    var nombre = document.getElementById('nombre').value;
    var edad = parseInt(document.getElementById('edad').value);
    diasVividos = edad*365;
    document.formulario.resultado.value = nombre + " ha vivido " + diasVividos + " dias";
    document.formulario.nombre.value = "";
    document.formulario.edad.value = "";
}