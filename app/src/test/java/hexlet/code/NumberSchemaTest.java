package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    private static final Object NULL = null;
    private static final Object POSITIVE_NUMBER = 8;
    private static final Object ZERO = 0;
    private static final Object NEGATIVE_NUMBER = -3;
    private static final Object STRING = "5";
    private NumberSchema schema;
    @BeforeEach
    public void beforeEach() {
        schema = Validator.number();
    }
    @Test
    public void beforeRequiredTest() {
        assertTrue(schema.isValid(NULL));
        assertTrue(schema.isValid(5));
    }

    @Test
    public void requiredTest() {
        schema.required();
        assertFalse(schema.isValid(NULL));
        assertTrue(schema.isValid(POSITIVE_NUMBER));
        assertTrue(schema.isValid(NEGATIVE_NUMBER));
        assertFalse(schema.isValid(STRING));
    }

    @Test
    public void positiveTest() {
        schema.required().positive();
        assertTrue(schema.isValid(POSITIVE_NUMBER));
        assertFalse(schema.isValid(ZERO));
        assertFalse(schema.isValid(NEGATIVE_NUMBER));
    }

    @Test
    public void rangeTest() {
        schema.required().range(8, 8);
        assertTrue(schema.isValid(POSITIVE_NUMBER));
        assertFalse(schema.isValid(NEGATIVE_NUMBER));

        schema = Validator.number().required().range(7, 8);
        assertTrue(schema.isValid(POSITIVE_NUMBER));
    }

    @Test
    public void requiredMethodsChainTest() {
        schema.required();
        assertTrue(schema.positive().isValid(POSITIVE_NUMBER));
        assertTrue(schema.range(-4, 9).isValid(POSITIVE_NUMBER));
        assertFalse(schema.isValid(NEGATIVE_NUMBER));
    }
}
