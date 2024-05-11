public class Main {
    public static void main(String[] args) {
        MyBST<Integer, String> bst = new MyBST<>();
        bst.put(8, "eight");
        bst.put(3, "three");
        bst.put(10, "ten");
        bst.put(1, "one");
        bst.put(6, "six");
        bst.put(14, "fourteen");
        bst.put(13, "thirteen");
        bst.put(4, "four");
        bst.put(7, "seven");

        for (Pair<Integer, String> pair : bst.iterator()) {
            System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
        }
        System.out.println(bst.get(3));
    }
}