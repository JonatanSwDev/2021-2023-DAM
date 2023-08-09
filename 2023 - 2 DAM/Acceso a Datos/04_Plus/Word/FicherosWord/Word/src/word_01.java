import java.io.File;
import java.util.List;
import java.util.Objects;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


@SuppressWarnings("unused")
public class word_01 {
    public static void main(String[] args) throws Exception {
        
    	XWPFDocument document = new XWPFDocument();
        //Write the Document in file system
        FileOutputStream out = new FileOutputStream("ejemplo_word_01.docx");
        //create Paragraph
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Hola Mundo\n");
        document.write(out);
        //Close document
        out.close();
        System.out.println("Documento creado!!");
    	
    }
}