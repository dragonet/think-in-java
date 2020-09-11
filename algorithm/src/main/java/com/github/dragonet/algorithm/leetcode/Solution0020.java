package com.github.dragonet.algorithm.leetcode;

import junit.framework.Assert;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 * @author xiaolong.qin
 * @date 2020/8/29 2:19 下午
 **/
public class Solution0020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character e = stack.peek();
                if ((e == '(' && c == ')')
                        || (e == '[' && c == ']')
                        || (e == '{' && c == '}')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0020 solution = new Solution0020();
        String s1 = "{}[]()";
        //Assert.assertEquals(true, solution.isValid(s1));

        String s2 = "{[]()}()";
        //Assert.assertEquals(true, solution.isValid(s2));

        String s3 = "{[}[](])";
        Assert.assertEquals(false, solution.isValid(s3));
    }
}
