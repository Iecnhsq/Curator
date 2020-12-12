package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

public class WWMessage {
    
    private static final Logger LOGGER = Logger.getLogger(WWMessage.class);

    public WWMessage() throws IOException {
        getWW();
    }

    private void getWW() throws FileNotFoundException, IOException {
        XWPFDocument docxModel = new XWPFDocument();
        CTSectPr ctSectPr = docxModel.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docxModel, ctSectPr);
        CTP ctpHeaderModel = createHeaderModel(
                "ДВНЗ КМТК 01.12.2020"
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
        XWPFParagraph bodyParagraph = docxModel.createParagraph();
        bodyParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragraphConfig = bodyParagraph.createRun();
        paragraphConfig.setBold(true);
        paragraphConfig.setFontFamily("Times New Roman");
        paragraphConfig.setFontSize(16);
        paragraphConfig.setText("Державний вищий навчальний заклад");
        paragraphConfig.addBreak();
        paragraphConfig.setText("'Київський механіко-технологічний коледж'");
        paragraphConfig.addBreak();
        paragraphConfig.setText(" "); // 2 пробела!!!!!
        paragraphConfig.addBreak();
        paragraphConfig.setText("Шановні батьки!");
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

        XWPFParagraph bodyParagraph2 = docxModel.createParagraph();
        bodyParagraph2.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun paragraphConfig2 = bodyParagraph2.createRun();
        paragraphConfig2.setFontFamily("Times New Roman");
        paragraphConfig2.setFontSize(14);
        paragraphConfig2.setBold(true);
        paragraphConfig2.setText("1. () ... - () н/а");

        try (
                 FileOutputStream outputStream = new FileOutputStream("D:/Лист.docx")) {
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
