package kotlinx.serialization.json;

import kotlinx.serialization.SerializationException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class JsonException extends SerializationException {
    public final String message;

    public JsonException(String str) {
        super(str);
        this.message = str;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}
