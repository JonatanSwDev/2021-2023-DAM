using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex2EvJonatan
{
    public class Detalle_Ped
    {
        private int codPediDetal;
        private int codProDetal;
        private int cantidadDetal;

        public Detalle_Ped(int codPediDetal, int codProDetal, int cantidadDetal)
        {
            this.codPediDetal = codPediDetal;
            this.codProDetal = codProDetal;
            this.cantidadDetal = cantidadDetal;
        }

        public int CodPediDetal { get => codPediDetal; set => codPediDetal = value; }
        public int CodProDetal { get => codProDetal; set => codProDetal = value; }
        public int CantidadDetal { get => cantidadDetal; set => cantidadDetal = value; }
    }
}
