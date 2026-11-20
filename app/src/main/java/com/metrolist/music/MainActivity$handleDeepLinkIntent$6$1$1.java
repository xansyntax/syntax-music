package com.metrolist.music;

import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity$handleDeepLinkIntent$6$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ SongItem $firstItem;
    public final /* synthetic */ String $playlistId;
    public final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$handleDeepLinkIntent$6$1$1(MainActivity mainActivity, SongItem songItem, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$firstItem = songItem;
        this.$playlistId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MainActivity$handleDeepLinkIntent$6$1$1(this.this$0, this.$firstItem, this.$playlistId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        MainActivity$handleDeepLinkIntent$6$1$1 mainActivity$handleDeepLinkIntent$6$1$1 = (MainActivity$handleDeepLinkIntent$6$1$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        mainActivity$handleDeepLinkIntent$6$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        PlayerConnection playerConnection = this.this$0.playerConnection;
        if (playerConnection != null) {
            SongItem songItem = this.$firstItem;
            playerConnection.playQueue(new YouTubeQueue(new WatchEndpoint(60, songItem != null ? songItem.id : null, this.$playlistId, null), songItem != null ? HexFormatKt.toMediaMetadata(songItem) : null));
        }
        return Unit.INSTANCE;
    }
}
