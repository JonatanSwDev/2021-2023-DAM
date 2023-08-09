namespace Jonatan_Gomez_Examen1ev
{
    partial class Operaciones
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.operacionesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ingresoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.reintegroToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem2 = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem3 = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem4 = new System.Windows.Forms.ToolStripMenuItem();
            this.lblImporte = new System.Windows.Forms.Label();
            this.txtIngreso = new System.Windows.Forms.TextBox();
            this.butIngresar = new System.Windows.Forms.Button();
            this.gpboxIngresar = new System.Windows.Forms.GroupBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtImporteRe = new System.Windows.Forms.TextBox();
            this.butRetirar = new System.Windows.Forms.Button();
            this.gpboxRetirar = new System.Windows.Forms.GroupBox();
            this.rtxtConsulta = new System.Windows.Forms.RichTextBox();
            this.menuStrip1.SuspendLayout();
            this.gpboxIngresar.SuspendLayout();
            this.gpboxRetirar.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.operacionesToolStripMenuItem,
            this.toolStripMenuItem1,
            this.toolStripMenuItem4});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // operacionesToolStripMenuItem
            // 
            this.operacionesToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.ingresoToolStripMenuItem,
            this.reintegroToolStripMenuItem});
            this.operacionesToolStripMenuItem.Name = "operacionesToolStripMenuItem";
            this.operacionesToolStripMenuItem.Size = new System.Drawing.Size(85, 20);
            this.operacionesToolStripMenuItem.Text = "Operaciones";
            // 
            // ingresoToolStripMenuItem
            // 
            this.ingresoToolStripMenuItem.Name = "ingresoToolStripMenuItem";
            this.ingresoToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.ingresoToolStripMenuItem.Text = "Ingreso";
            this.ingresoToolStripMenuItem.Click += new System.EventHandler(this.ingresoToolStripMenuItem_Click);
            // 
            // reintegroToolStripMenuItem
            // 
            this.reintegroToolStripMenuItem.Name = "reintegroToolStripMenuItem";
            this.reintegroToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.reintegroToolStripMenuItem.Text = "Reintegro";
            this.reintegroToolStripMenuItem.Click += new System.EventHandler(this.reintegroToolStripMenuItem_Click);
            // 
            // toolStripMenuItem1
            // 
            this.toolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem2,
            this.toolStripMenuItem3});
            this.toolStripMenuItem1.Name = "toolStripMenuItem1";
            this.toolStripMenuItem1.Size = new System.Drawing.Size(71, 20);
            this.toolStripMenuItem1.Text = "Consultas";
            // 
            // toolStripMenuItem2
            // 
            this.toolStripMenuItem2.Name = "toolStripMenuItem2";
            this.toolStripMenuItem2.Size = new System.Drawing.Size(180, 22);
            this.toolStripMenuItem2.Text = "Saldo";
            this.toolStripMenuItem2.Click += new System.EventHandler(this.toolStripMenuItem2_Click);
            // 
            // toolStripMenuItem3
            // 
            this.toolStripMenuItem3.Name = "toolStripMenuItem3";
            this.toolStripMenuItem3.Size = new System.Drawing.Size(180, 22);
            this.toolStripMenuItem3.Text = "Movimientos";
            this.toolStripMenuItem3.Click += new System.EventHandler(this.toolStripMenuItem3_Click);
            // 
            // toolStripMenuItem4
            // 
            this.toolStripMenuItem4.Name = "toolStripMenuItem4";
            this.toolStripMenuItem4.Size = new System.Drawing.Size(41, 20);
            this.toolStripMenuItem4.Text = "Salir";
            this.toolStripMenuItem4.Click += new System.EventHandler(this.toolStripMenuItem4_Click);
            // 
            // lblImporte
            // 
            this.lblImporte.AutoSize = true;
            this.lblImporte.Location = new System.Drawing.Point(12, 23);
            this.lblImporte.Name = "lblImporte";
            this.lblImporte.Size = new System.Drawing.Size(45, 13);
            this.lblImporte.TabIndex = 1;
            this.lblImporte.Text = "Importe:";
            // 
            // txtIngreso
            // 
            this.txtIngreso.Location = new System.Drawing.Point(63, 20);
            this.txtIngreso.Name = "txtIngreso";
            this.txtIngreso.Size = new System.Drawing.Size(100, 20);
            this.txtIngreso.TabIndex = 2;
            // 
            // butIngresar
            // 
            this.butIngresar.Location = new System.Drawing.Point(184, 18);
            this.butIngresar.Name = "butIngresar";
            this.butIngresar.Size = new System.Drawing.Size(75, 23);
            this.butIngresar.TabIndex = 3;
            this.butIngresar.Text = "Ingresar";
            this.butIngresar.UseVisualStyleBackColor = true;
            this.butIngresar.Click += new System.EventHandler(this.butIngresar_Click);
            // 
            // gpboxIngresar
            // 
            this.gpboxIngresar.Controls.Add(this.butIngresar);
            this.gpboxIngresar.Controls.Add(this.txtIngreso);
            this.gpboxIngresar.Controls.Add(this.lblImporte);
            this.gpboxIngresar.Location = new System.Drawing.Point(72, 39);
            this.gpboxIngresar.Name = "gpboxIngresar";
            this.gpboxIngresar.Size = new System.Drawing.Size(281, 61);
            this.gpboxIngresar.TabIndex = 4;
            this.gpboxIngresar.TabStop = false;
            this.gpboxIngresar.Text = "Ingresar";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 23);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(45, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Importe:";
            // 
            // txtImporteRe
            // 
            this.txtImporteRe.Location = new System.Drawing.Point(63, 20);
            this.txtImporteRe.Name = "txtImporteRe";
            this.txtImporteRe.Size = new System.Drawing.Size(100, 20);
            this.txtImporteRe.TabIndex = 2;
            // 
            // butRetirar
            // 
            this.butRetirar.Location = new System.Drawing.Point(184, 18);
            this.butRetirar.Name = "butRetirar";
            this.butRetirar.Size = new System.Drawing.Size(75, 23);
            this.butRetirar.TabIndex = 3;
            this.butRetirar.Text = "Retirar";
            this.butRetirar.UseVisualStyleBackColor = true;
            this.butRetirar.Click += new System.EventHandler(this.butRetirar_Click);
            // 
            // gpboxRetirar
            // 
            this.gpboxRetirar.Controls.Add(this.butRetirar);
            this.gpboxRetirar.Controls.Add(this.txtImporteRe);
            this.gpboxRetirar.Controls.Add(this.label1);
            this.gpboxRetirar.Location = new System.Drawing.Point(405, 39);
            this.gpboxRetirar.Name = "gpboxRetirar";
            this.gpboxRetirar.Size = new System.Drawing.Size(281, 61);
            this.gpboxRetirar.TabIndex = 5;
            this.gpboxRetirar.TabStop = false;
            this.gpboxRetirar.Text = "Retirar";
            // 
            // rtxtConsulta
            // 
            this.rtxtConsulta.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rtxtConsulta.Location = new System.Drawing.Point(32, 123);
            this.rtxtConsulta.Name = "rtxtConsulta";
            this.rtxtConsulta.Size = new System.Drawing.Size(735, 279);
            this.rtxtConsulta.TabIndex = 6;
            this.rtxtConsulta.Text = "";
            // 
            // Operaciones
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.rtxtConsulta);
            this.Controls.Add(this.gpboxRetirar);
            this.Controls.Add(this.gpboxIngresar);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Operaciones";
            this.Text = "Form1";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.gpboxIngresar.ResumeLayout(false);
            this.gpboxIngresar.PerformLayout();
            this.gpboxRetirar.ResumeLayout(false);
            this.gpboxRetirar.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem operacionesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ingresoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem reintegroToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem2;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem3;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem4;
        private System.Windows.Forms.Label lblImporte;
        private System.Windows.Forms.TextBox txtIngreso;
        private System.Windows.Forms.Button butIngresar;
        private System.Windows.Forms.GroupBox gpboxIngresar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtImporteRe;
        private System.Windows.Forms.Button butRetirar;
        private System.Windows.Forms.GroupBox gpboxRetirar;
        private System.Windows.Forms.RichTextBox rtxtConsulta;
    }
}