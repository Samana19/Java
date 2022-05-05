public class BalanceParanthesis {
    
    public boolean isBalanced(String exp) {
        StackExample stack = new StackExample(exp.length());
        String openingbracket = "([{";
        String closingbracket = ")]}";

        for (int i = 0; i < exp.length(); i++) {
            char bracket=exp.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            }
            else{
                int index = closingbracket.indexOf(bracket);
                char openingbraces=openingbracket.charAt(index);
                if(stack.pop()!=openingbraces){
                    return false;
                }
            }
            if(stack.isEmpty()){
                return false;
            }
}
        return true; }}