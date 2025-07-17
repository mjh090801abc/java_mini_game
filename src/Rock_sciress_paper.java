import java.util.Scanner;
import java.util.Random;

public class Rock_sciress_paper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] shape = {"가위", "바위", "보"};
        Random rand = new Random();

        System.out.print("게임을 플레이할 횟수: ");
        int howmany_gameplay = sc.nextInt();

        int count = 0;

        while (count < howmany_gameplay) {
            System.out.print("\n가위, 바위, 보 중 하나를 입력하세요: ");
            String user = sc.next();

            // 컴퓨터가 랜덤으로 다시 선택함
            int comIndex = rand.nextInt(3);
            String computer = shape[comIndex];

            System.out.println("컴퓨터: " + computer);
            System.out.println("당신: " + user);

            // 승부 판단
            if (user.equals(computer)) {
                System.out.println("무승부!");
            } else if ((user.equals("가위") && computer.equals("보")) ||
                    (user.equals("바위") && computer.equals("가위")) ||
                    (user.equals("보") && computer.equals("바위"))) {
                System.out.println("당신이 이겼습니다!");
            } else {
                System.out.println("컴퓨터가 이겼습니다!");
            }

            count++;
            System.out.println("남은 횟수: " + (howmany_gameplay - count));
        }

        System.out.println("\n총 플레이 완료!");
    }
}
