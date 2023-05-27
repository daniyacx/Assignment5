public class Main {

        public static void main(String[] args) {
            BST<Integer, String> bst = new BST<>();

            bst.put(5, "Bangchan");
            bst.put(3, "Changbin");
            bst.put(7, "Lee Minho");
            bst.put(2, "Felix");
            bst.put(4, "Han Jisung");
            bst.put(6, "Jeongin");
            bst.put(8, "Seungmin");
            bst.put(1, "Stray Kids");

            System.out.println(bst.get(5));
            System.out.println(bst.get(2));
            System.out.println(bst.get(8));
            System.out.println(bst.get(0));
            System.out.println(bst.consistValue("Stray Kids"));
            System.out.println(bst.consistValue("I love java"));
            bst.delete(3);
            bst.delete(7);


            for (BST.Node elem : bst.iterator()) {
                System.out.println("key is " + elem.key + " and value is " + elem.val);
            }
        }
    }
