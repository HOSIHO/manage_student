# 수강생 관리 프로그램

## 프로그래밍 요구사항

- **아래 수강생 관리 유즈케이스를 설계한 것을 바탕으로 설계 후에 객체지향 프로그래밍을 작성해주세요.**
    - 단, 구현 해야할 코드는 domain, application 패키지 내부만 수정해서 구현해야 합니다.
- **자바 코드 컨벤션을 지키면서 프로그래밍 해주세요.**
    - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
    - [Intellij 에 Google Java Style 적용 시키기](https://www.notion.so/Intellij-Google-Java-Style-ea91a00678014af68125209bb0caf50c?pvs=21)
- **함수는 최대한 하나의 일만 하도록 만들기**
- **참고 자료**
    - [vo](https://tecoble.techcourse.co.kr/post/2020-06-11-value-object/)
    - [1급 컬렉션](https://f-lab.kr/insight/understanding-and-applying-first-class-collections?gad_source=1&gclid=CjwKCAjwjeuyBhBuEiwAJ3vuoYK-xFTSYwyHPJ9QW6hr6D2l3nr8HVRpkG8F6RrpE3oMBS4KeS1xUBoC0mIQAvD_BwE)
    - [객체지향 생활체조](https://jamie95.tistory.com/99)

## **유즈케이스 - 과외 수강생 관리 프로그램 구현 기능**

1. 일별 수업 정보 반환:
    - 요일에 해당하는 수업들을 반환해야함
        - 요일 입력은 MONDAY, TUESDAY 와 같은 식으로 콘솔로 입력 받을 수 있어야 함
    - 단, 학생 상태가 비활성화 상태이면 수업을 반환해서는 안됨
2. 수강생들의 상태를 변경 할 수 있음:
    - 학생이 활성 상태 일 때에는 일별 수업에서 포함이 되어야 함
    - 학생이 비활성 상태일 때에는, 일별 수업에 포함되서는 안 됨
    - 활동 상태에서 활동 상태로, 비활성 상태에서 비활성 상태로 변경이 되어서는 안 됨
3. 수강생들의 수강료를 변경 할 수 있음:
    - 특정 학생의 수강료를 변경 시키면 특정 학생 수업에 전체에 적용이 되어야 함
