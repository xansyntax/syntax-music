package io.ktor.websocket;

import io.ktor.http.ContentType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0013\u001a\u00020\u00108VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/FrameTooBigException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlinx/coroutines/CopyableThrowable;", "", "frameSize", "", "cause", "<init>", "(JLjava/lang/Throwable;)V", "(J)V", "createCopy", "()Lio/ktor/websocket/FrameTooBigException;", "J", "getFrameSize", "()J", "", "getMessage", "()Ljava/lang/String;", ContentType.Message.TYPE, "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FrameTooBigException extends Exception implements CopyableThrowable {
    private final long frameSize;

    public /* synthetic */ FrameTooBigException(long j, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : th);
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public FrameTooBigException createCopy() {
        return new FrameTooBigException(this.frameSize, this);
    }

    public final long getFrameSize() {
        return this.frameSize;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        if (this.frameSize >= 0) {
            str = ": " + this.frameSize;
        } else {
            str = "";
        }
        return "Frame is too big".concat(str);
    }

    public FrameTooBigException(long j, Throwable th) {
        super(th);
        this.frameSize = j;
    }

    @Deprecated
    public /* synthetic */ FrameTooBigException(long j) {
        this(j, null);
    }
}
