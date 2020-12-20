package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DoIt {

    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

}
