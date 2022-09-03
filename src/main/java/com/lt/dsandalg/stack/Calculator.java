package com.lt.dsandalg.stack;

import com.lt.dsandalg.stack.list.ListStack;

/**
 * @description: 用栈实现计算器
 * @author: ~Teng~
 * @date: 2022/9/3 12:46
 */
public class Calculator {
    public static void main(String[] args) {
        // 测试运算
        String expression1 = "33+2+2*6-2";
        String expression2 = "7*22*2-5+1-5+3-4";
        String expression3 = "4/2*3-4*2-3-99";
        String expression4 = "1*1*1*3*2/3";
        String expression5 = "11*1*1*3*2/3";
        String expression6 = "1000*23";

        // 创建两个栈：数栈、符号栈
        ListStack numStack = new ListStack(10);
        ListStack operationStack = new ListStack(10);

        test(expression1, numStack, operationStack);
        test(expression2, numStack, operationStack);
        test(expression3, numStack, operationStack);
        test(expression4, numStack, operationStack);
        test(expression5, numStack, operationStack);
        test(expression6, numStack, operationStack);
    }

    /**
     * 测试方法，测试表达式的结果，并且打印结果
     *
     * @param expression     表达式
     * @param numStack       数字栈
     * @param operationStack 符号栈
     */
    public static void test(String expression, ListStack numStack, ListStack operationStack) {
        // 用于扫描
        int index = 0;
        // 将每次扫描得到的char保存到ch
        char ch = ' ';

        // 开始while循环的扫描expression
        while (true) {
            // 依次得到expression的每一个字符
            ch = getCharByIndex(expression, index);
            // 判断ch是什么，然后做相应的处理
            if (isOperation(ch)) {
                // 运用管道过滤器风格，处理运算符
                operationSolve1(ch, numStack, operationStack);
            } else {
                // 数直接入数栈，对值为ASCII值-48
                // 当处理多位数时候，不能立即入栈，可能是多位数，调用过滤器处理多位数
                index = numSolve1(expression, index, numStack);
            }
            // 让index+1，并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        // 最后只剩下两个数和一个运算符
        int res = cal((int) numStack.pop(), (int) numStack.pop(), (char) operationStack.pop());
        System.out.printf("表达式: %s = %d\n", expression, res);
    }

    /**
     * 符号过滤器1，判断当前是否具有字符
     *
     * @param ch             运算符
     * @param numStack       数字栈
     * @param operationStack 运算符栈
     */
    private static void operationSolve1(char ch, ListStack numStack, ListStack operationStack) {
        // 判断当前符号栈是否具有操作符
        if (!operationStack.isEmpty()) {
            // 不为空
            operationSolve2(ch, numStack, operationStack);
        } else {
            operationStack.push(ch);
        }
    }

    /**
     * 符号过滤器2，处理字符优先级，递归调用过滤器1
     *
     * @param ch             运算符
     * @param numStack       数字栈
     * @param operationStack 运算符栈
     */
    private static void operationSolve2(char ch, ListStack numStack, ListStack operationStack) {
        // 比较优先级
        if (priority(ch) <= priority((Character) operationStack.peek())) {
            // 调用过滤器3进行计算
            operationSolve3(numStack, operationStack);
            // 递归调用过滤器1，不能递归调用过滤器2，因为可能存在当前运算符栈为空的情况
            operationSolve1(ch, numStack, operationStack);
        } else {
            // 直接加入算数运算符
            operationStack.push(ch);
        }
    }

    /**
     * 符号过滤器3，进行运算
     *
     * @param numStack       数字栈
     * @param operationStack 运算符栈
     */
    private static void operationSolve3(ListStack numStack, ListStack operationStack) {
        int num1 = (int) numStack.pop();
        int num2 = (int) numStack.pop();
        char operation = (char) operationStack.pop();
        int res = cal(num1, num2, operation);
        // 把运算结果加到数栈
        numStack.push(res);
    }

    /**
     * 计算结果
     *
     * @param num1      操作数1，先出栈的数
     * @param num2      操作数2，后出栈的数
     * @param operation 操作符
     * @return 计算结果
     */
    private static int cal(int num1, int num2, char operation) {
        int res = 0;
        switch (operation) {
            case '+' -> res = num1 + num2;
            case '-' -> res = num2 - num1;
            case '*' -> res = num1 * num2;
            case '/' -> res = num2 / num1;
            default -> System.out.println("非法运算符");
        }
        return res;
    }

    /**
     * 返回运算符的优先级，数字越大，运算符越高
     *
     * @param operation 运算符
     * @return 1 or -1 or 0
     */
    private static int priority(char operation) {
        if (operation == '*' || operation == '/') {
            return 1;
        } else if (operation == '+' || operation == '-') {
            return 0;
        } else {
            // 假设目前的表达式只有 + - * /
            return -1;
        }
    }

    /**
     * 处理数字入栈的情况，包含处理多位数的情况，并且返回到操作表达式当前的下标
     *
     * @param expression 表达式
     * @param index      下标
     * @param numStack   数字栈
     * @return 操作表达式当前的下标
     */
    private static int numSolve1(String expression, int index, ListStack numStack) {
        // 需要对多位数进行判断
        int end = index + 1;
        for (; end < expression.length(); end++) {
            // 判断是否为操作符
            char ch = getCharByIndex(expression, end);
            if (!isOperation(ch)) {
                continue;
            } else {
                break;
            }
        }
        // 截取多位数字---获取真正的数字
        String numStr = expression.substring(index, end);
        // 数据入栈
        numStack.push(Integer.valueOf(numStr));
        // 因为test函数进行了+1，所以这里进行-1，避免给重复添加
        return end - 1;
    }

    /**
     * 判断是不是运算符
     *
     * @param val 字符
     * @return 是不是运算符
     */
    private static boolean isOperation(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 获取表达式的下标位置为index的字符
     *
     * @param expression 表达式
     * @param index      下标
     * @return index的字符
     */
    private static char getCharByIndex(String expression, int index) {
        return expression.charAt(index);
    }
}
