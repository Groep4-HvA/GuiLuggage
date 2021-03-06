package models;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ChrisvanderHeijden
 */
public class User {

    private int id;
    private String username;
    private String password;
    //aditional info
    private String name;
    private String userLang;
    private boolean isManager;
    private boolean isAppManager;

    public User() {
    }

    /**
     * Create a user with an already encryted password
     * @param username
     * @param password
     * @param name
     * @param userLang
     * @param isManager
     * @param isAppManager 
     */
    public User(String username, String password, String name, String userLang, boolean isManager, boolean isAppManager) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.userLang = userLang;
        this.isManager = isManager;
        this.isAppManager = isAppManager;
    }

    /**
     * Create a user based on a field.getPassword() this will encrypt the password
     * @param username
     * @param pass
     * @param name
     * @param userLang
     * @param isManager
     * @param isAppManager 
     */
    public User(String username, char[] pass, String name, String userLang, boolean isManager, boolean isAppManager) {
        this.username = username;
        this.password = DigestUtils.sha256Hex(String.valueOf(pass));
        this.name = name;
        this.userLang = userLang;
        this.isManager = isManager;
        this.isAppManager = isAppManager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAppManager() {
        return isAppManager;
    }

    public void setAppManager(boolean isAppManager) {
        this.isAppManager = isAppManager;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean isManager) {
        this.isManager = isManager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword(char[] password) {
        this.password = DigestUtils.sha256Hex(String.valueOf(password));
    }

    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    @Override
    public String toString() {
        return "Medewerker{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", userLang=" + userLang + ", isManager=" + isManager + ", isAppManager=" + isAppManager + '}';
    }

}
