using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ex2EvJonatan
{
    public partial class Padre : Form
    
    {
        public static List<Producto> productos = new List<Producto>();
        public static int nProductos = 0;
        public static List<Detalle_Ped> dPedidos = new List<Detalle_Ped>();
        public static int nDetPedidos = 0;
        public static List<Pedido> pedidos = new List<Pedido>();
        public static int nPedidos = 0;

        public Padre()
        {
            InitializeComponent();
        }

        private void productosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            for (int i = 1; i <= 4; i++)
            {
                productos.Add(new Producto(i, "Producto" + i, i*2.1, 10));
            }
            nProductos = 4;
            menuProductos.Enabled = false;
            menuPyD.Enabled = true;
            MessageBox.Show("Productos creados");
        }

        private void pedidosYDetallesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PyD soyHijo = new PyD();
            soyHijo.MdiParent = this;
            soyHijo.Show();
        }

        private void productoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Consulta soyHijo = new Consulta();
            soyHijo.MdiParent = this;
            soyHijo.Show();
        }

        private void menuCrear_Click(object sender, EventArgs e)
        {
            CrearFactura soyHijo = new CrearFactura();
            soyHijo.MdiParent = this;
            soyHijo.Show();
        }

        private void acercaDeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Jonatan Gomez Garcia");
        }

        private void menuAbrir_Click(object sender, EventArgs e)
        {
            AbrirFactura soyHijo = new AbrirFactura();
            soyHijo.MdiParent = this;
            soyHijo.Show();
        }
    }
}
