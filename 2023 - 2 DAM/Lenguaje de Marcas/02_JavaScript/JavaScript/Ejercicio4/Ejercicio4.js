flores = ['rosa.jpg', 'lirio.jpg', 'loto.jpg','homer.jpg'];

function calcularDias(){
    var nombre = document.getElementById('nombre').value;
    var apellido1 = document.getElementById('apellido1').value;
    var apellido2 = document.getElementById('apellido2').value;
    var edad = parseInt(document.getElementById('edad').value);
    diasVividos = edad*365;
    document.formulario.resultado.value = nombre + " " + apellido1 + " " + apellido2 + " ha vivido " + diasVividos + " dias";
    document.formulario.nombre.value = "";
    document.formulario.apellido1.value = "";
    document.formulario.apellido2.value = "";
    document.formulario.edad.value = "";
}

function cambiarImagenes(caso){
    switch (caso){
        case 0:
            document.getElementById("img1").src=flores[0];
            break;
        case 1:
            document.getElementById("img1").src=flores[1];
            break;
        case 2:
            document.getElementById("img1").src=flores[2];
            break;
        case 3:
            document.getElementById("img1").src=flores[3];
            break;
    }
    
}