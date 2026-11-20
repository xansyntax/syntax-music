package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/ClosedWriteChannelException;", "Lio/ktor/utils/io/ClosedByteChannelException;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ClosedWriteChannelException extends ClosedByteChannelException {
    public /* synthetic */ ClosedWriteChannelException(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th);
    }

    public ClosedWriteChannelException(Throwable th) {
        super(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClosedWriteChannelException() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}
