package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;

public class WWTable {

    private static final Logger LOGGER = Logger.getLogger(WWTable.class);
    private final DoIt dt = new DoIt();

    public void getWW(String t1, String t2) throws FileNotFoundException, IOException {
        XWPFDocument docxModel = new XWPFDocument();
        CTSectPr ctSectPr = docxModel.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docxModel, ctSectPr);
        CTP ctpHeaderModel = createHeaderModel(
                "ДВНЗ КМТК " + dt.getDate()
        );
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeaderModel, docxModel);
        headerFooterPolicy.createHeader(
                XWPFHeaderFooterPolicy.DEFAULT,
                new XWPFParagraph[]{headerParagraph}
        );
        CTP ctpFooterModel = createFooterModel("Сформовано автоматично");
        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooterModel, docxModel);
        headerFooterPolicy.createFooter(
                XWPFHeaderFooterPolicy.DEFAULT,
                new XWPFParagraph[]{footerParagraph}
        );

        XWPFParagraph BP1 = docxModel.createParagraph();
        BP1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun PC1 = BP1.createRun();
        PC1.setBold(true);
        PC1.setFontFamily("Times New Roman");
        PC1.setFontSize(16);
        PC1.setText(t1);
        PC1.addBreak();

        XWPFParagraph BP2 = docxModel.createParagraph();
        BP2.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun PC2 = BP2.createRun();
        PC2.setFontFamily("Times New Roman");
        PC2.setFontSize(14);
        PC2.setText(t2);
        PC2.addBreak();

        int twipsPerInch = 1440;
        XWPFTable table1 = docxModel.createTable();
        table1.setTableAlignment(TableRowAlign.CENTER);
        XWPFTableRow tableRowOne = table1.getRow(0);
        tableRowOne.getCell(0).setText("Загальна кількість оцінок:");
        tableRowOne.addNewTableCell().setText("Z");
        tableRowOne.addNewTableCell().setText("% якості:");
        tableRowOne.addNewTableCell().setText("Z");
        tableRowOne.setHeight((int) (twipsPerInch * 1 / 4));

        XWPFTableRow tableRowTwo = table1.createRow();
        tableRowTwo.getCell(0).setText("Кількість оцінок \"5\" та \"4\":");
        tableRowTwo.getCell(1).setText("Z");
        tableRowTwo.getCell(2).setText("% прогулів:");
        tableRowTwo.getCell(3).setText("Z");
        tableRowTwo.setHeight((int) (twipsPerInch * 1 / 4));

        XWPFTableRow tableRowThree = table1.createRow();
        tableRowThree.getCell(0).setText("Кількість незадовільних оцінок:");
        tableRowThree.getCell(1).setText("Z");
        tableRowThree.getCell(2).setText("Дата заповнення:");
        tableRowThree.getCell(3).setText(dt.getDate());
        tableRowThree.setHeight((int) (twipsPerInch * 1 / 4));

        XWPFTableRow tableRowFour = table1.createRow();
        tableRowFour.getCell(0).setText("% успішності:");
        tableRowFour.getCell(1).setText("Z");
        tableRowFour.getCell(2).setText("Керівник групи:");
        tableRowFour.getCell(3).setText("І.М. Богданов");
        tableRowFour.setHeight((int) (twipsPerInch * 1 / 4));

        /*
        XWPFParagraph bodyParagraph = docxModel.createParagraph();
        bodyParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphConfig = bodyParagraph.createRun();
        paragraphConfig.setBold(true);
        paragraphConfig.setFontFamily("Times New Roman");
        paragraphConfig.setFontSize(16);
        paragraphConfig.setText("Державний вищий навчальний заклад");
        paragraphConfig.addBreak();

        XWPFParagraph bodyParagraph1 = docxModel.createParagraph();
        bodyParagraph1.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun paragraphConfig1 = bodyParagraph1.createRun();
        paragraphConfig1.setFontFamily("Times New Roman");
        paragraphConfig1.setFontSize(14);
        paragraphConfig1.setText("   Адміністрація ДВНЗ 'Київський механіко-технологічний коледж' доводить до Вашого відома те,"
                + " що Ваш син, студент групи () ТРЗВ - 17/1 () Панчик Богдан Романович за резкльтатами атестації"
                + " за () лютий місяць має () 47 годин пропусків занять без поважних причин та незадовільні оцінки з"
                + " наступних предметів/дисциплін:");
         */
        try (
                 FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ivans\\Music\\Відомість успішності.docx")) {
            docxModel.write(outputStream);
        }
        LOGGER.info("Успешно записан в файл");
    }

    private static CTP createFooterModel(String footerContent) {
        CTP ctpFooterModel = CTP.Factory.newInstance();
        CTR ctrFooterModel = ctpFooterModel.addNewR();
        CTText cttFooter = ctrFooterModel.addNewT();
        cttFooter.setStringValue(footerContent);
        return ctpFooterModel;
    }

    private static CTP createHeaderModel(String headerContent) {
        CTP ctpHeaderModel = CTP.Factory.newInstance();
        CTR ctrHeaderModel = ctpHeaderModel.addNewR();
        CTText cttHeader = ctrHeaderModel.addNewT();
        cttHeader.setStringValue(headerContent);
        return ctpHeaderModel;
    }

}
