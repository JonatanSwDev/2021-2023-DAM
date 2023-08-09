document.getElementById("titulo").addEventListener('mousedown', cambiarcolor);


function cambiarcolor(){
    var color = Math.floor(Math.random()*16777215);
    var colorValue = color.toString(16);
    document.getElementById("titulo").style.backgroundColor="#" + colorValue;
    document.getElementById("titulo").innerHTML="Cambiar color: #" + colorValue;
}