public class validParenthesis {
    // Check if parentheses are valid (LeetCode 20)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    
    public static boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    // Alternative solution with cleaner matching
    public static boolean isValidAlt(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        java.util.Map<Character, Character> pairs = new java.util.HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                // Closing bracket
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                // Opening bracket
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String[] testCases = {
            "()",      // true
            "()[]{}", // true
            "([{}])", // true
            "([)]",   // false
            "{[}",    // false
            "",       // true
            "(",      // false
            ")"       // false
        };
        
        for (String test : testCases) {
            System.out.println("\"" + test + "\" is valid: " + isValid(test));
        }
    }
}
