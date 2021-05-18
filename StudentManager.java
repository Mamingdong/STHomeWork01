package STHomeWork01;
import java.util.*;


public class StudentManager {
    static Stu[] stu=new Stu[100];
    static Scanner scanner=new Scanner(System.in);
    static  int number=0;
    int choice;

    //public void App() 1.1错误
    public void app() {
        while (true) {
            display();
            choice = scanner.nextInt();
            if (choice == 6) break;
            switch (choice) {
                case 1:
                    add();
                    break;//添加学生信息
                case 2:
                    query();
                    break;//查询学生信息
                case 3:
                    delete();
                    break;//删除学生信息
                case 4:
                    change();
                    break;//修改学生信息
                case 5:
                    show();
                    break;//输出学生信息
                case 6:
                    break;
            }
            //}2.3错误
        }//while
    //}2.3错误
    }//app

    static void display()
    {
        System.out.println("***************************************");
        System.out.println("****  学生信息管理系统  *****");
        System.out.println("****  1：添加学生信息   ****");
        System.out.println("****  2：查询学生信息   ****");
        System.out.println("****  3：删除学生信息   ****");
        System.out.println("****  4：修改学生信息   ****");
        System.out.println("****  5：输出学生信息   ****");
        System.out.println("****  6：退出     ****");
        System.out.println("**** 请输入您要进行的操作（1-6） ***");
        System.out.println("***************************************");
    }

    static void add()//添加学生信息 case 1
    {//添加学生信息 2.1错误
        System.out.println("点击任意键继续添加学生信息");
        System.out.println("请输入该学生的学号，姓名，出生日期，性别");
        stu[number]=new Stu();
        stu[number].setID(scanner.nextInt());
        stu[number].setName(scanner.next());
        stu[number].setBirDate(scanner.next());
        stu[number].setGender(scanner.next());
        number++;
        sort();
        System.out.println("添加成功");
    }

    static void show()//展示学生信息 case 5
    {//展示学生信息 2.1错误
        System.out.println("这些学生的学号，姓名，出生日期，性别分别为");
        for(int i=0;i<number;i++)
            System.out.println(stu[i].getID()+"\t"+stu[i].getName()+"\t"+stu[i].getBirDate()+"\t"+stu[i].getGender());
        System.out.println();
    }

    static void sort()//对学生信息进行排序
    {//对学生信息进行排序 2.1错误
        int j;
        Stu temp=new Stu();
        for(int i=0;i<number;i++)
        {
            for(j=i+1;j<number;j++)
                if(stu[i].getID()>stu[j].getID())
                {temp=stu[i];stu[i]=stu[j];stu[j]=temp;}
        }
        System.out.println("排序完成，选择”学生信息查看“进行查看");
    }

    static void change()//改变学生信息 case 4
    {//改变学生信息 2.1
        System.out.println("请输入要修改信息的学生姓名");
        String stuname=scanner.next();
        for(int i=0;i<number;i++)
        {
            if(stuname.equals(stu[i].getName()))
            {System.out.println("请输入要修改的学生的信息");
                stu[i].setID(scanner.nextInt());
                stu[i].setName(scanner.next());
                stu[i].setGender(scanner.next());
                stu[i].setBirDate(scanner.next());
                break;
            }
            if(number==i)System.out.println("对不起查无此人");
        }

    }

    static void query()//查询学生信息 case 2
    {//查询 2.1
        System.out.println("请输入要查询的学生姓名");
        String Stuname=scanner.next();
        int i;
        for(i=0;i<number;i++)
        {
            if(Stuname.equals(stu[i].getName())){
                System.out.println("*******************************************");
                System.out.println(stu[i].getID()+"\t"+stu[i].getName()+"\t"+"\t"+stu[i].getBirDate()+stu[i].getGender());
                System.out.println("*******************************************");
            }
        }
        if(number==i)System.out.println("对不起查无此人");
    }

    static void delete() //删除学生信息 case 3
    {//删除学生信息 2.1
        System.out.println("请输入要删除信息的学生姓名");
        String stuname=scanner.next();
        int i;
        for( i=0;i<number;i++)
            if(stuname.equals(stu[i].getName()))break;
        if(number==i)System.out.println("对不起查无此人");
        for(;i<number-1;i++)
            stu[i]=stu[i+1];
        number--;
        System.out.println("删除完成");
    }
}
