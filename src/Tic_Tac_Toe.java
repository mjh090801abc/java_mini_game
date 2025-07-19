import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 사용자에게 행과 열 크기를 입력받음
        System.out.print("판의 행 크기 입력: ");
        int rows = sc.nextInt();

        System.out.print("판의 열 크기 입력: ");
        int cols = sc.nextInt();

        // 2. 입력한 크기로 보드 배열 생성
        char[][] board = new char[rows][cols];

        // 3. 보드를 '.' 문자로 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '.';
            }
        }

        int totalMoves = rows * cols; // 총 가능한 이동 횟수
        int moveCount = 0; // 현재까지 진행된 턴 수
        boolean gameEnded = false;
        char currentPlayer = 'X'; // 첫 시작은 Player 1

        // 4. 게임 루프 시작
        while (!gameEnded && moveCount < totalMoves) {
            printBoard(board); // 현재 보드 출력

            System.out.println("Player " + (currentPlayer == 'X' ? "1 (X)" : "2 (O)") + ", 행과 열 입력 (0부터 시작): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // 5. 유효한 입력인지 확인
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                System.out.println("⚠️ 범위를 벗어난 좌표입니다. 다시 입력하세요.");
                continue;
            }

            if (board[row][col] != '.') {
                System.out.println("⚠️ 이미 놓인 자리입니다. 다시 입력하세요.");
                continue;
            }

            // 6. 플레이어 기호를 보드에 표시
            board[row][col] = currentPlayer;
            moveCount++;

            // 7. 승리 조건 검사
            if (checkWin(board, row, col, currentPlayer)) {
                printBoard(board);
                System.out.println("🎉 Player " + (currentPlayer == 'X' ? "1 (X)" : "2 (O)") + " 승리!");
                gameEnded = true;
            } else if (moveCount == totalMoves) {
                printBoard(board);
                System.out.println("🤝 무승부입니다!");
            } else {
                // 8. 턴 교체
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    // 보드를 출력하는 함수
    public static void printBoard(char[][] board) {
        System.out.print("   ");
        for (int i = 0; i < board[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 현재 놓은 위치(row, col)를 기준으로 승리 조건을 검사하는 함수
    public static boolean checkWin(char[][] board, int row, int col, char player) {
        int rows = board.length;
        int cols = board[0].length;

        // 가로 검사
        boolean winRow = true;
        for (int j = 0; j < cols; j++) {
            if (board[row][j] != player) {
                winRow = false;
                break;
            }
        }

        // 세로 검사
        boolean winCol = true;
        for (int i = 0; i < rows; i++) {
            if (board[i][col] != player) {
                winCol = false;
                break;
            }
        }

        // 왼쪽 위 -> 오른쪽 아래 대각선 검사
        boolean winDiag1 = true;
        if (row == col) {
            for (int i = 0; i < rows; i++) {
                if (i < cols && board[i][i] != player) {
                    winDiag1 = false;
                    break;
                }
            }
        } else {
            winDiag1 = false;
        }

        // 오른쪽 위 -> 왼쪽 아래 대각선 검사
        boolean winDiag2 = true;
        if (row + col == cols - 1) {
            for (int i = 0; i < rows; i++) {
                int j = cols - 1 - i;
                if (j >= 0 && j < cols && board[i][j] != player) {
                    winDiag2 = false;
                    break;
                }
            }
        } else {
            winDiag2 = false;
        }

        // 어느 하나라도 true면 승리
        return winRow || winCol || winDiag1 || winDiag2;
    }
}

