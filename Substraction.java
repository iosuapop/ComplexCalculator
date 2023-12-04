public class Substraction extends ComplexExpression{
    Substraction(Operation operation, Complex[] args){
        super(operation, args);
    }
    @Override
    public Complex executeOneOperation(Complex nr, Complex ot){
        return nr.minus(ot);
    }
}