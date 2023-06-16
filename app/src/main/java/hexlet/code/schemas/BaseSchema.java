package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final LinkedList<Predicate<Object>> conditions = new LinkedList<>();
    protected final void addCondition(Predicate<Object> condition) {
        conditions.add(condition);
    }
    public final boolean isValid(Object o) {
        return conditions.stream()
                    .allMatch(condition -> condition.test(o));
    }
}

