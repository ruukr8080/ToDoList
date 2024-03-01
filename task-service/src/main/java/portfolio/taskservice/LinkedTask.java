package portfolio.taskservice;

import java.util.List;
import java.util.NoSuchElementException;

public class LinkedTask<TaskData> implements List<TaskData> {
    private TaskNode<TaskData> head;
    private TaskNode<TaskData> tail;
    private int size;

    public LinkedTask() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 특정 인덱스의 태스크 노드 반환
    private TaskNode<TaskData> search(int idx) {

        // 범위 밖으로 벗어나면 예외 던짐
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 뒤에서부터 검색
        if (idx + 1 > size / 2) {
            TaskNode<TaskData> x = tail;
            for (int i = size - 1; i > idx; i--) {
                x = x.prev;
            }
            return x;
        }

        // 앞에서부터 검색
        else {
            TaskNode<TaskData> x = head;
            for (int i = 0; i < idx; i++) {
                x = x.next;
            }
            return x;
        }
    }

    public void addFirst(TaskData value) {
        TaskNode<TaskData> newNode = new TaskNode<TaskData>(value); // 새 노드 생성
        newNode.next = head; // 새 노드의 다음 노드로 head 노드를 연결

        /**
         * head가 null이 아닐 경우에만 기존 head노드의 prev 변수가
         * 새 노드를 가리키도록 한다.
         * 이유는 기존 head노드가 없는 경우(null)는 데이터가
         * 아무 것도 없던 상태였으므로 head.prev를 하면 잘못된 참조가 된다.
         */

        if(head != null) {
            head.prev = newNode;
        }

        head = newNode;
        size++;

        /**
         * 다음에 가리킬 노드가 없는 경우(=데이터가 새 노드밖에 없는 경우)
         * 데이터가 한 개(새 노드)밖에 없으므로 새 노드는 처음 시작노드이자
         * 마지막 노드다. 즉 tail = head 다.
         */
        if (head.next == null) {
            tail = head;
        }
    }

    @Override
    public boolean add (TaskData value) {
        addLast(value);
        return true;
    }

    public void addLast(TaskData value) {
        TaskNode<TaskData> newNode = new TaskNode<TaskData>(value); // 새 노드 생성

        if (size==0) { // 처음 넣는 노드일 경우 addFirst로 추가
            addFirst(value);
            return;
        }

        /**
         * 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 하고
         * tail이 가리키는 노드를 새 노드로 바꿔준다.
         */
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void add(int idx, TaskData value) {

        // 잘못된 인덱스를 참조할 경우 예외 발생
        if (idx > size || idx < 0 ) {
            throw new IndexOutOfBoundsException();
        }

        // 추가하려는 idx가 가장 앞에 추가하려는 경우 addFist 호출
        if (idx == 0) {
            addFirst(value);
            return;
        }

        // 추가하려는 idx가 마지막 위치일 경우 addLast 호출
        if (idx == size) {
            addLast(value);
            return;
        }

        // 추가하려는 위치 이전 노드
        TaskNode<TaskData> prevNode = search(idx -1);

        // 추가하려는 위치의 노드
        TaskNode<TaskData> nextNode = prevNode.next;

        // 추가하려는 노드
        TaskNode<TaskData> newNode = new TaskNode<TaskData>(value);

        // 링크 끊기
        prevNode.next = null;
        nextNode.next = null;

        // 링크 연결
        prevNode.next = newNode;

        newNode.prev = prevNode;
        newNode.next = nextNode;

        nextNode.prev = newNode;
        size++;
    }

    public TaskData remove() {
        TaskNode<TaskData> headNode = head;

        if (headNode == null) {
            throw new NoSuchElementException();
        }

        // 삭제된 노드를 반환하기 위한 임시 변수
        TaskData elem = headNode.data;

        // head의 다음 노드
        TaskNode
    }
}
