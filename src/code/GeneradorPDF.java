package code;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import com.itextpdf.text.Image;
import javax.swing.JTable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneradorPDF {

    public void crearFactura(String nombreCliente, String nitCliente, String direccionCliente, JTable tbCarrito, float total) throws IOException {
        // Definir la ruta y nombre del archivo PDF
        String ruta = "Factura_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".pdf";

        // Crear el documento PDF
        Document documento = new Document();

        try {
            // Crear un escritor de PDF
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));

            // Abrir el documento
            documento.open();
            
             // Agregar la imagen
        InputStream inputStream = getClass().getResourceAsStream("/img/logo.png"); 
        Image imagen = Image.getInstance(inputStream.readAllBytes());
        imagen.scaleToFit(100, 100); // Escalar la imagen a un tamaño específico (opcional)
        imagen.setAlignment(Image.ALIGN_LEFT); // Alinear la imagen a la izquierda
        documento.add(imagen);
            // Información de la tienda
            documento.add(new Paragraph("Optical"));
            documento.add(new Paragraph("Teléfono: 1234-5678"));
            documento.add(new Paragraph("Dirección: Calle Falsa 123\n\n"));

            // Información del cliente
            documento.add(new Paragraph("Información del Cliente:"));
            documento.add(new Paragraph("Nombre: " + nombreCliente));
            documento.add(new Paragraph("NIT: " + nitCliente));
            documento.add(new Paragraph("Dirección: " + direccionCliente + "\n\n"));

            // Fecha de la venta
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            documento.add(new Paragraph("Fecha: " + fecha + "\n\n"));

            // Crear una tabla con 5 columnas: Código, Nombre, Precio, Cantidad, Total
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Código");
            tabla.addCell("Nombre");
            tabla.addCell("Precio");
            tabla.addCell("Cantidad");
            tabla.addCell("Total");

            // Rellenar la tabla con los datos del carrito
            for (int i = 0; i < tbCarrito.getRowCount(); i++) {
                tabla.addCell(tbCarrito.getValueAt(i, 0).toString());  // Código
                tabla.addCell(tbCarrito.getValueAt(i, 1).toString());  // Nombre
                tabla.addCell(tbCarrito.getValueAt(i, 2).toString());  // Precio
                tabla.addCell(tbCarrito.getValueAt(i, 3).toString());  // Cantidad
                tabla.addCell(tbCarrito.getValueAt(i, 4).toString());  // Total
            }

            // Agregar la tabla al documento
            documento.add(tabla);

            // Agregar el total a pagar
            documento.add(new Paragraph("\nTotal a pagar: Q" + String.format("%.2f", total)));

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            documento.close();
        }
       
        System.out.println("PDF generado correctamente en: " + ruta);
        
         // Abrir el archivo PDF Automaticamente
         File pdfFile = new File(ruta);
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);  
        }
    }
    
    
}
