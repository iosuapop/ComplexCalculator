import java.util.Stack;

public class ExpressionParser {
    private final ExpressionFactory expressionFactory;

    public ExpressionParser(){
        this.expressionFactory = ExpressionFactory.getInstance();
    }

    public Complex parseExpression(String[] args) throws Exception{
        if (args.length % 2 == 0){
            throw new Exception("Not a valid expresion.");
        }

        Stack<Complex> orderStack = new Stack<>();
        boolean add = false;
        boolean sub = false;
        boolean times = false;
        boolean div = false;

        Complex[] operands = new Complex[2];

        for(int i=0; i< args.length; i++){
            if(i%2 == 0 && (args[i].equals("+") || args[i].equals("-") || args[i].equals("*") || args[i].equals("/"))) {
                throw new ArithmeticException("Operator expected.");
            }

            if(i%2 != 0 && Complex.checkOk(args[i])) {
                throw new ArithmeticException("Number at invalid position.");
            }
            switch(args[i]) {
                case "+" -> {
                    add = true;
                    continue;
                }
                case "-" -> {
                    sub = true;
                    continue;
                }
                case "*" -> {
                    times = true;
                    continue;
                }
                case "/" -> {
                    div = true;
                    continue;
                }
            }

            Complex ot = new Complex(args[i]);
            operands[0] = ot;
            if (add){
                operands[1] = orderStack.pop();
                Complex partial_result = expressionFactory.createExpression(Operation.ADDITION, operands).execute();
                orderStack.push(partial_result);
                add = false;
                //System.out.println(partial_result);
            }else
            if (sub){
                operands[1] = orderStack.pop();
                Complex partial_result = expressionFactory.createExpression(Operation.SUBSTRACTION, operands).execute();
                orderStack.push(partial_result);
                sub = false;
                //System.out.println(partial_result);
            }else
            if (times){
                operands[1] = orderStack.pop();
                Complex partial_result = expressionFactory.createExpression(Operation.MULTIPLICATION, operands).execute();
                orderStack.push(partial_result);
                times = false;
                //System.out.println(partial_result);
            }else
            if (div){
                operands[1] = orderStack.pop();
                Complex partial_result = expressionFactory.createExpression(Operation.DIVISION, operands).execute();
                orderStack.push(partial_result);
                div = false;
                //System.out.println(partial_result);
            }else{
                orderStack.push(operands[0]);
            }
        }

        Complex result = new Complex(0,0);
        while(!orderStack.empty()){
            operands[0] = result;
            operands[1] = orderStack.pop();
            result = expressionFactory.createExpression(Operation.ADDITION, operands).execute();
        }
        return result;
    }

}
