package assignment;

import java.util.ArrayList;
import java.util.List;

public class Calculator2 {
    private List<Integer> results = new ArrayList<>(); // 연산 결과 저장 컬렉션

    // 사칙연산을 수행하고 결과를 반환하는 메서드
    public int calculate(int num1, int num2, char operator) throws ArithmeticException {
        int result = 0;

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
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                throw new IllegalArgumentException("올바른 연산자를 입력하세요.");
        }

        results.add(result); // 연산 결과 저장
        return result;
    }

    // 저장된 연산 결과를 반환하는 메서드
    public List<Integer> getResults() {
        return results;
    }

    // 가장 먼저 저장된 연산 결과를 삭제하는 메서드
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }

    // 모든 결과를 초기화하는 메서드
    public void reset() {
        results.clear();
        System.out.println("모든 연산 결과가 초기화되었습니다.");
    }
}
