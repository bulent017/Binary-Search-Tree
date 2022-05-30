import java.util.Stack;

public class MyBST {

    // Inner Class -> Only reachable by this class
    class Node {

        String familyName;
        FamilyLinkList memberList;
        Node left, right;

        public Node(String familyName) {
            this.familyName = familyName;
            left = right = null;
            memberList = new FamilyLinkList();
        }
    }

    // Root of BST
    Node root;

    // Constructor
    public MyBST() {
        root = null;
    }


    void insert(String fName, String name, int age) {
        // This method mainly inserts the family members to the Tree
        // 1-) If a family is not in the tree first you need to insert that family
        // Then you can insert the member to the memberList of that Node

        // 2-) If a family is already in the Tree
        // Then you just need to add the member to the memberList of that Node
        Node newLink = new Node(fName);
        if (root == null){
            root = newLink;
            newLink.memberList.insertNode(name,age);
        }
        else {
            Node current = root;
            while (current!=null){
                if (current.familyName.compareTo(newLink.familyName)<0){
                    if (current.right!= null){
                        current = current.right;
                    }
                    else{

                        current.right = newLink;
                        newLink.memberList.insertNode(name,age);
                        break;
                    }


                }
                else if (current.familyName.compareTo(newLink.familyName)>0){
                    if (current.left!= null){
                        current = current.left;
                    }
                    else{
                        current.left = newLink;
                        newLink.memberList.insertNode(name,age);

                        break;
                    }
                }
                else{
                    current.memberList.insertNode(name,age);

                    break;
                }

            }

        }
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // In Order Traversal of the Family Tree
    // Family names and members need to be printed according to the family tree
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("---------------------------------");
            System.out.println("Family Name: " + root.familyName);
            System.out.println("Family Members:");
            root.memberList.printLinkList();
            System.out.println("---------------------------------\n");
            inorderRec(root.right);
        }
    }


    void search(String fName, String name) {
        // An iterative search function needs to be written
        if (root == null){
            System.out.println(fName+" family is not in BST");
            return;
        }

        Node current = root;
        while (current!=null){
            if (current.familyName.compareTo(fName)<0){
                if (current.right!= null){
                    current = current.right;
                }else{
                    System.out.println(fName+" family is not in BST");
                    break;
                }
            }
            else if (current.familyName.compareTo(fName)>0){
                if (current.left!= null){
                    current = current.left;
                }
                else{
                    System.out.println(fName+" family is not in BST");
                    break;
                }
            }
            else{ // if it founded
                if (current.memberList.search(name)){
                    System.out.println(name+ " "+fName+" found in the Tree");
                    return;

                }else{
                    System.out.println(fName+" family is found BUT "+name +" not inside the Family");
                    return;
                }
            }
        }
    }



    void delete(String fName, String name) {
        // An iterative delete method will be written
        // 1- If the person is exist
        // You just need to remove the family member from the memberlist
        // Family name is not needed to be deleted from the Tree

        // 2- If person is not exist
        // Just give the correct warning message
        Node current = root;
        while (current!=null){
            if (current.familyName.compareTo(fName)<0){
                if (current.right!= null){
                    current = current.right;
                }else{
                    System.out.println(fName+" family is not in the Tree");
                    break;
                }
            }
            else if (current.familyName.compareTo(fName)>0){
                if (current.left!= null){
                    current = current.left;
                }
                else{
                    System.out.println(fName+" family is not in the Tree");
                    break;
                }
            }
            else{ // if it founded
                if (current.memberList.deleteNode(name)){
                    System.out.println(name+ " "+fName+" is deleted");
                    return;

                }else{
                    System.out.println(name+" "+fName+" is not Found in his/her family!");
                    return;
                }
            }
        }



    }

    // Is a method to show the tree
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 35;
        boolean isRowEmpty = false;
        System.out.println(
                "----------------------------------------------------------------------------------------------------");

        System.out.println("FAMILIES TREE");
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.familyName);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if (temp.left != null
                            || temp.right != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("----");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }  // end while isRowEmpty is false
        System.out.println(
                "-----------------------------------------------------------------------------------------------------");
    }  // end displayTree()

}