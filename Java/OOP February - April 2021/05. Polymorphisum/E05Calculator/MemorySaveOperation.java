package E05Calculator;

import java.util.ArrayList;
import java.util.List;

public class MemorySaveOperation implements Operation {
    private List<Integer> operands;
    private int result;
    public static List<Integer> memorySavedList = new ArrayList<>();

    public MemorySaveOperation() {
        this.operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = this.operands.get(0);
            memorySavedList.add(this.result);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 1;
    }
}
