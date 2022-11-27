package utility;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JsonUtility {

    public static final Gson GSON = new Gson();

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return GSON.fromJson(json, classOfT);
    }
}
