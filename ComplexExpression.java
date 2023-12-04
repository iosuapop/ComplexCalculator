public abstract class ComplexExpression {
    protected Complex[] args;
    protected Operation operation;

    public ComplexExpression(Operation op, Complex[] args){
        this.operation = op;
        this.args = args;
    }
    public Complex execute(){
        Complex result = this.args[0];
        for(int i = 1; i < args.length; ++i) {
            result = executeOneOperation(result, args[i]);
        }
        return result;
    }

    protected abstract Complex executeOneOperation(Complex nr, Complex ot);
}
