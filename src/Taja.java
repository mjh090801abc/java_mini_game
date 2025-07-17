import java.util.Random;
import java.util.Scanner;

public class Taja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "banana", "computer", "keyboard", "java", "python", "c", "unity", "porn hub"};
        Random random = new Random(); // random 이라는 객체를 만들어서 랜덤으로 뽑음

        int score = 0;
        System.out.print("문제 수: ");
        int totalQuestions = scanner.nextInt(); // 풀문제 개수를 저장 (scanner.nextInt()는 정수를 입력받는 메서드임)
        scanner.nextLine();

        System.out.println("=== 타자 게임 시작 ===");

        long startTime = System.currentTimeMillis(); // 게임 시작 시간을 밀리초 단위로 받음

        for (int i = 0; i < totalQuestions; i++) { // 문제를 낼 수만큼 내기
            String word = words[random.nextInt(words.length)];
            System.out.println("문제 " + (i + 1) + ": " + word);
            System.out.print("입력 >> ");
            String input = scanner.nextLine(); // 사용자가 입력한 값

            if (word.equals(input)) { // equals로 비교하면 정확함
                System.out.println("정답!\n");
                score++; // 맞췄으므로 score에 1점 추가
            } else {
                System.out.println("오답! (정답: " + word + ")\n");
            }
        }

        long endTime = System.currentTimeMillis(); // 끝난 시간도 밀리초 단위로 저장
        long final_time = (endTime - startTime) / 1000;

        System.out.println("=== 게임 종료 ===");
        System.out.println("점수: " + score + "/" + totalQuestions);
        System.out.println("걸린 시간: " + final_time + "초");
    }
}
