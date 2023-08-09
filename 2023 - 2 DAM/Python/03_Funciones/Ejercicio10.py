from funciones.Listas import duplicarLista

##Este ejercicio llama a duplicarLista enviandole una lista y no recibe la lista generada, ya q ue los cambios se hacen directamente en memoria
lista = [1,2,3]
print(lista)
duplicarLista(lista)
print(lista)