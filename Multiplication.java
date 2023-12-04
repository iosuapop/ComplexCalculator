public class Multiplication extends ComplexExpression{
    Multiplication(Operation operation, Complex[] args){
        super(operation, args);
    }
    @Override
    public Complex executeOneOperation(Complex nr, Complex ot){
        return nr.times(ot);
    }
}