package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a&\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/OutputStream;", "out", "", "limit", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/io/OutputStream;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WritingKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.WritingKt", f = "Writing.kt", l = {25}, m = "copyTo", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WritingKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:21:0x005c  */
    /* JADX WARN: Code duplicated, block: B:23:0x006f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005a -> B:26:0x0080). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0070 -> B:25:0x0078). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:31:0x00ad
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r19, java.io.OutputStream r20, long r21, kotlin.coroutines.Continuation r23) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.WritingKt.copyTo(io.ktor.utils.io.ByteReadChannel, java.io.OutputStream, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, OutputStream outputStream, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, outputStream, j, continuation);
    }
}
