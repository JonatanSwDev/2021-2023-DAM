namespace Jonatan_Gomez_Examen1ev
{
    partial class CajeroAutomatico
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
            this.butCrearLista = new System.Windows.Forms.Button();
            this.txtNumTar = new System.Windows.Forms.TextBox();
            this.lblTarjeta = new System.Windows.Forms.Label();
            this.butNumTar = new System.Windows.Forms.Button();
            this.lblClave = new System.Windows.Forms.Label();
            this.txtClaveTar = new System.Windows.Forms.TextBox();
            this.butClaveTar = new System.Windows.Forms.Button();
            this.butDesbloquear = new System.Windows.Forms.Button();
            this.butTarDes = new System.Windows.Forms.Button();
            this.lblTarDes = new System.Windows.Forms.Label();
            this.txtTarDes = new System.Windows.Forms.TextBox();
            this.lblNombre = new System.Windows.Forms.Label();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.gpboxDesbloquear = new System.Windows.Forms.GroupBox();
            this.butCerrar = new System.Windows.Forms.Button();
            this.gpboxDesbloquear.SuspendLayout();
            this.SuspendLayout();
            // 
            // butCrearLista
            // 
            this.butCrearLista.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.butCrearLista.Location = new System.Drawing.Point(286, 208);
            this.butCrearLista.Name = "butCrearLista";
            this.butCrearLista.Size = new System.Drawing.Size(175, 37);
            this.butCrearLista.TabIndex = 0;
            this.butCrearLista.Text = "Crear Lista";
            this.butCrearLista.UseVisualStyleBackColor = true;
            this.butCrearLista.Click += new System.EventHandler(this.butCrearLista_Click);
            // 
            // txtNumTar
            // 
            this.txtNumTar.Location = new System.Drawing.Point(331, 85);
            this.txtNumTar.Name = "txtNumTar";
            this.txtNumTar.Size = new System.Drawing.Size(100, 20);
            this.txtNumTar.TabIndex = 1;
            // 
            // lblTarjeta
            // 
            this.lblTarjeta.AutoSize = true;
            this.lblTarjeta.Location = new System.Drawing.Point(234, 88);
            this.lblTarjeta.Name = "lblTarjeta";
            this.lblTarjeta.Size = new System.Drawing.Size(69, 13);
            this.lblTarjeta.TabIndex = 2;
            this.lblTarjeta.Text = "Nº de tarjeta:";
            // 
            // butNumTar
            // 
            this.butNumTar.Location = new System.Drawing.Point(464, 83);
            this.butNumTar.Name = "butNumTar";
            this.butNumTar.Size = new System.Drawing.Size(75, 23);
            this.butNumTar.TabIndex = 3;
            this.butNumTar.Text = "Aceptar";
            this.butNumTar.UseVisualStyleBackColor = true;
            this.butNumTar.Click += new System.EventHandler(this.butNumTar_Click);
            // 
            // lblClave
            // 
            this.lblClave.AutoSize = true;
            this.lblClave.Location = new System.Drawing.Point(234, 141);
            this.lblClave.Name = "lblClave";
            this.lblClave.Size = new System.Drawing.Size(87, 13);
            this.lblClave.TabIndex = 4;
            this.lblClave.Text = "Clave  de tarjeta:";
            // 
            // txtClaveTar
            // 
            this.txtClaveTar.Location = new System.Drawing.Point(331, 138);
            this.txtClaveTar.Name = "txtClaveTar";
            this.txtClaveTar.Size = new System.Drawing.Size(100, 20);
            this.txtClaveTar.TabIndex = 5;
            // 
            // butClaveTar
            // 
            this.butClaveTar.Location = new System.Drawing.Point(464, 136);
            this.butClaveTar.Name = "butClaveTar";
            this.butClaveTar.Size = new System.Drawing.Size(75, 23);
            this.butClaveTar.TabIndex = 6;
            this.butClaveTar.Text = "Aceptar";
            this.butClaveTar.UseVisualStyleBackColor = true;
            this.butClaveTar.Click += new System.EventHandler(this.butClaveTar_Click);
            // 
            // butDesbloquear
            // 
            this.butDesbloquear.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.butDesbloquear.Location = new System.Drawing.Point(173, 12);
            this.butDesbloquear.Name = "butDesbloquear";
            this.butDesbloquear.Size = new System.Drawing.Size(175, 37);
            this.butDesbloquear.TabIndex = 7;
            this.butDesbloquear.Text = "Desbloquear";
            this.butDesbloquear.UseVisualStyleBackColor = true;
            this.butDesbloquear.Click += new System.EventHandler(this.butDesbloquear_Click);
            // 
            // butTarDes
            // 
            this.butTarDes.Location = new System.Drawing.Point(258, 25);
            this.butTarDes.Name = "butTarDes";
            this.butTarDes.Size = new System.Drawing.Size(75, 23);
            this.butTarDes.TabIndex = 10;
            this.butTarDes.Text = "Aceptar";
            this.butTarDes.UseVisualStyleBackColor = true;
            this.butTarDes.Click += new System.EventHandler(this.butTarDes_Click);
            // 
            // lblTarDes
            // 
            this.lblTarDes.AutoSize = true;
            this.lblTarDes.Location = new System.Drawing.Point(28, 30);
            this.lblTarDes.Name = "lblTarDes";
            this.lblTarDes.Size = new System.Drawing.Size(69, 13);
            this.lblTarDes.TabIndex = 9;
            this.lblTarDes.Text = "Nº de tarjeta:";
            // 
            // txtTarDes
            // 
            this.txtTarDes.Location = new System.Drawing.Point(125, 27);
            this.txtTarDes.Name = "txtTarDes";
            this.txtTarDes.Size = new System.Drawing.Size(100, 20);
            this.txtTarDes.TabIndex = 8;
            // 
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Location = new System.Drawing.Point(28, 82);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(69, 13);
            this.lblNombre.TabIndex = 12;
            this.lblNombre.Text = "Nº de tarjeta:";
            // 
            // txtNombre
            // 
            this.txtNombre.Location = new System.Drawing.Point(125, 79);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(100, 20);
            this.txtNombre.TabIndex = 11;
            // 
            // gpboxDesbloquear
            // 
            this.gpboxDesbloquear.Controls.Add(this.lblNombre);
            this.gpboxDesbloquear.Controls.Add(this.txtNombre);
            this.gpboxDesbloquear.Controls.Add(this.butTarDes);
            this.gpboxDesbloquear.Controls.Add(this.lblTarDes);
            this.gpboxDesbloquear.Controls.Add(this.txtTarDes);
            this.gpboxDesbloquear.Location = new System.Drawing.Point(206, 290);
            this.gpboxDesbloquear.Name = "gpboxDesbloquear";
            this.gpboxDesbloquear.Size = new System.Drawing.Size(357, 123);
            this.gpboxDesbloquear.TabIndex = 13;
            this.gpboxDesbloquear.TabStop = false;
            this.gpboxDesbloquear.Text = "Desbloquear";
            // 
            // butCerrar
            // 
            this.butCerrar.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.butCerrar.Location = new System.Drawing.Point(425, 12);
            this.butCerrar.Name = "butCerrar";
            this.butCerrar.Size = new System.Drawing.Size(175, 37);
            this.butCerrar.TabIndex = 14;
            this.butCerrar.Text = "Cerrar";
            this.butCerrar.UseVisualStyleBackColor = true;
            this.butCerrar.Click += new System.EventHandler(this.butCerrar_Click);
            // 
            // CajeroAutomatico
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.butCerrar);
            this.Controls.Add(this.gpboxDesbloquear);
            this.Controls.Add(this.butDesbloquear);
            this.Controls.Add(this.butClaveTar);
            this.Controls.Add(this.txtClaveTar);
            this.Controls.Add(this.lblClave);
            this.Controls.Add(this.butNumTar);
            this.Controls.Add(this.lblTarjeta);
            this.Controls.Add(this.txtNumTar);
            this.Controls.Add(this.butCrearLista);
            this.Name = "CajeroAutomatico";
            this.Text = "Cajero Automatico";
            this.gpboxDesbloquear.ResumeLayout(false);
            this.gpboxDesbloquear.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button butCrearLista;
        private System.Windows.Forms.TextBox txtNumTar;
        private System.Windows.Forms.Label lblTarjeta;
        private System.Windows.Forms.Button butNumTar;
        private System.Windows.Forms.Label lblClave;
        private System.Windows.Forms.TextBox txtClaveTar;
        private System.Windows.Forms.Button butClaveTar;
        private System.Windows.Forms.Button butDesbloquear;
        private System.Windows.Forms.Button butTarDes;
        private System.Windows.Forms.Label lblTarDes;
        private System.Windows.Forms.TextBox txtTarDes;
        private System.Windows.Forms.Label lblNombre;
        private System.Windows.Forms.TextBox txtNombre;
        private System.Windows.Forms.GroupBox gpboxDesbloquear;
        private System.Windows.Forms.Button butCerrar;
    }
}

