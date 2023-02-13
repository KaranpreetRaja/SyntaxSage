
import okhttp3.Request;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.util.ArrayList;

class Account{
    
    private String accountName;
    private String accountPass;
    private String UUID;
    private ArrayList<String> classes;

    //
    public Account() {
        this.accountName = "";
        this.accountPass = "";
        this.UUID = "";
        this.classes = new ArrayList<String>();
    }

    public Account(String accountName, String accountPass) {
        this.accountName = accountName;
        this.accountPass = accountPass;
        this.UUID = generateUUID();
        this.classes = new ArrayList<String>();
    }

    public static Account createAccount(String accountName, String accountPass){
        Account newAccount = new Account(accountName, accountPass);
        return newAccount;
    }

    public String getUsername() {
        return this.accountName;
    }

    public int getUUID() {
        return this.UUID;
    }

    private void setUsername(String newUsername){
        this.accountName = newUsername;
    }

    private void setPassword(String newPassword){
        this.accountPass = newPassword;
    }

    public ArrayList<String> getClasses() {
        return this.classes;
    }

    private void enrollClasses(String newClass) {
        //Check if Language exists in database first
        this.classes.add(newClass);
    }

    private void unenrollClasses(String oldClass) {
        if (this.class.contains(oldClass)) {
            this.classes.remove(oldClass);
        }
    }

    public String generateUUID() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://www.uuidtools.com/api/generate/v5/namespace/ns:url/name/https://www.uuidtools.com/generate").build();
        try{
            Response response = client.newCall(request).execute()
            return response.body().string();
        }
    }


}