package main.java.calculator;

import java.util.ArrayList;

public class ArithmeticCalculator extends Calculator {
    AddOperator addOperator;
    SubtractOperator subtractOperator;
    MultiplyOperator multiplyOperator;
    DivideOperator divideOperator;

    public ArithmeticCalculator(ArrayList<Double> resultArr, AddOperator addOperator, SubtractOperator subtractOperator,
                                MultiplyOperator multiplyOperator, DivideOperator divideOperator) { // 매개변수로 ArrayList 생성자를 받아 부모 생성자의 ArrayList 생성
        super(resultArr);
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
    }

    /**
     *  calculate 메서드는 아래의 매개변수를 가지고 사직연산을 하는 메서드입니다.
     * @param num1 : 첫 번째 정수 타입
     * @param num2 : 두 번째 정수 타입
     * @param operator : 사직연산 기호 문자 타입
     * @return result : 사직연산의 결과를 전달하는 정수 타입 반환값
     * @throws DivZeroException : 나눗셈의 나누는 정수값이 0일때, 예외를 보내는 예외 클래스
     */
    public int calculate(int num1, int num2, char operator) throws DivZeroException{
        int result;

        switch (operator) { // 입력받은 연산자(operator) 값에 따라 다르게 연산
            case '+':
                result = addOperator.operator(num1, num2);
                break;
            case '-':
                result = subtractOperator.operator(num1, num2);
                break;
            case '*':
                result = multiplyOperator.operator(num1, num2);
                break;
            case '/':
                if (num2 == 0) {
                    throw new DivZeroException();
                } else {
                    result = divideOperator.operator(num1, num2);
                    break;
                }
            default:
                throw new UnsupportedOperationException("올바른 선택이 아닙니다.");
        }
        return result;
    }

    @Override
    public void inquiryResults() {
        for (double i : super.getResultArr()) {
            System.out.println("저장된 연산결과 : " + i);
        }
    }

}
