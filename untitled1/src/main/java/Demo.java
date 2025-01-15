import javax.swing.text.Style;
import java.net.Socket;
import java.util.*;

//Java:
public class Demo{

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        menuView();

    }


    // -------------------- 数据设计 --------------------
/*
    棋盘:
        map[i][j]表示坐标(i,j)的值
        0表示空地
        1表示黑子
        2表示白子
    如: map[3][6] = 1  表示(3,6)的位置是黑子
*/
    public static int map[][] = new int[19][19];

    // 表示当前回合数  偶数表示黑棋落子  奇数表示白棋落子
// 如: flag = 20 表示当前是第[20]次落子  由黑方落子
    public static int flag;
// -------------------- 数据设计 --------------------


    // -------------------- service --------------------
/*
    负责人: 张三
    功能: 初始化游戏数据
        将棋盘的值初始化为0
        当前回合设为黑棋(flag设为0)
    参数: void
    返回值: void
*/
    public static void init(){
        //在此处完成代码
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                map[i][j] = 0;
            }
        }
        flag=0;
    }

    /*
        *难点1
        负责人: 张三
        功能: 根据传入的坐标(map对应位置)和flag值 判断落点后是否获胜
        参数:
            x: 当前回合落子的x坐标
            y: 当前回合落子的y坐标
        返回值:
            0表示没有获胜
            1表示黑子胜利
            2表示白子胜利
    */

    public static int isWin(int x, int y){
        //在此处完成代码
        int n=0; //判断是哪方在下棋,当前棋是1还是2
        if(flag%2==0) n=1; //下棋次数为偶数黑子下棋
        else n=2; //下棋次数为奇数白子下棋
        //判断水平方向上是否获胜
        int count=1;
        //在当前下棋位置的左边是否有棋
        for(int i=y-1; i>=0; i--){
            if(map[x][i]==n) {
                count++;
                if(count==5) return n;
            } else {
                break;
            }
        }
        //在当前下棋位置的右边是否有棋
        for(int i=y+1; i<19; i++){
            if(map[x][i]==n) {
                count++;
                if(count==5) return n;
            } else {
                break;
            }
        }
        count=1;
        //判断垂直方向上是否获胜
        //在当前下棋位置的上边是否有棋
        for(int i=x-1; i>=0; i--){
            if(map[i][y]==n) {
                count++;
                if(count==5) return n;
            } else {
                break;
            }
        }
        //在当前下棋位置的下边是否有棋
        for(int i=x+1; i<19; i++){
            if(map[i][y]==n) {
                count++;
                if(count==5) return n;
            } else {
                break;
            }
        }
        count=1;
        //判断左上右下方向上是否获胜
        //在当前下棋位置的左上是否有棋
        for(int i=x-1,j=y-1; i>=0&&j>=0; i--,j--){
            if(map[i][j]==n) {
                count++;
                if(count==5) return n;
            } else {
                break;
            }
        }
        //在当前下棋位置的右下是否有棋
        for(int i=x+1,j=y+1; i<19&&j<19; i++,j++){
            if(map[i][j]==n) {
                count++;
                if(count==5) return n;
            } else {
                break;
            }
        }
        count=1;
        //判断左下右上方向上是否获胜
        //在当前下棋位置的右上是否有棋
        for(int i=x-1,j=y+1; i>=0&&j<19; i--,j++){
            if(map[i][j]==n) {
                count++;
                if(count==5) return n;
            } else {
                break;
            }
        }
        //在当前下棋位置的左下是否有棋
        for(int i=x+1,j=y-1; i<19&&j>=0; i++,j--){
            if(map[i][j]==n) {
                count++;
                if(count==5) return n;
            } else {
                break;
            }
        }


        return 0;
    }

    /*
        负责人: 张三
        功能: 在指定位置落子
            如果map[x][y]是空地 则修改map[x][y]的值:改为相应颜色(flag对应颜色)        否则不操作
        参数:
            x: 当前回合落子的x坐标
            y: 当前回合落子的y坐标
        返回值:
            0表示落子失败 (棋盘已经有子)
            1表示落子成功

    */
    public static int playerMove(int x, int y){
        //在此处完成代码
        int n=0; //判断是哪方在下棋,当前棋是1还是2
        if(flag%2==0) n=1; //下棋次数为偶数黑子下棋
        else n=2; //下棋次数为奇数白子下棋
        if(map[x][y]==0) {
            map[x][y]=n;
            return 1;
        }
        return 0;
    }
// -------------------- service --------------------



    // -------------------- view --------------------
/*
    功能: 展示选项, 玩家可以在这里选择进入游戏, 进入设置或退出游戏
        进入游戏: 调用游戏界面函数gameView();
        进入设置: 敬请期待...
        退出游戏: 调用exit(0);
*/
    public static void menuView(){
        //在此处完成代码
        while(true){
            System.out.println("====欢迎来到五子棋游戏！！！====");
            System.out.println("1.进入游戏");
            System.out.println("2.进入设置");
            System.out.println("3.退出游戏");
            System.out.println("请输入要操作的选项(1-3)：");
            int choose=scan.nextInt();
            switch(choose){
                case 1:
                    gameView();
                    break;
                case 2:
                    System.out.println("敬请期待...");
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误！！");
                    break;
            }
        }

    }

    /*
        负责人: 张三
        功能: 根据map数组 打印游戏棋盘
        参数: void
        返回值: void
    */
    public static void gameView_ShowMap(){
        //在此处完成代码
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /*
        负责人: 张三
        功能: 根据flag的值 打印游戏胜利界面 用户可以按任意键回到主菜单
        参数: void
        返回值: void
    */
    public static void winView(){
        //在此处完成代码
        if(flag%2==0) {
            System.out.println("黑方赢了！");
        } else {
            System.out.println("白方赢了！");
        }

    }

    /*
        *难点2
        负责人: 张三
        功能: 游戏界面整合
            初始化游戏数据(调用函数init())
            while(1){
                打印游戏界面(调用函数gameView_ShowMap())
                接收玩家坐标输入

                落子(调用落子函数playerMove())
                    (如果落子失败 重新开始循环)

                判断游戏是否胜利(调用胜利判断函数isWin())
                    (如果游戏胜利 调用胜利界面函数 然后结束当前界面)
                切换玩家(修改flag值)
            }
        参数: void
        返回值: void
    */
    public static void gameView(){
        //在此处完成代码
        init();
        while(true) {
            gameView_ShowMap();
            
            System.out.println("请输入下棋坐标x y:");
            int x=scan.nextInt();
            int y=scan.nextInt();
            if(playerMove(x,y)==0) {
                System.out.println("此位置不可以下棋！");
                continue;
            }
            if(isWin(x,y)!=0) {
                gameView_ShowMap();
                winView();
                break;
            };
            flag++;

        }
    }
// -------------------- view --------------------
}