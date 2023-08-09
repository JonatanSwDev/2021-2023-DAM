using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;
using System.Threading.Tasks;

namespace Jonatan_Gomez_Examen1ev
{
    public class ClaseTarjeta
    {
        private string numTarjeta;
        private string nombre;
        private bool bloqueo;
        private int claveTarjeta;
        private double saldo;

        public ClaseTarjeta() { }
        public ClaseTarjeta(string numTarjeta, string nombre, int claveTarjeta)
        {
            this.numTarjeta = numTarjeta;
            this.nombre = nombre;
            this.bloqueo = false;
            if (claveTarjeta >= 0000 && claveTarjeta <= 9999)
            {
                this.claveTarjeta = claveTarjeta;
            }
            this.saldo = 0;
        }

        public string GetNumTarjeta()
        {
            return this.numTarjeta;
        }
        public string GetNombre()
        {
            return this.nombre;
        }
        public bool EstaBloqueada()
        {
            return this.bloqueo;
        }
        public int GetClaveTarjeta()
        {
            return this.claveTarjeta;
        }
        public double GetSaldo()
        {
            return this.saldo;
        }

        public void SetNumTarjeta(string numTarjeta)
        {
            this.numTarjeta = numTarjeta;
        }
        public void SetNombre(string nombre)
        {
            this.nombre = nombre;
        }
        public void SetBloqueo(bool bloqueo)
        {
            this.bloqueo = bloqueo;
        }

        public bool Ingresar(double importe)
        {
            if (importe > 0)
            {
                this.saldo += importe;
                return true;
            }
            return false;
        }

        public bool Reintegro(double importe)
        {
            if (importe <= this.saldo)
            {
                this.saldo -= importe;
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
