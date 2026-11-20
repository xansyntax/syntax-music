package com.metrolist.music.viewmodels;

import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CachePlaylistViewModel$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;

    public /* synthetic */ CachePlaylistViewModel$$ExternalSyntheticLambda0(List list, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        List list = this.f$0;
        switch (b) {
            case 0:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Song songByIdBlocking = musicDatabase.getSongByIdBlocking((String) it.next());
                    if (songByIdBlocking != null) {
                        musicDatabase.$$delegate_0.update(SongEntity.copy$default(songByIdBlocking.song, null, 0, null, null, null, false, null, null, null, null, null, 0, false, false, false, null, 134201343));
                    }
                }
                return unit;
            case 1:
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                lazyListIntervalContent.items(list.size(), null, new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list, (byte) 17), new ComposableLambdaImpl(true, 802480018, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4((byte) 4, list)));
                return unit;
            default:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                int i = 0;
                for (Object obj2 : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw null;
                    }
                    PlaylistSongMap playlistSongMap = ((PlaylistSong) obj2).map;
                    if (playlistSongMap.position != i) {
                        PlaylistSongMap playlistSongMapCopy$default = PlaylistSongMap.copy$default(playlistSongMap, i, null, 23);
                        musicDatabase2.getClass();
                        musicDatabase2.$$delegate_0.update(playlistSongMapCopy$default);
                    }
                    i = i2;
                }
                return unit;
        }
    }
}
