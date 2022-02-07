package ATM.Class;

import ATM.Enter.Language;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ArraysClass {

    public static Vector<Integer> accountsVector = new Vector<Integer>();
    public static Vector<Integer> passwords1Vector = new Vector<Integer>();
    public static Vector<Integer> passwords2Vector = new Vector<Integer>();
    public static Vector<Integer> balanceVector = new Vector<Integer>();
    public static Vector<String> firstNamesVector = new Vector<String>();
    public static Vector<String> lastNamesVector = new Vector<String>();
    public static Vector<Boolean> accessVector = new Vector<Boolean>();
    //creating vectors for each parameter

    //public int language;
    // 0 = English & 1 = Persian
    //the value is assigned in the language(main) frame
    //and it is given to every frame for changing the language if necessary
    public static int adminPass = 123456;

    public static int user;
    //the value is assigned in the authentication frame and in some frames in admin's manu

    public static int u;
    //gets the index of user's account number
    //public int u = 4;

    int r = accountsVector.size();
    //gets the number of users

    public void defaultAccounts() {
        newUser("محک", "خیریه", 123456789, 100000, 1010, 101010);
        newUser("a", "aa", 123456, 1600, 1111, 111111);
        newUser("b", "bb", 654321, 3200, 2222, 222222);
        newUser("c", "cc", 987654, 6400, 3333, 333333);
        newUser("d", "dd", 456789, 12800, 4444, 444444);
        // it makes some defult users 
        // it is called in the language frame
    }

    public void ui(int userEnter){
        user=userEnter;
        u = accountsVector.indexOf(user);
        
    }
    
    public static void newUser(
            String firstName, String lastName, Integer accountNumber,
            Integer accountBalance, Integer password1, Integer password2) {

        if (accountsVector.contains(accountNumber)) {
            JOptionPane.showMessageDialog(null, "the number exists already");
            //check if the account number doesn't exist already
        } else {
            accountsVector.addElement(accountNumber);
            firstNamesVector.addElement(firstName);
            lastNamesVector.addElement(lastName);
            balanceVector.addElement(accountBalance);
            passwords1Vector.addElement(password1);
            passwords2Vector.addElement(password2);
            accessVector.addElement(true);

            //adds a new user to each of the vectors
        }
    }

    public static int searchPass1() {
        int result = passwords1Vector.elementAt(u);
        return result;
        // returns user's password1 for authentication

    }

    public static void changePass1(int i) {
        passwords1Vector.setElementAt(u, i);
        // gets the new password1
        //changes the password1 of the index that it gets by searching for the user's account number
    }

    public static void changePass2(int i) {
        passwords2Vector.setElementAt(u, i);
        // gets the new password2
        //changes the password2 of the index that it gets by searching for the user's account number
    }

    public static int searchbalance() {
        int result = balanceVector.get(u);
        return result;
        //returns the balance of the index that it gets by searching for the users's account number
    }

    public static void changeBalance(int i) {
        balanceVector.setElementAt(u, i);
        //gets the new balance
        //changes the balance of the index that it gets by searching for the users's account number
    }

    public static String searchName(int i) {
        String result = firstNamesVector.get(i) + "  " + lastNamesVector.get(i);
        return result;
        //gets the account number of the user who is receiving money
        // returns the first name and last name
    }

    public static void transferMoney(int acc, int amount) {
        int u = accountsVector.indexOf(acc);
        int old = balanceVector.get(u);
        balanceVector.setElementAt(u, (old + amount));
        // gets the account number of the user who is receiving money
        // changes the balance of reciever
    }

    public static boolean getAccess() {
        boolean result = accessVector.get(u);
        return result;
    }

    public static void changeAccess(boolean j) {
        accessVector.setElementAt(j, u);
        // recieves the condition
        // changes the condition of the index that it gets by searching for the user's account number
    }

}
