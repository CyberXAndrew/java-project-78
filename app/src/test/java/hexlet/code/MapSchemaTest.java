package hexlet.code;

import hexlet.code.schemas.BaseSchema;
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
    public MapSchema schema;
    public Map<String, BaseSchema> schemas;
    Map<String, Object> human1 = new HashMap<>();
    Map<String, Object> human2 = new HashMap<>();
    Map<String, Object> human3 = new HashMap<>();
    Map<String, Object> human4 = new HashMap<>();

    @BeforeEach
    public void beforeEach() {
        schema = Validator.map();
        schemas = new HashMap<>();

        human1.put("name", "Kolya");
        human1.put("age", 100);

        human2.put("name", "Maya");
        human2.put("age", null);

        human3.put("name", "");
        human3.put("age", null);

        human4.put("name", "Valya");
        human4.put("age", -5);
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
        assertTrue(schema.isValid(EMPTY_MAP));
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

    @Test
    public void nestedObjectsTest1() {
        schemas.put("name", Validator.string().required());
        schemas.put("age", Validator.number().positive());
        schema.shape(schemas);
        assertTrue(schema.isValid(human1)); //kolya 100
        assertTrue(schema.isValid(human2)); //maya null
        assertFalse(schema.isValid(human3)); // "" null
        assertFalse(schema.isValid(human4)); //valya -5
    }
    @Test
    public void nestedObjectsTest2() {
        schemas.put("name", Validator.string().contains("lya"));
        schemas.put("age", Validator.number().range(-5, 8));
        schema.shape(schemas);
        assertFalse(schema.isValid(human1));
        assertFalse(schema.isValid(human2));
        assertFalse(schema.isValid(human3));
        assertTrue(schema.isValid(human4));
    }
    @Test
    public void nestedObjectsTest3() {
        schemas.put("name", Validator.string());
        schemas.put("age", Validator.number().range(-1, 100));
        assertTrue(schema.shape(schemas).isValid(human3));
        assertFalse(schema.isValid(human4));
    }
}
