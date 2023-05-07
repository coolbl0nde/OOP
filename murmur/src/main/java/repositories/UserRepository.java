package repositories;

import managers.UserManager;

import java.util.Map;

public class UserRepository {

    public Map<String,Object> getUserInfo(int id){
        return UserManager.getUserInfo(id);
    }
}
