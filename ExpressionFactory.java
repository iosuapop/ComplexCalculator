public class ExpressionFactory implements Factory{
    //singleton class
    private static final ExpressionFactory instance = new ExpressionFactory();

    private ExpressionFactory(){}
    public static ExpressionFactory getInstance(){
        return instance;
    }

    @Override
    public ComplexExpression createExpression(Operation operation, Complex[] args){
        return switch (operation){
            case ADDITION -> new Addition(Operation.ADDITION,args);
            case SUBSTRACTION -> new Substraction(Operation.SUBSTRACTION,args);
            case MULTIPLICATION -> new Multiplication(Operation.MULTIPLICATION,args);
            case DIVISION -> new Division(Operation.DIVISION,args);
        };
    }

}
