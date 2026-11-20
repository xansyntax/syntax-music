package com.metrolist.music.ui.screens.playlist;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.menu.AlbumMenuKt$AlbumMenu$2$1;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TopPlaylistScreenKt$TopPlaylistScreen$4$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ParcelableSnapshotMutableIntState $downloadState$delegate;
    public final /* synthetic */ DownloadUtil $downloadUtil;
    public final /* synthetic */ SnapshotStateList $mutableSongs;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $songs$delegate;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopPlaylistScreenKt$TopPlaylistScreen$4$1(SnapshotStateList snapshotStateList, DownloadUtil downloadUtil, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$mutableSongs = snapshotStateList;
        this.$downloadUtil = downloadUtil;
        this.$songs$delegate = mutableState;
        this.$downloadState$delegate = parcelableSnapshotMutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new TopPlaylistScreenKt$TopPlaylistScreen$4$1(this.$mutableSongs, this.$downloadUtil, this.$songs$delegate, this.$downloadState$delegate, continuation, (byte) 0);
            case 1:
                return new TopPlaylistScreenKt$TopPlaylistScreen$4$1(this.$mutableSongs, this.$downloadUtil, this.$songs$delegate, this.$downloadState$delegate, continuation, (byte) 1);
            default:
                return new TopPlaylistScreenKt$TopPlaylistScreen$4$1(this.$mutableSongs, this.$downloadUtil, this.$songs$delegate, this.$downloadState$delegate, continuation, (byte) 2);
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
        }
        return ((TopPlaylistScreenKt$TopPlaylistScreen$4$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.$downloadState$delegate;
        DownloadUtil downloadUtil = this.$downloadUtil;
        Unit unit = Unit.INSTANCE;
        SnapshotStateList snapshotStateList = this.$mutableSongs;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        MutableState mutableState = this.$songs$delegate;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                snapshotStateList.clear();
                List list = (List) mutableState.getValue();
                if (list != null) {
                    snapshotStateList.addAll(list);
                }
                List list2 = (List) mutableState.getValue();
                if (list2 != null && list2.isEmpty()) {
                    return unit;
                }
                StateFlowImpl stateFlowImpl = downloadUtil.downloads;
                AlbumMenuKt$AlbumMenu$2$1.AnonymousClass1 anonymousClass1 = new AlbumMenuKt$AlbumMenu$2$1.AnonymousClass1((byte) 4, mutableState, parcelableSnapshotMutableIntState);
                this.label = true;
                stateFlowImpl.collect(anonymousClass1, this);
                return coroutineSingletons;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                snapshotStateList.clear();
                List list3 = (List) mutableState.getValue();
                if (list3 != null) {
                    snapshotStateList.addAll(list3);
                }
                List list4 = (List) mutableState.getValue();
                if (list4 != null && list4.isEmpty()) {
                    return unit;
                }
                StateFlowImpl stateFlowImpl2 = downloadUtil.downloads;
                AlbumMenuKt$AlbumMenu$2$1.AnonymousClass1 anonymousClass2 = new AlbumMenuKt$AlbumMenu$2$1.AnonymousClass1((byte) 2, mutableState, parcelableSnapshotMutableIntState);
                this.label = true;
                stateFlowImpl2.collect(anonymousClass2, this);
                return coroutineSingletons;
            default:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                snapshotStateList.clear();
                snapshotStateList.addAll((List) mutableState.getValue());
                if (((List) mutableState.getValue()).isEmpty()) {
                    return unit;
                }
                StateFlowImpl stateFlowImpl3 = downloadUtil.downloads;
                AlbumMenuKt$AlbumMenu$2$1.AnonymousClass1 anonymousClass3 = new AlbumMenuKt$AlbumMenu$2$1.AnonymousClass1((byte) 3, mutableState, parcelableSnapshotMutableIntState);
                this.label = true;
                stateFlowImpl3.collect(anonymousClass3, this);
                return coroutineSingletons;
        }
    }
}
