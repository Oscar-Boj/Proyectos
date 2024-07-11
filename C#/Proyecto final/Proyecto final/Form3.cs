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
using iTextSharp.text;
using iTextSharp.text.pdf;
using System.IO;
using iTextSharp.tool.xml;

namespace Proyecto_final
{
    public partial class Form3 : Form
    {
        DataTable rs = new DataTable();

        OleDbConnection con = new OleDbConnection(@"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\Users\oscar\Downloads\Proyecto final\PF.mdb");
        public Form3()
        {
            InitializeComponent();
        }

        private void btn_Mostrar_Click(object sender, EventArgs e)
        {
            int codigo_orden = Int16.Parse(txt_Buscar.Text);


            con.Open();
            OleDbCommand da = new OleDbCommand("SELECT cl.nombre_cliente "
                + "FROM Orden AS od INNER JOIN Cliente AS cl "
                + "ON od.cod_cliente = cl.cod_cliente "
                + "WHERE od.cod_orden = " + codigo_orden + "", con);
            da.ExecuteNonQuery();
            String nombre_cliente = (String)da.ExecuteScalar();

            OleDbCommand dt = new OleDbCommand("SELECT fecha_ingreso "
                + "FROM Orden "
                + "WHERE cod_orden = " + codigo_orden + "", con);
            dt.ExecuteNonQuery();
            String fecha_ingreso = (String)dt.ExecuteScalar();


            OleDbCommand eq1 = new OleDbCommand("SELECT eq1.descripcion_equipo & ' ' & eq1.modelo_equipo "
                + "FROM Tipo_mantenimiento AS tm INNER JOIN Equipo AS eq1 "
                + "ON tm.cod_equipo = eq1.cod_equipo "
                + "WHERE tm.cod_orden = " + codigo_orden + "", con);
            eq1.ExecuteNonQuery();
            String equipo = (String)eq1.ExecuteScalar();


            OleDbCommand tt = new OleDbCommand("SELECT Sum(precio*1) "
                + "FROM Tipo_mantenimiento "
                + "WHERE cod_orden = " + codigo_orden + "", con);
            tt.ExecuteNonQuery();
            decimal monto = (decimal)tt.ExecuteScalar();


            OleDbDataAdapter ta = new OleDbDataAdapter("SELECT tm.cod_orden, eq.descripcion_equipo & ' ' & eq.modelo_equipo AS equipo, 1 AS cantidad, tm.precio, tm.precio*1 AS monto, tm.tipo_mantenimiento "
                + "FROM Tipo_mantenimiento AS tm INNER JOIN Equipo AS eq "
                + "ON tm.cod_equipo = eq.cod_equipo "
                + "WHERE tm.cod_orden = " + codigo_orden + "", con);
            //DataTable rs = new DataTable();
            ta.Fill(rs);
            DTGV.DataSource = rs;
            con.Close();

            lbl_cliente.Text = nombre_cliente;
            lbl_fecha.Text = fecha_ingreso;
            lbl_Equipo.Text = equipo;
            lbl_total.Text = monto.ToString();
        }

        private void btn_Ordenes_Click(object sender, EventArgs e)
        {
            this.Hide();
            new Form1().ShowDialog();
        }

        private void btn_Inventario_Click(object sender, EventArgs e)
        {
            this.Hide();
            new Form2().ShowDialog();
        }

        private void Form3_Load(object sender, EventArgs e)
        {

        }
        private void btn_Imprimir_Click(object sender, EventArgs e)
        {
            SaveFileDialog savefile = new SaveFileDialog();
            savefile.FileName = string.Format("{0}.pdf", DateTime.Now.ToString("ddMMyyyyHHmmss"));
            string paginaHTML_Texto = Properties.Resources.Plantilla.ToString();
            paginaHTML_Texto = paginaHTML_Texto.Replace("@CLIENTE", lbl_cliente.Text);
            paginaHTML_Texto = paginaHTML_Texto.Replace("@DOCUMENTO", txt_Buscar.Text);
            paginaHTML_Texto = paginaHTML_Texto.Replace("@FECHA", DateTime.Now.ToString("dd/MM/yyyy"));
            string Filas = string.Empty;
            String filas = "";
            DataTable rs1 = new DataTable();

            OleDbDataAdapter ta = new OleDbDataAdapter("SELECT 1 AS cantidad, eq.descripcion_equipo & ' ' & eq.modelo_equipo AS equipo, tm.precio, tm.precio*1 AS monto "
               + "FROM Tipo_mantenimiento AS tm INNER JOIN Equipo AS eq "
               + "ON tm.cod_equipo = eq.cod_equipo "
               + "WHERE tm.cod_orden = " + txt_Buscar.Text + "", con);
            ta.Fill(rs1);
            con.Close();

            foreach (DataRow row in rs1.Rows)
            {
                filas += "<tr> ";
                for (int x = 0; x < rs1.Columns.Count; x++)
                {
                    Console.Write(row[x].ToString() + " | ");
                    filas += "<td> "+ row[x].ToString() + " </td>\n";
                }
                filas += "</tr> \n";
            }

            paginaHTML_Texto = paginaHTML_Texto.Replace("@FILAS", filas);
            paginaHTML_Texto = paginaHTML_Texto.Replace("@TOTAL", lbl_total.Text);
            if (savefile.ShowDialog() == DialogResult.OK)
            {
                using (FileStream stream = new FileStream(savefile.FileName, FileMode.Create))
                {
                    //Crear un nuevo documento y lo definimos como PDF
                    Document pdfDoc = new Document(PageSize.A4, 25, 25, 25, 25);
                    PdfWriter writer = PdfWriter.GetInstance(pdfDoc, stream);
                    pdfDoc.Open();
                    pdfDoc.Add(new Phrase(""));

                    //Agregar la imagen al documento
                    iTextSharp.text.Image img = iTextSharp.text.Image.GetInstance(Properties.Resources.logo, System.Drawing.Imaging.ImageFormat.Png);
                    img.ScaleToFit(60, 60);
                    img.Alignment = iTextSharp.text.Image.UNDERLYING;

                    img.SetAbsolutePosition(pdfDoc.LeftMargin, pdfDoc.Top - 60);
                    pdfDoc.Add(img);
                    using (StringReader sr = new StringReader(paginaHTML_Texto))
                    {
                        XMLWorkerHelper.GetInstance().ParseXHtml(writer, pdfDoc, sr);
                    }
                    pdfDoc.Close();
                    stream.Close();
                }
            }
        }
    }
}