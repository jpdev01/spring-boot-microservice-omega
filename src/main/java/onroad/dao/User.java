package onroad.dao;

public class User {
    private int id;
    private String login;
    private String password;
    private String permissao;
    private static User instance;

    public void User(){

    }

    public static User getInstance() {
        return instance;
    }

    public void setInstance(User instance) {
        this.instance = instance;
    }

    public User(int id, String login, String pass, String permissao){
        this.setId(id);
        this.setLogin(login);
        this.setPassword(pass);
        this.setPermissao(permissao);

        Users users = Users.getInstance();
        users.save(this);
    }

    public User(String login, String pass, String permissao){
        this.setId(generateId());
        this.setLogin(login);
        this.setPassword(pass);
        this.setPermissao(permissao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public boolean isAdm(){
        if (this.permissao == "adm"){
            return true;
        }
        return false;
    }

    public User load(int id){
        Users users = Users.getInstance();
        return users.load(id);
    }

    public int generateId(){
        Users users = Users.getInstance();
        if (users != null && users.getUsers() != null && !(users.getUsers().isEmpty())){
            return users.size() + 1;
        }
        return 1;
    }
}
