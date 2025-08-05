import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("로그인 페이지");
        System.out.println();

        System.out.println("아이디 : ");
        String username = sc.nextLine();

        int[] count = new int[128];

        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            count[ch]++;
        }

        boolean repeat_num = false;
        for (int i = 0; i < 128; i++) {
            if (count[i] >= 4) {
                repeat_num = true;
                break;
            }
        }
        if (repeat_num) {
            System.out.println("아이디에 같은 4글자가 포함되어있습니다. 로그인 실패!");
            return;
        }

        System.out.println("비밀번호 : ");
        String password = sc.nextLine();

        int[] count2 = new int[128];

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            count2[ch]++;
        }

        boolean repeat_num2 = false;
        for (int i = 0; i < 128; i++) {
            if (count2[i] >= 4) {
                repeat_num2 = true;
                break;
            }
        }
        if (repeat_num2) {
            System.out.println("비밀번호에 같은 4글자가 포함되어있습니다. 로그인 실패!");
            return;
        }
    }
}
