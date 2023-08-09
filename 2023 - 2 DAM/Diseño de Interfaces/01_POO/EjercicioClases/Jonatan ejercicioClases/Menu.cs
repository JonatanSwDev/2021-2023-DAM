using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;

namespace Jonatan_ejercicioClases
{
    public partial class Menu : Form
    {
        bool codigo = false;
        List<ARTICULO> articulos = new List<ARTICULO>();
        public Menu()
        {
            InitializeComponent();
            reset();
        }
        private void reset()
        {
            lblCantidad.Visible = false;
            lblArticulo.Visible = false;
            txtCodigoArt.Visible = false;
            rtxtBox.Visible = false;
            butListar.Visible = false;
            butPedir.Visible = false;
            rtxtBox.Visible = false;
            butConsultar.Visible = false;
            rtxtBox.Text = "";
            txtCantidad.Visible = false;
            comboBox1.Visible = false;
            txtCantidad.Text = "";
            txtCodigoArt.Text = "";
            lblExistencias.Visible = false;
            lblNombreIn.Visible = false;
            lblInfoCodigo.Visible = false; 
            lblPrecio.Visible = false;
            lblCategoria.Visible = false;
            txtExistencias.Visible = false;
            txtInfoCodigo.Visible = false;
            txtNombreIn.Visible = false;
            txtPrecio.Visible = false;
            comboBox2.Visible = false;
            butAlta.Visible = false;
            gpAlta.Visible = false;
            
        }

        private void porCodigoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            reset();
            codigo = true;
            lblArticulo.Text = "Condigo del articulo";
            lblArticulo.Visible = true;
            txtCodigoArt.Visible = true;
            rtxtBox.Visible = true;
            butConsultar.Visible = true; 
        }

        private void porNombreToolStripMenuItem_Click(object sender, EventArgs e)
        {
            reset();
            codigo = false;
            lblArticulo.Text = "Nombre del articulo";
            lblArticulo.Visible = true;
            txtCodigoArt.Visible = true;
            rtxtBox.Visible = true;
            butConsultar.Visible = true;
        }

        private void butConsultar_Click(object sender, EventArgs e)
        {
            int c = 0;
            if (codigo)
            {
                try
                {
                    c = Int32.Parse(txtCodigoArt.Text);
                }
                catch
                {
                    MessageBox.Show("Introduce un codigo de articulo");
                    return;
                }
            }
            foreach (ARTICULO art in articulos)
            {
                if (codigo)
                {
                    if(art.getCodigo() == c)
                    {
                        rtxtBox.Text = art.ToString();
                        txtCodigoArt.Text = "";
                        return;
                    }
                }
                else if (!codigo)
                {
                    if (art.getNombre().Equals(txtCodigoArt.Text))
                    {
                        rtxtBox.Text = art.ToString();
                        txtCodigoArt.Text = "";
                        return;
                    }
                }

            }
            MessageBox.Show("Articulo no encontrado");
        }

        private void menuListarArticulos_Click(object sender, EventArgs e)
        {
            reset();
            rtxtBox.Visible = true;
            foreach (ARTICULO art in articulos)
            {
                rtxtBox.Text += art.ToString() + "\n";
            }
        }

        private void menuArticulosMinimos_Click(object sender, EventArgs e)
        {
            reset();
            rtxtBox.Visible = true;
            foreach (ARTICULO art in articulos)
            {
                if (art.getExistencias() < 10)
                {
                    rtxtBox.Text += art.ToString() + "\n";
                }
            }
            if (rtxtBox.Text.Length == 0)
            {
                MessageBox.Show("No hay articulos bajo minimos");
            }
        }


        private void menuArticulosCategoria_Click(object sender, EventArgs e)
        {
            reset();
            rtxtBox.Visible = true;
            comboBox1.Visible = true;
            butListar.Visible = true;
        }

        private void butListar_Click(object sender, EventArgs e)
        {
            rtxtBox.Text = "";
            foreach (ARTICULO art in articulos)
            {
                try
                {
                    if (art.getCategoria().Equals(comboBox1.Text))
                    {
                        rtxtBox.Text += art.ToString();
                    }
                }
                catch
                {
                    MessageBox.Show("Ha ocurrido un error");
                }
            }
        }

        private void menuPedido_Click(object sender, EventArgs e)
        {
            reset();
            lblArticulo.Visible = true;
            lblCantidad.Visible = true;
            txtCodigoArt.Visible = true;
            txtCantidad.Visible = true;
            butPedir.Visible = true;
        }

        private void butPedir_Click(object sender, EventArgs e)
        {
            try
            {
                int cod = Int32.Parse(txtCodigoArt.Text);
                int cant = Int32.Parse(txtCantidad.Text);
                bool actualizado = false;
                foreach (ARTICULO art in articulos)
                {
                    if (cod == art.getCodigo())
                    {
                        art.actualizarExistencias(cant);
                        actualizado = true;
                        txtCodigoArt.Text = "";
                        txtCantidad.Text = "";
                    }
                }
                if (!actualizado)
                {
                    MessageBox.Show("Articulo inexistente");
                }
            }
            catch
            {
                MessageBox.Show("Ha ocurrido un error");
            }   
        }

        private void menuAlta_Click(object sender, EventArgs e)
        {
            gpAlta.Visible = true;
            lblExistencias.Visible = true;
            lblNombreIn.Visible = true;
            lblInfoCodigo.Visible = true;
            lblPrecio.Visible = true;
            lblCategoria.Visible = true;
            txtExistencias.Visible = true;
            txtInfoCodigo.Visible = true;
            txtNombreIn.Visible = true;
            txtPrecio.Visible = true;
            comboBox2.Visible = true;
            butAlta.Visible = true;
            txtInfoCodigo.Text = (articulos.Count() + 1).ToString();
            
        }

        private void butAlta_Click(object sender, EventArgs e)
        {
            try
            {
                int existencias = Int32.Parse(txtExistencias.Text);
                double precio = Double.Parse(txtPrecio.Text);
                if (comboBox2.Text.Length !=0)
                {
                    articulos.Add(new ARTICULO(txtNombreIn.Text, comboBox2.Text, precio, existencias));
                    MessageBox.Show("Articulo creado");
                    txtInfoCodigo.Text = (articulos.Count() + 1).ToString();
                } else
                {
                    MessageBox.Show("Selecciona una categoria");
                }
            } catch
            {
                MessageBox.Show("Ha ocurrido un error");
            }
        }
    }
}
