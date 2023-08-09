using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio_Clases_y_herencia
{
    public partial class Banco : Form
    {
        List<Object> cuentas = new List<Object>();
        int id = 1;
        private int tipo = -1;
        public Banco()
        {
            InitializeComponent();
            reset();
        }

        private void reset()
        {
            gpboxConsultar.Visible = false;
            rtxtConsultar.Clear();
            txtCuentaCons.Clear();
            gpboxInRe.Visible = false;
            txtCantidadInRe.Clear();
            txtCuentaInRe.Clear();
            gpboxTransferir.Visible = false;
            gpboxAlta.Visible = false;
            txtCuentaAlta.Clear();
            txtTitularAlta.Clear();
            txtDniAlta.Clear();
            tipo = -1;
        }

        private void menuConsultaNumero_Click(object sender, EventArgs e)
        {
            reset();
            gpboxConsultar.Visible = true;
            lblCuentaCons.Text = "Cuenta:";
        }

        private void menuConsultaDNI_Click(object sender, EventArgs e)
        {
            reset();
            gpboxConsultar.Visible = true;
            lblCuentaCons.Text = "DNI:";
        }
        private void butConsultar_Click(object sender, EventArgs e)
        {
            foreach (Cuenta cuenta in cuentas)
            {
                if (cuenta.getDni().Equals(txtCuentaCons.Text) || txtCuentaCons.Text.Equals(cuenta.getNumero().ToString()))
                {
                    rtxtConsultar.Text = cuenta.ToString();
                    txtCuentaCons.Clear();
                    return;
                }
            }
            MessageBox.Show("No se encontro ninguna cuenta");
            txtCuentaCons.SelectAll();
            txtCuentaCons.Focus();
        }

        private void menuIngreso_Click(object sender, EventArgs e)
        {
            reset();
            gpboxInRe.Visible = true;
            gpboxInRe.Text = "Ingresar";
            butInRe.Text = "Ingresar";
            tipo = 0;

        }

        private void menuReintegro_Click(object sender, EventArgs e)
        {
            reset();
            gpboxInRe.Visible = true;
            gpboxInRe.Text = "Retirar";
            butInRe.Text = "Retirar";
            tipo = 1;
        }

        private void butInRe_Click(object sender, EventArgs e)
        {
            try
            {

                double cantidad = Double.Parse(PasarDecimal(txtCantidadInRe.Text));
                Cuenta cuenta = new Cuenta();
                foreach (Object cuentaActual in cuentas)
                {
                    if (Object.ReferenceEquals(cuentaActual.GetType(), cuenta.GetType()))
                    {
                        cuenta = (Cuenta)cuentaActual;
                    }
                    else
                    {
                        cuenta = (CuentaEmpresa)cuentaActual;
                    }
                    if (txtCuentaInRe.Text.Equals(cuenta.getNumero().ToString()) && tipo == 0 && cuenta.Ingreso(cantidad))
                    {
                        MessageBox.Show("Ingreso de " + cantidad + "€ realizado\nSaldo actual: " + cuenta.getSaldo());
                        txtCuentaInRe.Clear();
                        txtCantidadInRe.Clear();
                        return;
                    }
                    else if (txtCuentaInRe.Text.Equals(cuenta.getNumero().ToString()) && tipo == 1)
                    {
                        if (cuenta.Reintegro(cantidad))
                        {
                            MessageBox.Show("Retiro de " + cantidad + "€ realizado\nSaldo actual: " + cuenta.getSaldo());
                            txtCuentaInRe.Clear();
                            txtCantidadInRe.Clear();
                            return;
                        }
                        else { MessageBox.Show("Operacion denegada\nSaldo actual: " + cuenta.getSaldo() + "€"); return; }
                    }
                }
                MessageBox.Show("No se ha podido realizar la operacion\nVrifique cuenta y cantidad");
            }
            catch
            {
                MessageBox.Show("Ingrese una cantidad valida");
                txtCantidadInRe.SelectAll();
                txtCantidadInRe.Focus();
            }
        }

        private String PasarDecimal(String numero)
        {
            return numero.Replace('.', ',');
        }

        private void menuTransferencia_Click(object sender, EventArgs e)
        {
            reset();
            gpboxTransferir.Visible = true;
        }

        private void butTransferir_Click(object sender, EventArgs e)
        {
            double cantidad = 0;
            try
            {
                cantidad = Double.Parse(PasarDecimal(txtCantidadTr.Text));
            } catch {
                MessageBox.Show("Introduce una cantidad válida");
                txtCantidadTr.SelectAll();
                txtCantidadTr.Focus();
                return;
            }
            Cuenta cuenta = new Cuenta();
            Cuenta cuentaOr = new Cuenta();
            Cuenta cuentaDe = new Cuenta();
            foreach (Object cuentaActual in cuentas)
            {
                if (Object.ReferenceEquals(cuentaActual.GetType(), cuenta.GetType()))
                {
                    cuenta = (Cuenta)cuentaActual;
                }
                else
                {
                    cuenta = (CuentaEmpresa)cuentaActual;
                }
                if (txtCuentaOr.Text.Equals(cuenta.getNumero().ToString())) {
                    cuentaOr = cuenta;
                }
                if (txtCuentaDe.Text.Equals(cuenta.getNumero().ToString()))
                {
                    cuentaDe = cuenta;
                }
            }
            if (cuentaOr.getNumero() != cuentaDe.getNumero() && cuentaOr.Transferencia(cuentaDe, cantidad))
            {
                MessageBox.Show("Transferencia de " + cantidad + "€ realizada de cuenta " +
                    cuentaOr.getNumero() + " a cuenta " + cuentaDe.getNumero() +
                    "\nSaldo cuenta " + cuentaOr.getNumero() + ": " + cuentaOr.getSaldo() +
                    "\nSaldo cuenta " + cuentaDe.getNumero() + ": " + cuentaDe.getSaldo());
                txtCantidadTr.Clear();
                txtCuentaOr.Clear();
                txtCuentaOr.Focus();
                txtCuentaDe.Clear();
            } else { MessageBox.Show("Operacion denegada"); }
        }


        private void butAlta_Click(object sender, EventArgs e)
        {
            if (tipo == 0 && txtCuentaAlta.TextLength != 0 && txtDniAlta.TextLength != 0)
            {
                cuentas.Add(new Cuenta(id, txtTitularAlta.Text, txtDniAlta.Text));
                MessageBox.Show("Cuenta " + id + " creada");
                id++;
                txtCuentaAlta.Text = "" + id;
            } else if (tipo == 1 && txtCuentaAlta.TextLength != 0 && txtDniAlta.TextLength != 0)
            {
                cuentas.Add(new CuentaEmpresa(id, txtTitularAlta.Text, txtDniAlta.Text));
                MessageBox.Show("Cuenta " + id + " creada");
                id++;
                txtCuentaAlta.Text = "" + id;
            } else if (tipo == -1)
            {
                MessageBox.Show("Selecciona tipo de cuenta");
            } else { MessageBox.Show("Se ha producido un error"); }
        }

        private void rbutCuenta_CheckedChanged(object sender, EventArgs e)
        {
            tipo = 0;
        }

        private void rbutonEmpresa_CheckedChanged(object sender, EventArgs e)
        {
            tipo = 1;
        }

        private void menuAlta_Click(object sender, EventArgs e)
        {
            reset();
            gpboxAlta.Visible = true;
            txtCuentaAlta.Text = "" + id;
        }
    }
}
