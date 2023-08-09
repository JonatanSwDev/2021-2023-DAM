flores = ['rosa.jpg', 'lirio.jpg', 'loto.jpg'];
i=0;

window.onload(setTimeout());
    function cambiarImagenes(){
        document.getElementById("img1").src=flores[i];
        i++;
        if (i == 3){
            i = 0;
        }
    }

    function setTimeout(){
        interval = setInterval(cambiarImagenes, 500);
        cambiarImagenes();
    }
    
