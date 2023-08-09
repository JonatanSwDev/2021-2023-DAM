from funciones.Listas import concatLista

lista1 = [1,2,3]
print(f"Lista1 recien creada: {lista1}")
lista2 = concatLista(lista1)
print(f"Lista 2 resultado de llamar al metodo: {lista2}")
print(f"Lista 1 despues de llamar al metodo: {lista1}")
lista1[0] = 100
print(f"Lista 1 modificada: {lista1}")
print(f"La lista2 sigue intacta despues de la modificacion: {lista2}")