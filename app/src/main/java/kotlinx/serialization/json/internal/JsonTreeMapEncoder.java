package kotlinx.serialization.json.internal;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonTreeMapEncoder extends JsonTreeEncoder {
    public boolean isKey;
    public String tag;

    @Override // kotlinx.serialization.json.internal.JsonTreeEncoder
    public final JsonElement getCurrent() {
        return new JsonObject((LinkedHashMap) this.content);
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeEncoder
    public final void putElement(String str, JsonElement jsonElement) {
        str.getClass();
        jsonElement.getClass();
        if (!this.isKey) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.content;
            String str2 = this.tag;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tag");
                throw null;
            }
            linkedHashMap.put(str2, jsonElement);
            this.isKey = true;
            return;
        }
        if (jsonElement instanceof JsonPrimitive) {
            this.tag = ((JsonPrimitive) jsonElement).getContent();
            this.isKey = false;
        } else {
            if (jsonElement instanceof JsonObject) {
                throw WriteModeKt.InvalidKeyKindException(JsonObjectSerializer.descriptor);
            }
            if (jsonElement instanceof JsonArray) {
                throw WriteModeKt.InvalidKeyKindException(JsonArraySerializer.descriptor);
            }
            PathKt$$ExternalSyntheticBUOutline0.m$1();
        }
    }
}
