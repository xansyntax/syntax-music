package com.metrolist.music.discord;

import androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2;
import com.materialkolor.ktx.ImageBitmapKt$rememberThemeColor$1$1;
import com.metrolist.innertubex.cipher.EjsChallengeSolver;
import com.metrolist.music.App;
import io.ktor.client.utils.CIOKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;
import okio.Path;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordGateway {
    public volatile int _currentSeq;
    public final SharedFlowImpl _events;
    public volatile String _sessionId;
    public volatile long activeWebSocketId;
    public final String appId;
    public final ReadonlySharedFlow events;
    public final CoroutineScope externalScope;
    public volatile String gatewayUrl;
    public volatile StandaloneCoroutine heartbeatJob;
    public final OkHttpClient httpClient;
    public volatile boolean isOpen;
    public final AtomicLong lastAckAtMs;
    public volatile int reconnectAttempts;
    public final EjsChallengeSolver.AnonymousClass2 tokenProvider;
    public volatile WebSocket webSocket;
    public final AtomicLong webSocketIdCounter;

    /* JADX INFO: renamed from: com.metrolist.music.discord.DiscordGateway$connect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public long J$0;
        public RealWebSocket L$3;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscordGateway.this.connect(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.discord.DiscordGateway$handleClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01411 extends ContinuationImpl {
        public int I$0;
        public long J$0;
        public long J$1;
        public String L$0;
        public ReconnectAction L$1;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C01411(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscordGateway.this.handleClose(0, null, false, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.discord.DiscordGateway$handleFrame$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01421 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01421(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscordGateway.this.handleFrame(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.discord.DiscordGateway$performReconnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01431 extends ContinuationImpl {
        public ReconnectAction L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01431(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscordGateway.this.performReconnect(null, this);
        }
    }

    public DiscordGateway(String str, EjsChallengeSolver.AnonymousClass2 anonymousClass2, CoroutineScope coroutineScope) {
        str.getClass();
        coroutineScope.getClass();
        this.appId = str;
        this.tokenProvider = anonymousClass2;
        this.externalScope = coroutineScope;
        SharedFlowImpl sharedFlowImplMutableSharedFlow = StateFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
        this._events = sharedFlowImplMutableSharedFlow;
        this.events = new ReadonlySharedFlow(sharedFlowImplMutableSharedFlow);
        this.webSocketIdCounter = new AtomicLong(0L);
        this.gatewayUrl = "wss://gateway.discord.gg/?v=10&encoding=json";
        this.lastAckAtMs = new AtomicLong(0L);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15L, TimeUnit.SECONDS);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.readTimeout(0L, timeUnit);
        builder.pingInterval = _UtilJvmKt.checkDuration("interval", 0L, timeUnit);
        this.httpClient = new OkHttpClient(builder);
    }

    public static long applyJitter(long j, double d) {
        if (j > 0) {
            long j2 = (long) (j * d);
            if (j2 > 0) {
                AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
                AbstractPlatformRandom abstractPlatformRandom2 = Random.defaultRandom;
                return ((abstractPlatformRandom2.getImpl().nextBoolean() ? -1L : 1L) * Math.abs(abstractPlatformRandom2.nextLong(j2 + 1))) + j;
            }
        }
        return j;
    }

    public final void close(int i, String str) {
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.i(Integer.valueOf(i), str);
        StandaloneCoroutine standaloneCoroutine = this.heartbeatJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.heartbeatJob = null;
        WebSocket webSocket = this.webSocket;
        this.webSocket = null;
        this.isOpen = false;
        this.activeWebSocketId = this.webSocketIdCounter.incrementAndGet();
        if (webSocket != null) {
            try {
                ((RealWebSocket) webSocket).close(i, str);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object connect(ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        RealWebSocket realWebSocket;
        long j;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final long jIncrementAndGet = this.webSocketIdCounter.incrementAndGet();
            this.activeWebSocketId = jIncrementAndGet;
            final CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
            Request.Builder builder = new Request.Builder();
            builder.url(this.gatewayUrl);
            RealWebSocket realWebSocketNewWebSocket = this.httpClient.newWebSocket(new Request(builder), new WebSocketListener() { // from class: com.metrolist.music.discord.DiscordGateway$createListener$1
                @Override // okhttp3.WebSocketListener
                public final void onClosed(WebSocket webSocket, int i3, String str) {
                    webSocket.getClass();
                    str.getClass();
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.i(Integer.valueOf(i3), str, Long.valueOf(jIncrementAndGet));
                    DiscordGateway discordGateway = this;
                    AwaitKt.launch$default(discordGateway.externalScope, null, null, new ImageBitmapKt$rememberThemeColor$1$1(discordGateway, i3, str, jIncrementAndGet, null), 3);
                }

                @Override // okhttp3.WebSocketListener
                public final void onClosing(WebSocket webSocket, int i3, String str) {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.i(Integer.valueOf(i3), str, Long.valueOf(jIncrementAndGet));
                    try {
                        ((RealWebSocket) webSocket).close(CIOKt.DEFAULT_HTTP_POOL_SIZE, null);
                    } catch (Throwable unused) {
                    }
                }

                @Override // okhttp3.WebSocketListener
                public final void onFailure(WebSocket webSocket, Throwable th, Response response) {
                    if (jIncrementAndGet != this.activeWebSocketId) {
                        return;
                    }
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.e$1(response != null ? Integer.valueOf(response.code) : null, Long.valueOf(jIncrementAndGet));
                    if (!completableDeferredImplCompletableDeferred$default.isCompleted()) {
                        completableDeferredImplCompletableDeferred$default.completeExceptionally(th);
                    }
                    DiscordGateway discordGateway = this;
                    AwaitKt.launch$default(discordGateway.externalScope, null, null, new ScrollableKt$semanticsScrollBy$2(response, th, discordGateway, jIncrementAndGet, null), 3);
                }

                @Override // okhttp3.WebSocketListener
                public final void onMessage(WebSocket webSocket, String str) {
                    if (jIncrementAndGet != this.activeWebSocketId) {
                        return;
                    }
                    DiscordGateway discordGateway = this;
                    AwaitKt.launch$default(discordGateway.externalScope, null, null, new App.C01391(discordGateway, str, null, (byte) 16), 3);
                }

                @Override // okhttp3.WebSocketListener
                public final void onOpen(WebSocket webSocket, Response response) {
                    if (jIncrementAndGet != this.activeWebSocketId) {
                        return;
                    }
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.i(Integer.valueOf(response.code), Long.valueOf(jIncrementAndGet));
                    this.webSocket = webSocket;
                    this.isOpen = true;
                    this.lastAckAtMs.set(System.currentTimeMillis());
                    completableDeferredImplCompletableDeferred$default.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
                }
            });
            this.webSocket = realWebSocketNewWebSocket;
            try {
                anonymousClass1.L$3 = realWebSocketNewWebSocket;
                anonymousClass1.J$0 = jIncrementAndGet;
                anonymousClass1.label = 1;
                if (completableDeferredImplCompletableDeferred$default.awaitInternal(anonymousClass1) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                realWebSocket = realWebSocketNewWebSocket;
                j = jIncrementAndGet;
            } catch (Throwable th) {
                th = th;
                realWebSocket = realWebSocketNewWebSocket;
                j = jIncrementAndGet;
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.e$1(new Long(j));
                realWebSocket.cancel();
                this.webSocket = null;
                throw th;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = anonymousClass1.J$0;
            realWebSocket = anonymousClass1.L$3;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.e$1(new Long(j));
                try {
                    realWebSocket.cancel();
                } catch (Throwable unused) {
                }
                this.webSocket = null;
                throw th;
            }
        }
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.i(new Long(j), this.gatewayUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0111  */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ae, code lost:
    
        if (r0.emit(r2, r8) == r9) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ed, code lost:
    
        if (r0.emit(r2, r8) == r9) goto L41;
     */
    /* JADX WARN: Type inference failed for: r2v25, types: [com.metrolist.music.discord.ReconnectAction, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleClose(int i, String str, boolean z, long j, ContinuationImpl continuationImpl) {
        C01411 c01411;
        ReconnectAction resume;
        long jApplyJitter;
        ?? r2;
        Object obj;
        boolean z2;
        long j2;
        ReconnectAction reconnectAction;
        long j3;
        long jDoubleValue;
        int i2 = i;
        String str2 = str;
        boolean z3 = z;
        long j4 = j;
        Unit unit = Unit.INSTANCE;
        if (continuationImpl instanceof C01411) {
            c01411 = (C01411) continuationImpl;
            int i3 = c01411.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c01411.label = i3 - Integer.MIN_VALUE;
            } else {
                c01411 = new C01411(continuationImpl);
            }
        } else {
            c01411 = new C01411(continuationImpl);
        }
        Object obj2 = c01411.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i4 = c01411.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj2);
            if (j4 != this.activeWebSocketId) {
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.i(new Long(j4), new Long(this.activeWebSocketId), new Integer(i2));
                return unit;
            }
            if (this.isOpen || this.webSocket != null) {
                this.isOpen = false;
                StandaloneCoroutine standaloneCoroutine = this.heartbeatJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                this.heartbeatJob = null;
                this.webSocket = null;
                SharedFlowImpl sharedFlowImpl = this._events;
                GatewayEvent.Disconnected disconnected = new GatewayEvent.Disconnected(str2, i2, z3);
                c01411.L$0 = str2;
                c01411.I$0 = i2;
                c01411.Z$0 = z3;
                c01411.J$0 = j4;
                c01411.label = 1;
                if (sharedFlowImpl.emit(disconnected, c01411) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            return unit;
        }
        if (i4 == 1) {
            long j5 = c01411.J$0;
            z3 = c01411.Z$0;
            int i5 = c01411.I$0;
            String str3 = c01411.L$0;
            ResultKt.throwOnFailure(obj2);
            i2 = i5;
            str2 = str3;
            j4 = j5;
        } else {
            if (i4 == 2) {
                ResultKt.throwOnFailure(obj2);
                return unit;
            }
            if (i4 == 3) {
                ResultKt.throwOnFailure(obj2);
                return unit;
            }
            if (i4 != 4) {
                if (i4 == 5) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            long j6 = c01411.J$1;
            j2 = c01411.J$0;
            z2 = c01411.Z$0;
            int i6 = c01411.I$0;
            reconnectAction = c01411.L$1;
            ResultKt.throwOnFailure(obj2);
            obj = coroutineSingletons;
            i2 = i6;
            jApplyJitter = j6;
            r2 = 0;
        }
        c01411.L$0 = r2;
        c01411.L$1 = r2;
        c01411.I$0 = i2;
        c01411.Z$0 = z2;
        c01411.J$0 = j2;
        c01411.J$1 = jApplyJitter;
        c01411.label = 5;
        if (performReconnect(reconnectAction, c01411) == obj) {
            return obj;
        }
        return unit;
        if (i2 == 1000 && z3) {
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.d(new Object[0]);
            this._sessionId = null;
            this._currentSeq = 0;
            return unit;
        }
        boolean z4 = this._sessionId != null;
        int i7 = this._currentSeq;
        String str4 = this._sessionId;
        ReconnectAction reconnectAction2 = ReconnectAction.ReIdentify.INSTANCE;
        if (i2 != 4000) {
            if (i2 == 4001 || i2 == 4007 || i2 == 4009) {
                resume = reconnectAction2;
            } else if (i2 == 4014) {
                resume = ReconnectAction.SurfaceFatal.INSTANCE;
            } else if (i2 != 4004) {
                resume = reconnectAction2;
            } else {
                resume = ReconnectAction.RefreshAndReIdentify.INSTANCE;
            }
        } else if (!z4 || str4 == null || i7 <= 0) {
            resume = reconnectAction2;
        } else {
            resume = new ReconnectAction.Resume(str4, i7);
        }
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("DiscordSvc");
        ConnectionPool.d(Integer.valueOf(i2), Boolean.valueOf(z4), Integer.valueOf(i7), Reflection.getOrCreateKotlinClass(resume.getClass()).getSimpleName());
        connectionPool.tag("DiscordSvc");
        ConnectionPool.i(Reflection.getOrCreateKotlinClass(resume.getClass()).getSimpleName(), new Integer(i2));
        if (resume instanceof ReconnectAction.SurfaceFatal) {
            connectionPool.tag("DiscordSvc");
            ConnectionPool.w(new Integer(i2));
            this._sessionId = null;
            this._currentSeq = 0;
            return unit;
        }
        if (!(resume instanceof ReconnectAction.RefreshAndReIdentify)) {
            if (!(resume instanceof ReconnectAction.Resume) && !(resume instanceof ReconnectAction.ReIdentify)) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            if (this.reconnectAttempts >= 7) {
                connectionPool.tag("DiscordSvc");
                ConnectionPool.w(new Integer(7));
                SharedFlowImpl sharedFlowImpl2 = this._events;
                GatewayEvent.Disconnected disconnected2 = new GatewayEvent.Disconnected("max reconnect attempts", 4000, false);
                c01411.L$0 = null;
                c01411.L$1 = null;
                c01411.I$0 = i2;
                c01411.Z$0 = z3;
                c01411.J$0 = j4;
                c01411.label = 3;
            } else {
                this.reconnectAttempts++;
                if (i2 == 429) {
                    int iIndexOf$default = StringsKt.indexOf$default(str2, ";retry_after=", 0, false, 6);
                    if (iIndexOf$default < 0) {
                        j3 = 60000;
                        jDoubleValue = 60000;
                    } else {
                        Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(StringsKt.substringBefore$default(StringsKt.substringBefore$default(StringsKt.trim(str2.substring(iIndexOf$default + 13)).toString(), ';'), ','));
                        if (doubleOrNull != null) {
                            j3 = 60000;
                            jDoubleValue = (long) (doubleOrNull.doubleValue() * 1000.0d);
                            if (jDoubleValue < 60000) {
                            }
                        } else {
                            j3 = 60000;
                        }
                        jDoubleValue = j3;
                    }
                    if (jDoubleValue < j3) {
                        jDoubleValue = j3;
                    }
                    jApplyJitter = jDoubleValue;
                } else {
                    long j7 = (1 << (this.reconnectAttempts - 1)) * 1000;
                    if (j7 > 64000) {
                        j7 = 64000;
                    }
                    jApplyJitter = applyJitter(j7, 0.25d);
                }
                connectionPool.tag("DiscordSvc");
                ConnectionPool.i(new Long(jApplyJitter), new Integer(this.reconnectAttempts), new Integer(i2));
                r2 = 0;
                c01411.L$0 = null;
                c01411.L$1 = resume;
                c01411.I$0 = i2;
                c01411.Z$0 = z3;
                c01411.J$0 = j4;
                c01411.J$1 = jApplyJitter;
                c01411.label = 4;
                obj = coroutineSingletons;
                if (AwaitKt.delay(jApplyJitter, c01411) == obj) {
                    return obj;
                }
                z2 = z3;
                j2 = j4;
                reconnectAction = resume;
                c01411.L$0 = r2;
                c01411.L$1 = r2;
                c01411.I$0 = i2;
                c01411.Z$0 = z2;
                c01411.J$0 = j2;
                c01411.J$1 = jApplyJitter;
                c01411.label = 5;
                if (performReconnect(reconnectAction, c01411) == obj) {
                    return obj;
                }
            }
            return unit;
        }
        connectionPool.tag("DiscordSvc");
        ConnectionPool.w(new Integer(i2));
        SharedFlowImpl sharedFlowImpl3 = this._events;
        GatewayEvent.RefreshToken refreshToken = GatewayEvent.RefreshToken.INSTANCE;
        c01411.L$0 = null;
        c01411.L$1 = null;
        c01411.I$0 = i2;
        c01411.Z$0 = z3;
        c01411.J$0 = j4;
        c01411.label = 2;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x0274 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:127:0x0275 A[PHI: r16
      0x0275: PHI (r16v2 kotlin.Unit) = 
      (r16v1 kotlin.Unit)
      (r16v1 kotlin.Unit)
      (r16v1 kotlin.Unit)
      (r16v1 kotlin.Unit)
      (r16v1 kotlin.Unit)
      (r16v1 kotlin.Unit)
      (r16v1 kotlin.Unit)
      (r16v3 kotlin.Unit)
     binds: [B:125:0x0272, B:119:0x025a, B:106:0x0224, B:85:0x01b0, B:65:0x0157, B:56:0x00f2, B:53:0x00d0, B:81:0x0197] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0191, code lost:
    
        if (r2.emit(r3, r4) == r5) goto L126;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleFrame(String str, ContinuationImpl continuationImpl) throws JSONException {
        C01421 c01421;
        Unit unit;
        int iOptInt;
        Unit unit2 = Unit.INSTANCE;
        if (continuationImpl instanceof C01421) {
            c01421 = (C01421) continuationImpl;
            int i = c01421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01421.label = i - Integer.MIN_VALUE;
            } else {
                c01421 = new C01421(continuationImpl);
            }
        } else {
            c01421 = new C01421(continuationImpl);
        }
        Object obj = c01421.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (c01421.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int iOptInt2 = jSONObject.optInt("op", -1);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("d");
                    String strOptString = jSONObject.has("t") ? jSONObject.optString("t") : null;
                    ConnectionPool connectionPool = Timber.Forest;
                    connectionPool.tag("DiscordSvc");
                    unit = unit2;
                    ConnectionPool.v(new Integer(iOptInt2), strOptString == null ? "" : strOptString, new Integer(jSONObject.optInt("s", 0)));
                    if (jSONObject.has("s") && !jSONObject.isNull("s") && (iOptInt = jSONObject.optInt("s", 0)) > 0) {
                        this._currentSeq = iOptInt;
                    }
                    if (iOptInt2 == 0) {
                        if (!Intrinsics.areEqual(strOptString, "READY")) {
                            if (!Intrinsics.areEqual(strOptString, "RESUMED")) {
                                SharedFlowImpl sharedFlowImpl = this._events;
                                if (jSONObjectOptJSONObject == null) {
                                    jSONObjectOptJSONObject = new JSONObject();
                                }
                                GatewayEvent.TextDispatch textDispatch = new GatewayEvent.TextDispatch(iOptInt2, strOptString, jSONObjectOptJSONObject);
                                c01421.label = 5;
                                if (sharedFlowImpl.emit(textDispatch, c01421) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                return unit;
                            }
                            this.reconnectAttempts = 0;
                            connectionPool.tag("DiscordSvc");
                            String str2 = this._sessionId;
                            ConnectionPool.d(str2 != null ? StringsKt.take(8, str2) : null);
                            SharedFlowImpl sharedFlowImpl2 = this._events;
                            String str3 = this._sessionId;
                            GatewayEvent.Resumed resumed = new GatewayEvent.Resumed(str3 != null ? str3 : "");
                            c01421.label = 4;
                            if (sharedFlowImpl2.emit(resumed, c01421) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            return unit;
                        }
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject();
                        }
                        String strOptString2 = jSONObjectOptJSONObject.optString("session_id", "");
                        String strOptString3 = jSONObjectOptJSONObject.optString("resume_gateway_url", "");
                        strOptString3.getClass();
                        if (strOptString3.length() <= 0) {
                            strOptString3 = null;
                        }
                        this._sessionId = strOptString2;
                        connectionPool.tag("DiscordSvc");
                        strOptString2.getClass();
                        ConnectionPool.d(StringsKt.take(8, strOptString2), strOptString3 != null ? StringsKt.take(60, strOptString3) : null);
                        if (strOptString3 != null) {
                            this.gatewayUrl = strOptString3;
                            connectionPool.tag("DiscordSvc");
                            ConnectionPool.i(strOptString3);
                        }
                        this.reconnectAttempts = 0;
                        SharedFlowImpl sharedFlowImpl3 = this._events;
                        GatewayEvent.Ready ready = new GatewayEvent.Ready(strOptString2, strOptString3);
                        c01421.label = 3;
                        if (sharedFlowImpl3.emit(ready, c01421) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        return unit;
                    }
                    if (iOptInt2 == 1) {
                        heartbeat(this._currentSeq);
                        return unit;
                    }
                    if (iOptInt2 != 7) {
                        switch (iOptInt2) {
                            case 9:
                                Object objOpt = jSONObject.opt("d");
                                Boolean bool = objOpt instanceof Boolean ? (Boolean) objOpt : null;
                                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                                connectionPool.tag("DiscordSvc");
                                ConnectionPool.w(Boolean.valueOf(zBooleanValue));
                                if (!zBooleanValue) {
                                    this._sessionId = null;
                                }
                                SharedFlowImpl sharedFlowImpl4 = this._events;
                                GatewayEvent.InvalidSession invalidSession = new GatewayEvent.InvalidSession(zBooleanValue);
                                c01421.label = 6;
                                break;
                            case 10:
                                long jOptLong = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optLong("heartbeat_interval", 41250L) : 41250L;
                                connectionPool.tag("DiscordSvc");
                                ConnectionPool.d(new Long(jOptLong));
                                StandaloneCoroutine standaloneCoroutine = this.heartbeatJob;
                                if (standaloneCoroutine != null) {
                                    standaloneCoroutine.cancel(null);
                                }
                                long jApplyJitter = applyJitter(jOptLong, 0.05d);
                                connectionPool.tag("DiscordSvc");
                                ConnectionPool.i(Long.valueOf(jOptLong), Long.valueOf(jApplyJitter));
                                this.lastAckAtMs.set(System.currentTimeMillis());
                                this.heartbeatJob = AwaitKt.launch$default(this.externalScope, null, null, new DiscordGateway$startHeartbeat$1(this, jApplyJitter, null), 3);
                                SharedFlowImpl sharedFlowImpl5 = this._events;
                                GatewayEvent.Hello hello = new GatewayEvent.Hello(jOptLong);
                                c01421.label = 1;
                                if (sharedFlowImpl5.emit(hello, c01421) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                break;
                            case 11:
                                this.lastAckAtMs.set(System.currentTimeMillis());
                                SharedFlowImpl sharedFlowImpl6 = this._events;
                                GatewayEvent.HeartbeatAck heartbeatAck = new GatewayEvent.HeartbeatAck(new Integer(this._currentSeq));
                                c01421.label = 2;
                                if (sharedFlowImpl6.emit(heartbeatAck, c01421) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                break;
                            default:
                                SharedFlowImpl sharedFlowImpl7 = this._events;
                                if (jSONObjectOptJSONObject == null) {
                                    jSONObjectOptJSONObject = new JSONObject();
                                }
                                GatewayEvent.TextDispatch textDispatch2 = new GatewayEvent.TextDispatch(iOptInt2, strOptString, jSONObjectOptJSONObject);
                                c01421.label = 7;
                                if (sharedFlowImpl7.emit(textDispatch2, c01421) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                break;
                        }
                    } else {
                        connectionPool.tag("DiscordSvc");
                        ConnectionPool.w(new Object[0]);
                        WebSocket webSocket = this.webSocket;
                        if (webSocket != null) {
                            ((RealWebSocket) webSocket).close(4000, "reconnect requested");
                            return unit;
                        }
                    }
                    return unit;
                } catch (Throwable unused) {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.e$1(new Object[0]);
                    return unit2;
                }
            case 1:
                ResultKt.throwOnFailure(obj);
                return unit2;
            case 2:
                ResultKt.throwOnFailure(obj);
                return unit2;
            case 3:
                ResultKt.throwOnFailure(obj);
                return unit2;
            case 4:
                ResultKt.throwOnFailure(obj);
                return unit2;
            case 5:
                ResultKt.throwOnFailure(obj);
                return unit2;
            case 6:
                ResultKt.throwOnFailure(obj);
                unit = unit2;
                WebSocket webSocket2 = this.webSocket;
                if (webSocket2 != null) {
                    ((RealWebSocket) webSocket2).close(4000, "invalid session");
                    return unit;
                }
                return unit;
            case 7:
                ResultKt.throwOnFailure(obj);
                return unit2;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    public final void heartbeat(int i) throws JSONException {
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.d(Integer.valueOf(i));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("op", 1);
        if (i > 0) {
            jSONObject.put("d", i);
        } else {
            jSONObject.put("d", JSONObject.NULL);
        }
        String string = jSONObject.toString();
        string.getClass();
        send(string);
    }

    public final void identify(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", str);
        jSONObject.put("intents", 0);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("os", "android");
        jSONObject2.put("browser", "Discord Android");
        jSONObject2.put("device", this.appId);
        jSONObject.put("properties", jSONObject2);
        jSONObject.put("compress", false);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("op", 2);
        jSONObject3.put("d", jSONObject);
        String string = jSONObject3.toString();
        string.getClass();
        send(string);
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.i(new Integer(str.length()));
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x00de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dc, code lost:
    
        if ((r14 instanceof com.metrolist.music.discord.ReconnectAction.RefreshAndReIdentify) != false) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performReconnect(ReconnectAction reconnectAction, ContinuationImpl continuationImpl) {
        C01431 c01431;
        Object obj = Unit.INSTANCE;
        if (continuationImpl instanceof C01431) {
            c01431 = (C01431) continuationImpl;
            int i = c01431.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01431.label = i - Integer.MIN_VALUE;
            } else {
                c01431 = new C01431(continuationImpl);
            }
        } else {
            c01431 = new C01431(continuationImpl);
        }
        Object objInvoke = c01431.result;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c01431.label;
        try {
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(objInvoke);
                        c01431.L$0 = reconnectAction;
                        c01431.label = 1;
                        if (connect(c01431) != obj2) {
                        }
                        return obj2;
                    }
                    if (i2 != 1) {
                        if (i2 == 2) {
                            reconnectAction = c01431.L$0;
                            ResultKt.throwOnFailure(objInvoke);
                            String str = ((ReconnectAction.Resume) reconnectAction).sessionId;
                            int i3 = ((ReconnectAction.Resume) reconnectAction).seq;
                            c01431.L$0 = null;
                            c01431.label = 3;
                            resume(i3, str, (String) objInvoke);
                            if (obj != obj2) {
                                return obj2;
                            }
                            return obj;
                        }
                        if (i2 == 3) {
                            ResultKt.throwOnFailure(objInvoke);
                            return obj;
                        }
                        if (i2 != 4) {
                            if (i2 == 5) {
                                ResultKt.throwOnFailure(objInvoke);
                                return obj;
                            }
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(objInvoke);
                        c01431.L$0 = null;
                        c01431.label = 5;
                        identify((String) objInvoke);
                        if (obj == obj2) {
                            return obj2;
                        }
                        return obj;
                    }
                    reconnectAction = c01431.L$0;
                    ResultKt.throwOnFailure(objInvoke);
                    if (reconnectAction != null) {
                        if (!(reconnectAction instanceof ReconnectAction.Resume)) {
                            if (reconnectAction instanceof ReconnectAction.ReIdentify) {
                                EjsChallengeSolver.AnonymousClass2 anonymousClass2 = this.tokenProvider;
                                c01431.L$0 = null;
                                c01431.label = 4;
                                objInvoke = anonymousClass2.invoke(c01431);
                                if (objInvoke != obj2) {
                                    c01431.L$0 = null;
                                    c01431.label = 5;
                                    identify((String) objInvoke);
                                    if (obj == obj2) {
                                    }
                                }
                            } else if (!(reconnectAction instanceof ReconnectAction.SurfaceFatal)) {
                            }
                            return obj;
                        }
                        EjsChallengeSolver.AnonymousClass2 anonymousClass3 = this.tokenProvider;
                        c01431.L$0 = reconnectAction;
                        c01431.label = 2;
                        objInvoke = anonymousClass3.invoke(c01431);
                        if (objInvoke != obj2) {
                            String str2 = ((ReconnectAction.Resume) reconnectAction).sessionId;
                            int i4 = ((ReconnectAction.Resume) reconnectAction).seq;
                            c01431.L$0 = null;
                            c01431.label = 3;
                            resume(i4, str2, (String) objInvoke);
                            if (obj != obj2) {
                                return obj;
                            }
                        }
                        return obj2;
                    }
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                } catch (Throwable unused) {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.e$1(new Object[0]);
                    return obj;
                }
            } catch (Throwable unused2) {
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.e$1(new Object[0]);
                WebSocket webSocket = this.webSocket;
                if (webSocket != null) {
                    ((RealWebSocket) webSocket).close(1011, "resume failed");
                }
            }
        } catch (Throwable unused3) {
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.e$1(new Object[0]);
            WebSocket webSocket2 = this.webSocket;
            if (webSocket2 != null) {
                ((RealWebSocket) webSocket2).close(1011, "identify failed");
            }
        }
    }

    public final void resume(int i, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", str2);
        jSONObject.put("session_id", str);
        jSONObject.put("seq", i);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("op", 6);
        jSONObject2.put("d", jSONObject);
        String string = jSONObject2.toString();
        string.getClass();
        send(string);
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.i(StringsKt.take(8, str), new Integer(i));
    }

    public final void send(String str) {
        WebSocket webSocket = this.webSocket;
        if (webSocket == null || !this.isOpen) {
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.w(webSocket, Boolean.valueOf(this.isOpen));
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("DiscordGateway: WebSocket is not open");
            return;
        }
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("DiscordSvc");
        ConnectionPool.v(Integer.valueOf(str.length()));
        ByteString byteString = ByteString.EMPTY;
        if (((RealWebSocket) webSocket).send(1, Path.Companion.encodeUtf8(str))) {
            return;
        }
        connectionPool.tag("DiscordSvc");
        ConnectionPool.w(new Object[0]);
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("DiscordGateway: WebSocket send returned false (queue full or closing)");
    }
}
