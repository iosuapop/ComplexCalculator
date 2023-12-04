public class Division extends ComplexExpression{
    Division(Operation operation, Complex[] args){
        super(operation, args);
    }
    @Override
    public Complex executeOneOperation(Complex nr, Complex ot){
        return nr.div(ot);
    }
}
