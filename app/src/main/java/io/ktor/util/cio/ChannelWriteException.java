package io.ktor.util.cio;

import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/util/cio/ChannelWriteException;", "Lio/ktor/util/cio/ChannelIOException;", "", ContentType.Message.TYPE, "", "exception", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChannelWriteException extends ChannelIOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelWriteException(String str, Throwable th) {
        super(str, th);
        str.getClass();
        th.getClass();
    }

    public /* synthetic */ ChannelWriteException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Cannot write to channel" : str, th);
    }
}
