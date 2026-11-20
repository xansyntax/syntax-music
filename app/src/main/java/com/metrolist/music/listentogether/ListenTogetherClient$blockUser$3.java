package com.metrolist.music.listentogether;

import android.content.Context;
import androidx.compose.runtime.Recomposer$join$2;
import coil3.network.HttpException;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.ArtistViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherClient$blockUser$3 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ ListenTogetherClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListenTogetherClient$blockUser$3(ListenTogetherClient listenTogetherClient, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = listenTogetherClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        ListenTogetherClient listenTogetherClient = this.this$0;
        switch (b) {
            case 0:
                return new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 0);
            case 1:
                return new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 1);
            case 2:
                return new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 2);
            case 3:
                return new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 3);
            case 4:
                return new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 4);
            case 5:
                return new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 5);
            case 6:
                return new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 6);
            default:
                return new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 7);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
        return ((ListenTogetherClient$blockUser$3) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ListenTogetherClient listenTogetherClient = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Continuation continuation = null;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    String str = ListenTogetherClient.DEFAULT_SERVER_URL;
                    return listenTogetherClient.saveBlockedUsernames(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Context context = listenTogetherClient.context;
                Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(2, continuation, (byte) 7);
                this.label = true;
                return UtilsKt.safeDataStoreEdit(context, recomposer$join$2, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 2:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    if (AwaitKt.delay(1800000L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                String str2 = ListenTogetherClient.DEFAULT_SERVER_URL;
                if (!listenTogetherClient.shouldDisconnectForBackgroundIdle()) {
                    return unit;
                }
                listenTogetherClient.log(LogLevel.INFO, "Background idle timeout reached", "Disconnecting to save battery");
                listenTogetherClient.backgroundDisconnectJob = null;
                listenTogetherClient.disconnect();
                return unit;
            case 3:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    if (AwaitKt.delay(500L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                listenTogetherClient.connect();
                return unit;
            case 4:
                boolean z5 = this.label;
                if (!z5) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    if (AwaitKt.delay(500L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                String str3 = listenTogetherClient.storedRoomCode;
                str3.getClass();
                String str4 = listenTogetherClient.storedUsername;
                str4.getClass();
                listenTogetherClient.joinRoom(str3, str4);
                return unit;
            case 5:
                boolean z6 = this.label;
                try {
                    if (!z6) {
                        ResultKt.throwOnFailure(obj);
                        String str5 = ListenTogetherClient.DEFAULT_SERVER_URL;
                        NetworkConnectivityObserver networkConnectivityObserver = (NetworkConnectivityObserver) listenTogetherClient.connectivityObserver$delegate.getValue();
                        if (networkConnectivityObserver == null) {
                            return unit;
                        }
                        ReadonlyStateFlow readonlyStateFlow = networkConnectivityObserver.networkStatus;
                        ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass2 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 6, listenTogetherClient);
                        this.label = true;
                        if (readonlyStateFlow.$$delegate_0.collect(anonymousClass2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z6) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new HttpException();
                } catch (Exception unused) {
                    Timber.Forest.tag("ListenTogether");
                    ConnectionPool.e$1(new Object[0]);
                    return unit;
                }
            case 6:
                boolean z7 = this.label;
                if (z7) {
                    if (z7) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Context context2 = listenTogetherClient.context;
                DownloadUtil.AnonymousClass2 anonymousClass3 = new DownloadUtil.AnonymousClass2((Object) listenTogetherClient, continuation, (byte) 13);
                this.label = true;
                return UtilsKt.safeDataStoreEdit(context2, anonymousClass3, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z8 = this.label;
                if (!z8) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    String str6 = ListenTogetherClient.DEFAULT_SERVER_URL;
                    return listenTogetherClient.saveBlockedUsernames(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z8) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
