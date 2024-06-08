package org.example;

import java.util.Arrays;

public class Stack {

    private Integer[] stack;
    private String[] stringStack;
    private Integer top;

    public Integer[] getStack() {
        return stack;
    }

    public String[] getStringStack() {
        return stringStack;
    }

    public Integer getTop() {
        return top;
    }

    public Stack() {
        this.stack = new Integer[10];
        this.stringStack = new String[10];
        this.top = -1;//배열 인덱스는 0부터 시작하기 때문
    }

    public Stack(Integer top) {
        this.stack = new Integer[top];
        this.stringStack = new String[top];
        this.top = -1;
    }

    public Boolean isEmpty(){
        return (top == -1 ? true : false);
    }

    public Boolean isFull(){
        return (top == stack.length-1 ? true : false);
    }
    public void push(Integer data){
        if (top >= -1 && top < stack.length-1){
            top++;
            stack[top] = data;
        }
    }

    public Integer peek(){
        if (top == -1){
            return -1;
        }
        return stack[top];
    }

    public Integer pop(){
        if (top < 0){
            System.out.println("빈스택");
            return -1;
        }else {
            return stack[top--];
        }
    }

    public void display(){
        for (int i = 0; i < stack.length; i++) {
            if (i <= top){
                System.out.printf("[ %d ]",stack[i]);
            }else {
                System.out.printf("[ null ]");
            }
        }
        System.out.println();
    }

    public Integer[] reverse(Integer[] arr){
        Stack s1 = new Stack(arr.length);
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (arr[i] != null){
                s1.push(arr[i]);
            }
        }
        return s1.getStack();
    }




//  2) 중위식을 후위식으로 변경
//    문자열을 반환하고 문자열을 하나 입력받는 postfix라는 이름의 메소드
//    문자열을 저장할 변수를 생성하고 ""를 저장
//    전달받은 문자열의 길이만큼 저장할 수 있는 스택 생성 후 변수에 저장
//    전달받은 문자열의 길이만큼 반복하는 반복문
//    만약에 전달받은 문자에서 현재 반복횟수번째 글자가 숫자면
//    문자열을 저장할 변수에 추가
//    그렇지 않으면
//    무한 반복
//    만약에 스택이 비어있거나 스택에 마지막에 저장된 것과 전달받은 문자에서 현재 반복횟수번째 글자의 우선순위를 비교해서 현재 반복횟수번째 글자의 우선순위가 높으면
//    스택에 push하고 무한 반복 종료
//    그렇지 않으면
//    문자열을 저장할 변수에 스택에서 마지막에 저장된 것을 pop해서 추가
//
//    스택이 비어있지 않으면 계속 반복
//    문자열을 저장할 변수에 스택에서 마지막에 저장된 것을 pop해서 추가
//
//    문자열을 저장할 변수를 반환
//
//  3) 후위식을 계산
//    문자열을 반환하고 문자열을 하나 입력받는 postfixCalc라는 메소드
//    전달받은 문자열의 길이만큼 저장할 수 있는 스택 생성 후 변수에 저장
//    전달받은 문자열의 길이만큼 반복하는 반복문
//    만약에 전달받은 문자에서 현재 반복횟수번째 글자가 숫자면
//    전달받은 문자에서 현재 반복횟수번째 글자를 스택에  push
//    그렇지 않으면
//    숫자를 저장할 수 있는 변수 num2 생성
//    숫자를 저장할 수 있는 변수 num1 생성
//    스택에서 pop해온 글자를 숫자로 바꿔서 num2에 저장
//    스택에서 pop해온 글자를 숫자로 바꿔서 num1에 저장
//
//    만약에 전달받은 문자에서 현재 반복횟수번째 글자가 +면
//    num1과 num2를 더한 값을 스택에 push
//    그렇지 않고 만약에 전달받은 문자에서 현재 반복횟수번째 글자가 -면
//    num1과 num2를 뺀 값을 스택에 push
//    그렇지 않고 만약에 전달받은 문자에서 현재 반복횟수번째 글자가 *면
//    num1과 num2를 곱한 값을 스택에 push
//    그렇지 않고 만약에 전달받은 문자에서 현재 반복횟수번째 글자가 /면
//    num1과 num2를 나눈 값을 스택에 push
//
//    스택에 저장된 값을 pop해서 반환











}
