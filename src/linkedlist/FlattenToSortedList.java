package linkedlist;

public class FlattenToSortedList {

    FlattenNode head;
    public static void main(String[] args) {
        FlattenToSortedList L = new FlattenToSortedList();
        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 28);

        // flatten the list
        L.head = L.flatten(L.head);

        L.printList();

    }

   public  FlattenNode flatten(FlattenNode root){
       if (root == null || root.right == null) {
           return root;
       }
       root.right = flatten(root.right);
       MergeTwoSortedList.mergeSortedList(root, root.right);
       return root;
   }

    public void printList(){
        FlattenNode temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }

    public  FlattenNode push(FlattenNode head,int data){
        FlattenNode newNode = new FlattenNode(data);
        newNode.down = head;
        head = newNode;
        return head;
    }
}
