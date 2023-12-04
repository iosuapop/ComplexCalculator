public class Addition extends ComplexExpression{
    public Addition(Operation operation, Complex[] args){
        super(operation, args);
    }
    @Override
    public Complex executeOneOperation(Complex nr, Complex ot){
        return nr.plus(ot);
    }
}