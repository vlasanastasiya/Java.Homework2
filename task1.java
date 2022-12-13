// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.util.LinkedHashMap;
import java.util.Map;

public class task1 {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name","Ivanov");
        map.put("country","Russia");
        map.put("city","Moscow");
        map.put("age",null);
        

        System.out.println(request(map));
    }

    public static String request(Map<String, String> key) {
        StringBuilder result = new StringBuilder();
        if (key == null || key.isEmpty())
            return result.toString();
        for (Map.Entry<String, String> pair : key.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null)
                continue;
            result.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' ; ");
        }
        if (result.length() > 5)
            result.delete(result.length() - 5, result.length());
        return result.toString();
    }
}