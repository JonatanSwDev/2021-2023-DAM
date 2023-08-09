class Empleado:
    def __init__(self, nom="", ed=-1, sal=0.0):
        # Como se especifica tipo hago comprobaciones de tipo
        if isinstance(nom, str) and len(nom.split()) > 1:
            self.nombre = nom
        else:
            self.nombre = nom
        if isinstance(ed, int) and 18 <= ed <= 45:
            self.edad = ed
        else:
            self.edad = -1
        if isinstance(sal, float):
            self.salario = sal
        else:
            self.salario = 0.0

    def clasEdad(self):
        # YO LO HE ENTENDIDO ASI
        if self.edad <= 21:
            return "Principiante"
        elif 22 <= self.edad < 35:
            return "Intermedio"
        else:
            return "Senior"

    def aumentarSalario(self, porcentaje):
        self.salario += self.salario * porcentaje / 100

    def __str__(self):
        return f"Nombre: {self.nombre}\nEdad: {self.edad} - {self.clasEdad()}\nSalario: {self.salario}"


class Programador(Empleado):
    def __init__(self, nom="", ed=0, sal=0.0, lc=0, leng=""):
        super().__init__(nom, ed, sal)
        # Como se especifica tipo hago comprobaciones de tipo
        if isinstance(lc, int):
            self.lineasDeCodigoPorHora = lc
        else:
            self.lineasDeCodigoPorHora = 0
        if isinstance(leng, str):
            self.lenguajeDominante = leng
        else:
            self.lenguajeDominante = ""

    def __str__(self):
        return super().__str__() + f"\nLineas de codigo por hora: {self.lineasDeCodigoPorHora}\n" \
                                   f"Lenguaje dominante: {self.lenguajeDominante}"


###########################################

def comenzar():
    juan = Empleado("Juan Antonio", 18, 1100.0)
    antonio = Empleado("Antonio Perez", 23, 2300.0)
    jony = Programador("Jonatan Gomez", 35, 8000.0, 100, "python")
    return [juan, antonio, jony]


def addEmpleado():
    nom = input("Introduce el nombre del empleado: ").strip()
    ed = int(input("Introduce la eddad de" + nom + ": ").strip())
    sal = float(input("Introduce el sueldo de " + nom + ": ").strip())
    opcion = input(nom + "¿Es programador? Y/N").strip().upper()
    if opcion == "Y":
        lc = int(input("Introduce la cantidad de lineas de codigo para " + nom + ": ").strip())
        leng = input("Introduce el lenguaje de programacion principal de " + nom + ": ").strip()
        nuevo = Programador(nom, ed, sal, lc, leng)
    else:
        nuevo = Empleado(nom, ed, sal)
    return nuevo


def obtenerEmpleado(empleados, nom):
    for mpl in empleados:
        if mpl.nombre.lower() == nom.lower():
            return mpl
    return Empleado()


############################################

if __name__ == '__main__':
    empleados = comenzar()
    menu = "1. Dar de alta un empleado\n" \
           "2. Aumentar de suelto\n" \
           "3. Mostrar empleado\n" \
           "0. Salir\n"

    opcion = "-1"
    while opcion != "0":
        print(menu)
        opcion = input("Seleccione una opcion: ").strip()

        if opcion == "1":
            empleados.append(addEmpleado())

        elif opcion == "2":
            nom = input("Introduce el nombre del empleado a aumentar el sueldo: ")
            actual = obtenerEmpleado(empleados, nom)
            if actual.edad != -1:
                porcent = int(input("Introduce el porcentaje del sueldo a aumentar: "))
                actual.aumentarSalario(porcent)
            else:
                print("Empleado no encontrado")

        elif opcion == "3":
            nom = input("Introduce el nombre del empleado a mostrar: ")
            actual = obtenerEmpleado(empleados, nom)
            print(actual)

        elif opcion == "0":
            print("FIN DE PROGRAMA")