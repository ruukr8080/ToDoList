package portfolio.taskservice;

import java.io.File;
import java.time.LocalDateTime;

public class TaskData {
    // 유저가 태스크의 속성(완수 조건)을 정의함
    // '' = 없음
    String completionCriteria;
    Boolean completed;

    // 유저가 태스크의 속성(완수 실패 시 행위 - 에정된 다음 태스크를 미루고 반복)를 정의함
    Boolean delayAndRepeat;

    // 유저가 태스크의 속성(완수 실패 시 행위 - 연결된 다음 태스크를 취소)를 정의함
    Boolean cancelLinked;

    // 유저가 태스크의 이름을 정의함
    String definedName;

    // 유저가 태스크 수행에 필요한 시간을 정의함
    LocalDateTime stdDateTime;
    LocalDateTime endDateTime;

    // 유저가 input을 정의함. input은 task 수행 종료 시 output이 됨. output은 다음 작업의 input이 될 수 있음.
    File deliverableState;
}
