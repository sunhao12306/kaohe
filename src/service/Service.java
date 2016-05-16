package service;

import entity.ShuJu;
import sun.security.util.Length;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 #### 指令详细说明
 1. 指令中的[]表示此条件是可选项,如select 和 select --column c1,c2 均为正常的
 2. 指令中的,表示此条件可能有多个,每个条件以逗号(半角)分隔 如select --column id 和 select --column id,name.前者表示选择id,后者表示选择id和name
 3. 语句中的字符串必须以'开头,'结尾,否则提示相应的语句错误,在解析时将相应的''去除
 4. 每次操作时均实际操作同一份数据,即多个指令会对数据有不同的影响
 8. dump
 按照 select * --order name,score 的格式输出所有数据至指定文件.文件中由dump后面的参数得出.
 输出数据中包括行头
 返回信息,导出数据至文件{filename}成功
 9. sync
 将当前的数据,重新同步至原数据文件,并按id值排序,包括行头
 * Created by hao on 2016/5/12.
 */
public class Service {
    ShuJu shuJu=new ShuJu();
    List<ShuJu> shuJus = new ArrayList<>();
    List  list =new ArrayList<>();
    Scanner keyBoard = new Scanner(System.in);
    /**
     * 读取数据
     */
    public  void  readShuJu()  {
        try {
            File file = new File("C:\\Users\\hao\\Desktop\\data.txt");
            BufferedReader bufferedReader =  new BufferedReader(new FileReader(file));
            bufferedReader.readLine();
            String s;
            while (( s = bufferedReader.readLine()) != null){
                String[] shuJu1= s.split(" ");
                ShuJu shuJu2 = new ShuJu();
                shuJu2.setId(Integer.parseInt(shuJu1[0]));
                shuJu2.setName(shuJu1[1]);
                shuJu2.setSubject(shuJu1[2]);
                shuJu2.setScore(Integer.parseInt(shuJu1[3]));
                shuJu2.setAdvisor(shuJu1[4]);
                shuJus.add(shuJu2);
            }
            bufferedReader.close();
            for(ShuJu  shuJu :shuJus){
                System.out.println(shuJu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *存数据
     */
    public  void saveShuJu(String str){
        try {
            File file = new File("C:\\Users\\hao\\Desktop\\data.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
//            String shuJu="id name subject score advisor";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "1 张三 C 90 [A,B]";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "3 张三 C# 91 [C]";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "6 李四 JAVA 80 [D]";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "8 李四 C# 83 [A,C]";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "10 李四 SQL 84 [E]";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "16 王五 LINUX 86 [A,B,C]";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "18 王五 SCRIPT 88 []";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "19 张三 JAVA 89 [B]";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "21 李四 C 91 [A,D]";bufferedWriter.write(shuJu);bufferedWriter.newLine();
//            shuJu = "23 张三 SQL 101 [X]";bufferedWriter.write(shuJu);bufferedWriter.newLine();
          String shuJu=str;bufferedWriter.write(str);bufferedWriter.newLine();
            System.out.println("写入成功！");
           // list.add(ShuJu);
            list.add(shuJu);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 3. select
     *  select [--column c1,c2] [--condition c1 c2] [--order o1,o2]
     根据条件选择指定的列数据,并且按指定的排序进行排序
     --column 表示需要选择的列,如果有多个列,以逗号分隔.如果输入 *或者 没有此条件 表示选择所有列
     --condition表示 相应的过滤条件 格式为 id > 5 或者是 name = '张三'.中间的条件支持 > >= < <= = != like 操作.其中,如果目的是数字,按照数字进行比较,如果是字符串按照字符串进行比较. =在字符串中使用equals比较. like操作符仅支持字符串,并且其值可能为 abc %abc,abc% %abc%格式,其中%格式表示其前面(后面)为任意数据.如%abc能支持xabc,yabc,abc等
     --order 表示排序条件,格式为 id asc(或desc)或者是 id,其后面没有asc(desc)时,默认为asc.多个排序条件,按先后顺序进行.如name asc,score desc,表示先按name正序(即小的在前),再按score倒序
     响应信息为查询出来的相应数据,在输出第一行,显示相应的行头.每一列按tab分隔
     */
    public void select(String shuju) {
//          String s = "select [--column c1,c2] [--condition c1 c2] [--order o1,o2]";
//          String [] shuJu1=s.split("[,]");
//             if (equals(",")) {
//                shuJu.setId(Integer.parseInt(shuJu1[0]));
//

        switch (shuju.split("[ ]").length) {
            case 1:

                break;
            case 2:

                break;

            case 3:

                break;

        }
    }

    /**
     * 4. update
     *  update [expr1,expr2] [--condition c1 c2]
     根据相应的条件更新相应的列的数据
     --condition与select定义相同
     expr1,expr2表示要更新的列,多个列以逗号分隔.如name='张三',score=20表示更新name为张三,score为20
     *** 由于在数据当中,认为id值是全局惟一的.因此,在update时,如果update之后的数据的id值在之前的数据中有重复,,则认为语句错误 ***
     返回信息为 成功更新{x}条数据,x为更新的数据量
     */
    public  void update(){

    }
    /**
     *  5. delete
     *  insert (c1,c2) values(v1,v2)
     根据相应的条件删除相应的数据
     返回信息为 成功删除{x}条数据,X为成功删除的数据量
     */
    public void delete(){

    }
    /**
     * 6. insert第一种格式
     *insert values v1,v2,v3,v4
     按照id,name,subject,score,advisor的顺序插入相应的数据.如果相应列插入为null值,则输入null.
     如果是字符串列,null认为是java中的null,数字列为0
     如果并没有插入足够多列,则认为为语法错误
     id认为是全局惟一的,因此插入重复id的数据,认为是语句错误
     返回信息为 插入数据{id}成功 id为相应的id值
     /**
     * 7. insert第二种格式
     *  insert (c1,c2) values(v1,v2)
     按照(内指定的列),插入相应的数据,如insert (id,name) values(3,'张三').则表示只插入此2列,其余列为null
     如果插入的列中没有id列,则生成产生新的id值,默认为当前最大值+1
     如果插入的列中的id列值,与当前数据重复,则认为是语句错误
     返回信息为 插入数据{id}成功 id为相应的id值
     */
    public void insert(){

    }
    /**
     * 8. dump
     *   dump filename
     按照 select * --order name,score 的格式输出所有数据至指定文件.文件中由dump后面的参数得出.
     输出数据中包括行头
     返回信息,导出数据至文件{filename}成功
     */
    public void dump(){

    }
    /**
     * 9. sync
     将当前的数据,重新同步至原数据文件,并按id值排序,包括行头
     */
    public void  sync(){

    }

}
