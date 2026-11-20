package com.metrolist.music.ui.component;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.media3.common.MediaItem;
import com.metrolist.music.playback.PlayerConnection;
import com.yalantis.ucrop.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ItemsKt$SwipeToSongBox$1$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ Context $ctx;
    public final /* synthetic */ MediaItem $mediaItem;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState $offset;
    public final /* synthetic */ PlayerConnection $player;
    public final /* synthetic */ CoroutineScope $scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemsKt$SwipeToSongBox$1$1(ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, PlayerConnection playerConnection, MediaItem mediaItem, Context context, CoroutineScope coroutineScope, Continuation continuation) {
        super(3, continuation);
        this.$offset = parcelableSnapshotMutableFloatState;
        this.$player = playerConnection;
        this.$mediaItem = mediaItem;
        this.$ctx = context;
        this.$scope = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws Exception {
        ((Number) obj2).floatValue();
        Context context = this.$ctx;
        CoroutineScope coroutineScope = this.$scope;
        ItemsKt$SwipeToSongBox$1$1 itemsKt$SwipeToSongBox$1$1 = new ItemsKt$SwipeToSongBox$1$1(this.$offset, this.$player, this.$mediaItem, context, coroutineScope, (Continuation) obj3);
        Unit unit = Unit.INSTANCE;
        itemsKt$SwipeToSongBox$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        ResultKt.throwOnFailure(obj);
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.$offset;
        float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
        Context context = this.$ctx;
        MediaItem mediaItem = this.$mediaItem;
        PlayerConnection playerConnection = this.$player;
        CoroutineScope coroutineScope = this.$scope;
        if (floatValue >= 300.0f) {
            if (playerConnection != null) {
                playerConnection.playNext(CollectionsKt__IterablesKt.listOf(mediaItem));
            }
            Toast.makeText(context, R.string.play_next, 0).show();
            AwaitKt.launch$default(coroutineScope, null, null, new ItemsKt$reset$1(parcelableSnapshotMutableFloatState, null, (byte) 0), 3);
        } else if (parcelableSnapshotMutableFloatState.getFloatValue() <= -300.0f) {
            if (playerConnection != null) {
                playerConnection.addToQueue(CollectionsKt__IterablesKt.listOf(mediaItem));
            }
            Toast.makeText(context, R.string.add_to_queue, 0).show();
            AwaitKt.launch$default(coroutineScope, null, null, new ItemsKt$reset$1(parcelableSnapshotMutableFloatState, null, (byte) 0), 3);
        } else {
            AwaitKt.launch$default(coroutineScope, null, null, new ItemsKt$reset$1(parcelableSnapshotMutableFloatState, null, (byte) 0), 3);
        }
        return Unit.INSTANCE;
    }
}
