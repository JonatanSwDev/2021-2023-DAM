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
    public partial class AbrirFactura : Form
    {
        public AbrirFactura()
        {
            InitializeComponent();
            using (OpenFileDialog openFileDialog = new OpenFileDialog())
            {
                openFileDialog.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
                openFileDialog.FilterIndex = 1;
                openFileDialog.RestoreDirectory = true;

                if (openFileDialog.ShowDialog() == DialogResult.OK)
                    using (StreamReader reader = new StreamReader(openFileDialog.OpenFile()))
                    {
                       richTextBox1.Text = reader.ReadToEnd();
                        
                    }
                }
            }

        private void butSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }

}
