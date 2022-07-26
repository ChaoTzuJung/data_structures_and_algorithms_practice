public class List_Impl3 {
    // 這個 Node 要收進
    static class Node {
        // 當作 Node 的 value
        Integer val;
        // Node 本身要指向下一個的 Node 的位置
        Node next;

        // Node 的建構式，利用這個當作每一個節點
        public Node(int val) {
            // 用內部變數接起來
            this.val = val;
        }
    }


    // 指出開始位置
    private Node start;
    // 指出結束位置
    private Node end;

    // Linked List 建構式
    public List_Impl3() {

    }

    public void add(int val) {
        // 開頭指標目前還是 null
        if (start == null) {
            // 給一個新節點當開頭
            start = new Node(val);
            // 更新成開頭一樣的位置
            end = start;
        } else {
            end.next = new Node(val);
            // end 指標跟上
            end = end.next;
        }
    }

    public Integer search(int val) {
        // 整個 list 還是空的
        if (start == null) return null;
        // 宣告 node 變數，從開頭開始跑
        Node node = start
        // 因為不知道會跑到何時，所以用 while 回圈
        while(true) {
            // list 跑到底了 
            if (node == null) break;
            if (node.val == val) return node.val;
            node = node.next;
        }
    }

    public void remove(int val) {
        /** Step.1 search */
        Node node = start;
        Node remove_target = null;
        // for deleted
        Node node_prev = null;

        while(true) {
            if (node == null) break;
            if (node.val == val) {
                remove_target = node;
                break;
            }
            // for deleted：每次跑回圈時，下一個都要接到上一個位置
            node_prev = node;
            node = node.next;
        }

        /** Step.2 deleted */
        if (remove_target == null) return;
        // 目標結點在開頭
        if (remove_target == start) {
            // start == null
            start = start.next // 刪除開頭，且 List 連結不會斷掉
        // 目標結點在中間位置，要把目標前一個 node 接到下一個 node
        } else {
            // prev -> -> next 直接跳過要刪除的節點
            node_prev.next = remove_target.next;
        }
    }

    public static void main(String[] args) {
        /** initialize */
        List_Impl3 mylist = new List_Impl3();

        /** add O(1) - start */
        mylist.add(9);

         /** add O(1) */
        mylist.add(11);
        mylist.add(2);
        mylist.add(98);
        mylist.add(35);

        /** search O(n) */
        int val = mylist.search(98);

        /** remove O(n) */
        mylist.remove(2);
        mylist.remove(9); // remove start
        mylist.remove(35); // remove end

        System.out.println();
    }
}