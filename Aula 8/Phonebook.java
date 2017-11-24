import java.util.Scanner;

public class Phonebook extends BinarySearchTree {
    BinarySearchTree<Contact> phonebook;
    int size;

    Phonebook(Contact user){
        phonebook = new BinarySearchTree<>(user);
        size = 1;
    }
    Phonebook(){
        phonebook = new BinarySearchTree<>();
        size = 0;
    }

    public void insertIntoExisting(String name, String number){
        Contact temp = phonebook.getElement(new Contact(name));
        if(temp != null){
            temp.addNumber(number);
            System.out.printf("Phone number %s successfully added to contact %s \n", number, name);
        }else{
            System.out.printf("Contact %s doesn't exists!\n", name);
        }
    }
    public void insertIntoExisting(String name, BinarySearchTree<String> numbers){
        while(!numbers.isEmpty()){
            String min = numbers.findMin();
            insertIntoExisting(name, min);
            numbers.remove(min);
        }
    }

    public void insert(Contact contact){
        if(!phonebook.contains(contact)) {
            phonebook.insert(contact);
            size++;
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("\nContact %s already exists!\n" +
                            "Do you wish to add the following number/numbers into the existing contact?\n",
                    contact.name);
            contact.phoneNumbers.printInOrder();
            System.out.print("(Yes or No): ");
            String input = scanner.next();
            if(input.equalsIgnoreCase("yes"))
                insertIntoExisting(contact.name, contact.phoneNumbers);

        }
    }

    public void remove(String name){
        phonebook.remove(phonebook.getElement(new Contact(name)));
        size--;
    }

    public void getNumbers(String name){
        phonebook.getElement(new Contact(name)).getNumbers();
    }

    public String getCallerID(String callerNumber){
        for(Contact x : phonebook){
            if(x.phoneNumbers.contains(callerNumber))
                return x.name;
        }
        return callerNumber;
    }

    public int getSize(){
        return size;
    }
}
