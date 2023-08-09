function calcular()
{
    b = document.getElementById("b").value;
    a = document.getElementById("a").value;
    c = document.getElementById("c").value;

var disc = discrim(a,b,c);

if (disc < 0)
   document.formulario.resultado.value="Sin solución real";
else
   {
   x1 = (-b + Math.sqrt(disc))/(2*a);
   x2 = (-b - Math.sqrt(disc))/(2*a);

   document.formulario.resultado1.value = "x1 = " + x1; 
   document.formulario.resultado2.value = "x2 = " + x2; 
   } 
}
function discrim(a, b, c)
{
return (b*b - 4*a*c);
} 