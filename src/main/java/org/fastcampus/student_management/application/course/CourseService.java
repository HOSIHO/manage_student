package org.fastcampus.student_management.application.course;

import java.util.ArrayList;
import java.util.List;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;
import org.fastcampus.student_management.repo.StudentRepository;

public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(), courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }

  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // TODO: 과제 구현 부분
    //1. 일별 수업 정보 반환:
    //    - 요일에 해당하는 수업들을 반환해야함
    //        - 요일 입력은 MONDAY, TUESDAY 와 같은 식으로 콘솔로 입력 받을 수 있어야 함
    //    - 단, 학생 상태가 비활성화 상태이면 수업을 반환해서는 안됨

    List<Course> courses = courseRepository.getCourseDayOfWeek(dayOfWeek);

    // 람다 형식의 반환의 장점 : 간결한 코드
    return courses.stream().map(CourseInfoDto::new).toList();
  }

  public void changeFee(String studentName, int fee) {
    // TODO: 과제 구현 부분
    // 3. 수강생들의 수강료를 변경 할 수 있음:
    //    - 특정 학생의 수강료를 변경 시키면 특정 학생 수업에 전체에 적용이 되어야 함

    // 반복문을 서비스 레이어에서 노출시키지 않기.
    // 테스트가 쉬워짐
    // 1급 컬렉션
    List<Course> courses = courseRepository.getCourseListByStudent(studentName);
    CourseList courseList = new CourseList(courses);
    courseList.changeAllcourseFee(fee);
  }
}
