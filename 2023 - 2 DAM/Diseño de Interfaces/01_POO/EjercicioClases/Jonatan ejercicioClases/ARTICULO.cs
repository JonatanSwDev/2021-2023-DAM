using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Jonatan_ejercicioClases
{
    internal class ARTICULO
    {
        private int codigoArticulo;
        private String nombreArticulo;
        private String categoriaArticulo;
        private double precioArticulo;
        private int existencias;
        private static int cod = 0;

        public ARTICULO() { }
        public ARTICULO(String nombreArticulo, String categoriaArticulo, double precioArticulo, int existencias)
        {
            cod++;
            this.codigoArticulo = cod;
            this.codigoArticulo = codigoArticulo;
            this.nombreArticulo = nombreArticulo;
            if (categoriaArticulo.Equals("Informática")
                || categoriaArticulo.Equals("Imagen")
                || categoriaArticulo.Equals("Telefonía")
                || categoriaArticulo.Equals("Sonido"))
            {
                this.categoriaArticulo = categoriaArticulo;
            } else
            {
                this.categoriaArticulo = null;
            }
            this.precioArticulo = precioArticulo;
            this.existencias = existencias;
        }

        public int getCodigo()
        {
            return this.codigoArticulo;
        }
        public String getNombre()
        {
            return this.nombreArticulo;
        }
        public String getCategoria()
        {
            return this.categoriaArticulo;
        }
        public double getPrecio()
        {
            return this.precioArticulo;
        }
        public int getExistencias()
        {
            return this.existencias;
        }

        //Setters
        public void setNombre(String nombreArticulo)
        {
            this.nombreArticulo = nombreArticulo;
        }
        public void setCategoria(String categoriaArticulo)
        {
            if (categoriaArticulo.Equals("Informática")
                || categoriaArticulo.Equals("Imagen")
                || categoriaArticulo.Equals("Telefonía")
                || categoriaArticulo.Equals("Sonido"))
            {
                this.categoriaArticulo = categoriaArticulo;
            }
            else
            {
                this.categoriaArticulo = null;
            }
        }
        public void setPrecio(double precioArticulo)
        {
            this.precioArticulo = precioArticulo;
        }
        public void setExistencias(int existencias)
        {
            this.existencias = existencias;   
        }

        public override string ToString()
        {
            return "Codigo: " + this.codigoArticulo +
                "   Nombre: " + this.nombreArticulo +
                "   Categoria: " + this.categoriaArticulo +
                "   Precio: " + this.precioArticulo + 
                "   Existencias: " + this.existencias
                ;
        }

        public void actualizarExistencias(int cantidadPedido)
        {
            if (cantidadPedido <= this.existencias)
            {
                this.existencias -= cantidadPedido;
                MessageBox.Show("Pedido realizado\n" + "Quedan " + existencias + " " + this.nombreArticulo);
            } else
            {
                MessageBox.Show("No hay existencias suficientes");
            }
        }

    }
}
