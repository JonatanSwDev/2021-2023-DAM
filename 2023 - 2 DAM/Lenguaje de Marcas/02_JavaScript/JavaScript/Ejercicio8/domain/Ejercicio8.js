fallos = ["./domain/homer0.jpeg","./domain/homer1.jpeg","./domain/homer2.jpeg","./domain/homer3.jpeg","./domain/homer4.jpeg","./domain/homer5.jpeg","./domain/homer6.jpeg"];
palabras=["PELAMELO","PENELOPE","PELOTAZO","PANDILLA"]
i = 0;

random = Math.floor(Math.random() * 4);
palabra = palabras[random];
charVictoria = ["P","*","*","*","*","*","*","*"];

function comprobar(c){
    valor = new String(document.getElementById(c).value.toUpperCase());
    caracter = palabra.charAt(c);
    if (caracter != valor){
        document.getElementById("img"+i).src=fallos[i];
        document.getElementById(c).value="";
        document.getElementById("pelos").src="./domain/derrota.jpg";
        i++;
    } else {
        document.getElementById("pelos").src="./domain/victoria.jpeg";
        charVictoria[c] = valor;
        palabraVictoria = "";
        for(j = 0; j < charVictoria.length; j++){
            palabraVictoria += charVictoria[j];
        }
        
        if(palabraVictoria == palabra){
            window.alert("¡HAS GANADO!\nLa palabra era " + palabra);
            document.getElementById('resetear').style.display = 'block';
        }
    }

    if(i == 7){
        window.alert("¡HAS PERDIDO!\nLa palabra era " + palabra);
        document.getElementById('resetear').style.display = 'block';
    }
}