package service;

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

public class WordWorker {

    private static final Logger LOGGER = Logger.getLogger(WordWorker.class);

    public WordWorker() throws IOException {
        getWW();
    }

    private void getWW() throws FileNotFoundException, IOException {
        // создаем модель docx документа,
        // к которой будем прикручивать наполнение (колонтитулы, текст)
        XWPFDocument docxModel = new XWPFDocument();
        CTSectPr ctSectPr = docxModel.getDocument().getBody().addNewSectPr();
        // получаем экземпляр XWPFHeaderFooterPolicy для работы с колонтитулами
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docxModel, ctSectPr);
        // создаем верхний колонтитул Word файла
        CTP ctpHeaderModel = createHeaderModel(
                "Верхний колонтитул - создано с помощью Apache POI на Java :)"
        );
        // устанавливаем сформированный верхний
        // колонтитул в модель документа Word
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeaderModel, docxModel);
        headerFooterPolicy.createHeader(
                XWPFHeaderFooterPolicy.DEFAULT,
                new XWPFParagraph[]{headerParagraph}
        );
        // создаем нижний колонтитул docx файла
        CTP ctpFooterModel = createFooterModel("Просто нижний колонтитул");
        // устанавливаем сформированый нижний
        // колонтитул в модель документа Word
        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooterModel, docxModel);
        headerFooterPolicy.createFooter(
                XWPFHeaderFooterPolicy.DEFAULT,
                new XWPFParagraph[]{footerParagraph}
        );
        // создаем обычный параграф, который будет расположен слева,
        // будет синим курсивом со шрифтом 25 размера
        XWPFParagraph bodyParagraph = docxModel.createParagraph();
        bodyParagraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun paragraphConfig = bodyParagraph.createRun();
        paragraphConfig.setItalic(true);
        paragraphConfig.setFontSize(25);
        // HEX цвет без решетки #
        paragraphConfig.setColor("06357a");
        paragraphConfig.setText(
                "Prologistic.com.ua - новые статьи по Java и Android каждую неделю. Подписывайтесь!"
        );
        try ( // сохраняем модель docx документа в файл
                 FileOutputStream outputStream = new FileOutputStream("D:/Apache POI Word Test.docx")) {
            docxModel.write(outputStream);
        }
        LOGGER.info("Успешно записан в файл");
    }

    private static CTP createFooterModel(String footerContent) {
        // создаем футер или нижний колонтитул
        CTP ctpFooterModel = CTP.Factory.newInstance();
        CTR ctrFooterModel = ctpFooterModel.addNewR();
        CTText cttFooter = ctrFooterModel.addNewT();
        cttFooter.setStringValue(footerContent);
        return ctpFooterModel;
    }

    private static CTP createHeaderModel(String headerContent) {
        // создаем хедер или верхний колонтитул
        CTP ctpHeaderModel = CTP.Factory.newInstance();
        CTR ctrHeaderModel = ctpHeaderModel.addNewR();
        CTText cttHeader = ctrHeaderModel.addNewT();
        cttHeader.setStringValue(headerContent);
        return ctpHeaderModel;
    }

}
