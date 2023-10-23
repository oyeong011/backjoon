package backjoon;

public class ex1158 {
    class ListNode{
        private String data; // 데이터 저장 변수
        public ListNode link; // 다른 노드를 참조할 변수

        public ListNode(){
            this.data = null;
            this.link = null;
        }
        public ListNode(String data){
            this.data = data;
            this.link = null;
        }
        public ListNode(String data, ListNode link){
            this.data = data;
            this.link = link;
        }

        public String getData(){
            return this.data;
        }
    }
    public class LinkedList{
        private ListNode head;

        public LinkedList(){
            head = null;
        }
         
        public void insertNode(ListNode preNode, String data){
            ListNode newNode = new ListNode(data);
            
            newNode.link = preNode.link;
            preNode.link = newNode;
        }
        public void insertNode(String data){
            ListNode newNode = new ListNode(data);
            if(head==null){
                this.head = newNode;
            } else {
                ListNode tempNode = head;

                while(tempNode.link!=null){
                    tempNode = tempNode.link;
                }
                tempNode.link = newNode;
            }
        }
        
    }
}
