package io.ktor.http;

import io.ktor.utils.io.JvmSerializer;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/http/UrlJvmSerializer;", "Lio/ktor/utils/io/JvmSerializer;", "Lio/ktor/http/Url;", "<init>", "()V", "value", "", "jvmSerialize", "(Lio/ktor/http/Url;)[B", "jvmDeserialize", "([B)Lio/ktor/http/Url;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UrlJvmSerializer implements JvmSerializer<Url> {
    public static final UrlJvmSerializer INSTANCE = new UrlJvmSerializer();

    private UrlJvmSerializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.ktor.utils.io.JvmSerializer
    public Url jvmDeserialize(byte[] value) {
        value.getClass();
        return URLUtilsKt.Url(StringsKt__StringsJVMKt.decodeToString(value));
    }

    @Override // io.ktor.utils.io.JvmSerializer
    public byte[] jvmSerialize(Url value) {
        value.getClass();
        return StringsKt__StringsJVMKt.encodeToByteArray(value.getUrlString());
    }
}
