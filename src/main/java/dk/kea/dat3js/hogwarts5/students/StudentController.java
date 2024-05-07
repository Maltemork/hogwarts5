package dk.kea.dat3js.hogwarts5.students;

import jdk.jfr.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  // get all students
  @GetMapping
  public List<StudentResponseDTO> getAllStudents() {
    return studentService.findAll();
  }

  // get student by id
  @GetMapping("/{id}")
  public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable int id) {
    return ResponseEntity.of(studentService.findById(id));
  }

  @GetMapping(params = {"firstName", "lastName"})
  public List<StudentResponseDTO> getAllStudentsByName(@RequestParam String firstName, @RequestParam String lastName) {
    return studentService.findAllByName(firstName, lastName);
  }



  // create post, put, patch, delete methods
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequest) {
    // Assuming studentService.save() returns the saved student object
    StudentResponseDTO savedStudent = studentService.save(studentRequest);

    if (savedStudent != null) {
      return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @PutMapping("/{id}")
  public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable int id, @RequestBody StudentRequestDTO student) {
    return ResponseEntity.of(studentService.updateIfExists(id, student));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<StudentResponseDTO> partialUpdateStudent(@PathVariable int id, @RequestBody StudentRequestDTO student) {
    return ResponseEntity.of(studentService.partialUpdate(id, student));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<StudentResponseDTO> deleteStudent(@PathVariable int id) {
    return ResponseEntity.of(studentService.deleteById(id));
  }
}
