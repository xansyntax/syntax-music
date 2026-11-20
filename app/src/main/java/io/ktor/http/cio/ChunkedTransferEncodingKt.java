package io.ktor.http.cio;

import com.yalantis.ucrop.UCrop;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.core.StringsKt__StringsKt;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\b\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\t\u001a \u0010\u0005\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0005\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\f*\u00020\u0001H\u0082@¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0082@¢\u0006\u0004\b\u0010\u0010\u000f\u001a!\u0010\u0016\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017\u001a \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0016\u0010\u0018\u001a\u0013\u0010\u0019\u001a\u00020\f*\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a,\u0010 \u001a\u00020\u001d*\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0082@¢\u0006\u0004\b \u0010!\"\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#\"\u0014\u0010%\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&\"\u0014\u0010'\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&\"\u0014\u0010(\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010&\"\u0014\u0010)\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010&\"\u0014\u0010+\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,\"\u0014\u0010-\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.*\n\u00100\"\u00020\u00032\u00020\u0003*\n\u00101\"\u00020\u00142\u00020\u0014¨\u00062"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/WriterJob;", "Lio/ktor/http/cio/DecoderJob;", "decodeChunked", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/utils/io/WriterJob;", "", "contentLength", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;J)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteWriteChannel;", "out", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skipCrLf", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseChunkSize", "output", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/http/cio/EncoderJob;", "encodeChunked", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ReaderJob;", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rethrowCloseCause", "(Lio/ktor/utils/io/ByteReadChannel;)V", "", "memory", "", "startIndex", "endIndex", "writeChunk", "(Lio/ktor/utils/io/ByteWriteChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MAX_CHUNK_SIZE_LENGTH", "I", "", "CR", "B", "LF", "SEMICOLON", "QUOTE", "", "CrLfShort", "S", "CrLf", "[B", "LastChunkBytes", "DecoderJob", "EncoderJob", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChunkedTransferEncodingKt {
    private static final byte CR = 13;
    private static final short CrLfShort = 3338;
    private static final byte LF = 10;
    private static final int MAX_CHUNK_SIZE_LENGTH = 128;
    private static final byte QUOTE = 34;
    private static final byte SEMICOLON = 59;
    private static final byte[] CrLf = StringsKt__StringsKt.toByteArray$default(ServerSentEventKt.END_OF_LINE, null, 1, null);
    private static final byte[] LastChunkBytes = StringsKt__StringsKt.toByteArray$default("0\r\n\r\n", null, 1, null);

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$1", f = "ChunkedTransferEncoding.kt", l = {47}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteReadChannel $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, Continuation continuation) {
            super(2, continuation);
            this.$input = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            WriterScope writerScope = (WriterScope) this.L$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteReadChannel byteReadChannel = this.$input;
                ByteWriteChannel channel = writerScope.getChannel();
                this.L$0 = null;
                this.label = 1;
                Object objDecodeChunked = ChunkedTransferEncodingKt.decodeChunked(byteReadChannel, channel, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDecodeChunked == coroutineSingletons) {
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

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", l = {62, 63, 65, UCrop.REQUEST_CROP, 70, 71, 78, 78}, m = "decodeChunked", v = 1)
    public static final class AnonymousClass2 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.decodeChunked((ByteReadChannel) null, (ByteWriteChannel) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$1", f = "ChunkedTransferEncoding.kt", l = {189}, m = "invokeSuspend", v = 1)
    public static final class C03041 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteWriteChannel $output;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03041(ByteWriteChannel byteWriteChannel, Continuation continuation) {
            super(2, continuation);
            this.$output = byteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C03041 c03041 = new C03041(this.$output, continuation);
            c03041.L$0 = obj;
            return c03041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ReaderScope readerScope, Continuation continuation) {
            return ((C03041) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ReaderScope readerScope = (ReaderScope) this.L$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteWriteChannel byteWriteChannel = this.$output;
                ByteReadChannel channel = readerScope.getChannel();
                this.L$0 = null;
                this.label = 1;
                Object objEncodeChunked = ChunkedTransferEncodingKt.encodeChunked(byteWriteChannel, channel, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objEncodeChunked == coroutineSingletons) {
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

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", l = {242, 202, 207, 213, 213}, m = "encodeChunked", v = 1)
    public static final class C03052 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C03052(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.encodeChunked(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$parseChunkSize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", l = {135}, m = "parseChunkSize", v = 1)
    public static final class C03061 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03061(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.parseChunkSize(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$skipCrLf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", l = {83, 84}, m = "skipCrLf", v = 1)
    public static final class C03071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03071(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.skipCrLf(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$writeChunk$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", l = {231, 232, 234, 235, 236}, m = "writeChunk", v = 1)
    public static final class C03081 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03081(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.writeChunk(null, null, 0, 0, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ca A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:15:0x0054, B:39:0x00c2, B:41:0x00ca, B:44:0x00db, B:46:0x00e5, B:49:0x00f8, B:53:0x010c, B:56:0x011e, B:20:0x0068, B:23:0x0079, B:26:0x0089, B:29:0x0099, B:32:0x00a8), top: B:76:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00db A[Catch: all -> 0x0059, PHI: r1 r6 r9 r11
      0x00db: PHI (r1v15 io.ktor.utils.io.ByteWriteChannel) = (r1v5 io.ktor.utils.io.ByteWriteChannel), (r1v16 io.ktor.utils.io.ByteWriteChannel) binds: [B:29:0x0099, B:42:0x00d7] A[DONT_GENERATE, DONT_INLINE]
      0x00db: PHI (r6v10 long) = (r6v3 long), (r6v11 long) binds: [B:29:0x0099, B:42:0x00d7] A[DONT_GENERATE, DONT_INLINE]
      0x00db: PHI (r9v19 io.ktor.utils.io.ByteReadChannel) = (r9v9 io.ktor.utils.io.ByteReadChannel), (r9v22 io.ktor.utils.io.ByteReadChannel) binds: [B:29:0x0099, B:42:0x00d7] A[DONT_GENERATE, DONT_INLINE]
      0x00db: PHI (r11v6 java.lang.Object) = (r11v1 java.lang.Object), (r11v10 java.lang.Object) binds: [B:29:0x0099, B:42:0x00d7] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x0059, blocks: (B:15:0x0054, B:39:0x00c2, B:41:0x00ca, B:44:0x00db, B:46:0x00e5, B:49:0x00f8, B:53:0x010c, B:56:0x011e, B:20:0x0068, B:23:0x0079, B:26:0x0089, B:29:0x0099, B:32:0x00a8), top: B:76:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e5 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:15:0x0054, B:39:0x00c2, B:41:0x00ca, B:44:0x00db, B:46:0x00e5, B:49:0x00f8, B:53:0x010c, B:56:0x011e, B:20:0x0068, B:23:0x0079, B:26:0x0089, B:29:0x0099, B:32:0x00a8), top: B:76:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f8 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:15:0x0054, B:39:0x00c2, B:41:0x00ca, B:44:0x00db, B:46:0x00e5, B:49:0x00f8, B:53:0x010c, B:56:0x011e, B:20:0x0068, B:23:0x0079, B:26:0x0089, B:29:0x0099, B:32:0x00a8), top: B:76:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0109  */
    /* JADX WARN: Code duplicated, block: B:52:0x010a  */
    /* JADX WARN: Code duplicated, block: B:55:0x011d  */
    /* JADX WARN: Code duplicated, block: B:56:0x011e A[Catch: all -> 0x0059, PHI: r1 r6 r8 r9
      0x011e: PHI (r1v13 io.ktor.utils.io.ByteWriteChannel) = (r1v11 io.ktor.utils.io.ByteWriteChannel), (r1v14 io.ktor.utils.io.ByteWriteChannel) binds: [B:20:0x0068, B:54:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x011e: PHI (r6v8 long) = (r6v6 long), (r6v9 long) binds: [B:20:0x0068, B:54:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x011e: PHI (r8v4 io.ktor.utils.io.ByteReadChannel) = (r8v3 io.ktor.utils.io.ByteReadChannel), (r8v5 io.ktor.utils.io.ByteReadChannel) binds: [B:20:0x0068, B:54:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x011e: PHI (r9v17 long) = (r9v14 long), (r9v18 long) binds: [B:20:0x0068, B:54:0x011b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {all -> 0x0059, blocks: (B:15:0x0054, B:39:0x00c2, B:41:0x00ca, B:44:0x00db, B:46:0x00e5, B:49:0x00f8, B:53:0x010c, B:56:0x011e, B:20:0x0068, B:23:0x0079, B:26:0x0089, B:29:0x0099, B:32:0x00a8), top: B:76:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0135 A[PHI: r1 r6
      0x0135: PHI (r1v12 io.ktor.utils.io.ByteWriteChannel) = 
      (r1v7 io.ktor.utils.io.ByteWriteChannel)
      (r1v15 io.ktor.utils.io.ByteWriteChannel)
      (r1v16 io.ktor.utils.io.ByteWriteChannel)
     binds: [B:26:0x0089, B:47:0x00f4, B:40:0x00c8] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r6v7 long) = (r6v4 long), (r6v10 long), (r6v11 long) binds: [B:26:0x0089, B:47:0x00f4, B:40:0x00c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012d, code lost:
    
        if (r1.flush(r0) == r5) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0142, code lost:
    
        if (r1.flushAndClose(r0) == r5) goto L72;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x012d -> B:59:0x0130). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object decodeChunked(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Continuation continuation) throws Throwable {
        AnonymousClass2 anonymousClass2;
        long j;
        ByteWriteChannel byteWriteChannel2;
        long j2;
        ByteReadChannel byteReadChannel2;
        long jLongValue;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object chunkSize = anonymousClass2.result;
        ?? r1 = anonymousClass2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            switch (r1) {
                case 0:
                    ResultKt.throwOnFailure(chunkSize);
                    j = 0;
                    try {
                        anonymousClass2.L$0 = byteReadChannel;
                        anonymousClass2.L$1 = byteWriteChannel;
                        anonymousClass2.J$0 = j;
                        anonymousClass2.label = 1;
                        chunkSize = ByteReadChannelOperationsKt.exhausted(byteReadChannel, anonymousClass2);
                        if (chunkSize != coroutineSingletons) {
                            byteWriteChannel2 = byteWriteChannel;
                            if (!((Boolean) chunkSize).booleanValue()) {
                                anonymousClass2.L$0 = byteReadChannel;
                                anonymousClass2.L$1 = byteWriteChannel2;
                                anonymousClass2.J$0 = j;
                                anonymousClass2.label = 2;
                                chunkSize = parseChunkSize(byteReadChannel, anonymousClass2);
                                if (chunkSize != coroutineSingletons) {
                                    jLongValue = ((Number) chunkSize).longValue();
                                    if (jLongValue == 0) {
                                        anonymousClass2.L$0 = byteReadChannel;
                                        anonymousClass2.L$1 = byteWriteChannel2;
                                        anonymousClass2.J$0 = j;
                                        anonymousClass2.J$1 = jLongValue;
                                        anonymousClass2.label = 4;
                                        if (ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannel2, jLongValue, anonymousClass2) == coroutineSingletons) {
                                            byteReadChannel2 = byteReadChannel;
                                            j2 = jLongValue;
                                            anonymousClass2.L$0 = byteReadChannel2;
                                            anonymousClass2.L$1 = byteWriteChannel2;
                                            anonymousClass2.J$0 = j;
                                            anonymousClass2.J$1 = j2;
                                            anonymousClass2.label = 5;
                                            if (skipCrLf(byteReadChannel2, anonymousClass2) != coroutineSingletons) {
                                                anonymousClass2.L$0 = byteReadChannel2;
                                                anonymousClass2.L$1 = byteWriteChannel2;
                                                anonymousClass2.J$0 = j;
                                                anonymousClass2.J$1 = j2;
                                                anonymousClass2.label = 6;
                                                break;
                                            }
                                        }
                                    } else {
                                        anonymousClass2.L$0 = null;
                                        anonymousClass2.L$1 = byteWriteChannel2;
                                        anonymousClass2.J$0 = j;
                                        anonymousClass2.J$1 = jLongValue;
                                        anonymousClass2.label = 3;
                                        if (skipCrLf(byteReadChannel, anonymousClass2) == coroutineSingletons) {
                                            anonymousClass2.L$0 = null;
                                            anonymousClass2.L$1 = null;
                                            anonymousClass2.J$0 = j;
                                            anonymousClass2.label = 7;
                                            break;
                                        }
                                    }
                                }
                            } else {
                                anonymousClass2.L$0 = null;
                                anonymousClass2.L$1 = null;
                                anonymousClass2.J$0 = j;
                                anonymousClass2.label = 7;
                                break;
                            }
                        }
                        return coroutineSingletons;
                    } catch (Throwable th) {
                        th = th;
                        r1 = byteWriteChannel;
                        try {
                            ByteWriteChannelOperationsKt.close(r1, th);
                            throw th;
                        } catch (Throwable th2) {
                            anonymousClass2.L$0 = null;
                            anonymousClass2.L$1 = null;
                            anonymousClass2.L$2 = th2;
                            anonymousClass2.J$0 = j;
                            anonymousClass2.label = 8;
                            if (r1.flushAndClose(anonymousClass2) != coroutineSingletons) {
                                throw th2;
                            }
                        }
                    }
                    break;
                case 1:
                    j = anonymousClass2.J$0;
                    byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$1;
                    byteReadChannel = (ByteReadChannel) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(chunkSize);
                    if (!((Boolean) chunkSize).booleanValue()) {
                        anonymousClass2.L$0 = null;
                        anonymousClass2.L$1 = null;
                        anonymousClass2.J$0 = j;
                        anonymousClass2.label = 7;
                        break;
                    } else {
                        anonymousClass2.L$0 = byteReadChannel;
                        anonymousClass2.L$1 = byteWriteChannel2;
                        anonymousClass2.J$0 = j;
                        anonymousClass2.label = 2;
                        chunkSize = parseChunkSize(byteReadChannel, anonymousClass2);
                        if (chunkSize != coroutineSingletons) {
                            jLongValue = ((Number) chunkSize).longValue();
                            if (jLongValue == 0) {
                                anonymousClass2.L$0 = byteReadChannel;
                                anonymousClass2.L$1 = byteWriteChannel2;
                                anonymousClass2.J$0 = j;
                                anonymousClass2.J$1 = jLongValue;
                                anonymousClass2.label = 4;
                                if (ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannel2, jLongValue, anonymousClass2) == coroutineSingletons) {
                                    byteReadChannel2 = byteReadChannel;
                                    j2 = jLongValue;
                                    anonymousClass2.L$0 = byteReadChannel2;
                                    anonymousClass2.L$1 = byteWriteChannel2;
                                    anonymousClass2.J$0 = j;
                                    anonymousClass2.J$1 = j2;
                                    anonymousClass2.label = 5;
                                    if (skipCrLf(byteReadChannel2, anonymousClass2) != coroutineSingletons) {
                                        anonymousClass2.L$0 = byteReadChannel2;
                                        anonymousClass2.L$1 = byteWriteChannel2;
                                        anonymousClass2.J$0 = j;
                                        anonymousClass2.J$1 = j2;
                                        anonymousClass2.label = 6;
                                        break;
                                    }
                                }
                            } else {
                                anonymousClass2.L$0 = null;
                                anonymousClass2.L$1 = byteWriteChannel2;
                                anonymousClass2.J$0 = j;
                                anonymousClass2.J$1 = jLongValue;
                                anonymousClass2.label = 3;
                                if (skipCrLf(byteReadChannel, anonymousClass2) == coroutineSingletons) {
                                    anonymousClass2.L$0 = null;
                                    anonymousClass2.L$1 = null;
                                    anonymousClass2.J$0 = j;
                                    anonymousClass2.label = 7;
                                    break;
                                }
                            }
                        }
                    }
                    return coroutineSingletons;
                case 2:
                    j = anonymousClass2.J$0;
                    byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$1;
                    byteReadChannel = (ByteReadChannel) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(chunkSize);
                    jLongValue = ((Number) chunkSize).longValue();
                    if (jLongValue == 0) {
                        anonymousClass2.L$0 = byteReadChannel;
                        anonymousClass2.L$1 = byteWriteChannel2;
                        anonymousClass2.J$0 = j;
                        anonymousClass2.J$1 = jLongValue;
                        anonymousClass2.label = 4;
                        if (ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannel2, jLongValue, anonymousClass2) == coroutineSingletons) {
                            byteReadChannel2 = byteReadChannel;
                            j2 = jLongValue;
                            anonymousClass2.L$0 = byteReadChannel2;
                            anonymousClass2.L$1 = byteWriteChannel2;
                            anonymousClass2.J$0 = j;
                            anonymousClass2.J$1 = j2;
                            anonymousClass2.label = 5;
                            if (skipCrLf(byteReadChannel2, anonymousClass2) != coroutineSingletons) {
                                anonymousClass2.L$0 = byteReadChannel2;
                                anonymousClass2.L$1 = byteWriteChannel2;
                                anonymousClass2.J$0 = j;
                                anonymousClass2.J$1 = j2;
                                anonymousClass2.label = 6;
                                break;
                            }
                        }
                    } else {
                        anonymousClass2.L$0 = null;
                        anonymousClass2.L$1 = byteWriteChannel2;
                        anonymousClass2.J$0 = j;
                        anonymousClass2.J$1 = jLongValue;
                        anonymousClass2.label = 3;
                        if (skipCrLf(byteReadChannel, anonymousClass2) == coroutineSingletons) {
                            anonymousClass2.L$0 = null;
                            anonymousClass2.L$1 = null;
                            anonymousClass2.J$0 = j;
                            anonymousClass2.label = 7;
                            break;
                        }
                    }
                    return coroutineSingletons;
                case 3:
                    j = anonymousClass2.J$0;
                    byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$1;
                    ResultKt.throwOnFailure(chunkSize);
                    anonymousClass2.L$0 = null;
                    anonymousClass2.L$1 = null;
                    anonymousClass2.J$0 = j;
                    anonymousClass2.label = 7;
                    break;
                case 4:
                    j2 = anonymousClass2.J$1;
                    j = anonymousClass2.J$0;
                    byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$1;
                    byteReadChannel2 = (ByteReadChannel) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(chunkSize);
                    anonymousClass2.L$0 = byteReadChannel2;
                    anonymousClass2.L$1 = byteWriteChannel2;
                    anonymousClass2.J$0 = j;
                    anonymousClass2.J$1 = j2;
                    anonymousClass2.label = 5;
                    if (skipCrLf(byteReadChannel2, anonymousClass2) != coroutineSingletons) {
                        anonymousClass2.L$0 = byteReadChannel2;
                        anonymousClass2.L$1 = byteWriteChannel2;
                        anonymousClass2.J$0 = j;
                        anonymousClass2.J$1 = j2;
                        anonymousClass2.label = 6;
                        break;
                    }
                    return coroutineSingletons;
                case 5:
                    j2 = anonymousClass2.J$1;
                    j = anonymousClass2.J$0;
                    byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$1;
                    byteReadChannel2 = (ByteReadChannel) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(chunkSize);
                    anonymousClass2.L$0 = byteReadChannel2;
                    anonymousClass2.L$1 = byteWriteChannel2;
                    anonymousClass2.J$0 = j;
                    anonymousClass2.J$1 = j2;
                    anonymousClass2.label = 6;
                    break;
                case 6:
                    j2 = anonymousClass2.J$1;
                    j = anonymousClass2.J$0;
                    byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$1;
                    byteReadChannel2 = (ByteReadChannel) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(chunkSize);
                    j += j2;
                    byteWriteChannel = byteWriteChannel2;
                    byteReadChannel = byteReadChannel2;
                    anonymousClass2.L$0 = byteReadChannel;
                    anonymousClass2.L$1 = byteWriteChannel;
                    anonymousClass2.J$0 = j;
                    anonymousClass2.label = 1;
                    chunkSize = ByteReadChannelOperationsKt.exhausted(byteReadChannel, anonymousClass2);
                    if (chunkSize != coroutineSingletons) {
                        byteWriteChannel2 = byteWriteChannel;
                        if (!((Boolean) chunkSize).booleanValue()) {
                            anonymousClass2.L$0 = null;
                            anonymousClass2.L$1 = null;
                            anonymousClass2.J$0 = j;
                            anonymousClass2.label = 7;
                            break;
                        } else {
                            anonymousClass2.L$0 = byteReadChannel;
                            anonymousClass2.L$1 = byteWriteChannel2;
                            anonymousClass2.J$0 = j;
                            anonymousClass2.label = 2;
                            chunkSize = parseChunkSize(byteReadChannel, anonymousClass2);
                            if (chunkSize != coroutineSingletons) {
                                jLongValue = ((Number) chunkSize).longValue();
                                if (jLongValue == 0) {
                                    anonymousClass2.L$0 = byteReadChannel;
                                    anonymousClass2.L$1 = byteWriteChannel2;
                                    anonymousClass2.J$0 = j;
                                    anonymousClass2.J$1 = jLongValue;
                                    anonymousClass2.label = 4;
                                    if (ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannel2, jLongValue, anonymousClass2) == coroutineSingletons) {
                                        byteReadChannel2 = byteReadChannel;
                                        j2 = jLongValue;
                                        anonymousClass2.L$0 = byteReadChannel2;
                                        anonymousClass2.L$1 = byteWriteChannel2;
                                        anonymousClass2.J$0 = j;
                                        anonymousClass2.J$1 = j2;
                                        anonymousClass2.label = 5;
                                        if (skipCrLf(byteReadChannel2, anonymousClass2) != coroutineSingletons) {
                                            anonymousClass2.L$0 = byteReadChannel2;
                                            anonymousClass2.L$1 = byteWriteChannel2;
                                            anonymousClass2.J$0 = j;
                                            anonymousClass2.J$1 = j2;
                                            anonymousClass2.label = 6;
                                            break;
                                        }
                                    }
                                } else {
                                    anonymousClass2.L$0 = null;
                                    anonymousClass2.L$1 = byteWriteChannel2;
                                    anonymousClass2.J$0 = j;
                                    anonymousClass2.J$1 = jLongValue;
                                    anonymousClass2.label = 3;
                                    if (skipCrLf(byteReadChannel, anonymousClass2) == coroutineSingletons) {
                                        anonymousClass2.L$0 = null;
                                        anonymousClass2.L$1 = null;
                                        anonymousClass2.J$0 = j;
                                        anonymousClass2.label = 7;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    return coroutineSingletons;
                case 7:
                    ResultKt.throwOnFailure(chunkSize);
                    return Unit.INSTANCE;
                case 8:
                    Throwable th3 = (Throwable) anonymousClass2.L$2;
                    ResultKt.throwOnFailure(chunkSize);
                    throw th3;
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:? A[LOOP:0: B:113:0x00bc->B:123:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d2 A[Catch: all -> 0x00fe, TRY_LEAVE, TryCatch #6 {all -> 0x00fe, blocks: (B:37:0x00c2, B:39:0x00c8, B:41:0x00d2), top: B:115:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:49:0x0105  */
    /* JADX WARN: Code duplicated, block: B:52:0x010d A[Catch: all -> 0x01a8, TryCatch #3 {all -> 0x01a8, blocks: (B:50:0x0107, B:52:0x010d, B:54:0x0120, B:56:0x012d, B:58:0x013a, B:78:0x01aa, B:79:0x01b1), top: B:109:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0120 A[Catch: all -> 0x01a8, TryCatch #3 {all -> 0x01a8, blocks: (B:50:0x0107, B:52:0x010d, B:54:0x0120, B:56:0x012d, B:58:0x013a, B:78:0x01aa, B:79:0x01b1), top: B:109:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x012d A[Catch: all -> 0x01a8, TryCatch #3 {all -> 0x01a8, blocks: (B:50:0x0107, B:52:0x010d, B:54:0x0120, B:56:0x012d, B:58:0x013a, B:78:0x01aa, B:79:0x01b1), top: B:109:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x013a A[Catch: all -> 0x01a8, TRY_LEAVE, TryCatch #3 {all -> 0x01a8, blocks: (B:50:0x0107, B:52:0x010d, B:54:0x0120, B:56:0x012d, B:58:0x013a, B:78:0x01aa, B:79:0x01b1), top: B:109:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x016a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0181  */
    /* JADX WARN: Code duplicated, block: B:66:0x0183 A[Catch: all -> 0x018e, TryCatch #7 {all -> 0x018e, blocks: (B:63:0x0175, B:66:0x0183, B:68:0x0189, B:71:0x0192, B:72:0x0199, B:73:0x019a, B:74:0x01a1), top: B:117:0x0175 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0189 A[Catch: all -> 0x018e, TryCatch #7 {all -> 0x018e, blocks: (B:63:0x0175, B:66:0x0183, B:68:0x0189, B:71:0x0192, B:72:0x0199, B:73:0x019a, B:74:0x01a1), top: B:117:0x0175 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0192 A[Catch: all -> 0x018e, TryCatch #7 {all -> 0x018e, blocks: (B:63:0x0175, B:66:0x0183, B:68:0x0189, B:71:0x0192, B:72:0x0199, B:73:0x019a, B:74:0x01a1), top: B:117:0x0175 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x019a A[Catch: all -> 0x018e, TryCatch #7 {all -> 0x018e, blocks: (B:63:0x0175, B:66:0x0183, B:68:0x0189, B:71:0x0192, B:72:0x0199, B:73:0x019a, B:74:0x01a1), top: B:117:0x0175 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01aa A[Catch: all -> 0x01a8, TRY_ENTER, TryCatch #3 {all -> 0x01a8, blocks: (B:50:0x0107, B:52:0x010d, B:54:0x0120, B:56:0x012d, B:58:0x013a, B:78:0x01aa, B:79:0x01b1), top: B:109:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x012d -> B:117:0x0175). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x016a -> B:62:0x0171). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x01b2 -> B:113:0x00bc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:73:0x019a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object encodeChunked(io.ktor.utils.io.ByteWriteChannel r21, io.ktor.utils.io.ByteReadChannel r22, kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.encodeChunked(io.ktor.utils.io.ByteWriteChannel, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0057  */
    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0075 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x008c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0095 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x0097  */
    /* JADX WARN: Code duplicated, block: B:34:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a1 A[PHI: r9 r10 r11
      0x00a1: PHI (r9v5 int) = (r9v2 int), (r9v3 int), (r9v2 int) binds: [B:61:0x00d9, B:72:0x00fe, B:34:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x00a1: PHI (r10v5 int) = (r10v2 int), (r10v4 int), (r10v2 int) binds: [B:61:0x00d9, B:72:0x00fe, B:34:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x00a1: PHI (r11v5 long) = (r11v2 long), (r11v4 long), (r11v2 long) binds: [B:61:0x00d9, B:72:0x00fe, B:34:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00af  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:74:0x0101  */
    /* JADX WARN: Code duplicated, block: B:76:0x0107  */
    /* JADX WARN: Code duplicated, block: B:78:0x011d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0076 -> B:23:0x007c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008c -> B:29:0x008d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x00ad
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object parseChunkSize(io.ktor.utils.io.ByteReadChannel r23, kotlin.coroutines.Continuation r24) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.parseChunkSize(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void rethrowCloseCause(ByteReadChannel byteReadChannel) throws Throwable {
        Throwable closedCause = byteReadChannel instanceof ByteChannel ? ((ByteChannel) byteReadChannel).getClosedCause() : null;
        if (closedCause != null) {
            throw closedCause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        if (r7 == r5) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object skipCrLf(ByteReadChannel byteReadChannel, Continuation continuation) throws IOException {
        C03071 c03071;
        if (continuation instanceof C03071) {
            c03071 = (C03071) continuation;
            int i = c03071.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03071.label = i - Integer.MIN_VALUE;
            } else {
                c03071 = new C03071(continuation);
            }
        } else {
            c03071 = new C03071(continuation);
        }
        Object obj = c03071.result;
        int i2 = c03071.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c03071.L$0 = byteReadChannel;
            c03071.label = 1;
            obj = ByteReadChannelOperationsKt.readByte(byteReadChannel, c03071);
            if (obj != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            byteReadChannel = (ByteReadChannel) c03071.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((Number) obj).byteValue() == 10) {
            return Unit.INSTANCE;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Expected LF");
        return null;
        if (((Number) obj).byteValue() != 13) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Expected CR");
            return null;
        }
        c03071.L$0 = null;
        c03071.label = 2;
        obj = ByteReadChannelOperationsKt.readByte(byteReadChannel, c03071);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x00e9 A[PHI: r0 r1 r2 r4
      0x00e9: PHI (r0v4 int) = (r0v3 int), (r0v10 int) binds: [B:31:0x00e6, B:20:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x00e9: PHI (r1v4 int) = (r1v3 int), (r1v11 int) binds: [B:31:0x00e6, B:20:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x00e9: PHI (r2v4 int) = (r2v3 int), (r2v9 int) binds: [B:31:0x00e6, B:20:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x00e9: PHI (r4v8 io.ktor.utils.io.ByteWriteChannel) = (r4v7 io.ktor.utils.io.ByteWriteChannel), (r4v19 io.ktor.utils.io.ByteWriteChannel) binds: [B:31:0x00e6, B:20:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x0103  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0114, code lost:
    
        if (r4.flush(r9) == r14) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeChunk(ByteWriteChannel byteWriteChannel, byte[] bArr, int i, int i2, Continuation continuation) {
        C03081 c03081;
        int i3;
        byte[] bArr2;
        ByteWriteChannel byteWriteChannel2;
        int i4;
        byte[] bArr3;
        int i5;
        int i6;
        byte[] bArr4;
        ByteWriteChannel byteWriteChannel3;
        ByteWriteChannel byteWriteChannel4;
        ByteWriteChannel byteWriteChannel5 = byteWriteChannel;
        int i7 = i;
        int i8 = i2;
        if (continuation instanceof C03081) {
            c03081 = (C03081) continuation;
            int i9 = c03081.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                c03081.label = i9 - Integer.MIN_VALUE;
            } else {
                c03081 = new C03081(continuation);
            }
        } else {
            c03081 = new C03081(continuation);
        }
        C03081 c03082 = c03081;
        Object obj = c03082.result;
        int i10 = c03082.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            i3 = i8 - i7;
            c03082.L$0 = byteWriteChannel5;
            bArr2 = bArr;
            c03082.L$1 = bArr2;
            c03082.I$0 = i7;
            c03082.I$1 = i8;
            c03082.I$2 = i3;
            c03082.label = 1;
            if (CharsKt.writeIntHex(byteWriteChannel5, i3, c03082) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i10 == 1) {
            int i11 = c03082.I$2;
            int i12 = c03082.I$1;
            int i13 = c03082.I$0;
            bArr2 = (byte[]) c03082.L$1;
            ByteWriteChannel byteWriteChannel6 = (ByteWriteChannel) c03082.L$0;
            ResultKt.throwOnFailure(obj);
            i8 = i12;
            i7 = i13;
            i3 = i11;
            byteWriteChannel5 = byteWriteChannel6;
        } else {
            if (i10 == 2) {
                i4 = c03082.I$2;
                i6 = c03082.I$1;
                i5 = c03082.I$0;
                byte[] bArr5 = (byte[]) c03082.L$1;
                ByteWriteChannel byteWriteChannel7 = (ByteWriteChannel) c03082.L$0;
                ResultKt.throwOnFailure(obj);
                bArr3 = bArr5;
                byteWriteChannel2 = byteWriteChannel7;
                c03082.L$0 = byteWriteChannel2;
                c03082.L$1 = null;
                c03082.I$0 = i5;
                c03082.I$1 = i6;
                c03082.I$2 = i4;
                c03082.label = 3;
                if (ByteWriteChannelOperationsKt.writeFully(byteWriteChannel2, bArr3, i5, i6, c03082) != coroutineSingletons) {
                    bArr4 = CrLf;
                    c03082.L$0 = byteWriteChannel2;
                    c03082.L$1 = null;
                    c03082.I$0 = i5;
                    c03082.I$1 = i6;
                    c03082.I$2 = i4;
                    c03082.label = 4;
                    byteWriteChannel3 = byteWriteChannel2;
                    if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel3, bArr4, 0, 0, c03082, 6, null) != coroutineSingletons) {
                        byteWriteChannel4 = byteWriteChannel3;
                        c03082.L$0 = null;
                        c03082.L$1 = null;
                        c03082.I$0 = i5;
                        c03082.I$1 = i6;
                        c03082.I$2 = i4;
                        c03082.label = 5;
                    }
                }
                return coroutineSingletons;
            }
            if (i10 == 3) {
                i4 = c03082.I$2;
                i6 = c03082.I$1;
                i5 = c03082.I$0;
                byteWriteChannel2 = (ByteWriteChannel) c03082.L$0;
                ResultKt.throwOnFailure(obj);
                bArr4 = CrLf;
                c03082.L$0 = byteWriteChannel2;
                c03082.L$1 = null;
                c03082.I$0 = i5;
                c03082.I$1 = i6;
                c03082.I$2 = i4;
                c03082.label = 4;
                byteWriteChannel3 = byteWriteChannel2;
                if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel3, bArr4, 0, 0, c03082, 6, null) != coroutineSingletons) {
                    byteWriteChannel4 = byteWriteChannel3;
                    c03082.L$0 = null;
                    c03082.L$1 = null;
                    c03082.I$0 = i5;
                    c03082.I$1 = i6;
                    c03082.I$2 = i4;
                    c03082.label = 5;
                }
                return coroutineSingletons;
            }
            if (i10 == 4) {
                i4 = c03082.I$2;
                i6 = c03082.I$1;
                i5 = c03082.I$0;
                byteWriteChannel4 = (ByteWriteChannel) c03082.L$0;
                ResultKt.throwOnFailure(obj);
                c03082.L$0 = null;
                c03082.L$1 = null;
                c03082.I$0 = i5;
                c03082.I$1 = i6;
                c03082.I$2 = i4;
                c03082.label = 5;
            } else {
                if (i10 != 5) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i4 = c03082.I$2;
                ResultKt.throwOnFailure(obj);
            }
        }
        return new Integer(i4);
        c03082.L$0 = byteWriteChannel5;
        c03082.L$1 = bArr2;
        c03082.I$0 = i7;
        c03082.I$1 = i8;
        c03082.I$2 = i3;
        c03082.label = 2;
        if (ByteWriteChannelOperationsKt.writeShort(byteWriteChannel5, CrLfShort, c03082) != coroutineSingletons) {
            byte[] bArr6 = bArr2;
            byteWriteChannel2 = byteWriteChannel5;
            i4 = i3;
            bArr3 = bArr6;
            int i14 = i8;
            i5 = i7;
            i6 = i14;
            c03082.L$0 = byteWriteChannel2;
            c03082.L$1 = null;
            c03082.I$0 = i5;
            c03082.I$1 = i6;
            c03082.I$2 = i4;
            c03082.label = 3;
            if (ByteWriteChannelOperationsKt.writeFully(byteWriteChannel2, bArr3, i5, i6, c03082) != coroutineSingletons) {
                bArr4 = CrLf;
                c03082.L$0 = byteWriteChannel2;
                c03082.L$1 = null;
                c03082.I$0 = i5;
                c03082.I$1 = i6;
                c03082.I$2 = i4;
                c03082.label = 4;
                byteWriteChannel3 = byteWriteChannel2;
                if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel3, bArr4, 0, 0, c03082, 6, null) != coroutineSingletons) {
                    byteWriteChannel4 = byteWriteChannel3;
                    c03082.L$0 = null;
                    c03082.L$1 = null;
                    c03082.I$0 = i5;
                    c03082.I$1 = i6;
                    c03082.I$2 = i4;
                    c03082.label = 5;
                }
            }
        }
        return coroutineSingletons;
    }

    public static final WriterJob decodeChunked(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, long j) {
        coroutineScope.getClass();
        byteReadChannel.getClass();
        return ByteWriteChannelOperationsKt.writer$default(coroutineScope, coroutineScope.getCoroutineContext(), false, (Function2) new AnonymousClass1(byteReadChannel, null), 2, (Object) null);
    }

    @Deprecated
    public static final WriterJob decodeChunked(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel) {
        coroutineScope.getClass();
        byteReadChannel.getClass();
        return decodeChunked(coroutineScope, byteReadChannel, -1L);
    }

    public static final ReaderJob encodeChunked(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext) {
        byteWriteChannel.getClass();
        coroutineContext.getClass();
        return ByteReadChannelOperationsKt.reader((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2) new C03041(byteWriteChannel, null));
    }
}
