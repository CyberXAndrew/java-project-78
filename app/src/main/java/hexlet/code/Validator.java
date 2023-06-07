package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class Validator {
    public StringSchema schema;
    public StringSchema string() {
        this.schema = new StringSchema();
        return schema;
    }
}
