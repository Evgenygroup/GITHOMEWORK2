import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DateTimeTest {

    private DateTime d;

    @Before
    public void init() {
        d = new DateTime();
    }

    //1
    @Test
    public void daysBetweenDatesTestOneDate() {
        LocalDateTime localDateTime1 = LocalDateTime.now();

        List<LocalDateTime> datestimes = Arrays.asList(localDateTime1);

        assertEquals(0, d.numberOfDaysBetweenDates(datestimes));

    }

    @Test
    public void daysBetweenDatesTestSimilarDates() {
        LocalDateTime localDateTime1 = LocalDateTime.now();

        List<LocalDateTime> datestimes = Arrays.asList(localDateTime1, localDateTime1);

        assertEquals(0, d.numberOfDaysBetweenDates(datestimes));

    }

    @Test
    public void daysBetweenDatesTest() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.plusDays(10);
        LocalDateTime localDateTime3 = localDateTime1.plusDays(5);
        List<LocalDateTime> datestimes = Arrays.asList(localDateTime1, localDateTime2, localDateTime3);

        assertEquals(10, d.numberOfDaysBetweenDates(datestimes));

    }

    //2
    @Test
    public void sortedDatesTest() {
        List<String> actual = Arrays.asList("10 Jun 2019", "08 Jul 2018", "01 Jan 2010");
        List<String> expected = Arrays.asList("Пт, 01 янв 2010", "Вс, 08 июл 2018", "Пн, 10 июн 2019");
        assertEquals(expected, d.sortedDates(actual));

    }
}
