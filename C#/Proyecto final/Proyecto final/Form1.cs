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
    public partial class Form1 : Form
    {
        OleDbConnection con = new OleDbConnection(@"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\Users\oscar\Downloads\Proyecto final\PF.mdb");
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btn_Guardar_Click(object sender, EventArgs e)
        {
            int id_cliente;
            int id_equipo;
            int id_orden;
            DateTime hoy = DateTime.Now;

            con.Open();
            OleDbCommand cmd = new OleDbCommand("Insert into Cliente(nombre_cliente, telefono_cliente)values('"+txt_Nombre.Text+"',"+txt_Telefono.Text+")", con);
            cmd.ExecuteNonQuery();
            OleDbCommand cmd1 = new OleDbCommand("SELECT @@IDENTITY", con);
            id_cliente = (int)cmd1.ExecuteScalar();
            Console.WriteLine("ID_CLIENTE: "+id_cliente);
            con.Close();
            fillgrid();

            con.Open();
            OleDbCommand cm = new OleDbCommand("Insert into Equipo(descripcion_equipo, modelo_equipo)values('" + txt_Equipo.Text + "','" + txt_Modelo.Text + "')", con);
            cm.ExecuteNonQuery();
            OleDbCommand cmd2 = new OleDbCommand("SELECT @@IDENTITY", con);
            id_equipo = (int)cmd2.ExecuteScalar();
            Console.WriteLine("ID_EQUIPO: " + id_equipo);
            con.Close();
            fillgrid();

            con.Open();
            OleDbCommand md = new OleDbCommand("Insert into Orden(cod_cliente, cod_empleado, fecha_ingreso,  observacion)values(" + id_cliente + "," + 1 + ", '"+hoy.ToString()+"', '"+txt_Observacion.Text+"')", con);
            md.ExecuteNonQuery();
            OleDbCommand cmd3 = new OleDbCommand("SELECT @@IDENTITY", con);
            id_orden = (int)cmd3.ExecuteScalar();
            Console.WriteLine("ID_ORDEN: " + id_orden);
            con.Close();
            fillgrid();

            con.Open();
            OleDbCommand cd = new OleDbCommand("Insert into Tipo_mantenimiento(cod_equipo, cod_orden, tipo_mantenimiento, precio, descripcion)values("+id_equipo+ "," + id_orden + ", '" + txt_Tipoman.Text + "'," + txt_Precio.Text + ",'"+txt_Mantenimiento.Text+"')", con);
            cd.ExecuteNonQuery();
            con.Close();
            fillgrid();

            MessageBox.Show("Orden generada: " + id_orden);
        }

        void fillgrid()
        {
            con.Open();
            OleDbDataAdapter da = new OleDbDataAdapter("SELECT od.cod_orden, cl.nombre_cliente, od.fecha_ingreso, od.observacion " 
                + "FROM Orden AS od INNER JOIN Cliente AS cl " 
                + "ON od.cod_cliente = cl.cod_cliente "
                + "ORDER BY od.cod_orden", con);
            DataTable dt = new DataTable();
            da.Fill(dt);
            DTGV.DataSource = dt;
            con.Close();
        }

        private void btn_Inventario_Click(object sender, EventArgs e)
        {
            this.Hide();
            new Form2().ShowDialog();
        }

        private void btn_Facturacion_Click(object sender, EventArgs e)
        {
            this.Hide();
            new Form3().ShowDialog();
        }

        private void btn_Limpiar_Click(object sender, EventArgs e)
        {
            txt_Equipo.Text = "";
            txt_Mantenimiento.Text = "";
            txt_Modelo.Text = "";
            txt_Nombre.Text = "";
            txt_Observacion.Text = "";
            txt_Precio.Text = "";
            txt_Telefono.Text = "";
            txt_Tipoman.Text = "";
            DTGV.DataSource = "";
            txt_Nombre.Focus();
        }
    }
}
