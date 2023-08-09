class Producto:
    def __init__(self, tit, tip, prec, dia=0, alquila=False):
        self.titulo = tit
        self.tipo = tip
        self.precio = prec
        self.dias = dia
        self.alquilado = alquila

    def alquilar(self, cliente, dia):
        if not self.alquilado and 0 < dia <= 7:
            self.dias = dia
            self.alquilado = True
            cliente.alquilar(self)
            return True
        else:
            return False

    def __str__(self):
        alq = f"Si\nDias: {self.dias}" if self.alquilado else "No"
        return f"Titulo: {self.titulo}" \
               f"\nTipo: {self.tipo}" \
               f"\nPrecio: {self.precio}" \
               f"\nAlquilado: {alq}"


class Pelicula(Producto):
    def __init__(self, tit, tip, prec, gen, anio, direct, interpr):
        super().__init__(tit, tip, prec)
        self.genero = gen
        self.year = anio
        self.director = direct
        self.interpretes = interpr

    def __str__(self):
        return super().__str__() + f"\nGenero: {self.genero}" \
                                   f"\nAño: {self.year}, " \
                                   f"\nDirector: {self.director}" \
                                   f"\nInterpretes{self.interpretes}\n"


class Videojuego(Producto):
    def __init__(self, tit, tip, prec, esti, plat):
        super().__init__(tit, tip, prec)
        self.estilo = esti
        self.plataforma = plat

    def __str__(self):
        return super().__str__() + f"\nEstilo: {self.estilo}" \
                                   f"\nPlataforma: {self.plataforma}\n"


class Cliente:
    def __init__(self, i, nom, dir, tel, product=None):
        if product is None:
            product = []
        self.id = i
        self.nombre = nom
        self.direccion = dir
        self.telefono = tel
        self.productos = product

    def alquilar(self, product):
        self.productos.append(product)

    def __str__(self):
        listProduct = []
        for producto in self.productos:
            listProduct.append(producto.titulo)

        return f"Id: {self.id}" \
               f"\nNombre: {self.nombre}" \
               f"\nDireccion: {self.direccion}" \
               f"\nTelefono; {self.telefono}" \
               f"\nProductos {listProduct}\n"


#############################################
def ejemploPR():
    # Videojuegos
    eft = Videojuego("Escape from Tarkov", "videojuego", 5.0, "Shooter", "PC")
    tekken7 = Videojuego("Tekken 7", "videojuego", 3.0, "Peleas", "PS5")
    n23 = Pelicula("El numero 23", "pelicula", 4.0, "Thriller", 2008, "No se", ["Muchos"])
    avatar = Pelicula("Avatar", "pelicula", 5.0, "Fantasia", 2008, "No se", ["Muchos"])
    l = {"escape from tarkov": eft, "tekken 7": tekken7, "el numero 23": n23, "avatar": avatar}
    return l


def ejemploCL():
    pepe = Cliente(0, "Pepe", "Calle de Pepe", 666666666)
    juan = Cliente(1, "Juan", "Calle de Juan", 777777777)
    l = {"pepe": pepe, "juan": juan}
    return l


def addVideojuego(listaPR):
    tit = input("Introduce el titulo: ").strip()
    prec = float(input("Introduce el precio: ").strip())
    esti = input("Introduce el estilo: ").strip()
    plat = input("Introduce la plataforma: ").strip()
    videjouego = Videojuego(tit, "videojuego", prec, esti, plat)
    listaPR[tit.lower()] = videjouego


def addPelicula(listaPR):
    tit = input("Introduce el titulo: ").strip()
    prec = float(input("Introduce el precio: ").strip())
    gen = input("Introduce el genero: ").strip()
    anio = int(input("Introduce el año: ").strip())
    direct = input("Introduce el director").strip()
    interp = input("Introduce los interpretes separados por coma").strip().split(",")
    pelicula = Pelicula(tit, "pelicula", prec, gen, anio, direct, interp)
    listaPR[tit.lower()] = pelicula


def addCliente(listaCL):
    i = len(listaCL)
    nom = input("Introduce el nombre: ").strip()
    dir = input("Introduce la direccion").strip()
    tel = int(input("Introduce el telefono").strip())
    cliente = Cliente(i, nom, dir, tel)
    listaCL[nom.lower()] = cliente


def alquilar(listaPR, listaCL):
    ##No hago la comprobacion de si esta alquilado porque ya se encuentra en la clase, quiero verlo :)
    #Producto
    for key in listaPR:
        print(key)
    prod = input("Introduce el producto a alquilar")
    if prod not in listaPR.keys():
        print("No se encuentra el producto")
        return
    #Cliente
    for key in listaCL:
        print(key)
    cli = input("Introduce el cliente a quien se alquila")
    if cli not in listaCL.keys():
        print("No se encuentra el cliente")
        return
    #Dia
    dia = int(input("Introduce los dias de alquiler (min 1, max 7)"))
    #Alquilar y comprobar
    if listaPR[prod].alquilar(listaCL[cli], dia):
        print(f"{listaPR[prod].titulo} alquilado a {listaCL[cli].nombre} por {dia} dias")
    else:
        print(f"{listaPR[prod].titulo} ya se encuentra alquilado")


if __name__ == '__main__':
    listaPR = ejemploPR()
    listaCL = ejemploCL()

    menu = "1. Listar productos\n" \
           "2. Añadir productos\n" \
           "3. Ficha producto\n" \
           "4. Lista clientes\n" \
           "5. Añadir cliente\n" \
           "6. Ficha cliente\n" \
           "7. Alquiler producto\n"

    opcion = "-1"
    while opcion != "0":
        print(menu)
        opcion = input("Seleccione una opcion: ").strip()

        if opcion == "1":
            for key in listaPR:
                print(key)
        elif opcion == "2":
            op = -1
            while op != "1" and op != "2":
                print("Selecciona el tipo de producto:"
                      "1. Videojuego"
                      "2. Pelicula")
                op = input().strip()
            if op == "1":
                addVideojuego(listaPR)
            else:
                addPelicula(listaPR)
        elif opcion == "3":
            pr = input("Introduce el producto a consultar: ").strip().lower()
            if pr in listaPR.keys():
                print(listaPR[pr])
            else:
                print("El producto seleccionado no existe")
        elif opcion == "4":
            for key in listaCL:
                print(key)
        elif opcion == "5":
            addCliente(listaCL)
        elif opcion == "6":
            pr = input("Introduce el cliente a consultar: ").strip().lower()
            if pr in listaCL.keys():
                print(listaCL[pr])
            else:
                print("El cliente seleccionado no existe")
        elif opcion == "7":
            alquilar(listaPR, listaCL)
        elif opcion == "0":
            print("FIN DE PROGRAMA")
