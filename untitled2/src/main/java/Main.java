import java.util.*;


// 抽象类 Person
abstract class Person{
    protected int age;
    protected String name;
    protected boolean sex; //true为女，false为男
    public static int count=0;//用于统计有多少Person对象
    public Person(){}
    public Person(int age,String name,boolean sex) { //构造方法: 传入年龄, 性别和姓名. 将对应数据进行修改
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public abstract void show(); //抽象方法show; 打印该对象的信息
}

class Student extends Person{
    private int sid; //学号(sid)
    public static int count=0; //count: 用于统计有多少Student对象
    public Student(){}
    public Student(int age,String name, boolean sex) {
        super(age,name, sex);
        this.sid = this.hashCode();
    }

   @Override
   public boolean equals(Object o) {
        if(o instanceof Student){
            Student s = (Student)o;
            return this.sid == s.sid;
        }
        return false;
   }

    @Override
    public int hashCode() {
        return Objects.hash(age,sex,name);
    }

    @Override
    public void show() {
        System.out.println("学号: " + sid + " 姓名: " + name + " 年龄: " + age + " 性别: " + (sex ? "女" : "男"));
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
class Worker extends Person{
    private int wid; //工号(wid)
    public static int count=0; //用于统计有多少Worker对象
    public Worker(){}
    public Worker(int age,String name, boolean sex) {
        super(age,name, sex);
        wid = this.hashCode();
    }
    @Override
    public void show() {
        System.out.println("工号: " + wid + " 姓名: " + name + " 年龄: " + age + " 性别: " + (sex ? "女" : "男"));
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Worker){
            Worker w = (Worker)o;
            return this.wid == w.wid;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age,sex,name);
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }
}
class Management{
    private ArrayList<Person> persons=new ArrayList<>();
    public boolean add(Person person){
        if(persons.contains(person)) return false;
        persons.add(person);
        if(person instanceof Student){Student.count ++;}
        if(person instanceof Worker){Worker.count ++;}
        Person.count ++;
        return true;
    }
    public boolean delStudent(int id){
        for (Person person : persons) {
            if(person instanceof Student){
                Student s = (Student)person;
                if(s.getSid()==id) {
                    persons.remove(person);
                    Student.count--;
                    Person.count --;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean delWorker(int id){
        for (Person person : persons) {
            if(person instanceof Worker){
                Worker w = (Worker)person;
                if(w.getWid()==id) {
                    persons.remove(person);
                    Worker.count--;
                    Person.count --;
                    return true;
                }
            }
        }
        return false;
    }
    public void showStudent() {
        for (Person person : persons) {
            if(person instanceof Student){
                Student s = (Student)person;
                s.show();
            }
        }
    }
    public void showWorker() {
        for (Person person : persons) {
            if(person instanceof Worker){
                Worker w = (Worker)person;
                w.show();
            }
        }
    }
    public void showStat() {
        System.out.println("学生有"+Student.count+"人");
        System.out.println("工人有"+Worker.count+"人");
    }
}

public class Main {
    static final boolean MAN = false;
    static final boolean WOMAN = true;
    public static void main(String[] args) {
        Management mana = new Management();
// add测试
        System.out.println(
                (mana.add(new Student(18, "张三", MAN)) &&
                        mana.add(new Student(19, "李四", WOMAN)) &&
                        mana.add(new Worker(20,"王五", MAN)) &&
                        mana.add(new Worker(21, "赵六", WOMAN)) &&
                        !mana.add(new Worker(21, "赵六", WOMAN))) ? "测试成功" : "测试失败"
        );
//del及hashCode测试
        int tempId = new Worker(21, "赵六", WOMAN).hashCode();
        System.out.println(
                (mana.delStudent(tempId) ||
                        !mana.delWorker(tempId)) ? "测试失败" : "测试成功"
        );
// count测试
        System.gc();
        try { Thread.sleep(1000); } catch (InterruptedException e)
        {e.printStackTrace();}
        System.out.println(
                (Student.count == 2 &&
                        Worker.count == 1 &&
                        Person.count == 3) ? "测试成功": "测试失败"
        );
// 打印
        mana.showStudent();
        mana.showWorker();
        mana.showStat();
    }
}
