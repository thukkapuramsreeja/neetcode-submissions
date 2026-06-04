

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (String t : tokens) {

            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {

                int a = st.pop(); // right operand
                int b = st.pop(); // left operand

                switch (t) {
                    case "+":
                        st.push(b + a);
                        break;

                    case "-":
                        st.push(b - a);
                        break;

                    case "*":
                        st.push(b * a);
                        break;

                    case "/":
                        st.push(b / a); // truncates toward 0
                        break;
                }

            } else {
                st.push(Integer.parseInt(t));
            }
        }

        return st.pop();
    }
}