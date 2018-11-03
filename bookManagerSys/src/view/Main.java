package view;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entiy.User;
import service.Menu;
import service.impl.MenuImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        Scanner input = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("请选择登录身份(:");
            System.out.println("1:管理员   0:普通用户");
            user.setType_(input.nextInt());
            System.out.println("请输入用户名:");
            user.setUsername(input.next());
            System.out.println("请输入密码;");
            user.setPwd(input.next());
            if (userDao.userLogin(user)) {
                break;
            }else {
                count++;
                System.out.println("登录失败("+ count +"次)！请检查账户密码以及正确身份！");
            }
            if (count > 2){
                System.out.println("失败次数过多！程序退出！");
                System.exit(1);
            }
        }
        Menu menu = new MenuImpl(user);
        switch (user.getType_()) {
            case 0:
                menu.normalMenu();
                break;
            case 1:
                menu.adminMenu();
                break;
        }
    }

}
