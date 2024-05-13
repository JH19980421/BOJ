import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q01918 {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (checkCalculate(c)) {
                case -1:
                    sb.append(c);
                    break;
                case  0:
                    if (c=='(') {
                        stack.add(c);
                        break;
                    }
                    else while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    while (!stack.isEmpty() && checkCalculate(stack.peek()) >= checkCalculate(c))
                        sb.append(stack.pop());
                    stack.add(c);
                    break;
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.toString());
    }

    static int checkCalculate(char c) {
        if (c == '(' || c == ')') return 0;
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return -1;
    }
}
