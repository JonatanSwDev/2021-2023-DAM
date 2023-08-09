using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ex2EvJonatan
{
    public partial class Consulta : Form
    {
        public Consulta()
        {
            InitializeComponent();
        }

        private void butSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void butBuscar_Click(object sender, EventArgs e)
        {
            try
            {
                int idBuscar = int.Parse(txtCod.Text);
                Producto producto = buscarProducto(idBuscar);
                if (producto != null)
                {
                    txtNombre.Text = producto.NomPro;
                    txtPrecio.Text = producto.PrecioPro.ToString();
                    txtStock.Text = producto.StockPro.ToString();
                }
            } catch
            {
                MessageBox.Show("Ha ocurrido un error al buscar el producto");
            }
        }

        private Producto buscarProducto(int idProducto)
        {
            foreach (Producto act in Padre.productos)
            {
                if (idProducto == act.CodPro)
                {
                    return act;
                }
            }
            MessageBox.Show("Producto no encontrado");
            return null;
        }
    }
}
