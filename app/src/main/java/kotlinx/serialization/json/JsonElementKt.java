package kotlinx.serialization.json;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.internal.AbstractJsonLexer;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.StringOpsKt;
import kotlinx.serialization.json.internal.WriteModeKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class JsonElementKt {
    public static final InlineClassDescriptor jsonUnquotedLiteralDescriptor = EnumsKt.InlinePrimitiveDescriptor("kotlinx.serialization.json.JsonUnquotedLiteral", StringSerializer.INSTANCE);

    public static final JsonPrimitive JsonPrimitive(String str) {
        return str == null ? JsonNull.INSTANCE : new JsonLiteral(str, true, null);
    }

    public static final void error(String str, JsonElement jsonElement) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(jsonElement.getClass()) + " is not a " + str);
    }

    public static final Boolean getBooleanOrNull(JsonPrimitive jsonPrimitive) {
        String content = jsonPrimitive.getContent();
        String[] strArr = StringOpsKt.ESCAPE_STRINGS;
        content.getClass();
        if (content.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (content.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final String getContentOrNull(JsonPrimitive jsonPrimitive) {
        jsonPrimitive.getClass();
        if (jsonPrimitive instanceof JsonNull) {
            return null;
        }
        return jsonPrimitive.getContent();
    }

    public static final JsonArray getJsonArray(JsonElement jsonElement) {
        jsonElement.getClass();
        JsonArray jsonArray = jsonElement instanceof JsonArray ? (JsonArray) jsonElement : null;
        if (jsonArray != null) {
            return jsonArray;
        }
        error("JsonArray", jsonElement);
        throw null;
    }

    public static final JsonObject getJsonObject(JsonElement jsonElement) {
        jsonElement.getClass();
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject != null) {
            return jsonObject;
        }
        error("JsonObject", jsonElement);
        throw null;
    }

    public static final JsonPrimitive getJsonPrimitive(JsonElement jsonElement) {
        jsonElement.getClass();
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        error("JsonPrimitive", jsonElement);
        throw null;
    }

    public static final long parseLongImpl(JsonPrimitive jsonPrimitive) {
        StringJsonLexer StringJsonLexer = WriteModeKt.StringJsonLexer(Json.Default, jsonPrimitive.getContent());
        String str = StringJsonLexer.source;
        long jConsumeNumericLiteral = StringJsonLexer.consumeNumericLiteral();
        if (StringJsonLexer.consumeNextToken() == 10) {
            return jConsumeNumericLiteral;
        }
        int i = StringJsonLexer.currentPosition;
        int i2 = i > 0 ? i - 1 : i;
        AbstractJsonLexer.fail$default(StringJsonLexer, IntIntPair$$ExternalSyntheticOutline0.m("Expected input to contain a single valid number, but got '", (i == str.length() || i2 < 0) ? "EOF" : String.valueOf(str.charAt(i2)), "' after it"), i2, null, 4);
        throw null;
    }

    public static final JsonPrimitive JsonPrimitive(Number number) {
        return new JsonLiteral(number, false, null);
    }
}
