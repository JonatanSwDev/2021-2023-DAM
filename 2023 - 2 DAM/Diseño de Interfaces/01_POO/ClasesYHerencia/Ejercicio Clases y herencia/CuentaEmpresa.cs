using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio_Clases_y_herencia
{
    internal class CuentaEmpresa : Cuenta
    {
        private long interes;
        private double credito;
        private int mesesCredito;
        private double topeCredito;

        public CuentaEmpresa() { }
        public CuentaEmpresa(int numero, String titular, String dni) : base(numero, titular, dni)
        {
            this.interes = 2;
            this.credito = 0;
            this.mesesCredito = 12;
            this.topeCredito = 5000;
        }

        public override bool Reintegro(double importe)
        {
            if (importe > base.getSaldo())
            {
                if (CalcularCredito(importe))
                {
                    if (base.Reintegro(importe))
                    {
                        return true;
                    }
                    else { return false; }
                }
                else { return false; }
            }
            else if (base.Reintegro(importe))
            {
                return true;
            }
            else { return false; }
        }

        public bool CalcularCredito(double importe)
        {
            double prestamoNecesario = importe - this.getSaldo();
            double prestamoSimulado = prestamoNecesario + this.credito;
            if (prestamoSimulado <= this.topeCredito)
            {
                this.credito += prestamoNecesario;
                if (base.Ingreso(prestamoNecesario)) { return true; } else { return false; }
            }
            else { return false; }
        }

        public String MostrarCredito()
        {
            if (credito > 0)
            {
                return this.credito + " - " + this.interes + "% - " + 
                        ((credito + (credito * interes)/100)/ mesesCredito) + " €/mes";
            } else { return ""; }
        }

        public override string ToString()
        {
            return base.ToString() + "\nInteres: " + this.interes +
                                    "\nCredito: " + this.credito +
                                    "\nTope: " + this.topeCredito +
                                    "\nMeses: " + this.mesesCredito + "\n" +
                                    MostrarCredito();
        }





    }
}
