package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.function.Predicate;

public class BaseSchema {
    protected LinkedList<Predicate<Object>> conditions = new LinkedList<>();
    public void addCondition(Predicate<Object> condition) {
        conditions.add(condition);
    }
    public boolean isValid(Object o) {
        return conditions.stream()
                    .allMatch(condition -> condition.test(o));
    }
}
