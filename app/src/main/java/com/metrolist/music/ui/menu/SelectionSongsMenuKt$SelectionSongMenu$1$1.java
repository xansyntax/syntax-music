package com.metrolist.music.ui.menu;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.playback.DownloadUtil;
import java.util.ArrayList;
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
public final class SelectionSongsMenuKt$SelectionSongMenu$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ParcelableSnapshotMutableIntState $downloadState$delegate;
    public final /* synthetic */ DownloadUtil $downloadUtil;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ArrayList $songSelection;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectionSongsMenuKt$SelectionSongMenu$1$1(ArrayList arrayList, DownloadUtil downloadUtil, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$songSelection = arrayList;
        this.$downloadUtil = downloadUtil;
        this.$downloadState$delegate = parcelableSnapshotMutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SelectionSongsMenuKt$SelectionSongMenu$1$1(this.$songSelection, this.$downloadUtil, this.$downloadState$delegate, continuation, (byte) 0);
            default:
                return new SelectionSongsMenuKt$SelectionSongMenu$1$1(this.$songSelection, this.$downloadUtil, this.$downloadState$delegate, continuation, (byte) 1);
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
        }
        return ((SelectionSongsMenuKt$SelectionSongMenu$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.$downloadState$delegate;
        DownloadUtil downloadUtil = this.$downloadUtil;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ArrayList arrayList = this.$songSelection;
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
                if (arrayList.isEmpty()) {
                    return unit;
                }
                StateFlowImpl stateFlowImpl = downloadUtil.downloads;
                YouTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1 youTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1 = new YouTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1(arrayList, parcelableSnapshotMutableIntState, (byte) 1);
                this.label = true;
                stateFlowImpl.collect(youTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1, this);
                return coroutineSingletons;
            default:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (arrayList.isEmpty()) {
                    return unit;
                }
                StateFlowImpl stateFlowImpl2 = downloadUtil.downloads;
                YouTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1 youTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$2 = new YouTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1(arrayList, parcelableSnapshotMutableIntState, (byte) 2);
                this.label = true;
                stateFlowImpl2.collect(youTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$2, this);
                return coroutineSingletons;
        }
    }
}
