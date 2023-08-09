function calcular(){
    var decimal = parseInt(document.getElementById("number").value);
    var binario = decimal.toString(2);
    var octal = decimal.toString(8);
    var exadecimal = decimal.toString(16);

    document.getElementById("resultado").innerHTML = "<p>Binario:" + binario + " </p>"+
                    "<p>Octal: " + octal + "</p>"+
                    "<p>Exadecimal: " + exadecimal + "</p>";
}