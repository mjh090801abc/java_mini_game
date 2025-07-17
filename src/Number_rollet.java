import java.util.Scanner;
import java.util.Random;

public class Number_rollet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("목록의 개수: ");
        int how_many = sc.nextInt();
        sc.nextLine();

        String[] list = new String[how_many];

        for (int i = 0; i < how_many; i++) {
            System.out.print((i + 1) + ". 항목 입력: ");
            list[i] = sc.nextLine();
        }

        int winnerIndex = rand.nextInt(how_many);
        String winner = list[winnerIndex];

        System.out.println((winnerIndex + 1) + "번 " + winner + " 🎉");
    }
}
