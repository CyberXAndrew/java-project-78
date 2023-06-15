package hexlet.code.schemas;

//import hexlet.code.Validator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    protected LinkedList<Predicate<Object>> conditions = new LinkedList<>();
    protected Map<String, BaseSchema> mapConditions = new HashMap<>();
    public void addCondition(Predicate<Object> condition) {
        conditions.add(condition);
    }
    public boolean isValid(Object o) {
        if (((Map <?, ?>) o).values() instanceof BaseSchema) {// ВОТ ТУТ
            return mapConditions.keySet().stream()
                    .allMatch(key -> mapConditions.get(key).conditions.stream()
                        .allMatch(condition -> condition.test(((Map<?, ?>) o).get(key))));
        }
        return conditions.stream()
                    .allMatch(condition -> condition.test(o));
    }
}
//            for (String key : mapConditions.keySet()) { //Map.Entry<String, BaseSchema> key : mapConditions.entrySet()
//                BaseSchema schema =  mapConditions.get(key); //v.number().positive()
//                return schema.conditions.stream()
//                        .allMatch(condition -> condition.test(((Map<?, ?>) o).get(key)));
//            }
