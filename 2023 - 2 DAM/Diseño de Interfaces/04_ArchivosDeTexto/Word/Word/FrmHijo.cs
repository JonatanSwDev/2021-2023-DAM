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

namespace Word
{
    public partial class FrmHijo : Form
    {
        private bool cambios = false;
        private string ruta = null;
        public FrmHijo()
        {
            InitializeComponent();
            
        }

        public FrmHijo(string ruta)
        {
            InitializeComponent();
            this.ruta = ruta;
        }
        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            cambios = true;
        }


        public RichTextBox getTexto()
        {
            return richTextBox1;
        }

        public string getRuta()
        {
            return ruta;
        }

        public void Guardado()
        {
            cambios = false;
        }

        public void GuardadoComo(string ruta)
        {
            this.ruta = ruta;
            cambios = false;
            this.Text = Path.GetFileName(ruta);
        }

        private void FrmHijo_FormClosing_1(object sender, FormClosingEventArgs e)
        {
            if (cambios)
            { //preguntar si se desean guardar los cambio con 3 opciones: Yes, No y Cancel
                DialogResult result = MessageBox.Show("¿Desea guardar los cambios?", this.Text,
                MessageBoxButtons.YesNoCancel, MessageBoxIcon.Question,
                 MessageBoxDefaultButton.Button1);
                //Preguntamos si quiere guardar o no antes de cerrar o cancela
                if (result == DialogResult.Cancel)
                {
                    e.Cancel = true; //Cancelamos el proceso de cerrado
                }
                else
                {
                    if (result == DialogResult.Yes)
                    {
                        Word padre = (Word) MdiParent;
                        padre.Guardar(this);
                    }
                }
            }
        }
    }
}
