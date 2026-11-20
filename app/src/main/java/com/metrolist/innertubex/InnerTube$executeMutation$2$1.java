package com.metrolist.innertubex;

import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.View;
import androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda1;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3;
import androidx.compose.foundation.text.contextmenu.internal.FloatingTextActionModeCallback;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.node.NodeChain;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1;
import coil3.RealImageLoader;
import com.google.common.base.Joiner;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertubex.cipher.YouTubeCipherService;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$executeMutation$2$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ Object $block;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $requestSession;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$executeMutation$2$1(Object obj, Object obj2, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$block = obj;
        this.$requestSession = obj2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj = this.$requestSession;
        Object obj2 = this.$block;
        switch (b) {
            case 0:
                return new InnerTube$executeMutation$2$1((Function2) obj2, (InnerTube.SessionSnapshot) obj, continuation, (byte) 0);
            case 1:
                return new InnerTube$executeMutation$2$1((NodeChain) obj2, (Function3) obj, continuation, (byte) 1);
            case 2:
                return new InnerTube$executeMutation$2$1((AndroidTextContextMenuToolbarProvider) obj2, (TextContextMenuDataProvider) obj, continuation, (byte) 2);
            case 3:
                return new InnerTube$executeMutation$2$1((BasicTextContextMenuProvider) obj2, (BasicTextContextMenuProvider.SessionImpl) obj, continuation, (byte) 3);
            case 4:
                return new InnerTube$executeMutation$2$1((RoomDatabase) obj2, (InnerTube$executeMutation$2$1) obj, continuation, (byte) 4);
            case 5:
                return new InnerTube$executeMutation$2$1((RoomDatabase) obj2, (Function1) obj, continuation, (byte) 5);
            case 6:
                return new InnerTube$executeMutation$2$1((YouTubeCipherService) obj2, (String) obj, continuation, (byte) 6);
            case 7:
                return new InnerTube$executeMutation$2$1((Function2) obj2, (MusicDatabase) obj, continuation, (byte) 7);
            case 8:
                return new InnerTube$executeMutation$2$1((MusicDatabase) obj2, (SongItem) obj, continuation, (byte) 8);
            default:
                return new InnerTube$executeMutation$2$1((FlowCollector) obj2, (Ref$ObjectRef) obj, continuation, (byte) 9);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
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
            case 7:
                break;
            case 8:
                break;
        }
        return ((InnerTube$executeMutation$2$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl textActionModeCallbackImpl;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$block;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj3 = this.$requestSession;
        byte b2 = 1;
        Continuation continuation = null;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object objInvoke = ((Function2) obj2).invoke((InnerTube.SessionSnapshot) obj3, this);
                    return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                NodeChain nodeChain = (NodeChain) obj2;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    AnchoredDraggableState$$ExternalSyntheticLambda1 anchoredDraggableState$$ExternalSyntheticLambda1 = new AnchoredDraggableState$$ExternalSyntheticLambda1(nodeChain, b2);
                    RealImageLoader.AnonymousClass2 anonymousClass2 = new RealImageLoader.AnonymousClass2((Function3) obj3, nodeChain, continuation, (byte) 8);
                    this.label = true;
                    if (ScrollableKt.restartable(anchoredDraggableState$$ExternalSyntheticLambda1, anonymousClass2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                DefaultDraggableAnchors anchors = nodeChain.getAnchors();
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) nodeChain.head;
                Object objClosestAnchor = anchors.closestAnchor(parcelableSnapshotMutableFloatState.getFloatValue());
                if (objClosestAnchor == null) {
                    return unit;
                }
                if (Math.abs(parcelableSnapshotMutableFloatState.getFloatValue() - nodeChain.getAnchors().positionOf(objClosestAnchor)) >= 0.5f || !((Boolean) ((Function1) nodeChain.layoutNode).invoke(objClosestAnchor)).booleanValue()) {
                    return unit;
                }
                ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).setValue(objClosestAnchor);
                ((ParcelableSnapshotMutableState) nodeChain.innerCoordinator).setValue(objClosestAnchor);
                return unit;
            case 2:
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = (AndroidTextContextMenuToolbarProvider) obj2;
                SnapshotStateObserver snapshotStateObserver = androidTextContextMenuToolbarProvider.snapshotStateObserver;
                View view = androidTextContextMenuToolbarProvider.view;
                boolean z3 = this.label;
                byte b3 = 3;
                try {
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl textContextMenuSessionImpl = new AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl();
                        TextContextMenuDataProvider textContextMenuDataProvider = (TextContextMenuDataProvider) obj3;
                        AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl textActionModeCallbackImpl2 = new AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl(textContextMenuSessionImpl, new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3(androidTextContextMenuToolbarProvider, textContextMenuDataProvider, (byte) 0), new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3(androidTextContextMenuToolbarProvider, textContextMenuDataProvider, (byte) 1), view);
                        Function1 function1 = androidTextContextMenuToolbarProvider.callbackInjector;
                        if (function1 != null && (textActionModeCallbackImpl = (AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl) function1.invoke(textActionModeCallbackImpl2)) != null) {
                            textActionModeCallbackImpl2 = textActionModeCallbackImpl;
                        }
                        Looper looperMyLooper = Looper.myLooper();
                        Handler handler = view.getHandler();
                        if (looperMyLooper != (handler != null ? handler.getLooper() : null)) {
                            Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda1 = androidTextContextMenuToolbarProvider.startActionModeRunnable;
                            if (util$$ExternalSyntheticLambda1 == null) {
                                util$$ExternalSyntheticLambda1 = new Util$$ExternalSyntheticLambda1(androidTextContextMenuToolbarProvider, textActionModeCallbackImpl2, textContextMenuSessionImpl, b2);
                                androidTextContextMenuToolbarProvider.startActionModeRunnable = util$$ExternalSyntheticLambda1;
                            }
                            view.post(util$$ExternalSyntheticLambda1);
                        } else {
                            ActionMode actionModeStartActionMode = view.startActionMode(new FloatingTextActionModeCallback(textActionModeCallbackImpl2), 1);
                            if (actionModeStartActionMode == null) {
                                return unit;
                            }
                            androidTextContextMenuToolbarProvider.actionMode = actionModeStartActionMode;
                        }
                        this.label = true;
                        Object objReceive = textContextMenuSessionImpl.channel.receive(this);
                        if (objReceive != coroutineSingletons) {
                            objReceive = unit;
                        }
                        if (objReceive == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    snapshotStateObserver.clear();
                    Looper looperMyLooper2 = Looper.myLooper();
                    Handler handler2 = view.getHandler();
                    if (looperMyLooper2 != (handler2 != null ? handler2.getLooper() : null)) {
                        Runnable activityCompat$$ExternalSyntheticLambda0 = androidTextContextMenuToolbarProvider.finishActionModeRunnable;
                        if (activityCompat$$ExternalSyntheticLambda0 == null) {
                            activityCompat$$ExternalSyntheticLambda0 = new ActivityCompat$$ExternalSyntheticLambda0(b3, androidTextContextMenuToolbarProvider);
                            androidTextContextMenuToolbarProvider.finishActionModeRunnable = activityCompat$$ExternalSyntheticLambda0;
                        }
                        view.post(activityCompat$$ExternalSyntheticLambda0);
                    } else {
                        ActionMode actionMode = androidTextContextMenuToolbarProvider.actionMode;
                        if (actionMode != null) {
                            actionMode.finish();
                        }
                    }
                    Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda2 = androidTextContextMenuToolbarProvider.startActionModeRunnable;
                    if (util$$ExternalSyntheticLambda2 != null) {
                        view.removeCallbacks(util$$ExternalSyntheticLambda2);
                    }
                    androidTextContextMenuToolbarProvider.actionMode = null;
                    return unit;
                } catch (Throwable th) {
                    snapshotStateObserver.clear();
                    Looper looperMyLooper3 = Looper.myLooper();
                    Handler handler3 = view.getHandler();
                    if (looperMyLooper3 != (handler3 != null ? handler3.getLooper() : null)) {
                        Runnable activityCompat$$ExternalSyntheticLambda1 = androidTextContextMenuToolbarProvider.finishActionModeRunnable;
                        if (activityCompat$$ExternalSyntheticLambda1 == null) {
                            activityCompat$$ExternalSyntheticLambda1 = new ActivityCompat$$ExternalSyntheticLambda0(b3, androidTextContextMenuToolbarProvider);
                            androidTextContextMenuToolbarProvider.finishActionModeRunnable = activityCompat$$ExternalSyntheticLambda1;
                        }
                        view.post(activityCompat$$ExternalSyntheticLambda1);
                    } else {
                        ActionMode actionMode2 = androidTextContextMenuToolbarProvider.actionMode;
                        if (actionMode2 != null) {
                            actionMode2.finish();
                        }
                    }
                    Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda3 = androidTextContextMenuToolbarProvider.startActionModeRunnable;
                    if (util$$ExternalSyntheticLambda3 != null) {
                        view.removeCallbacks(util$$ExternalSyntheticLambda3);
                    }
                    androidTextContextMenuToolbarProvider.actionMode = null;
                    throw th;
                }
            case 3:
                BasicTextContextMenuProvider.SessionImpl sessionImpl = (BasicTextContextMenuProvider.SessionImpl) obj3;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = ((BasicTextContextMenuProvider) obj2).session$delegate;
                boolean z4 = this.label;
                try {
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        parcelableSnapshotMutableState.setValue(sessionImpl);
                        this.label = true;
                        Object objReceive2 = sessionImpl.channel.receive(this);
                        if (objReceive2 != coroutineSingletons) {
                            objReceive2 = unit;
                        }
                        if (objReceive2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    parcelableSnapshotMutableState.setValue(null);
                    return unit;
                } catch (Throwable th2) {
                    parcelableSnapshotMutableState.setValue(null);
                    throw th2;
                }
            case 4:
                RoomDatabase roomDatabase = (RoomDatabase) obj2;
                boolean z5 = this.label;
                try {
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        roomDatabase.beginTransaction();
                        this.label = true;
                        obj = ((InnerTube$executeMutation$2$1) obj3).invoke(this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z5) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    roomDatabase.getOpenHelper().getWritableDatabase().setTransactionSuccessful();
                    roomDatabase.internalEndTransaction();
                    return obj;
                } catch (Throwable th3) {
                    roomDatabase.internalEndTransaction();
                    throw th3;
                }
            case 5:
                boolean z6 = this.label;
                if (z6) {
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                RoomDatabase roomDatabase2 = (RoomDatabase) obj2;
                DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1(roomDatabase2, continuation, (Function1) obj3, b2);
                this.label = true;
                Object objUseConnection = roomDatabase2.useConnection(false, dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1, this);
                return objUseConnection == coroutineSingletons ? coroutineSingletons : objUseConnection;
            case 6:
                boolean z7 = this.label;
                if (!z7) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Regex regex = YouTubeCipherService.N_PARAMETER_REGEX;
                    obj = ((YouTubeCipherService) obj2).getOrDownloadPlayerCode((String) obj3, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z7) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((YouTubeCipherService.PlayerCodeResult) obj).code;
            case 7:
                boolean z8 = this.label;
                if (!z8) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return ((Function2) obj2).invoke((MusicDatabase) obj3, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z8) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                SongItem songItem = (SongItem) obj3;
                boolean z9 = this.label;
                if (!z9) {
                    ResultKt.throwOnFailure(obj);
                    DownloadUtil.AnonymousClass2 anonymousClass3 = new DownloadUtil.AnonymousClass2((Object) songItem, continuation, (byte) 28);
                    this.label = true;
                    if (((MusicDatabase) obj2).withTransaction(anonymousClass3, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z9) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return CollectionsKt__IterablesKt.listOf(songItem.id);
            default:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj3;
                boolean z10 = this.label;
                if (!z10) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector = (FlowCollector) obj2;
                    Joiner joiner = CombineKt.NULL;
                    Object obj4 = ref$ObjectRef.element;
                    if (obj4 == joiner) {
                        obj4 = null;
                    }
                    this.label = true;
                    if (flowCollector.emit(obj4, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z10) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ref$ObjectRef.element = null;
                return unit;
        }
    }
}
