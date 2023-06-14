package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {
    protected static StringSchema string() {
        return new StringSchema();
    }

    protected static NumberSchema number() {
        return new NumberSchema();
    }
}
