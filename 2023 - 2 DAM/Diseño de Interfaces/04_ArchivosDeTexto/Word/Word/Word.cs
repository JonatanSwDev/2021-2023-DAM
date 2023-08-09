using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.TaskbarClock;

namespace Word
{
    public partial class Word : Form
    {
        public Word()
        {
            InitializeComponent();
        }

        private void nuevoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FrmHijo soyHijo = new FrmHijo();
            soyHijo.MdiParent = this;
            soyHijo.Text = "Documento - " + this.MdiChildren.Length.ToString();
            soyHijo.Show();
        }

        private bool CheckHijos()
        {
            if (this.MdiChildren.Length > 0)
            { 
                return true;
            }else { return false; }

        }

        private void Word_Load(object sender, EventArgs e)
        {

        }

        private void guardarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (!CheckHijos()) { return; }
            FrmHijo formActivo = (FrmHijo)ActiveMdiChild;
            Guardar(formActivo);

        }

        //He hecho los deberes y he establecido el acceso como private protected
        //Dando acceso al metodo solamente a los objetos declarados dentro del metodo
        //Por lo que solo tendrá acceso a este método el formulario hijo
        internal void Guardar(FrmHijo formActivo)
        {
            if (formActivo.getRuta() != null)
            {
                File.WriteAllText(formActivo.getRuta(), formActivo.getTexto().Text);
                MessageBox.Show(Path.GetFileName(formActivo.getRuta()) + " guardado con exito");
                formActivo.Guardado();
            }
            else
            {
                GuardarComo(formActivo);
            }
        }

        private void Ventana_Options_Click(object sender, EventArgs e)
        {
            string caso = ((ToolStripMenuItem)sender).Name;
            switch (caso)
            {
                case "cascada":
                    this.LayoutMdi(System.Windows.Forms.MdiLayout.Cascade);
                    break;
                case "vertical":
                    this.LayoutMdi(System.Windows.Forms.MdiLayout.TileVertical);
                    break;
                case "horizontal":
                    this.LayoutMdi(System.Windows.Forms.MdiLayout.TileHorizontal);
                    break;
            }
        }

        private void guardarcomoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (!CheckHijos()) { return; }
            
                FrmHijo formActivo = (FrmHijo)ActiveMdiChild;
                GuardarComo(formActivo);
        }

        private void GuardarComo(FrmHijo formActivo)
        {
            
            //Creamos el dialogo tipico de un guardar como, que no es ni mas ni menos que una instancia de la clase
            //SaveFileDialog
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();
            saveFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            saveFileDialog1.FilterIndex = 1;
            saveFileDialog1.RestoreDirectory = true;

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                File.WriteAllText(saveFileDialog1.FileName, formActivo.getTexto().Text);
                //Usando el metodo de Path.getFileName obtenemos solamente el nombre del archivo
                MessageBox.Show(Path.GetFileName(saveFileDialog1.FileName) + " guardado con exito");
                //Llamada al metodo que controla los cambios de un guardar como
                formActivo.GuardadoComo(saveFileDialog1.FileName);
                
            }
        }
        private void abrirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //Una buena practica para utilizar cadenas de uso por utilidades
            //Es abriendo usos con la palabra reservada using
            using (OpenFileDialog openFileDialog = new OpenFileDialog())
            {
                openFileDialog.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
                openFileDialog.FilterIndex = 1;
                openFileDialog.RestoreDirectory = true;

                if (openFileDialog.ShowDialog() == DialogResult.OK)
                {
                    //Comprobamos que el archivo no este abierto en un formulario hijo
                    for (int i = 0; i < this.MdiChildren.Count(); i++)
                    {
                        FrmHijo hijo = (FrmHijo)this.MdiChildren[i];
                        if (hijo.getRuta() != null)
                        {
                            if (hijo.getRuta().Equals(openFileDialog.FileName))
                            {
                                MessageBox.Show(openFileDialog.FileName + "\nYa se encuentra abierto");
                                return;
                            }
                        }
                    }
                    //Llamada al constructor añadiendo el Path
                    FrmHijo soyHijo = new FrmHijo(openFileDialog.FileName);
                    soyHijo.MdiParent = this;
                    soyHijo.Text = Path.GetFileName(openFileDialog.FileName); //Nombre del fichero
                    soyHijo.Show();

                    //Abrimos el fichero para poder leer el contenido
                    var fileStream = openFileDialog.OpenFile();
                    
                    //Lectura del contenido usando StramRrader
                    using (StreamReader reader = new StreamReader(fileStream))
                    {
                        //Añadir texto al formulario Hijo
                        soyHijo.getTexto().Text = reader.ReadToEnd();
                        //Establecemos cambios a false, ya que el evento de cambios lo habrá puesto a true
                        soyHijo.Guardado();
                    }
                }
            }
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Editar_Options_Click(object sender, EventArgs e)
        {
            if(!CheckHijos()){ return; }

            FrmHijo formActivo = (FrmHijo)ActiveMdiChild;
            RichTextBox texto = formActivo.getTexto();
            //Guardamos el nombre del caso
            string caso = ((ToolStripMenuItem)sender).Name;
            switch (caso)
            {
                case "deshacer":
                    texto.Undo();
                    break;
                case "rehacer":
                    texto.Redo();
                    break;
                case "cortar":
                    texto.Cut();
                    break;
                case "copiar":
                    texto.Copy();
                    break;
                case "pegar":
                    texto.Paste();
                    break;
                case "seleccionar":
                    texto.SelectAll();
                    break;
            }
        }
        private void Formato_Options_Click(object sender, EventArgs e)
        {
            if (!CheckHijos()) { return; }

            FrmHijo formActivo = (FrmHijo)ActiveMdiChild;
            RichTextBox texto = formActivo.getTexto();
            //Guardamos el nombre del caso
            string caso = ((ToolStripMenuItem)sender).Name;
            if (caso.Contains("color"))
            {
                ColorDialog MyDialog = new ColorDialog();
                // Habilitamos los colores personalizados, para darle juego
                MyDialog.AllowFullOpen = true;
                // Habilitamos la ayuda al color, aunque no hace mucha falta, es bien sencillo
                MyDialog.ShowHelp = true;
                switch (caso)
                {
                    case "colortext":
                        // Colocamos el color por defecto del dialogo al color actual
                        MyDialog.Color = texto.ForeColor;

                        // Actualizamos el color de la letra
                        if (MyDialog.ShowDialog() == DialogResult.OK)
                            texto.ForeColor = MyDialog.Color;
                        break;

                    case "colorbgtext":
                        // Colocamos el color por defecto del dialogo al color actual
                        MyDialog.Color = texto.BackColor;

                        // Actualizamos el color de fondo
                        if (MyDialog.ShowDialog() == DialogResult.OK)
                            texto.BackColor = MyDialog.Color;
                        texto.Redo();
                        break;

                    case "colorbgform":
                        // Colocamos el color por defecto del dialogo al color actual
                        MyDialog.Color = formActivo.BackColor;

                        // Actualizamos el color de la letra
                        if (MyDialog.ShowDialog() == DialogResult.OK)
                            formActivo.BackColor = MyDialog.Color;
                        texto.Cut();
                        break;
                }
            } else if (caso.Equals("formatotext"))
            {
                FontDialog MyDialog = new FontDialog();
                MyDialog.ShowHelp = true;

                //Voy a permitir tambien el color dentro del dialogo
                MyDialog.ShowColor = true;
                MyDialog.Color = texto.ForeColor;

                if (MyDialog.ShowDialog() != DialogResult.Cancel)
                {
                    texto.Font = MyDialog.Font;
                    texto.ForeColor = MyDialog.Color;
                }
            }
        }
    }
}
