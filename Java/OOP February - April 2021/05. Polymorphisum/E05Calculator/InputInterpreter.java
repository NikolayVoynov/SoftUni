package E05Calculator;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
    }

    public boolean interpret(String input) {
        try {
            if ("mr".equals(input)) {
                int lastIndex = MemorySaveOperation.memorySavedList.size() - 1;
                int operand = MemorySaveOperation.memorySavedList.remove(lastIndex);
                engine.pushNumber(operand);
            } else {
                engine.pushNumber(Integer.parseInt(input));
            }

        } catch (Exception ex) {
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("ms")) {
            return new MemorySaveOperation();
        }

        return null;
    }
}
