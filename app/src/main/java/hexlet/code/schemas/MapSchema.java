package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        Predicate<Object> requiredCondition = x -> x instanceof Map;
        addCondition(requiredCondition);
        return this;
    }

    public MapSchema sizeof(int number) {
        Predicate<Object> sizeCondition = x -> ((Map<?, ?>) x).size() == number;
        addCondition(sizeCondition);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        map.keySet().forEach(key -> addCondition(o -> map.get(key).isValid(((Map<?, ?>) o).get(key))));
        return this;
    }
}


