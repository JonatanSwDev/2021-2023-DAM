using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Jonatan_Gomez_Examen1ev
{
    public partial class Operaciones : Form
    {
        ClaseTarjeta tarjeta = new ClaseTarjeta();
        Form padre;
        string movimientos = "";
        public Operaciones(ClaseTarjeta tarjeta, Form padre)
        {
            InitializeComponent();
            this.tarjeta = tarjeta;
            this.Text = "Cliente: " + tarjeta.GetNombre();
            this.padre = padre;
            reset();
        }

        private void reset()
        {
            gpboxIngresar.Visible = false;
            txtImporteRe.Clear();
            gpboxRetirar.Visible = false;
            txtIngreso.Clear();
            rtxtConsulta.Visible = false;
            rtxtConsulta.Clear();
        }

        private void butIngresar_Click(object sender, EventArgs e)
        {
            try
            {
                double importe = Double.Parse(DecimalAutentico(txtIngreso.Text));
                if (importe > 0)
                {
                    if (tarjeta.Ingresar(importe))
                    {
                        MessageBox.Show("Ingreso realizado\nSlado actual " + tarjeta.GetSaldo());
                        movimientos += " [" + DateTime.Now.ToString() + "] Ingreso de " + importe + " realizado (saldo: " + tarjeta.GetSaldo()+ ")\n";
                        resetIngreso();
                    } else
                    {
                        MessageBox.Show("Ha ocurrido un error en el proceso de ingreso");
                        resetIngreso();
                    }
                } else if (importe == 0 || txtIngreso.TextLength == 0)

                {
                    MessageBox.Show("Introduce un importe mayor a 0");
                    resetIngreso();
                } else
                {
                    MessageBox.Show("Importe no valido");
                    resetIngreso();
                }
            }catch
            {
                MessageBox.Show("Ha ocurrido un error");
                resetIngreso();
            }
        }

        private void ingresoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            reset();
            gpboxIngresar.Visible = true;
        }

        private void butRetirar_Click(object sender, EventArgs e)
        {
            try
            {
                double importe = Double.Parse(DecimalAutentico(txtImporteRe.Text));
                if (importe > 0)
                {
                    if (tarjeta.Reintegro(importe))
                    {
                        MessageBox.Show("Retiro realizado\nSlado actual " + tarjeta.GetSaldo());
                        movimientos += " [" + DateTime.Now.ToString() + "] Retiro de " + importe + " realizado (saldo: " + tarjeta.GetSaldo() + ")\n";
                        resetRetiro();

                    }
                    else
                    {
                        MessageBox.Show("Ha ocurrido un error en el proceso de ingreso\nSaldo actual: " + tarjeta.GetSaldo());
                        movimientos += " [" + DateTime.Now.ToString() + "] Error al intentar retirar " + importe + "€, saldo actual " + tarjeta.GetSaldo() + "€\n";
                        resetRetiro();
                    }
                }
                else if (importe == 0 || txtImporteRe.TextLength == 0)

                {
                    MessageBox.Show("Introduce un importe mayor a 0");
                    resetRetiro();
                }
                else
                {
                    MessageBox.Show("Importe no valido");
                    resetRetiro();
                }
            }
            catch
            {
                MessageBox.Show("Ha ocurrido un error");
                resetRetiro();
            }
        }

        private void reintegroToolStripMenuItem_Click(object sender, EventArgs e)
        {
            reset();
            gpboxRetirar.Visible = true;
        }

        private void toolStripMenuItem2_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Saldo actual: " + tarjeta.GetSaldo());
            movimientos += " [" + DateTime.Now.ToString() + "] Consulda de saldo: " + tarjeta.GetSaldo() + "€\n";
        }

        private void toolStripMenuItem3_Click(object sender, EventArgs e)
        {
            reset();
            movimientos += " [" + DateTime.Now.ToString() + "] Consulta de movimientos\n";
            rtxtConsulta.Visible = true;
            rtxtConsulta.Text = movimientos;
        }

        private void toolStripMenuItem4_Click(object sender, EventArgs e)
        {
            padre.Show();
            this.Close();
        }

        private string DecimalAutentico(string numero)
        {
            
            return numero.Replace('.', ',');
        }

        private void resetRetiro()
        {
            txtImporteRe.Clear();
            txtImporteRe.Focus();
        }

        private void resetIngreso()
        {
            txtIngreso.Clear();
            txtIngreso.Focus();
        }
    }
}
