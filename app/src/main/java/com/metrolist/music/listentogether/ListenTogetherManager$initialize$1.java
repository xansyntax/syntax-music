package com.metrolist.music.listentogether;

import com.metrolist.music.db.DatabaseDao$songs$$inlined$map$1;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.utils.UtilsKt;
import java.util.Objects;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherManager$initialize$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ ListenTogetherManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListenTogetherManager$initialize$1(ListenTogetherManager listenTogetherManager, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = listenTogetherManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        ListenTogetherManager listenTogetherManager = this.this$0;
        switch (b) {
            case 0:
                return new ListenTogetherManager$initialize$1(listenTogetherManager, continuation, (byte) 0);
            case 1:
                return new ListenTogetherManager$initialize$1(listenTogetherManager, continuation, (byte) 1);
            case 2:
                return new ListenTogetherManager$initialize$1(listenTogetherManager, continuation, (byte) 2);
            case 3:
                return new ListenTogetherManager$initialize$1(listenTogetherManager, continuation, (byte) 3);
            default:
                return new ListenTogetherManager$initialize$1(listenTogetherManager, continuation, (byte) 4);
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
                ((ListenTogetherManager$initialize$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return coroutineSingletons;
            case 1:
                return ((ListenTogetherManager$initialize$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 2:
                ((ListenTogetherManager$initialize$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return coroutineSingletons;
            case 3:
                return ((ListenTogetherManager$initialize$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                return ((ListenTogetherManager$initialize$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final byte b = 0;
        final byte b2 = 1;
        switch (this.$r8$classId) {
            case 0:
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    final ListenTogetherManager listenTogetherManager = this.this$0;
                    ReadonlySharedFlow readonlySharedFlow = listenTogetherManager.client.events;
                    FlowCollector flowCollector = new FlowCollector() { // from class: com.metrolist.music.listentogether.ListenTogetherManager$initialize$1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) throws Throwable {
                            byte b3 = b;
                            Unit unit = Unit.INSTANCE;
                            ListenTogetherManager listenTogetherManager2 = listenTogetherManager;
                            switch (b3) {
                                case 0:
                                    ListenTogetherEvent listenTogetherEvent = (ListenTogetherEvent) obj2;
                                    try {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        Objects.toString(listenTogetherEvent);
                                        ConnectionPool.d(new Object[0]);
                                        listenTogetherManager2.handleEvent(listenTogetherEvent);
                                    } catch (Exception unused) {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        Objects.toString(listenTogetherEvent);
                                        ConnectionPool.e$1(new Object[0]);
                                    }
                                    break;
                                case 1:
                                    RoomRole roomRole = (RoomRole) obj2;
                                    try {
                                        RoomRole roomRole2 = listenTogetherManager2.lastRole;
                                        listenTogetherManager2.lastRole = roomRole;
                                        RoomRole roomRole3 = RoomRole.HOST;
                                        boolean z2 = roomRole2 == roomRole3;
                                        if (roomRole == roomRole3 && !z2) {
                                            PlayerConnection playerConnection = listenTogetherManager2.playerConnection;
                                            if (playerConnection != null) {
                                                Timber.Forest.tag("ListenTogetherManager");
                                                ConnectionPool.d(new Object[0]);
                                                listenTogetherManager2.startQueueSyncObservation();
                                                listenTogetherManager2.startHeartbeat();
                                                listenTogetherManager2.startVolumeSyncObservation();
                                                if (!listenTogetherManager2.playerListenerRegistered) {
                                                    try {
                                                        playerConnection.getPlayerSafe().addListener(listenTogetherManager2.playerListener);
                                                        listenTogetherManager2.playerListenerRegistered = true;
                                                    } catch (Exception unused2) {
                                                        Timber.Forest.tag("ListenTogetherManager");
                                                        ConnectionPool.e$1(new Object[0]);
                                                    }
                                                }
                                            }
                                        } else if (roomRole != roomRole3 && z2) {
                                            Timber.Forest.tag("ListenTogetherManager");
                                            ConnectionPool.d(new Object[0]);
                                            StandaloneCoroutine standaloneCoroutine = listenTogetherManager2.queueObserverJob;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel(null);
                                            }
                                            listenTogetherManager2.queueObserverJob = null;
                                            listenTogetherManager2.stopHeartbeat();
                                            listenTogetherManager2.stopVolumeSyncObservation();
                                        }
                                        if (listenTogetherManager2.playerConnection != null) {
                                            listenTogetherManager2.restoreGuestMuteState();
                                        }
                                    } catch (Exception unused3) {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        ConnectionPool.e$1(new Object[0]);
                                    }
                                    break;
                                default:
                                    Boolean bool = (Boolean) obj2;
                                    bool.getClass();
                                    StateFlowImpl stateFlowImpl = listenTogetherManager2.syncHostVolumeEnabled;
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, bool);
                                    break;
                            }
                            return unit;
                            return unit;
                            return unit;
                        }
                    };
                    this.label = true;
                    if (readonlySharedFlow.$$delegate_0.collect(flowCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 1:
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    if (AwaitKt.delay(200L, this) == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.isSyncing = false;
                return Unit.INSTANCE;
            case 2:
                CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    final ListenTogetherManager listenTogetherManager2 = this.this$0;
                    ReadonlyStateFlow readonlyStateFlow = listenTogetherManager2.role;
                    FlowCollector flowCollector2 = new FlowCollector() { // from class: com.metrolist.music.listentogether.ListenTogetherManager$initialize$1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) throws Throwable {
                            byte b3 = b2;
                            Unit unit = Unit.INSTANCE;
                            ListenTogetherManager listenTogetherManager3 = listenTogetherManager2;
                            switch (b3) {
                                case 0:
                                    ListenTogetherEvent listenTogetherEvent = (ListenTogetherEvent) obj2;
                                    try {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        Objects.toString(listenTogetherEvent);
                                        ConnectionPool.d(new Object[0]);
                                        listenTogetherManager3.handleEvent(listenTogetherEvent);
                                    } catch (Exception unused) {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        Objects.toString(listenTogetherEvent);
                                        ConnectionPool.e$1(new Object[0]);
                                    }
                                    break;
                                case 1:
                                    RoomRole roomRole = (RoomRole) obj2;
                                    try {
                                        RoomRole roomRole2 = listenTogetherManager3.lastRole;
                                        listenTogetherManager3.lastRole = roomRole;
                                        RoomRole roomRole3 = RoomRole.HOST;
                                        boolean z4 = roomRole2 == roomRole3;
                                        if (roomRole == roomRole3 && !z4) {
                                            PlayerConnection playerConnection = listenTogetherManager3.playerConnection;
                                            if (playerConnection != null) {
                                                Timber.Forest.tag("ListenTogetherManager");
                                                ConnectionPool.d(new Object[0]);
                                                listenTogetherManager3.startQueueSyncObservation();
                                                listenTogetherManager3.startHeartbeat();
                                                listenTogetherManager3.startVolumeSyncObservation();
                                                if (!listenTogetherManager3.playerListenerRegistered) {
                                                    try {
                                                        playerConnection.getPlayerSafe().addListener(listenTogetherManager3.playerListener);
                                                        listenTogetherManager3.playerListenerRegistered = true;
                                                    } catch (Exception unused2) {
                                                        Timber.Forest.tag("ListenTogetherManager");
                                                        ConnectionPool.e$1(new Object[0]);
                                                    }
                                                }
                                            }
                                        } else if (roomRole != roomRole3 && z4) {
                                            Timber.Forest.tag("ListenTogetherManager");
                                            ConnectionPool.d(new Object[0]);
                                            StandaloneCoroutine standaloneCoroutine = listenTogetherManager3.queueObserverJob;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel(null);
                                            }
                                            listenTogetherManager3.queueObserverJob = null;
                                            listenTogetherManager3.stopHeartbeat();
                                            listenTogetherManager3.stopVolumeSyncObservation();
                                        }
                                        if (listenTogetherManager3.playerConnection != null) {
                                            listenTogetherManager3.restoreGuestMuteState();
                                        }
                                    } catch (Exception unused3) {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        ConnectionPool.e$1(new Object[0]);
                                    }
                                    break;
                                default:
                                    Boolean bool = (Boolean) obj2;
                                    bool.getClass();
                                    StateFlowImpl stateFlowImpl = listenTogetherManager3.syncHostVolumeEnabled;
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, bool);
                                    break;
                            }
                            return unit;
                            return unit;
                            return unit;
                        }
                    };
                    this.label = true;
                    if (readonlyStateFlow.$$delegate_0.collect(flowCollector2, this) == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 3:
                final ListenTogetherManager listenTogetherManager3 = this.this$0;
                CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowDistinctUntilChanged = StateFlowKt.distinctUntilChanged(new DatabaseDao$songs$$inlined$map$1(UtilsKt.getDataStore(listenTogetherManager3.context).getData(), (byte) 29));
                    final byte b3 = 2;
                    FlowCollector flowCollector3 = new FlowCollector() { // from class: com.metrolist.music.listentogether.ListenTogetherManager$initialize$1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) throws Throwable {
                            byte b4 = b3;
                            Unit unit = Unit.INSTANCE;
                            ListenTogetherManager listenTogetherManager4 = listenTogetherManager3;
                            switch (b4) {
                                case 0:
                                    ListenTogetherEvent listenTogetherEvent = (ListenTogetherEvent) obj2;
                                    try {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        Objects.toString(listenTogetherEvent);
                                        ConnectionPool.d(new Object[0]);
                                        listenTogetherManager4.handleEvent(listenTogetherEvent);
                                    } catch (Exception unused) {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        Objects.toString(listenTogetherEvent);
                                        ConnectionPool.e$1(new Object[0]);
                                    }
                                    break;
                                case 1:
                                    RoomRole roomRole = (RoomRole) obj2;
                                    try {
                                        RoomRole roomRole2 = listenTogetherManager4.lastRole;
                                        listenTogetherManager4.lastRole = roomRole;
                                        RoomRole roomRole3 = RoomRole.HOST;
                                        boolean z5 = roomRole2 == roomRole3;
                                        if (roomRole == roomRole3 && !z5) {
                                            PlayerConnection playerConnection = listenTogetherManager4.playerConnection;
                                            if (playerConnection != null) {
                                                Timber.Forest.tag("ListenTogetherManager");
                                                ConnectionPool.d(new Object[0]);
                                                listenTogetherManager4.startQueueSyncObservation();
                                                listenTogetherManager4.startHeartbeat();
                                                listenTogetherManager4.startVolumeSyncObservation();
                                                if (!listenTogetherManager4.playerListenerRegistered) {
                                                    try {
                                                        playerConnection.getPlayerSafe().addListener(listenTogetherManager4.playerListener);
                                                        listenTogetherManager4.playerListenerRegistered = true;
                                                    } catch (Exception unused2) {
                                                        Timber.Forest.tag("ListenTogetherManager");
                                                        ConnectionPool.e$1(new Object[0]);
                                                    }
                                                }
                                            }
                                        } else if (roomRole != roomRole3 && z5) {
                                            Timber.Forest.tag("ListenTogetherManager");
                                            ConnectionPool.d(new Object[0]);
                                            StandaloneCoroutine standaloneCoroutine = listenTogetherManager4.queueObserverJob;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel(null);
                                            }
                                            listenTogetherManager4.queueObserverJob = null;
                                            listenTogetherManager4.stopHeartbeat();
                                            listenTogetherManager4.stopVolumeSyncObservation();
                                        }
                                        if (listenTogetherManager4.playerConnection != null) {
                                            listenTogetherManager4.restoreGuestMuteState();
                                        }
                                    } catch (Exception unused3) {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        ConnectionPool.e$1(new Object[0]);
                                    }
                                    break;
                                default:
                                    Boolean bool = (Boolean) obj2;
                                    bool.getClass();
                                    StateFlowImpl stateFlowImpl = listenTogetherManager4.syncHostVolumeEnabled;
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, bool);
                                    break;
                            }
                            return unit;
                            return unit;
                            return unit;
                        }
                    };
                    this.label = true;
                    if (flowDistinctUntilChanged.collect(flowCollector3, this) == coroutineSingletons4) {
                        return coroutineSingletons4;
                    }
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                ListenTogetherManager listenTogetherManager4 = this.this$0;
                CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z5 = this.label;
                if (!z5) {
                    ResultKt.throwOnFailure(obj);
                    PlayerConnection playerConnection = listenTogetherManager4.playerConnection;
                    if (playerConnection == null) {
                        return Unit.INSTANCE;
                    }
                    MutableStateFlow playerVolume = playerConnection.service.getPlayerVolume();
                    ListenTogetherManager$startVolumeSyncObservation$1$1 listenTogetherManager$startVolumeSyncObservation$1$1 = new ListenTogetherManager$startVolumeSyncObservation$1$1(listenTogetherManager4, null);
                    this.label = true;
                    if (StateFlowKt.collectLatest(playerVolume, listenTogetherManager$startVolumeSyncObservation$1$1, this) == coroutineSingletons5) {
                        return coroutineSingletons5;
                    }
                } else {
                    if (!z5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("SharedFlow never completes, this call should never return.");
                return null;
        }
    }
}
