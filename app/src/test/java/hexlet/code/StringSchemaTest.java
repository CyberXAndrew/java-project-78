package hexlet.code;

import hexlet.code.schemas.StringSchema;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private static final String EMPTY_STRING = "";
    private static final String NULL = null;
    private static final int RANDOM_INTEGER = 7;
    private static final int WRONG_LENGTH = 10;
    private static final int RIGHT_LENGTH = 5;
    private static final String RANDOM_STRING = "String";
    private static final Object OBJECT = new Validator();
    private static final String CONTROL_STRING = "what does";
    private static final String CORRECT_SUBSTRING = "wh";
    private static final String INCORRECT_SUBSTRING = "wh ";

    @Test
    public void beforeRequiredTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.isValid(EMPTY_STRING));
        assertTrue(schema.isValid(RANDOM_INTEGER));
        assertTrue(schema.isValid(NULL));
        assertTrue(schema.isValid(RANDOM_STRING));
        assertTrue(schema.isValid(OBJECT));
    }

    @Test
    public void requiredIsValidTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        schema.required();
        assertFalse(schema.isValid(EMPTY_STRING));
        assertFalse(schema.isValid(RANDOM_INTEGER));
        assertFalse(schema.isValid(NULL));
        assertTrue(schema.isValid(RANDOM_STRING));
        assertFalse(schema.isValid(OBJECT));
    }

    @Test
    public void requiredMethodsChainTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        schema.required();
        assertTrue(schema.contains(CORRECT_SUBSTRING).isValid(CONTROL_STRING));
        assertFalse(schema.contains(INCORRECT_SUBSTRING).isValid(CONTROL_STRING));
        assertTrue(schema.minLength(RIGHT_LENGTH).contains(CORRECT_SUBSTRING).isValid(CONTROL_STRING));
        assertFalse(schema.minLength(WRONG_LENGTH).isValid(CONTROL_STRING));
        assertFalse(schema.minLength(WRONG_LENGTH).contains(CORRECT_SUBSTRING).isValid(CONTROL_STRING));
        assertFalse(schema.minLength(RIGHT_LENGTH).contains(INCORRECT_SUBSTRING).isValid(CONTROL_STRING));
        assertFalse(schema.isValid(CONTROL_STRING));
    }
}
