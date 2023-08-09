function scriptResuelto(){
    var farenheit, celsius;
    var s="";
    for(i=0;i<=10;i++) {
        celsius=10*i;
        farenheit=32+((celsius*9)/5);
        s=s+"C: "+celsius+"\n";
        s=s+"F: "+farenheit+"\n";
            if (celsius==0) { s=s+"Punto congelación del Agua\n"; }
            if (celsius==100) { s=s+"Punto de ebullición del Agua\n"; }
    } 
    window.alert(s);
}

