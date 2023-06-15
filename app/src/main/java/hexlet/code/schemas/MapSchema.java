package hexlet.code.schemas;

//import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    //    protected Map<String, BaseSchema> mapConditions = new HashMap<>();
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

    public MapSchema shape(Map<String, BaseSchema> map) {
        map.keySet().forEach(key -> conditions.add(o -> map.get(key).isValid(o)));
        return this;
    }
}


