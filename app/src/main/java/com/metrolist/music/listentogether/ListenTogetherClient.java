package com.metrolist.music.listentogether;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;
import android.widget.Toast;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.app.NavUtils;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.google.protobuf.GeneratedMessageLite;
import com.metrolist.music.App$observeSettingsChanges$1$2$2$1;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.Updater$getAllReleases$2;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.client.utils.CIOKt;
import io.ktor.http.HttpHeaders;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http1.HeadersReader;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherClient {
    public static final String DEFAULT_SERVER_URL = ((ListenTogetherServer) CollectionsKt.first((List) ListenTogetherServers.servers$delegate.getValue())).url;
    public static volatile ListenTogetherClient instance;
    public final StateFlowImpl _blockedUsernames;
    public final StateFlowImpl _bufferingUsers;
    public final StateFlowImpl _connectionState;
    public final SharedFlowImpl _events;
    public final StateFlowImpl _logs;
    public final StateFlowImpl _pendingJoinRequests;
    public final StateFlowImpl _pendingSuggestions;
    public final StateFlowImpl _role;
    public final StateFlowImpl _roomState;
    public final StateFlowImpl _userId;
    public StandaloneCoroutine backgroundDisconnectJob;
    public final ReadonlyStateFlow blockedUsernames;
    public final OkHttpClient client;
    public final MessageCodec codec;
    public final ReadonlyStateFlow connectionState;
    public final SynchronizedLazyImpl connectivityObserver$delegate;
    public final Context context;
    public final BufferedChannel eventQueue;
    public final ReadonlySharedFlow events;
    public boolean isNetworkAvailable;
    public final LinkedHashMap joinRequestNotifications;
    public final JsonImpl json;
    public final AtomicLong lastPlaybackRevision;
    public final ReadonlyStateFlow logs;
    public CharsKt pendingAction;
    public final ReadonlyStateFlow pendingJoinRequests;
    public final ReadonlyStateFlow pendingSuggestions;
    public StandaloneCoroutine pingJob;
    public final AtomicLong pingSequence;
    public int reconnectAttempts;
    public final ReadonlyStateFlow role;
    public final ReadonlyStateFlow roomState;
    public final ContextScope scope;
    public final HeadersReader serverClock;
    public final AtomicInteger sessionApplyGeneration;
    public String sessionToken;
    public String storedRoomCode;
    public String storedUsername;
    public final LinkedHashMap suggestionNotifications;
    public final ReadonlyStateFlow userId;
    public PowerManager.WakeLock wakeLock;
    public boolean wasHost;
    public RealWebSocket webSocket;

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherClient$handleConnectionFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01481 extends SuspendLambda implements Function2 {
        public final /* synthetic */ long $delayMs;
        public final /* synthetic */ long $delaySeconds;
        public boolean label;
        public final /* synthetic */ ListenTogetherClient this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01481(long j, ListenTogetherClient listenTogetherClient, long j2, Continuation continuation) {
            super(2, continuation);
            this.$delayMs = j;
            this.this$0 = listenTogetherClient;
            this.$delaySeconds = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C01481(this.$delayMs, this.this$0, this.$delaySeconds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01481) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ListenTogetherClient listenTogetherClient = this.this$0;
            StateFlowImpl stateFlowImpl = listenTogetherClient._connectionState;
            boolean z = this.label;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                this.label = true;
                Object objDelay = AwaitKt.delay(this.$delayMs, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDelay == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            if (stateFlowImpl.getValue() == ConnectionState.RECONNECTING || stateFlowImpl.getValue() == ConnectionState.DISCONNECTED) {
                listenTogetherClient.log(LogLevel.INFO, "Reconnecting after backoff", IntIntPair$$ExternalSyntheticOutline0.m(this.$delaySeconds, "Delay was ", "s"));
                listenTogetherClient.connect();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherClient$handleMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01491 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Listentogether.RoomCreatedPayload $payload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01491(Listentogether.RoomCreatedPayload roomCreatedPayload, Continuation continuation) {
            super(2, continuation);
            this.$payload = roomCreatedPayload;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ListenTogetherClient.this.new C01491(this.$payload, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            C01491 c01491 = (C01491) create((CoroutineScope) obj, (Continuation) obj2);
            Unit unit = Unit.INSTANCE;
            c01491.invokeSuspend(unit);
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ResultKt.throwOnFailure(obj);
            Context context = ListenTogetherClient.this.context;
            Toast.makeText(context, context.getString(R.string.listen_together_room_created, this.$payload.getRoomCode()), 1).show();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherClient$saveBlockedUsernames$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01501 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01501(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ListenTogetherClient.this.saveBlockedUsernames(this);
        }
    }

    public ListenTogetherClient(Context context) {
        this.context = context;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.scope = AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE.plus(AwaitKt.SupervisorJob$default()));
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(ConnectionState.DISCONNECTED);
        this._connectionState = stateFlowImplMutableStateFlow;
        this.connectionState = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        Continuation continuation = null;
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._roomState = stateFlowImplMutableStateFlow2;
        this.roomState = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = StateFlowKt.MutableStateFlow(RoomRole.NONE);
        this._role = stateFlowImplMutableStateFlow3;
        this.role = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        StateFlowImpl stateFlowImplMutableStateFlow4 = StateFlowKt.MutableStateFlow(null);
        this._userId = stateFlowImplMutableStateFlow4;
        this.userId = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow4);
        EmptyList emptyList = EmptyList.INSTANCE;
        StateFlowImpl stateFlowImplMutableStateFlow5 = StateFlowKt.MutableStateFlow(emptyList);
        this._pendingJoinRequests = stateFlowImplMutableStateFlow5;
        this.pendingJoinRequests = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow5);
        StateFlowImpl stateFlowImplMutableStateFlow6 = StateFlowKt.MutableStateFlow(emptyList);
        this._bufferingUsers = stateFlowImplMutableStateFlow6;
        StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow6);
        StateFlowImpl stateFlowImplMutableStateFlow7 = StateFlowKt.MutableStateFlow(emptyList);
        this._pendingSuggestions = stateFlowImplMutableStateFlow7;
        this.pendingSuggestions = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow7);
        StateFlowImpl stateFlowImplMutableStateFlow8 = StateFlowKt.MutableStateFlow(EmptySet.INSTANCE);
        this._blockedUsernames = stateFlowImplMutableStateFlow8;
        this.blockedUsernames = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow8);
        StateFlowImpl stateFlowImplMutableStateFlow9 = StateFlowKt.MutableStateFlow(emptyList);
        this._logs = stateFlowImplMutableStateFlow9;
        this.logs = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow9);
        SharedFlowImpl sharedFlowImplMutableSharedFlow$default = StateFlowKt.MutableSharedFlow$default(0, 7, null);
        this._events = sharedFlowImplMutableSharedFlow$default;
        this.events = new ReadonlySharedFlow(sharedFlowImplMutableSharedFlow$default);
        byte b = 6;
        this.eventQueue = EntryPoints.Channel$default(Integer.MAX_VALUE, 6, null);
        this.json = UuidKt.Json$default(new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 13));
        this.sessionApplyGeneration = new AtomicInteger(0);
        instance = this;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if ((notificationManager != null ? notificationManager.getNotificationChannel("listen_together_channel") : null) == null) {
                NotificationChannel notificationChannel = new NotificationChannel("listen_together_channel", context.getString(R.string.listen_together_notification_channel_name), 4);
                notificationChannel.setDescription(context.getString(R.string.listen_together_notification_channel_desc));
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
        } catch (Exception e) {
            log(LogLevel.WARNING, "Failed to create notification channel", e.getMessage());
        }
        ProcessLifecycleOwner.newInstance.registry.addObserver(new DefaultLifecycleObserver() { // from class: com.metrolist.music.listentogether.ListenTogetherClient$observeAppLifecycle$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStart(LifecycleOwner lifecycleOwner) {
                this.this$0.evaluateBackgroundDisconnectPolicy("app_foreground");
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStop(LifecycleOwner lifecycleOwner) {
                this.this$0.evaluateBackgroundDisconnectPolicy("app_background");
            }
        });
        AwaitKt.launch$default(this.scope, null, null, new SimpleActor$offer$2(this, continuation, (byte) 11), 3);
        AwaitKt.launch$default(this.scope, null, null, new SyncUtils.AnonymousClass3(this, continuation, (byte) 10), 3);
        this.codec = new MessageCodec();
        ListenTogetherClient$serverClock$1 listenTogetherClient$serverClock$1 = ListenTogetherClient$serverClock$1.INSTANCE;
        HeadersReader headersReader = new HeadersReader();
        headersReader.headerLimit = Long.MAX_VALUE;
        this.serverClock = headersReader;
        this.pingSequence = new AtomicLong(0L);
        this.lastPlaybackRevision = new AtomicLong(0L);
        this.joinRequestNotifications = new LinkedHashMap();
        this.suggestionNotifications = new LinkedHashMap();
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(new ImageLoader$Builder$$ExternalSyntheticLambda1(b, this));
        this.connectivityObserver$delegate = synchronizedLazyImpl;
        boolean zIsCurrentlyConnected = true;
        try {
            NetworkConnectivityObserver networkConnectivityObserver = (NetworkConnectivityObserver) synchronizedLazyImpl.getValue();
            if (networkConnectivityObserver != null) {
                zIsCurrentlyConnected = networkConnectivityObserver.isCurrentlyConnected();
            }
        } catch (Exception unused) {
        }
        this.isNetworkAvailable = zIsCurrentlyConnected;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(30L, timeUnit);
        builder.readTimeout(60L, timeUnit);
        builder.writeTimeout(30L, timeUnit);
        builder.pingInterval = _UtilJvmKt.checkDuration("interval", 60L, timeUnit);
        this.client = new OkHttpClient(builder);
    }

    public static void sendPlaybackAction$default(ListenTogetherClient listenTogetherClient, String str, String str2, Long l, Listentogether.TrackInfo trackInfo, List list, String str3, Float f, int i) {
        String str4 = (i & 2) != 0 ? null : str2;
        Long l2 = (i & 4) != 0 ? null : l;
        Listentogether.TrackInfo trackInfo2 = (i & 8) != 0 ? null : trackInfo;
        List list2 = (i & 32) != 0 ? null : list;
        String str5 = (i & 64) != 0 ? null : str3;
        Float f2 = (i & 128) != 0 ? null : f;
        listenTogetherClient.getClass();
        if (listenTogetherClient._role.getValue() != RoomRole.HOST) {
            listenTogetherClient.log(LogLevel.ERROR, "Cannot control playback", "Not host");
            return;
        }
        listenTogetherClient.sendMessage("playback_action", ProtocolKt.PlaybackActionPayload$default(str, str4, l2, trackInfo2, list2, str5, f2, null, 0L, (l2 == null || !(str.equals("play") || str.equals("pause") || str.equals("seek"))) ? null : listenTogetherClient.serverClock.now(), 768));
    }

    public final boolean acceptPlaybackRevision(long j) {
        AtomicLong atomicLong;
        long j2;
        if (j <= 0) {
            return true;
        }
        do {
            atomicLong = this.lastPlaybackRevision;
            j2 = atomicLong.get();
            if (j >= j2) {
                if (j == j2) {
                    break;
                }
            } else {
                return false;
            }
        } while (!atomicLong.compareAndSet(j2, j));
        return true;
    }

    public final void acquireWakeLock() {
        PowerManager.WakeLock wakeLock;
        PowerManager.WakeLock wakeLockNewWakeLock = this.wakeLock;
        if (wakeLockNewWakeLock == null) {
            PowerManager powerManager = (PowerManager) this.context.getSystemService(PowerManager.class);
            wakeLockNewWakeLock = powerManager != null ? powerManager.newWakeLock(1, "Metrolist:ListenTogether") : null;
            this.wakeLock = wakeLockNewWakeLock;
        }
        if (wakeLockNewWakeLock != null && wakeLockNewWakeLock.isHeld() && (wakeLock = this.wakeLock) != null) {
            wakeLock.release();
        }
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.acquire(600000L);
        }
        log(LogLevel.DEBUG, "Wake lock acquired", null);
    }

    public final void approveJoin(String str) {
        if (this._role.getValue() != RoomRole.HOST) {
            log(LogLevel.ERROR, "Cannot approve join", "Not host");
            return;
        }
        GeneratedMessageLite generatedMessageLiteBuild = Listentogether.ApproveJoinPayload.newBuilder().setUserId(str).m915build();
        generatedMessageLiteBuild.getClass();
        sendMessage("approve_join", (Listentogether.ApproveJoinPayload) generatedMessageLiteBuild);
        Integer num = (Integer) this.joinRequestNotifications.remove(str);
        if (num != null) {
            new NotificationManagerCompat(this.context).cancel(num.intValue());
        }
    }

    public final void approveSuggestion(String str) {
        if (this._role.getValue() != RoomRole.HOST) {
            log(LogLevel.ERROR, "Cannot approve suggestion", "Not host");
            return;
        }
        GeneratedMessageLite generatedMessageLiteBuild = Listentogether.ApproveSuggestionPayload.newBuilder().setSuggestionId(str).m915build();
        generatedMessageLiteBuild.getClass();
        sendMessage("approve_suggestion", (Listentogether.ApproveSuggestionPayload) generatedMessageLiteBuild);
        StateFlowImpl stateFlowImpl = this._pendingSuggestions;
        Iterable iterable = (Iterable) stateFlowImpl.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!Intrinsics.areEqual(((Listentogether.SuggestionReceivedPayload) obj).getSuggestionId(), str)) {
                arrayList.add(obj);
            }
        }
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, arrayList);
        Integer num = (Integer) this.suggestionNotifications.remove(str);
        if (num != null) {
            new NotificationManagerCompat(this.context).cancel(num.intValue());
        }
    }

    public final void clearPersistedSession() {
        try {
            AwaitKt.launch$default(this.scope, null, null, new ListenTogetherClient$blockUser$3(this, null, (byte) 1), 3);
        } catch (Exception e) {
            log(LogLevel.ERROR, "Failed to clear persisted session", e.getMessage());
        }
    }

    public final void connect() {
        StateFlowImpl stateFlowImpl = this._connectionState;
        if (stateFlowImpl.getValue() != ConnectionState.CONNECTED) {
            Object value = stateFlowImpl.getValue();
            ConnectionState connectionState = ConnectionState.CONNECTING;
            if (value != connectionState) {
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, connectionState);
                this.serverClock.reset();
                evaluateBackgroundDisconnectPolicy("connect");
                Context context = this.context;
                DataStore dataStore = UtilsKt.getDataStore(context);
                Preferences$Key preferences$Key = PreferenceKeysKt.ListenTogetherServerUrlKey;
                String str = DEFAULT_SERVER_URL;
                String string = StringsKt.trim((String) UtilsKt.get(dataStore, preferences$Key, str)).toString();
                if (string.length() == 0 || StringsKt.contains(string, "metroserver.meowery.eu", true)) {
                    string = str;
                }
                log(LogLevel.INFO, "Connecting to server", string);
                Request.Builder builder = new Request.Builder();
                String string2 = StringsKt.trim((String) UtilsKt.get(UtilsKt.getDataStore(context), preferences$Key, str)).toString();
                if (string2.length() != 0 && !StringsKt.contains(string2, "metroserver.meowery.eu", true)) {
                    str = string2;
                }
                builder.url(str);
                builder.header(HttpHeaders.UserAgent, "com.metrolist.music");
                this.webSocket = this.client.newWebSocket(new Request(builder), new WebSocketListener() { // from class: com.metrolist.music.listentogether.ListenTogetherClient.connect.1
                    @Override // okhttp3.WebSocketListener
                    public final void onClosed(WebSocket webSocket, int i, String str2) {
                        webSocket.getClass();
                        str2.getClass();
                        String str3 = "Code: " + i + ", Reason: " + str2;
                        ListenTogetherClient listenTogetherClient = ListenTogetherClient.this;
                        LogLevel logLevel = LogLevel.INFO;
                        listenTogetherClient.log(logLevel, "Connection closed", str3);
                        StandaloneCoroutine standaloneCoroutine = listenTogetherClient.pingJob;
                        if (standaloneCoroutine != null) {
                            standaloneCoroutine.cancel(null);
                        }
                        listenTogetherClient.pingJob = null;
                        listenTogetherClient.serverClock.reset();
                        StateFlowImpl stateFlowImpl2 = listenTogetherClient._connectionState;
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, ConnectionState.DISCONNECTED);
                        StateFlowImpl stateFlowImpl3 = listenTogetherClient._pendingJoinRequests;
                        stateFlowImpl3.getClass();
                        EmptyList emptyList = EmptyList.INSTANCE;
                        stateFlowImpl3.updateState(null, emptyList);
                        StateFlowImpl stateFlowImpl4 = listenTogetherClient._bufferingUsers;
                        stateFlowImpl4.getClass();
                        stateFlowImpl4.updateState(null, emptyList);
                        if (listenTogetherClient.sessionToken == null || listenTogetherClient._roomState.getValue() == null) {
                            listenTogetherClient.emitEvent(ListenTogetherEvent.Disconnected.INSTANCE);
                        } else {
                            listenTogetherClient.log(logLevel, "Connection lost, will attempt to reconnect", null);
                            listenTogetherClient.handleConnectionFailure(new Exception("Connection lost"));
                        }
                        listenTogetherClient.evaluateBackgroundDisconnectPolicy("socket_disconnected");
                    }

                    @Override // okhttp3.WebSocketListener
                    public final void onClosing(WebSocket webSocket, int i, String str2) {
                        ListenTogetherClient.this.log(LogLevel.INFO, "Server closing connection", "Code: " + i + ", Reason: " + str2);
                        ((RealWebSocket) webSocket).close(CIOKt.DEFAULT_HTTP_POOL_SIZE, null);
                    }

                    @Override // okhttp3.WebSocketListener
                    public final void onFailure(WebSocket webSocket, Throwable th, Response response) {
                        String message = th.getMessage();
                        ListenTogetherClient listenTogetherClient = ListenTogetherClient.this;
                        listenTogetherClient.log(LogLevel.ERROR, "Connection failure", message);
                        listenTogetherClient.handleConnectionFailure(th);
                    }

                    @Override // okhttp3.WebSocketListener
                    public final void onMessage(WebSocket webSocket, ByteString byteString) {
                        ListenTogetherClient.this.handleMessage(byteString.toByteArray());
                    }

                    @Override // okhttp3.WebSocketListener
                    public final void onOpen(WebSocket webSocket, Response response) {
                        String str2;
                        ListenTogetherClient listenTogetherClient = ListenTogetherClient.this;
                        LogLevel logLevel = LogLevel.INFO;
                        listenTogetherClient.log(logLevel, "Connected to server", null);
                        StateFlowImpl stateFlowImpl2 = listenTogetherClient._connectionState;
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, ConnectionState.CONNECTED);
                        listenTogetherClient.reconnectAttempts = 0;
                        StandaloneCoroutine standaloneCoroutine = listenTogetherClient.pingJob;
                        if (standaloneCoroutine != null) {
                            standaloneCoroutine.cancel(null);
                        }
                        listenTogetherClient.pingJob = AwaitKt.launch$default(listenTogetherClient.scope, null, null, new Updater$getAllReleases$2(listenTogetherClient, (Continuation) null), 3);
                        listenTogetherClient.evaluateBackgroundDisconnectPolicy("socket_open");
                        if (listenTogetherClient.sessionToken != null && (str2 = listenTogetherClient.storedRoomCode) != null) {
                            listenTogetherClient.log(logLevel, "Attempting to reconnect to previous session", "Room: ".concat(str2));
                            String str3 = listenTogetherClient.sessionToken;
                            str3.getClass();
                            GeneratedMessageLite generatedMessageLiteBuild = Listentogether.ReconnectPayload.newBuilder().setSessionToken(str3).m915build();
                            generatedMessageLiteBuild.getClass();
                            listenTogetherClient.sendMessage("reconnect", (Listentogether.ReconnectPayload) generatedMessageLiteBuild);
                            return;
                        }
                        CharsKt charsKt = listenTogetherClient.pendingAction;
                        if (charsKt == null) {
                            return;
                        }
                        listenTogetherClient.pendingAction = null;
                        listenTogetherClient.evaluateBackgroundDisconnectPolicy("pending_action_started");
                        if (charsKt instanceof PendingAction$CreateRoom) {
                            String str4 = ((PendingAction$CreateRoom) charsKt).username;
                            listenTogetherClient.log(logLevel, "Executing pending create room", str4);
                            str4.getClass();
                            GeneratedMessageLite generatedMessageLiteBuild2 = Listentogether.CreateRoomPayload.newBuilder().setUsername(str4).m915build();
                            generatedMessageLiteBuild2.getClass();
                            listenTogetherClient.sendMessage("create_room", (Listentogether.CreateRoomPayload) generatedMessageLiteBuild2);
                            return;
                        }
                        if (!(charsKt instanceof PendingAction$JoinRoom)) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return;
                        }
                        PendingAction$JoinRoom pendingAction$JoinRoom = (PendingAction$JoinRoom) charsKt;
                        String str5 = pendingAction$JoinRoom.username;
                        String str6 = pendingAction$JoinRoom.roomCode;
                        listenTogetherClient.log(logLevel, "Executing pending join room", Fragment$5$$ExternalSyntheticOutline0.m(str6, " as ", str5));
                        String upperCase = str6.toUpperCase(Locale.ROOT);
                        upperCase.getClass();
                        str5.getClass();
                        GeneratedMessageLite generatedMessageLiteBuild3 = Listentogether.JoinRoomPayload.newBuilder().setRoomCode(upperCase).setUsername(str5).m915build();
                        generatedMessageLiteBuild3.getClass();
                        listenTogetherClient.sendMessage("join_room", (Listentogether.JoinRoomPayload) generatedMessageLiteBuild3);
                    }
                });
                return;
            }
        }
        log(LogLevel.WARNING, "Already connected or connecting", null);
    }

    public final void disconnect() {
        log(LogLevel.INFO, "Disconnecting from server", null);
        StandaloneCoroutine standaloneCoroutine = this.backgroundDisconnectJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.backgroundDisconnectJob = null;
        releaseWakeLock();
        StandaloneCoroutine standaloneCoroutine2 = this.pingJob;
        if (standaloneCoroutine2 != null) {
            standaloneCoroutine2.cancel(null);
        }
        this.pingJob = null;
        this.serverClock.reset();
        this.lastPlaybackRevision.set(0L);
        RealWebSocket realWebSocket = this.webSocket;
        if (realWebSocket != null) {
            realWebSocket.close(CIOKt.DEFAULT_HTTP_POOL_SIZE, "User disconnected");
        }
        this.webSocket = null;
        StateFlowImpl stateFlowImpl = this._connectionState;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, ConnectionState.DISCONNECTED);
        this.sessionToken = null;
        this.storedRoomCode = null;
        this.storedUsername = null;
        this.pendingAction = null;
        this._roomState.setValue(null);
        StateFlowImpl stateFlowImpl2 = this._role;
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, RoomRole.NONE);
        this._userId.setValue(null);
        StateFlowImpl stateFlowImpl3 = this._pendingJoinRequests;
        stateFlowImpl3.getClass();
        EmptyList emptyList = EmptyList.INSTANCE;
        stateFlowImpl3.updateState(null, emptyList);
        StateFlowImpl stateFlowImpl4 = this._bufferingUsers;
        stateFlowImpl4.getClass();
        stateFlowImpl4.updateState(null, emptyList);
        clearPersistedSession();
        this.reconnectAttempts = 0;
        emitEvent(ListenTogetherEvent.Disconnected.INSTANCE);
    }

    public final void emitEvent(ListenTogetherEvent listenTogetherEvent) {
        if (this.eventQueue.mo1712trySendJP2dKIU(listenTogetherEvent) instanceof ChannelResult.Failed) {
            log(LogLevel.ERROR, "Failed to queue Listen Together event", Reflection.getOrCreateKotlinClass(listenTogetherEvent.getClass()).getSimpleName());
        }
    }

    public final void evaluateBackgroundDisconnectPolicy(String str) {
        boolean zShouldDisconnectForBackgroundIdle = shouldDisconnectForBackgroundIdle();
        StandaloneCoroutine standaloneCoroutine = this.backgroundDisconnectJob;
        Continuation continuation = null;
        if (zShouldDisconnectForBackgroundIdle) {
            if (standaloneCoroutine == null || !standaloneCoroutine.isActive()) {
                log(LogLevel.INFO, "Scheduling background idle disconnect", IntIntPair$$ExternalSyntheticOutline0.m("Disconnecting in 30 minutes (", str, ")"));
                this.backgroundDisconnectJob = AwaitKt.launch$default(this.scope, null, null, new ListenTogetherClient$blockUser$3(this, continuation, (byte) 2), 3);
                return;
            }
            return;
        }
        if (standaloneCoroutine != null && standaloneCoroutine.isActive()) {
            log(LogLevel.DEBUG, "Cancelled background idle disconnect", str);
        }
        StandaloneCoroutine standaloneCoroutine2 = this.backgroundDisconnectJob;
        if (standaloneCoroutine2 != null) {
            standaloneCoroutine2.cancel(null);
        }
        this.backgroundDisconnectJob = null;
    }

    public final void handleConnectionFailure(Throwable th) {
        StandaloneCoroutine standaloneCoroutine = this.pingJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.pingJob = null;
        String str = this.sessionToken;
        StateFlowImpl stateFlowImpl = this._roomState;
        boolean z = (str == null && stateFlowImpl.getValue() == null && this.pendingAction == null) ? false : true;
        boolean z2 = this.isNetworkAvailable;
        StateFlowImpl stateFlowImpl2 = this._connectionState;
        if (!z2) {
            log(LogLevel.WARNING, "Connection failure, waiting for network", th.getMessage());
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, ConnectionState.DISCONNECTED);
            evaluateBackgroundDisconnectPolicy("connection_failure_no_network");
            return;
        }
        int i = this.reconnectAttempts;
        if (i < 15 && z) {
            this.reconnectAttempts = i + 1;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, ConnectionState.RECONNECTING);
            long jMin = Math.min(((long) (2 << Math.min(this.reconnectAttempts - 1, 4))) * 1000, 120000L);
            long jRandom = jMin + ((long) (Math.random() * jMin * 0.2d));
            long j = jRandom / 1000;
            int i2 = this.reconnectAttempts;
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder("Attempt ");
            sb.append(i2);
            sb.append("/15, waiting ");
            sb.append(j);
            log(LogLevel.INFO, "Attempting reconnect", IntIntPair$$ExternalSyntheticOutline0.m(sb, "s, reason: ", message));
            emitEvent(new ListenTogetherEvent.Reconnecting(this.reconnectAttempts));
            AwaitKt.launch$default(this.scope, null, null, new C01481(jRandom, this, j, null), 3);
            evaluateBackgroundDisconnectPolicy("connection_failure_retrying");
            return;
        }
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, ConnectionState.ERROR);
        if (this.sessionToken != null) {
            log(LogLevel.ERROR, "Reconnection failed", "Max attempts reached, but session preserved for manual reconnect");
            String message2 = th.getMessage();
            emitEvent(new ListenTogetherEvent.ConnectionError("Connection failed after 15 attempts. ".concat(message2 != null ? message2 : "Unknown error")));
        } else {
            this.sessionToken = null;
            this.storedRoomCode = null;
            this.storedUsername = null;
            stateFlowImpl.setValue(null);
            StateFlowImpl stateFlowImpl3 = this._role;
            stateFlowImpl3.getClass();
            stateFlowImpl3.updateState(null, RoomRole.NONE);
            clearPersistedSession();
            String message3 = th.getMessage();
            emitEvent(new ListenTogetherEvent.ConnectionError(message3 != null ? message3 : "Unknown error"));
        }
        evaluateBackgroundDisconnectPolicy("connection_failure_exhausted");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final void handleMessage(byte[] bArr) {
        LogLevel logLevel;
        LogLevel logLevel2;
        Listentogether.RoomState roomStateCopy$default;
        Listentogether.RoomState roomStateCopy$default2;
        Listentogether.RoomState roomStateCopy$default3;
        Listentogether.TrackInfo trackInfoOrNull;
        Listentogether.RoomState roomStateCopy$default4;
        List listPlus;
        List queue;
        Listentogether.RoomState roomStateCopy$default5;
        List list;
        Listentogether.RoomState roomStateCopy$default6;
        long position;
        long lastUpdate;
        Listentogether.RoomState roomStateCopy$default7;
        long position2;
        long lastUpdate2;
        Listentogether.RoomState roomStateCopy$default8;
        long position3;
        long lastUpdate3;
        Listentogether.RoomState roomStateCopy$default9;
        long lastUpdate4;
        List queue2;
        LogLevel logLevel3;
        Listentogether.RoomState roomStateCopy$default10;
        Listentogether.RoomState roomStateCopy$default11;
        Listentogether.RoomState roomStateCopy$default12;
        Listentogether.RoomState roomStateCopy$default13;
        Listentogether.RoomState roomStateCopy$default14;
        LogLevel logLevel4 = LogLevel.ERROR;
        MessageCodec messageCodec = this.codec;
        String str = bArr.length + " bytes";
        LogLevel logLevel5 = LogLevel.DEBUG;
        log(logLevel5, "Received message", str);
        try {
            messageCodec.getClass();
            Pair pairDecode = MessageCodec.decode(bArr);
            String str2 = (String) pairDecode.first;
            byte[] bArr2 = (byte[]) pairDecode.second;
            int iHashCode = str2.hashCode();
            RoomRole roomRole = RoomRole.NONE;
            StateFlowImpl stateFlowImpl = this._blockedUsernames;
            RoomRole roomRole2 = RoomRole.GUEST;
            LogLevel logLevel6 = LogLevel.WARNING;
            RoomRole roomRole3 = RoomRole.HOST;
            LogLevel logLevel7 = LogLevel.INFO;
            ContextScope contextScope = this.scope;
            LinkedHashMap linkedHashMap = this.suggestionNotifications;
            StateFlowImpl stateFlowImpl2 = this._bufferingUsers;
            StateFlowImpl stateFlowImpl3 = this._pendingJoinRequests;
            AtomicLong atomicLong = this.lastPlaybackRevision;
            LogLevel logLevel8 = logLevel4;
            StateFlowImpl stateFlowImpl4 = this._userId;
            Context context = this.context;
            EmptyList emptyList = EmptyList.INSTANCE;
            StateFlowImpl stateFlowImpl5 = this._role;
            StateFlowImpl stateFlowImpl6 = this._roomState;
            Object obj = "Code: ";
            try {
                try {
                    try {
                        switch (iHashCode) {
                            case -1941230026:
                                logLevel2 = logLevel6;
                                if (str2.equals("reconnected")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.ReconnectedPayload reconnectedPayload = generatedMessageLiteDecodePayload instanceof Listentogether.ReconnectedPayload ? (Listentogether.ReconnectedPayload) generatedMessageLiteDecodePayload : null;
                                    if (reconnectedPayload != null) {
                                        stateFlowImpl4.setValue(reconnectedPayload.getUserId());
                                        if (reconnectedPayload.getIsHost()) {
                                            roomRole2 = roomRole3;
                                        }
                                        stateFlowImpl5.setValue(roomRole2);
                                        stateFlowImpl6.setValue(reconnectedPayload.getState());
                                        atomicLong.set(reconnectedPayload.getState().getRevision());
                                        this.wasHost = reconnectedPayload.getIsHost();
                                        System.currentTimeMillis();
                                        savePersistedSession();
                                        evaluateBackgroundDisconnectPolicy("reconnected");
                                        this.reconnectAttempts = 0;
                                        acquireWakeLock();
                                        log(logLevel7, "Successfully reconnected to room", "Code: " + reconnectedPayload.getRoomCode() + ", isHost: " + reconnectedPayload.getIsHost() + ", attempt was " + this.reconnectAttempts);
                                        String roomCode = reconnectedPayload.getRoomCode();
                                        roomCode.getClass();
                                        String userId = reconnectedPayload.getUserId();
                                        userId.getClass();
                                        Listentogether.RoomState state = reconnectedPayload.getState();
                                        state.getClass();
                                        emitEvent(new ListenTogetherEvent.Reconnected(roomCode, userId, state, reconnectedPayload.getIsHost()));
                                        break;
                                    }
                                }
                                log(logLevel2, "Unknown message type", str2);
                                break;
                            case -1849187859:
                                logLevel2 = logLevel6;
                                if (str2.equals("sync_state")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload2 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.SyncStatePayload syncStatePayload = generatedMessageLiteDecodePayload2 instanceof Listentogether.SyncStatePayload ? (Listentogether.SyncStatePayload) generatedMessageLiteDecodePayload2 : null;
                                    if (syncStatePayload != null) {
                                        if (acceptPlaybackRevision(syncStatePayload.getRevision())) {
                                            Listentogether.RoomState roomState = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                            if (roomState != null) {
                                                Listentogether.TrackInfo currentTrackOrNull = ProtocolKt.getCurrentTrackOrNull(syncStatePayload);
                                                boolean isPlaying = syncStatePayload.getIsPlaying();
                                                long position4 = syncStatePayload.getPosition();
                                                long lastUpdate5 = syncStatePayload.getLastUpdate();
                                                float volume = syncStatePayload.getVolume();
                                                List<Listentogether.TrackInfo> queueList = syncStatePayload.getQueueList();
                                                if (queueList == null) {
                                                    Object value = stateFlowImpl6.getValue();
                                                    value.getClass();
                                                    queueList = ProtocolKt.getQueue((Listentogether.RoomState) value);
                                                }
                                                List<Listentogether.TrackInfo> list2 = queueList;
                                                Object value2 = stateFlowImpl6.getValue();
                                                value2.getClass();
                                                roomStateCopy$default = ProtocolKt.copy$default(roomState, null, null, currentTrackOrNull, isPlaying, position4, lastUpdate5, volume, list2, Math.max(((Listentogether.RoomState) value2).getRevision(), syncStatePayload.getRevision()), 7);
                                            } else {
                                                roomStateCopy$default = null;
                                            }
                                            stateFlowImpl6.setValue(roomStateCopy$default);
                                            log(logLevel7, "Sync state received", "Playing: " + syncStatePayload.getIsPlaying() + ", Position: " + syncStatePayload.getPosition());
                                            emitEvent(new ListenTogetherEvent.SyncStateReceived(syncStatePayload));
                                        } else {
                                            log(logLevel5, "Discarding stale sync state", "Revision: " + syncStatePayload.getRevision());
                                        }
                                    }
                                } else {
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case -1343902913:
                                logLevel2 = logLevel6;
                                if (str2.equals("sync_playback")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload3 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.PlaybackActionPayload playbackActionPayload = generatedMessageLiteDecodePayload3 instanceof Listentogether.PlaybackActionPayload ? (Listentogether.PlaybackActionPayload) generatedMessageLiteDecodePayload3 : null;
                                    if (playbackActionPayload != null) {
                                        if (acceptPlaybackRevision(playbackActionPayload.getRevision())) {
                                            log(logLevel5, "Playback sync", "Action: " + playbackActionPayload.getAction());
                                            String action = playbackActionPayload.getAction();
                                            if (action != null) {
                                                switch (action.hashCode()) {
                                                    case -1851001235:
                                                        if (action.equals("sync_queue")) {
                                                            Listentogether.RoomState roomState2 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                            if (roomState2 != null) {
                                                                List queue3 = ProtocolKt.getQueue(playbackActionPayload);
                                                                roomStateCopy$default3 = ProtocolKt.copy$default(roomState2, null, null, null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, queue3 == null ? emptyList : queue3, 0L, 767);
                                                            } else {
                                                                roomStateCopy$default3 = null;
                                                            }
                                                            stateFlowImpl6.setValue(roomStateCopy$default3);
                                                        }
                                                        break;
                                                    case -1739141005:
                                                        if (action.equals("queue_add") && (trackInfoOrNull = ProtocolKt.getTrackInfoOrNull(playbackActionPayload)) != null) {
                                                            Listentogether.RoomState roomState3 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                            List queue4 = roomState3 != null ? ProtocolKt.getQueue(roomState3) : emptyList;
                                                            Listentogether.RoomState roomState4 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                            if (roomState4 != null) {
                                                                if (playbackActionPayload.getRevision() > 0) {
                                                                    List queue5 = ProtocolKt.getQueue(playbackActionPayload);
                                                                    listPlus = queue5 == null ? emptyList : queue5;
                                                                } else {
                                                                    listPlus = playbackActionPayload.getInsertNext() ? CollectionsKt.plus((Iterable) queue4, (Collection) CollectionsKt__IterablesKt.listOf(trackInfoOrNull)) : CollectionsKt.plus(trackInfoOrNull, queue4);
                                                                }
                                                                roomStateCopy$default4 = ProtocolKt.copy$default(roomState4, null, null, null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, listPlus, 0L, 767);
                                                            } else {
                                                                roomStateCopy$default4 = null;
                                                            }
                                                            stateFlowImpl6.setValue(roomStateCopy$default4);
                                                        }
                                                        break;
                                                    case -1088367209:
                                                        if (action.equals("set_volume")) {
                                                            Float fValueOf = Float.valueOf(playbackActionPayload.getVolume());
                                                            if (!Intrinsics.areEqual(playbackActionPayload.getAction(), "set_volume")) {
                                                                fValueOf = null;
                                                            }
                                                            if (fValueOf != null) {
                                                                Listentogether.RoomState roomState5 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                                stateFlowImpl6.setValue(roomState5 != null ? ProtocolKt.copy$default(roomState5, null, null, null, false, 0L, 0L, UuidKt.coerceIn(fValueOf.floatValue(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f), null, 0L, 895) : null);
                                                            }
                                                        }
                                                        break;
                                                    case -570138209:
                                                        if (action.equals("queue_clear")) {
                                                            Listentogether.RoomState roomState6 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                            stateFlowImpl6.setValue(roomState6 != null ? ProtocolKt.copy$default(roomState6, null, null, null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, (playbackActionPayload.getRevision() <= 0 || (queue = ProtocolKt.getQueue(playbackActionPayload)) == null) ? emptyList : queue, 0L, 767) : null);
                                                        }
                                                        break;
                                                    case -71190670:
                                                        if (action.equals("queue_remove")) {
                                                            String trackId = playbackActionPayload.getTrackId();
                                                            if (trackId.length() <= 0) {
                                                                trackId = null;
                                                            }
                                                            if (trackId != null && trackId.length() != 0) {
                                                                Listentogether.RoomState roomState7 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                                List queue6 = roomState7 != null ? ProtocolKt.getQueue(roomState7) : emptyList;
                                                                Listentogether.RoomState roomState8 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                                if (roomState8 != null) {
                                                                    if (playbackActionPayload.getRevision() > 0) {
                                                                        List queue7 = ProtocolKt.getQueue(playbackActionPayload);
                                                                        list = queue7 == null ? emptyList : queue7;
                                                                    } else {
                                                                        ArrayList arrayList = new ArrayList();
                                                                        for (Object obj2 : queue6) {
                                                                            if (!Intrinsics.areEqual(((Listentogether.TrackInfo) obj2).getId(), trackId)) {
                                                                                arrayList.add(obj2);
                                                                            }
                                                                        }
                                                                        list = arrayList;
                                                                    }
                                                                    roomStateCopy$default5 = ProtocolKt.copy$default(roomState8, null, null, null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, list, 0L, 767);
                                                                } else {
                                                                    roomStateCopy$default5 = null;
                                                                }
                                                                stateFlowImpl6.setValue(roomStateCopy$default5);
                                                            }
                                                        }
                                                        break;
                                                    case 3443508:
                                                        if (action.equals("play")) {
                                                            Listentogether.RoomState roomState9 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                            if (roomState9 != null) {
                                                                Long positionOrNull = ProtocolKt.getPositionOrNull(playbackActionPayload);
                                                                if (positionOrNull != null) {
                                                                    position = positionOrNull.longValue();
                                                                } else {
                                                                    Object value3 = stateFlowImpl6.getValue();
                                                                    value3.getClass();
                                                                    position = ((Listentogether.RoomState) value3).getPosition();
                                                                }
                                                                long j = position;
                                                                Long serverTimeOrNull = ProtocolKt.getServerTimeOrNull(playbackActionPayload);
                                                                if (serverTimeOrNull != null) {
                                                                    lastUpdate = serverTimeOrNull.longValue();
                                                                } else {
                                                                    Object value4 = stateFlowImpl6.getValue();
                                                                    value4.getClass();
                                                                    lastUpdate = ((Listentogether.RoomState) value4).getLastUpdate();
                                                                }
                                                                long j2 = lastUpdate;
                                                                Object value5 = stateFlowImpl6.getValue();
                                                                value5.getClass();
                                                                roomStateCopy$default6 = ProtocolKt.copy$default(roomState9, null, null, null, true, j, j2, CropImageView.DEFAULT_ASPECT_RATIO, null, Math.max(((Listentogether.RoomState) value5).getRevision(), playbackActionPayload.getRevision()), 399);
                                                            } else {
                                                                roomStateCopy$default6 = null;
                                                            }
                                                            stateFlowImpl6.setValue(roomStateCopy$default6);
                                                        }
                                                        break;
                                                    case 3526264:
                                                        if (action.equals("seek")) {
                                                            Listentogether.RoomState roomState10 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                            if (roomState10 != null) {
                                                                Long positionOrNull2 = ProtocolKt.getPositionOrNull(playbackActionPayload);
                                                                if (positionOrNull2 != null) {
                                                                    position2 = positionOrNull2.longValue();
                                                                } else {
                                                                    Object value6 = stateFlowImpl6.getValue();
                                                                    value6.getClass();
                                                                    position2 = ((Listentogether.RoomState) value6).getPosition();
                                                                }
                                                                long j3 = position2;
                                                                Long serverTimeOrNull2 = ProtocolKt.getServerTimeOrNull(playbackActionPayload);
                                                                if (serverTimeOrNull2 != null) {
                                                                    lastUpdate2 = serverTimeOrNull2.longValue();
                                                                } else {
                                                                    Object value7 = stateFlowImpl6.getValue();
                                                                    value7.getClass();
                                                                    lastUpdate2 = ((Listentogether.RoomState) value7).getLastUpdate();
                                                                }
                                                                long j4 = lastUpdate2;
                                                                Object value8 = stateFlowImpl6.getValue();
                                                                value8.getClass();
                                                                roomStateCopy$default7 = ProtocolKt.copy$default(roomState10, null, null, null, false, j3, j4, CropImageView.DEFAULT_ASPECT_RATIO, null, Math.max(((Listentogether.RoomState) value8).getRevision(), playbackActionPayload.getRevision()), 415);
                                                            } else {
                                                                roomStateCopy$default7 = null;
                                                            }
                                                            stateFlowImpl6.setValue(roomStateCopy$default7);
                                                        }
                                                        break;
                                                    case 106440182:
                                                        if (action.equals("pause")) {
                                                            Listentogether.RoomState roomState11 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                            if (roomState11 != null) {
                                                                Long positionOrNull3 = ProtocolKt.getPositionOrNull(playbackActionPayload);
                                                                if (positionOrNull3 != null) {
                                                                    position3 = positionOrNull3.longValue();
                                                                } else {
                                                                    Object value9 = stateFlowImpl6.getValue();
                                                                    value9.getClass();
                                                                    position3 = ((Listentogether.RoomState) value9).getPosition();
                                                                }
                                                                long j5 = position3;
                                                                Long serverTimeOrNull3 = ProtocolKt.getServerTimeOrNull(playbackActionPayload);
                                                                if (serverTimeOrNull3 != null) {
                                                                    lastUpdate3 = serverTimeOrNull3.longValue();
                                                                } else {
                                                                    Object value10 = stateFlowImpl6.getValue();
                                                                    value10.getClass();
                                                                    lastUpdate3 = ((Listentogether.RoomState) value10).getLastUpdate();
                                                                }
                                                                long j6 = lastUpdate3;
                                                                Object value11 = stateFlowImpl6.getValue();
                                                                value11.getClass();
                                                                roomStateCopy$default8 = ProtocolKt.copy$default(roomState11, null, null, null, false, j5, j6, CropImageView.DEFAULT_ASPECT_RATIO, null, Math.max(((Listentogether.RoomState) value11).getRevision(), playbackActionPayload.getRevision()), 399);
                                                            } else {
                                                                roomStateCopy$default8 = null;
                                                            }
                                                            stateFlowImpl6.setValue(roomStateCopy$default8);
                                                        }
                                                        break;
                                                    case 251257852:
                                                        if (action.equals("change_track")) {
                                                            Listentogether.RoomState roomState12 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                                            if (roomState12 != null) {
                                                                Listentogether.TrackInfo trackInfoOrNull2 = ProtocolKt.getTrackInfoOrNull(playbackActionPayload);
                                                                Long serverTimeOrNull4 = ProtocolKt.getServerTimeOrNull(playbackActionPayload);
                                                                if (serverTimeOrNull4 != null) {
                                                                    lastUpdate4 = serverTimeOrNull4.longValue();
                                                                } else {
                                                                    Object value12 = stateFlowImpl6.getValue();
                                                                    value12.getClass();
                                                                    lastUpdate4 = ((Listentogether.RoomState) value12).getLastUpdate();
                                                                }
                                                                long j7 = lastUpdate4;
                                                                if (playbackActionPayload.getRevision() > 0) {
                                                                    List queue8 = ProtocolKt.getQueue(playbackActionPayload);
                                                                    queue2 = queue8 == null ? emptyList : queue8;
                                                                } else {
                                                                    Object value13 = stateFlowImpl6.getValue();
                                                                    value13.getClass();
                                                                    queue2 = ProtocolKt.getQueue((Listentogether.RoomState) value13);
                                                                }
                                                                Object value14 = stateFlowImpl6.getValue();
                                                                value14.getClass();
                                                                roomStateCopy$default9 = ProtocolKt.copy$default(roomState12, null, null, trackInfoOrNull2, false, 0L, j7, CropImageView.DEFAULT_ASPECT_RATIO, queue2, Math.max(((Listentogether.RoomState) value14).getRevision(), playbackActionPayload.getRevision()), 135);
                                                            } else {
                                                                roomStateCopy$default9 = null;
                                                            }
                                                            stateFlowImpl6.setValue(roomStateCopy$default9);
                                                        }
                                                        break;
                                                }
                                            }
                                            Listentogether.RoomState roomState13 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                            if (roomState13 != null) {
                                                Object value15 = stateFlowImpl6.getValue();
                                                value15.getClass();
                                                roomStateCopy$default2 = ProtocolKt.copy$default(roomState13, null, null, null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, Math.max(((Listentogether.RoomState) value15).getRevision(), playbackActionPayload.getRevision()), 511);
                                            } else {
                                                roomStateCopy$default2 = null;
                                            }
                                            stateFlowImpl6.setValue(roomStateCopy$default2);
                                            emitEvent(new ListenTogetherEvent.PlaybackSync(playbackActionPayload));
                                        } else {
                                            log(logLevel5, "Discarding stale playback event", "Revision: " + playbackActionPayload.getRevision());
                                        }
                                    }
                                } else {
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case -1131623067:
                                logLevel2 = logLevel6;
                                if (str2.equals("kicked")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload4 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.KickedPayload kickedPayload = generatedMessageLiteDecodePayload4 instanceof Listentogether.KickedPayload ? (Listentogether.KickedPayload) generatedMessageLiteDecodePayload4 : null;
                                    if (kickedPayload != null) {
                                        log(logLevel2, "Kicked from room", kickedPayload.getReason());
                                        releaseWakeLock();
                                        this.sessionToken = null;
                                        stateFlowImpl6.setValue(null);
                                        stateFlowImpl5.setValue(roomRole);
                                        atomicLong.set(0L);
                                        evaluateBackgroundDisconnectPolicy("kicked");
                                        String reason = kickedPayload.getReason();
                                        reason.getClass();
                                        emitEvent(new ListenTogetherEvent.Kicked(reason));
                                    }
                                } else {
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case -1024893420:
                                logLevel2 = logLevel6;
                                if (str2.equals("buffer_wait")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload5 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.BufferWaitPayload bufferWaitPayload = generatedMessageLiteDecodePayload5 instanceof Listentogether.BufferWaitPayload ? (Listentogether.BufferWaitPayload) generatedMessageLiteDecodePayload5 : null;
                                    if (bufferWaitPayload != null) {
                                        List<String> waitingForList = bufferWaitPayload.getWaitingForList();
                                        waitingForList.getClass();
                                        stateFlowImpl2.setValue(waitingForList);
                                        List<String> waitingForList2 = bufferWaitPayload.getWaitingForList();
                                        waitingForList2.getClass();
                                        log(logLevel5, "Waiting for buffering", "Users: " + waitingForList2.size());
                                        String trackId2 = bufferWaitPayload.getTrackId();
                                        trackId2.getClass();
                                        List<String> waitingForList3 = bufferWaitPayload.getWaitingForList();
                                        waitingForList3.getClass();
                                        emitEvent(new ListenTogetherEvent.BufferWait(trackId2, waitingForList3));
                                    }
                                } else {
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case -752968828:
                                logLevel2 = logLevel6;
                                if (str2.equals("room_created")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload6 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.RoomCreatedPayload roomCreatedPayload = generatedMessageLiteDecodePayload6 instanceof Listentogether.RoomCreatedPayload ? (Listentogether.RoomCreatedPayload) generatedMessageLiteDecodePayload6 : null;
                                    if (roomCreatedPayload != null) {
                                        stateFlowImpl4.setValue(roomCreatedPayload.getUserId());
                                        stateFlowImpl5.setValue(roomRole3);
                                        atomicLong.set(0L);
                                        this.sessionToken = roomCreatedPayload.getSessionToken();
                                        this.storedRoomCode = roomCreatedPayload.getRoomCode();
                                        this.wasHost = true;
                                        System.currentTimeMillis();
                                        String roomCode2 = roomCreatedPayload.getRoomCode();
                                        roomCode2.getClass();
                                        String userId2 = roomCreatedPayload.getUserId();
                                        userId2.getClass();
                                        String userId3 = roomCreatedPayload.getUserId();
                                        userId3.getClass();
                                        String str3 = this.storedUsername;
                                        if (str3 == null) {
                                            str3 = "";
                                        }
                                        stateFlowImpl6.setValue(ProtocolKt.RoomState(roomCode2, userId2, CollectionsKt__IterablesKt.listOf(ProtocolKt.UserInfo(userId3, str3, true, true)), null, false, 0L, System.currentTimeMillis(), 1.0f, EmptyList.INSTANCE, 0L));
                                        savePersistedSession();
                                        evaluateBackgroundDisconnectPolicy("room_created");
                                        acquireWakeLock();
                                        log(logLevel7, "Room created", "Code: " + roomCreatedPayload.getRoomCode());
                                        String roomCode3 = roomCreatedPayload.getRoomCode();
                                        roomCode3.getClass();
                                        String userId4 = roomCreatedPayload.getUserId();
                                        userId4.getClass();
                                        emitEvent(new ListenTogetherEvent.RoomCreated(roomCode3, userId4));
                                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                                        AwaitKt.launch$default(contextScope, MainDispatcherLoader.dispatcher, null, new C01491(roomCreatedPayload, null), 2);
                                    }
                                } else {
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case -412578243:
                                logLevel3 = logLevel6;
                                if (str2.equals("user_joined")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload7 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.UserJoinedPayload userJoinedPayload = generatedMessageLiteDecodePayload7 instanceof Listentogether.UserJoinedPayload ? (Listentogether.UserJoinedPayload) generatedMessageLiteDecodePayload7 : null;
                                    if (userJoinedPayload != null) {
                                        Listentogether.RoomState roomState14 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                        if (roomState14 != null) {
                                            Object value16 = stateFlowImpl6.getValue();
                                            value16.getClass();
                                            List users = ProtocolKt.getUsers((Listentogether.RoomState) value16);
                                            String userId5 = userJoinedPayload.getUserId();
                                            userId5.getClass();
                                            String username = userJoinedPayload.getUsername();
                                            username.getClass();
                                            roomStateCopy$default10 = ProtocolKt.copy$default(roomState14, null, CollectionsKt.plus(ProtocolKt.UserInfo(userId5, username, false, true), users), null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, 0L, 1019);
                                        } else {
                                            roomStateCopy$default10 = null;
                                        }
                                        stateFlowImpl6.setValue(roomStateCopy$default10);
                                        Iterable iterable = (Iterable) stateFlowImpl3.getValue();
                                        ArrayList arrayList2 = new ArrayList();
                                        for (Object obj3 : iterable) {
                                            if (!Intrinsics.areEqual(((Listentogether.JoinRequestPayload) obj3).getUserId(), userJoinedPayload.getUserId())) {
                                                arrayList2.add(obj3);
                                            }
                                        }
                                        stateFlowImpl3.setValue(arrayList2);
                                        Integer num = (Integer) this.joinRequestNotifications.remove(userJoinedPayload.getUserId());
                                        if (num != null) {
                                            new NotificationManagerCompat(context).cancel(num.intValue());
                                        }
                                        log(logLevel7, "User joined", userJoinedPayload.getUsername());
                                        String userId6 = userJoinedPayload.getUserId();
                                        userId6.getClass();
                                        String username2 = userJoinedPayload.getUsername();
                                        username2.getClass();
                                        emitEvent(new ListenTogetherEvent.UserJoined(userId6, username2));
                                    }
                                } else {
                                    logLevel2 = logLevel3;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case -241805892:
                                logLevel3 = logLevel6;
                                logLevel8 = logLevel8;
                                if (str2.equals("suggestion_received")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload8 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.SuggestionReceivedPayload suggestionReceivedPayload = generatedMessageLiteDecodePayload8 instanceof Listentogether.SuggestionReceivedPayload ? (Listentogether.SuggestionReceivedPayload) generatedMessageLiteDecodePayload8 : null;
                                    if (suggestionReceivedPayload != null && stateFlowImpl5.getValue() == roomRole3) {
                                        String fromUsername = suggestionReceivedPayload.getFromUsername();
                                        fromUsername.getClass();
                                        if (((Set) stateFlowImpl.getValue()).contains(fromUsername)) {
                                            log(logLevel7, "Suggestion from blocked user ignored", "User: " + suggestionReceivedPayload.getFromUsername());
                                        } else {
                                            log(logLevel7, "Suggestion received", suggestionReceivedPayload.getFromUsername() + ": " + suggestionReceivedPayload.getTrackInfo().getTitle());
                                            if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.ListenTogetherAutoApproveSuggestionsKey, Boolean.FALSE)).booleanValue()) {
                                                log(logLevel7, "Auto-approving suggestion", suggestionReceivedPayload.getFromUsername() + ": " + suggestionReceivedPayload.getTrackInfo().getTitle());
                                                String suggestionId = suggestionReceivedPayload.getSuggestionId();
                                                suggestionId.getClass();
                                                approveSuggestion(suggestionId);
                                            } else {
                                                StateFlowImpl stateFlowImpl7 = this._pendingSuggestions;
                                                stateFlowImpl7.setValue(CollectionsKt.plus(suggestionReceivedPayload, (Collection) stateFlowImpl7.getValue()));
                                                if (NavUtils.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
                                                    showSuggestionNotification(suggestionReceivedPayload);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    logLevel2 = logLevel3;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case -41582503:
                                logLevel3 = logLevel6;
                                if (str2.equals("suggestion_rejected")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload9 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.SuggestionRejectedPayload suggestionRejectedPayload = generatedMessageLiteDecodePayload9 instanceof Listentogether.SuggestionRejectedPayload ? (Listentogether.SuggestionRejectedPayload) generatedMessageLiteDecodePayload9 : null;
                                    if (suggestionRejectedPayload != null) {
                                        String reasonOrNull = ProtocolKt.getReasonOrNull(suggestionRejectedPayload);
                                        if (reasonOrNull == null) {
                                            reasonOrNull = "";
                                        }
                                        log(logLevel3, "Suggestion rejected", reasonOrNull);
                                        Integer num2 = (Integer) linkedHashMap.remove(suggestionRejectedPayload.getSuggestionId());
                                        if (num2 != null) {
                                            new NotificationManagerCompat(context).cancel(num2.intValue());
                                        }
                                    }
                                } else {
                                    logLevel2 = logLevel3;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case 3446776:
                                logLevel3 = logLevel6;
                                if (str2.equals("pong")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload10 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.PongPayload pongPayload = generatedMessageLiteDecodePayload10 instanceof Listentogether.PongPayload ? (Listentogether.PongPayload) generatedMessageLiteDecodePayload10 : null;
                                    if (pongPayload != null && this.serverClock.recordPong(pongPayload.getClientTime(), pongPayload.getServerReceiveTime(), pongPayload.getServerSendTime()) && stateFlowImpl5.getValue() == roomRole2) {
                                        requestSync();
                                    }
                                    log(logLevel5, "Pong received", null);
                                }
                                logLevel2 = logLevel3;
                                log(logLevel2, "Unknown message type", str2);
                                break;
                            case 46372851:
                                logLevel3 = logLevel6;
                                logLevel8 = logLevel8;
                                if (str2.equals("join_rejected")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload11 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.JoinRejectedPayload joinRejectedPayload = generatedMessageLiteDecodePayload11 instanceof Listentogether.JoinRejectedPayload ? (Listentogether.JoinRejectedPayload) generatedMessageLiteDecodePayload11 : null;
                                    if (joinRejectedPayload != null) {
                                        log(logLevel3, "Join rejected", joinRejectedPayload.getReason());
                                        String reason2 = joinRejectedPayload.getReason();
                                        reason2.getClass();
                                        emitEvent(new ListenTogetherEvent.JoinRejected(reason2));
                                    }
                                }
                                logLevel2 = logLevel3;
                                log(logLevel2, "Unknown message type", str2);
                                break;
                            case 96784904:
                                try {
                                    if (!str2.equals("error")) {
                                        logLevel2 = logLevel6;
                                        log(logLevel2, "Unknown message type", str2);
                                        break;
                                    } else {
                                        GeneratedMessageLite generatedMessageLiteDecodePayload12 = MessageCodec.decodePayload(str2, bArr2);
                                        Listentogether.ErrorPayload errorPayload = generatedMessageLiteDecodePayload12 instanceof Listentogether.ErrorPayload ? (Listentogether.ErrorPayload) generatedMessageLiteDecodePayload12 : null;
                                        if (errorPayload != null) {
                                            log(logLevel8, "Server error", errorPayload.getCode() + ": " + errorPayload.getMessage());
                                            if (Intrinsics.areEqual(errorPayload.getCode(), "session_not_found")) {
                                                stateFlowImpl6.setValue(null);
                                                stateFlowImpl5.setValue(roomRole);
                                                stateFlowImpl3.setValue(emptyList);
                                                stateFlowImpl2.setValue(emptyList);
                                                String str4 = this.storedRoomCode;
                                                if (str4 != null && this.storedUsername != null && !this.wasHost) {
                                                    log(logLevel6, "Session expired on server", "Attempting automatic rejoin to room: ".concat(str4));
                                                    AwaitKt.launch$default(contextScope, null, null, new ListenTogetherClient$blockUser$3(this, null, (byte) 4), 3);
                                                } else if (str4 == null || this.storedUsername == null) {
                                                    clearPersistedSession();
                                                    this.sessionToken = null;
                                                } else {
                                                    log(logLevel6, "Host session expired", "Room: " + str4 + " - manual intervention may be needed");
                                                    clearPersistedSession();
                                                    this.sessionToken = null;
                                                }
                                            }
                                            String code = errorPayload.getCode();
                                            code.getClass();
                                            String message = errorPayload.getMessage();
                                            message.getClass();
                                            emitEvent(new ListenTogetherEvent.ServerError(code, message));
                                            break;
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    obj = logLevel8;
                                    logLevel = obj;
                                    log(logLevel, "Error parsing message", e.getMessage());
                                }
                                break;
                            case 339284987:
                                if (str2.equals("user_left")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload13 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.UserLeftPayload userLeftPayload = generatedMessageLiteDecodePayload13 instanceof Listentogether.UserLeftPayload ? (Listentogether.UserLeftPayload) generatedMessageLiteDecodePayload13 : null;
                                    if (userLeftPayload != null) {
                                        Listentogether.RoomState roomState15 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                        if (roomState15 != null) {
                                            Object value17 = stateFlowImpl6.getValue();
                                            value17.getClass();
                                            List users2 = ProtocolKt.getUsers((Listentogether.RoomState) value17);
                                            ArrayList arrayList3 = new ArrayList();
                                            for (Object obj4 : users2) {
                                                if (!Intrinsics.areEqual(((Listentogether.UserInfo) obj4).getUserId(), userLeftPayload.getUserId())) {
                                                    arrayList3.add(obj4);
                                                }
                                            }
                                            roomStateCopy$default11 = ProtocolKt.copy$default(roomState15, null, arrayList3, null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, 0L, 1019);
                                        } else {
                                            roomStateCopy$default11 = null;
                                        }
                                        stateFlowImpl6.setValue(roomStateCopy$default11);
                                        log(logLevel7, "User left", userLeftPayload.getUsername());
                                        String userId7 = userLeftPayload.getUserId();
                                        userId7.getClass();
                                        String username3 = userLeftPayload.getUsername();
                                        username3.getClass();
                                        emitEvent(new ListenTogetherEvent.UserLeft(userId7, username3));
                                    }
                                } else {
                                    logLevel2 = logLevel6;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case 569480792:
                                if (str2.equals("buffer_complete")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload14 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.BufferCompletePayload bufferCompletePayload = generatedMessageLiteDecodePayload14 instanceof Listentogether.BufferCompletePayload ? (Listentogether.BufferCompletePayload) generatedMessageLiteDecodePayload14 : null;
                                    if (bufferCompletePayload != null) {
                                        stateFlowImpl2.setValue(emptyList);
                                        log(logLevel7, "All users buffered", "Track: " + bufferCompletePayload.getTrackId());
                                        String trackId3 = bufferCompletePayload.getTrackId();
                                        trackId3.getClass();
                                        emitEvent(new ListenTogetherEvent.BufferComplete(trackId3));
                                    }
                                } else {
                                    logLevel2 = logLevel6;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case 793518018:
                                if (str2.equals("user_reconnected")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload15 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.UserReconnectedPayload userReconnectedPayload = generatedMessageLiteDecodePayload15 instanceof Listentogether.UserReconnectedPayload ? (Listentogether.UserReconnectedPayload) generatedMessageLiteDecodePayload15 : null;
                                    if (userReconnectedPayload != null) {
                                        Listentogether.RoomState roomState16 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                        if (roomState16 != null) {
                                            Object value18 = stateFlowImpl6.getValue();
                                            value18.getClass();
                                            List<Listentogether.UserInfo> users3 = ProtocolKt.getUsers((Listentogether.RoomState) value18);
                                            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(users3, 10));
                                            for (Listentogether.UserInfo userInfoCopy$default : users3) {
                                                if (Intrinsics.areEqual(userInfoCopy$default.getUserId(), userReconnectedPayload.getUserId())) {
                                                    userInfoCopy$default = ProtocolKt.copy$default(userInfoCopy$default, false, true, 7);
                                                }
                                                arrayList4.add(userInfoCopy$default);
                                            }
                                            roomStateCopy$default12 = ProtocolKt.copy$default(roomState16, null, arrayList4, null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, 0L, 1019);
                                        } else {
                                            roomStateCopy$default12 = null;
                                        }
                                        stateFlowImpl6.setValue(roomStateCopy$default12);
                                        log(logLevel7, "User reconnected", userReconnectedPayload.getUsername());
                                        String userId8 = userReconnectedPayload.getUserId();
                                        userId8.getClass();
                                        String username4 = userReconnectedPayload.getUsername();
                                        username4.getClass();
                                        emitEvent(new ListenTogetherEvent.UserReconnected(userId8, username4));
                                    }
                                } else {
                                    logLevel2 = logLevel6;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case 1408227101:
                                if (str2.equals("host_changed")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload16 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.HostChangedPayload hostChangedPayload = generatedMessageLiteDecodePayload16 instanceof Listentogether.HostChangedPayload ? (Listentogether.HostChangedPayload) generatedMessageLiteDecodePayload16 : null;
                                    if (hostChangedPayload != null) {
                                        Listentogether.RoomState roomState17 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                        if (roomState17 != null) {
                                            String newHostId = hostChangedPayload.getNewHostId();
                                            newHostId.getClass();
                                            Object value19 = stateFlowImpl6.getValue();
                                            value19.getClass();
                                            List<Listentogether.UserInfo> users4 = ProtocolKt.getUsers((Listentogether.RoomState) value19);
                                            ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(users4, 10));
                                            for (Listentogether.UserInfo userInfo : users4) {
                                                arrayList5.add(ProtocolKt.copy$default(userInfo, Intrinsics.areEqual(userInfo.getUserId(), hostChangedPayload.getNewHostId()), false, 11));
                                            }
                                            roomStateCopy$default13 = ProtocolKt.copy$default(roomState17, newHostId, arrayList5, null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, 0L, 1017);
                                        } else {
                                            roomStateCopy$default13 = null;
                                        }
                                        stateFlowImpl6.setValue(roomStateCopy$default13);
                                        if (Intrinsics.areEqual(hostChangedPayload.getNewHostId(), stateFlowImpl4.getValue())) {
                                            stateFlowImpl5.setValue(roomRole3);
                                        } else if (stateFlowImpl5.getValue() == roomRole3) {
                                            stateFlowImpl5.setValue(roomRole2);
                                        }
                                        log(logLevel7, "Host changed", "New host: " + hostChangedPayload.getNewHostName());
                                        String newHostId2 = hostChangedPayload.getNewHostId();
                                        newHostId2.getClass();
                                        String newHostName = hostChangedPayload.getNewHostName();
                                        newHostName.getClass();
                                        emitEvent(new ListenTogetherEvent.HostChanged(newHostId2, newHostName));
                                    }
                                } else {
                                    logLevel2 = logLevel6;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case 1752158866:
                                if (str2.equals("suggestion_approved")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload17 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.SuggestionApprovedPayload suggestionApprovedPayload = generatedMessageLiteDecodePayload17 instanceof Listentogether.SuggestionApprovedPayload ? (Listentogether.SuggestionApprovedPayload) generatedMessageLiteDecodePayload17 : null;
                                    if (suggestionApprovedPayload != null) {
                                        log(logLevel7, "Suggestion approved", suggestionApprovedPayload.getTrackInfo().getTitle());
                                        Integer num3 = (Integer) linkedHashMap.remove(suggestionApprovedPayload.getSuggestionId());
                                        if (num3 != null) {
                                            new NotificationManagerCompat(context).cancel(num3.intValue());
                                        }
                                    }
                                } else {
                                    logLevel2 = logLevel6;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case 1791421999:
                                if (str2.equals("user_disconnected")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload18 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.UserDisconnectedPayload userDisconnectedPayload = generatedMessageLiteDecodePayload18 instanceof Listentogether.UserDisconnectedPayload ? (Listentogether.UserDisconnectedPayload) generatedMessageLiteDecodePayload18 : null;
                                    if (userDisconnectedPayload != null) {
                                        Listentogether.RoomState roomState18 = (Listentogether.RoomState) stateFlowImpl6.getValue();
                                        if (roomState18 != null) {
                                            Object value20 = stateFlowImpl6.getValue();
                                            value20.getClass();
                                            List<Listentogether.UserInfo> users5 = ProtocolKt.getUsers((Listentogether.RoomState) value20);
                                            ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(users5, 10));
                                            for (Listentogether.UserInfo userInfoCopy$default2 : users5) {
                                                if (Intrinsics.areEqual(userInfoCopy$default2.getUserId(), userDisconnectedPayload.getUserId())) {
                                                    userInfoCopy$default2 = ProtocolKt.copy$default(userInfoCopy$default2, false, false, 7);
                                                }
                                                arrayList6.add(userInfoCopy$default2);
                                            }
                                            roomStateCopy$default14 = ProtocolKt.copy$default(roomState18, null, arrayList6, null, false, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, 0L, 1019);
                                        } else {
                                            roomStateCopy$default14 = null;
                                        }
                                        stateFlowImpl6.setValue(roomStateCopy$default14);
                                        log(logLevel7, "User temporarily disconnected", userDisconnectedPayload.getUsername());
                                        String userId9 = userDisconnectedPayload.getUserId();
                                        userId9.getClass();
                                        String username5 = userDisconnectedPayload.getUsername();
                                        username5.getClass();
                                        emitEvent(new ListenTogetherEvent.UserDisconnected(userId9, username5));
                                    }
                                } else {
                                    logLevel2 = logLevel6;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case 1840114220:
                                if (str2.equals("join_approved")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload19 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.JoinApprovedPayload joinApprovedPayload = generatedMessageLiteDecodePayload19 instanceof Listentogether.JoinApprovedPayload ? (Listentogether.JoinApprovedPayload) generatedMessageLiteDecodePayload19 : null;
                                    if (joinApprovedPayload != null) {
                                        stateFlowImpl4.setValue(joinApprovedPayload.getUserId());
                                        stateFlowImpl5.setValue(roomRole2);
                                        this.sessionToken = joinApprovedPayload.getSessionToken();
                                        this.storedRoomCode = joinApprovedPayload.getRoomCode();
                                        this.wasHost = false;
                                        System.currentTimeMillis();
                                        stateFlowImpl6.setValue(joinApprovedPayload.getState());
                                        atomicLong.set(joinApprovedPayload.getState().getRevision());
                                        savePersistedSession();
                                        evaluateBackgroundDisconnectPolicy("join_approved");
                                        acquireWakeLock();
                                        log(logLevel7, "Joined room", "Code: " + joinApprovedPayload.getRoomCode());
                                        String roomCode4 = joinApprovedPayload.getRoomCode();
                                        roomCode4.getClass();
                                        String userId10 = joinApprovedPayload.getUserId();
                                        userId10.getClass();
                                        Listentogether.RoomState state2 = joinApprovedPayload.getState();
                                        state2.getClass();
                                        emitEvent(new ListenTogetherEvent.JoinApproved(roomCode4, userId10, state2));
                                    }
                                } else {
                                    logLevel2 = logLevel6;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            case 1948101754:
                                if (str2.equals("join_request")) {
                                    GeneratedMessageLite generatedMessageLiteDecodePayload20 = MessageCodec.decodePayload(str2, bArr2);
                                    Listentogether.JoinRequestPayload joinRequestPayload = generatedMessageLiteDecodePayload20 instanceof Listentogether.JoinRequestPayload ? (Listentogether.JoinRequestPayload) generatedMessageLiteDecodePayload20 : null;
                                    if (joinRequestPayload != null) {
                                        String username6 = joinRequestPayload.getUsername();
                                        username6.getClass();
                                        if (((Set) stateFlowImpl.getValue()).contains(username6)) {
                                            log(logLevel7, "Join request from blocked user ignored", "User: " + joinRequestPayload.getUsername());
                                            String userId11 = joinRequestPayload.getUserId();
                                            userId11.getClass();
                                            rejectJoin(userId11, "You are blocked");
                                        } else {
                                            stateFlowImpl3.setValue(CollectionsKt.plus(joinRequestPayload, (Collection) stateFlowImpl3.getValue()));
                                            log(logLevel7, "Join request received", "User: " + joinRequestPayload.getUsername());
                                            boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.ListenTogetherAutoApprovalKey, Boolean.FALSE)).booleanValue();
                                            if (stateFlowImpl5.getValue() == roomRole3) {
                                                if (zBooleanValue) {
                                                    log(logLevel7, "Auto-approving join request", "User: " + joinRequestPayload.getUsername());
                                                    String userId12 = joinRequestPayload.getUserId();
                                                    userId12.getClass();
                                                    approveJoin(userId12);
                                                } else if (NavUtils.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
                                                    showJoinRequestNotification(joinRequestPayload);
                                                }
                                            }
                                            String userId13 = joinRequestPayload.getUserId();
                                            userId13.getClass();
                                            String username7 = joinRequestPayload.getUsername();
                                            username7.getClass();
                                            emitEvent(new ListenTogetherEvent.JoinRequestReceived(userId13, username7));
                                        }
                                    }
                                } else {
                                    logLevel2 = logLevel6;
                                    log(logLevel2, "Unknown message type", str2);
                                }
                                break;
                            default:
                                logLevel2 = logLevel6;
                                log(logLevel2, "Unknown message type", str2);
                                break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    logLevel = context;
                    log(logLevel, "Error parsing message", e.getMessage());
                }
            } catch (Exception e4) {
                e = e4;
                logLevel = logLevel8;
                log(logLevel, "Error parsing message", e.getMessage());
            }
        } catch (Exception e5) {
            e = e5;
            logLevel = logLevel4;
        }
    }

    public final boolean isInRoom() {
        return this._roomState.getValue() != null;
    }

    public final void joinRoom(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.sessionApplyGeneration.incrementAndGet();
        this.lastPlaybackRevision.set(0L);
        clearPersistedSession();
        this.sessionToken = null;
        this.storedRoomCode = null;
        this.wasHost = false;
        this.storedUsername = str2;
        StateFlowImpl stateFlowImpl = this._connectionState;
        if (stateFlowImpl.getValue() == ConnectionState.CONNECTED) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            GeneratedMessageLite generatedMessageLiteBuild = Listentogether.JoinRoomPayload.newBuilder().setRoomCode(upperCase).setUsername(str2).m915build();
            generatedMessageLiteBuild.getClass();
            sendMessage("join_room", (Listentogether.JoinRoomPayload) generatedMessageLiteBuild);
            return;
        }
        log(LogLevel.INFO, "Not connected, queueing join room action", null);
        this.pendingAction = new PendingAction$JoinRoom(str, str2);
        evaluateBackgroundDisconnectPolicy("join_room_queued");
        if (stateFlowImpl.getValue() == ConnectionState.DISCONNECTED || stateFlowImpl.getValue() == ConnectionState.ERROR) {
            connect();
        }
    }

    public final void log(LogLevel logLevel, String str, String str2) {
        String str3 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        str3.getClass();
        LogEntry logEntry = new LogEntry(str3, logLevel, str, str2);
        StateFlowImpl stateFlowImpl = this._logs;
        List listTakeLast = CollectionsKt.takeLast(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, CollectionsKt.plus(logEntry, (Collection) stateFlowImpl.getValue()));
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, listTakeLast);
        int iOrdinal = logLevel.ordinal();
        if (iOrdinal == 0) {
            Timber.Forest.tag("ListenTogether");
            ConnectionPool.i(new Object[0]);
            return;
        }
        if (iOrdinal == 1) {
            Timber.Forest.tag("ListenTogether");
            ConnectionPool.w(new Object[0]);
        } else if (iOrdinal == 2) {
            Timber.Forest.tag("ListenTogether");
            ConnectionPool.e(new Object[0]);
        } else if (iOrdinal != 3) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
        } else {
            Timber.Forest.tag("ListenTogether");
            ConnectionPool.d(new Object[0]);
        }
    }

    public final long positionAtServerTime$app(long j, Long l, boolean z) {
        Long lNow;
        HeadersReader headersReader = this.serverClock;
        headersReader.getClass();
        return (!z || l == null || l.longValue() <= 0 || (lNow = headersReader.now()) == null) ? j : Math.max(0L, lNow.longValue() - l.longValue()) + j;
    }

    public final void rejectJoin(String str, String str2) {
        if (this._role.getValue() != RoomRole.HOST) {
            log(LogLevel.ERROR, "Cannot reject join", "Not host");
            return;
        }
        Listentogether.RejectJoinPayload.Builder userId = Listentogether.RejectJoinPayload.newBuilder().setUserId(str);
        if (str2 == null) {
            str2 = "";
        }
        GeneratedMessageLite generatedMessageLiteBuild = userId.setReason(str2).m915build();
        generatedMessageLiteBuild.getClass();
        sendMessage("reject_join", (Listentogether.RejectJoinPayload) generatedMessageLiteBuild);
        StateFlowImpl stateFlowImpl = this._pendingJoinRequests;
        Iterable iterable = (Iterable) stateFlowImpl.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!Intrinsics.areEqual(((Listentogether.JoinRequestPayload) obj).getUserId(), str)) {
                arrayList.add(obj);
            }
        }
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, arrayList);
        Integer num = (Integer) this.joinRequestNotifications.remove(str);
        if (num != null) {
            new NotificationManagerCompat(this.context).cancel(num.intValue());
        }
    }

    public final void rejectSuggestion(String str, String str2) {
        if (this._role.getValue() != RoomRole.HOST) {
            log(LogLevel.ERROR, "Cannot reject suggestion", "Not host");
            return;
        }
        Listentogether.RejectSuggestionPayload.Builder suggestionId = Listentogether.RejectSuggestionPayload.newBuilder().setSuggestionId(str);
        if (str2 == null) {
            str2 = "";
        }
        GeneratedMessageLite generatedMessageLiteBuild = suggestionId.setReason(str2).m915build();
        generatedMessageLiteBuild.getClass();
        sendMessage("reject_suggestion", (Listentogether.RejectSuggestionPayload) generatedMessageLiteBuild);
        StateFlowImpl stateFlowImpl = this._pendingSuggestions;
        Iterable iterable = (Iterable) stateFlowImpl.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!Intrinsics.areEqual(((Listentogether.SuggestionReceivedPayload) obj).getSuggestionId(), str)) {
                arrayList.add(obj);
            }
        }
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, arrayList);
        Integer num = (Integer) this.suggestionNotifications.remove(str);
        if (num != null) {
            new NotificationManagerCompat(this.context).cancel(num.intValue());
        }
    }

    public final void releaseWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
        log(LogLevel.DEBUG, "Wake lock released", null);
    }

    public final void requestSync() {
        if (this._roomState.getValue() == null) {
            log(LogLevel.ERROR, "Cannot request sync", "Not in room");
        } else {
            log(LogLevel.INFO, "Requesting sync state from server", null);
            sendMessage("request_sync", null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6 */
    public final Object saveBlockedUsernames(ContinuationImpl continuationImpl) {
        C01501 c01501;
        if (continuationImpl instanceof C01501) {
            c01501 = (C01501) continuationImpl;
            int i = c01501.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01501.label = i - Integer.MIN_VALUE;
            } else {
                c01501 = new C01501(continuationImpl);
            }
        } else {
            c01501 = new C01501(continuationImpl);
        }
        Object obj = c01501.result;
        int i2 = c01501.label;
        Continuation continuation = null;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                JsonImpl jsonImpl = this.json;
                List list = CollectionsKt.toList((Iterable) this._blockedUsernames.getValue());
                jsonImpl.getClass();
                String strEncodeToString = jsonImpl.encodeToString(new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1), list);
                Context context = this.context;
                App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$1 = new App$observeSettingsChanges$1$2$2$1(strEncodeToString, continuation, (byte) 2);
                c01501.label = 1;
                Object objSafeDataStoreEdit = UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$1, c01501);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                this = objSafeDataStoreEdit;
                if (objSafeDataStoreEdit == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this = this;
            }
        } catch (Exception e) {
            this.log(LogLevel.ERROR, "Failed to save blocked usernames", e.getMessage());
        }
        return Unit.INSTANCE;
    }

    public final void savePersistedSession() {
        try {
            AwaitKt.launch$default(this.scope, null, null, new ListenTogetherClient$blockUser$3(this, null, (byte) 6), 3);
        } catch (Exception e) {
            log(LogLevel.ERROR, "Failed to save persisted session", e.getMessage());
        }
    }

    public final void sendBufferReady(String str) {
        String string = StringsKt.trim(str).toString();
        if (string.length() == 0) {
            log(LogLevel.WARNING, "Skipping buffer ready", "Track ID is blank");
            return;
        }
        GeneratedMessageLite generatedMessageLiteBuild = Listentogether.BufferReadyPayload.newBuilder().setTrackId(string).m915build();
        generatedMessageLiteBuild.getClass();
        sendMessage("buffer_ready", (Listentogether.BufferReadyPayload) generatedMessageLiteBuild);
    }

    public final void sendMessage(String str, GeneratedMessageLite generatedMessageLite) {
        boolean zSend;
        LogLevel logLevel = LogLevel.ERROR;
        try {
            byte[] bArrEncode = this.codec.encode(str, generatedMessageLite);
            log(LogLevel.DEBUG, "Sending message", str.concat(" (protobuf)"));
            RealWebSocket realWebSocket = this.webSocket;
            if (realWebSocket != null) {
                ByteString byteString = ByteString.EMPTY;
                byte[] bArrCopyOf = Arrays.copyOf(bArrEncode, bArrEncode.length);
                zSend = realWebSocket.send(2, new ByteString(Arrays.copyOf(bArrCopyOf, bArrCopyOf.length)));
            } else {
                zSend = false;
            }
            if (zSend) {
                return;
            }
            log(logLevel, "Failed to send message", str);
        } catch (Exception e) {
            log(logLevel, "Error encoding message", IntIntPair$$ExternalSyntheticOutline0.m(str, ": ", e.getMessage()));
        }
    }

    public final void sendTimeSyncPing() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        GeneratedMessageLite generatedMessageLiteBuild = Listentogether.PingPayload.newBuilder().setClientTime(jElapsedRealtime).setSequence(this.pingSequence.incrementAndGet()).m915build();
        generatedMessageLiteBuild.getClass();
        sendMessage("ping", (Listentogether.PingPayload) generatedMessageLiteBuild);
    }

    public final boolean shouldDisconnectForBackgroundIdle() {
        StateFlowImpl stateFlowImpl = this._connectionState;
        return ProcessLifecycleOwner.newInstance.registry.state.compareTo(Lifecycle.State.STARTED) < 0 && this._roomState.getValue() == null && this.pendingAction == null && (stateFlowImpl.getValue() == ConnectionState.CONNECTED || stateFlowImpl.getValue() == ConnectionState.CONNECTING || stateFlowImpl.getValue() == ConnectionState.RECONNECTING);
    }

    public final void showJoinRequestNotification(Listentogether.JoinRequestPayload joinRequestPayload) {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() % 2147483647L);
        this.joinRequestNotifications.put(joinRequestPayload.getUserId(), Integer.valueOf(iCurrentTimeMillis));
        Context context = this.context;
        Intent intent = new Intent(context, (Class<?>) ListenTogetherActionReceiver.class);
        intent.setAction("com.metrolist.music.LISTEN_TOGETHER_APPROVE_JOIN");
        intent.putExtra("extra_user_id", joinRequestPayload.getUserId());
        intent.putExtra("extra_notification_id", iCurrentTimeMillis);
        Intent intent2 = new Intent(context, (Class<?>) ListenTogetherActionReceiver.class);
        intent2.setAction("com.metrolist.music.LISTEN_TOGETHER_REJECT_JOIN");
        intent2.putExtra("extra_user_id", joinRequestPayload.getUserId());
        intent2.putExtra("extra_notification_id", iCurrentTimeMillis);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, joinRequestPayload.getUserId().hashCode(), intent, 201326592);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, ~joinRequestPayload.getUserId().hashCode(), intent2, 201326592);
        String string = context.getString(R.string.listen_together_join_request_notification, joinRequestPayload.getUsername());
        string.getClass();
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, "listen_together_channel");
        notificationCompat$Builder.mNotification.icon = R.drawable.share;
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(context.getString(R.string.listen_together));
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(string);
        notificationCompat$Builder.mPriority = 1;
        notificationCompat$Builder.setFlag(16, true);
        notificationCompat$Builder.addAction(context.getString(R.string.approve), broadcast);
        notificationCompat$Builder.addAction(context.getString(R.string.reject), broadcast2);
        if (NavUtils.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            new NotificationManagerCompat(context).notify(iCurrentTimeMillis, notificationCompat$Builder.build());
        }
    }

    public final void showSuggestionNotification(Listentogether.SuggestionReceivedPayload suggestionReceivedPayload) {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() % 2147483647L);
        this.suggestionNotifications.put(suggestionReceivedPayload.getSuggestionId(), Integer.valueOf(iCurrentTimeMillis));
        Context context = this.context;
        Intent intent = new Intent(context, (Class<?>) ListenTogetherActionReceiver.class);
        intent.setAction("com.metrolist.music.LISTEN_TOGETHER_APPROVE_SUGGESTION");
        intent.putExtra("extra_suggestion_id", suggestionReceivedPayload.getSuggestionId());
        intent.putExtra("extra_notification_id", iCurrentTimeMillis);
        Intent intent2 = new Intent(context, (Class<?>) ListenTogetherActionReceiver.class);
        intent2.setAction("com.metrolist.music.LISTEN_TOGETHER_REJECT_SUGGESTION");
        intent2.putExtra("extra_suggestion_id", suggestionReceivedPayload.getSuggestionId());
        intent2.putExtra("extra_notification_id", iCurrentTimeMillis);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, suggestionReceivedPayload.getSuggestionId().hashCode(), intent, 201326592);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, ~suggestionReceivedPayload.getSuggestionId().hashCode(), intent2, 201326592);
        String string = context.getString(R.string.listen_together_suggestion_received, suggestionReceivedPayload.getFromUsername(), suggestionReceivedPayload.getTrackInfo().getTitle());
        string.getClass();
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, "listen_together_channel");
        notificationCompat$Builder.mNotification.icon = R.drawable.share;
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(context.getString(R.string.listen_together));
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(string);
        notificationCompat$Builder.mPriority = 1;
        notificationCompat$Builder.setFlag(16, true);
        notificationCompat$Builder.addAction(context.getString(R.string.approve), broadcast);
        notificationCompat$Builder.addAction(context.getString(R.string.reject), broadcast2);
        if (NavUtils.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            new NotificationManagerCompat(context).notify(iCurrentTimeMillis, notificationCompat$Builder.build());
        }
    }
}
