matriz = []
for i in range(1,6):
    valor = input("Introduzca la fila "+str(i)).split(" ")
    matriz.append(valor)

filas = []
columnas = []
#for i in range(0,len(matriz)):
    #columna = 0
    #for j in range(0,len(matriz[i])):

for i in range(5):
    horizontal_total = 0
    vertical_total = 0
    for j in range(5):
        horizontal_total += int(matriz[i][j])
        vertical_total += int(matriz[j][i])
    filas.append(horizontal_total)
    columnas.append(vertical_total)
    
print("Horizontal Row Sums:",filas)
print("Vertical Row Sums:", columnas)
    



         