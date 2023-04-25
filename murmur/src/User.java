import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class User {
    private int id;
    private DataBase dataBase;
    private static DataBase staticDataBase;

    public User(String name, String surname, String phoneNumber, String username, String password, DataBase dataBase) {
        this.id = new Random().nextInt();

        staticDataBase = dataBase;
        this.dataBase = dataBase;
        this.dataBase.addUser(this.id, name, surname, phoneNumber, username, password);

    }

    public int getId(){
        return this.id;
    }

    public String getName() {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                return (String)user.get("name");
            }
        }

        return null;
    }
    static public String getName(int id){
        List<Map<String, Object>> userList = staticDataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("name");
            }
        }

        return null;
    }

    public void setName(String name) {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                user.put("name", name);
                break;
            }
        }
    }

    public String getSurname() {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                return (String)user.get("surname");
            }
        }

        return null;
    }

    public void setSurname(String surname) {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                user.put("surname", surname);
                break;
            }
        }
    }

    public String getPhoneNumber() {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                return (String)user.get("phoneNumber");
            }
        }

        return null;
    }

    public void setPhoneNumber(String phoneNumber) {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                user.put("phoneNumber", phoneNumber);
                break;
            }
        }
    }

    public String getUsername() {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                return (String)user.get("username");
            }
        }

        return null;
    }

    public void setUsername(String username) {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                user.put("username", username);
                break;
            }
        }
    }

    public String getPassword() {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                return (String)user.get("password");
            }
        }

        return null;
    }

    public void setPassword(String password) {
        List<Map<String, Object>> userList = dataBase.getUsersList();

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(this.id)) {
                user.put("password", password);
                break;
            }
        }
    }
}