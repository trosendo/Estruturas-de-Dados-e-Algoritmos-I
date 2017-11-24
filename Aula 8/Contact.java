public class Contact implements Comparable<Contact> {
    String name;
    BinarySearchTree<String> phoneNumbers;

    Contact(String name, String phoneNumber){
        this.name = name;
        phoneNumbers = new BinarySearchTree<>(phoneNumber);
    }
    Contact(String name){
        this.name = name;
        phoneNumbers = new BinarySearchTree<>();
    }

    public void addNumber(String number){
        phoneNumbers.insert(number);
    }

    public void getNumbers(){
        phoneNumbers.printInOrder();
    }

    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }

    public String toString(){
        return name;
    }

}
