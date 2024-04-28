package dk.kea.dat3js.hogwarts5.students;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getFullName() {


    }

    @Test
    void getFullNameWithMiddleName() {
        // arrange
        Student student = new Student("Harry", "James", "Potter", null, 7);

        // act
        var fullName = student.getFullName();

        // assert
        assertEquals("Harry James Potter", fullName);


    }

    @Test
    void getFullNameWithoutMiddleName() {
        // arrange
        Student student = new Student("Cho", "Chang", null, 7);

        // act
        var fullName = student.getFullName();

        // assert
        assertEquals("Cho Chang", fullName);
    }

    @Test
    void setFullNameWithMiddleName() {
        // arrange
        Student student = new Student("first", "middle", "last", null, 7);

        // act
        student.setFullName("Hermione JeAn GrAngEr");

        // assert
        assertEquals("Hermione", student.getFirstName());
        assertEquals("Jean", student.getMiddleName());
        assertEquals("Granger", student.getLastName());
    }

    @Test
    void setFullNameWithoutLastName() {
        // arrange
        Student student = new Student("first", "middle", "last", null, 7);

        // act
        student.setFullName("Harry");

        // assert
        assertEquals("Harry", student.getFullName());
    }

    @Test
    void setFullNameWithMultipleMiddleName() {
        // arrange
        Student student = new Student("first", "middle", "last", null, 7);

        // act
        student.setFullName("Harry James jamEs JAMes Potter");

        // assert
        assertEquals("Harry", student.getFirstName());
        assertEquals("James James James", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void setFullNameWithEmptyString() {
        // arrange
        Student student = new Student("First", "Middle", "Last", null, 7);

        // act
        student.setFullName("");

        // assert
        assertNull(student.getFirstName());
        assertNull(student.getMiddleName());
        assertNull(student.getLastName());
    }

    @Test
    void setFullNameWithNull() {
        // arrange
        Student student = new Student("First", "Middle", "Last", null, 7);

        // act
        student.setFullName(null);

        // assert
        assertNull(student.getFullName());
    }

    @Test
    void setNameWithSpaceAtEnd() {
        // arrange
        Student student = new Student("first", "middle", "last", null, 7);

        // act
        student.setFullName("Malte Mørkeberg ");

        //assert
        assertEquals("Malte Mørkeberg", student.getFullName());
    }

    @Test
    void setFullName() {
    }
}