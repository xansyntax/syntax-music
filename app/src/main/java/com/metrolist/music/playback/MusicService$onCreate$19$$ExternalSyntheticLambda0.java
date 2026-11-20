package com.metrolist.music.playback;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.lyrics.LyricsWithProvider;
import com.metrolist.music.models.MediaMetadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicService$onCreate$19$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaMetadata f$0;
    public final /* synthetic */ LyricsWithProvider f$1;

    public /* synthetic */ MusicService$onCreate$19$$ExternalSyntheticLambda0(MediaMetadata mediaMetadata, LyricsWithProvider lyricsWithProvider, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaMetadata;
        this.f$1 = lyricsWithProvider;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LyricsWithProvider lyricsWithProvider = this.f$1;
        MediaMetadata mediaMetadata = this.f$0;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        switch (b) {
            case 0:
                LyricsEntity lyricsEntity = new LyricsEntity(mediaMetadata.id, lyricsWithProvider.lyrics, lyricsWithProvider.provider);
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.upsert(lyricsEntity);
                break;
            default:
                LyricsEntity lyricsEntity2 = new LyricsEntity(mediaMetadata.id, lyricsWithProvider.lyrics, lyricsWithProvider.provider);
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.upsert(lyricsEntity2);
                break;
        }
        return unit;
    }
}
