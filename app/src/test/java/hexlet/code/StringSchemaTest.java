package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTest {
    private static final int RANDOM_INTEGER = 7;
    private static final int WRONG_LENGTH = 10;
    private static final int RIGHT_LENGTH = 5;
    private StringSchema schema;
    @BeforeEach
    public void beforeEach() {
        schema = Validator.string();
    }
    @Test
    public void beforeRequiredTest() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(RANDOM_INTEGER));
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("String"));
    }

    @Test
    public void requiredIsValidTest() {
        schema.required();
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid(RANDOM_INTEGER));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("String"));
    }

    @Test
    public void requiredMethodsChainTest() {
        schema.required();
        schema.contains("what");
        assertTrue(schema.isValid("what does"));

        schema = Validator.string().required();
        schema.contains("why");
        assertFalse(schema.isValid("what does"));

        schema = Validator.string().required();
        schema.minLength(RIGHT_LENGTH);
        schema.contains("what");
        assertTrue(schema.isValid("what does"));

        schema = Validator.string().required();
        schema.minLength(WRONG_LENGTH);
        assertFalse(schema.isValid("what does"));

        schema = Validator.string().required();
        schema.minLength(RIGHT_LENGTH);
        schema.contains("what");
        assertTrue(schema.isValid("what does"));

        schema = Validator.string().required();
        schema.minLength(RIGHT_LENGTH);
        schema.contains("what");
        assertTrue(schema.isValid("what does"));
        assertFalse(schema.contains("why").isValid("what does"));
    }
}
