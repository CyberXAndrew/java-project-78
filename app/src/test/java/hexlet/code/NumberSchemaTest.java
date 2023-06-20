package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumberSchemaTest {
    private static final Object POSITIVE_NUMBER = 8;
    private static final Object ZERO = 0;
    private static final Object NEGATIVE_NUMBER = -3;
    private static final Object RANDOM_NUMBER = 5;
    private static NumberSchema schema;
    @BeforeEach
    public void beforeEach() {
        schema = Validator.number();
    }
    @Test
    public void beforeRequiredTest() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(RANDOM_NUMBER));
    }

    @Test
    public void requiredTest() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(POSITIVE_NUMBER));
        assertTrue(schema.isValid(NEGATIVE_NUMBER));
        assertFalse(schema.isValid("5"));
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
        schema.positive();
        assertTrue(schema.isValid(POSITIVE_NUMBER));
        schema.range(-4, 9);
        assertTrue(schema.isValid(POSITIVE_NUMBER));
        assertFalse(schema.isValid(NEGATIVE_NUMBER));
    }
}
