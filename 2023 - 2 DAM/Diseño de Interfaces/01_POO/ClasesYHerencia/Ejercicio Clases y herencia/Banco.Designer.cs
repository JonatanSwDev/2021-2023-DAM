namespace Ejercicio_Clases_y_herencia
{
    partial class Banco
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
            this.operacionesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuAlta = new System.Windows.Forms.ToolStripMenuItem();
            this.consultarCuentaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuConsultaNumero = new System.Windows.Forms.ToolStripMenuItem();
            this.menuConsultaDNI = new System.Windows.Forms.ToolStripMenuItem();
            this.menuIngreso = new System.Windows.Forms.ToolStripMenuItem();
            this.menuReintegro = new System.Windows.Forms.ToolStripMenuItem();
            this.menuTransferencia = new System.Windows.Forms.ToolStripMenuItem();
            this.lblCuentaCons = new System.Windows.Forms.Label();
            this.txtCuentaCons = new System.Windows.Forms.TextBox();
            this.butConsultar = new System.Windows.Forms.Button();
            this.rtxtConsultar = new System.Windows.Forms.RichTextBox();
            this.gpboxConsultar = new System.Windows.Forms.GroupBox();
            this.gpboxInRe = new System.Windows.Forms.GroupBox();
            this.txtCantidadInRe = new System.Windows.Forms.TextBox();
            this.lblCantidadInRe = new System.Windows.Forms.Label();
            this.butInRe = new System.Windows.Forms.Button();
            this.txtCuentaInRe = new System.Windows.Forms.TextBox();
            this.lblCuentaInRe = new System.Windows.Forms.Label();
            this.lblCurntaOr = new System.Windows.Forms.Label();
            this.lblCuentaDe = new System.Windows.Forms.Label();
            this.lblCantidadTr = new System.Windows.Forms.Label();
            this.txtCuentaOr = new System.Windows.Forms.TextBox();
            this.txtCuentaDe = new System.Windows.Forms.TextBox();
            this.txtCantidadTr = new System.Windows.Forms.TextBox();
            this.butTransferir = new System.Windows.Forms.Button();
            this.gpboxTransferir = new System.Windows.Forms.GroupBox();
            this.lblCuentaAlta = new System.Windows.Forms.Label();
            this.lblTitularAlta = new System.Windows.Forms.Label();
            this.lblDniAlta = new System.Windows.Forms.Label();
            this.txtCuentaAlta = new System.Windows.Forms.TextBox();
            this.txtTitularAlta = new System.Windows.Forms.TextBox();
            this.txtDniAlta = new System.Windows.Forms.TextBox();
            this.butAlta = new System.Windows.Forms.Button();
            this.gpboxAlta = new System.Windows.Forms.GroupBox();
            this.rbutonEmpresa = new System.Windows.Forms.RadioButton();
            this.rbutCuenta = new System.Windows.Forms.RadioButton();
            this.menuStrip1.SuspendLayout();
            this.gpboxConsultar.SuspendLayout();
            this.gpboxInRe.SuspendLayout();
            this.gpboxTransferir.SuspendLayout();
            this.gpboxAlta.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.operacionesToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(913, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // operacionesToolStripMenuItem
            // 
            this.operacionesToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuAlta,
            this.consultarCuentaToolStripMenuItem,
            this.menuIngreso,
            this.menuReintegro,
            this.menuTransferencia});
            this.operacionesToolStripMenuItem.Name = "operacionesToolStripMenuItem";
            this.operacionesToolStripMenuItem.Size = new System.Drawing.Size(85, 20);
            this.operacionesToolStripMenuItem.Text = "Operaciones";
            // 
            // menuAlta
            // 
            this.menuAlta.Name = "menuAlta";
            this.menuAlta.Size = new System.Drawing.Size(180, 22);
            this.menuAlta.Text = "Alta";
            this.menuAlta.Click += new System.EventHandler(this.menuAlta_Click);
            // 
            // consultarCuentaToolStripMenuItem
            // 
            this.consultarCuentaToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuConsultaNumero,
            this.menuConsultaDNI});
            this.consultarCuentaToolStripMenuItem.Name = "consultarCuentaToolStripMenuItem";
            this.consultarCuentaToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.consultarCuentaToolStripMenuItem.Text = "Consultar cuenta";
            // 
            // menuConsultaNumero
            // 
            this.menuConsultaNumero.Name = "menuConsultaNumero";
            this.menuConsultaNumero.Size = new System.Drawing.Size(192, 22);
            this.menuConsultaNumero.Text = "Por numero de cuenta";
            this.menuConsultaNumero.Click += new System.EventHandler(this.menuConsultaNumero_Click);
            // 
            // menuConsultaDNI
            // 
            this.menuConsultaDNI.Name = "menuConsultaDNI";
            this.menuConsultaDNI.Size = new System.Drawing.Size(192, 22);
            this.menuConsultaDNI.Text = "Por DNI";
            this.menuConsultaDNI.Click += new System.EventHandler(this.menuConsultaDNI_Click);
            // 
            // menuIngreso
            // 
            this.menuIngreso.Name = "menuIngreso";
            this.menuIngreso.Size = new System.Drawing.Size(180, 22);
            this.menuIngreso.Text = "Ingreso a cuenta";
            this.menuIngreso.Click += new System.EventHandler(this.menuIngreso_Click);
            // 
            // menuReintegro
            // 
            this.menuReintegro.Name = "menuReintegro";
            this.menuReintegro.Size = new System.Drawing.Size(180, 22);
            this.menuReintegro.Text = "Reintegro de cuenta";
            this.menuReintegro.Click += new System.EventHandler(this.menuReintegro_Click);
            // 
            // menuTransferencia
            // 
            this.menuTransferencia.Name = "menuTransferencia";
            this.menuTransferencia.Size = new System.Drawing.Size(180, 22);
            this.menuTransferencia.Text = "Transferencia";
            this.menuTransferencia.Click += new System.EventHandler(this.menuTransferencia_Click);
            // 
            // lblCuentaCons
            // 
            this.lblCuentaCons.AutoSize = true;
            this.lblCuentaCons.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCuentaCons.Location = new System.Drawing.Point(24, 24);
            this.lblCuentaCons.Name = "lblCuentaCons";
            this.lblCuentaCons.Size = new System.Drawing.Size(69, 20);
            this.lblCuentaCons.TabIndex = 1;
            this.lblCuentaCons.Text = "Cuenta: ";
            // 
            // txtCuentaCons
            // 
            this.txtCuentaCons.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCuentaCons.Location = new System.Drawing.Point(99, 21);
            this.txtCuentaCons.Name = "txtCuentaCons";
            this.txtCuentaCons.Size = new System.Drawing.Size(100, 26);
            this.txtCuentaCons.TabIndex = 2;
            // 
            // butConsultar
            // 
            this.butConsultar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.butConsultar.Location = new System.Drawing.Point(225, 19);
            this.butConsultar.Name = "butConsultar";
            this.butConsultar.Size = new System.Drawing.Size(90, 30);
            this.butConsultar.TabIndex = 3;
            this.butConsultar.Text = "Consultar";
            this.butConsultar.UseVisualStyleBackColor = true;
            this.butConsultar.Click += new System.EventHandler(this.butConsultar_Click);
            // 
            // rtxtConsultar
            // 
            this.rtxtConsultar.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rtxtConsultar.Location = new System.Drawing.Point(28, 68);
            this.rtxtConsultar.Name = "rtxtConsultar";
            this.rtxtConsultar.Size = new System.Drawing.Size(287, 174);
            this.rtxtConsultar.TabIndex = 4;
            this.rtxtConsultar.Text = "";
            // 
            // gpboxConsultar
            // 
            this.gpboxConsultar.Controls.Add(this.rtxtConsultar);
            this.gpboxConsultar.Controls.Add(this.butConsultar);
            this.gpboxConsultar.Controls.Add(this.txtCuentaCons);
            this.gpboxConsultar.Controls.Add(this.lblCuentaCons);
            this.gpboxConsultar.Location = new System.Drawing.Point(22, 27);
            this.gpboxConsultar.Name = "gpboxConsultar";
            this.gpboxConsultar.Size = new System.Drawing.Size(341, 261);
            this.gpboxConsultar.TabIndex = 5;
            this.gpboxConsultar.TabStop = false;
            this.gpboxConsultar.Text = "Consultar";
            // 
            // gpboxInRe
            // 
            this.gpboxInRe.Controls.Add(this.txtCantidadInRe);
            this.gpboxInRe.Controls.Add(this.lblCantidadInRe);
            this.gpboxInRe.Controls.Add(this.butInRe);
            this.gpboxInRe.Controls.Add(this.txtCuentaInRe);
            this.gpboxInRe.Controls.Add(this.lblCuentaInRe);
            this.gpboxInRe.Location = new System.Drawing.Point(22, 27);
            this.gpboxInRe.Name = "gpboxInRe";
            this.gpboxInRe.Size = new System.Drawing.Size(341, 110);
            this.gpboxInRe.TabIndex = 6;
            this.gpboxInRe.TabStop = false;
            this.gpboxInRe.Text = "Ingresar";
            // 
            // txtCantidadInRe
            // 
            this.txtCantidadInRe.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCantidadInRe.Location = new System.Drawing.Point(108, 70);
            this.txtCantidadInRe.Name = "txtCantidadInRe";
            this.txtCantidadInRe.Size = new System.Drawing.Size(100, 26);
            this.txtCantidadInRe.TabIndex = 5;
            // 
            // lblCantidadInRe
            // 
            this.lblCantidadInRe.AutoSize = true;
            this.lblCantidadInRe.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCantidadInRe.Location = new System.Drawing.Point(24, 73);
            this.lblCantidadInRe.Name = "lblCantidadInRe";
            this.lblCantidadInRe.Size = new System.Drawing.Size(77, 20);
            this.lblCantidadInRe.TabIndex = 4;
            this.lblCantidadInRe.Text = "Cantidad:";
            // 
            // butInRe
            // 
            this.butInRe.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.butInRe.Location = new System.Drawing.Point(230, 35);
            this.butInRe.Name = "butInRe";
            this.butInRe.Size = new System.Drawing.Size(90, 49);
            this.butInRe.TabIndex = 3;
            this.butInRe.Text = "Op";
            this.butInRe.UseVisualStyleBackColor = true;
            this.butInRe.Click += new System.EventHandler(this.butInRe_Click);
            // 
            // txtCuentaInRe
            // 
            this.txtCuentaInRe.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCuentaInRe.Location = new System.Drawing.Point(108, 21);
            this.txtCuentaInRe.Name = "txtCuentaInRe";
            this.txtCuentaInRe.Size = new System.Drawing.Size(100, 26);
            this.txtCuentaInRe.TabIndex = 2;
            // 
            // lblCuentaInRe
            // 
            this.lblCuentaInRe.AutoSize = true;
            this.lblCuentaInRe.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCuentaInRe.Location = new System.Drawing.Point(24, 24);
            this.lblCuentaInRe.Name = "lblCuentaInRe";
            this.lblCuentaInRe.Size = new System.Drawing.Size(69, 20);
            this.lblCuentaInRe.TabIndex = 1;
            this.lblCuentaInRe.Text = "Cuenta: ";
            // 
            // lblCurntaOr
            // 
            this.lblCurntaOr.AutoSize = true;
            this.lblCurntaOr.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCurntaOr.Location = new System.Drawing.Point(19, 26);
            this.lblCurntaOr.Name = "lblCurntaOr";
            this.lblCurntaOr.Size = new System.Drawing.Size(116, 20);
            this.lblCurntaOr.TabIndex = 7;
            this.lblCurntaOr.Text = "Cuenta Origen:";
            // 
            // lblCuentaDe
            // 
            this.lblCuentaDe.AutoSize = true;
            this.lblCuentaDe.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCuentaDe.Location = new System.Drawing.Point(266, 26);
            this.lblCuentaDe.Name = "lblCuentaDe";
            this.lblCuentaDe.Size = new System.Drawing.Size(124, 20);
            this.lblCuentaDe.TabIndex = 8;
            this.lblCuentaDe.Text = "Cuenta Destino:";
            // 
            // lblCantidadTr
            // 
            this.lblCantidadTr.AutoSize = true;
            this.lblCantidadTr.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCantidadTr.Location = new System.Drawing.Point(19, 79);
            this.lblCantidadTr.Name = "lblCantidadTr";
            this.lblCantidadTr.Size = new System.Drawing.Size(77, 20);
            this.lblCantidadTr.TabIndex = 9;
            this.lblCantidadTr.Text = "Cantidad:";
            // 
            // txtCuentaOr
            // 
            this.txtCuentaOr.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCuentaOr.Location = new System.Drawing.Point(141, 23);
            this.txtCuentaOr.Name = "txtCuentaOr";
            this.txtCuentaOr.Size = new System.Drawing.Size(100, 26);
            this.txtCuentaOr.TabIndex = 10;
            // 
            // txtCuentaDe
            // 
            this.txtCuentaDe.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCuentaDe.Location = new System.Drawing.Point(396, 26);
            this.txtCuentaDe.Name = "txtCuentaDe";
            this.txtCuentaDe.Size = new System.Drawing.Size(100, 26);
            this.txtCuentaDe.TabIndex = 11;
            // 
            // txtCantidadTr
            // 
            this.txtCantidadTr.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCantidadTr.Location = new System.Drawing.Point(141, 76);
            this.txtCantidadTr.Name = "txtCantidadTr";
            this.txtCantidadTr.Size = new System.Drawing.Size(100, 26);
            this.txtCantidadTr.TabIndex = 12;
            // 
            // butTransferir
            // 
            this.butTransferir.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.butTransferir.Location = new System.Drawing.Point(270, 65);
            this.butTransferir.Name = "butTransferir";
            this.butTransferir.Size = new System.Drawing.Size(120, 37);
            this.butTransferir.TabIndex = 13;
            this.butTransferir.Text = "Transferir";
            this.butTransferir.UseVisualStyleBackColor = true;
            this.butTransferir.Click += new System.EventHandler(this.butTransferir_Click);
            // 
            // gpboxTransferir
            // 
            this.gpboxTransferir.Controls.Add(this.butTransferir);
            this.gpboxTransferir.Controls.Add(this.txtCantidadTr);
            this.gpboxTransferir.Controls.Add(this.txtCuentaDe);
            this.gpboxTransferir.Controls.Add(this.txtCuentaOr);
            this.gpboxTransferir.Controls.Add(this.lblCantidadTr);
            this.gpboxTransferir.Controls.Add(this.lblCuentaDe);
            this.gpboxTransferir.Controls.Add(this.lblCurntaOr);
            this.gpboxTransferir.Location = new System.Drawing.Point(22, 27);
            this.gpboxTransferir.Name = "gpboxTransferir";
            this.gpboxTransferir.Size = new System.Drawing.Size(519, 119);
            this.gpboxTransferir.TabIndex = 14;
            this.gpboxTransferir.TabStop = false;
            this.gpboxTransferir.Text = "Transferir";
            // 
            // lblCuentaAlta
            // 
            this.lblCuentaAlta.AutoSize = true;
            this.lblCuentaAlta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCuentaAlta.Location = new System.Drawing.Point(20, 70);
            this.lblCuentaAlta.Name = "lblCuentaAlta";
            this.lblCuentaAlta.Size = new System.Drawing.Size(144, 20);
            this.lblCuentaAlta.TabIndex = 15;
            this.lblCuentaAlta.Text = "Numero de cuenta:";
            // 
            // lblTitularAlta
            // 
            this.lblTitularAlta.AutoSize = true;
            this.lblTitularAlta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTitularAlta.Location = new System.Drawing.Point(20, 109);
            this.lblTitularAlta.Name = "lblTitularAlta";
            this.lblTitularAlta.Size = new System.Drawing.Size(56, 20);
            this.lblTitularAlta.TabIndex = 16;
            this.lblTitularAlta.Text = "Titular:";
            // 
            // lblDniAlta
            // 
            this.lblDniAlta.AutoSize = true;
            this.lblDniAlta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblDniAlta.Location = new System.Drawing.Point(20, 148);
            this.lblDniAlta.Name = "lblDniAlta";
            this.lblDniAlta.Size = new System.Drawing.Size(41, 20);
            this.lblDniAlta.TabIndex = 17;
            this.lblDniAlta.Text = "DNI:";
            // 
            // txtCuentaAlta
            // 
            this.txtCuentaAlta.Enabled = false;
            this.txtCuentaAlta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCuentaAlta.Location = new System.Drawing.Point(173, 67);
            this.txtCuentaAlta.Name = "txtCuentaAlta";
            this.txtCuentaAlta.Size = new System.Drawing.Size(100, 26);
            this.txtCuentaAlta.TabIndex = 18;
            // 
            // txtTitularAlta
            // 
            this.txtTitularAlta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtTitularAlta.Location = new System.Drawing.Point(173, 106);
            this.txtTitularAlta.Name = "txtTitularAlta";
            this.txtTitularAlta.Size = new System.Drawing.Size(100, 26);
            this.txtTitularAlta.TabIndex = 19;
            // 
            // txtDniAlta
            // 
            this.txtDniAlta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtDniAlta.Location = new System.Drawing.Point(173, 145);
            this.txtDniAlta.Name = "txtDniAlta";
            this.txtDniAlta.Size = new System.Drawing.Size(100, 26);
            this.txtDniAlta.TabIndex = 20;
            // 
            // butAlta
            // 
            this.butAlta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.butAlta.Location = new System.Drawing.Point(307, 101);
            this.butAlta.Name = "butAlta";
            this.butAlta.Size = new System.Drawing.Size(120, 37);
            this.butAlta.TabIndex = 21;
            this.butAlta.Text = "Alta";
            this.butAlta.UseVisualStyleBackColor = true;
            this.butAlta.Click += new System.EventHandler(this.butAlta_Click);
            // 
            // gpboxAlta
            // 
            this.gpboxAlta.Controls.Add(this.rbutonEmpresa);
            this.gpboxAlta.Controls.Add(this.rbutCuenta);
            this.gpboxAlta.Controls.Add(this.butAlta);
            this.gpboxAlta.Controls.Add(this.txtDniAlta);
            this.gpboxAlta.Controls.Add(this.txtTitularAlta);
            this.gpboxAlta.Controls.Add(this.txtCuentaAlta);
            this.gpboxAlta.Controls.Add(this.lblDniAlta);
            this.gpboxAlta.Controls.Add(this.lblTitularAlta);
            this.gpboxAlta.Controls.Add(this.lblCuentaAlta);
            this.gpboxAlta.Location = new System.Drawing.Point(22, 27);
            this.gpboxAlta.Name = "gpboxAlta";
            this.gpboxAlta.Size = new System.Drawing.Size(447, 192);
            this.gpboxAlta.TabIndex = 22;
            this.gpboxAlta.TabStop = false;
            this.gpboxAlta.Text = "Alta de cuenta";
            // 
            // rbutonEmpresa
            // 
            this.rbutonEmpresa.AutoSize = true;
            this.rbutonEmpresa.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rbutonEmpresa.Location = new System.Drawing.Point(280, 28);
            this.rbutonEmpresa.Name = "rbutonEmpresa";
            this.rbutonEmpresa.Size = new System.Drawing.Size(147, 24);
            this.rbutonEmpresa.TabIndex = 23;
            this.rbutonEmpresa.TabStop = true;
            this.rbutonEmpresa.Text = "Cuenta Empresa";
            this.rbutonEmpresa.UseVisualStyleBackColor = true;
            this.rbutonEmpresa.CheckedChanged += new System.EventHandler(this.rbutonEmpresa_CheckedChanged);
            // 
            // rbutCuenta
            // 
            this.rbutCuenta.AutoSize = true;
            this.rbutCuenta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rbutCuenta.Location = new System.Drawing.Point(24, 28);
            this.rbutCuenta.Name = "rbutCuenta";
            this.rbutCuenta.Size = new System.Drawing.Size(133, 24);
            this.rbutCuenta.TabIndex = 22;
            this.rbutCuenta.TabStop = true;
            this.rbutCuenta.Text = "Cuenta Normal";
            this.rbutCuenta.UseVisualStyleBackColor = true;
            this.rbutCuenta.CheckedChanged += new System.EventHandler(this.rbutCuenta_CheckedChanged);
            // 
            // Banco
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(913, 478);
            this.Controls.Add(this.gpboxAlta);
            this.Controls.Add(this.gpboxTransferir);
            this.Controls.Add(this.gpboxInRe);
            this.Controls.Add(this.gpboxConsultar);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Banco";
            this.Text = "Banco";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.gpboxConsultar.ResumeLayout(false);
            this.gpboxConsultar.PerformLayout();
            this.gpboxInRe.ResumeLayout(false);
            this.gpboxInRe.PerformLayout();
            this.gpboxTransferir.ResumeLayout(false);
            this.gpboxTransferir.PerformLayout();
            this.gpboxAlta.ResumeLayout(false);
            this.gpboxAlta.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem operacionesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem menuAlta;
        private System.Windows.Forms.ToolStripMenuItem consultarCuentaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem menuConsultaNumero;
        private System.Windows.Forms.ToolStripMenuItem menuConsultaDNI;
        private System.Windows.Forms.ToolStripMenuItem menuIngreso;
        private System.Windows.Forms.ToolStripMenuItem menuReintegro;
        private System.Windows.Forms.Label lblCuentaCons;
        private System.Windows.Forms.TextBox txtCuentaCons;
        private System.Windows.Forms.Button butConsultar;
        private System.Windows.Forms.RichTextBox rtxtConsultar;
        private System.Windows.Forms.GroupBox gpboxConsultar;
        private System.Windows.Forms.GroupBox gpboxInRe;
        private System.Windows.Forms.Button butInRe;
        private System.Windows.Forms.TextBox txtCuentaInRe;
        private System.Windows.Forms.Label lblCuentaInRe;
        private System.Windows.Forms.TextBox txtCantidadInRe;
        private System.Windows.Forms.Label lblCantidadInRe;
        private System.Windows.Forms.ToolStripMenuItem menuTransferencia;
        private System.Windows.Forms.Label lblCurntaOr;
        private System.Windows.Forms.Label lblCuentaDe;
        private System.Windows.Forms.Label lblCantidadTr;
        private System.Windows.Forms.TextBox txtCuentaOr;
        private System.Windows.Forms.TextBox txtCuentaDe;
        private System.Windows.Forms.TextBox txtCantidadTr;
        private System.Windows.Forms.Button butTransferir;
        private System.Windows.Forms.GroupBox gpboxTransferir;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblCuentaAlta;
        private System.Windows.Forms.Label lblTitularAlta;
        private System.Windows.Forms.Label lblDniAlta;
        private System.Windows.Forms.TextBox txtCuentaAlta;
        private System.Windows.Forms.TextBox txtTitularAlta;
        private System.Windows.Forms.TextBox txtDniAlta;
        private System.Windows.Forms.Button butAlta;
        private System.Windows.Forms.GroupBox gpboxAlta;
        private System.Windows.Forms.RadioButton rbutonEmpresa;
        private System.Windows.Forms.RadioButton rbutCuenta;
    }
}

