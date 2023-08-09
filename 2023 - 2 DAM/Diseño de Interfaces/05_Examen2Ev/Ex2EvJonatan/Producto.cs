using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex2EvJonatan
{
    public class Producto
    {
        private int codPro;
        private string nomPro;
        private double precioPro;
        private int stockPro;
        

        public Producto(int codPro, string nomPro, double precioPro, int stockPro)
        {
            this.codPro = codPro;
            this.nomPro = nomPro;
            this.precioPro = precioPro;
            this.stockPro = stockPro;
        }

        public int CodPro { get => codPro; set => codPro = value; }
        public string NomPro { get => nomPro; set => nomPro = value; }
        public double PrecioPro { get => precioPro; set => precioPro = value; }
        public int StockPro { get => stockPro; set => stockPro = value; }
    }
}
