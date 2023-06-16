package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        Predicate<Object> requiredCondition = x -> x instanceof Integer;
        conditions.addFirst(requiredCondition);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> positiveCondition = x -> x == null || ((Integer) x) > 0;
        conditions.add(positiveCondition);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        Predicate<Object> rangeCondition = x -> x == null || ((Integer) x) >= begin && ((Integer) x) <= end;
        conditions.add(rangeCondition);
        return this;
    }
}
