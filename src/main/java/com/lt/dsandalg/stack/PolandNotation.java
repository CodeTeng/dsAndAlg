package com.lt.dsandalg.stack;

import java.util.*;

/**
 * @description: 逆波兰表达式计算器
 * @author: ~Teng~
 * @date: 2022/9/3 13:29
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 定义一个逆波兰表达式
        // (3+4)*5-6 => 3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";
        // 先将3 4 + 5 * 6 - 放入一个链表，配合栈完成计算
        List<String> listString = getListString(suffixExpression);
        System.out.println(calculate(listString));
    }

    /**
     * 计算逆波兰表达式最终结果
     *
     * @param stringList 数据和运算符链表
     * @return 计算结果
     */
    private static int calculate(List<String> stringList) {
        // 创建一个栈
        Deque<String> stack = new ArrayDeque<>();
        // 开始遍历链表
        for (String element : stringList) {
            // 如果是数字
            if (element.matches("\\d+")) {
                stack.push(element);
            } else {
                // 出栈两个数
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = switch (element) {
                    case "+" -> num1 + num2;
                    case "-" -> num2 - num1;
                    case "*" -> num1 * num2;
                    case "/" -> num2 / num1;
                    default -> throw new RuntimeException("运算符有误");
                };
                // res入栈
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 将逆波兰表达式的数据和运算符依次放到ArrayList中
     *
     * @param suffixExpression 逆波兰表达式
     * @return 链表
     */
    private static List<String> getListString(String suffixExpression) {
        String[] strings = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        return list;
    }
}
