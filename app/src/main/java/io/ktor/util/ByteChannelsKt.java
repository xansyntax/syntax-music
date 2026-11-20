package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.io.Buffer;
import kotlinx.io.RealSource;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlin/Pair;", "split", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/Pair;", "Lio/ktor/utils/io/ByteWriteChannel;", "first", "second", "", "copyToBoth", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteWriteChannel;)V", "", "CHUNK_BUFFER_SIZE", "J", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteChannelsKt {
    private static final long CHUNK_BUFFER_SIZE = 4096;

    /* JADX INFO: renamed from: io.ktor.util.ByteChannelsKt$copyToBoth$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", l = {64, 66, 67, 81, 82, 81, 82, 81, 82}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteWriteChannel $first;
        final /* synthetic */ ByteWriteChannel $second;
        final /* synthetic */ ByteReadChannel $this_copyToBoth;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Continuation continuation) {
            super(2, continuation);
            this.$this_copyToBoth = byteReadChannel;
            this.$first = byteWriteChannel;
            this.$second = byteWriteChannel2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$this_copyToBoth, this.$first, this.$second, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0086 A[Catch: all -> 0x0078, TryCatch #3 {all -> 0x0078, blocks: (B:44:0x00fb, B:26:0x007e, B:28:0x0086, B:30:0x008e, B:32:0x0096, B:35:0x00af, B:49:0x0103, B:50:0x0106, B:51:0x0107, B:59:0x0131, B:21:0x0074, B:36:0x00b8, B:43:0x00f2, B:47:0x0101), top: B:84:0x0005, inners: #0, #2 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x00d5  */
        /* JADX WARN: Code duplicated, block: B:40:0x00d7 A[Catch: all -> 0x0049, PHI: r0 r3 r4 r5 r7 r10
          0x00d7: PHI (r0v14 io.ktor.utils.io.ByteReadChannel) = (r0v10 io.ktor.utils.io.ByteReadChannel), (r0v15 io.ktor.utils.io.ByteReadChannel) binds: [B:18:0x0065, B:38:0x00d3] A[DONT_GENERATE, DONT_INLINE]
          0x00d7: PHI (r3v6 io.ktor.utils.io.ByteWriteChannel) = (r3v3 io.ktor.utils.io.ByteWriteChannel), (r3v7 io.ktor.utils.io.ByteWriteChannel) binds: [B:18:0x0065, B:38:0x00d3] A[DONT_GENERATE, DONT_INLINE]
          0x00d7: PHI (r4v6 io.ktor.utils.io.ByteWriteChannel) = (r4v3 io.ktor.utils.io.ByteWriteChannel), (r4v7 io.ktor.utils.io.ByteWriteChannel) binds: [B:18:0x0065, B:38:0x00d3] A[DONT_GENERATE, DONT_INLINE]
          0x00d7: PHI (r5v7 java.lang.AutoCloseable) = (r5v3 java.lang.AutoCloseable), (r5v9 java.lang.AutoCloseable) binds: [B:18:0x0065, B:38:0x00d3] A[DONT_GENERATE, DONT_INLINE]
          0x00d7: PHI (r7v3 int) = (r7v2 int), (r7v4 int) binds: [B:18:0x0065, B:38:0x00d3] A[DONT_GENERATE, DONT_INLINE]
          0x00d7: PHI (r10v12 kotlinx.io.Buffer) = (r10v8 kotlinx.io.Buffer), (r10v17 kotlinx.io.Buffer) binds: [B:18:0x0065, B:38:0x00d3] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {all -> 0x0049, blocks: (B:12:0x0044, B:37:0x00bb, B:40:0x00d7), top: B:85:0x0044 }] */
        /* JADX WARN: Code duplicated, block: B:51:0x0107 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #3 {all -> 0x0078, blocks: (B:44:0x00fb, B:26:0x007e, B:28:0x0086, B:30:0x008e, B:32:0x0096, B:35:0x00af, B:49:0x0103, B:50:0x0106, B:51:0x0107, B:59:0x0131, B:21:0x0074, B:36:0x00b8, B:43:0x00f2, B:47:0x0101), top: B:84:0x0005, inners: #0, #2 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x010f  */
        /* JADX WARN: Code duplicated, block: B:56:0x0125  */
        /* JADX WARN: Code duplicated, block: B:59:0x0131 A[Catch: all -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0078, blocks: (B:44:0x00fb, B:26:0x007e, B:28:0x0086, B:30:0x008e, B:32:0x0096, B:35:0x00af, B:49:0x0103, B:50:0x0106, B:51:0x0107, B:59:0x0131, B:21:0x0074, B:36:0x00b8, B:43:0x00f2, B:47:0x0101), top: B:84:0x0005, inners: #0, #2 }] */
        /* JADX WARN: Code duplicated, block: B:76:0x0188  */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00ee, code lost:
        
            if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writePacket(r3, r10, r9) == r2) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x012e, code lost:
        
            if (r10.flushAndClose(r9) == r2) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x015b, code lost:
        
            if (r10.flushAndClose(r9) == r2) goto L75;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00ee -> B:44:0x00fb). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00f2 -> B:44:0x00fb). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ByteWriteChannel byteWriteChannel;
            ByteReadChannel byteReadChannel;
            ByteWriteChannel byteWriteChannel2;
            ByteWriteChannel byteWriteChannel3;
            AutoCloseable autoCloseable;
            Buffer buffer;
            int i;
            RealSource realSourcePeek;
            Throwable closedCause;
            ByteWriteChannel byteWriteChannel4;
            int i2 = this.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                switch (i2) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        if (!this.$this_copyToBoth.isClosedForRead() || (this.$first.isClosedForWrite() && this.$second.isClosedForWrite())) {
                            closedCause = this.$this_copyToBoth.getClosedCause();
                            if (closedCause != null) {
                                throw closedCause;
                            }
                            byteWriteChannel4 = this.$first;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 4;
                            if (byteWriteChannel4.flushAndClose(this) != coroutineSingletons) {
                                ByteWriteChannel byteWriteChannel5 = this.$second;
                                this.label = 5;
                            }
                            break;
                        } else {
                            ByteReadChannel byteReadChannel2 = this.$this_copyToBoth;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 1;
                            obj = ByteReadChannelOperationsKt.readBuffer(byteReadChannel2, ByteChannelsKt.CHUNK_BUFFER_SIZE, this);
                            if (obj != coroutineSingletons) {
                                autoCloseable = (AutoCloseable) obj;
                                byteWriteChannel3 = this.$first;
                                byteWriteChannel2 = this.$second;
                                byteReadChannel = this.$this_copyToBoth;
                                buffer = (Buffer) autoCloseable;
                                realSourcePeek = buffer.peek();
                                this.L$0 = autoCloseable;
                                this.L$1 = byteWriteChannel3;
                                this.L$2 = byteWriteChannel2;
                                this.L$3 = byteReadChannel;
                                this.L$4 = buffer;
                                i = 0;
                                this.I$0 = 0;
                                this.label = 2;
                                if (ByteWriteChannelOperationsKt.writePacket(byteWriteChannel3, realSourcePeek, this) == coroutineSingletons) {
                                    RealSource realSourcePeek2 = buffer.peek();
                                    this.L$0 = autoCloseable;
                                    this.L$1 = byteWriteChannel3;
                                    this.L$2 = byteWriteChannel2;
                                    this.L$3 = byteReadChannel;
                                    this.L$4 = null;
                                    this.I$0 = i;
                                    this.label = 3;
                                    break;
                                }
                            }
                        }
                        return coroutineSingletons;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        autoCloseable = (AutoCloseable) obj;
                        byteWriteChannel3 = this.$first;
                        byteWriteChannel2 = this.$second;
                        byteReadChannel = this.$this_copyToBoth;
                        buffer = (Buffer) autoCloseable;
                        realSourcePeek = buffer.peek();
                        this.L$0 = autoCloseable;
                        this.L$1 = byteWriteChannel3;
                        this.L$2 = byteWriteChannel2;
                        this.L$3 = byteReadChannel;
                        this.L$4 = buffer;
                        i = 0;
                        this.I$0 = 0;
                        this.label = 2;
                        if (ByteWriteChannelOperationsKt.writePacket(byteWriteChannel3, realSourcePeek, this) == coroutineSingletons) {
                            RealSource realSourcePeek3 = buffer.peek();
                            this.L$0 = autoCloseable;
                            this.L$1 = byteWriteChannel3;
                            this.L$2 = byteWriteChannel2;
                            this.L$3 = byteReadChannel;
                            this.L$4 = null;
                            this.I$0 = i;
                            this.label = 3;
                            break;
                        }
                        return coroutineSingletons;
                    case 2:
                        int i3 = this.I$0;
                        Buffer buffer2 = (Buffer) this.L$4;
                        ByteReadChannel byteReadChannel3 = (ByteReadChannel) this.L$3;
                        ByteWriteChannel byteWriteChannel6 = (ByteWriteChannel) this.L$2;
                        ByteWriteChannel byteWriteChannel7 = (ByteWriteChannel) this.L$1;
                        AutoCloseable autoCloseable2 = (AutoCloseable) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            buffer = buffer2;
                            byteWriteChannel2 = byteWriteChannel6;
                            autoCloseable = autoCloseable2;
                            i = i3;
                            byteReadChannel = byteReadChannel3;
                            byteWriteChannel3 = byteWriteChannel7;
                        } catch (Throwable th) {
                            th = th;
                            byteReadChannel = byteReadChannel3;
                            byteWriteChannel2 = byteWriteChannel6;
                            byteWriteChannel3 = byteWriteChannel7;
                            autoCloseable = autoCloseable2;
                            try {
                                byteReadChannel.cancel(th);
                                ByteWriteChannelOperationsKt.close(byteWriteChannel3, th);
                                ByteWriteChannelOperationsKt.close(byteWriteChannel2, th);
                                StringsKt__IndentKt.closeFinally(autoCloseable, null);
                                if (!this.$this_copyToBoth.isClosedForRead()) {
                                    closedCause = this.$this_copyToBoth.getClosedCause();
                                    if (closedCause != null) {
                                        throw closedCause;
                                    }
                                    byteWriteChannel4 = this.$first;
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.label = 4;
                                    if (byteWriteChannel4.flushAndClose(this) != coroutineSingletons) {
                                        ByteWriteChannel byteWriteChannel8 = this.$second;
                                        this.label = 5;
                                    }
                                    break;
                                } else {
                                    closedCause = this.$this_copyToBoth.getClosedCause();
                                    if (closedCause != null) {
                                        throw closedCause;
                                    }
                                    byteWriteChannel4 = this.$first;
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.label = 4;
                                    if (byteWriteChannel4.flushAndClose(this) != coroutineSingletons) {
                                        ByteWriteChannel byteWriteChannel9 = this.$second;
                                        this.label = 5;
                                    }
                                    break;
                                }
                                return coroutineSingletons;
                            } catch (Throwable th2) {
                                try {
                                    throw th2;
                                } catch (Throwable th3) {
                                    StringsKt__IndentKt.closeFinally(autoCloseable, th2);
                                    throw th3;
                                }
                            }
                        }
                        RealSource realSourcePeek4 = buffer.peek();
                        this.L$0 = autoCloseable;
                        this.L$1 = byteWriteChannel3;
                        this.L$2 = byteWriteChannel2;
                        this.L$3 = byteReadChannel;
                        this.L$4 = null;
                        this.I$0 = i;
                        this.label = 3;
                        break;
                    case 3:
                        byteReadChannel = (ByteReadChannel) this.L$3;
                        byteWriteChannel2 = (ByteWriteChannel) this.L$2;
                        byteWriteChannel3 = (ByteWriteChannel) this.L$1;
                        autoCloseable = (AutoCloseable) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th4) {
                            th = th4;
                            byteReadChannel.cancel(th);
                            ByteWriteChannelOperationsKt.close(byteWriteChannel3, th);
                            ByteWriteChannelOperationsKt.close(byteWriteChannel2, th);
                        }
                        StringsKt__IndentKt.closeFinally(autoCloseable, null);
                        if (!this.$this_copyToBoth.isClosedForRead()) {
                            closedCause = this.$this_copyToBoth.getClosedCause();
                            if (closedCause != null) {
                                throw closedCause;
                            }
                            byteWriteChannel4 = this.$first;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 4;
                            if (byteWriteChannel4.flushAndClose(this) != coroutineSingletons) {
                                ByteWriteChannel byteWriteChannel10 = this.$second;
                                this.label = 5;
                            }
                            break;
                        } else {
                            closedCause = this.$this_copyToBoth.getClosedCause();
                            if (closedCause != null) {
                                throw closedCause;
                            }
                            byteWriteChannel4 = this.$first;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 4;
                            if (byteWriteChannel4.flushAndClose(this) != coroutineSingletons) {
                                ByteWriteChannel byteWriteChannel11 = this.$second;
                                this.label = 5;
                            }
                            break;
                        }
                        return coroutineSingletons;
                    case 4:
                        ResultKt.throwOnFailure(obj);
                        ByteWriteChannel byteWriteChannel12 = this.$second;
                        this.label = 5;
                        break;
                    case 5:
                    case 7:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 6:
                        ResultKt.throwOnFailure(obj);
                        ByteWriteChannel byteWriteChannel13 = this.$second;
                        this.label = 7;
                        break;
                    case 8:
                        Throwable th5 = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        th = th5;
                        byteWriteChannel = this.$second;
                        this.L$0 = th;
                        this.label = 9;
                        if (byteWriteChannel.flushAndClose(this) != coroutineSingletons) {
                            throw th;
                        }
                        return coroutineSingletons;
                    case 9:
                        Throwable th6 = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th6;
                    default:
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } catch (Throwable th7) {
                try {
                    ByteWriteChannelOperationsKt.close(this.$first, th7);
                    ByteWriteChannelOperationsKt.close(this.$second, th7);
                    ByteWriteChannel byteWriteChannel14 = this.$first;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 6;
                    if (byteWriteChannel14.flushAndClose(this) != coroutineSingletons) {
                        ByteWriteChannel byteWriteChannel15 = this.$second;
                        this.label = 7;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    ByteWriteChannel byteWriteChannel16 = this.$first;
                    this.L$0 = th;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 8;
                    if (byteWriteChannel16.flushAndClose(this) != coroutineSingletons) {
                        byteWriteChannel = this.$second;
                        this.L$0 = th;
                        this.label = 9;
                        if (byteWriteChannel.flushAndClose(this) != coroutineSingletons) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.ByteChannelsKt$split$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", l = {27, 32}, m = "invokeSuspend", v = 1)
    public static final class C03211 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteChannel $first;
        final /* synthetic */ ByteChannel $second;
        final /* synthetic */ ByteReadChannel $this_split;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: io.ktor.util.ByteChannelsKt$split$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$1", f = "ByteChannels.kt", l = {30}, m = "invokeSuspend", v = 1)
        public static final class C00141 extends SuspendLambda implements Function2 {
            final /* synthetic */ byte[] $buffer;
            final /* synthetic */ ByteChannel $first;
            final /* synthetic */ int $read;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00141(ByteChannel byteChannel, byte[] bArr, int i, Continuation continuation) {
                super(2, continuation);
                this.$first = byteChannel;
                this.$buffer = bArr;
                this.$read = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00141(this.$first, this.$buffer, this.$read, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C00141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteChannel byteChannel = this.$first;
                    byte[] bArr = this.$buffer;
                    int i2 = this.$read;
                    this.label = 1;
                    Object objWriteFully = ByteWriteChannelOperationsKt.writeFully(byteChannel, bArr, 0, i2, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWriteFully == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: io.ktor.util.ByteChannelsKt$split$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$2", f = "ByteChannels.kt", l = {31}, m = "invokeSuspend", v = 1)
        public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
            final /* synthetic */ byte[] $buffer;
            final /* synthetic */ int $read;
            final /* synthetic */ ByteChannel $second;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ByteChannel byteChannel, byte[] bArr, int i, Continuation continuation) {
                super(2, continuation);
                this.$second = byteChannel;
                this.$buffer = bArr;
                this.$read = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.$second, this.$buffer, this.$read, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteChannel byteChannel = this.$second;
                    byte[] bArr = this.$buffer;
                    int i2 = this.$read;
                    this.label = 1;
                    Object objWriteFully = ByteWriteChannelOperationsKt.writeFully(byteChannel, bArr, 0, i2, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWriteFully == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03211(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ByteChannel byteChannel2, Continuation continuation) {
            super(2, continuation);
            this.$this_split = byteReadChannel;
            this.$first = byteChannel;
            this.$second = byteChannel2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C03211 c03211 = new C03211(this.$this_split, this.$first, this.$second, continuation);
            c03211.L$0 = obj;
            return c03211;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0049 A[Catch: all -> 0x009f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x009f, blocks: (B:17:0x003f, B:20:0x0049), top: B:60:0x003f }] */
        /* JADX WARN: Code duplicated, block: B:24:0x005a  */
        /* JADX WARN: Code duplicated, block: B:25:0x005b A[Catch: all -> 0x0096, PHI: r7 r10 r14
          0x005b: PHI (r7v4 byte[]) = (r7v0 byte[]), (r7v5 byte[]) binds: [B:15:0x002e, B:23:0x0058] A[DONT_GENERATE, DONT_INLINE]
          0x005b: PHI (r10v7 io.ktor.util.ByteChannelsKt$split$1) = (r10v1 io.ktor.util.ByteChannelsKt$split$1), (r10v12 io.ktor.util.ByteChannelsKt$split$1) binds: [B:15:0x002e, B:23:0x0058] A[DONT_GENERATE, DONT_INLINE]
          0x005b: PHI (r14v7 java.lang.Object) = (r14v0 java.lang.Object), (r14v16 java.lang.Object) binds: [B:15:0x002e, B:23:0x0058] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x0096, blocks: (B:22:0x0054, B:25:0x005b, B:27:0x0063, B:29:0x0081, B:41:0x00a2, B:45:0x00bb), top: B:55:0x0054 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x0063 A[Catch: all -> 0x0096, TRY_LEAVE, TryCatch #1 {all -> 0x0096, blocks: (B:22:0x0054, B:25:0x005b, B:27:0x0063, B:29:0x0081, B:41:0x00a2, B:45:0x00bb), top: B:55:0x0054 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0094 -> B:60:0x003f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 234
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.C03211.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void copyToBoth(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2) {
        byteReadChannel.getClass();
        byteWriteChannel.getClass();
        byteWriteChannel2.getClass();
        AwaitKt.launch$default(GlobalScope.INSTANCE, Dispatchers.Default, null, new AnonymousClass1(byteReadChannel, byteWriteChannel, byteWriteChannel2, null), 2).invokeOnCompletion(new ByteChannelsKt$$ExternalSyntheticLambda0(byteWriteChannel, byteWriteChannel2, (byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyToBoth$lambda$0(ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Throwable th) throws Throwable {
        Unit unit = Unit.INSTANCE;
        if (th == null) {
            return unit;
        }
        ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
        ByteWriteChannelOperationsKt.close(byteWriteChannel2, th);
        return unit;
    }

    public static final Pair split(ByteReadChannel byteReadChannel, CoroutineScope coroutineScope) {
        byteReadChannel.getClass();
        coroutineScope.getClass();
        ByteChannel byteChannel = new ByteChannel(true);
        ByteChannel byteChannel2 = new ByteChannel(true);
        AwaitKt.launch$default(coroutineScope, null, null, new C03211(byteReadChannel, byteChannel, byteChannel2, null), 3).invokeOnCompletion(new ByteChannelsKt$$ExternalSyntheticLambda0(byteChannel, byteChannel2, (byte) 4));
        return new Pair(byteChannel, byteChannel2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit split$lambda$0(ByteChannel byteChannel, ByteChannel byteChannel2, Throwable th) {
        Unit unit = Unit.INSTANCE;
        if (th == null) {
            return unit;
        }
        byteChannel.cancel(th);
        byteChannel2.cancel(th);
        return unit;
    }
}
