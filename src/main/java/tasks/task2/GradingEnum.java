package tasks.task2;

import java.util.List;

public enum GradingEnum {
    EXCELLENT, GOOD, SATISFACTORY, UNSATISFACTORY;

    private static final List<GradingEnum> gradings = List.of(GradingEnum.values());
    private static int index = 0;

    public List<GradingEnum> showAll() {
        return gradings;
    }

    public GradingEnum next() {
        if (index < gradings.size() - 1) {
            index++;
        }
        return gradings.get(index);
    }

    public GradingEnum previous() {
        if (index > 0) {
            index--;
        }
        return gradings.get(index);
    }
}
