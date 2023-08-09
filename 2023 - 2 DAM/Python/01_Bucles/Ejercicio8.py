import sys

print("Introduce los dias del mes: ")
try:
    dias = int(input())
    print("Dia 1 del mes (0 lunes, 6 domingo): ")
    lunes = int(input())
except:
    print("No has introducido un valor numerico")
    sys.exit()

resultado = "  L  M  X  J  V  S  D\n"
dia = 1
for i in range(6):
    for j in range(7):
        if i == 0 and j < lunes:
            resultado += "   "
        elif dia <= dias and dia < 10:
            resultado += "  " + str(dia)
            dia += 1
        elif dia <= dias and dia >= 10:
            resultado += " " + str(dia)
            dia += 1
resultado += "\n"
print(resultado)
