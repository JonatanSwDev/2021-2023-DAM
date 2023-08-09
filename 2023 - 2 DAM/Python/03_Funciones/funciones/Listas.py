def duplicarLista(lista):
    ##Este metodo no hace falta que devuelva la lista, ya que actua directamente sobre las direcciones en memoria
    for i in range(len(lista)):
        lista.append(lista[0]*2)
        del lista[0]

def concatLista(lista):
    return lista + lista
