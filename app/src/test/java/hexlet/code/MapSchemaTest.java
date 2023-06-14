package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.HashMap;

public class MapSchemaTest {
    private static final String NULL = null;
    private static final Map<String, String> EMPTY_MAP = new HashMap<>();
    private static final Map<String, String> ONE_PAIR_MAP = new HashMap<>(Map.of("key1", "value1"));
    private static final Map<String, String> TWO_PAIR_MAP = new HashMap<>(Map.of("key1", "value1",
            "key2", "value2"));
    private static final Map<String, String> THREE_PAIR_MAP = new HashMap<>(Map.of("key1", "value1", "key2",
            "value2", "key3", "value3"));
    private static final int EXAMPLE_SIZE = 2;
    public static MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = Validator.map();
    }

    @Test
    public void beforeRequired() {
        assertTrue(schema.isValid(NULL));
        assertTrue(schema.isValid(EMPTY_MAP));
        assertTrue(schema.isValid(THREE_PAIR_MAP));
    }

    @Test
    public void requiredTest() {
        assertFalse(schema.required().isValid(NULL));
        assertTrue(schema.isValid(new HashMap<>()));
        assertTrue(schema.isValid(TWO_PAIR_MAP));
    }

    @Test
    public void sizeOfTest() {
        schema.required();
        assertFalse(schema.sizeOf(EXAMPLE_SIZE).isValid(EMPTY_MAP));
        assertFalse(schema.isValid(ONE_PAIR_MAP));
        assertFalse(schema.isValid(THREE_PAIR_MAP));
        assertTrue(schema.isValid(TWO_PAIR_MAP));
    }
}
