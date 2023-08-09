class Empleado:
    def __init__(self, nEmpleado, nombre, categoria, pais):
        self.nEmpleado = nEmpleado
        self.nombre = nombre
        self.categoria = categoria
        self.pais = pais

    def __str__(self):
        cadena = "Id: " + str(self.nEmpleado) + ", Nombre: " + self.nombre + ", Categoria: " \
                + self.categoria + ", Pais: " + self.pais
        return cadena

def imprimirempleados(empleados):
    for empleado in empleados:
        print(empleado)

def empleadosCategoria(empleados, categorias):
    empCat = {}
    for categoria in categorias:
        contador = 0
        for empleado in empleados:
            if categoria == empleado.categoria:
                contador += 1
        empCat[categoria] = contador
    return empCat

def empleadosPais(empleados,paises):
    empPais = {}
    for pais in paises:
        contador = 0
        for empleado in empleados:
            if pais == empleado.pais:
                contador += 1
        empPais[pais] = contador
    return empPais

def paisMaximoEmpleados(empPais):
    paisMaxEmpleados = ""
    maxEmpleados = 0
    for pais in empPais.keys():
        if empPais[pais] > maxEmpleados:
            maxEmpleados = empPais[pais]
            paisMaxEmpleados = pais
    return paisMaxEmpleados + " con " + str(maxEmpleados)

categorias = ["A", "B", "C", "D", "E", "F"]
paises = ["Francia", "España", "Portugal", "Alemania", "Suiza", "Noruega", "China"]

francesco = Empleado(1, "Francesco Franciscano", "A", "Francia")
antonio = Empleado(2, "Antonio Garcia", "B", "España")
pepino = Empleado(3, "Pepino Palitroque", "B", "Portugal")
alemanio = Empleado(4, "Alemanio Altrueque", "D", "Alemania")
suricato = Empleado(5, "Suricato Succinio", "E", "Suiza")
notorio = Empleado(6, "Notorio del Norte", "F", "Noruega")
cheng = Empleado(7, "Cheng Khan", "F", "China")
yin = Empleado(8, "Yin Kazama", "B", "China")

empleados = [francesco, antonio, pepino, alemanio, suricato, notorio, cheng, yin]
print("###### Listado de empleados ######")
imprimirempleados(empleados)

#Obtener numero de empleados por categoria dentro de un diccionario
empCat = empleadosCategoria(empleados,categorias)

#Obtener el numero de empleados por Pais dentro de un diccionario
empPais = empleadosPais(empleados, paises)

#Obtener el pais con mayor numero de empleados dentro de una cadena
paisMaxEmpleados = paisMaximoEmpleados(empPais)
#Mostrar todo
print("\n###### Empleados por categoria ######")
for clave in empCat.keys():
    print(clave, "-->", empCat[clave])

print("\n###### Empleados por Pais ######")
for clave in empPais.keys():
    print(clave, "-->", empPais[clave])

print("\n##################\nPais con mas empleados:", paisMaxEmpleados)