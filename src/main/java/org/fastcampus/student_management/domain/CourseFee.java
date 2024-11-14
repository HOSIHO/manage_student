package org.fastcampus.student_management.domain;

public class CourseFee {



  // VO exception 사용시 재사용 가능 , 확인하기 쉬움
  private int fee;

  public CourseFee(int fee) {
    this.fee = fee;
  }


  public void changeFee(int fee){
    this.fee=fee;
  }
  public void checkFee(int fee){
    if (fee<0){
      throw new IllegalArgumentException("수강료는 0원 이상이어야 함");
    }
  }

  public int getFee() {
    return fee;
  }

}
