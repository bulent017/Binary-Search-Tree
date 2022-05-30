public class Main {

    public static void main(String[] args) {
        MyBST bst = new MyBST();

        System.out.println("-----------------------------------------------");
        System.out.println("1)INSERT Operations ");
        System.out.println("-----------------------------------------------");

        bst.insert("Malling", "Noel", 30);
        bst.insert("Malling", "Oralia", 25);
        bst.insert("Stagge", "Irvin", 22);
        bst.insert("Fremantle", "Sibyl", 44);
        bst.insert("Billington", "Tracie", 65);
        bst.insert("Stagge", "Patton", 20);
        bst.insert("Tiddeman", "Phaidra", 12);
        bst.insert("Billington", "Derril", 6);
        bst.insert("Cancellieri", "Viviana", 25);
        bst.insert("Stagge", "Josephina", 88);
        bst.insert("Malling", "Cathrine", 68);
        bst.insert("Fremantle", "Veradis", 50);
        bst.insert("McDavitt", "Bryce", 64);
        bst.insert("Tiddeman", "Salome", 42);
        bst.insert("Malling", "Abey", 43);
        bst.insert("Kirkhouse", "Niko", 55);

        bst.displayTree();
        bst.inorder();

        System.out.println("-----------------------------------------------");
        System.out.println("2)SEARCH Operations ");
        System.out.println("-----------------------------------------------");

        bst.search("Malling", "Oralia");
        bst.search("Malling", "Veradis");
        bst.search("Hamilton", "Alfred");
        bst.search("Malling", "Abey");

        System.out.println("-----------------------------------------------");
        System.out.println("3)DELETE Operations ");
        System.out.println("-----------------------------------------------");


        bst.delete("Billington", "Tracie");
        bst.delete("Malling", "Oralia");
        bst.delete("Malling", "Abey");

        bst.delete("Hamilton", "Alfred");
        bst.delete("Malling", "Abey");
        bst.delete("Malling", "Veradis");
        bst.inorder();
    }
}