frase = input("Introduce una frase: ")

vocales = ["a","e","i","o","u"]

for vocal in vocales:
    #Aqui si quiero que muestre todas las vocales, ya que es facilmente legible al humano
    veces = (frase.count(vocal.upper()) + frase.count(vocal.lower()))
    if vocal != "u":
        print(str(vocal), '(', str(veces), end='), ')
    else:
        print(str(vocal), '(', str(veces), end=")")