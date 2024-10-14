package code;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
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
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import javax.swing.JOptionPane;

public class GeneradorPDF {

    public void crearFactura(String nombreCliente, String nitCliente, String direccionCliente, JTable tbCarrito, float total) throws IOException {
        // Definir la ruta y nombre del archivo PDF (NO TOCAR. PERMITE QUE SE ABRAN DESPUES LOS PDF)    
        String ruta = "facturas/" + nombreCliente +"_"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".pdf";

        // Crear el documento PDF
        Document documento = new Document();

        try {
    // Crear un escritor de PDF
    PdfWriter.getInstance(documento, new FileOutputStream(ruta));

    // Abrir el documento
    documento.open();

    // **Definir fuentes**
    Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);  // Negrita, tamaño 14
    Font fuenteTexto = FontFactory.getFont(FontFactory.HELVETICA, 12);        // Regular, tamaño 12

    // **1. Agregar la imagen en la parte superior izquierda**
    InputStream inputStream = getClass().getResourceAsStream("/img/logo.png"); 
    Image imagen = Image.getInstance(inputStream.readAllBytes());
    imagen.scaleToFit(100, 100);
    imagen.setAbsolutePosition(40, 750); // Posicionar la imagen
    documento.add(imagen);

    // **2. Agregar la fecha en la esquina superior derecha**
    String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    Paragraph fechaParrafo = new Paragraph("Fecha: " + fecha, fuenteTexto);
    fechaParrafo.setAlignment(Paragraph.ALIGN_RIGHT);
    documento.add(fechaParrafo);

    // **3. Información de la tienda centrada**
    Paragraph infoTienda = new Paragraph("Optical\nTeléfono: 1234-5678\nDirección: Calle Falsa 123\n\n", fuenteTitulo);
    infoTienda.setAlignment(Paragraph.ALIGN_CENTER);
    documento.add(infoTienda);
    
    // Agregar el título "Información del cliente"
    Paragraph tituloCliente = new Paragraph("Información del cliente", fuenteTitulo);
    tituloCliente.setAlignment(Paragraph.ALIGN_LEFT); // Alinear a la izquierda
    documento.add(tituloCliente);
    


// Información del cliente organizada en párrafos con títulos en negrita
Paragraph infoCliente = new Paragraph();
infoCliente.setSpacingBefore(10f); // Espacio antes de la sección

// Agregar título "Nombre" en negrita y su valor
infoCliente.add(new Phrase("Nombre: ", fuenteTitulo));
infoCliente.add(new Phrase(nombreCliente + "\n", fuenteTexto));

// Agregar título "NIT" en negrita y su valor
infoCliente.add(new Phrase("NIT: ", fuenteTitulo));
infoCliente.add(new Phrase(nitCliente + "\n", fuenteTexto));

// Agregar título "Dirección" en negrita y su valor
infoCliente.add(new Phrase("Dirección: ", fuenteTitulo));
infoCliente.add(new Phrase(direccionCliente + "\n", fuenteTexto));

// Agregar el párrafo al documento
documento.add(infoCliente);


    // **5. Crear la tabla de productos sin bordes**
    PdfPTable tablaProductos = new PdfPTable(5);
    tablaProductos.setWidthPercentage(100);
    tablaProductos.setSpacingBefore(20f);

    // Encabezados con negrita
    String[] headers = { "Código", "Nombre", "Precio", "Cantidad", "Total" };
    for (String header : headers) {
        PdfPCell headerCell = new PdfPCell(new Paragraph(header, fuenteTitulo));
        headerCell.setBorder(PdfPCell.NO_BORDER);
        tablaProductos.addCell(headerCell);
    }

    // Rellenar la tabla con los datos del carrito
    for (int i = 0; i < tbCarrito.getRowCount(); i++) {
        for (int j = 0; j < 5; j++) {
            PdfPCell dataCell = new PdfPCell(new Paragraph(tbCarrito.getValueAt(i, j).toString(), fuenteTexto));
            dataCell.setBorder(PdfPCell.NO_BORDER);
            tablaProductos.addCell(dataCell);
        }
    }

    documento.add(tablaProductos);

    // **6. Total a pagar alineado a la izquierda**
    Paragraph totalPagar = new Paragraph("\nTotal a pagar: Q" + String.format("%.2f", total), fuenteTexto);
    totalPagar.setAlignment(Paragraph.ALIGN_RIGHT);
    documento.add(totalPagar);

    // **7. Mensaje final centrado**
    Paragraph mensajeFinal = new Paragraph("\nGracias por su compra", fuenteTitulo);
    mensajeFinal.setAlignment(Paragraph.ALIGN_CENTER);
    documento.add(mensajeFinal);

} catch (DocumentException | IOException e) {
    e.printStackTrace();
} 
    finally {
            // Cerrar el documento
            documento.close();
        }
       
        System.out.println("PDF generado correctamente en: " + ruta);
        
         // Abrir el archivo PDF Automaticamente
      /*   File pdfFile = new File(ruta);
        if (pdfFile.exists()) {             //Si se quiere que se abra al nomas crearse, quitar este comentario
            Desktop.getDesktop().open(pdfFile);  
        } */ 
    }
    
    
    public void abrirPDF(String rutaPDF) throws IOException {
    File archivo = new File(rutaPDF);

    if (archivo.exists()) {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(archivo);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo en este sistema.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "El archivo PDF no existe.");
    }
}

    
}
