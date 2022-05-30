import java.util.Stack;

public class FamilyLinkList {

    class Node {

        public String name;
        public int age;
        public Node next;

        public Node(String name, int age) {
            this.name = name;
            this.age = age;
            this.next = null;
        }

        public String toString() {
            return "Name=" + name + ", Age=" + age;
        }
    }

    public Node head;
    public FamilyLinkList() {
        head = null;
    }


    public void insertNode(String name, int age) {
        // Inserts a node at the end of the FamilyLinkList
        Node newNode = new Node(name,age);
        if (head== null){
            head = newNode;
        }
        else{
            Node current = head;

            while (current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public boolean search(String name) {
        // Searches a name into the Family Linked Lists and returns true if found
        // false otherwise
        Node current = head;
        if (current == null){
            return false;
        }

        boolean flag = false;
        while (current!=null){
            if (name.equals(current.name)){
                flag = true;
                break;
            }
            else{
                current = current.next;
            }


        }
        return flag;

    }


    public boolean deleteNode(String name) {
        // Deletes the node from Family Link Lists
        // Return true if delete is succesful, false otherwise
        Node current = head;
        Node previous = head;
        boolean flag ;
        if (current == null){
            return false;

        }
        if (head.name.equals(name)){
            head = head.next;
            return true;
        }
        while (current!=null){
            if (current.name.equals(name)){
                break;
            }
            else {
                previous =current;
                current = current.next;
            }

        }
        if (current!= null){
            previous.next = current.next;
            flag = true;
        }else {
           flag = false;
        }

        return flag;
    }

    // Prints the FamilyLinkList
    void printLinkList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}