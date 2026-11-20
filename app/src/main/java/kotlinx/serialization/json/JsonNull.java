package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/json/JsonNull;", "Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = JsonNullSerializer.class)
public final class JsonNull extends JsonPrimitive {
    public static final JsonNull INSTANCE = new JsonNull();

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final String getContent() {
        return "null";
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final boolean isString() {
        return false;
    }

    public final KSerializer serializer() {
        return JsonNullSerializer.INSTANCE;
    }
}
