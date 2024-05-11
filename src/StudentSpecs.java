public class StudentSpecs {
    private String name;
    private String surname;
    private int age;
    StudentSpecs(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public int hashCode(){
        int hash = 0;
        for(int i = 0; i < name.length(); i++){
            hash = name.toCharArray()[i] + (hash * 31);
        }
        for(int i = 0; i < surname.length(); i++){
            hash = surname.toCharArray()[i] + (hash * 31);
        }
        hash += age;
        return hash;
    }
}
