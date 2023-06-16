package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    public StringSchema required() {
        Predicate<Object> requiredCondition = x -> !Objects.equals(x, null) && !Objects.equals(x, "");
        addCondition(requiredCondition);
        return this;
    }
    public StringSchema minLength(int number) {
        if (number < 0) {
            throw new IndexOutOfBoundsException("Index less than zero!");
        }
        Predicate<Object> stringLength = x -> ((String) x).length() >= number;
        addCondition(stringLength);
        return this;
    }
    public StringSchema contains(String string) {
        Predicate<Object> substring = x -> ((String) x).contains(string);
        addCondition(substring);
        return this;
    }
}
