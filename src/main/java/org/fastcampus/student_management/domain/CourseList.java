package org.fastcampus.student_management.domain;

import java.util.List;

public class CourseList {
  private final List<Course> courses;

  public CourseList(List<Course> courses) {
    this.courses = courses;
  }

  // 구조 뭔가 이상한데?
  public void changeAllcourseFee(int fee){
    for(Course course:courses){
      if (course.isSameDay(DayOfWeek.SATURDAY)||course.isSameDay(DayOfWeek.SUNDAY)){
        course.chageFee((int)(fee*1.5));
      }
      course.chageFee(fee);
    }
  }
}
