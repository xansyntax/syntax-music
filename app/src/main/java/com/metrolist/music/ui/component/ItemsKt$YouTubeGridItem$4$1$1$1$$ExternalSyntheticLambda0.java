package com.metrolist.music.ui.component;

import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.music.db.MusicDatabase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$YouTubeGridItem$4$1$1$1$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AlbumPage f$0;

    public /* synthetic */ ItemsKt$YouTubeGridItem$4$1$1$1$$ExternalSyntheticLambda0(AlbumPage albumPage, byte b) {
        this.$r8$classId = b;
        this.f$0 = albumPage;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        AlbumPage albumPage = this.f$0;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        switch (b) {
            case 0:
                musicDatabase.insert(albumPage);
                break;
            default:
                musicDatabase.getClass();
                musicDatabase.insert(albumPage);
                break;
        }
        return unit;
    }
}
