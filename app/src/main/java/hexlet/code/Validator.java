package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.MapSchema;

public class Validator {
    protected static StringSchema string() {
        return new StringSchema();
    }
    protected static NumberSchema number() {
        return new NumberSchema();
    }
    protected static MapSchema map() {
        return new MapSchema();
    }
}
