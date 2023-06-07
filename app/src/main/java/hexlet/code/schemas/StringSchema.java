package hexlet.code.schemas;

import java.util.Objects;

public class StringSchema {
    private boolean constraint = false;
    private String substring = "";
    private int stringLength;

    public boolean isValid(Object o) {
        if (!constraint) { //на всё вернёт true
            return true;
        } else if (Objects.equals(o, null) || Objects.equals(o.toString(), "")) {
            return false; //false если o это null или ""
        } else if (!(o instanceof String)) {
            return false; //фолс если не строковый объект
        } else if (!substring.isEmpty() && !(o.toString()).contains(substring)) { //String.valueOf(o)
            return false; //если есть подстрока и значения не совпадают фолс
        } else {
            return stringLength == 0 || (o.toString()).length() >= stringLength;
        }
    }
    public void required() {
        this.constraint = true;
    }
    public StringSchema minLength(int number) {
        if (number < 0) {
            throw new IndexOutOfBoundsException("Index less than zero");
        }
        this.stringLength = number;
        return this;
    }
    public StringSchema contains(String string) {
        this.substring = string;
        return this;
    }
//    public StringSchema contains(String string) {
//        StringSchema ss = new StringSchema();
//        ss.required();
//        ss.substring = string;
//        return ss;
//    }
}
