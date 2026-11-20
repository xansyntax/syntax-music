package com.metrolist.music.ui.screens.library;

import androidx.compose.runtime.State;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibrarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1 implements Function0 {
    public final /* synthetic */ Object $filteredSongs;
    public final /* synthetic */ int $index;
    public final /* synthetic */ State $mediaMetadata$delegate;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ Object $queueAllSongsStr;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object $song;

    public LibrarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1(EpisodeItem episodeItem, PlayerConnection playerConnection, int i, List list, State state, State state2) {
        this.$song = episodeItem;
        this.$playerConnection = playerConnection;
        this.$index = i;
        this.$queueAllSongsStr = list;
        this.$mediaMetadata$delegate = state;
        this.$filteredSongs = state2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.$filteredSongs;
        State state = this.$mediaMetadata$delegate;
        Object obj2 = this.$song;
        PlayerConnection playerConnection = this.$playerConnection;
        Object obj3 = this.$queueAllSongsStr;
        int i = 0;
        switch (b) {
            case 0:
                String str = ((Song) obj2).song.id;
                MediaMetadata mediaMetadata = (MediaMetadata) state.getValue();
                if (!Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null)) {
                    String str2 = (String) obj3;
                    ArrayList arrayList = (ArrayList) obj;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj4 = arrayList.get(i);
                        i++;
                        arrayList2.add(UuidKt.toMediaItem((Song) obj4));
                    }
                    playerConnection.playQueue(new ListQueue(str2, arrayList2, this.$index, 0L, 8, null));
                } else {
                    playerConnection.togglePlayPause();
                }
                break;
            default:
                List list = (List) obj3;
                String str3 = ((EpisodeItem) obj2).id;
                MediaMetadata mediaMetadata2 = (MediaMetadata) state.getValue();
                if (!Intrinsics.areEqual(str3, mediaMetadata2 != null ? mediaMetadata2.id : null)) {
                    ConnectionPool connectionPool = Timber.Forest;
                    list.size();
                    connectionPool.getClass();
                    ConnectionPool.d(new Object[0]);
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata((EpisodeItem) it.next())));
                    }
                    ConnectionPool connectionPool2 = Timber.Forest;
                    arrayList3.size();
                    connectionPool2.getClass();
                    ConnectionPool.d(new Object[0]);
                    PodcastItem podcastItem = (PodcastItem) ((State) obj).getValue();
                    playerConnection.playQueue(new ListQueue(podcastItem != null ? podcastItem.title : null, arrayList3, this.$index, 0L, 8, null));
                } else {
                    playerConnection.togglePlayPause();
                }
                break;
        }
        return unit;
    }

    public LibrarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1(Song song, PlayerConnection playerConnection, String str, ArrayList arrayList, int i, State state) {
        this.$song = song;
        this.$playerConnection = playerConnection;
        this.$queueAllSongsStr = str;
        this.$filteredSongs = arrayList;
        this.$index = i;
        this.$mediaMetadata$delegate = state;
    }
}
