class Diccionario:
    def __init__(self, nom, ed, nvl):
        self.nombre = nom
        self.editorial = ed
        self.nvl = nvl
        self.diccionario = {}
        self.diccionarioDePrueba()

    def diccionarioDePrueba(self):

        self.diccionario["alumno"] = acepciones = {0: "Persona que asiste a una clase para aprender"}
        self.diccionario["profesor"] = acepciones = {0: "Persona que imparte una clase",
                                        1: "Persona que toca en una orquesta"}

    def introducirPalabras(self, palabra):
        self.diccionario[palabra] = acepciones = {}

    def introducirAcepciones(self, palabra, valor):
        longi = len(self.diccionario[palabra])

        self.diccionario[palabra][longi] = valor

    def consultarDiccionario(self, palabra):
        resultado = palabra + ": \n"
        for ac in dict(self.diccionario[palabra]).keys():
            resultado += "\t" + self.diccionario[palabra][ac] + "\n"
        return resultado

    def palabrasOrdenadas(self, letra):
        lista = []
        for palabra in self.diccionario:
            if palabra.strip()[0:1] == letra:
                lista.append(palabra)
        lista.sort()
        return lista


if __name__ == '__main__':
    menu = "1. Crear diccionario\n" \
           "2. Introducir palabra\n" \
           "3. Introducir acepciones a una palabra\n" \
           "4. Consultar palabra\n" \
           "5. Obtener palabras por letra\n" \
           "0. Salir\n"

    opcion = "-1"
    while opcion != "0":
        print(menu)

        opcion = input("Seleccione una opcion: ").strip()

        if opcion == "1":
            nombre = input("Introduce el nombre del diccionario:")
            ed = input("Introduce la editorial del diccionario:")
            lvl = input("Introduce el nivel del diccionario:")
            dic = Diccionario(nombre, ed, lvl)
        elif opcion == "2":
            palabra = input("Escribe la palabra a introducir:").strip().lower()
            dic.introducirPalabras(palabra)
        elif opcion == "3":
            palabra = input("Escribe la palabra sobre la que quieres trabajar:").lower()
            acepcion = input("Escribe la acepcion para " + palabra).strip()
            dic.introducirAcepciones(palabra, acepcion)
        elif opcion == "4":
            palabra = input("Escribe la palabra a consultar:").strip().lower()
            print(dic.consultarDiccionario(palabra))
        elif opcion == "5":
            letra = input("Escribe la letra a buscar:").strip().lower()
            palabras = dic.palabrasOrdenadas(letra)
            for palabra in palabras:
                print(palabra, end=", " if palabra != palabras[len(palabras) - 1] else "\n\n")
        elif opcion == "0":
            print("\nFIN DE PROGRAMA")
