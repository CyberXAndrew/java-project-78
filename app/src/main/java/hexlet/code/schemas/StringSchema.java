package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    public void required() {
        Predicate<Object> required = x -> !Objects.equals(x, null) && !Objects.equals(x, "");
        conditions.addFirst(required);
    }
    public void minLength(int number) {
        if (number < 0) {
            throw new IndexOutOfBoundsException("Index less than zero!");
        }
        Predicate<Object> stringLength = x -> ((String) x).length() >= number;
        addCondition(stringLength);
    }
    public void contains(String string) {
        Predicate<Object> substring = x -> ((String) x).contains(string);
        addCondition(substring);
    }
}
