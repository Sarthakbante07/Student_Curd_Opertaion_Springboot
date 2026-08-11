package in.striker.curdSpringBootDemo.Service;

import in.striker.curdSpringBootDemo.entity.Student;
import in.striker.curdSpringBootDemo.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

public StudentService(StudentRepository studentRepository){
    this.studentRepository = studentRepository;
}

    public Student createStudent(Student studentReq) {


        Student studentResp = studentRepository.save(studentReq);

        return studentResp;
    }


    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findById(id);

        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudent() {
    List<Student> studentList = studentRepository.findAll();
    return  studentList;
    }

    public Student updateStudent(Long id, Student studentreq) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }
      Student studentToSave = existingStudent.get();

        studentToSave.setName(studentreq.getName());
        studentToSave.setEmail(studentreq.getEmail());
        studentToSave.setAge(studentreq.getAge());
        studentToSave.setRollNo(studentreq.getRollNo());
        studentToSave.setSubject(studentreq.getSubject());

        return  studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id) {
    Boolean isstudent = studentRepository.existsById(id);
    if(!isstudent) return false;

    studentRepository.deleteById(id);
    return true;
}
}
