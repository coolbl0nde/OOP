package managers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private static DataBase dataBase = DataBase.getInstance();

    public UserManager() {
    }

    public static void addUser(int id, String name, String surname, String phoneNumber, String username, String password){
        Map<String, Object> userData = new HashMap<>();

        userData.put("id", id);
        userData.put("name", name);
        userData.put("surname", surname);
        userData.put("username", username);
        userData.put("phoneNumber", phoneNumber);
        userData.put("password", password);

        dataBase.insert(userData, "user");
    }
    public static String getName(int id){
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("name");
            }
        }

        return null;
    }

    public static void setName(String name, int id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("name", name);
                break;
            }
        }
    }

    public static String getSurname(int id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("surname");
            }
        }

        return null;
    }

    public static void setSurname(String surname, int id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("surname", surname);
                break;
            }
        }
    }

    public static String getPhoneNumber(int id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("phoneNumber");
            }
        }

        return null;
    }

    public static void setPhoneNumber(String phoneNumber, int id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("phoneNumber", phoneNumber);
                break;
            }
        }
    }

    public static String getUsername(int id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("username");
            }
        }

        return null;
    }

    public static void setUsername(String username, int id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("username", username);
                break;
            }
        }
    }

    public static String getPassword(int id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("password");
            }
        }

        return null;
    }

    public static void setPassword(String password, int id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("password", password);
                break;
            }
        }
    }

    public static Map<String, Object> getUserInfo(int id){
        List<Map<String, Object>> users = dataBase.get("user");

        for(Map<String, Object> user : users){
            if(user.get("id").equals(id)){
                return user;
            }
        }

        return null;
    }
}
