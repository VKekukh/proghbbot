package ua.kiev.prog.proghbbot.user;

public class ChatUser {

    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String languageCode;

    public ChatUser() {
    }

    public ChatUser(int id, String firstName, String lastName, String userName, String languageCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.languageCode = languageCode;
    }

    public int getId() {
        return id;
    }

    public ChatUser setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ChatUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ChatUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ChatUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public ChatUser setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    @Override
    public String toString() {
        return "ChatUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }
}
