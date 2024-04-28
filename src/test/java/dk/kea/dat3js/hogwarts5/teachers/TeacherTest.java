package dk.kea.dat3js.hogwarts5.teachers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TeacherTest {

    @Test
    void getFullName() {


    }

    @Test
    void getFullNameWithMiddleName() {
        // arrange
        Teacher teacher = new Teacher("Harry", "James", "Potter", null, "Potions");

        // act
        var fullName = teacher.getFullName();

        // assert
        assertEquals("Harry James Potter", fullName);


    }

    @Test
    void getFullNameWithoutMiddleName() {
        // arrange
        Teacher teacher = new Teacher("Cho", "Chang", null, "Potions");

        // act
        var fullName = teacher.getFullName();

        // assert
        assertEquals("Cho Chang", fullName);
    }

    @Test
    void setFullNameWithMiddleName() {
        // arrange
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions");

        // act
        teacher.setFullName("Hermione JeAn GrAngEr");

        // assert
        assertEquals("Hermione", teacher.getFirstName());
        assertEquals("Jean", teacher.getMiddleName());
        assertEquals("Granger", teacher.getLastName());
    }

    @Test
    void setFullNameWithoutLastName() {
        // arrange
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions");

        // act
        teacher.setFullName("Harry");

        // assert
        assertEquals("Harry", teacher.getFullName());
    }

    @Test
    void setFullNameWithMultipleMiddleName() {
        // arrange
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions");

        // act
        teacher.setFullName("Harry James jamEs JAMes Potter");

        // assert
        assertEquals("Harry", teacher.getFirstName());
        assertEquals("James James James", teacher.getMiddleName());
        assertEquals("Potter", teacher.getLastName());
    }

    @Test
    void setFullNameWithEmptyString() {
        // arrange
        Teacher teacher = new Teacher("First", "Middle", "Last", null, "Potions");

        // act
        teacher.setFullName("");

        // assert
        assertNull(teacher.getFirstName());
        assertNull(teacher.getMiddleName());
        assertNull(teacher.getLastName());
    }

    @Test
    void setFullNameWithNull() {
        // arrange
        Teacher teacher = new Teacher("First", "Middle", "Last", null, "Potions");

        // act
        teacher.setFullName(null);

        // assert
        assertNull(teacher.getFullName());
    }

    @Test
    void setNameWithSpaceAtEnd() {
        // arrange
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions");

        // act
        teacher.setFullName("Malte Mørkeberg ");

        //assert
        assertEquals("Malte Mørkeberg", teacher.getFullName());
    }

    @Test
    void setNameWithWeirdCapitalization() {
        // arrange
        Teacher teacher = new Teacher("Minerva McGonagall", null, "Enchanting");

        // act
        String returnedName = teacher.getLastName();

        // assert
        assertEquals("McGonagall", returnedName);
    }

    @Test
    void setNameWithDashSomewhere() {
        // arrange
        Teacher teacher = new Teacher("justin finch-mckinley", null, "Advanced Farting");

        // act
        String returnedName = teacher.getFullName();

        // assert
        assertEquals("Justin Finch-McKinley", returnedName);


    }

    @Test
    void setFullName() {
    }
}