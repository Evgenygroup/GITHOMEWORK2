import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DateTime {


    //Задача 1 Дан список List<LocalDateTime>, нужно
    // вывести количество дней между самой раннейи поздней датами.


    public long numberOfDaysBetweenDates(List<LocalDateTime> dates) {
        List<LocalDateTime> collect = dates.stream()
                .sorted()
                .collect(Collectors.toList());
        return ChronoUnit.DAYS.between(collect.get(0), collect.get(collect.size() - 1));
    }

    //Задача 2 Дан список строк List<String>, представляющих даты в формате ”3 Jun 2018”.
    // Вывести отсортированный список в формате “Tue, 3 Jun 2018 ”. Вывести даты на русском

    public List<String> sortedDates(List<String> stringDates) {
        return stringDates.stream()
                .map(DateTime::convertStringDateIntoLocalDate)
                .sorted()
                .map(DateTime::convertDateToNewFormat)
                .collect(Collectors.toList());
    }

    private static LocalDate convertStringDateIntoLocalDate(String str) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    private static String convertDateToNewFormat(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy", new Locale("ru")));
    }


}
