package com.metrolist.music.playback;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlayerImpl;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.queues.Queue;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda117;
import com.metrolist.music.utils.UtilsKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerConnection implements Player.Listener {
    public volatile boolean allowInternalSync;
    public ExoPlayerImpl attachedPlayer;
    public final StateFlowImpl canSkipNext;
    public final StateFlowImpl canSkipPrevious;
    public final ReadonlyStateFlow currentFormat;
    public final ReadonlyStateFlow currentLyrics;
    public final StateFlowImpl currentMediaItemIndex;
    public final ReadonlyStateFlow currentSong;
    public final StateFlowImpl currentStreamClient;
    public final StateFlowImpl currentWindowIndex;
    public final MusicDatabase database;
    public final StateFlowImpl error;
    public final ReadonlyStateFlow isEffectivelyPlaying;
    public final StateFlowImpl isMuted;
    public final StateFlowImpl isPlayerInitialized;
    public final ReadonlyStateFlow isPlaying;
    public final StateFlowImpl mediaMetadata;
    public ComponentRegistry$Builder$$ExternalSyntheticLambda2 onRestartSong;
    public final StateFlowImpl playWhenReady;
    public final StateFlowImpl playbackState;
    public final ReadonlyStateFlow playerReadinessFlow;
    public final StateFlowImpl queueTitle;
    public final StateFlowImpl queueWindows;
    public final StateFlowImpl repeatMode;
    public final MusicService service;
    public PlayerMenuKt$$ExternalSyntheticLambda117 shouldBlockPlaybackChanges;
    public final StateFlowImpl shuffleModeEnabled;

    /* JADX INFO: renamed from: com.metrolist.music.playback.PlayerConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function3 {
        public /* synthetic */ int I$0;
        public /* synthetic */ boolean Z$0;

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            int iIntValue = ((Number) obj).intValue();
            boolean zBooleanValue = ((Boolean) obj2).booleanValue();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(3, (Continuation) obj3);
            anonymousClass1.I$0 = iIntValue;
            anonymousClass1.Z$0 = zBooleanValue;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.I$0;
            boolean z = this.Z$0;
            ResultKt.throwOnFailure(obj);
            return Boolean.valueOf(z && i != 4);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.PlayerConnection$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ PlayerConnection this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(byte b, PlayerConnection playerConnection, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = playerConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            PlayerConnection playerConnection = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass2((byte) 0, playerConnection, continuation);
                default:
                    return new AnonymousClass2((byte) 1, playerConnection, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
            }
            return coroutineSingletons;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            final PlayerConnection playerConnection = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            final byte b2 = 1;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (z) {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    ReadonlyStateFlow readonlyStateFlow = playerConnection.playerReadinessFlow;
                    final byte b3 = 0;
                    FlowCollector flowCollector = new FlowCollector() { // from class: com.metrolist.music.playback.PlayerConnection.2.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) {
                            byte b4 = b3;
                            Unit unit = Unit.INSTANCE;
                            PlayerConnection playerConnection2 = playerConnection;
                            switch (b4) {
                                case 0:
                                    Boolean bool = (Boolean) obj2;
                                    boolean zBooleanValue = bool.booleanValue();
                                    StateFlowImpl stateFlowImpl = playerConnection2.isPlayerInitialized;
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, bool);
                                    if (zBooleanValue) {
                                        Timber.Forest.tag("PlayerConnection");
                                        ConnectionPool.d(new Object[0]);
                                    }
                                    break;
                                default:
                                    ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) obj2;
                                    if (exoPlayerImpl != null && exoPlayerImpl != playerConnection2.attachedPlayer) {
                                        playerConnection2.updateAttachedPlayer(exoPlayerImpl);
                                    }
                                    break;
                            }
                            return unit;
                        }
                    };
                    this.label = true;
                    if (readonlyStateFlow.$$delegate_0.collect(flowCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
                default:
                    boolean z2 = this.label;
                    if (z2) {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    ReadonlyStateFlow readonlyStateFlow2 = playerConnection.service.playerFlow;
                    FlowCollector flowCollector2 = new FlowCollector() { // from class: com.metrolist.music.playback.PlayerConnection.2.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) {
                            byte b4 = b2;
                            Unit unit = Unit.INSTANCE;
                            PlayerConnection playerConnection2 = playerConnection;
                            switch (b4) {
                                case 0:
                                    Boolean bool = (Boolean) obj2;
                                    boolean zBooleanValue = bool.booleanValue();
                                    StateFlowImpl stateFlowImpl = playerConnection2.isPlayerInitialized;
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, bool);
                                    if (zBooleanValue) {
                                        Timber.Forest.tag("PlayerConnection");
                                        ConnectionPool.d(new Object[0]);
                                    }
                                    break;
                                default:
                                    ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) obj2;
                                    if (exoPlayerImpl != null && exoPlayerImpl != playerConnection2.attachedPlayer) {
                                        playerConnection2.updateAttachedPlayer(exoPlayerImpl);
                                    }
                                    break;
                            }
                            return unit;
                        }
                    };
                    this.label = true;
                    if (readonlyStateFlow2.$$delegate_0.collect(flowCollector2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
            }
        }
    }

    public PlayerConnection(Context context, MusicService.MusicBinder musicBinder, MusicDatabase musicDatabase, LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl) {
        Triple triple;
        byte b = 1;
        this.database = musicDatabase;
        MusicService musicService = MusicService.this;
        this.service = musicService;
        ReadonlyStateFlow readonlyStateFlow = musicService.isPlayerReady;
        this.playerReadinessFlow = readonlyStateFlow;
        this.isPlayerInitialized = StateFlowKt.MutableStateFlow(readonlyStateFlow.$$delegate_0.getValue());
        byte b2 = 0;
        try {
            ExoPlayerImpl playerOrNull = getPlayerOrNull();
            if (playerOrNull != null) {
                triple = new Triple(Integer.valueOf(playerOrNull.getPlaybackState()), Boolean.valueOf(playerOrNull.getPlayWhenReady()), Boolean.valueOf(playerOrNull.getPlayWhenReady() && playerOrNull.getPlaybackState() != 4));
            } else {
                Timber.Forest.tag("PlayerConnection");
                ConnectionPool.w(new Object[0]);
                Boolean bool = Boolean.FALSE;
                triple = new Triple(1, bool, bool);
            }
        } catch (Exception unused) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
            Boolean bool2 = Boolean.FALSE;
            triple = new Triple(1, bool2, bool2);
        }
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("PlayerConnection");
        Objects.toString(this.playerReadinessFlow.$$delegate_0.getValue());
        ConnectionPool.d(new Object[0]);
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(triple.first);
        this.playbackState = stateFlowImplMutableStateFlow;
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(triple.second);
        this.playWhenReady = stateFlowImplMutableStateFlow2;
        Continuation continuation = null;
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 flowKt__ZipKt$combine$$inlined$unsafeFlow$1 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(stateFlowImplMutableStateFlow, stateFlowImplMutableStateFlow2, new AnonymousClass1(3, null), (byte) 0);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        Object obj = triple.third;
        ReadonlyStateFlow readonlyStateFlowStateIn = StateFlowKt.stateIn(flowKt__ZipKt$combine$$inlined$unsafeFlow$1, lifecycleCoroutineScopeImpl, startedLazily, obj);
        this.isPlaying = readonlyStateFlowStateIn;
        AwaitKt.launch$default(lifecycleCoroutineScopeImpl, null, null, new AnonymousClass2(b2, this, continuation), 3);
        connectionPool.tag("PlayerConnection");
        ConnectionPool.d(new Object[0]);
        CastConnectionHandler castConnectionHandler = this.service.castConnectionHandler;
        StateFlowImpl stateFlowImplMutableStateFlow3 = castConnectionHandler != null ? castConnectionHandler.isCasting : StateFlowKt.MutableStateFlow(Boolean.FALSE);
        CastConnectionHandler castConnectionHandler2 = this.service.castConnectionHandler;
        this.isEffectivelyPlaying = StateFlowKt.stateIn(StateFlowKt.combine(readonlyStateFlowStateIn, stateFlowImplMutableStateFlow3, castConnectionHandler2 != null ? castConnectionHandler2.castIsPlaying : StateFlowKt.MutableStateFlow(Boolean.FALSE), new PlayerConnection$isEffectivelyPlaying$1(4, null)), lifecycleCoroutineScopeImpl, startedLazily, obj);
        ExoPlayerImpl playerOrNull2 = getPlayerOrNull();
        StateFlowImpl stateFlowImplMutableStateFlow4 = StateFlowKt.MutableStateFlow(playerOrNull2 != null ? IntMath.getCurrentMetadata(playerOrNull2) : null);
        this.mediaMetadata = stateFlowImplMutableStateFlow4;
        this.currentSong = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(stateFlowImplMutableStateFlow4, new PlayerConnection$special$$inlined$flatMapLatest$1(b2, this, continuation)), lifecycleCoroutineScopeImpl, startedLazily, null);
        this.currentLyrics = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(stateFlowImplMutableStateFlow4, new PlayerConnection$special$$inlined$flatMapLatest$1(b, this, continuation)), lifecycleCoroutineScopeImpl, startedLazily, null);
        this.currentFormat = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(stateFlowImplMutableStateFlow4, new PlayerConnection$special$$inlined$flatMapLatest$1((byte) 2, this, continuation)), lifecycleCoroutineScopeImpl, startedLazily, null);
        this.queueTitle = StateFlowKt.MutableStateFlow(null);
        this.queueWindows = StateFlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this.currentMediaItemIndex = StateFlowKt.MutableStateFlow(-1);
        this.currentWindowIndex = StateFlowKt.MutableStateFlow(-1);
        this.shuffleModeEnabled = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.repeatMode = StateFlowKt.MutableStateFlow(0);
        Boolean bool3 = Boolean.TRUE;
        this.canSkipPrevious = StateFlowKt.MutableStateFlow(bool3);
        this.canSkipNext = StateFlowKt.MutableStateFlow(bool3);
        this.error = StateFlowKt.MutableStateFlow(null);
        MusicService musicService2 = this.service;
        this.isMuted = musicService2.isMuted;
        this.currentStreamClient = musicService2.currentStreamClient;
        AwaitKt.launch$default(lifecycleCoroutineScopeImpl, null, null, new AnonymousClass2(b, this, continuation), 3);
        ExoPlayerImpl playerOrNull3 = getPlayerOrNull();
        if (this.attachedPlayer == null && playerOrNull3 != null) {
            updateAttachedPlayer(playerOrNull3);
        }
        connectionPool.tag("PlayerConnection");
        Objects.toString(this.playerReadinessFlow.$$delegate_0.getValue());
        ConnectionPool.d(new Object[0]);
    }

    public static Map parseDayTimes(String str) {
        Integer intOrNull;
        if (StringsKt.isBlank(str)) {
            return EmptyMap.INSTANCE;
        }
        List listSplit$default = StringsKt.split$default(str, new String[]{";"}, 0, 6);
        ArrayList arrayList = new ArrayList();
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt.split$default((String) it.next(), new String[]{"="}, 0, 6);
            Pair pair = null;
            if (listSplit$default2.size() == 2 && (intOrNull = StringsKt__StringsJVMKt.toIntOrNull((String) listSplit$default2.get(0))) != null) {
                List listSplit$default3 = StringsKt.split$default((CharSequence) listSplit$default2.get(1), new String[]{"-"}, 0, 6);
                if (listSplit$default3.size() == 2) {
                    pair = new Pair(intOrNull, new Pair(listSplit$default3.get(0), listSplit$default3.get(1)));
                }
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    public final void addToQueue(List list) throws Exception {
        PlayerMenuKt$$ExternalSyntheticLambda117 playerMenuKt$$ExternalSyntheticLambda117;
        if (!this.allowInternalSync && (playerMenuKt$$ExternalSyntheticLambda117 = this.shouldBlockPlaybackChanges) != null && ((Boolean) playerMenuKt$$ExternalSyntheticLambda117.invoke()).booleanValue()) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.d(new Object[0]);
            return;
        }
        try {
            this.service.addToQueue(list);
        } catch (Exception e) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
            throw e;
        }
    }

    public final void dispose() {
        try {
            ExoPlayerImpl exoPlayerImpl = this.attachedPlayer;
            if (exoPlayerImpl != null) {
                exoPlayerImpl.removeListener(this);
            }
            this.attachedPlayer = null;
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.d(new Object[0]);
        } catch (Exception unused) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    public final ExoPlayerImpl getPlayerOrNull() {
        try {
            if (((Boolean) this.playerReadinessFlow.$$delegate_0.getValue()).booleanValue()) {
                return this.service.player;
            }
            return null;
        } catch (NullPointerException | UninitializedPropertyAccessException unused) {
            return null;
        }
    }

    public final ExoPlayerImpl getPlayerSafe() {
        ReadonlyStateFlow readonlyStateFlow = this.playerReadinessFlow;
        if (!((Boolean) readonlyStateFlow.$$delegate_0.getValue()).booleanValue()) {
            PathKt$$ExternalSyntheticBUOutline0.m$2(readonlyStateFlow.$$delegate_0.getValue(), "Player not yet initialized in MusicService; service.isPlayerReady=");
            return null;
        }
        try {
            return this.service.player;
        } catch (UninitializedPropertyAccessException e) {
            throw new IllegalStateException("MusicService.player field not initialized despite isPlayerReady=true; possible race condition in service startup", e);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onMediaItemTransition(int i, MediaItem mediaItem) {
        this.mediaMetadata.setValue(mediaItem != null ? UuidKt.getMetadata(mediaItem) : null);
        Integer numValueOf = Integer.valueOf(getPlayerSafe().getCurrentMediaItemIndex());
        StateFlowImpl stateFlowImpl = this.currentMediaItemIndex;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, numValueOf);
        Integer numValueOf2 = Integer.valueOf(IntMath.getCurrentQueueIndex(getPlayerSafe()));
        StateFlowImpl stateFlowImpl2 = this.currentWindowIndex;
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, numValueOf2);
        updateCanSkipPreviousAndNext();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0138  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.media3.common.Player.Listener
    public final void onPlayWhenReadyChanged(int i, boolean z) {
        ConnectionPool connectionPool;
        boolean zContains;
        Pair pair;
        StateFlowImpl stateFlowImpl = this.playWhenReady;
        boolean zBooleanValue = ((Boolean) stateFlowImpl.getValue()).booleanValue();
        Boolean boolValueOf = Boolean.valueOf(z);
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, boolValueOf);
        if (!z || zBooleanValue) {
            return;
        }
        MusicService musicService = this.service;
        try {
            Context applicationContext = musicService.getApplicationContext();
            applicationContext.getClass();
            Boolean bool = (Boolean) UtilsKt.get(UtilsKt.getDataStore(applicationContext), PreferenceKeysKt.SleepTimerEnabledKey);
            boolean zBooleanValue2 = bool != null ? bool.booleanValue() : false;
            ConnectionPool connectionPool2 = Timber.Forest;
            connectionPool2.tag("PlayerConnection");
            ConnectionPool.d(new Object[0]);
            if (!zBooleanValue2) {
                connectionPool2.tag("PlayerConnection");
                ConnectionPool.d(new Object[0]);
                return;
            }
            SleepTimer sleepTimer = musicService.sleepTimer;
            if (sleepTimer != null && sleepTimer.isActive()) {
                connectionPool2.tag("PlayerConnection");
                ConnectionPool.d(new Object[0]);
                return;
            }
            Context applicationContext2 = musicService.getApplicationContext();
            applicationContext2.getClass();
            String str = (String) UtilsKt.get(UtilsKt.getDataStore(applicationContext2), PreferenceKeysKt.SleepTimerRepeatKey);
            if (str == null) {
                str = "daily";
            }
            Context applicationContext3 = musicService.getApplicationContext();
            applicationContext3.getClass();
            String str2 = (String) UtilsKt.get(UtilsKt.getDataStore(applicationContext3), PreferenceKeysKt.SleepTimerStartTimeKey);
            if (str2 == null) {
                str2 = "09:00";
            }
            Context applicationContext4 = musicService.getApplicationContext();
            applicationContext4.getClass();
            String str3 = (String) UtilsKt.get(UtilsKt.getDataStore(applicationContext4), PreferenceKeysKt.SleepTimerEndTimeKey);
            if (str3 == null) {
                str3 = "23:00";
            }
            Context applicationContext5 = musicService.getApplicationContext();
            applicationContext5.getClass();
            Float f = (Float) UtilsKt.get(UtilsKt.getDataStore(applicationContext5), PreferenceKeysKt.SleepTimerDefaultKey);
            int iRoundToInt = MathKt.roundToInt(f != null ? f.floatValue() : 30.0f);
            Context applicationContext6 = musicService.getApplicationContext();
            applicationContext6.getClass();
            String str4 = (String) UtilsKt.get(UtilsKt.getDataStore(applicationContext6), PreferenceKeysKt.SleepTimerCustomDaysKey);
            if (str4 == null) {
                str4 = "0,1,2,3,4";
            }
            Context applicationContext7 = musicService.getApplicationContext();
            applicationContext7.getClass();
            String str5 = (String) UtilsKt.get(UtilsKt.getDataStore(applicationContext7), PreferenceKeysKt.SleepTimerDayTimesKey);
            if (str5 == null) {
                str5 = "";
            }
            connectionPool2.tag("PlayerConnection");
            ConnectionPool.d(new Object[0]);
            LocalTime localTimeNow = LocalTime.now();
            int value = LocalDate.now().getDayOfWeek().getValue() % 7;
            int i2 = value == 0 ? 6 : value - 1;
            connectionPool2.tag("PlayerConnection");
            Objects.toString(localTimeNow);
            ConnectionPool.d(new Object[0]);
            switch (str.hashCode()) {
                case -1349088399:
                    if (!str.equals("custom")) {
                        connectionPool = connectionPool2;
                        zContains = false;
                    } else {
                        List listSplit$default = StringsKt.split$default(str4, new String[]{","}, 0, 6);
                        ArrayList arrayList = new ArrayList();
                        Iterator it = listSplit$default.iterator();
                        while (it.hasNext()) {
                            Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull(StringsKt.trim((String) it.next()).toString());
                            if (intOrNull != null) {
                                arrayList.add(intOrNull);
                            }
                        }
                        connectionPool = Timber.Forest;
                        connectionPool.tag("PlayerConnection");
                        arrayList.toString();
                        ConnectionPool.d(new Object[0]);
                        zContains = arrayList.contains(Integer.valueOf(i2));
                    }
                    break;
                case -621971893:
                    if (str.equals("weekdays")) {
                        if (i2 >= 0 && i2 < 5) {
                            connectionPool = connectionPool2;
                            zContains = true;
                            break;
                        }
                    }
                    connectionPool = connectionPool2;
                    zContains = false;
                    break;
                case -621930260:
                    if (str.equals("weekends")) {
                        if (5 <= i2 && i2 < 7) {
                            connectionPool = connectionPool2;
                            zContains = true;
                            break;
                        }
                    }
                    connectionPool = connectionPool2;
                    zContains = false;
                    break;
                case 95346201:
                    if (!str.equals("daily")) {
                        connectionPool = connectionPool2;
                        zContains = false;
                    } else {
                        connectionPool = connectionPool2;
                        zContains = true;
                    }
                    break;
                case 1806612576:
                    if (!str.equals("weekdays_weekends")) {
                        connectionPool = connectionPool2;
                        zContains = false;
                    } else {
                        connectionPool = connectionPool2;
                        zContains = true;
                    }
                    break;
                default:
                    connectionPool = connectionPool2;
                    zContains = false;
                    break;
            }
            if (!zContains) {
                connectionPool.tag("PlayerConnection");
                ConnectionPool.d(new Object[0]);
                return;
            }
            DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("HH:mm");
            if (str.equals("daily") || (pair = (Pair) parseDayTimes(str5).get(Integer.valueOf(i2))) == null) {
                pair = new Pair(str2, str3);
            }
            String str6 = (String) pair.first;
            String str7 = (String) pair.second;
            LocalTime localTime = LocalTime.parse(str6, dateTimeFormatterOfPattern);
            LocalTime localTime2 = LocalTime.parse(str7, dateTimeFormatterOfPattern);
            boolean z2 = !localTime2.isAfter(localTime) ? !(localTimeNow.isAfter(localTime) || localTimeNow.isBefore(localTime2)) : !(localTimeNow.isAfter(localTime) && localTimeNow.isBefore(localTime2));
            connectionPool.tag("PlayerConnection");
            Objects.toString(localTimeNow);
            ConnectionPool.d(new Object[0]);
            if (!z2) {
                connectionPool.tag("PlayerConnection");
                ConnectionPool.d(new Object[0]);
                return;
            }
            connectionPool.tag("PlayerConnection");
            ConnectionPool.i(new Object[0]);
            SleepTimer sleepTimer2 = musicService.sleepTimer;
            if (sleepTimer2 != null) {
                sleepTimer2.start(iRoundToInt, false, false);
            }
        } catch (Exception unused) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        Integer numValueOf = Integer.valueOf(i);
        StateFlowImpl stateFlowImpl = this.playbackState;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, numValueOf);
        ExoPlayerImpl playerSafe = getPlayerSafe();
        playerSafe.verifyApplicationThread();
        this.error.setValue(playerSafe.playbackInfo.playbackError);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlayerErrorChanged(PlaybackException playbackException) {
        if (playbackException != null) {
            playbackException.printStackTrace();
        }
        this.error.setValue(playbackException);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onRepeatModeChanged(int i) {
        ExoPlayerImpl playerSafe = getPlayerSafe();
        playerSafe.verifyApplicationThread();
        if (i != playerSafe.repeatMode) {
            return;
        }
        Integer numValueOf = Integer.valueOf(i);
        StateFlowImpl stateFlowImpl = this.repeatMode;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, numValueOf);
        updateCanSkipPreviousAndNext();
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onShuffleModeEnabledChanged(boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        StateFlowImpl stateFlowImpl = this.shuffleModeEnabled;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, boolValueOf);
        List queueWindows = IntMath.getQueueWindows(getPlayerSafe());
        StateFlowImpl stateFlowImpl2 = this.queueWindows;
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, queueWindows);
        Integer numValueOf = Integer.valueOf(IntMath.getCurrentQueueIndex(getPlayerSafe()));
        StateFlowImpl stateFlowImpl3 = this.currentWindowIndex;
        stateFlowImpl3.getClass();
        stateFlowImpl3.updateState(null, numValueOf);
        updateCanSkipPreviousAndNext();
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onTimelineChanged(Timeline timeline, int i) {
        timeline.getClass();
        List queueWindows = IntMath.getQueueWindows(getPlayerSafe());
        StateFlowImpl stateFlowImpl = this.queueWindows;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, queueWindows);
        this.queueTitle.setValue(this.service.queueTitle);
        Integer numValueOf = Integer.valueOf(getPlayerSafe().getCurrentMediaItemIndex());
        StateFlowImpl stateFlowImpl2 = this.currentMediaItemIndex;
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, numValueOf);
        Integer numValueOf2 = Integer.valueOf(IntMath.getCurrentQueueIndex(getPlayerSafe()));
        StateFlowImpl stateFlowImpl3 = this.currentWindowIndex;
        stateFlowImpl3.getClass();
        stateFlowImpl3.updateState(null, numValueOf2);
        updateCanSkipPreviousAndNext();
    }

    public final void pause() {
        try {
            CastConnectionHandler castConnectionHandler = this.service.castConnectionHandler;
            if (castConnectionHandler == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
                getPlayerSafe().setPlayWhenReady(false);
            }
        } catch (Exception unused) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    public final void play() {
        try {
            CastConnectionHandler castConnectionHandler = this.service.castConnectionHandler;
            if (castConnectionHandler == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
                if (getPlayerSafe().getPlaybackState() == 1) {
                    getPlayerSafe().prepare();
                }
                getPlayerSafe().setPlayWhenReady(true);
            }
        } catch (Exception unused) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    public final void playNext(List list) {
        PlayerMenuKt$$ExternalSyntheticLambda117 playerMenuKt$$ExternalSyntheticLambda117;
        if (!this.allowInternalSync && (playerMenuKt$$ExternalSyntheticLambda117 = this.shouldBlockPlaybackChanges) != null && ((Boolean) playerMenuKt$$ExternalSyntheticLambda117.invoke()).booleanValue()) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.d(new Object[0]);
            return;
        }
        try {
            this.service.playNext(list);
        } catch (Exception e) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
            throw e;
        }
    }

    public final void playQueue(Queue queue) {
        PlayerMenuKt$$ExternalSyntheticLambda117 playerMenuKt$$ExternalSyntheticLambda117;
        queue.getClass();
        if (!this.allowInternalSync && (playerMenuKt$$ExternalSyntheticLambda117 = this.shouldBlockPlaybackChanges) != null && ((Boolean) playerMenuKt$$ExternalSyntheticLambda117.invoke()).booleanValue()) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.d(new Object[0]);
            return;
        }
        if (!((Boolean) this.playerReadinessFlow.$$delegate_0.getValue()).booleanValue()) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.w(new Object[0]);
        }
        try {
            MusicService musicService = this.service;
            boolean z = MusicService.isRunning;
            musicService.playQueue(queue, true, false);
        } catch (Exception e) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
            throw e;
        }
    }

    public final void seekTo(long j) {
        try {
            CastConnectionHandler castConnectionHandler = this.service.castConnectionHandler;
            if (castConnectionHandler == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
                getPlayerSafe().seekToCurrentItem(j);
            }
        } catch (Exception unused) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    public final void seekToNext() {
        try {
            CastConnectionHandler castConnectionHandler = this.service.castConnectionHandler;
            if (castConnectionHandler == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
                getPlayerSafe().seekToNext();
                if (getPlayerSafe().getPlaybackState() == 1 || getPlayerSafe().getPlaybackState() == 4) {
                    getPlayerSafe().prepare();
                }
                getPlayerSafe().setPlayWhenReady(true);
            }
        } catch (Exception unused) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    public final void seekToPrevious() {
        try {
            CastConnectionHandler castConnectionHandler = this.service.castConnectionHandler;
            if (castConnectionHandler == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
                if (getPlayerSafe().getCurrentPosition() <= 3000 && getPlayerSafe().hasPreviousMediaItem()) {
                    getPlayerSafe().seekToPreviousMediaItemInternal();
                    if (getPlayerSafe().getPlaybackState() == 1 || getPlayerSafe().getPlaybackState() == 4) {
                        getPlayerSafe().prepare();
                    }
                    getPlayerSafe().setPlayWhenReady(true);
                    return;
                }
                getPlayerSafe().seekToCurrentItem(0L);
                if (getPlayerSafe().getPlaybackState() == 1 || getPlayerSafe().getPlaybackState() == 4) {
                    getPlayerSafe().prepare();
                }
                getPlayerSafe().setPlayWhenReady(true);
                ComponentRegistry$Builder$$ExternalSyntheticLambda2 componentRegistry$Builder$$ExternalSyntheticLambda2 = this.onRestartSong;
                if (componentRegistry$Builder$$ExternalSyntheticLambda2 != null) {
                    componentRegistry$Builder$$ExternalSyntheticLambda2.invoke();
                }
            }
        } catch (Exception unused) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    public final void startRadioSeamlessly() throws Exception {
        PlayerMenuKt$$ExternalSyntheticLambda117 playerMenuKt$$ExternalSyntheticLambda117 = this.shouldBlockPlaybackChanges;
        if (playerMenuKt$$ExternalSyntheticLambda117 != null && ((Boolean) playerMenuKt$$ExternalSyntheticLambda117.invoke()).booleanValue()) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.d(new Object[0]);
            return;
        }
        if (!((Boolean) this.playerReadinessFlow.$$delegate_0.getValue()).booleanValue()) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.w(new Object[0]);
        }
        try {
            this.service.startRadioSeamlessly();
        } catch (Exception e) {
            Timber.Forest.tag("PlayerConnection");
            ConnectionPool.e$1(new Object[0]);
            throw e;
        }
    }

    public final void toggleMute() {
        MusicService musicService = this.service;
        StateFlowImpl stateFlowImpl = musicService.isMuted;
        stateFlowImpl.updateState(null, Boolean.valueOf(!((Boolean) stateFlowImpl.getValue()).booleanValue()));
        musicService.applyEffectiveVolume();
    }

    public final void togglePlayPause() {
        PlayerMenuKt$$ExternalSyntheticLambda117 playerMenuKt$$ExternalSyntheticLambda117;
        if (this.allowInternalSync || (playerMenuKt$$ExternalSyntheticLambda117 = this.shouldBlockPlaybackChanges) == null || !((Boolean) playerMenuKt$$ExternalSyntheticLambda117.invoke()).booleanValue()) {
            try {
                CastConnectionHandler castConnectionHandler = this.service.castConnectionHandler;
                if (castConnectionHandler != null && ((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
                    ((Boolean) castConnectionHandler.castIsPlaying.getValue()).getClass();
                    return;
                }
                ExoPlayerImpl playerSafe = getPlayerSafe();
                playerSafe.getClass();
                if (!playerSafe.getPlayWhenReady() && playerSafe.getPlaybackState() == 1) {
                    playerSafe.prepare();
                }
                playerSafe.setPlayWhenReady(!playerSafe.getPlayWhenReady());
            } catch (Exception unused) {
                Timber.Forest.tag("PlayerConnection");
                ConnectionPool.e$1(new Object[0]);
            }
        }
    }

    public final void updateAttachedPlayer(ExoPlayerImpl exoPlayerImpl) {
        ExoPlayerImpl exoPlayerImpl2 = this.attachedPlayer;
        if (exoPlayerImpl2 != null) {
            exoPlayerImpl2.removeListener(this);
        }
        this.attachedPlayer = exoPlayerImpl;
        exoPlayerImpl.listeners.add(this);
        Integer numValueOf = Integer.valueOf(exoPlayerImpl.getPlaybackState());
        StateFlowImpl stateFlowImpl = this.playbackState;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, numValueOf);
        Boolean boolValueOf = Boolean.valueOf(exoPlayerImpl.getPlayWhenReady());
        StateFlowImpl stateFlowImpl2 = this.playWhenReady;
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, boolValueOf);
        this.mediaMetadata.setValue(IntMath.getCurrentMetadata(exoPlayerImpl));
        this.queueTitle.setValue(this.service.queueTitle);
        List queueWindows = IntMath.getQueueWindows(exoPlayerImpl);
        StateFlowImpl stateFlowImpl3 = this.queueWindows;
        stateFlowImpl3.getClass();
        stateFlowImpl3.updateState(null, queueWindows);
        Integer numValueOf2 = Integer.valueOf(IntMath.getCurrentQueueIndex(exoPlayerImpl));
        StateFlowImpl stateFlowImpl4 = this.currentWindowIndex;
        stateFlowImpl4.getClass();
        stateFlowImpl4.updateState(null, numValueOf2);
        Integer numValueOf3 = Integer.valueOf(exoPlayerImpl.getCurrentMediaItemIndex());
        StateFlowImpl stateFlowImpl5 = this.currentMediaItemIndex;
        stateFlowImpl5.getClass();
        stateFlowImpl5.updateState(null, numValueOf3);
        exoPlayerImpl.verifyApplicationThread();
        Boolean boolValueOf2 = Boolean.valueOf(exoPlayerImpl.shuffleModeEnabled);
        StateFlowImpl stateFlowImpl6 = this.shuffleModeEnabled;
        stateFlowImpl6.getClass();
        stateFlowImpl6.updateState(null, boolValueOf2);
        exoPlayerImpl.verifyApplicationThread();
        Integer numValueOf4 = Integer.valueOf(exoPlayerImpl.repeatMode);
        StateFlowImpl stateFlowImpl7 = this.repeatMode;
        stateFlowImpl7.getClass();
        stateFlowImpl7.updateState(null, numValueOf4);
        Timber.Forest.tag("PlayerConnection");
        ConnectionPool.d(new Object[0]);
    }

    public final void updateCanSkipPreviousAndNext() {
        boolean zIsEmpty = getPlayerSafe().getCurrentTimeline().isEmpty();
        StateFlowImpl stateFlowImpl = this.canSkipNext;
        StateFlowImpl stateFlowImpl2 = this.canSkipPrevious;
        if (zIsEmpty) {
            Boolean bool = Boolean.FALSE;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, bool);
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool);
            return;
        }
        Timeline.Window window = getPlayerSafe().getCurrentTimeline().getWindow(getPlayerSafe().getCurrentMediaItemIndex(), new Timeline.Window(), 0L);
        window.getClass();
        boolean z = true;
        Boolean boolValueOf = Boolean.valueOf(getPlayerSafe().isCommandAvailable(5) || !window.isLive() || getPlayerSafe().isCommandAvailable(6));
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, boolValueOf);
        if ((!window.isLive() || !window.isDynamic) && !getPlayerSafe().isCommandAvailable(8)) {
            z = false;
        }
        Boolean boolValueOf2 = Boolean.valueOf(z);
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, boolValueOf2);
    }
}
