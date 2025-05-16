package task1;
/*
push(item) — добавляет элемент к вершине стека.
pop() — удаляет и возвращает элемент с вершины стека.
peek() — возвращает элемент на вершине стека, не удаляя его.
isEmpty() — проверяет, пуст ли стек.
size() — возвращает количество элементов в стеке.
clear() — удаляет все элементы из стека.
contains(item) — проверяет, содержит ли стек указанный элемент.
 */

import java.util.Stack;

public class stack {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[]})")); // true
        System.out.println(isValid("(((())))")); // true
        System.out.println(isValid("[{]}")); // false
        System.out.println(isValid("(()")); // false
    }
}