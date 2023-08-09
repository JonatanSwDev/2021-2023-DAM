flores = ['coche.png', 'rosa.jpg', 'lirio.jpg', 'loto.jpg'];
var i=0;
var interval;
var parado = false;

//window.onload(setTimeout());
    function cambiarImagenes(){
        if (i < 3){
            i++; 
            document.getElementById("img1").src=flores[i];
            document.getElementById("parrafo").innerHTML=i;
        } else {
            i=0;
            document.getElementById("img1").src=flores[i];
            document.getElementById("parrafo").innerHTML=i; 
        }
    }

    function setTimeout(){
        interval = setInterval(cambiarImagenes, 700);
    }

    function pararImagen(){
        if(!parado){
            clearInterval(interval);
            parado = true;
        } else {
            setTimeout();
            parado = false;
        }
    }