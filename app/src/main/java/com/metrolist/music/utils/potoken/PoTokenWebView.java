package com.metrolist.music.utils.potoken;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.collection.ArrayMap;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda3;
import com.metrolist.innertube.YouTube;
import dagger.hilt.EntryPoints;
import io.ktor.http.HttpHeaders;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.RealCall;
import okio.Okio__OkioKt;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\f\u0010 \u001a\u00020\u001fH\u0007b\u0002\b!J\u0014\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0015H\u0007b\u0002\b!J\u0014\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0015H\u0007b\u0002\b!J\f\u0010&\u001a\u00020\u001fH\u0007b\u0002\b!J\u0016\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0015H\u0007b\u0002\b!J\u001c\u0010.\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0015H\u0007b\u0002\b!J\u001e\u00101\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00152\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005H\u0002J\u0018\u00102\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00052\u0006\u0010(\u001a\u00020\u0015H\u0002J\u001a\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\u0017H\u0002J,\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u00152\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001f08H\u0002J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020:H\u0002J\u0006\u0010;\u001a\u00020\u001fJ\f\u0010<\u001a\u00020\u001fH\u0003b\u0002\b=R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012Rf\u0010\u0013\u001aZ\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015 \u0016*\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00050\u0005 \u0016*,\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015 \u0016*\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00050\u0005\u0018\u00010\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b0\u0010\u0012Ê\u0001\f\b@\u0012\b\bA\u0012\u0004\b\u0003\u0010\u0000¨\u0006?"}, d2 = {"Lcom/metrolist/music/utils/potoken/PoTokenWebView;", "", "context", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "<init>", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)V", "webView", "Landroid/webkit/WebView;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "initResumed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "closed", "", "value", "isDead", "()Z", "poTokenContinuations", "", "", "kotlin.jvm.PlatformType", "", "requestCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "expirationInstant", "Ljava/time/Instant;", "loadHtmlAndObtainBotguard", "", "downloadAndRunBotguard", "Landroid/webkit/JavascriptInterface;", "onJsInitializationError", "error", "onRunBotguardResult", "botguardResponse", "onMinterCreated", "generatePoToken", "identifier", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generatePoTokenInternal", "requestKey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onObtainPoTokenError", "onObtainPoTokenResult", "poTokenU8", "isExpired", "addPoTokenEmitter", "popPoTokenContinuation", "popAllPoTokenContinuations", "makeBotguardServiceRequest", "url", "data", "handleResponseBody", "Lkotlin/Function1;", "onInitializationErrorCloseAndCancel", "", "close", "destroyWebView", "Landroidx/annotation/MainThread;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PoTokenWebView {
    private static final long GENERATE_TIMEOUT_MS = 15000;
    private static final String GOOGLE_API_KEY = "AIzaSyDyT5W0Jh49F30Pqqtyfdf7pDLFKLJoAnw";
    private static final long INIT_TIMEOUT_MS = 45000;
    private static final String JS_INTERFACE = "PoTokenWebView";
    private static final String REQUEST_KEY = "O43z0dpjhgX20SCx4KAo";
    private static final String TAG = "PoTokenWebView";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.3";
    private static final OkHttpClient httpClient;
    private volatile boolean closed;
    private final Continuation continuation;
    private final CoroutineExceptionHandler exceptionHandler;
    private Instant expirationInstant;
    private final AtomicBoolean initResumed;
    private volatile boolean isDead;
    private final Map<String, Continuation> poTokenContinuations;
    private final AtomicLong requestCounter;
    private final CoroutineScope scope;
    private final WebView webView;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenWebView$generatePoToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 560)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView", f = "PoTokenWebView.kt", l = {272}, m = "generatePoToken", v = 2)
    public static final class C01961 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C01961(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PoTokenWebView.this.generatePoToken(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenWebView$generatePoToken$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$generatePoToken$2", f = "PoTokenWebView.kt", l = {273}, m = "invokeSuspend", v = 2)
    public static final class C01972 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $identifier;
        final /* synthetic */ String $requestKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01972(String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.$identifier = str;
            this.$requestKey = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PoTokenWebView.this.new C01972(this.$identifier, this.$requestKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C01972) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            PoTokenWebView poTokenWebView = PoTokenWebView.this;
            String str = this.$identifier;
            String str2 = this.$requestKey;
            this.label = 1;
            Object objGeneratePoTokenInternal = poTokenWebView.generatePoTokenInternal(str, str2, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objGeneratePoTokenInternal == coroutineSingletons ? coroutineSingletons : objGeneratePoTokenInternal;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenWebView$generatePoTokenInternal$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$generatePoTokenInternal$2", f = "PoTokenWebView.kt", l = {496}, m = "invokeSuspend", v = 2)
    public static final class C01982 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $identifier;
        final /* synthetic */ String $requestKey;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01982(String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.$requestKey = str;
            this.$identifier = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PoTokenWebView.this.new C01982(this.$requestKey, this.$identifier, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C01982) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            PoTokenWebView poTokenWebView = PoTokenWebView.this;
            String str = this.$requestKey;
            String str2 = this.$identifier;
            this.L$0 = poTokenWebView;
            this.L$1 = str;
            this.L$2 = str2;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(this));
            cancellableContinuationImpl.initCancellability();
            Timber.Forest.tag("PoTokenWebView");
            ConnectionPool.d(new Object[0]);
            poTokenWebView.addPoTokenEmitter(str, cancellableContinuationImpl);
            poTokenWebView.webView.evaluateJavascript(Fragment$5$$ExternalSyntheticOutline0.m("(function() {\n                        var requestKey = \"", str, "\"\n                        try {\n                            var u8Identifier = ", JavaScriptUtilKt.stringToU8(str2), "\n                            obtainPoToken(u8Identifier).then(function(poTokenU8) {\n                                PoTokenWebView.onObtainPoTokenResult(requestKey, poTokenU8.join(\",\"))\n                            }).catch(function(error) {\n                                PoTokenWebView.onObtainPoTokenError(requestKey, error + \"\\n\" + (error.stack || ''))\n                            })\n                        } catch (error) {\n                            PoTokenWebView.onObtainPoTokenError(requestKey, error + \"\\n\" + error.stack)\n                        }\n                    })()"), null);
            Object result = cancellableContinuationImpl.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return result == coroutineSingletons ? coroutineSingletons : result;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenWebView$loadHtmlAndObtainBotguard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$loadHtmlAndObtainBotguard$1", f = "PoTokenWebView.kt", l = {150}, m = "invokeSuspend", v = 2)
    public static final class C01991 extends SuspendLambda implements Function2 {
        int label;

        public C01991(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PoTokenWebView.this.new C01991(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C01991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                PoTokenWebView$loadHtmlAndObtainBotguard$1$html$1 poTokenWebView$loadHtmlAndObtainBotguard$1$html$1 = new PoTokenWebView$loadHtmlAndObtainBotguard$1$html$1(PoTokenWebView.this, null);
                this.label = 1;
                obj = AwaitKt.withContext(defaultIoScheduler, poTokenWebView$loadHtmlAndObtainBotguard$1$html$1, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            PoTokenWebView.this.webView.loadDataWithBaseURL("https://www.youtube.com", StringsKt__StringsJVMKt.replaceFirst$default((String) obj, "</script>", "\nPoTokenWebView.downloadAndRunBotguard()</script>"), "text/html", "utf-8", null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenWebView$makeBotguardServiceRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$makeBotguardServiceRequest$1", f = "PoTokenWebView.kt", l = {387}, m = "invokeSuspend", v = 2)
    public static final class C02001 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $data;
        final /* synthetic */ Function1 $handleResponseBody;
        final /* synthetic */ String $url;
        Object L$0;
        int label;
        final /* synthetic */ PoTokenWebView this$0;

        /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenWebView$makeBotguardServiceRequest$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
        @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$makeBotguardServiceRequest$1$1", f = "PoTokenWebView.kt", l = {}, m = "invokeSuspend", v = 2)
        public static final class C00101 extends SuspendLambda implements Function2 {
            final /* synthetic */ Request.Builder $requestBuilder;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00101(Request.Builder builder, Continuation continuation) {
                super(2, continuation);
                this.$requestBuilder = builder;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00101(this.$requestBuilder, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C00101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws IOException {
                ResponseBody responseBody;
                String strString = null;
                if (this.label != 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                OkHttpClient okHttpClient = PoTokenWebView.httpClient;
                Request.Builder builder = this.$requestBuilder;
                builder.getClass();
                Request request = new Request(builder);
                okHttpClient.getClass();
                Response responseExecute = new RealCall(okHttpClient, request, false).execute();
                int i = responseExecute.code;
                try {
                    Integer num = new Integer(i);
                    if (i == 200 && (responseBody = responseExecute.body) != null) {
                        strString = responseBody.string();
                    }
                    Pair pair = new Pair(num, strString);
                    responseExecute.close();
                    return pair;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(responseExecute, th);
                        throw th2;
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02001(String str, String str2, PoTokenWebView poTokenWebView, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$data = str;
            this.$url = str2;
            this.this$0 = poTokenWebView;
            this.$handleResponseBody = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C02001(this.$data, this.$url, this.this$0, this.$handleResponseBody, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Request.Builder builder = new Request.Builder();
                RequestBody.Companion companion = RequestBody.Companion;
                String str = this.$data;
                companion.getClass();
                builder.method("POST", RequestBody.Companion.create(str, null));
                Headers headers = Headers.EMPTY;
                Map mapMapOf = MapsKt__MapsKt.mapOf(new Pair(HttpHeaders.UserAgent, PoTokenWebView.USER_AGENT), new Pair(HttpHeaders.Accept, "application/json"), new Pair(HttpHeaders.ContentType, "application/json+protobuf"), new Pair("x-goog-api-key", PoTokenWebView.GOOGLE_API_KEY), new Pair("x-user-agent", "grpc-web-javascript/0.1"));
                String[] strArr = new String[mapMapOf.size() * 2];
                int i2 = 0;
                for (Map.Entry entry : mapMapOf.entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    String string = StringsKt.trim(str2).toString();
                    String string2 = StringsKt.trim(str3).toString();
                    EntryPoints.headersCheckName(string);
                    EntryPoints.headersCheckValue(string2, string);
                    strArr[i2] = string;
                    strArr[i2 + 1] = string2;
                    i2 += 2;
                }
                builder.headers = EntryPoints.commonNewBuilder(new Headers(strArr));
                builder.url(this.$url);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                C00101 c00101 = new C00101(builder, null);
                this.L$0 = null;
                this.label = 1;
                obj = AwaitKt.withContext(defaultIoScheduler, c00101, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            Pair pair = (Pair) obj;
            int iIntValue = ((Number) pair.first).intValue();
            String str4 = (String) pair.second;
            if (str4 == null || str4.length() == 0) {
                this.this$0.onInitializationErrorCloseAndCancel(new PoTokenException(IntIntPair$$ExternalSyntheticOutline0.m(iIntValue, "Invalid botguard response (code=", ", empty body)")));
            } else {
                this.$handleResponseBody.invoke(str4);
            }
            return Unit.INSTANCE;
        }
    }

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(YouTube.innerTube.configuredProxy);
        httpClient = new OkHttpClient(builder);
    }

    private PoTokenWebView(Context context, Continuation continuation) {
        this.continuation = continuation;
        WebView webView = new WebView(context);
        this.webView = webView;
        this.scope = AwaitKt.MainScope();
        this.initResumed = new AtomicBoolean(false);
        this.poTokenContinuations = Collections.synchronizedMap(new ArrayMap(0));
        this.requestCounter = new AtomicLong();
        this.exceptionHandler = new PoTokenWebView$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.$$INSTANCE, this);
        WebSettings settings = webView.getSettings();
        settings.getClass();
        settings.setJavaScriptEnabled(true);
        settings.setUserAgentString(USER_AGENT);
        settings.setBlockNetworkLoads(true);
        webView.addJavascriptInterface(this, "PoTokenWebView");
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.metrolist.music.utils.potoken.PoTokenWebView.1

            /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenWebView$1$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(k = 3, mv = {2, 4, 0}, xi = 1328)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
                    try {
                        iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage m) {
                ConnectionPool connectionPool;
                m.getClass();
                String strMessage = m.message();
                ConsoleMessage.MessageLevel messageLevel = m.messageLevel();
                int i = messageLevel == null ? -1 : WhenMappings.$EnumSwitchMapping$0[messageLevel.ordinal()];
                if (i == 1) {
                    connectionPool = Timber.Forest;
                    connectionPool.tag("PoTokenWebView");
                    ConnectionPool.e(new Object[0]);
                } else if (i != 2) {
                    connectionPool = Timber.Forest;
                    connectionPool.tag("PoTokenWebView");
                    ConnectionPool.d(new Object[0]);
                } else {
                    connectionPool = Timber.Forest;
                    connectionPool.tag("PoTokenWebView");
                    ConnectionPool.w(new Object[0]);
                }
                strMessage.getClass();
                if (StringsKt.contains(strMessage, "Uncaught", false)) {
                    String strM = Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("\"", strMessage, "\", source: ", m.sourceId(), " ("), m.lineNumber(), ")");
                    if (PoTokenWebView.this.initResumed.get()) {
                        connectionPool.tag("PoTokenWebView");
                        ConnectionPool.e(new Object[0]);
                        PoTokenWebView.this.isDead = true;
                        PoTokenException poTokenException = new PoTokenException(strM);
                        PoTokenWebView.this.close();
                        Iterator it = PoTokenWebView.this.popAllPoTokenContinuations().entrySet().iterator();
                        while (it.hasNext()) {
                            try {
                                ((Continuation) ((Map.Entry) it.next()).getValue()).resumeWith(new Result.Failure(poTokenException));
                            } catch (Throwable unused) {
                            }
                        }
                    } else {
                        BadWebViewException badWebViewException = new BadWebViewException(strM);
                        connectionPool.tag("PoTokenWebView");
                        ConnectionPool.e(new Object[0]);
                        PoTokenWebView.this.onInitializationErrorCloseAndCancel(badWebViewException);
                        Iterator it2 = PoTokenWebView.this.popAllPoTokenContinuations().entrySet().iterator();
                        while (it2.hasNext()) {
                            try {
                                ((Continuation) ((Map.Entry) it2.next()).getValue()).resumeWith(new Result.Failure(badWebViewException));
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                return super.onConsoleMessage(m);
            }
        });
        webView.setWebViewClient(new WebViewClient() { // from class: com.metrolist.music.utils.potoken.PoTokenWebView.2
            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                Object failure;
                view.getClass();
                detail.getClass();
                try {
                    failure = Boolean.valueOf(detail.didCrash());
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                if (failure instanceof Result.Failure) {
                    failure = null;
                }
                Timber.Forest.tag("PoTokenWebView");
                ConnectionPool.e(new Object[0]);
                PoTokenWebView.this.isDead = true;
                PoTokenException poTokenException = new PoTokenException("WebView render process gone (didCrash=" + ((Boolean) failure) + ")");
                PoTokenWebView.this.onInitializationErrorCloseAndCancel(poTokenException);
                Iterator it = PoTokenWebView.this.popAllPoTokenContinuations().entrySet().iterator();
                while (it.hasNext()) {
                    ((Continuation) ((Map.Entry) it.next()).getValue()).resumeWith(new Result.Failure(poTokenException));
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addPoTokenEmitter(String identifier, Continuation continuation) {
        Map<String, Continuation> map = this.poTokenContinuations;
        map.getClass();
        map.put(identifier, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyWebView() {
        Object failure;
        try {
            this.webView.clearHistory();
            this.webView.clearCache(true);
            this.webView.loadUrl("about:blank");
            this.webView.onPause();
            this.webView.removeAllViews();
            this.webView.destroy();
            failure = Unit.INSTANCE;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
        if (thM1866exceptionOrNullimpl != null) {
            Timber.Forest.tag("PoTokenWebView");
            String simpleName = Reflection.getOrCreateKotlinClass(thM1866exceptionOrNullimpl.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "unknown";
            }
            "PO-token WebView teardown failed type=".concat(simpleName);
            ConnectionPool.w(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit downloadAndRunBotguard$lambda$0(PoTokenWebView poTokenWebView, String str) {
        str.getClass();
        String challengeData = JavaScriptUtilKt.parseChallengeData(str);
        poTokenWebView.webView.evaluateJavascript("try {\n                    data = " + challengeData + "\n                    runBotGuard(data).then(function (result) {\n                        this.webPoSignalOutput = result.webPoSignalOutput\n                        PoTokenWebView.onRunBotguardResult(result.botguardResponse)\n                    }, function (error) {\n                        PoTokenWebView.onJsInitializationError(error + \"\\n\" + error.stack)\n                    })\n                } catch (error) {\n                    PoTokenWebView.onJsInitializationError(error + \"\\n\" + error.stack)\n                }", null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object generatePoTokenInternal(String str, String str2, Continuation continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return AwaitKt.withContext(MainDispatcherLoader.dispatcher, new C01982(str2, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadHtmlAndObtainBotguard() {
        Timber.Forest.tag("PoTokenWebView");
        ConnectionPool.d(new Object[0]);
        AwaitKt.launch$default(this.scope, this.exceptionHandler, null, new C01991(null), 2);
    }

    private final void makeBotguardServiceRequest(String url, String data, Function1 handleResponseBody) {
        AwaitKt.launch$default(this.scope, this.exceptionHandler, null, new C02001(data, url, this, handleResponseBody, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInitializationErrorCloseAndCancel(Throwable error) {
        close();
        if (this.initResumed.compareAndSet(false, true)) {
            try {
                this.continuation.resumeWith(ResultKt.createFailure(error));
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRunBotguardResult$lambda$0(PoTokenWebView poTokenWebView, String str) {
        str.getClass();
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("PoTokenWebView");
        ConnectionPool.d(new Object[0]);
        try {
            Pair integrityTokenData = JavaScriptUtilKt.parseIntegrityTokenData(str);
            String str2 = (String) integrityTokenData.first;
            long jLongValue = ((Number) integrityTokenData.second).longValue();
            connectionPool.tag("PoTokenWebView");
            ConnectionPool.d(new Object[0]);
            Instant instantMinus = Instant.now().plusSeconds(jLongValue).minus(10L, (TemporalUnit) ChronoUnit.MINUTES);
            instantMinus.getClass();
            poTokenWebView.expirationInstant = instantMinus;
            connectionPool.tag("PoTokenWebView");
            ConnectionPool.d(new Object[0]);
            poTokenWebView.webView.evaluateJavascript("try {\n                        console.log('[JS] Setting integrityToken and calling createPoTokenMinter...');\n                        this.integrityToken = " + str2 + "\n                        console.log('[JS] integrityToken set, now calling createPoTokenMinter...');\n                        createPoTokenMinter(webPoSignalOutput, integrityToken).then(function() {\n                            console.log('[JS] createPoTokenMinter .then() resolved!');\n                            PoTokenWebView.onMinterCreated()\n                        }).catch(function(error) {\n                            console.log('[JS] createPoTokenMinter .catch() error: ' + error);\n                            PoTokenWebView.onJsInitializationError(error + \"\\n\" + (error.stack || ''))\n                        })\n                    } catch (error) {\n                        console.log('[JS] createPoTokenMinter SYNC error: ' + error);\n                        PoTokenWebView.onJsInitializationError(error + \"\\n\" + error.stack)\n                    }", null);
        } catch (Exception e) {
            Timber.Forest.tag("PoTokenWebView");
            String simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "unknown";
            }
            "Failed to parse integrity token data type=".concat(simpleName);
            ConnectionPool.e(new Object[0]);
            poTokenWebView.onInitializationErrorCloseAndCancel(new PoTokenException(Fragment$5$$ExternalSyntheticOutline0.m("parseIntegrityTokenData failed: ", e.getMessage())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Continuation> popAllPoTokenContinuations() {
        Map<String, Continuation> map = this.poTokenContinuations;
        map.getClass();
        Map<String, Continuation> map2 = MapsKt__MapsKt.toMap(map);
        this.poTokenContinuations.clear();
        return map2;
    }

    private final Continuation popPoTokenContinuation(String identifier) {
        return this.poTokenContinuations.remove(identifier);
    }

    public final void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        AwaitKt.cancel(this.scope, (CancellationException) null);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            destroyWebView();
        } else {
            new Handler(Looper.getMainLooper()).post(new MediaSessionService$$ExternalSyntheticLambda3((byte) 4, this));
        }
    }

    @JavascriptInterface
    public final void downloadAndRunBotguard() {
        Timber.Forest.tag("PoTokenWebView");
        ConnectionPool.d(new Object[0]);
        makeBotguardServiceRequest("https://www.youtube.com/api/jnn/v1/Create", "[ \"O43z0dpjhgX20SCx4KAo\" ]", new PoTokenWebView$$ExternalSyntheticLambda0(this, (byte) 0));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object generatePoToken(String str, Continuation continuation) throws PoTokenException {
        C01961 c01961;
        String str2;
        if (continuation instanceof C01961) {
            c01961 = (C01961) continuation;
            int i = c01961.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01961.label = i - Integer.MIN_VALUE;
            } else {
                c01961 = new C01961(continuation);
            }
        } else {
            c01961 = new C01961(continuation);
        }
        Object obj = c01961.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c01961.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isDead || this.closed) {
                throw new PoTokenException("PoToken WebView is dead/closed — instance must be recreated");
            }
            String str3 = str + "#" + this.requestCounter.incrementAndGet();
            try {
                C01972 c01972 = new C01972(str, str3, null);
                c01961.L$0 = null;
                c01961.L$1 = str3;
                c01961.label = 1;
                Object objWithTimeout = AwaitKt.withTimeout(GENERATE_TIMEOUT_MS, c01972, c01961);
                if (objWithTimeout == coroutineSingletons) {
                    return coroutineSingletons;
                }
                obj = objWithTimeout;
                str2 = str3;
            } catch (TimeoutCancellationException unused) {
                str2 = str3;
                this.isDead = true;
                popPoTokenContinuation(str2);
                Timber.Forest.tag("PoTokenWebView");
                ConnectionPool.e(new Object[0]);
                throw new PoTokenException("poToken generation timed out after 15000ms");
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str2 = (String) c01961.L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (TimeoutCancellationException unused2) {
                this.isDead = true;
                popPoTokenContinuation(str2);
                Timber.Forest.tag("PoTokenWebView");
                ConnectionPool.e(new Object[0]);
                throw new PoTokenException("poToken generation timed out after 15000ms");
            }
        }
        return (String) obj;
    }

    /* JADX INFO: renamed from: isDead, reason: from getter */
    public final boolean getIsDead() {
        return this.isDead;
    }

    public final boolean isExpired() {
        Instant instantNow = Instant.now();
        Instant instant = this.expirationInstant;
        if (instant != null) {
            return instantNow.isAfter(instant);
        }
        Intrinsics.throwUninitializedPropertyAccessException("expirationInstant");
        throw null;
    }

    @JavascriptInterface
    public final void onJsInitializationError(String error) {
        error.getClass();
        onInitializationErrorCloseAndCancel(PoTokenExceptionKt.buildExceptionForJsError(error));
    }

    @JavascriptInterface
    public final void onMinterCreated() {
        Timber.Forest.tag("PoTokenWebView");
        ConnectionPool.d(new Object[0]);
        if (this.initResumed.compareAndSet(false, true)) {
            this.continuation.resumeWith(this);
        }
    }

    @JavascriptInterface
    public final void onObtainPoTokenError(String requestKey, String error) {
        requestKey.getClass();
        error.getClass();
        Continuation continuationPopPoTokenContinuation = popPoTokenContinuation(requestKey);
        if (continuationPopPoTokenContinuation != null) {
            continuationPopPoTokenContinuation.resumeWith(new Result.Failure(new PoTokenException(error)));
        }
    }

    @JavascriptInterface
    public final void onObtainPoTokenResult(String requestKey, String poTokenU8) {
        requestKey.getClass();
        poTokenU8.getClass();
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("PoTokenWebView");
        ConnectionPool.d(new Object[0]);
        try {
            String strU8ToBase64 = JavaScriptUtilKt.u8ToBase64(poTokenU8);
            connectionPool.tag("PoTokenWebView");
            ConnectionPool.d(new Object[0]);
            Continuation continuationPopPoTokenContinuation = popPoTokenContinuation(requestKey);
            if (continuationPopPoTokenContinuation != null) {
                continuationPopPoTokenContinuation.resumeWith(strU8ToBase64);
            }
        } catch (Throwable th) {
            Continuation continuationPopPoTokenContinuation2 = popPoTokenContinuation(requestKey);
            if (continuationPopPoTokenContinuation2 != null) {
                continuationPopPoTokenContinuation2.resumeWith(new Result.Failure(th));
            }
        }
    }

    @JavascriptInterface
    public final void onRunBotguardResult(String botguardResponse) {
        botguardResponse.getClass();
        Timber.Forest.tag("PoTokenWebView");
        "botguardResponse: ".concat(botguardResponse);
        ConnectionPool.d(new Object[0]);
        makeBotguardServiceRequest("https://www.youtube.com/api/jnn/v1/GenerateIT", "[ \"O43z0dpjhgX20SCx4KAo\", \"" + botguardResponse + "\" ]", new PoTokenWebView$$ExternalSyntheticLambda0(this, (byte) 1));
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/metrolist/music/utils/potoken/PoTokenWebView$Companion;", "", "<init>", "()V", "TAG", "", "GOOGLE_API_KEY", "REQUEST_KEY", "USER_AGENT", "JS_INTERFACE", "INIT_TIMEOUT_MS", "", "GENERATE_TIMEOUT_MS", "httpClient", "Lokhttp3/OkHttpClient;", "getNewPoTokenGenerator", "Lcom/metrolist/music/utils/potoken/PoTokenWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeQuietly", "", "potWv", "(Lcom/metrolist/music/utils/potoken/PoTokenWebView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object closeQuietly(PoTokenWebView poTokenWebView, Continuation continuation) {
            if (poTokenWebView != null) {
                NonCancellable nonCancellable = NonCancellable.INSTANCE;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                Object objWithContext = AwaitKt.withContext(nonCancellable.plus(MainDispatcherLoader.dispatcher), new PoTokenWebView$Companion$closeQuietly$2(poTokenWebView, null), continuation);
                if (objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return objWithContext;
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0092  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b1, code lost:
        
            if (closeQuietly(r11, r0) == r6) goto L37;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getNewPoTokenGenerator(Context context, Continuation continuation) throws PoTokenException {
            PoTokenWebView$Companion$getNewPoTokenGenerator$1 poTokenWebView$Companion$getNewPoTokenGenerator$1;
            Ref$ObjectRef ref$ObjectRefM5m;
            Ref$ObjectRef ref$ObjectRef;
            PoTokenWebView poTokenWebView;
            if (continuation instanceof PoTokenWebView$Companion$getNewPoTokenGenerator$1) {
                poTokenWebView$Companion$getNewPoTokenGenerator$1 = (PoTokenWebView$Companion$getNewPoTokenGenerator$1) continuation;
                int i = poTokenWebView$Companion$getNewPoTokenGenerator$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.label = i - Integer.MIN_VALUE;
                } else {
                    poTokenWebView$Companion$getNewPoTokenGenerator$1 = new PoTokenWebView$Companion$getNewPoTokenGenerator$1(this, continuation);
                }
            } else {
                poTokenWebView$Companion$getNewPoTokenGenerator$1 = new PoTokenWebView$Companion$getNewPoTokenGenerator$1(this, continuation);
            }
            Object obj = poTokenWebView$Companion$getNewPoTokenGenerator$1.result;
            int i2 = poTokenWebView$Companion$getNewPoTokenGenerator$1.label;
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i2 == 0) {
                ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
                try {
                    PoTokenWebView$Companion$getNewPoTokenGenerator$2 poTokenWebView$Companion$getNewPoTokenGenerator$2 = new PoTokenWebView$Companion$getNewPoTokenGenerator$2(context, ref$ObjectRefM5m, null);
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$0 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$1 = ref$ObjectRefM5m;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.label = 1;
                    Object objWithTimeout = AwaitKt.withTimeout(PoTokenWebView.INIT_TIMEOUT_MS, poTokenWebView$Companion$getNewPoTokenGenerator$2, poTokenWebView$Companion$getNewPoTokenGenerator$1);
                    return objWithTimeout == obj2 ? obj2 : objWithTimeout;
                } catch (TimeoutCancellationException unused) {
                    ref$ObjectRef = ref$ObjectRefM5m;
                    Timber.Forest.tag("PoTokenWebView");
                    ConnectionPool.e(new Object[0]);
                    PoTokenWebView poTokenWebView2 = (PoTokenWebView) ref$ObjectRef.element;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$0 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$1 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$2 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.label = 2;
                } catch (CancellationException e) {
                    e = e;
                    poTokenWebView = (PoTokenWebView) ref$ObjectRefM5m.element;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$0 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$1 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$2 = e;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.label = 3;
                    if (closeQuietly(poTokenWebView, poTokenWebView$Companion$getNewPoTokenGenerator$1) != obj2) {
                        throw e;
                    }
                }
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        ResultKt.throwOnFailure(obj);
                        throw new PoTokenException("PoTokenWebView init timed out after 45000ms");
                    }
                    if (i2 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    CancellationException cancellationException = (CancellationException) poTokenWebView$Companion$getNewPoTokenGenerator$1.L$2;
                    ResultKt.throwOnFailure(obj);
                    throw cancellationException;
                }
                ref$ObjectRef = (Ref$ObjectRef) poTokenWebView$Companion$getNewPoTokenGenerator$1.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                } catch (TimeoutCancellationException unused2) {
                    Timber.Forest.tag("PoTokenWebView");
                    ConnectionPool.e(new Object[0]);
                    PoTokenWebView poTokenWebView3 = (PoTokenWebView) ref$ObjectRef.element;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$0 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$1 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$2 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.label = 2;
                } catch (CancellationException e2) {
                    ref$ObjectRefM5m = ref$ObjectRef;
                    e = e2;
                    poTokenWebView = (PoTokenWebView) ref$ObjectRefM5m.element;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$0 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$1 = null;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.L$2 = e;
                    poTokenWebView$Companion$getNewPoTokenGenerator$1.label = 3;
                    if (closeQuietly(poTokenWebView, poTokenWebView$Companion$getNewPoTokenGenerator$1) != obj2) {
                        throw e;
                    }
                }
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ PoTokenWebView(Context context, Continuation continuation, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, continuation);
    }
}
