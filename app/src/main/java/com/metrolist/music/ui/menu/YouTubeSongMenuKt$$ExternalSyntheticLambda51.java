package com.metrolist.music.ui.menu;

import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import java.time.LocalDateTime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTubeSongMenuKt$$ExternalSyntheticLambda51 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SongItem f$0;

    public /* synthetic */ YouTubeSongMenuKt$$ExternalSyntheticLambda51(SongItem songItem, byte b) {
        this.$r8$classId = b;
        this.f$0 = songItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SongItem songItem = this.f$0;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        switch (b) {
            case 0:
                musicDatabase.getClass();
                musicDatabase.inLibrary(songItem.id, null);
                break;
            case 1:
                musicDatabase.insert(HexFormatKt.toMediaMetadata(songItem), new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                break;
            case 2:
                musicDatabase.insert(HexFormatKt.toMediaMetadata(songItem), new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                break;
            default:
                musicDatabase.getClass();
                musicDatabase.insert(HexFormatKt.toMediaMetadata(songItem), new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                String str = songItem.id;
                musicDatabase.inLibrary(str, LocalDateTime.now());
                musicDatabase.$$delegate_0.addLibraryTokens(str, songItem.libraryAddToken, songItem.libraryRemoveToken);
                break;
        }
        return unit;
    }
}
