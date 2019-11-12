import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;


public class Main {

    /* Задача 3  Есть файл со списком имен с датами рождения:
     Sergey,15-02-1979
     Ivan,22-03-1986
     Piotr,01-10-1955
     Anna,13-12-1995
     Нужно написать программу, которая возвращает файл со списком имен и датрождений
         , отсортированный по дате рождения.*/
    public static void main(String[] args) {
        Main m = new Main();
        File file = new File("listofpersons.txt");
        File fileout = new File("listofpersonsOut.txt");
        m.sortedByBirthDate(file, fileout);
    }

    public void sortedByBirthDate(File file, File fileout) {
        try (BufferedReader in = new BufferedReader(new FileReader(file));
             PrintWriter out = new PrintWriter(fileout)) {
            in.lines()
                    .map(this::createPerson)
                    .sorted(Comparator.comparing(Person::getDateOfBirth))
                  //  .map(this::createStringFromPerson)
                    .forEach(out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private Person createPerson(String string) {
        String[] data = string.split(",");
        return new Person(data[0], LocalDate.parse(data[1], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

 /*   private String createStringFromPerson(Person person) {
        return person.getName() + "," + person.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }*/

}

class Person {
    private String name;
    private LocalDate dateOfBirth;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return name + ',' + dateOfBirth;
    }
}
