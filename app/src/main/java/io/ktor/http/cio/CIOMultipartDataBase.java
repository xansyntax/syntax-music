package io.ktor.http.cio;

import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.BuildConfig;
import io.ktor.http.ContentDisposition;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.MultiPartData;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.DeprecationKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.io.Buffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0004\b\u0011\u0010\u0010J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lio/ktor/http/cio/CIOMultipartDataBase;", "Lio/ktor/http/content/MultiPartData;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "", "contentType", "", "contentLength", "formFieldLimit", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/CharSequence;Ljava/lang/Long;J)V", "Lio/ktor/http/content/PartData;", "readPart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPartSuspend", "Lio/ktor/http/cio/MultipartEvent;", "event", "eventToData", "(Lio/ktor/http/cio/MultipartEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "part", "partToData", "(Lio/ktor/http/cio/MultipartEvent$MultipartPart;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/HttpHeadersMap;", "Lio/ktor/http/Headers;", "snapshot", "(Lio/ktor/http/cio/HttpHeadersMap;)Lio/ktor/http/Headers;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "previousPart", "Lio/ktor/http/content/PartData;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "events", "Lkotlinx/coroutines/channels/ReceiveChannel;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CIOMultipartDataBase implements MultiPartData, CoroutineScope {
    private final CoroutineContext coroutineContext;
    private final ReceiveChannel events;
    private PartData previousPart;

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$eventToData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", l = {62, 65, 70}, m = "eventToData", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return CIOMultipartDataBase.this.eventToData(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$partToData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", l = {76, 86}, m = "partToData", v = 1)
    public static final class C03011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C03011(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.partToData(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$partToData$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1 {
        public AnonymousClass5(Object obj) {
            super(1, obj, MultipartEvent.MultipartPart.class, "releaseSuspend", "releaseSuspend(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((MultipartEvent.MultipartPart) this.receiver).releaseSuspend(continuation);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$readPart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", l = {35, 39, 45}, m = "readPart", v = 1)
    public static final class C03021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03021(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.readPart(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", l = {51, 52}, m = "readPartSuspend", v = 1)
    public static final class C03031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03031(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.readPartSuspend(this);
        }
    }

    public CIOMultipartDataBase(CoroutineContext coroutineContext, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l, long j) {
        coroutineContext.getClass();
        byteReadChannel.getClass();
        charSequence.getClass();
        this.coroutineContext = coroutineContext;
        this.events = MultipartKt.parseMultipart(this, byteReadChannel, charSequence, l, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object eventToData(MultipartEvent multipartEvent, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objPartToData = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objPartToData);
                if (multipartEvent instanceof MultipartEvent.MultipartPart) {
                    anonymousClass1.L$0 = multipartEvent;
                    anonymousClass1.label = 1;
                    objPartToData = partToData((MultipartEvent.MultipartPart) multipartEvent, anonymousClass1);
                    if (objPartToData == obj) {
                    }
                    return (PartData) objPartToData;
                }
                anonymousClass1.L$0 = multipartEvent;
                anonymousClass1.label = 2;
                if (multipartEvent.releaseSuspend(anonymousClass1) != obj) {
                    return null;
                }
                return obj;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(objPartToData);
                return (PartData) objPartToData;
            }
            if (i2 == 2) {
                ResultKt.throwOnFailure(objPartToData);
                return null;
            }
            if (i2 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Throwable th = (Throwable) anonymousClass1.L$1;
            ResultKt.throwOnFailure(objPartToData);
            throw th;
        } catch (Throwable th2) {
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = th2;
            anonymousClass1.label = 3;
            if (multipartEvent.releaseSuspend(anonymousClass1) != obj) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
    
        if (r8 == r5) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object partToData(MultipartEvent.MultipartPart multipartPart, Continuation continuation) {
        C03011 c03011;
        Headers headersSnapshot;
        if (continuation instanceof C03011) {
            c03011 = (C03011) continuation;
            int i = c03011.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03011.label = i - Integer.MIN_VALUE;
            } else {
                c03011 = new C03011(continuation);
            }
        } else {
            c03011 = new C03011(continuation);
        }
        Object objAwait = c03011.result;
        int i2 = c03011.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            Deferred headers = multipartPart.getHeaders();
            c03011.L$0 = multipartPart;
            c03011.label = 1;
            objAwait = headers.await(c03011);
            if (objAwait != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            multipartPart = (MultipartEvent.MultipartPart) c03011.L$0;
            ResultKt.throwOnFailure(objAwait);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            headersSnapshot = (Headers) c03011.L$2;
            multipartPart = (MultipartEvent.MultipartPart) c03011.L$0;
            ResultKt.throwOnFailure(objAwait);
        }
        Buffer buffer = (Buffer) objAwait;
        try {
            PartData.FormItem formItem = new PartData.FormItem(DeprecationKt.readText(buffer), new CIOMultipartDataBase$partToData$2$1(multipartPart), headersSnapshot, new CIOMultipartDataBase$partToData$2$2(multipartPart));
            StringsKt__IndentKt.closeFinally(buffer, null);
            return formItem;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(buffer, th);
                throw th2;
            }
        }
        headersSnapshot = snapshot((HttpHeadersMap) objAwait);
        String str = headersSnapshot.get(HttpHeaders.ContentDisposition);
        ContentDisposition contentDisposition = str != null ? ContentDisposition.INSTANCE.parse(str) : null;
        String strParameter = contentDisposition != null ? contentDisposition.parameter(ContentDisposition.Parameters.FileName) : null;
        ByteReadChannel body = multipartPart.getBody();
        if (strParameter != null) {
            return new PartData.FileItem(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 26, multipartPart), new AnonymousClass4(multipartPart), headersSnapshot, new AnonymousClass5(multipartPart));
        }
        c03011.L$0 = multipartPart;
        c03011.L$1 = null;
        c03011.L$2 = headersSnapshot;
        c03011.L$3 = null;
        c03011.L$4 = null;
        c03011.L$5 = null;
        c03011.label = 2;
        objAwait = ByteReadChannelOperationsKt.readBuffer(body, c03011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    /* JADX WARN: Code duplicated, block: B:23:0x0049 A[Catch: ClosedReceiveChannelException -> 0x005b, PHI: r7
      0x0049: PHI (r7v2 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:21:0x0046, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {ClosedReceiveChannelException -> 0x005b, blocks: (B:13:0x002b, B:26:0x0056, B:20:0x003c, B:23:0x0049, B:17:0x0035), top: B:30:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (r7 == r5) goto L25;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0053 -> B:26:0x0056). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readPartSuspend(Continuation continuation) throws Throwable {
        C03031 c03031;
        if (continuation instanceof C03031) {
            c03031 = (C03031) continuation;
            int i = c03031.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03031.label = i - Integer.MIN_VALUE;
            } else {
                c03031 = new C03031(continuation);
            }
        } else {
            c03031 = new C03031(continuation);
        }
        Object objEventToData = c03031.result;
        int i2 = c03031.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objEventToData);
                ReceiveChannel receiveChannel = this.events;
                c03031.L$0 = null;
                c03031.label = 1;
                objEventToData = receiveChannel.receive(c03031);
                if (objEventToData == obj) {
                    c03031.L$0 = null;
                    c03031.label = 2;
                    objEventToData = eventToData((MultipartEvent) objEventToData, c03031);
                }
                return obj;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(objEventToData);
                c03031.L$0 = null;
                c03031.label = 2;
                objEventToData = eventToData((MultipartEvent) objEventToData, c03031);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objEventToData);
            }
            PartData partData = (PartData) objEventToData;
            if (partData != null) {
                return partData;
            }
            ReceiveChannel receiveChannel2 = this.events;
            c03031.L$0 = null;
            c03031.label = 1;
            objEventToData = receiveChannel2.receive(c03031);
            if (objEventToData == obj) {
                c03031.L$0 = null;
                c03031.label = 2;
                objEventToData = eventToData((MultipartEvent) objEventToData, c03031);
            }
            return obj;
        } catch (ClosedReceiveChannelException unused) {
            return null;
        }
    }

    private final Headers snapshot(HttpHeadersMap httpHeadersMap) {
        Headers.Companion companion = Headers.INSTANCE;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        Iterator it = httpHeadersMap.offsets().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            headersBuilder.append(httpHeadersMap.nameAtOffset(iIntValue).toString(), httpHeadersMap.valueAtOffset(iIntValue).toString());
        }
        return headersBuilder.build();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if (r8 == r6) goto L32;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0076 -> B:33:0x0079). Please report as a decompilation issue!!! */
    @Override // io.ktor.http.content.MultiPartData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object readPart(Continuation continuation) throws Throwable {
        C03021 c03021;
        if (continuation instanceof C03021) {
            c03021 = (C03021) continuation;
            int i = c03021.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03021.label = i - Integer.MIN_VALUE;
            } else {
                c03021 = new C03021(continuation);
            }
        } else {
            c03021 = new C03021(continuation);
        }
        Object objEventToData = c03021.result;
        int i2 = c03021.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objEventToData);
            PartData partData = this.previousPart;
            if (partData != null) {
                Function1 release = partData.getRelease();
                c03021.label = 1;
                if (release.invoke(c03021) != obj) {
                }
            }
            return obj;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(objEventToData);
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    ResultKt.throwOnFailure(objEventToData);
                    return objEventToData;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objEventToData);
        }
        PartData partData2 = (PartData) objEventToData;
        if (partData2 != null) {
            this.previousPart = partData2;
            return partData2;
        }
        MultipartEvent multipartEvent = (MultipartEvent) ChannelResult.m1903getOrNullimpl(this.events.mo1861tryReceivePtdJZtk());
        if (multipartEvent == null) {
            c03021.L$0 = null;
            c03021.label = 3;
            Object partSuspend = readPartSuspend(c03021);
            if (partSuspend != obj) {
                return partSuspend;
            }
        } else {
            c03021.L$0 = null;
            c03021.label = 2;
            objEventToData = eventToData(multipartEvent, c03021);
        }
        return obj;
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$partToData$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0 {
        public AnonymousClass4(Object obj) {
            super(0, obj, MultipartEvent.MultipartPart.class, BuildConfig.BUILD_TYPE, "release()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1700invoke() {
            ((MultipartEvent.MultipartPart) this.receiver).release();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m1700invoke();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ CIOMultipartDataBase(CoroutineContext coroutineContext, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineContext, byteReadChannel, charSequence, l, (i & 16) != 0 ? 65536L : j);
    }
}
