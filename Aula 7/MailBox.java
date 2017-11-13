import java.util.Iterator;

public class MailBox {
    String email;
    LinkedList<String[]> inbox;
    LinkedList<String[]> trash;

    public MailBox(){
        email = "";
        inbox = new LinkedList<>();
        trash = new LinkedList<>();
    }

    public MailBox(String email){
        this.email = email;
        inbox = new LinkedList<>();
        trash = new LinkedList<>();
    }

    public void receive(String sender, String subject, String content){
        String message[] = {sender, subject, content};
        inbox.add(message);
    }

    public String showInbox(){
        if(inbox.isEmpty()){
            return "[SHOW INBOX]: Inbox is empty!";
        }
        String out = "";
        for(String[] s: inbox){
            out += String.format("Sender: %s\n\tSubject: %s\n\t\tMessage: %s\n",
                    s[0], s[1], s[2]);
        }
        return out;
    }
    public String showTrash(){
        if(trash.isEmpty()){
            return "[SHOW TRASH]: Trash is empty!";
        }
        String out = "";
        for(String[] s: trash){
            out += String.format("Sender: %s\n\tSubject: %s\n\t\tMessage: %s\n",
                    s[0], s[1], s[2]);
        }
        return out;
    }

    String readMessage(int i){
        return inbox.get(i)[2];
    }

    public void delete(int i){
        trash.add(inbox.get(i));
        inbox.removeIndex(i);
    }

    public void emptyTrash(){
        Iterator<String[]> iterator = trash.iterator();
        while(iterator.hasNext()){
            trash.removeIndex(0);
            iterator.next();
        }
    }

    public LinkedList<Integer> computeSearch(String str){
        LinkedList<Integer> out = new LinkedList<>();
        int c = 0;
        for(String[] s : inbox){
            if(s[0].contains(str) || s[1].contains(str) || s[2].contains(str)){
                out.add(c);
            }
            c++;
        }
        return out;
    }

    public String search(String str){
        LinkedList<Integer> searchResult = computeSearch(str);
        if(searchResult.isEmpty()){
           return String.format("NO MATCH FOR \"%s\"", str);
        }
        String out = "";
        String[] mail;
        for(int i : searchResult) {
            mail = inbox.get(i);
            out += String.format("Sender: %s\n\tSubject: %s\n\t\tMessage: %s\n",
                    mail[0], mail[1], mail[2]);
        }
        return out;
    }

}
