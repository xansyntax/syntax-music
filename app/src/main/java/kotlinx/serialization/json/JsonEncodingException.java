package kotlinx.serialization.json;

import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonEncodingException extends JsonException {
    public JsonEncodingException(String str, String str2) {
        super(str.concat((str2 == null || StringsKt.isBlank(str2)) ? "" : "\n".concat(str2)));
    }
}
