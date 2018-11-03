package service.impl;

import entiy.Book;
import entiy.User;
import service.MenuOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuImpl implements service.Menu {


    private User user = null;
    private MenuOperation mo = null;
    private Scanner input = new Scanner(System.in);
    public MenuImpl(){
    }
    public MenuImpl(User user){
        this.user = user;
        mo = new MenuOperationImpl(this.user);
    }

    /**
     * 管理员菜单
     */
    @Override
    public void adminMenu() {
        List<Book> bookList = new ArrayList<>();
        while (true) {
            System.out.println("----------------------------------管理员菜单----------------------------------");
            System.out.println("   1.查询所有图书\n" +
                    "   2.按书名模糊查询图书\n" +
                    "   3.修改图书价格\n" +
                    "   4.添加新图书\n" +
                    "   5.删除图书\n" +
                    "   6.注册新用户\n" +
                    "   7.修改用户密码\n" +
                    "   0.退出系统\n");
            System.out.println("请选择操作!");
            switch (input.nextInt()) {

                case 1://1.查询所有图书
                    mo.queryPage(bookList);
                    break;
                case 2://2.按书名模糊查询图书
                    mo.queryByLikeBookName(bookList);
                    break;
                //endregion
                case 3://3.修改图书价格
                    mo.modifyBook();
                    break;
                case 4://添加图书
                    mo.addBook();
                    break;
                case 5://4.删除图书
                    mo.deleteBook();
                    break;
                case 6://5.注册新用户
                    mo.registerNewUser();
                break;
                case 7://6.修改用户密码
                    mo.modifyPwd();
                    break;
                case 0:
                    System.exit(0);
            }
        }


    }

    /**
     * 普通用户菜单
     */
    @Override
    public void normalMenu() {
        List<Book> bookList = new ArrayList<>();
        while (true) {
            System.out.println("----------------------------------普通用户菜单----------------------------------");
            System.out.println("   1.查询所有图书\n" +
                    "   2.按书名模糊查询图书\n" +
                    "   3.注册新用户\n" +
                    "   4.修改用户密码\n" +
                    "   0.退出系统\n");
            System.out.println("请选择操作!");
            switch (input.nextInt()) {
                case 1://1.查询所有图书
                    //region 查询所有图书
                    mo.queryPage(bookList);
                    break;
                case 2://2.按书名模糊查询图书
                    mo.queryByLikeBookName(bookList);
                    break;
                case 3://注册新用户
                    mo.registerNewUser();
                    break;
                case 4://修改密码
                    mo.modifyPwd();
                    break;

            }
        }
    }



}
