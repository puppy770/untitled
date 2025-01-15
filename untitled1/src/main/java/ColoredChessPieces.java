public class ColoredChessPieces {

    // ANSI escape codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        // 输出棋子的颜色和类型
        System.out.println(RED + "●" + RESET);
        System.out.println(GREEN + "●" + RESET);
        System.out.println(YELLOW + "●" + RESET);
        System.out.println(BLUE + "●" + RESET);
        System.out.println(MAGENTA + "●" + RESET);
        System.out.println(CYAN + "●" + RESET);
        System.out.println(WHITE + "●" + RESET);
    }
}