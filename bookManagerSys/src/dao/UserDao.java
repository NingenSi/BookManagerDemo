package dao;

import entiy.User;

public interface UserDao {
    boolean userLogin(User user);

    boolean register(User user);

    boolean modifyPwd(User user, String newPwd);
}
