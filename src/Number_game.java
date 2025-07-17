import java.util.Scanner;
import java.util.Random;

public class Number_game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random_number = new Random();

        System.out.println("==== 숫자 맞추기 게임 ====");
        System.out.print("1부터 어느 숫자까지 맞춰볼까요? : ");
        int max_number = sc.nextInt();

        int range = random_number.nextInt(max_number) + 1;

        System.out.println("\n==== 숫자 맞추기 게임 시작 ====");
        System.out.println("1부터 " + max_number + "까지의 숫자를 맞춰보세요!");

        int try_number = 0;  // 누적 시도 횟수는 while 바깥에 선언

        while (true) {
            System.out.print("입력 >> ");
            int person = sc.nextInt();
            try_number++;  // 시도할 때마다 증가

            if (person < range) {
                System.out.println("🔼 UP");
            } else if (person > range) {
                System.out.println("🔽 DOWN");
            } else {
                System.out.println("🎉 정답입니다! 숫자는 " + range + "였습니다!");
                System.out.println("총 시도 횟수: " + try_number + "번");
                break;  // 정답 맞췄으니 반복 종료
            }
        }

        sc.close();  // 입력 닫기 (좋은 습관)
    }
}
