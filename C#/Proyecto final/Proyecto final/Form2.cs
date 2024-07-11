using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.OleDb;

namespace Proyecto_final
{
    public partial class Form2 : Form
    {
        OleDbConnection con = new OleDbConnection(@"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\Users\oscar\Downloads\Proyecto final\PF.mdb");
        public Form2()
        {
            InitializeComponent();
        }

        private void btn_Guardar_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand("Insert into Producto(nombre_producto, precio_producto, cantidad)values('" + txt_nombre.Text + "'," + txt_precio.Text + ", "+ txt_cantidad.Text +")", con);
            cmd.ExecuteNonQuery();
            con.Close();
            fillgrid();
        }
        void fillgrid()
        {
            con.Open();
            OleDbDataAdapter da = new OleDbDataAdapter("Select *from Producto order by cod_producto", con);
            DataTable dt = new DataTable();
            da.Fill(dt);
            DTGV.DataSource = dt;
            con.Close();
        }

        private void btn_Eliminar_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand("Delete from Producto where cod_producto="+txt_codp.Text+"", con);
            cmd.ExecuteNonQuery();
            con.Close();
            fillgrid();
        }

        private void btn_Actualizar_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand("Update Producto set nombre_producto='"+txt_nombre.Text+"', precio_producto="+txt_precio.Text+", cantidad="+txt_cantidad.Text+" where cod_producto="+txt_codp.Text+"", con);
            cmd.ExecuteNonQuery();
            con.Close();
            fillgrid();
        }

        private void btn_limpiar_Click(object sender, EventArgs e)
        {
            txt_nombre.Text = "";
            txt_precio.Text = "";
            txt_cantidad.Text = "";
            txt_codp.Text = "";
            DTGV.DataSource = "";
            txt_codp.Focus();
        }

        private void btn_Mostrar_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbDataAdapter da = new OleDbDataAdapter("Select *from Producto order by cod_producto", con);
            DataTable dt = new DataTable();
            da.Fill(dt);
            DTGV.DataSource = dt;
            con.Close();
        }

        private void btn_Ordenes_Click(object sender, EventArgs e)
        {
            this.Hide();
            new Form1().ShowDialog();
        }

        private void btn_Facturacion_Click(object sender, EventArgs e)
        {
            this.Hide();
            new Form3().ShowDialog();
        }
    }
}
