package com.OnlineExaminationSystem.App.service;

import com.OnlineExaminationSystem.App.entity.users.Student;
import com.OnlineExaminationSystem.App.exceptions.ApiException;
import com.OnlineExaminationSystem.App.repository.StudentRepository;
import com.OnlineExaminationSystem.App.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;


    public Student addAndUpdateStudent(Student student) {

        if (this.userRepository.findUserByEmail(student.getEmail()).isPresent()) {
            throw new ApiException("Duplicate Email");
        }
        this.studentRepository.save(student);

        return student;
    }

    public void deleteById(Long studentId) {
        Student student = this.studentRepository.findStudentById(studentId)
                .orElseThrow(() -> new ApiException("Student not found"));
        this.studentRepository.deleteById(studentId);
    }

    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        Student student = this.studentRepository.findStudentById(studentId)
                .orElseThrow(() -> new ApiException("Student not found"));
        return student;
    }


}
