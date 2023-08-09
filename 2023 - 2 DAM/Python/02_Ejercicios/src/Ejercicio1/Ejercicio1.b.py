frase = input("Introduce una frase: ")

abecedario = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"]

for letra in abecedario:
    #Considero que no hace falta mostrar todo el abecedario, asi queda mas legible al humano
    if letra.upper() in frase or letra.lower() in frase:
        veces = (frase.count(letra.upper()) + frase.count(letra.lower()))
        print("La letra", str(letra)," esta ", str(veces), " veces")