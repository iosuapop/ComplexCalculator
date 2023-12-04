public class Main {
    public static void main(String[] args) throws Exception {
        String[] expr1 = {"4.4+3.9*i", "+", "1.7-9.3*i"}; //6.1-5.4*i
        String[] expr2 = {"2.2+2.1*i", "/", "3.9+1.6*i", "*", "3.1+6.1*i"}; // 0.49+4.88*i
        String[] expr3 = {"4.0+2.0*i", "+", "1.3+20.0*i"};// 5.3+22*i

        ExpressionParser expressionParser = new ExpressionParser();
        System.out.println(expressionParser.parseExpression(expr1));
        System.out.println(expressionParser.parseExpression(expr2));
        System.out.println(expressionParser.parseExpression(expr3));

        String[] expr = args[0].split(",");
        System.out.println(expressionParser.parseExpression(expr));
    }
}