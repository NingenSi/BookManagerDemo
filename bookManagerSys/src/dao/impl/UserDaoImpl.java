package dao.impl;

import dao.BaseDAO;
import entiy.User;
import dao.UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl extends BaseDAO implements UserDao {
    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public boolean userLogin(User user){
        Connection conn = getConnection();
        String sql = "select username,pwd,type_ from t_user where username = ? and pwd = ? and type_ = ?";
        PreparedStatement preStat = null;
        ResultSet rs = null;
        try {
            preStat = conn.prepareStatement(sql);
            preStat.setString(1,user.getUsername());
            preStat.setString(2,user.getPwd());
            preStat.setInt(3,user.getType_());
            rs = preStat.executeQuery();
            while ( rs.next() ){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,preStat,rs);
        }
        return false;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public boolean register(User user){
        if (!userLogin(user)) {

            String sql = "insert into t_user values(t_userid_sq.nextval,?,?,0)";
            if(operateDML(sql,new Object[]{user.getUsername(),user.getPwd()})){
                return true;
            }

        }
        return false;
    }

    /**
     * 修改密码
     * @param user
     * @param newPwd
     * @return
     */
    @Override
    public boolean modifyPwd(User user, String newPwd){
        if (!user.getPwd().equals(newPwd)) {  //新旧密码不一样
            if (userLogin(user)) {  //用户存在并且旧密码正确
                String sql = "update t_user set pwd = ? where userName = ?";
                if (operateDML(sql, new Object[]{newPwd, user.getUsername()})) {
                    return true;
                }
            }
        }
        return false;
    }
}
