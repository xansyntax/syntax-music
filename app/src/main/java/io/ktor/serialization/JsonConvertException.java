package io.ktor.serialization;

import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/serialization/JsonConvertException;", "Lio/ktor/serialization/ContentConvertException;", "", ContentType.Message.TYPE, "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ktor-serialization"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonConvertException extends ContentConvertException {
    public /* synthetic */ JsonConvertException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonConvertException(String str, Throwable th) {
        super(str, th);
        str.getClass();
    }
}
