package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        Predicate<Object> requiredCondition = x -> x instanceof Map;
        conditions.addFirst(requiredCondition);
        return this;
    }

    public MapSchema sizeOf(int number) {
        Predicate<Object> sizeCondition = x -> ((Map<?, ?>) x).size() == number;
        conditions.add(sizeCondition);
        return this;
    }
}
