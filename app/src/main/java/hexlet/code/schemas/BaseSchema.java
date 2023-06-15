package hexlet.code.schemas;

//import hexlet.code.Validator;

//import java.util.HashMap;
import java.util.LinkedList;
//import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    protected LinkedList<Predicate<Object>> conditions = new LinkedList<>();
    public void addCondition(Predicate<Object> condition) {
        conditions.add(condition);
    }
    public boolean isValid(Object o) { //o -> map.get(key).isValid(o)
        return conditions.stream()
                    .allMatch(condition -> condition.test(o));
    }
}

