package com.metrolist.music.ui.screens.artist;

import androidx.compose.runtime.State;
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
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistSongsScreenKt$ArtistSongsScreen$1$1$1$3$2$1 implements Function0 {
    public final /* synthetic */ int $index;
    public final /* synthetic */ State $mediaMetadata$delegate;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ String $queueAllSongsStr;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Song $song;
    public final /* synthetic */ State $songs$delegate;

    public /* synthetic */ ArtistSongsScreenKt$ArtistSongsScreen$1$1$1$3$2$1(Song song, PlayerConnection playerConnection, String str, int i, State state, State state2, byte b) {
        this.$r8$classId = b;
        this.$song = song;
        this.$playerConnection = playerConnection;
        this.$queueAllSongsStr = str;
        this.$index = i;
        this.$mediaMetadata$delegate = state;
        this.$songs$delegate = state2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        State state = this.$songs$delegate;
        PlayerConnection playerConnection = this.$playerConnection;
        State state2 = this.$mediaMetadata$delegate;
        Song song = this.$song;
        switch (b) {
            case 0:
                String str = song.song.id;
                MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                if (!Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null)) {
                    List list = (List) state.getValue();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(UuidKt.toMediaItem((Song) it.next()));
                    }
                    playerConnection.playQueue(new ListQueue(this.$queueAllSongsStr, arrayList, this.$index, 0L, 8, null));
                } else {
                    playerConnection.togglePlayPause();
                }
                break;
            default:
                String str2 = song.song.id;
                MediaMetadata mediaMetadata2 = (MediaMetadata) state2.getValue();
                if (!Intrinsics.areEqual(str2, mediaMetadata2 != null ? mediaMetadata2.id : null)) {
                    List list2 = (List) state.getValue();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(UuidKt.toMediaItem((Song) it2.next()));
                    }
                    playerConnection.playQueue(new ListQueue(this.$queueAllSongsStr, arrayList2, this.$index, 0L, 8, null));
                } else {
                    playerConnection.togglePlayPause();
                }
                break;
        }
        return unit;
    }
}
