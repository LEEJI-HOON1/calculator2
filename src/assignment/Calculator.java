package assignment;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueCalc = "yes"; // 반복 여부를 저장할 변수
        int num1 = 0; // 초기 값 설정
        boolean firstOperation = true; // 첫 번째 연산인지 확인하는 변수

        while (!continueCalc.equalsIgnoreCase("exit")) {  // 사용자가 "exit" 입력 시 종료
            try {
                if (firstOperation) {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = sc.nextInt();
                    if (num1 > Integer.MAX_VALUE) {
                        throw new ArithmeticException("숫자 최대치를 넘길 수 없습니다.");
                    }
                    firstOperation = false; // 첫 번째 연산이 완료되면 false로 설정
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();
                if (num2 > Integer.MAX_VALUE) {
                    throw new ArithmeticException("숫자 최대치를 넘길 수 없습니다.");
                }

                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
                char operator = sc.next().charAt(0);

                int result = 0;

                // 사칙연산 수행
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            System.out.println("0으로 나눌 수 없습니다.");
                            continue; // 0으로 나누기 예외 처리 시 계산 재시도
                        }
                        break;
                    default:
                        System.out.println("올바른 연산자를 입력하세요.");
                        continue; // 잘못된 연산자 입력 시 계산 재시도
                }

                // 결과 출력
                System.out.println("결과: " + result);

                // 계속할지, 초기화 여부를 물어봄
                System.out.println("계속 계산하시겠습니까? (계속하려면 아무 키나 입력, 종료하려면 'exit' 입력, 계산을 초기화하려면 'reset' 입력)");
                String userChoice = sc.next();
                if (userChoice.equalsIgnoreCase("reset")) {
                    num1 = 0; // 계산 초기화
                    firstOperation = true; // 첫 번째 연산으로 초기화
                } else if (userChoice.equalsIgnoreCase("exit")) {
                    continueCalc = "exit"; // 프로그램 종료
                }

            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                num1 = 0; // 계산 초기화
                firstOperation = true; // 첫 번째 연산으로 초기화
                sc.nextLine(); // 입력 버퍼 비우기

            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                sc.nextLine(); // 입력 버퍼 비우기
            }
        }
        System.out.println("프로그램이 종료되었습니다.");

    }
}
