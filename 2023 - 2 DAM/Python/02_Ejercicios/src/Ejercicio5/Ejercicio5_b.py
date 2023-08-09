import sys
billetes = {
    500:0,
    200:0,
    100:0,
    50:0,
    20:0,
    10:0,
    5:0,
    2:0,
    1:0
    }

valor = list(billetes.keys())

cantidad = input("Introduce una cantidad entera en euros: ")

if cantidad.isnumeric():
    cantidad = int(cantidad)
else:
    print("No has introduciendo una cantidad valida\nFinalizando programa...")
    sys.exit(0)

while(cantidad > 0):
    if cantidad >= valor[0]:
        billetes[500] += 1
        cantidad -= valor[0]
    elif cantidad >= valor[1]:
        billetes[200] += 1
        cantidad -= valor[1]
    elif cantidad >= valor[2]:
        billetes[100] += 1
        cantidad -= valor[2]
    elif cantidad >= valor[3]:
        billetes[50] += 1
        cantidad -= valor[3]
    elif cantidad >= valor[4]:
        billetes[20] += 1
        cantidad -= valor[4]
    elif cantidad >= valor[5]:
        billetes[10] += 1
        cantidad -= valor[5]
    elif cantidad >= valor[6]:
        billetes[5] += 1
        cantidad -= valor[6]
    elif cantidad >= valor[7]:
        billetes[2] += 1
        cantidad -= valor[7]
    elif cantidad >= valor[8]:
        billetes[1] += 1
        cantidad -= valor[8]
  
for clave in billetes.keys():
    if billetes[clave] > 0:
        if clave > 2:
            print(str(billetes[clave]),"billetes de",str(clave))
        else:
            print(str(billetes[clave]),"monedas de",str(clave))
    
    
        
        