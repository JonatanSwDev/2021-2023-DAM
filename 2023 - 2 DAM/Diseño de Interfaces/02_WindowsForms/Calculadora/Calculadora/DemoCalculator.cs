using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;
using static System.Net.Mime.MediaTypeNames;

namespace Calculadora
{
    public partial class DemoCalculator : Form
    {
        string operacionActual = "";
        string numero1 = null;
        string numero2 = null;
        string ultimaop = null;
        List<String> historial = new List<string>();
        double resultado;
        string op = null;
        bool coma = false;
        string ultimoNum = null;


        public DemoCalculator()
        {
            InitializeComponent();
        }

        private void DemoCalculator_KeyDown(object sender, KeyEventArgs e)
        {
            int key = e.KeyValue;
            if (key >= 48 && key <= 57)
            {
                CrearNumero((key - 48).ToString());
            }
            else if (key >= 96 && key <= 105)
            {
                CrearNumero((key - 96).ToString());
            }
            else if (key == 110 || key == 190 || key == 188)
            {
                ColocarDecimal();
            }
            else
            {
                switch (e.KeyCode)
                {
                    case Keys.Divide:
                        CrearOp("/");
                        break;
                    case Keys.Multiply:
                        CrearOp("*");
                        break;
                    case Keys.OemMinus:
                        CrearOp("-");
                        break;
                    case Keys.Oemplus:
                        CrearOp("+");
                        break;
                    case Keys.Subtract:
                        CrearOp("-");
                        break;
                    case Keys.Add:
                        CrearOp("+");
                        break;
                    case Keys.Enter:
                        EjecutarIgual();
                        break;
                    case Keys.Escape:
                        EjecutarClear();
                        break;
                }
            }
        }

        private void butNumbers_Click(object sender, EventArgs e)
        {
            CrearNumero(((Button)sender).Text);
        }

        private void CrearNumero(string text)
        {
            if (op == null)
            {
                numero1 += text;
                operacionActual += text;
                textBox1.Text = operacionActual;
                coma = false;
            } else
            {
                numero2 += text;
                operacionActual += text;
                textBox1.Text = operacionActual;
            }
        }

        private void butOps_Click(object sender, EventArgs e)
        { 
            CrearOp(((Button)sender).Text);
        }

        private void CrearOp(string text)
        {
            if (op == null)
            {
                op = text;
                operacionActual += text;
                textBox1.Text = operacionActual;
            }
            else if (op != null && numero2 == null)
            {
                op = text;
                //-1?
                operacionActual = operacionActual.Substring(0, operacionActual.Length - 1) + op;
                textBox1.Text = operacionActual;

            } else if (op != null && numero2 != null)
            {
                if (Resolver())
                {
                    Resolucion();
                    op = text;
                    operacionActual = numero1 + text;
                    textBox1.Text = operacionActual;
                }   
            }
        }

        private bool Resolver()
        {
            switch (op)
            {
                case "+":
                    resultado = Double.Parse(numero1) + Double.Parse(numero2);
                    return true;
                    break;
                case "-":
                    resultado = Double.Parse(numero1) - Double.Parse(numero2);
                    return true;
                    break;
                case "*":
                    resultado = Double.Parse(numero1) * Double.Parse(numero2);
                    return true;
                    break;
                case "/":
                    resultado = Double.Parse(numero1) / Double.Parse(numero2);
                    return true;
                    break;
                default:
                    return false;
                    break;
            }
            
        }

        private void Resolucion()
        {
            string history = numero1 + op + numero2 + "=" + resultado.ToString() + "\n";
            historial.Add(history);
            ultimaop = op;
            ultimoNum = numero2;
            numero2 = null;
            numero1 = Math.Round(resultado, 2).ToString();
            op = null;
            coma = false;
            LlenarListView();
        }

        private void LlenarListView()
        {
            listView1.Items.Clear();
            foreach (string linea in historial)
            {
                ListViewItem lista = new ListViewItem(linea);
                listView1.Items.Add(lista);
            }
        }

        private void decimalButton_Click(object sender, EventArgs e)
        {
            ColocarDecimal();
        }

        private void ColocarDecimal()
        {
            if (!coma && op == null)
            {
                if (numero1 == null)
                {
                    numero1 = "0,";
                    coma = true;
                    operacionActual += numero1;
                }
                else
                {
                    numero1 += ",";
                    coma = true;
                    operacionActual += ",";
                }
            }
            else if (!coma && op != null)
            {
                if (numero2 == null)
                {
                    numero2 = "0,";
                    coma = true;
                    operacionActual += "0,";
                }
                else
                {
                    numero2 += ",";
                    coma = true;
                    operacionActual += ",";
                }
            }
            textBox1.Text = operacionActual;
        }

        private void equalsButton_Click(object sender, EventArgs e)
        {
            EjecutarIgual();
        }

        private void EjecutarIgual()
        {
            if (numero2 != null)
            {
                if (Resolver())
                {
                    Resolucion();
                    operacionActual = numero1;
                    textBox1.Text = operacionActual;
                }
            }
            else if (numero2 == null && op == null && ultimaop != null && ultimoNum != null)
            {
                op = ultimaop;
                numero2 = ultimoNum;
                if (Resolver())
                {
                    Resolucion();
                    operacionActual = numero1;
                    textBox1.Text = operacionActual;
                }
            }
        }

        private void changeSignButton_Click(object sender, EventArgs e)
        {
            if (op == null)
            {
                if (Double.Parse(numero1) < 0)
                {
                    numero1 = numero1.Substring(1,numero1.Length -1);
                } else
                {
                    numero1 = "-" + numero1;
                }
                operacionActual = numero1;
            } else if (op != null && numero2 != null)
            {
                if (Double.Parse(numero2) < 0)
                {
                    numero2 = numero2.Substring(1, numero2.Length -1);
                }
                else
                {
                    numero2 = "-" + numero2;
                }
                operacionActual = numero1 + op + numero2;
            }
            textBox1.Text = operacionActual;
        }

        private void clearButton_Click(object sender, EventArgs e)
        {
            EjecutarClear();
        }

        private void EjecutarClear()
        {
            operacionActual = "";
            numero1 = null;
            numero2 = null;
            op = null;
            coma = false;
            textBox1.Clear();
        }
    }
}
