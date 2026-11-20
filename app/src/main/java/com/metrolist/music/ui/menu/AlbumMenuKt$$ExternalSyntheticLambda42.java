package com.metrolist.music.ui.menu;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda42 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Album f$0;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda42(Album album, byte b) {
        this.$r8$classId = b;
        this.f$0 = album;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Album album = this.f$0;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        switch (b) {
            case 0:
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(album.album.toggleLike());
                break;
            case 1:
                if (album != null) {
                    AlbumEntity albumEntity = album.album;
                    musicDatabase.getClass();
                    musicDatabase.$$delegate_0.delete(albumEntity);
                }
                break;
            default:
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.delete(album.album);
                break;
        }
        return unit;
    }
}
