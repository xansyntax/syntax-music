package io.ktor.utils.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.websocket.ControlFramesKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.io.Buffer;
import kotlinx.io.Source;
import kotlinx.io.bytestring.ByteString;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0080@¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lio/ktor/utils/io/ByteChannelScanner;", "", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "Lkotlinx/io/bytestring/ByteString;", "matchString", "Lio/ktor/utils/io/ByteWriteChannel;", "writeChannel", "", "limit", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteWriteChannel;J)V", "", "ignoreMissing", "findNext$ktor_io", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findNext", "", "buildPartialMatchTable", "()[I", "", "advanceToNextPotentialMatch", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkFullMatch", "extra", "checkBounds", "(J)V", "", "toSingleLineString", "(Lkotlinx/io/bytestring/ByteString;)Ljava/lang/String;", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/io/bytestring/ByteString;", "Lio/ktor/utils/io/ByteWriteChannel;", "J", "Lkotlinx/io/Source;", "input", "Lkotlinx/io/Source;", "partialMatchTable", "[I", "Lkotlinx/io/Buffer;", "partialMatchBuffer", "Lkotlinx/io/Buffer;", "bytesRead", "", "matchIndex", "I", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ByteChannelScanner {
    private long bytesRead;
    private final ByteReadChannel channel;
    private final Source input;
    private final long limit;
    private int matchIndex;
    private final ByteString matchString;
    private final Buffer partialMatchBuffer;
    private final int[] partialMatchTable;
    private final ByteWriteChannel writeChannel;

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelScanner$advanceToNextPotentialMatch$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelScanner", f = "ByteChannelScanner.kt", l = {99, 105, 111}, m = "advanceToNextPotentialMatch", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelScanner.this.advanceToNextPotentialMatch(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelScanner$checkFullMatch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelScanner", f = "ByteChannelScanner.kt", l = {ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE, 143}, m = "checkFullMatch", v = 1)
    public static final class C03331 extends ContinuationImpl {
        byte B$0;
        int I$0;
        long J$0;
        int label;
        /* synthetic */ Object result;

        public C03331(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelScanner.this.checkFullMatch(this);
        }
    }

    public ByteChannelScanner(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j) {
        byteReadChannel.getClass();
        byteString.getClass();
        byteWriteChannel.getClass();
        this.channel = byteReadChannel;
        this.matchString = byteString;
        this.writeChannel = byteWriteChannel;
        this.limit = j;
        if (byteString.data.length <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Empty match string not permitted for scanning");
            throw null;
        }
        this.input = byteReadChannel.getReadBuffer();
        this.partialMatchTable = buildPartialMatchTable();
        this.partialMatchBuffer = new Buffer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x005d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009b -> B:19:0x0042). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object advanceToNextPotentialMatch(kotlin.coroutines.Continuation r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof io.ktor.utils.io.ByteChannelScanner.AnonymousClass1
            if (r2 == 0) goto L17
            r2 = r1
            io.ktor.utils.io.ByteChannelScanner$advanceToNextPotentialMatch$1 r2 = (io.ktor.utils.io.ByteChannelScanner.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            io.ktor.utils.io.ByteChannelScanner$advanceToNextPotentialMatch$1 r2 = new io.ktor.utils.io.ByteChannelScanner$advanceToNextPotentialMatch$1
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            int r3 = r2.label
            r4 = 0
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r6 = 0
            r7 = 3
            r8 = 2
            r9 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r3 == 0) goto L3f
            if (r3 == r9) goto L3b
            if (r3 == r8) goto L3f
            if (r3 != r7) goto L35
            kotlin.ResultKt.throwOnFailure(r1)
            return r5
        L35:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r0)
            return r4
        L3b:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L55
        L3f:
            kotlin.ResultKt.throwOnFailure(r1)
        L42:
            kotlinx.io.Source r1 = r0.input
            boolean r1 = r1.exhausted()
            if (r1 == 0) goto L5d
            io.ktor.utils.io.ByteReadChannel r1 = r0.channel
            r2.label = r9
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r1, r6, r2, r9, r4)
            if (r1 != r10) goto L55
            goto Lc3
        L55:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto Lc4
        L5d:
            kotlinx.io.Source r1 = r0.input
            kotlinx.io.bytestring.ByteString r3 = r0.matchString
            byte r3 = r3.get(r6)
            r11 = 0
            r13 = 6
            long r11 = kotlinx.io.Utf8Kt.indexOf$default(r1, r3, r11, r13)
            r13 = -1
            int r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r1 != 0) goto L9e
            kotlinx.io.Source r1 = r0.input
            r1.getClass()
            kotlinx.io.Buffer r1 = (kotlinx.io.Buffer) r1
            long r13 = r1.sizeMut
            r0.checkBounds(r13)
            long r13 = r0.bytesRead
            kotlinx.io.Source r1 = r0.input
            kotlinx.io.Buffer r1 = (kotlinx.io.Buffer) r1
            io.ktor.utils.io.ByteWriteChannel r3 = r0.writeChannel
            kotlinx.io.Sink r3 = r3.getWriteBuffer()
            long r15 = r1.transferTo(r3)
            long r13 = r13 + r15
            r0.bytesRead = r13
            io.ktor.utils.io.ByteWriteChannel r1 = r0.writeChannel
            r2.J$0 = r11
            r2.label = r8
            java.lang.Object r1 = io.ktor.utils.io.ByteWriteChannelKt.flushIfNeeded(r1, r2)
            if (r1 != r10) goto L42
            goto Lc3
        L9e:
            r0.checkBounds(r11)
            long r3 = r0.bytesRead
            kotlinx.io.Source r1 = r0.input
            io.ktor.utils.io.ByteWriteChannel r6 = r0.writeChannel
            kotlinx.io.Sink r6 = r6.getWriteBuffer()
            r6.getClass()
            kotlinx.io.Buffer r6 = (kotlinx.io.Buffer) r6
            long r8 = r1.readAtMostTo(r6, r11)
            long r8 = r8 + r3
            r0.bytesRead = r8
            io.ktor.utils.io.ByteWriteChannel r0 = r0.writeChannel
            r2.J$0 = r11
            r2.label = r7
            java.lang.Object r0 = io.ktor.utils.io.ByteWriteChannelKt.flushIfNeeded(r0, r2)
            if (r0 != r10) goto Lc4
        Lc3:
            return r10
        Lc4:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelScanner.advanceToNextPotentialMatch(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int[] buildPartialMatchTable() {
        byte[] bArr = this.matchString.data;
        int[] iArr = new int[bArr.length];
        int length = bArr.length;
        int i = 0;
        for (int i2 = 1; i2 < length; i2++) {
            while (i > 0 && this.matchString.get(i2) != this.matchString.get(i)) {
                i = iArr[i - 1];
            }
            if (this.matchString.get(i2) == this.matchString.get(i)) {
                i++;
            }
            iArr[i2] = i;
        }
        return iArr;
    }

    private final void checkBounds(long extra) throws IOException {
        if (this.bytesRead + extra <= this.limit) {
            return;
        }
        StringBuilder sb = new StringBuilder("Limit of ");
        sb.append(this.limit);
        sb.append(" bytes exceeded while searching for \"");
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(Format$$ExternalSyntheticOutline0.m(sb, toSingleLineString(this.matchString), '\"'));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0041  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:51:0x0084 A[ADDED_TO_REGION, EDGE_INSN: B:51:0x0084->B:37:0x0084 BREAK  A[LOOP:0: B:32:0x006e->B:36:0x007a], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003f -> B:27:0x005a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004a -> B:22:0x004e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object checkFullMatch(kotlin.coroutines.Continuation r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelScanner.checkFullMatch(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object findNext$ktor_io$default(ByteChannelScanner byteChannelScanner, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return byteChannelScanner.findNext$ktor_io(z, continuation);
    }

    private final String toSingleLineString(ByteString byteString) {
        byteString.getClass();
        return StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.decodeToString(byteString.data), "\n", "\\n", false);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0068 A[PHI: r11 r12
      0x0068: PHI (r11v3 boolean) = (r11v6 boolean), (r11v8 boolean) binds: [B:24:0x0065, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE]
      0x0068: PHI (r12v4 java.lang.Object) = (r12v15 java.lang.Object), (r12v1 java.lang.Object) binds: [B:24:0x0065, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x0099  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b0 A[PHI: r11
      0x00b0: PHI (r11v2 boolean) = (r11v3 boolean), (r11v6 boolean) binds: [B:27:0x006e, B:22:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x00bb A[PHI: r11
      0x00bb: PHI (r11v1 boolean) = (r11v2 boolean), (r11v9 boolean) binds: [B:38:0x00b8, B:18:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        if (r12.flush(r0) == r7) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c3, code lost:
    
        if (r12 == r7) goto L42;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00c3 -> B:43:0x00c6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object findNext$ktor_io(boolean z, Continuation continuation) throws IOException {
        ByteChannelScanner$findNext$1 byteChannelScanner$findNext$1;
        if (continuation instanceof ByteChannelScanner$findNext$1) {
            byteChannelScanner$findNext$1 = (ByteChannelScanner$findNext$1) continuation;
            int i = byteChannelScanner$findNext$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                byteChannelScanner$findNext$1.label = i - Integer.MIN_VALUE;
            } else {
                byteChannelScanner$findNext$1 = new ByteChannelScanner$findNext$1(this, continuation);
            }
        } else {
            byteChannelScanner$findNext$1 = new ByteChannelScanner$findNext$1(this, continuation);
        }
        Object objCheckFullMatch = byteChannelScanner$findNext$1.result;
        int i2 = byteChannelScanner$findNext$1.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCheckFullMatch);
            this.bytesRead = 0L;
            if (this.input.exhausted()) {
                ByteReadChannel byteReadChannel = this.channel;
                byteChannelScanner$findNext$1.Z$0 = z;
                byteChannelScanner$findNext$1.label = 1;
                objCheckFullMatch = ByteReadChannel.awaitContent$default(byteReadChannel, 0, byteChannelScanner$findNext$1, 1, null);
                if (objCheckFullMatch != obj) {
                    if (((Boolean) objCheckFullMatch).booleanValue()) {
                        byteChannelScanner$findNext$1.Z$0 = z;
                        byteChannelScanner$findNext$1.label = 2;
                        if (advanceToNextPotentialMatch(byteChannelScanner$findNext$1) != obj) {
                            byteChannelScanner$findNext$1.Z$0 = z;
                            byteChannelScanner$findNext$1.label = 3;
                            objCheckFullMatch = checkFullMatch(byteChannelScanner$findNext$1);
                        }
                    } else {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("Expected \""), toSingleLineString(this.matchString), "\" but encountered end of input"));
                            return null;
                        }
                        this.bytesRead = this.partialMatchBuffer.transferTo(this.writeChannel.getWriteBuffer()) + this.bytesRead;
                        ByteWriteChannel byteWriteChannel = this.writeChannel;
                        byteChannelScanner$findNext$1.Z$0 = z;
                        byteChannelScanner$findNext$1.label = 4;
                    }
                }
            } else {
                byteChannelScanner$findNext$1.Z$0 = z;
                byteChannelScanner$findNext$1.label = 2;
                if (advanceToNextPotentialMatch(byteChannelScanner$findNext$1) != obj) {
                    byteChannelScanner$findNext$1.Z$0 = z;
                    byteChannelScanner$findNext$1.label = 3;
                    objCheckFullMatch = checkFullMatch(byteChannelScanner$findNext$1);
                }
            }
            return obj;
        }
        if (i2 == 1) {
            z = byteChannelScanner$findNext$1.Z$0;
            ResultKt.throwOnFailure(objCheckFullMatch);
            if (((Boolean) objCheckFullMatch).booleanValue()) {
                byteChannelScanner$findNext$1.Z$0 = z;
                byteChannelScanner$findNext$1.label = 2;
                if (advanceToNextPotentialMatch(byteChannelScanner$findNext$1) != obj) {
                    byteChannelScanner$findNext$1.Z$0 = z;
                    byteChannelScanner$findNext$1.label = 3;
                    objCheckFullMatch = checkFullMatch(byteChannelScanner$findNext$1);
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("Expected \""), toSingleLineString(this.matchString), "\" but encountered end of input"));
                    return null;
                }
                this.bytesRead = this.partialMatchBuffer.transferTo(this.writeChannel.getWriteBuffer()) + this.bytesRead;
                ByteWriteChannel byteWriteChannel2 = this.writeChannel;
                byteChannelScanner$findNext$1.Z$0 = z;
                byteChannelScanner$findNext$1.label = 4;
            }
            return obj;
        }
        if (i2 == 2) {
            z = byteChannelScanner$findNext$1.Z$0;
            ResultKt.throwOnFailure(objCheckFullMatch);
            byteChannelScanner$findNext$1.Z$0 = z;
            byteChannelScanner$findNext$1.label = 3;
            objCheckFullMatch = checkFullMatch(byteChannelScanner$findNext$1);
        } else {
            if (i2 == 3) {
                z = byteChannelScanner$findNext$1.Z$0;
                ResultKt.throwOnFailure(objCheckFullMatch);
                if (((Boolean) objCheckFullMatch).booleanValue()) {
                    return new Long(this.bytesRead);
                }
                if (this.input.exhausted()) {
                    ByteReadChannel byteReadChannel2 = this.channel;
                    byteChannelScanner$findNext$1.Z$0 = z;
                    byteChannelScanner$findNext$1.label = 1;
                    objCheckFullMatch = ByteReadChannel.awaitContent$default(byteReadChannel2, 0, byteChannelScanner$findNext$1, 1, null);
                    if (objCheckFullMatch != obj) {
                        if (((Boolean) objCheckFullMatch).booleanValue()) {
                            byteChannelScanner$findNext$1.Z$0 = z;
                            byteChannelScanner$findNext$1.label = 2;
                            if (advanceToNextPotentialMatch(byteChannelScanner$findNext$1) != obj) {
                                byteChannelScanner$findNext$1.Z$0 = z;
                                byteChannelScanner$findNext$1.label = 3;
                                objCheckFullMatch = checkFullMatch(byteChannelScanner$findNext$1);
                            }
                        } else {
                            if (!z) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("Expected \""), toSingleLineString(this.matchString), "\" but encountered end of input"));
                                return null;
                            }
                            this.bytesRead = this.partialMatchBuffer.transferTo(this.writeChannel.getWriteBuffer()) + this.bytesRead;
                            ByteWriteChannel byteWriteChannel3 = this.writeChannel;
                            byteChannelScanner$findNext$1.Z$0 = z;
                            byteChannelScanner$findNext$1.label = 4;
                        }
                    }
                } else {
                    byteChannelScanner$findNext$1.Z$0 = z;
                    byteChannelScanner$findNext$1.label = 2;
                    if (advanceToNextPotentialMatch(byteChannelScanner$findNext$1) != obj) {
                        byteChannelScanner$findNext$1.Z$0 = z;
                        byteChannelScanner$findNext$1.label = 3;
                        objCheckFullMatch = checkFullMatch(byteChannelScanner$findNext$1);
                    }
                }
                return obj;
            }
            if (i2 != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objCheckFullMatch);
        }
        return new Long(this.bytesRead);
    }

    public /* synthetic */ ByteChannelScanner(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, byteString, byteWriteChannel, (i & 8) != 0 ? Long.MAX_VALUE : j);
    }
}
