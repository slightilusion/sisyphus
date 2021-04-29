package cc.yelcat.sisyphus.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String getTheday() {
        DateTimeFormatter fmDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //当天
        LocalDate today = LocalDate.now();
        return today.format(fmDate);
    }
}
