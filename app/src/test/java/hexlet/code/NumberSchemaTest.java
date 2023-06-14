//package hexlet.code;
//
//import hexlet.code.schemas.StringSchema;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class NumberSchemaTest {
//    private static final Object NULL = null;
//    private StringSchema schema;
//    @BeforeEach
//    public void beforeEach() {
//        Validator v = new Validator();
//        schema = v.number();
//    }
//    @Test
//    public void beforeRequiredTest() {
//        assertTrue(schema.isValid(NULL));
//
//    }
//}
