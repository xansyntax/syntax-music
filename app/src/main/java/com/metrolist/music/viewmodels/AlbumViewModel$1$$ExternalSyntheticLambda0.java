package com.metrolist.music.viewmodels;

import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumViewModel$1$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Album f$0;
    public final /* synthetic */ AlbumPage f$1;

    public /* synthetic */ AlbumViewModel$1$$ExternalSyntheticLambda0(Album album, AlbumPage albumPage, byte b) {
        this.$r8$classId = b;
        this.f$0 = album;
        this.f$1 = albumPage;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        AlbumPage albumPage = this.f$1;
        Album album = this.f$0;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        switch (b) {
            case 0:
                if (album != null) {
                    musicDatabase.update(album.album, albumPage, album.artists);
                } else {
                    musicDatabase.getClass();
                    musicDatabase.$$delegate_0.insert(albumPage);
                }
                break;
            case 1:
                musicDatabase.update(album.album, albumPage, album.artists);
                break;
            case 2:
                musicDatabase.getClass();
                musicDatabase.update(album.album, albumPage, album.artists);
                break;
            case 3:
                musicDatabase.getClass();
                musicDatabase.update(album.album, albumPage, album.artists);
                break;
            default:
                musicDatabase.getClass();
                musicDatabase.update(album.album, albumPage, album.artists);
                break;
        }
        return unit;
    }
}
