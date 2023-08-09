namespace Jonatan_ejercicioClases
{
    partial class Menu
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.menuToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuAlta = new System.Windows.Forms.ToolStripMenuItem();
            this.menuConsulta = new System.Windows.Forms.ToolStripMenuItem();
            this.porCodigoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.porNombreToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuListar = new System.Windows.Forms.ToolStripMenuItem();
            this.menuListarArticulos = new System.Windows.Forms.ToolStripMenuItem();
            this.menuArticulosMinimos = new System.Windows.Forms.ToolStripMenuItem();
            this.menuArticulosCategoria = new System.Windows.Forms.ToolStripMenuItem();
            this.menuPedido = new System.Windows.Forms.ToolStripMenuItem();
            this.lblArticulo = new System.Windows.Forms.Label();
            this.lblCantidad = new System.Windows.Forms.Label();
            this.txtCodigoArt = new System.Windows.Forms.TextBox();
            this.txtCantidad = new System.Windows.Forms.TextBox();
            this.butPedir = new System.Windows.Forms.Button();
            this.butListar = new System.Windows.Forms.Button();
            this.rtxtBox = new System.Windows.Forms.RichTextBox();
            this.butConsultar = new System.Windows.Forms.Button();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.lblInfoCodigo = new System.Windows.Forms.Label();
            this.lblNombreIn = new System.Windows.Forms.Label();
            this.lblCategoria = new System.Windows.Forms.Label();
            this.lblPrecio = new System.Windows.Forms.Label();
            this.lblExistencias = new System.Windows.Forms.Label();
            this.comboBox2 = new System.Windows.Forms.ComboBox();
            this.txtInfoCodigo = new System.Windows.Forms.TextBox();
            this.txtNombreIn = new System.Windows.Forms.TextBox();
            this.txtPrecio = new System.Windows.Forms.TextBox();
            this.txtExistencias = new System.Windows.Forms.TextBox();
            this.butAlta = new System.Windows.Forms.Button();
            this.gpAlta = new System.Windows.Forms.GroupBox();
            this.menuStrip1.SuspendLayout();
            this.gpAlta.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(1133, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "Alta";
            // 
            // menuToolStripMenuItem
            // 
            this.menuToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuAlta,
            this.menuConsulta,
            this.menuListar,
            this.menuPedido});
            this.menuToolStripMenuItem.Name = "menuToolStripMenuItem";
            this.menuToolStripMenuItem.Size = new System.Drawing.Size(50, 20);
            this.menuToolStripMenuItem.Text = "Menu";
            // 
            // menuAlta
            // 
            this.menuAlta.Name = "menuAlta";
            this.menuAlta.Size = new System.Drawing.Size(180, 22);
            this.menuAlta.Text = "Alta";
            this.menuAlta.Click += new System.EventHandler(this.menuAlta_Click);
            // 
            // menuConsulta
            // 
            this.menuConsulta.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.porCodigoToolStripMenuItem,
            this.porNombreToolStripMenuItem});
            this.menuConsulta.Name = "menuConsulta";
            this.menuConsulta.Size = new System.Drawing.Size(180, 22);
            this.menuConsulta.Text = "Consulta";
            // 
            // porCodigoToolStripMenuItem
            // 
            this.porCodigoToolStripMenuItem.Name = "porCodigoToolStripMenuItem";
            this.porCodigoToolStripMenuItem.Size = new System.Drawing.Size(139, 22);
            this.porCodigoToolStripMenuItem.Text = "Por Codigo";
            this.porCodigoToolStripMenuItem.Click += new System.EventHandler(this.porCodigoToolStripMenuItem_Click);
            // 
            // porNombreToolStripMenuItem
            // 
            this.porNombreToolStripMenuItem.Name = "porNombreToolStripMenuItem";
            this.porNombreToolStripMenuItem.Size = new System.Drawing.Size(139, 22);
            this.porNombreToolStripMenuItem.Text = "Por Nombre";
            this.porNombreToolStripMenuItem.Click += new System.EventHandler(this.porNombreToolStripMenuItem_Click);
            // 
            // menuListar
            // 
            this.menuListar.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuListarArticulos,
            this.menuArticulosMinimos,
            this.menuArticulosCategoria});
            this.menuListar.Name = "menuListar";
            this.menuListar.Size = new System.Drawing.Size(180, 22);
            this.menuListar.Text = "Listar";
            // 
            // menuListarArticulos
            // 
            this.menuListarArticulos.Name = "menuListarArticulos";
            this.menuListarArticulos.Size = new System.Drawing.Size(194, 22);
            this.menuListarArticulos.Text = "Todos los articulos";
            this.menuListarArticulos.Click += new System.EventHandler(this.menuListarArticulos_Click);
            // 
            // menuArticulosMinimos
            // 
            this.menuArticulosMinimos.Name = "menuArticulosMinimos";
            this.menuArticulosMinimos.Size = new System.Drawing.Size(194, 22);
            this.menuArticulosMinimos.Text = "Articulos en minimos";
            this.menuArticulosMinimos.Click += new System.EventHandler(this.menuArticulosMinimos_Click);
            // 
            // menuArticulosCategoria
            // 
            this.menuArticulosCategoria.Name = "menuArticulosCategoria";
            this.menuArticulosCategoria.Size = new System.Drawing.Size(194, 22);
            this.menuArticulosCategoria.Text = "Articulos por categoria";
            this.menuArticulosCategoria.Click += new System.EventHandler(this.menuArticulosCategoria_Click);
            // 
            // menuPedido
            // 
            this.menuPedido.Name = "menuPedido";
            this.menuPedido.Size = new System.Drawing.Size(180, 22);
            this.menuPedido.Text = "Hacer pedido";
            this.menuPedido.Click += new System.EventHandler(this.menuPedido_Click);
            // 
            // lblArticulo
            // 
            this.lblArticulo.AutoSize = true;
            this.lblArticulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblArticulo.Location = new System.Drawing.Point(12, 41);
            this.lblArticulo.Name = "lblArticulo";
            this.lblArticulo.Size = new System.Drawing.Size(152, 20);
            this.lblArticulo.TabIndex = 1;
            this.lblArticulo.Text = "Condigo del articulo:";
            this.lblArticulo.Visible = false;
            // 
            // lblCantidad
            // 
            this.lblCantidad.AutoSize = true;
            this.lblCantidad.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCantidad.Location = new System.Drawing.Point(12, 76);
            this.lblCantidad.Name = "lblCantidad";
            this.lblCantidad.Size = new System.Drawing.Size(77, 20);
            this.lblCantidad.TabIndex = 2;
            this.lblCantidad.Text = "Cantidad:";
            this.lblCantidad.Visible = false;
            // 
            // txtCodigoArt
            // 
            this.txtCodigoArt.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCodigoArt.Location = new System.Drawing.Point(170, 38);
            this.txtCodigoArt.Name = "txtCodigoArt";
            this.txtCodigoArt.Size = new System.Drawing.Size(100, 26);
            this.txtCodigoArt.TabIndex = 3;
            this.txtCodigoArt.Visible = false;
            // 
            // txtCantidad
            // 
            this.txtCantidad.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCantidad.Location = new System.Drawing.Point(170, 73);
            this.txtCantidad.Name = "txtCantidad";
            this.txtCantidad.Size = new System.Drawing.Size(100, 26);
            this.txtCantidad.TabIndex = 4;
            this.txtCantidad.Visible = false;
            // 
            // butPedir
            // 
            this.butPedir.Location = new System.Drawing.Point(286, 38);
            this.butPedir.Name = "butPedir";
            this.butPedir.Size = new System.Drawing.Size(107, 61);
            this.butPedir.TabIndex = 5;
            this.butPedir.Text = "Realizar pedido";
            this.butPedir.UseVisualStyleBackColor = true;
            this.butPedir.Visible = false;
            this.butPedir.Click += new System.EventHandler(this.butPedir_Click);
            // 
            // butListar
            // 
            this.butListar.Location = new System.Drawing.Point(170, 41);
            this.butListar.Name = "butListar";
            this.butListar.Size = new System.Drawing.Size(84, 26);
            this.butListar.TabIndex = 8;
            this.butListar.Text = "Listar";
            this.butListar.UseVisualStyleBackColor = true;
            this.butListar.Visible = false;
            this.butListar.Click += new System.EventHandler(this.butListar_Click);
            // 
            // rtxtBox
            // 
            this.rtxtBox.Location = new System.Drawing.Point(321, 122);
            this.rtxtBox.Name = "rtxtBox";
            this.rtxtBox.Size = new System.Drawing.Size(800, 312);
            this.rtxtBox.TabIndex = 10;
            this.rtxtBox.Text = "";
            this.rtxtBox.Visible = false;
            // 
            // butConsultar
            // 
            this.butConsultar.Location = new System.Drawing.Point(286, 38);
            this.butConsultar.Name = "butConsultar";
            this.butConsultar.Size = new System.Drawing.Size(97, 23);
            this.butConsultar.TabIndex = 12;
            this.butConsultar.Text = "Consultar";
            this.butConsultar.UseVisualStyleBackColor = true;
            this.butConsultar.Click += new System.EventHandler(this.butConsultar_Click);
            // 
            // comboBox1
            // 
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Items.AddRange(new object[] {
            "Informática",
            "Imagen",
            "Telefonía",
            "Sonido"});
            this.comboBox1.Location = new System.Drawing.Point(43, 41);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(121, 21);
            this.comboBox1.TabIndex = 11;
            this.comboBox1.Text = "Categoria";
            // 
            // lblInfoCodigo
            // 
            this.lblInfoCodigo.AutoSize = true;
            this.lblInfoCodigo.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblInfoCodigo.Location = new System.Drawing.Point(23, 35);
            this.lblInfoCodigo.Name = "lblInfoCodigo";
            this.lblInfoCodigo.Size = new System.Drawing.Size(152, 20);
            this.lblInfoCodigo.TabIndex = 13;
            this.lblInfoCodigo.Text = "Condigo del articulo:";
            this.lblInfoCodigo.Visible = false;
            // 
            // lblNombreIn
            // 
            this.lblNombreIn.AutoSize = true;
            this.lblNombreIn.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNombreIn.Location = new System.Drawing.Point(23, 87);
            this.lblNombreIn.Name = "lblNombreIn";
            this.lblNombreIn.Size = new System.Drawing.Size(69, 20);
            this.lblNombreIn.TabIndex = 14;
            this.lblNombreIn.Text = "Nombre:";
            this.lblNombreIn.Visible = false;
            // 
            // lblCategoria
            // 
            this.lblCategoria.AutoSize = true;
            this.lblCategoria.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCategoria.Location = new System.Drawing.Point(23, 142);
            this.lblCategoria.Name = "lblCategoria";
            this.lblCategoria.Size = new System.Drawing.Size(82, 20);
            this.lblCategoria.TabIndex = 15;
            this.lblCategoria.Text = "Categoria:";
            this.lblCategoria.Visible = false;
            // 
            // lblPrecio
            // 
            this.lblPrecio.AutoSize = true;
            this.lblPrecio.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPrecio.Location = new System.Drawing.Point(23, 194);
            this.lblPrecio.Name = "lblPrecio";
            this.lblPrecio.Size = new System.Drawing.Size(57, 20);
            this.lblPrecio.TabIndex = 16;
            this.lblPrecio.Text = "Precio:";
            this.lblPrecio.Visible = false;
            // 
            // lblExistencias
            // 
            this.lblExistencias.AutoSize = true;
            this.lblExistencias.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblExistencias.Location = new System.Drawing.Point(23, 244);
            this.lblExistencias.Name = "lblExistencias";
            this.lblExistencias.Size = new System.Drawing.Size(93, 20);
            this.lblExistencias.TabIndex = 17;
            this.lblExistencias.Text = "Existencias:";
            this.lblExistencias.Visible = false;
            // 
            // comboBox2
            // 
            this.comboBox2.FormattingEnabled = true;
            this.comboBox2.Items.AddRange(new object[] {
            "Informática",
            "Imagen",
            "Telefonía",
            "Sonido"});
            this.comboBox2.Location = new System.Drawing.Point(204, 141);
            this.comboBox2.Name = "comboBox2";
            this.comboBox2.Size = new System.Drawing.Size(121, 21);
            this.comboBox2.TabIndex = 18;
            // 
            // txtInfoCodigo
            // 
            this.txtInfoCodigo.Enabled = false;
            this.txtInfoCodigo.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtInfoCodigo.Location = new System.Drawing.Point(204, 32);
            this.txtInfoCodigo.Name = "txtInfoCodigo";
            this.txtInfoCodigo.Size = new System.Drawing.Size(100, 26);
            this.txtInfoCodigo.TabIndex = 19;
            this.txtInfoCodigo.Visible = false;
            // 
            // txtNombreIn
            // 
            this.txtNombreIn.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtNombreIn.Location = new System.Drawing.Point(204, 84);
            this.txtNombreIn.Name = "txtNombreIn";
            this.txtNombreIn.Size = new System.Drawing.Size(100, 26);
            this.txtNombreIn.TabIndex = 20;
            this.txtNombreIn.Visible = false;
            // 
            // txtPrecio
            // 
            this.txtPrecio.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtPrecio.Location = new System.Drawing.Point(204, 191);
            this.txtPrecio.Name = "txtPrecio";
            this.txtPrecio.Size = new System.Drawing.Size(100, 26);
            this.txtPrecio.TabIndex = 21;
            this.txtPrecio.Visible = false;
            // 
            // txtExistencias
            // 
            this.txtExistencias.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtExistencias.Location = new System.Drawing.Point(204, 241);
            this.txtExistencias.Name = "txtExistencias";
            this.txtExistencias.Size = new System.Drawing.Size(100, 26);
            this.txtExistencias.TabIndex = 22;
            this.txtExistencias.Visible = false;
            // 
            // butAlta
            // 
            this.butAlta.Location = new System.Drawing.Point(356, 120);
            this.butAlta.Name = "butAlta";
            this.butAlta.Size = new System.Drawing.Size(107, 61);
            this.butAlta.TabIndex = 23;
            this.butAlta.Text = "Dar de alta";
            this.butAlta.UseVisualStyleBackColor = true;
            this.butAlta.Visible = false;
            this.butAlta.Click += new System.EventHandler(this.butAlta_Click);
            // 
            // gpAlta
            // 
            this.gpAlta.Controls.Add(this.txtExistencias);
            this.gpAlta.Controls.Add(this.butAlta);
            this.gpAlta.Controls.Add(this.txtPrecio);
            this.gpAlta.Controls.Add(this.txtNombreIn);
            this.gpAlta.Controls.Add(this.txtInfoCodigo);
            this.gpAlta.Controls.Add(this.comboBox2);
            this.gpAlta.Controls.Add(this.lblExistencias);
            this.gpAlta.Controls.Add(this.lblPrecio);
            this.gpAlta.Controls.Add(this.lblCategoria);
            this.gpAlta.Controls.Add(this.lblNombreIn);
            this.gpAlta.Controls.Add(this.lblInfoCodigo);
            this.gpAlta.Location = new System.Drawing.Point(79, 132);
            this.gpAlta.Name = "gpAlta";
            this.gpAlta.Size = new System.Drawing.Size(480, 279);
            this.gpAlta.TabIndex = 24;
            this.gpAlta.TabStop = false;
            this.gpAlta.Text = "Alta";
            // 
            // Menu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1133, 476);
            this.Controls.Add(this.gpAlta);
            this.Controls.Add(this.butConsultar);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.rtxtBox);
            this.Controls.Add(this.butListar);
            this.Controls.Add(this.butPedir);
            this.Controls.Add(this.txtCantidad);
            this.Controls.Add(this.txtCodigoArt);
            this.Controls.Add(this.lblCantidad);
            this.Controls.Add(this.lblArticulo);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Menu";
            this.Text = "Articulos";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.gpAlta.ResumeLayout(false);
            this.gpAlta.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem menuToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem menuAlta;
        private System.Windows.Forms.ToolStripMenuItem menuConsulta;
        private System.Windows.Forms.ToolStripMenuItem menuListar;
        private System.Windows.Forms.ToolStripMenuItem menuListarArticulos;
        private System.Windows.Forms.ToolStripMenuItem menuArticulosMinimos;
        private System.Windows.Forms.ToolStripMenuItem menuArticulosCategoria;
        private System.Windows.Forms.ToolStripMenuItem menuPedido;
        private System.Windows.Forms.Label lblArticulo;
        private System.Windows.Forms.Label lblCantidad;
        private System.Windows.Forms.TextBox txtCodigoArt;
        private System.Windows.Forms.TextBox txtCantidad;
        private System.Windows.Forms.Button butPedir;
        private System.Windows.Forms.Button butListar;
        private System.Windows.Forms.RichTextBox rtxtBox;
        private System.Windows.Forms.ToolStripMenuItem porCodigoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem porNombreToolStripMenuItem;
        private System.Windows.Forms.Button butConsultar;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.Label lblInfoCodigo;
        private System.Windows.Forms.Label lblNombreIn;
        private System.Windows.Forms.Label lblCategoria;
        private System.Windows.Forms.Label lblPrecio;
        private System.Windows.Forms.Label lblExistencias;
        private System.Windows.Forms.ComboBox comboBox2;
        private System.Windows.Forms.TextBox txtInfoCodigo;
        private System.Windows.Forms.TextBox txtNombreIn;
        private System.Windows.Forms.TextBox txtPrecio;
        private System.Windows.Forms.TextBox txtExistencias;
        private System.Windows.Forms.Button butAlta;
        private System.Windows.Forms.GroupBox gpAlta;
    }
}

