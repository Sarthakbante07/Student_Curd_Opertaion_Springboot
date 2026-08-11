package in.striker.curdSpringBootDemo.Controller;

import in.striker.curdSpringBootDemo.Service.StudentService;
import in.striker.curdSpringBootDemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

       Student createdStudent =  studentService.createStudent(student);

       return ResponseEntity
               .status(HttpStatus.CREATED) //restonse positive bhejne ke liye
               .body(createdStudent); //jsx to json mai convert hota hai
    }

    //Read Student

    @GetMapping("/get/{Id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long Id){
        Student studentResp = studentService.getStudent(Id);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    //getAll
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getStudent(){

        List<Student> studentList = studentService.getAllStudent();

        if(studentList == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }

    //Update Student

    @PutMapping("/update/{Id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long Id ,
                                              @RequestBody Student studentreq){
        Student studentResp = studentService.updateStudent(Id, studentreq);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    //Delete Student

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long Id){
        Boolean isdeleted = studentService.deleteStudent(Id);
    if(!isdeleted){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(true);
    }
}
