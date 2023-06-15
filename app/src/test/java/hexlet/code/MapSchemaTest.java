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
//    private final Map<String, Object> HUMAN_1 = new HashMap<>(Map.of("name", "Kolya", "age", 100));
//    private final Map<String, Object> HUMAN_2 = new HashMap<>(Map.of("name", "Maya", "age", null));
//    private final Map<String, Object> HUMAN_3 = new HashMap<>(Map.of("name", "", "age", null));
//    private final Map<String, Object> HUMAN_4 = new HashMap<>(Map.of("name", "Valya", "age", -5));
    private static final int EXAMPLE_SIZE = 2;
    public MapSchema schema;
    public Map<String, BaseSchema> schemas;
    Map<String, Object> human1;
    Map<String, Object> human2;
    Map<String, Object> human3;
    Map<String, Object> human4;

    @BeforeEach
    public void beforeEach() {
        schema = Validator.map();
        schemas = new HashMap<>();
        human1 = Map.of("name", "Kolya", "age", 100);
        human2 = Map.of("name", "Maya", "age", null);
        human3 = Map.of("name", "", "age", null);
        human4 = Map.of("name", "Valya", "age", -5);
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
    public void nestedObjectsTest1() {   // NULL были заменены
        schemas.putAll(Map.of("name", Validator.string().required(), "age", Validator.number().positive()));
        schema.shape(schemas);
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human1));
        assertTrue(schema.isValid(human2));
        assertFalse(schema.isValid(human3));
        assertFalse(schema.isValid(human4));
    }
    @Test
    public void nestedObjectsTest2() { // NULL были заменены
        schemas.putAll(Map.of("name", Validator.string().required().contains("lya"), "age", Validator.number()
                .range(-1, 8)));
        schema.shape(schemas);
        assertFalse(schema.isValid(human1));
//        assertFalse(schema.isValid(human2));
        assertFalse(schema.isValid(human4));
    }
    @Test
    public void nestedObjectsTest3() { // NULL были заменены
        schemas.putAll(Map.of("name", Validator.string().required().contains("lya"), "age", Validator.number()
                .range(-1, 100)));
        schema.shape(schemas);
        assertTrue(schema.isValid(human1));
        assertFalse(schema.isValid(human4));
    }
}
