package dk.kea.dat3js.hogwarts5.teachers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    void notNull() {
        assertNotNull(webClient);
    }

    @Test
    void createStudentWithFullName() {
        webClient
                .post().uri("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("""
                        {
                            "name": "Peter Heronimous Lind",
                            "house": "Gryffindor",
                            "schoolYear": 7
                        }
                        """)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").exists()
                .jsonPath("$.firstName").isEqualTo("Peter")
                .jsonPath("$.middleName").isEqualTo("Heronimous")
                .jsonPath("$.lastName").isEqualTo("Lind")
                .jsonPath("$.house").isEqualTo("Gryffindor")
                .jsonPath("$.schoolYear").isEqualTo(7);
        ;
    }
}
