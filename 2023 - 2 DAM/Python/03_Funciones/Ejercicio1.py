from funciones.Factoriales import factorial
numero = input("Introduce un numero: ")
if numero.isnumeric():
     factorial(int(numero))
else:
     print(numero,"no es numerico")