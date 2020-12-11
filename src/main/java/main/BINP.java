package main;

import lombok.Getter;

public class BINP {

    @Getter
    private final String fio = "Богданов І.М.";
    @Getter
    private final String mail = "gmiller180890@gmail.com";

    @Getter
    private Object[][] data = new String[][]{{"1", "Афанасенко", ""},
    {"2", "Богданов", ""},
    {"3", "Зленко", ""},
    {"4", "Іпатов", ""},
    {"5", "Панчик", ""},
    {"6", "Пінчук", ""},
    {"7", "Семенченков", ""},
    {"8", "Ткаченко", ""},
    {"9", "Чупряк", ""},
    {"10", "Щербина", ""}};

    @Getter
    private Object[] columns = new String[]{"Id", "F., S. Name",
        "ТОЗП"};

}
