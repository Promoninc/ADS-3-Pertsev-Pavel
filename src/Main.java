import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("MyHashTable Section \n");
        int hashTableSize = 15;
        MyHashTable<StudentSpecs, Integer> hashTable = new MyHashTable<>(hashTableSize);
        for(int i = 0; i < 10000; i++){
            hashTable.put(new StudentSpecs(randomString(20), randomString(20), new Random().nextInt(40)), new Random().nextInt(10000));
        }
        System.out.println("Number of chains in each bucket: ");
        for (int i = 0; i < hashTableSize; i++){
            System.out.println(i + " Bucket: " + hashTable.getNumberOfChains(i));
        }
        System.out.println("\nMyBST Section \n");

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
        bst.delete(7);
        bst.delete(4);
        for (var elem : bst.iterator()) {
            System.out.println("Key: " + elem.getKey() + ", Value: " + elem.getValue());
        }
        System.out.println(bst.get(3));
    }
    public static String randomString(int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 20; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
