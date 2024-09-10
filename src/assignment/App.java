package assignment;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator2 calculator = new Calculator2(); // Calculator2 인스턴스 생성
        boolean firstOperation = true; // 첫 번째 연산인지 확인하는 변수
        int num1 = 0; // 첫 번째 숫자 저장 변수

        while (true) {
            try {
                if (firstOperation) {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = sc.nextInt();
                    firstOperation = false;
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
                char operator = sc.next().charAt(0);

                // 연산 수행 및 결과 출력
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);

                // 사용자가 다음 명령을 선택
                System.out.println("계속 계산하시겠습니까? (계속하려면 아무 키나 입력, 종료하려면 'exit' 입력, 첫 연산 결과 삭제는 'remove' 입력, 계산 초기화는 'reset' 입력)");
                String command = sc.next();

                // 'exit' 입력 시 종료
                if (command.equalsIgnoreCase("exit")) {
                    break;
                }
                // 'remove' 입력 시 가장 먼저 저장된 연산 결과 삭제
                else if (command.equalsIgnoreCase("remove")) {
                    calculator.removeFirstResult();
                    System.out.println("가장 먼저 저장된 연산 결과가 삭제되었습니다.");
                }
                // 'reset' 입력 시 모든 연산 결과 초기화
                else if (command.equalsIgnoreCase("reset")) {
                    calculator.reset();
                    firstOperation = true; // 첫 번째 연산으로 돌아가기
                }
                // 그 외의 입력 시 num1에 이전 결과를 저장하고 계속 계산
                else {
                    num1 = result;
                }

            } catch (ArithmeticException e) {
                System.out.println("에러: " + e.getMessage());
                firstOperation = true; // 예외 발생 시 처음부터 다시 계산
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                sc.nextLine(); // 입력 버퍼 비우기
            }
        }

        // 프로그램 종료 시 저장된 모든 연산 결과 출력
        System.out.println("저장된 모든 연산 결과: " + calculator.getResults());
        System.out.println("프로그램이 종료되었습니다.");
    }
}
