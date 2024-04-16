import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.*;

class Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", firstName, lastName);
    }

    @Override
    public int hashCode() {
        return firstName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return firstName.equals(((Person) obj).firstName);
    }
}


interface YearOfBirthTemplateFilter {

    Boolean test(LocalDate date);
    //Boolean test2(LocalDate date);

}


public class Main {

    public static void main(String[] args) {

        // Set
        Set<Person> personSet = new HashSet<Person>();
        Person person1 = new Person("Angel", "Pet", LocalDate.of(2001, 5, 14));
        Person person2 = new Person("Angelaa", "Pet", LocalDate.of(2000, 5, 14));
        Person person3 = new Person("Angelaaaa", "Pet", LocalDate.of(1999, 5, 14));
        Person person4 = new Person("Kiko", "Kikov", LocalDate.of(2002, 7, 22));
        personSet.add(person1);
        personSet.add(person3);
        personSet.add(person4);
        personSet.add(person2);

        // filter out persons that are born after 2001 godina

        // group persons with same surname, and the year of births

        Predicate<Person> p = person -> person.getDateOfBirth().getYear() <= 2001;

        YearOfBirthTemplateFilter filter = date -> date.getYear() <= 2001;


        Predicate<Person> pred = person -> filter.test(person.getDateOfBirth());

        Map<String, Set<Integer>> persons = personSet.stream().filter(p)
                .collect(
                    Collectors.groupingBy(
                        Person::getLastName, Collectors.mapping(p -> p.getDateOfBirth().getYear(), Collectors.toSet())
                    )
                );

        System.out.println(
            persons
        );

       // https://www.baeldung.com/java-groupingby-collector

    }
}
