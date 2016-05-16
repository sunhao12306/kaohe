package main;

import entity.ShuJu;
import service.Service;

import java.util.Scanner;

/**要求：1. 编写一个app,其表现为一个终端程序,并始终在终端输出一个提示.如 [root@shuyun ~]# ,等待使用者输入数据
 2. 使用者通过在提示后面输入相应的指令,并回车,然后程序接收到相应的指令之后,执行特定的操作,并显示相应的操作结果(或响应).然后,隔行,再输出相应的提示.
 3. 如果在提示后面输入 exit,则程序响应 logout,并成功退出
 4. 如果相应的指令不符合要求,则提示指令错误(如果可能,提示指令错误的地点及原因)
 #### 具体指令列表
 1. select [--column c1,c2] [--condition c1 c2] [--order o1,o2]
 2. update [expr1,expr2] [--condition c1 c2]
 3. delete [--condition c1 c2]
 4. insert values v1,v2,v3,v4
 5. insert (c1,c2) values(v1,v2)
 6. dump filename
 7. sync

 * Created by hao on 2016/5/12.
 */
public class Kaohe {
    public static void main(String[] args) {
        Service sc = new Service();
        Scanner sn = new Scanner(System.in);
        sc.readShuJu();
        String shuju = sn.nextLine();


        String a[] = shuju.split(" ");
        if (a[0].equals("select")) {

        } else if (a[0].equals("update")) {

        } else if (a[0].equals("delect")) {

        } else if (a[0].equals("insert")) {

        }else if (a[0].equals("dump")){

        }else{
            //       sc.saveShuJu(shuju);
        }
    }
}