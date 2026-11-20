package io.ktor.http.content;

import com.yalantis.ucrop.BuildConfig;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004&'()B=\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R-\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u0013\u0010%\u001a\u0004\u0018\u00010\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$\u0082\u0001\u0004*+,-¨\u0006."}, d2 = {"Lio/ktor/http/content/PartData;", "", "Lkotlin/Function0;", "", "dispose", "Lio/ktor/http/Headers;", "headers", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BuildConfig.BUILD_TYPE, "<init>", "(Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function0;", "getDispose", "()Lkotlin/jvm/functions/Function0;", "getDispose$annotations", "()V", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Lkotlin/jvm/functions/Function1;", "getRelease", "()Lkotlin/jvm/functions/Function1;", "Lio/ktor/http/ContentDisposition;", "contentDisposition$delegate", "Lkotlin/Lazy;", "getContentDisposition", "()Lio/ktor/http/ContentDisposition;", "contentDisposition", "Lio/ktor/http/ContentType;", "contentType$delegate", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "", "getName", "()Ljava/lang/String;", ContentDisposition.Parameters.Name, "FormItem", "FileItem", "BinaryItem", "BinaryChannelItem", "Lio/ktor/http/content/PartData$BinaryChannelItem;", "Lio/ktor/http/content/PartData$BinaryItem;", "Lio/ktor/http/content/PartData$FileItem;", "Lio/ktor/http/content/PartData$FormItem;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PartData {

    /* JADX INFO: renamed from: contentDisposition$delegate, reason: from kotlin metadata */
    private final Lazy contentDisposition;

    /* JADX INFO: renamed from: contentType$delegate, reason: from kotlin metadata */
    private final Lazy contentType;
    private final Function0 dispose;
    private final Headers headers;
    private final Function1 release;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/content/PartData$BinaryChannelItem;", "Lio/ktor/http/content/PartData;", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "provider", "Lio/ktor/http/Headers;", "partHeaders", "<init>", "(Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "Lkotlin/jvm/functions/Function0;", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class BinaryChannelItem extends PartData {
        private final Function0 provider;

        /* JADX INFO: renamed from: io.ktor.http.content.PartData$BinaryChannelItem$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.http.content.PartData$BinaryChannelItem$2", f = "Multipart.kt", l = {}, m = "invokeSuspend", v = 1)
        public static final class AnonymousClass2 extends SuspendLambda implements Function1 {
            int label;

            public AnonymousClass2(Continuation continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass2(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BinaryChannelItem(Function0 function0, Headers headers) {
            super(new PartData$BinaryChannelItem$$ExternalSyntheticLambda0(), headers, new AnonymousClass2(null), null);
            function0.getClass();
            headers.getClass();
            this.provider = function0;
        }

        public final Function0 getProvider() {
            return this.provider;
        }
    }

    private PartData(Function0 function0, Headers headers, Function1 function1) {
        this.dispose = function0;
        this.headers = headers;
        this.release = function1;
        final byte b = 0;
        Function0 function2 = new Function0(this) { // from class: io.ktor.http.content.PartData$$ExternalSyntheticLambda0
            public final /* synthetic */ PartData f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b2 = b;
                PartData partData = this.f$0;
                switch (b2) {
                    case 0:
                        return PartData.contentDisposition_delegate$lambda$0(partData);
                    default:
                        return PartData.contentType_delegate$lambda$0(partData);
                }
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.contentDisposition = ResultKt.lazy(lazyThreadSafetyMode, function2);
        final byte b2 = 1;
        this.contentType = ResultKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: io.ktor.http.content.PartData$$ExternalSyntheticLambda0
            public final /* synthetic */ PartData f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b3 = b2;
                PartData partData = this.f$0;
                switch (b3) {
                    case 0:
                        return PartData.contentDisposition_delegate$lambda$0(partData);
                    default:
                        return PartData.contentType_delegate$lambda$0(partData);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentDisposition contentDisposition_delegate$lambda$0(PartData partData) {
        String str = partData.headers.get(HttpHeaders.ContentDisposition);
        if (str != null) {
            return ContentDisposition.INSTANCE.parse(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType contentType_delegate$lambda$0(PartData partData) {
        String str = partData.headers.get(HttpHeaders.ContentType);
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }

    public final ContentDisposition getContentDisposition() {
        return (ContentDisposition) this.contentDisposition.getValue();
    }

    public final ContentType getContentType() {
        return (ContentType) this.contentType.getValue();
    }

    public final Function0 getDispose() {
        return this.dispose;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final String getName() {
        ContentDisposition contentDisposition = getContentDisposition();
        if (contentDisposition != null) {
            return contentDisposition.getName();
        }
        return null;
    }

    public final Function1 getRelease() {
        return this.release;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001BO\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u001e\b\u0002\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0004\b\u000e\u0010\u000fB1\b\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u0010R!\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/http/content/PartData$BinaryItem;", "Lio/ktor/http/content/PartData;", "Lkotlin/Function0;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "provider", "", "dispose", "Lio/ktor/http/Headers;", "partHeaders", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", BuildConfig.BUILD_TYPE, "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;Lkotlin/jvm/functions/Function1;)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "Lkotlin/jvm/functions/Function0;", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class BinaryItem extends PartData {
        private final Function0 provider;

        /* JADX INFO: renamed from: io.ktor.http.content.PartData$BinaryItem$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.http.content.PartData$BinaryItem$1", f = "Multipart.kt", l = {}, m = "invokeSuspend", v = 1)
        public static final class AnonymousClass1 extends SuspendLambda implements Function1 {
            int label;

            public AnonymousClass1(Continuation continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX INFO: renamed from: io.ktor.http.content.PartData$BinaryItem$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.http.content.PartData$BinaryItem$2", f = "Multipart.kt", l = {}, m = "invokeSuspend", v = 1)
        public static final class AnonymousClass2 extends SuspendLambda implements Function1 {
            int label;

            public AnonymousClass2(Continuation continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass2(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BinaryItem(Function0 function0, Function0 function1, Headers headers, Function1 function2) {
            super(function1, headers, function2, null);
            function0.getClass();
            function1.getClass();
            headers.getClass();
            function2.getClass();
            this.provider = function0;
        }

        public final Function0 getProvider() {
            return this.provider;
        }

        public /* synthetic */ BinaryItem(Function0 function0, Function0 function1, Headers headers, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, function1, headers, (i & 8) != 0 ? new AnonymousClass1(null) : function2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ BinaryItem(Function0 function0, Function0 function1, Headers headers) {
            this(function0, function1, headers, new AnonymousClass2(null));
            function0.getClass();
            function1.getClass();
            headers.getClass();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u001e\b\u0002\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0004\b\r\u0010\u000eB'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/content/PartData$FormItem;", "Lio/ktor/http/content/PartData;", "", "value", "Lkotlin/Function0;", "", "dispose", "Lio/ktor/http/Headers;", "partHeaders", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", BuildConfig.BUILD_TYPE, "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class FormItem extends PartData {
        private final String value;

        /* JADX INFO: renamed from: io.ktor.http.content.PartData$FormItem$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.http.content.PartData$FormItem$1", f = "Multipart.kt", l = {}, m = "invokeSuspend", v = 1)
        public static final class AnonymousClass1 extends SuspendLambda implements Function1 {
            int label;

            public AnonymousClass1(Continuation continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX INFO: renamed from: io.ktor.http.content.PartData$FormItem$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.http.content.PartData$FormItem$2", f = "Multipart.kt", l = {}, m = "invokeSuspend", v = 1)
        public static final class AnonymousClass2 extends SuspendLambda implements Function1 {
            int label;

            public AnonymousClass2(Continuation continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass2(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FormItem(String str, Function0 function0, Headers headers, Function1 function1) {
            super(function0, headers, function1, null);
            str.getClass();
            function0.getClass();
            headers.getClass();
            function1.getClass();
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        public /* synthetic */ FormItem(String str, Function0 function0, Headers headers, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, function0, headers, (i & 8) != 0 ? new AnonymousClass1(null) : function1);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ FormItem(String str, Function0 function0, Headers headers) {
            this(str, function0, headers, new AnonymousClass2(null));
            str.getClass();
            function0.getClass();
            headers.getClass();
        }
    }

    @Deprecated
    public static /* synthetic */ void getDispose$annotations() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u001e\b\u0002\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0004\b\r\u0010\u000eB-\b\u0017\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/http/content/PartData$FileItem;", "Lio/ktor/http/content/PartData;", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "provider", "", "dispose", "Lio/ktor/http/Headers;", "partHeaders", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", BuildConfig.BUILD_TYPE, "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;Lkotlin/jvm/functions/Function1;)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "Lkotlin/jvm/functions/Function0;", "getProvider", "()Lkotlin/jvm/functions/Function0;", "", "originalFileName", "Ljava/lang/String;", "getOriginalFileName", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class FileItem extends PartData {
        private final String originalFileName;
        private final Function0 provider;

        /* JADX INFO: renamed from: io.ktor.http.content.PartData$FileItem$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.http.content.PartData$FileItem$1", f = "Multipart.kt", l = {}, m = "invokeSuspend", v = 1)
        public static final class AnonymousClass1 extends SuspendLambda implements Function1 {
            int label;

            public AnonymousClass1(Continuation continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX INFO: renamed from: io.ktor.http.content.PartData$FileItem$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.http.content.PartData$FileItem$2", f = "Multipart.kt", l = {}, m = "invokeSuspend", v = 1)
        public static final class AnonymousClass2 extends SuspendLambda implements Function1 {
            int label;

            public AnonymousClass2(Continuation continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass2(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FileItem(Function0 function0, Function0 function1, Headers headers, Function1 function2) {
            super(function1, headers, function2, 0 == true ? 1 : 0);
            function0.getClass();
            function1.getClass();
            headers.getClass();
            function2.getClass();
            this.provider = function0;
            ContentDisposition contentDisposition = getContentDisposition();
            this.originalFileName = contentDisposition != null ? contentDisposition.parameter(ContentDisposition.Parameters.FileName) : null;
        }

        public final String getOriginalFileName() {
            return this.originalFileName;
        }

        public final Function0 getProvider() {
            return this.provider;
        }

        public /* synthetic */ FileItem(Function0 function0, Function0 function1, Headers headers, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, function1, headers, (i & 8) != 0 ? new AnonymousClass1(null) : function2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ FileItem(Function0 function0, Function0 function1, Headers headers) {
            this(function0, function1, headers, new AnonymousClass2(null));
            function0.getClass();
            function1.getClass();
            headers.getClass();
        }
    }

    public /* synthetic */ PartData(Function0 function0, Headers headers, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, headers, function1);
    }
}
