package linkedlist;

public class CloningWithRandomRef {

    /*
    * create new node with random and next ref
    * then insert into middle
    * */
    public RandomListNode cloneNextNodeInMiddle(RandomListNode head1){
        RandomListNode temp = head1;
        RandomListNode newNode;
        RandomListNode currNode;
        while (temp != null){
            currNode = temp.next;
            newNode = new RandomListNode(temp.data,temp.random,null);
            temp.next = newNode;
            newNode.next = currNode;
            temp = currNode;
        }
        return head1;
    }

    public RandomListNode cloneRandomNodeOfMiddle(RandomListNode head1){
        RandomListNode newHeadTemp = head1.next;
        RandomListNode currNode;
        while (newHeadTemp != null){
            currNode = newHeadTemp.next;
            newHeadTemp.random = newHeadTemp.random.next;
            if(currNode == null){
                break;
            }
            newHeadTemp = currNode.next;
        }
        return head1;
    }

    /*
    * 2. move tempHead1 if it is null then break loop
    * 3. move tempNewHead till tempNewHead is null
    * */
    public RandomListNode getClonedListHead(RandomListNode newListHead){
        RandomListNode newHead = newListHead.next;
        RandomListNode tempOfNewHead = newHead;
        RandomListNode tempOfHead = newListHead;
        while (tempOfNewHead != null){
            tempOfHead.next = tempOfNewHead.next;
            tempOfHead = tempOfHead.next;
            if(tempOfHead == null){
                break;
            }
            tempOfNewHead.next = tempOfHead.next;
            tempOfNewHead = tempOfNewHead.next;
        }
        return newHead;
    }


    /*
    * insert node in middle (val,random,null)
    * clone random ref in newly inserted node
    * then unlink the newly created node and return it's head
    * */
    public RandomListNode copyListUsingNextRefCopy(RandomListNode head1){
        if(head1 == null){
            return null;
        }
        RandomListNode newListHead = cloneNextNodeInMiddle(head1);
        newListHead = cloneRandomNodeOfMiddle(newListHead);
        return getClonedListHead(newListHead);
    }

    public void displayNode(RandomListNode head){
        RandomListNode temp = head;
        while (temp != null){
            System.out.println("val : "+temp.data+" random : "+temp.random.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        RandomListNode node4 = new RandomListNode(4,null,null);
        RandomListNode node3 = new RandomListNode(3,null,node4);
        RandomListNode node2 = new RandomListNode(2,null,node3);
        RandomListNode node1 = new RandomListNode(1,null,node2);
        RandomListNode head = node1;
        node1.random = node3;
        node2.random = node4;
        node3.random = node2;
        node4.random = node1;


        CloningWithRandomRef cloningWithRandomRef = new CloningWithRandomRef();
        System.out.println("display original list :");
        cloningWithRandomRef.displayNode(head);
        RandomListNode newHead = cloningWithRandomRef.copyListUsingNextRefCopy(head);
        System.out.println("print cloned list :");
        cloningWithRandomRef.displayNode(newHead);
        System.out.println("after cloing display original list :");
        cloningWithRandomRef.displayNode(head);
    }
}
