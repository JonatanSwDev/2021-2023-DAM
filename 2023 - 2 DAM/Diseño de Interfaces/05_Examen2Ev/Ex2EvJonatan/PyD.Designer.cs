namespace Ex2EvJonatan
{
    partial class PyD
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
            this.txtidPedido = new System.Windows.Forms.TextBox();
            this.txtCCliente = new System.Windows.Forms.TextBox();
            this.txtCantidad = new System.Windows.Forms.TextBox();
            this.txtFecha = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.cbCodProd = new System.Windows.Forms.ComboBox();
            this.label5 = new System.Windows.Forms.Label();
            this.butCancelar = new System.Windows.Forms.Button();
            this.butGuardar = new System.Windows.Forms.Button();
            this.grDetalles = new System.Windows.Forms.GroupBox();
            this.butPlus = new System.Windows.Forms.Button();
            this.butTerminar = new System.Windows.Forms.Button();
            this.grAlta = new System.Windows.Forms.GroupBox();
            this.grDetalles.SuspendLayout();
            this.grAlta.SuspendLayout();
            this.SuspendLayout();
            // 
            // txtidPedido
            // 
            this.txtidPedido.Enabled = false;
            this.txtidPedido.Location = new System.Drawing.Point(152, 31);
            this.txtidPedido.Name = "txtidPedido";
            this.txtidPedido.Size = new System.Drawing.Size(100, 20);
            this.txtidPedido.TabIndex = 0;
            // 
            // txtCCliente
            // 
            this.txtCCliente.Location = new System.Drawing.Point(152, 79);
            this.txtCCliente.Name = "txtCCliente";
            this.txtCCliente.Size = new System.Drawing.Size(100, 20);
            this.txtCCliente.TabIndex = 1;
            // 
            // txtCantidad
            // 
            this.txtCantidad.Location = new System.Drawing.Point(204, 83);
            this.txtCantidad.Name = "txtCantidad";
            this.txtCantidad.Size = new System.Drawing.Size(121, 20);
            this.txtCantidad.TabIndex = 3;
            // 
            // txtFecha
            // 
            this.txtFecha.Enabled = false;
            this.txtFecha.Location = new System.Drawing.Point(476, 31);
            this.txtFecha.Name = "txtFecha";
            this.txtFecha.Size = new System.Drawing.Size(100, 20);
            this.txtFecha.TabIndex = 4;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(26, 31);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(78, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "Codigo pedido:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(26, 79);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(77, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "Codigo cliente:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(36, 37);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(88, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Codigo producto:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(36, 83);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(97, 13);
            this.label4.TabIndex = 8;
            this.label4.Text = "Cantidad producto:";
            // 
            // cbCodProd
            // 
            this.cbCodProd.FormattingEnabled = true;
            this.cbCodProd.Location = new System.Drawing.Point(204, 37);
            this.cbCodProd.Name = "cbCodProd";
            this.cbCodProd.Size = new System.Drawing.Size(121, 21);
            this.cbCodProd.TabIndex = 9;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(363, 31);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(40, 13);
            this.label5.TabIndex = 10;
            this.label5.Text = "Fecha:";
            // 
            // butCancelar
            // 
            this.butCancelar.Location = new System.Drawing.Point(366, 77);
            this.butCancelar.Name = "butCancelar";
            this.butCancelar.Size = new System.Drawing.Size(75, 23);
            this.butCancelar.TabIndex = 11;
            this.butCancelar.Text = "Cancelar";
            this.butCancelar.UseVisualStyleBackColor = true;
            this.butCancelar.Click += new System.EventHandler(this.butCancelar_Click);
            // 
            // butGuardar
            // 
            this.butGuardar.Location = new System.Drawing.Point(501, 77);
            this.butGuardar.Name = "butGuardar";
            this.butGuardar.Size = new System.Drawing.Size(75, 23);
            this.butGuardar.TabIndex = 12;
            this.butGuardar.Text = "Guardar";
            this.butGuardar.UseVisualStyleBackColor = true;
            this.butGuardar.Click += new System.EventHandler(this.butGuardar_Click);
            // 
            // grDetalles
            // 
            this.grDetalles.Controls.Add(this.butTerminar);
            this.grDetalles.Controls.Add(this.butPlus);
            this.grDetalles.Controls.Add(this.cbCodProd);
            this.grDetalles.Controls.Add(this.label4);
            this.grDetalles.Controls.Add(this.label3);
            this.grDetalles.Controls.Add(this.txtCantidad);
            this.grDetalles.Enabled = false;
            this.grDetalles.Location = new System.Drawing.Point(116, 193);
            this.grDetalles.Name = "grDetalles";
            this.grDetalles.Size = new System.Drawing.Size(486, 159);
            this.grDetalles.TabIndex = 13;
            this.grDetalles.TabStop = false;
            this.grDetalles.Text = "Detalles Pedido";
            // 
            // butPlus
            // 
            this.butPlus.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.butPlus.Location = new System.Drawing.Point(373, 51);
            this.butPlus.Name = "butPlus";
            this.butPlus.Size = new System.Drawing.Size(53, 45);
            this.butPlus.TabIndex = 14;
            this.butPlus.Text = "+";
            this.butPlus.UseVisualStyleBackColor = true;
            this.butPlus.Click += new System.EventHandler(this.butPlus_Click);
            // 
            // butTerminar
            // 
            this.butTerminar.Location = new System.Drawing.Point(351, 117);
            this.butTerminar.Name = "butTerminar";
            this.butTerminar.Size = new System.Drawing.Size(75, 23);
            this.butTerminar.TabIndex = 14;
            this.butTerminar.Text = "Terminar";
            this.butTerminar.UseVisualStyleBackColor = true;
            this.butTerminar.Click += new System.EventHandler(this.butTerminar_Click);
            // 
            // grAlta
            // 
            this.grAlta.Controls.Add(this.butGuardar);
            this.grAlta.Controls.Add(this.butCancelar);
            this.grAlta.Controls.Add(this.label5);
            this.grAlta.Controls.Add(this.label2);
            this.grAlta.Controls.Add(this.label1);
            this.grAlta.Controls.Add(this.txtFecha);
            this.grAlta.Controls.Add(this.txtCCliente);
            this.grAlta.Controls.Add(this.txtidPedido);
            this.grAlta.Location = new System.Drawing.Point(53, 16);
            this.grAlta.Name = "grAlta";
            this.grAlta.Size = new System.Drawing.Size(595, 144);
            this.grAlta.TabIndex = 14;
            this.grAlta.TabStop = false;
            this.grAlta.Text = "groupBox2";
            // 
            // PyD
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(717, 389);
            this.Controls.Add(this.grAlta);
            this.Controls.Add(this.grDetalles);
            this.Name = "PyD";
            this.Text = "Pedidos y Detalles";
            this.grDetalles.ResumeLayout(false);
            this.grDetalles.PerformLayout();
            this.grAlta.ResumeLayout(false);
            this.grAlta.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TextBox txtidPedido;
        private System.Windows.Forms.TextBox txtCCliente;
        private System.Windows.Forms.TextBox txtCantidad;
        private System.Windows.Forms.TextBox txtFecha;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox cbCodProd;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button butCancelar;
        private System.Windows.Forms.Button butGuardar;
        private System.Windows.Forms.GroupBox grDetalles;
        private System.Windows.Forms.Button butPlus;
        private System.Windows.Forms.Button butTerminar;
        private System.Windows.Forms.GroupBox grAlta;
    }
}