

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;

import com.microsoft.schemas.vml.CTGroup;

public class Word3 {

	public static void main(String[] args) throws IOException, InvalidFormatException, XmlException {
    	@SuppressWarnings("resource")
		XWPFDocument document = new XWPFDocument();
    	XWPFRun run;
    	String texto = "Érase una vez un hidalgo de los de lanza en astillero....";	
    	
    	XWPFParagraph paragraph1 = document.createParagraph();
    	XWPFRun run1 = paragraph1.createRun();
    	//paragraph1.setAlignment(ParagraphAlignment.CENTER);
    	//paragraph1.setAlignment(ParagraphAlignment.LEFT);
    	//paragraph1.setAlignment(ParagraphAlignment.RIGHT);
    	paragraph1.setAlignment(ParagraphAlignment.BOTH);
    	run1.setBold(true);
    	run1.setFontSize(40);
    	run1.setFontFamily("arial");
    	run1.setText(texto);
    	run1.setColor("328800");
    	
    	run1.addBreak();
    	
    	XWPFTable table = document.createTable();
    	XWPFTableRow tableRow = table.getRow(0);
    	tableRow.getCell(0).setText("Nombre");
    	tableRow.getCell(0).setColor("00FF00");
    	tableRow.addNewTableCell().setText("Edad");
    	tableRow.getCell(1).setColor("00FF00");
    	tableRow.addNewTableCell().setText("Curso");
    	tableRow.getCell(2).setColor("00FF00");

    	XWPFTableRow tableRow2 = table.createRow();
    	tableRow2.getCell(0).setText("Leonardo");
    	tableRow2.getCell(1).setText("12");
    	tableRow2.getCell(2).setText("1-ESO-A");

    	XWPFTableRow tableRow3 = table.createRow();
    	//tableRow3.addNewTableCell();
    	tableRow3.getCell(0).setText("Juan");
    	tableRow3.getCell(1).setText("23");
    	tableRow3.getCell(2).setText("2_ASIR");
    	
    	XWPFParagraph paragraph2 = document.createParagraph();
    	XWPFRun run2 = paragraph2.createRun();
    	run2.addBreak();
    	run2.addBreak();
    	
    	
    	//#######################################################
    	
    
    	XWPFTable table2 = document.createTable(5,2);
    	table2.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(600));
    	table2.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(500));
    	table2.getRow(0).getCell(0).setText("1A");
    	table2.getRow(0).getCell(1).setText("1B");
    	XWPFTableRow newrow = table2.createRow();
    	newrow.getCell(0).setText("2A");
    	newrow.getCell(1).setText("2B");
    	
    	//ahora inserto un texto dentro de una celda ya existente
    	XWPFTableRow newrowPosicionar = table2.getRow(2);
    	newrowPosicionar.getCell(0).setText("3A");
    	newrowPosicionar.getCell(0).setColor("003322");
    	
    	
    	// voy a insertar un párrafo muy grnade dentro de la celda
    	XWPFParagraph paragraphCELDA = newrowPosicionar.getCell(1).addParagraph();
    	XWPFRun runTABLA = paragraphCELDA.createRun();
    	//paragraph1.setAlignment(ParagraphAlignment.CENTER);
    	//paragraph1.setAlignment(ParagraphAlignment.LEFT);
    	//paragraph1.setAlignment(ParagraphAlignment.RIGHT);
    	paragraphCELDA.setAlignment(ParagraphAlignment.BOTH);
    	runTABLA.setBold(true);
    	runTABLA.setFontSize(14);
    	runTABLA.setFontFamily("arial");
    	runTABLA.setText(texto);
    	runTABLA.setColor("328800");
    	
    	//voy a poner una imagen dentro de una celda de tabla
    	
    	FileInputStream fis2;
    	fis2 = new FileInputStream("bob.jpeg");
    	
    	
    	XWPFTableCell cell = table2.getRow(3).getCell(1);
    	cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
    	
    	
    	XWPFParagraph paragraphCELDA2 = cell.addParagraph();
       	XWPFRun runTABLA2 = paragraphCELDA2.createRun();
    
        runTABLA2.addPicture(fis2, XWPFDocument.PICTURE_TYPE_JPEG, "BOB_img", Units.toEMU(10), Units.toEMU(10));
        runTABLA2.addBreak();
       
    	
    	

    	//##############################################
      	
       	FileInputStream fis;
      
 
    	XWPFParagraph paragraph4;
        	

    	//Write Hall Name at the top of the word document
    	paragraph4 = document.createParagraph();
    	paragraph4.setAlignment(ParagraphAlignment.CENTER);
    	run = paragraph4.createRun();
    	
    	run.setUnderline(UnderlinePatterns.WORDS);
    	run.setText("Imagen: " );
    	run.addBreak();run.addBreak();
    	run.addBreak();
    	
    	fis = new FileInputStream("bob.jpeg");
        run.addPicture(fis, XWPFDocument.PICTURE_TYPE_JPEG, "BOB_img", Units.toEMU(100), Units.toEMU(100));
        
    	
        
        
        
        
        
        // ### GUARDANDO EN DISCO EL FICHERO CREADO
        FileOutputStream out = new FileOutputStream(new File("documento_2.docx"));    	
    	document.write(out);
    	out.close();
    	
    	System.out.println("Creado");		
    	  
    	}
    	
	
}
