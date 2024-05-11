import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int hashTableSize = 15;
        MyHashTable<StudentSpecs, Integer> hashTable = new MyHashTable<>(hashTableSize);
        for(int i = 0; i < 10000; i++){
            hashTable.put(new StudentSpecs(randomString(20), randomString(20), new Random().nextInt(40)), new Random().nextInt(10000));
        }
        System.out.println("Number of chains in each bucket: ");
        for (int i = 0; i < hashTableSize; i++){
            System.out.println(i + " Bucket: " + hashTable.getNumberOfChains(i));
        }
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