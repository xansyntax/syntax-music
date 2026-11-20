package io.ktor.http.cio;

import coil3.network.HttpException;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMethod;
import io.ktor.http.cio.internals.AsciiCharTree;
import io.ktor.http.cio.internals.CharArrayBuilder;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.http.cio.internals.MutableRange;
import io.ktor.http.cio.internals.TokenizerKt;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.LineEndingMode;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\b\u0010\u0004\u001a,\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\b\u0010\r\u001a\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\"\u0010#\u001a/\u0010)\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b)\u0010*\u001a\u001f\u0010+\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010-\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010/\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b/\u00100\u001a\u0017\u00101\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b1\u00102\u001a\u0017\u00104\u001a\u00020(2\u0006\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105\"\u0014\u00106\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107\"\u0014\u00108\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00107\"\u0014\u00109\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00107\"\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020&0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<\" \u0010>\u001a\u00020=8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b>\u00107\u0012\u0004\bA\u0010B\u001a\u0004\b?\u0010@\"\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/http/cio/Request;", "parseRequest", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/Response;", "parseResponse", "Lio/ktor/http/cio/HttpHeadersMap;", "parseHeaders", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "builder", "Lio/ktor/http/cio/internals/MutableRange;", "range", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "host", "", "validateHostHeader", "(Ljava/lang/CharSequence;)V", ContentType.Text.TYPE, "Lio/ktor/http/HttpMethod;", "parseHttpMethod", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Lio/ktor/http/HttpMethod;", "parseHttpMethodFull", "parseUri", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Ljava/lang/CharSequence;", "parseVersion", "", "parseStatusCode", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)I", "code", "", "statusOutOfRange", "(I)Z", "parseHeaderName", "(Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;)I", "index", "start", "", "ch", "", "parseHeaderNameFailed", "(Lio/ktor/http/cio/internals/CharArrayBuilder;IIC)Ljava/lang/Void;", "parseHeaderValue", "(Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;)V", "noColonFound", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Ljava/lang/Void;", "characterIsNotAllowed", "(Ljava/lang/CharSequence;C)Ljava/lang/Void;", "isDelimiter", "(C)Z", "result", "unsupportedHttpVersion", "(Ljava/lang/CharSequence;)Ljava/lang/Void;", "HTTP_LINE_LIMIT", "I", "HTTP_STATUS_CODE_MIN_RANGE", "HTTP_STATUS_CODE_MAX_RANGE", "", "hostForbiddenSymbols", "Ljava/util/Set;", "Lio/ktor/utils/io/LineEndingMode;", "httpLineEndings", "getHttpLineEndings", "()I", "getHttpLineEndings$annotations", "()V", "Lio/ktor/http/cio/internals/AsciiCharTree;", "", "versions", "Lio/ktor/http/cio/internals/AsciiCharTree;", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpParserKt {
    private static final int HTTP_LINE_LIMIT = 8192;
    private static final int HTTP_STATUS_CODE_MAX_RANGE = 999;
    private static final int HTTP_STATUS_CODE_MIN_RANGE = 100;
    private static final Set<Character> hostForbiddenSymbols = ArraysKt.toSet(new Character[]{'/', '?', '#', '@'});
    private static final int httpLineEndings;
    private static final AsciiCharTree<String> versions;

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseHeaders$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", l = {105}, m = "parseHeaders", v = 1)
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
            return HttpParserKt.parseHeaders(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseHeaders$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", l = {120}, m = "parseHeaders", v = 1)
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseHeaders(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", l = {45, 60}, m = "parseRequest", v = 1)
    public static final class C03091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C03091(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", l = {80, 89}, m = "parseResponse", v = 1)
    public static final class C03101 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C03101(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseResponse(null, this);
        }
    }

    static {
        LineEndingMode.Companion companion = LineEndingMode.INSTANCE;
        httpLineEndings = LineEndingMode.m1847plus1TerO4(companion.m1852getCRLFf0jXZW8(), companion.m1853getLFf0jXZW8());
        versions = AsciiCharTree.INSTANCE.build(CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"HTTP/1.0", "HTTP/1.1"}));
    }

    private static final Void characterIsNotAllowed(CharSequence charSequence, char c) {
        throw new ParserException("Character with code " + (c & 255) + " is not allowed in header names, \n" + ((Object) charSequence));
    }

    public static final int getHttpLineEndings() {
        return httpLineEndings;
    }

    private static final boolean isDelimiter(char c) {
        return Intrinsics.compare((int) c, 32) <= 0 || StringsKt.contains$default("\"(),/:;<=>?@[\\]{}", c);
    }

    private static final Void noColonFound(CharSequence charSequence, MutableRange mutableRange) {
        throw new ParserException("No colon in HTTP header in " + charSequence.subSequence(mutableRange.getStart(), mutableRange.getEnd()).toString() + " in builder: \n" + ((Object) charSequence));
    }

    public static final int parseHeaderName(CharArrayBuilder charArrayBuilder, MutableRange mutableRange) {
        charArrayBuilder.getClass();
        mutableRange.getClass();
        int end = mutableRange.getEnd();
        for (int start = mutableRange.getStart(); start < end; start++) {
            char cCharAt = charArrayBuilder.charAt(start);
            if (cCharAt == ':' && start != mutableRange.getStart()) {
                mutableRange.setStart(start + 1);
                return start;
            }
            if (isDelimiter(cCharAt)) {
                parseHeaderNameFailed(charArrayBuilder, start, mutableRange.getStart(), cCharAt);
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return 0;
            }
        }
        noColonFound(charArrayBuilder, mutableRange);
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return 0;
    }

    private static final Void parseHeaderNameFailed(CharArrayBuilder charArrayBuilder, int i, int i2, char c) {
        if (c == ':') {
            throw new ParserException("Empty header names are not allowed as per RFC7230.");
        }
        if (i == i2) {
            throw new ParserException("Multiline headers via line folding is not supported since it is deprecated as per RFC7230.");
        }
        characterIsNotAllowed(charArrayBuilder, c);
        throw new HttpException();
    }

    public static final void parseHeaderValue(CharArrayBuilder charArrayBuilder, MutableRange mutableRange) {
        charArrayBuilder.getClass();
        mutableRange.getClass();
        int start = mutableRange.getStart();
        int end = mutableRange.getEnd();
        int iSkipSpacesAndHorizontalTabs = TokenizerKt.skipSpacesAndHorizontalTabs(charArrayBuilder, start, end);
        if (iSkipSpacesAndHorizontalTabs >= end) {
            mutableRange.setStart(end);
            return;
        }
        int i = iSkipSpacesAndHorizontalTabs;
        int i2 = i;
        while (i < end) {
            char cCharAt = charArrayBuilder.charAt(i);
            if (cCharAt != '\t') {
                if (cCharAt == '\n' || cCharAt == '\r') {
                    characterIsNotAllowed(charArrayBuilder, cCharAt);
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return;
                } else if (cCharAt != ' ') {
                    i2 = i;
                }
            }
            i++;
        }
        mutableRange.setStart(iSkipSpacesAndHorizontalTabs);
        mutableRange.setEnd(i2 + 1);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0067 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0074 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:12:0x0032, B:23:0x0068, B:25:0x0074, B:27:0x0078, B:31:0x008e, B:19:0x0050, B:32:0x00ac, B:33:0x00b3, B:34:0x00b4, B:36:0x00bc), top: B:40:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0078 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:12:0x0032, B:23:0x0068, B:25:0x0074, B:27:0x0078, B:31:0x008e, B:19:0x0050, B:32:0x00ac, B:33:0x00b3, B:34:0x00b4, B:36:0x00bc), top: B:40:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x008a  */
    /* JADX WARN: Code duplicated, block: B:31:0x008e A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:12:0x0032, B:23:0x0068, B:25:0x0074, B:27:0x0078, B:31:0x008e, B:19:0x0050, B:32:0x00ac, B:33:0x00b3, B:34:0x00b4, B:36:0x00bc), top: B:40:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0065 -> B:23:0x0068). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object parseHeaders(io.ktor.utils.io.ByteReadChannel r12, io.ktor.http.cio.internals.CharArrayBuilder r13, io.ktor.http.cio.internals.MutableRange r14, kotlin.coroutines.Continuation r15) {
        /*
            boolean r0 = r15 instanceof io.ktor.http.cio.HttpParserKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r15
            io.ktor.http.cio.HttpParserKt$parseHeaders$2 r0 = (io.ktor.http.cio.HttpParserKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.http.cio.HttpParserKt$parseHeaders$2 r0 = new io.ktor.http.cio.HttpParserKt$parseHeaders$2
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L44
            if (r1 != r3) goto L3e
            java.lang.Object r12 = r0.L$3
            io.ktor.http.cio.HttpHeadersMap r12 = (io.ktor.http.cio.HttpHeadersMap) r12
            java.lang.Object r13 = r0.L$2
            io.ktor.http.cio.internals.MutableRange r13 = (io.ktor.http.cio.internals.MutableRange) r13
            java.lang.Object r14 = r0.L$1
            io.ktor.http.cio.internals.CharArrayBuilder r14 = (io.ktor.http.cio.internals.CharArrayBuilder) r14
            java.lang.Object r1 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Throwable -> L3a
            r5 = r14
            r9 = r0
            r4 = r1
            r14 = r13
            goto L68
        L3a:
            r0 = move-exception
            r13 = r0
            goto Lc0
        L3e:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r12)
            return r2
        L44:
            kotlin.ResultKt.throwOnFailure(r15)
            io.ktor.http.cio.HttpHeadersMap r15 = new io.ktor.http.cio.HttpHeadersMap
            r15.<init>(r13)
            r4 = r12
            r5 = r13
            r12 = r15
            r9 = r0
        L50:
            r9.L$0 = r4     // Catch: java.lang.Throwable -> L3a
            r9.L$1 = r5     // Catch: java.lang.Throwable -> L3a
            r9.L$2 = r14     // Catch: java.lang.Throwable -> L3a
            r9.L$3 = r12     // Catch: java.lang.Throwable -> L3a
            r9.label = r3     // Catch: java.lang.Throwable -> L3a
            r6 = 8192(0x2000, double:4.0474E-320)
            r8 = 0
            r10 = 4
            r11 = 0
            java.lang.Object r15 = io.ktor.utils.io.ByteReadChannelOperationsKt.readLineStrictTo$default(r4, r5, r6, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L3a
            kotlin.coroutines.intrinsics.CoroutineSingletons r13 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r15 != r13) goto L68
            return r13
        L68:
            java.lang.Number r15 = (java.lang.Number) r15     // Catch: java.lang.Throwable -> L3a
            long r0 = r15.longValue()     // Catch: java.lang.Throwable -> L3a
            r6 = -1
            int r13 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r13 != 0) goto L78
            r12.release()     // Catch: java.lang.Throwable -> L3a
            return r2
        L78:
            int r13 = r5.length()     // Catch: java.lang.Throwable -> L3a
            r14.setEnd(r13)     // Catch: java.lang.Throwable -> L3a
            int r13 = r14.getEnd()     // Catch: java.lang.Throwable -> L3a
            int r15 = r14.getStart()     // Catch: java.lang.Throwable -> L3a
            int r13 = r13 - r15
            if (r13 == 0) goto Lb4
            r15 = 8192(0x2000, float:1.148E-41)
            if (r13 >= r15) goto Lac
            int r13 = r14.getStart()     // Catch: java.lang.Throwable -> L3a
            int r15 = parseHeaderName(r5, r14)     // Catch: java.lang.Throwable -> L3a
            int r0 = r14.getEnd()     // Catch: java.lang.Throwable -> L3a
            parseHeaderValue(r5, r14)     // Catch: java.lang.Throwable -> L3a
            int r1 = r14.getStart()     // Catch: java.lang.Throwable -> L3a
            int r6 = r14.getEnd()     // Catch: java.lang.Throwable -> L3a
            r14.setStart(r0)     // Catch: java.lang.Throwable -> L3a
            r12.put(r13, r15, r1, r6)     // Catch: java.lang.Throwable -> L3a
            goto L50
        Lac:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L3a
            java.lang.String r14 = "Header line length limit exceeded"
            r13.<init>(r14)     // Catch: java.lang.Throwable -> L3a
            throw r13     // Catch: java.lang.Throwable -> L3a
        Lb4:
            java.lang.String r13 = "Host"
            java.lang.CharSequence r13 = r12.get(r13)     // Catch: java.lang.Throwable -> L3a
            if (r13 == 0) goto Lbf
            validateHostHeader(r13)     // Catch: java.lang.Throwable -> L3a
        Lbf:
            return r12
        Lc0:
            r12.release()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseHeaders(io.ktor.utils.io.ByteReadChannel, io.ktor.http.cio.internals.CharArrayBuilder, io.ktor.http.cio.internals.MutableRange, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object parseHeaders$default(ByteReadChannel byteReadChannel, CharArrayBuilder charArrayBuilder, MutableRange mutableRange, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            mutableRange = new MutableRange(0, 0);
        }
        return parseHeaders(byteReadChannel, charArrayBuilder, mutableRange, continuation);
    }

    private static final HttpMethod parseHttpMethod(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        HttpMethod httpMethod = (HttpMethod) CollectionsKt.singleOrNull(AsciiCharTree.search$default(CharsKt.getDefaultHttpMethods(), charSequence, mutableRange.getStart(), mutableRange.getEnd(), false, new HttpParserKt$$ExternalSyntheticLambda0((byte) 0), 8, null));
        if (httpMethod == null) {
            return parseHttpMethodFull(charSequence, mutableRange);
        }
        mutableRange.setStart(httpMethod.getValue().length() + mutableRange.getStart());
        return httpMethod;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseHttpMethod$lambda$0(char c, int i) {
        return c == ' ';
    }

    private static final HttpMethod parseHttpMethodFull(CharSequence charSequence, MutableRange mutableRange) {
        return new HttpMethod(TokenizerKt.nextToken(charSequence, mutableRange).toString());
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007b A[Catch: all -> 0x00fc, PHI: r2 r8 r9 r13
      0x007b: PHI (r2v2 io.ktor.http.cio.internals.MutableRange) = (r2v1 io.ktor.http.cio.internals.MutableRange), (r2v3 io.ktor.http.cio.internals.MutableRange) binds: [B:25:0x0069, B:33:0x00ab] A[DONT_GENERATE, DONT_INLINE]
      0x007b: PHI (r8v1 io.ktor.utils.io.ByteReadChannel) = (r8v0 io.ktor.utils.io.ByteReadChannel), (r8v2 io.ktor.utils.io.ByteReadChannel) binds: [B:25:0x0069, B:33:0x00ab] A[DONT_GENERATE, DONT_INLINE]
      0x007b: PHI (r9v1 io.ktor.http.cio.internals.CharArrayBuilder) = (r9v0 io.ktor.http.cio.internals.CharArrayBuilder), (r9v2 io.ktor.http.cio.internals.CharArrayBuilder) binds: [B:25:0x0069, B:33:0x00ab] A[DONT_GENERATE, DONT_INLINE]
      0x007b: PHI (r13v1 io.ktor.http.cio.HttpParserKt$parseRequest$1) = (r13v0 io.ktor.http.cio.HttpParserKt$parseRequest$1), (r13v2 io.ktor.http.cio.HttpParserKt$parseRequest$1) binds: [B:25:0x0069, B:33:0x00ab] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #3 {all -> 0x00fc, blocks: (B:29:0x008f, B:32:0x009c, B:26:0x007b, B:34:0x00ad, B:36:0x00c6, B:38:0x00cc, B:40:0x00d2, B:53:0x00ff, B:54:0x0106, B:55:0x0107, B:56:0x010e, B:57:0x010f, B:58:0x0135), top: B:67:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:28:0x008e  */
    /* JADX WARN: Code duplicated, block: B:31:0x009b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x009c A[Catch: all -> 0x00fc, TryCatch #3 {all -> 0x00fc, blocks: (B:29:0x008f, B:32:0x009c, B:26:0x007b, B:34:0x00ad, B:36:0x00c6, B:38:0x00cc, B:40:0x00d2, B:53:0x00ff, B:54:0x0106, B:55:0x0107, B:56:0x010e, B:57:0x010f, B:58:0x0135), top: B:67:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ad A[Catch: all -> 0x00fc, TryCatch #3 {all -> 0x00fc, blocks: (B:29:0x008f, B:32:0x009c, B:26:0x007b, B:34:0x00ad, B:36:0x00c6, B:38:0x00cc, B:40:0x00d2, B:53:0x00ff, B:54:0x0106, B:55:0x0107, B:56:0x010e, B:57:0x010f, B:58:0x0135), top: B:67:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c6 A[Catch: all -> 0x00fc, TryCatch #3 {all -> 0x00fc, blocks: (B:29:0x008f, B:32:0x009c, B:26:0x007b, B:34:0x00ad, B:36:0x00c6, B:38:0x00cc, B:40:0x00d2, B:53:0x00ff, B:54:0x0106, B:55:0x0107, B:56:0x010e, B:57:0x010f, B:58:0x0135), top: B:67:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00cc A[Catch: all -> 0x00fc, TryCatch #3 {all -> 0x00fc, blocks: (B:29:0x008f, B:32:0x009c, B:26:0x007b, B:34:0x00ad, B:36:0x00c6, B:38:0x00cc, B:40:0x00d2, B:53:0x00ff, B:54:0x0106, B:55:0x0107, B:56:0x010e, B:57:0x010f, B:58:0x0135), top: B:67:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d2 A[Catch: all -> 0x00fc, TRY_LEAVE, TryCatch #3 {all -> 0x00fc, blocks: (B:29:0x008f, B:32:0x009c, B:26:0x007b, B:34:0x00ad, B:36:0x00c6, B:38:0x00cc, B:40:0x00d2, B:53:0x00ff, B:54:0x0106, B:55:0x0107, B:56:0x010e, B:57:0x010f, B:58:0x0135), top: B:67:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00f3 A[Catch: all -> 0x00f9, TRY_LEAVE, TryCatch #1 {all -> 0x00f9, blocks: (B:44:0x00ed, B:47:0x00f3), top: B:63:0x00ed }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ff A[Catch: all -> 0x00fc, TRY_ENTER, TryCatch #3 {all -> 0x00fc, blocks: (B:29:0x008f, B:32:0x009c, B:26:0x007b, B:34:0x00ad, B:36:0x00c6, B:38:0x00cc, B:40:0x00d2, B:53:0x00ff, B:54:0x0106, B:55:0x0107, B:56:0x010e, B:57:0x010f, B:58:0x0135), top: B:67:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0107 A[Catch: all -> 0x00fc, TryCatch #3 {all -> 0x00fc, blocks: (B:29:0x008f, B:32:0x009c, B:26:0x007b, B:34:0x00ad, B:36:0x00c6, B:38:0x00cc, B:40:0x00d2, B:53:0x00ff, B:54:0x0106, B:55:0x0107, B:56:0x010e, B:57:0x010f, B:58:0x0135), top: B:67:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:57:0x010f A[Catch: all -> 0x00fc, TryCatch #3 {all -> 0x00fc, blocks: (B:29:0x008f, B:32:0x009c, B:26:0x007b, B:34:0x00ad, B:36:0x00c6, B:38:0x00cc, B:40:0x00d2, B:53:0x00ff, B:54:0x0106, B:55:0x0107, B:56:0x010e, B:57:0x010f, B:58:0x0135), top: B:67:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:67:0x008f A[EXC_TOP_SPLITTER, PHI: r0 r2 r8 r9 r13
      0x008f: PHI (r0v4 java.lang.Object) = (r0v3 java.lang.Object), (r0v1 java.lang.Object) binds: [B:27:0x008c, B:22:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x008f: PHI (r2v3 io.ktor.http.cio.internals.MutableRange) = (r2v2 io.ktor.http.cio.internals.MutableRange), (r2v9 io.ktor.http.cio.internals.MutableRange) binds: [B:27:0x008c, B:22:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x008f: PHI (r8v2 io.ktor.utils.io.ByteReadChannel) = (r8v1 io.ktor.utils.io.ByteReadChannel), (r8v6 io.ktor.utils.io.ByteReadChannel) binds: [B:27:0x008c, B:22:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x008f: PHI (r9v2 io.ktor.http.cio.internals.CharArrayBuilder) = (r9v1 io.ktor.http.cio.internals.CharArrayBuilder), (r9v5 io.ktor.http.cio.internals.CharArrayBuilder) binds: [B:27:0x008c, B:22:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x008f: PHI (r13v2 io.ktor.http.cio.HttpParserKt$parseRequest$1) = (r13v1 io.ktor.http.cio.HttpParserKt$parseRequest$1), (r13v3 io.ktor.http.cio.HttpParserKt$parseRequest$1) binds: [B:27:0x008c, B:22:0x0062] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008c -> B:67:0x008f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object parseRequest(io.ktor.utils.io.ByteReadChannel r16, kotlin.coroutines.Continuation r17) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseRequest(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00da A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:36:0x00d6, B:38:0x00da, B:42:0x00e5), top: B:46:0x00d6 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static final Object parseResponse(ByteReadChannel byteReadChannel, Continuation continuation) throws Throwable {
        C03101 c03101;
        Throwable th;
        CharArrayBuilder charArrayBuilder;
        CharArrayBuilder charArrayBuilder2;
        MutableRange mutableRange;
        ByteReadChannel byteReadChannel2;
        CharSequence version;
        int i;
        CharSequence charSequence;
        CharArrayBuilder charArrayBuilder3;
        HttpHeadersMap httpHeadersMap;
        if (continuation instanceof C03101) {
            c03101 = (C03101) continuation;
            int i2 = c03101.label;
            charArrayBuilder = -2147483648;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c03101.label = i2 - Integer.MIN_VALUE;
            } else {
                c03101 = new C03101(continuation);
            }
        } else {
            c03101 = new C03101(continuation);
        }
        C03101 c03102 = c03101;
        Object obj = c03102.result;
        int i3 = c03102.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                charArrayBuilder2 = new CharArrayBuilder(null, 1, null);
                MutableRange mutableRange2 = new MutableRange(0, 0);
                c03102.L$0 = byteReadChannel;
                c03102.L$1 = charArrayBuilder2;
                c03102.L$2 = mutableRange2;
                c03102.label = 1;
                Object lineStrictTo$default = ByteReadChannelOperationsKt.readLineStrictTo$default(byteReadChannel, charArrayBuilder2, 8192L, null, c03102, 4, null);
                if (lineStrictTo$default != coroutineSingletons) {
                    obj = lineStrictTo$default;
                    mutableRange = mutableRange2;
                    byteReadChannel2 = byteReadChannel;
                }
                return coroutineSingletons;
            }
            if (i3 == 1) {
                mutableRange = (MutableRange) c03102.L$2;
                charArrayBuilder2 = (CharArrayBuilder) c03102.L$1;
                byteReadChannel2 = (ByteReadChannel) c03102.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                int i4 = c03102.I$0;
                CharSequence charSequence2 = (CharSequence) c03102.L$4;
                version = (CharSequence) c03102.L$3;
                charArrayBuilder2 = (CharArrayBuilder) c03102.L$1;
                ResultKt.throwOnFailure(obj);
                i = i4;
                charSequence = charSequence2;
            }
            CharSequence charSequence3 = version;
            charArrayBuilder3 = charArrayBuilder2;
            try {
                httpHeadersMap = (HttpHeadersMap) obj;
                if (httpHeadersMap == null) {
                    httpHeadersMap = new HttpHeadersMap(charArrayBuilder3);
                }
                return new Response(charSequence3, i, charSequence, httpHeadersMap, charArrayBuilder3);
            } catch (Throwable th2) {
                th = th2;
                charArrayBuilder = charArrayBuilder3;
                charArrayBuilder.release();
                throw th;
            }
            if (((Number) obj).longValue() == -1) {
                return null;
            }
            mutableRange.setEnd(charArrayBuilder2.length());
            version = parseVersion(charArrayBuilder2, mutableRange);
            int statusCode = parseStatusCode(charArrayBuilder2, mutableRange);
            TokenizerKt.skipSpaces(charArrayBuilder2, mutableRange);
            CharSequence charSequenceSubSequence = charArrayBuilder2.subSequence(mutableRange.getStart(), mutableRange.getEnd());
            mutableRange.setStart(mutableRange.getEnd());
            c03102.L$0 = null;
            c03102.L$1 = charArrayBuilder2;
            c03102.L$2 = null;
            c03102.L$3 = version;
            c03102.L$4 = charSequenceSubSequence;
            c03102.I$0 = statusCode;
            c03102.label = 2;
            Object headers = parseHeaders(byteReadChannel2, charArrayBuilder2, mutableRange, c03102);
            if (headers != coroutineSingletons) {
                i = statusCode;
                charSequence = charSequenceSubSequence;
                obj = headers;
                CharSequence charSequence4 = version;
                charArrayBuilder3 = charArrayBuilder2;
                httpHeadersMap = (HttpHeadersMap) obj;
                if (httpHeadersMap == null) {
                    httpHeadersMap = new HttpHeadersMap(charArrayBuilder3);
                }
                return new Response(charSequence4, i, charSequence, httpHeadersMap, charArrayBuilder3);
            }
            return coroutineSingletons;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static final int parseStatusCode(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        int end = mutableRange.getEnd();
        int end2 = mutableRange.getEnd();
        int i = 0;
        for (int start = mutableRange.getStart(); start < end2; start++) {
            char cCharAt = charSequence.charAt(start);
            if (cCharAt == ' ') {
                if (!statusOutOfRange(i)) {
                    end = start;
                    break;
                }
                throw new ParserException("Status-code must be 3-digit. Status received: " + i + '.');
            }
            if ('0' > cCharAt || cCharAt >= ':') {
                throw new NumberFormatException("Illegal digit " + cCharAt + " in status code " + charSequence.subSequence(mutableRange.getStart(), TokenizerKt.findSpaceOrEnd(charSequence, mutableRange)).toString());
            }
            i = (i * 10) + (cCharAt - '0');
        }
        mutableRange.setStart(end);
        return i;
    }

    private static final CharSequence parseUri(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        int start = mutableRange.getStart();
        int iFindSpaceOrEnd = TokenizerKt.findSpaceOrEnd(charSequence, mutableRange);
        int i = iFindSpaceOrEnd - start;
        if (i <= 0) {
            return "";
        }
        if (i == 1 && charSequence.charAt(start) == '/') {
            mutableRange.setStart(iFindSpaceOrEnd);
            return "/";
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(start, iFindSpaceOrEnd);
        mutableRange.setStart(iFindSpaceOrEnd);
        return charSequenceSubSequence;
    }

    private static final CharSequence parseVersion(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        if (mutableRange.getStart() >= mutableRange.getEnd()) {
            PathKt$$ExternalSyntheticBUOutline0.m$2(charSequence, "Failed to parse version: ");
            return null;
        }
        String str = (String) CollectionsKt.singleOrNull(AsciiCharTree.search$default(versions, charSequence, mutableRange.getStart(), mutableRange.getEnd(), false, new HttpParserKt$$ExternalSyntheticLambda0((byte) 13), 8, null));
        if (str != null) {
            mutableRange.setStart(str.length() + mutableRange.getStart());
            return str;
        }
        unsupportedHttpVersion(TokenizerKt.nextToken(charSequence, mutableRange));
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseVersion$lambda$1(char c, int i) {
        return c == ' ';
    }

    private static final boolean statusOutOfRange(int i) {
        return i < HTTP_STATUS_CODE_MIN_RANGE || i > HTTP_STATUS_CODE_MAX_RANGE;
    }

    private static final Void unsupportedHttpVersion(CharSequence charSequence) {
        throw new ParserException("Unsupported HTTP version: " + ((Object) charSequence));
    }

    private static final void validateHostHeader(CharSequence charSequence) {
        if (StringsKt.endsWith$default(charSequence, ServerSentEventKt.COLON)) {
            throw new ParserException("Host header with ':' should contains port: " + ((Object) charSequence));
        }
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            Set<Character> set = hostForbiddenSymbols;
            if (set.contains(Character.valueOf(cCharAt))) {
                throw new ParserException("Host cannot contain any of the following symbols: " + set);
            }
        }
    }

    public static /* synthetic */ void getHttpLineEndings$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object parseHeaders(ByteReadChannel byteReadChannel, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        CharArrayBuilder charArrayBuilder;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object headers$default = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(headers$default);
            CharArrayBuilder charArrayBuilder2 = new CharArrayBuilder(null, 1, null);
            anonymousClass2.L$0 = null;
            anonymousClass2.L$1 = charArrayBuilder2;
            anonymousClass2.label = 1;
            headers$default = parseHeaders$default(byteReadChannel, charArrayBuilder2, null, anonymousClass2, 4, null);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (headers$default == coroutineSingletons) {
                return coroutineSingletons;
            }
            charArrayBuilder = charArrayBuilder2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            charArrayBuilder = (CharArrayBuilder) anonymousClass2.L$1;
            ResultKt.throwOnFailure(headers$default);
        }
        HttpHeadersMap httpHeadersMap = (HttpHeadersMap) headers$default;
        return httpHeadersMap == null ? new HttpHeadersMap(charArrayBuilder) : httpHeadersMap;
    }
}
