var numero = 23;
var i = 1;
var resultado = 0;
function mostrarMultiplos(){
    while(resultado < 1000){
        resultado = numero * i;
        if (resultado <= 1000){
            document.write(i + " multiplo de " + numero + " es: " + resultado + "<br/>");
        }
        i++;
    }
}