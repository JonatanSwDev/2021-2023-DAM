using System;


namespace Ex2EvJonatan
{
    public class Pedido
    {
        private int codPedi;
        private int codCliPedi;
        private DateTime fechaPedi;
        

        public Pedido(int codPedi, int codCliPedi, DateTime fechaPedi)
        {
            this.codPedi = codPedi;
            this.codCliPedi = codCliPedi;
            this.fechaPedi = fechaPedi;
        }

        public int CodPedi { get => codPedi; set => codPedi = value; }
        public int CodCliPedi { get => codCliPedi; set => codCliPedi = value; }
        public DateTime FechaPedi { get => fechaPedi; set => fechaPedi = value; }
    }
}
