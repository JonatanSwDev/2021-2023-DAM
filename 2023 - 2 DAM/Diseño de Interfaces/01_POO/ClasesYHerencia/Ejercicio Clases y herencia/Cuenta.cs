using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio_Clases_y_herencia
{
    internal class Cuenta
    {
        private int numero;
        private String titular;
        private String dni;
        private double saldo;

        public Cuenta() { }
        public Cuenta(int numero, String titular, String dni)
        {
            this.numero = numero;
            this.titular = titular;
            this.dni = dni;
            this.saldo = 0;
        }
        public int getNumero() { return numero; }
        public String getTitular() { return titular; }
        public String getDni() { return dni; }
        public double getSaldo() { return saldo; }
        public void setTitular(String titular) { this.titular = titular; }
        public void setDni(String dni) { this.dni = dni; }

        public virtual bool Reintegro(double importe)
        {
            if (importe > 0 && importe <= this.saldo)
            {
                this.saldo -= importe;
                return true;
            }
            else { return false; }
        }

        public bool Ingreso(double importe)
        {
            if (importe > 0)
            {
                this.saldo += importe;
                return true;
            }
            else { return false; }
        }

        public override string ToString()
        {
            return "Cuenta: " + this.numero +
                "\nTitular: " + this.titular +
                "\nDNI: " + this.dni +
                "\nSaldo: " + this.saldo;
        }

        public bool Transferencia(Cuenta cuentaDestino, double importe)
        {
            if (Reintegro(importe))
            {
                if (cuentaDestino.Ingreso(importe)) { return true; } else { return false; } 
            }
            else { return false; }
        }
    }
}
