package com.metrolist.music.ui.player;

import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.State;
import com.metrolist.music.playback.PlayerConnection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbnailKt$Thumbnail$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ State $canSkipNext$delegate;
    public final /* synthetic */ State $canSkipPrevious$delegate;
    public final /* synthetic */ State $currentItem$delegate;
    public final /* synthetic */ int $currentMediaIndex;
    public final /* synthetic */ State $itemScrollOffset$delegate;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ boolean $swipeThumbnail;
    public final /* synthetic */ LazyGridState $thumbnailLazyGridState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailKt$Thumbnail$2$1(LazyGridState lazyGridState, boolean z, int i, PlayerConnection playerConnection, State state, State state2, State state3, State state4, Continuation continuation) {
        super(2, continuation);
        this.$thumbnailLazyGridState = lazyGridState;
        this.$swipeThumbnail = z;
        this.$currentMediaIndex = i;
        this.$playerConnection = playerConnection;
        this.$itemScrollOffset$delegate = state;
        this.$currentItem$delegate = state2;
        this.$canSkipNext$delegate = state3;
        this.$canSkipPrevious$delegate = state4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ThumbnailKt$Thumbnail$2$1(this.$thumbnailLazyGridState, this.$swipeThumbnail, this.$currentMediaIndex, this.$playerConnection, this.$itemScrollOffset$delegate, this.$currentItem$delegate, this.$canSkipNext$delegate, this.$canSkipPrevious$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ThumbnailKt$Thumbnail$2$1 thumbnailKt$Thumbnail$2$1 = (ThumbnailKt$Thumbnail$2$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        thumbnailKt$Thumbnail$2$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        ResultKt.throwOnFailure(obj);
        boolean zIsScrollInProgress = this.$thumbnailLazyGridState.scrollableState.isScrollInProgress();
        Unit unit = Unit.INSTANCE;
        if (zIsScrollInProgress && this.$swipeThumbnail && ((Number) this.$itemScrollOffset$delegate.getValue()).intValue() == 0 && (i = this.$currentMediaIndex) >= 0) {
            State state = this.$currentItem$delegate;
            int iIntValue = ((Number) state.getValue()).intValue();
            PlayerConnection playerConnection = this.$playerConnection;
            if (iIntValue > i && ((Boolean) this.$canSkipNext$delegate.getValue()).booleanValue()) {
                playerConnection.getPlayerSafe().seekToNext();
                return unit;
            }
            if (((Number) state.getValue()).intValue() < i && ((Boolean) this.$canSkipPrevious$delegate.getValue()).booleanValue()) {
                playerConnection.getPlayerSafe().seekToPreviousMediaItemInternal();
            }
        }
        return unit;
    }
}
