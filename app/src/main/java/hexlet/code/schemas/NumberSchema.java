package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        Predicate<Object> requiredCondition = x -> x instanceof Integer; //&& !Objects.equals(x, null)
        conditions.addFirst(requiredCondition);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> positiveCondition = x -> ((int) x) > 0;
        conditions.add(positiveCondition);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        Predicate<Object> rangeCondition = x -> ((int) x) >= begin && ((int) x) <= end;
        conditions.add(rangeCondition);
        return this;
    }
}
