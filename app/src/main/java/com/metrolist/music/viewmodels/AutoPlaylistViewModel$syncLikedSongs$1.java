package com.metrolist.music.viewmodels;

import com.metrolist.music.utils.SyncOperation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoPlaylistViewModel$syncLikedSongs$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AutoPlaylistViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoPlaylistViewModel$syncLikedSongs$1(AutoPlaylistViewModel autoPlaylistViewModel, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = autoPlaylistViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        AutoPlaylistViewModel autoPlaylistViewModel = this.this$0;
        switch (b) {
            case 0:
                return new AutoPlaylistViewModel$syncLikedSongs$1(autoPlaylistViewModel, continuation, (byte) 0);
            default:
                return new AutoPlaylistViewModel$syncLikedSongs$1(autoPlaylistViewModel, continuation, (byte) 1);
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
                ((AutoPlaylistViewModel$syncLikedSongs$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((AutoPlaylistViewModel$syncLikedSongs$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        AutoPlaylistViewModel autoPlaylistViewModel = this.this$0;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                autoPlaylistViewModel.syncUtils.enqueue(SyncOperation.LikedSongs.INSTANCE);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                autoPlaylistViewModel.syncUtils.enqueue(SyncOperation.UploadedSongs.INSTANCE);
                break;
        }
        return unit;
    }
}
