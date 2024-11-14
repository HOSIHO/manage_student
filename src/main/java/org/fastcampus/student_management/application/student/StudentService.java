package org.fastcampus.student_management.application.student;

import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.StudentRepository;

public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void saveStudent(StudentInfoDto studentInfoDto) {
    Student student = new Student(studentInfoDto.getName(), studentInfoDto.getAge(), studentInfoDto.getAddress());
    studentRepository.save(student);
  }

  public Student getStudent(String name) {
    return studentRepository.findByName(name)
        .orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));
  }

  public void activateStudent(String name) {
    // TODO: 과제 구현 부분
    //2. 수강생들의 상태를 변경 할 수 있음:
    //    - 학생이 활성 상태 일 때에는 일별 수업에서 포함이 되어야 함
    //    - 학생이 비활성 상태일 때에는, 일별 수업에 포함되서는 안 됨
    //    - 활동 상태에서 활동 상태로, 비활성 상태에서 비활성 상태로 변경이 되어서는 안 됨

    Student student = getStudent(name);
    student.activate();


  }

  public void deactivateStudent(String name) {
    // TODO: 과제 구현 부분
    //2. 수강생들의 상태를 변경 할 수 있음:
    //    - 학생이 활성 상태 일 때에는 일별 수업에서 포함이 되어야 함
    //    - 학생이 비활성 상태일 때에는, 일별 수업에 포함되서는 안 됨
    //    - 활동 상태에서 활동 상태로, 비활성 상태에서 비활성 상태로 변경이 되어서는 안 됨
    Student student = getStudent(name);
    student.deactivate();

  }
}
