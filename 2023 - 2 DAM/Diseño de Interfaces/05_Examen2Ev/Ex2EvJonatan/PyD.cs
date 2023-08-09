using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ex2EvJonatan
{
    public partial class PyD : Form
    {
        public PyD()
        {
            InitializeComponent();
            actualizarFromulario();
        }

        private void actualizarFromulario()
        {
            txtidPedido.Text = "" + (Padre.nPedidos + 1);
            txtFecha.Text = DateTime.Now.ToShortDateString();
            foreach(Producto act in Padre.productos)
            cbCodProd.Items.Add(act.CodPro);
        }

        private void butGuardar_Click(object sender, EventArgs e)
        {
            try
            {
                Padre.pedidos.Add(new Pedido(int.Parse(txtidPedido.Text)
                , int.Parse(txtCCliente.Text)
                , DateTime.Now));
                MessageBox.Show("Pedido " + txtidPedido.Text + " generado con exito");
                Padre.nPedidos++;
                grAlta.Enabled = false;
                grDetalles.Enabled = true;
            } catch
            {
                MessageBox.Show("Ha ocurrido un error al generar el pedido");
            }
        }

        private void butCancelar_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void butPlus_Click(object sender, EventArgs e)
        {
            try
            {
                int idPedido = int.Parse(cbCodProd.Text);
                Producto producto = buscarProducto(idPedido);
                if (producto == null)
                {
                    MessageBox.Show("Ha ocurrido un error al cargar el producto");
                    return;
                }
                int cantidad = int.Parse(txtCantidad.Text);

                if (cantidad <= producto.StockPro && cantidad > 0)
                {

                    Padre.dPedidos.Add(new Detalle_Ped(int.Parse(txtidPedido.Text)
                , int.Parse(cbCodProd.Text)
                , int.Parse(txtCantidad.Text)));
                    producto.StockPro -= cantidad;
                    MessageBox.Show("Detalles del pedido generada con exito\nQuedan " + producto.StockPro);

                }
                else
                {
                    MessageBox.Show("Stock insuficiente, quedan " + producto.StockPro);
                }
            } catch
            {
                MessageBox.Show("Ha ocurrido un error al añadir los detalles");
            }
        }

        private Producto buscarProducto(int idPedido)
        {
            foreach (Producto act in Padre.productos)
            {
                if (idPedido == act.CodPro)
                {
                    return act;
                }
            }
            return null;
        }

        private void butTerminar_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
