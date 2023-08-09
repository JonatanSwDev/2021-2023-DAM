using System;
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
    public partial class CajeroAutomatico : Form
    {
        private List<ClaseTarjeta> tarjetas = new List<ClaseTarjeta>();
        ClaseTarjeta tarjeta = new ClaseTarjeta();
        private int intentos = 1;
        public CajeroAutomatico()
        {
            InitializeComponent();
            reset();
        }

        private void reset()
        {
            txtNumTar.Enabled = true;
            txtNumTar.Clear();
            lblTarjeta.Visible = false;
            lblClave.Visible = false;
            txtClaveTar.Visible = false;
            txtClaveTar.Clear();
            txtNumTar.Visible = false;
            txtNumTar.Clear();
            butClaveTar.Visible = false;
            butNumTar.Visible = false;
            intentos = 1;
            gpboxDesbloquear.Visible = false;
            txtTarDes.Clear();
            txtNombre.Clear();
            butDesbloquear.Visible = false;
        }

        private void principal()
        {
            butCrearLista.Visible = false;
            lblTarjeta.Visible = true;
            txtNumTar.Visible = true;
            butNumTar.Visible = true;
            tarjeta = new ClaseTarjeta();
            butDesbloquear.Visible = true;
        }

        private void butCrearLista_Click(object sender, EventArgs e)
        {
            tarjetas = new List<ClaseTarjeta>();
            String[] nombres = {"Felipe","Ramon","Lucas","Antonio","Josefa"};
            for (int i = 0; i < 5; i++)
            {
                ClaseTarjeta tarjetaAdd = new ClaseTarjeta(i.ToString(), nombres[i], 1234);
                tarjetas.Add(tarjetaAdd);
            }
            principal();
        }

        private void butNumTar_Click(object sender, EventArgs e)
        {
            foreach (ClaseTarjeta tarjetaActual in tarjetas)
            {
                if (txtNumTar.Text.Equals(tarjetaActual.GetNumTarjeta()))
                {
                    if (!tarjetaActual.EstaBloqueada())
                    {
                        tarjeta = tarjetaActual;
                        MessageBox.Show("Tarjeta " + tarjeta.GetNumTarjeta() + " seleccionada");
                        txtNumTar.Enabled = false;
                        txtClaveTar.Visible = true;
                        lblClave.Visible = true;
                        butNumTar.Visible = false;
                        butClaveTar.Visible = true;
                        return;
                    } else
                    {
                        MessageBox.Show("La tarjeta " + tarjetaActual.GetNumTarjeta() + " esta bloqueada");
                        return;
                    }
                }
            }
            MessageBox.Show("No se ha encontrado ninguna tarjeta con ese numero");
        }

        private void butClaveTar_Click(object sender, EventArgs e)
        {
            if (intentos <= 3 && txtClaveTar.Text.Equals(tarjeta.GetClaveTarjeta().ToString()))
            {
                MessageBox.Show("Acceso autorizado");
                Operaciones op = new Operaciones(tarjeta,this);
                op.Show();
                reset();
                principal();
                this.Hide();
            }
            else if (intentos <3 && !txtClaveTar.Text.Equals(tarjeta.GetClaveTarjeta()))
            {
                MessageBox.Show("Clave incorrecta, intentos restantes: " + (3 - intentos));
                intentos++;
            } 
            else if (intentos >= 3 && !txtClaveTar.Text.Equals(tarjeta.GetClaveTarjeta()))
            {
                tarjeta.SetBloqueo(true);
                MessageBox.Show("Has excedido el numero de intentos, tarjeta " + tarjeta.GetNumTarjeta() + " bloqueada");
                reset();
                principal();
            }
        }

        private void butDesbloquear_Click(object sender, EventArgs e)
        {
            reset();
            gpboxDesbloquear.Visible = true;
        }

        private void butTarDes_Click(object sender, EventArgs e)
        {
            foreach (ClaseTarjeta tarjetaActual in tarjetas)
            {
                if (txtTarDes.Text.Equals(tarjetaActual.GetNumTarjeta()) && txtNombre.Text.Equals(tarjetaActual.GetNombre()))
                {
                    tarjetaActual.SetBloqueo(false);
                    MessageBox.Show("Verificacion completada, tarjeta desbloqueada");
                    reset();
                    principal();
                    return; 
                }  
            }
            MessageBox.Show("Fallo de verificación");
            reset();
            principal();
        }

        private void butCerrar_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
