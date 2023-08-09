valor = "Not Vacia"
lista = []
while(valor):
    valor = input("\tIntroduce nombres. ENTER para terminar")
    if (valor):
        lista.append(valor)

for i in range(1, len(lista)):
    for j in range(0, len(lista)-i):
        if lista[j].lower() > lista[j+i].lower():
            elemento = lista[j]
            lista[j] = lista[j+1]
            lista[j+1] = elemento
            
print("\nLos nombres son:")
for nombre in lista:
    print(nombre)
    
            
