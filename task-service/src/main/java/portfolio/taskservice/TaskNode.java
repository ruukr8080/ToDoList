package portfolio.taskservice;

public class TaskNode<TaskData> {

    TaskData data;
    TaskNode<TaskData> prev; // 다음 노드 객체를 가리키는 레퍼런스 변수
    TaskNode<TaskData> next; // 이전 노드 객체를 가리키는 레퍼런스 변수

    TaskNode(TaskData data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
