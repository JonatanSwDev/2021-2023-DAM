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
    public partial class CrearFactura : Form
    {
        public CrearFactura()
        {
            InitializeComponent();
        }

        private void butCancelar_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void butAceptar_Click(object sender, EventArgs e)
        {
            richTextBox1.Clear();
            int idPedido = int.Parse(txtCodPed.Text);
            Pedido pedido = buscarPedido(idPedido);
            double totalTodo = 0;
            string resultado = "CodPedi: " + pedido.CodPedi + "\tCodCliPedi " + pedido.CodCliPedi + 
                "\t\tFechaPedi: " + pedido.FechaPedi.ToString() + "\n\n";
            foreach (Detalle_Ped dPed in Padre.dPedidos)
            {
                if (dPed.CodPediDetal == pedido.CodPedi)
                {
                    Producto prod = buscarProducto(dPed.CodPediDetal);
                    double total = dPed.CantidadDetal * prod.PrecioPro;
                    totalTodo += total;
                    resultado += "CodPediDetal: " + dPed.CodPediDetal + "\tNomPro: " + prod.NomPro +
                        "\t\tCantidadDetal: " + dPed.CantidadDetal + "\tPrecioPro: " + prod.PrecioPro +
                        "\tTotal: " + total + "\n\n";
                }
            }
            resultado += "\t\t\t\t\t\t\t\t\tTotalFactura: " + totalTodo;
            richTextBox1.Text = resultado;
        }

        private Pedido buscarPedido(int idPedido)
        {
            foreach (Pedido act in Padre.pedidos)
            {
                if (idPedido == act.CodPedi)
                {
                    return act;
                }
            }
            MessageBox.Show("Pedido no encontrado");
            return null;
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

        private void butGuardar_Click(object sender, EventArgs e)
        {
            
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();
            saveFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            saveFileDialog1.FilterIndex = 1;
            saveFileDialog1.RestoreDirectory = true;

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                File.WriteAllText(saveFileDialog1.FileName, richTextBox1.Text);
                MessageBox.Show("Factura guardado con exito");
            }
        }
    }
}
