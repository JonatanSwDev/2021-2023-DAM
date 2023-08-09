import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigInteger;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFTable.XWPFBorderType;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapSquare;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STVerticalAlignRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

import com.microsoft.schemas.office.word.CTWrap;

public class Curriculum {

    public static void main(String[] args) throws Exception {

        String NOMBRE = "Jónatan Gómez García";

        // Path de la imagen
        String imagenPath = "perfil.jpg";
        FileInputStream imagenIn = new FileInputStream(imagenPath);

        // Datos personales
        String seccionDP = "\tDatos Personales\t\t\t\t\t\t  ";
        String[] dataDP = { "Camino de los Soldados nº 57, Nonduermas, Murcia", "21 Abril de 1994", "Murcia",
                "638575367", "objetivopresidencia@gmail.com" };

        // Formación Académica
        String seccionFA = "\tFormación Académica";
        String[] dataFA = {
                "Ciclo formativo de Grado Medio de Sistemas Microinformáticos y Redes. IES Ingeniero de La Cierva, Murcia (2000 horas). Este Ciclo lleva aparejado el reconocimiento del “Título de Técnico Básico en Prevención de Riesgos Laborales”.",
                "Enseñanza Secundaria Obligatoria (ESO). IES Alcántara." };

        // Idiomas
        String seccionID = "\tIdiomas";
        String[] dataID = {
                "Módulo formativo en \"Ingles técnico\" (CFGS Desarrollo de Aplicaciones Multiplataforma). Inglés: nivel A1 (usuario básico)",
                "Español nativo" };

        // Experiencia laboral
        String seccionEL = "\tExperiencia Laboral";
        String[] dataEL = {
                "[2017] Meses de mayo, junio y septiembre en Parlamento Andaluz de Romea como extra de camarero.",
                "[2017-2018] Diciembre y Enero (200h) Mecánico de bicicletas de la empresa Soluciones Técnicas 2000 S.A. en Carrefour con tareas de montaje y reparación de bicicletas, reponedor, vendedor y mozo de almacén.",
                "[2017-2018] Diciembre y Enero (36h) Mecánico de bicicletas de la empresa Soluciones Técnicas 2000 S.A. en Hipercor el Tiro con tareas de montaje y reparación de bicicletas.",
                "[Diciembre 2017 – Junio 2018] Colaborador de la empresa Glovoapp23 S. L. como repartidor, dado de alta en el régimen de trabajadores por cuenta propia. ",
                "[Febrero 2018 – Julio 2018] Técnico Informático en Helpdesk y notarías en la empresa Universal Data.",
                "[Septiembre 2018 – Febrero 2019] Técnico Informático en Helpdesk y notarías en la empresa Universal Data.",
                "[Junio 2019 – Agosto 2019] Monitor de Karting en Karting Alhama.",
                "[Septiembre 2019 – Enero 2020] Cocinero en Domino’s Pizza.",
                "[Febrero 2020 – Abril 2022] Repartidor a domicilio en Burger King España, centro ubicado en Alcantarilla.",
                "[Junio 2022 – Agosto 2022] Tele operador remoto para Vitaldent." };

        // Otra informacion
        String seccionOI = "\tOtra información";
        String[] dataOI = { "Carnet de conducir: B, A.", "Vehículo propio." };

        /////////////////////////////// Crear el documento
        /////////////////////////////// Word//////////////////////////////

        // Crear un documento vacío
        XWPFDocument doc = new XWPFDocument();
     

        //Tabla para el primer contenido
        XWPFTable table = doc.createTable(1, 2);
        table.removeBorders();

        // Obtener la fila
        XWPFTableRow row = table.getRow(0);

        // Añadir texto a la primera celda
        XWPFTableCell cell1 = row.getCell(0);
        

        //Mi nombre
        XWPFParagraph nombre = cell1.addParagraph();
        nombre.setAlignment(ParagraphAlignment.LEFT);
        nombre.setSpacingAfter(0);
        nombre.setSpacingBefore(0);

        // Datos del nombre
        XWPFRun nombreRun = nombre.createRun();
        nombreRun.setBold(true);
        nombreRun.setFontSize(14);
        nombreRun.setText(NOMBRE);
        nombreRun.addBreak();



        // Crear un párrafo para los datos personales
        XWPFParagraph datosPersonales = cell1.addParagraph();
        datosPersonales.setAlignment(ParagraphAlignment.LEFT);
        datosPersonales.setSpacingAfter(0);
        datosPersonales.setSpacingBefore(0);

        // Crear el borde para el parrafo:
        datosPersonales.setBorderBottom(Borders.SINGLE);
        XWPFRun datosPersonalesRun = datosPersonales.createRun();
        datosPersonalesRun.setBold(true);
        datosPersonalesRun.setText(seccionDP);

        //Crear el contenido de los datos personales
        XWPFParagraph DPdata = cell1.addParagraph();
        DPdata.setSpacingBefore(0);
        DPdata.setSpacingAfter(0);
        XWPFRun DPdataRun = DPdata.createRun();
        DPdataRun.setFontSize(11);
        for (String string : dataDP) {
            DPdataRun.addBreak();
            DPdataRun.setText(string);
        }
        DPdataRun.addBreak();



        // Añadir la imagen a la segunda celda
        XWPFTableCell cell2 = row.getCell(1);
        cell2.addParagraph().createRun().addPicture(imagenIn, XWPFDocument.PICTURE_TYPE_JPEG, "portada.jpg", Units.toEMU(84),
        Units.toEMU(106));



        // Crear un párrafo para los formacion academica
        XWPFParagraph formacionAcademica = doc.createParagraph();
        formacionAcademica.setAlignment(ParagraphAlignment.LEFT);
        formacionAcademica.setSpacingAfter(0);
        formacionAcademica.setSpacingBefore(0);
        // Crear el borde para el parrafo:
        formacionAcademica.setBorderBottom(Borders.SINGLE);
        XWPFRun formacionAcademicaRun = formacionAcademica.createRun();
        formacionAcademicaRun.setBold(true);
        formacionAcademicaRun.setText(seccionFA);

        // Crear el contenido de las formacion academica
        XWPFParagraph FAdata = doc.createParagraph();
        FAdata.setSpacingBefore(0);
        FAdata.setSpacingAfter(0);
        XWPFRun FAdataRun = FAdata.createRun();
        FAdataRun.setFontSize(10);
        for (String string : dataFA) {
            FAdataRun.addBreak();
            FAdataRun.setText(string);
        }
        FAdataRun.addBreak();



        // Crear un párrafo para los idiomas
        XWPFParagraph idiomas = doc.createParagraph();
        idiomas.setAlignment(ParagraphAlignment.LEFT);
        idiomas.setSpacingAfter(0);
        idiomas.setSpacingBefore(0);
        // Crear el borde para el parrafo:
        idiomas.setBorderBottom(Borders.SINGLE);
        XWPFRun idiomasRun = idiomas.createRun();
        idiomasRun.setBold(true);
        idiomasRun.setText(seccionID);

        // Crear el contenido:
        XWPFParagraph IDdata = doc.createParagraph();
        IDdata.setSpacingBefore(0);
        IDdata.setSpacingAfter(0);
        XWPFRun IDdataRun = IDdata.createRun();
        IDdataRun.setFontSize(10);
        for (String string : dataID) {
            IDdataRun.addBreak();
            IDdataRun.setText(string);
        }
        IDdataRun.addBreak();
        


        // Crear un párrafo para los experienciaLaboral
        XWPFParagraph experienciaLaboral = doc.createParagraph();
        experienciaLaboral.setAlignment(ParagraphAlignment.LEFT);
        experienciaLaboral.setSpacingAfter(0);
        experienciaLaboral.setSpacingBefore(0);
        // Crear el borde para el parrafo:
        experienciaLaboral.setBorderBottom(Borders.SINGLE);
        XWPFRun experienciaLaboralRun = experienciaLaboral.createRun();
        experienciaLaboralRun.setBold(true);
        experienciaLaboralRun.setText(seccionEL);

        // Crear el contenido:
        XWPFParagraph ELdata = doc.createParagraph();
        ELdata.setSpacingBefore(0);
        ELdata.setSpacingAfter(0);
        XWPFRun ELdataRun = ELdata.createRun();
        ELdataRun.setFontSize(10);
        for (String string : dataEL) {
            ELdataRun.addBreak();
            ELdataRun.setText(string);
        }
        ELdataRun.addBreak();



        // Crear un párrafo para los otraInformacion
        XWPFParagraph otraInformacion = doc.createParagraph();
        otraInformacion.setAlignment(ParagraphAlignment.LEFT);
        otraInformacion.setSpacingAfter(0);
        otraInformacion.setSpacingBefore(0);
        // Crear el borde para el parrafo:
        otraInformacion.setBorderBottom(Borders.SINGLE);
        XWPFRun otraInformacionRun = otraInformacion.createRun();
        otraInformacionRun.setBold(true);
        otraInformacionRun.setText(seccionOI);

        // Crear el contenido:
        XWPFParagraph OIdata = doc.createParagraph();
        OIdata.setSpacingBefore(0);
        OIdata.setSpacingAfter(0);
        XWPFRun OIdataRun = OIdata.createRun();
        OIdataRun.setFontSize(10);
        for (String string : dataOI) {
            OIdataRun.addBreak();
            OIdataRun.setText(string);
        }
        OIdataRun.addBreak();

        FileOutputStream out = new FileOutputStream("Curriculum_Jonatan_Gomez(GENERADO).docx");
        doc.write(out);
        out.close();

        System.out.println("El currículum se ha generado correctamente.");

    }
}