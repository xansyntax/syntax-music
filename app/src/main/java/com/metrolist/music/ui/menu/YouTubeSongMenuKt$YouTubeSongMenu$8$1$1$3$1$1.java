package com.metrolist.music.ui.menu;

import com.metrolist.music.db.entities.SongEntity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTubeSongMenuKt$YouTubeSongMenu$8$1$1$3$1$1 extends AdaptedFunctionReference implements Function1 {
    public static final YouTubeSongMenuKt$YouTubeSongMenu$8$1$1$3$1$1 INSTANCE = new YouTubeSongMenuKt$YouTubeSongMenu$8$1$1$3$1$1(1, SongEntity.class, "toggleLike", "toggleLike(Z)Lcom/metrolist/music/db/entities/SongEntity;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SongEntity songEntity = (SongEntity) obj;
        songEntity.getClass();
        return songEntity.toggleLike(true);
    }
}
