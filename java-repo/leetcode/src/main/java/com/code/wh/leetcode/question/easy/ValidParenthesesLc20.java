package com.code.wh.leetcode.question.easy;

import java.util.Stack;

/**
 * @description:20 有效的括号 https://leetcode.cn/problems/valid-parentheses/
 * @author: 王欢
 * @create: 2022/10/11 11:34
 **/
public class ValidParenthesesLc20 {
    public boolean isValid(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> characterStack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(' || c == '[' || c == '{') {
                characterStack.push(c);
            } else {
                if (characterStack.isEmpty()) {
                    return false;
                }
                char peekChar = characterStack.pop();
                if (c == ')' && peekChar == '(') {
                    continue;
                }
                if (c == ']' && peekChar == '[') {
                    continue;
                }
                if (c == '}' && peekChar == '{') {
                    continue;
                }
                return false;
            }
        }
        if (characterStack.isEmpty()) {
            return true;
        }
        return false;
    }
}
