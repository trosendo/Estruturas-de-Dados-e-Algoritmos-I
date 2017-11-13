public class Main {
    public static void main(String[]args){
        MailBox myMailBox = new MailBox("my_email@gmail.com");
        myMailBox.receive("sender_email@gmail.com",
                "Testing Email",
                "This is a mail inbox test message - keyword bananas and apples");
        myMailBox.receive("seender_email2@gmail.com",
                "Testing 2",
                "This is a second mail inbox test message - keyword bananasa");
        System.out.println(myMailBox.search("apple"));
    }
}
