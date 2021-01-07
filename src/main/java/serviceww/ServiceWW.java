package serviceww;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ServiceWW {

    // Дата
    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

}
