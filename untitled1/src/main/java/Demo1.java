import java.util.Scanner;

//总地图 属性：map[][]
class Map{

}
public class Demo1 {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        menuView();
    }
    // -------------------- 数据设计 --------------------
/*
    地图:
        map[i][j]表示坐标(i,j)的值
        ' '表示空地
        'X'表示墙壁
        'H'表示箱子要推到的指定为止
        'B'表示箱子
        'M'表示小人
*/
    //关卡地图 没有箱子和小人
    public static char map1[][] ={{}};//在这里初始化地图
    public static char map2[][] ={{}};
    //本关地图 复制关卡地图，并加上箱子和小人
    public static Map map=new Map();


    // -------------------- 数据设计 --------------------


    // -------------------- service --------------------

    /*
        功能: 初始化游戏数据
            将游戏地图map按照传入的id不同，复制不同关卡地图数组给Map
            给小人一个初始位置，和每个箱子初始位置，根据地图来给，并根据其位置修改map的值
        参数:
            id：关卡数
        返回值: void
    */
    public static void init(int id){
        //在此处完成代码

    }


    /*
      功能: 小人移动到指定位置
          根据参数计算出小人要到位置的坐标 x y
          如果map[x][y]不是墙壁且不是箱子 则修改map[x][y]的值且将小人原位置变为关卡地图的原值
          如果map[x][y]是箱子 则小人会推箱子，箱子在小人移动方向上移动一格，判断是否可以推到这个新位置，即为空地或洞
                            如果不可以推，那小人也不可以移动
                            如果可以，修改map[x][y]的值且将小人原位置变为关卡地图的原值
                                    将箱子移动到新位置修改map[x1][y1]并将箱子原位置变为关卡地图的原值
          其他情况不做修改移动失败
      参数:
          id：在哪个关卡地图上移动
          dir: 代表向哪个方向移动[上1 下2 左3 右4]，每次移动一次
      返回值:
          0表示移动失败
          1表示移动成功

  */
    public static int playerMove(int id,int dir){
        //在此处完成代码
        return 0;
    }

    /*
        功能: 判断箱子是否都推到洞了
        参数: id:在哪个关卡地图上移动
        返回值:
            0表示箱子没有全部到位
            1表示箱子全部到位
    */
    public static int isWin(int id) {
        return 0;
    }




    // -------------------- service --------------------


    // -------------------- view --------------------
/*
    功能: 开始界面, 玩家可以在这里选择: [选关界面]/[设置界面]/[排行榜界面]/退出游戏
        选关界面: 调用选关界面函数gameChooseView();
        设置界面: 敬请期待...
        排行榜界面：敬请期待...
        退出游戏: 调用exit(0);
*/
    public static void menuView() {

    }
/*
    功能: 选关界面, 玩家可以在这里选择不同关卡进入不同游戏界面以及返回开始界面
        关卡1：XXX gameView(1)
        关卡2：XXX gameView(2)
        ...
        返回主界面：menuView()
 */
    public static void gameChooseView() {

    }

    /*
        功能: 展示游戏地图
     */
    public static void gameView_ShowMap() {

    }
    /*
        功能: 打印游戏胜利界面
        参数: void
        返回值: void
    */
    public static void winView(){

    }

    /*
        功能: 游戏界面整合
            初始化游戏数据(调用函数init(id))
            while(1){
                打印游戏界面(调用函数gameView_ShowMap())
                接收玩家接下来操作：退回到选关界面gameChooseView 或者 继续玩
                继续玩：接收玩家移动位置[上1 下2 左3 右4] 每次移动一次

                移动到此位置(调用移动函数playerMove())
                    (如果移动失败 重新开始循环)

                判断游戏是否胜利(调用胜利判断函数isWin())
                    (如果游戏胜利 调用胜利界面函数 然后结束当前界面)
            }
        参数: int id 为当前关卡数，根据id展示不同页面
        返回值: void
     */
    public static void gameView(int id) {
    }
    // -------------------- view --------------------
}
