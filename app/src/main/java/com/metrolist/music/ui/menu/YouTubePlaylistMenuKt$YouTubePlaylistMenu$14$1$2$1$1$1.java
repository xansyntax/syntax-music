package com.metrolist.music.ui.menu;

import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ PlaylistItem $playlist;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $songs;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1(List list, PlaylistItem playlistItem, PlayerConnection playerConnection, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$songs = list;
        this.$playlist = playlistItem;
        this.$playerConnection = playerConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1(this.$songs, this.$playlist, this.$playerConnection, continuation, (byte) 0);
            default:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1(this.$songs, this.$playlist, this.$playerConnection, continuation, (byte) 1);
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
        return ((YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0056 A[LOOP:0: B:16:0x0050->B:18:0x0056, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:35:0x00aa A[LOOP:1: B:33:0x00a4->B:35:0x00aa, LOOP_END] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator it;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PlayerConnection playerConnection = this.$playerConnection;
        PlaylistItem playlistItem = this.$playlist;
        List<SongItem> list = this.$songs;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    if (list.isEmpty()) {
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                        YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1 youTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1(playlistItem, null, (byte) 0);
                        this.label = true;
                        obj = AwaitKt.withContext(defaultIoScheduler, youTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    for (SongItem songItem : list) {
                        arrayList.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(SongItem.copy$default(songItem, null, null, YouTubeUtilsKt.resize(songItem.thumbnail, new Integer(544), new Integer(544)), 130815))));
                    }
                    playerConnection.playNext(arrayList);
                    return unit;
                }
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                list = (List) obj;
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                while (r11.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(SongItem.copy$default(songItem, null, null, YouTubeUtilsKt.resize(songItem.thumbnail, new Integer(544), new Integer(544)), 130815))));
                }
                playerConnection.playNext(arrayList);
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    if (list.isEmpty()) {
                        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                        YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1 youTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$2 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1(playlistItem, null, (byte) 1);
                        this.label = true;
                        obj = AwaitKt.withContext(defaultIoScheduler2, youTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$2, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(UuidKt.toMediaItem((SongItem) it.next()));
                    }
                    playerConnection.addToQueue(arrayList2);
                    return unit;
                }
                if (!z2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                list = (List) obj;
                arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(UuidKt.toMediaItem((SongItem) it.next()));
                }
                playerConnection.addToQueue(arrayList2);
                return unit;
        }
    }
}
