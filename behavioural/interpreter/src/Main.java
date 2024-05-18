// Expression interface
interface Expression {
    int interpret();
}

// Terminal expression class for numbers
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

// Non-terminal expression class for addition
class AdditionExpression implements Expression {
    private Expression left;
    private Expression right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create expression: 1 + 2 + 3
        Expression expression = new AdditionExpression(
                new AdditionExpression(new NumberExpression(1), new NumberExpression(2)),
                new NumberExpression(3)
        );

        // Interpret and evaluate the expression
        int result = expression.interpret();
        System.out.println("Result: " + result);
    }
}
