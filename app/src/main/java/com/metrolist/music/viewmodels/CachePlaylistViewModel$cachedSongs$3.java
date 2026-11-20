package com.metrolist.music.viewmodels;

import java.util.List;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CachePlaylistViewModel$cachedSongs$3 extends AdaptedFunctionReference implements Function4 {
    public static final CachePlaylistViewModel$cachedSongs$3 INSTANCE = new CachePlaylistViewModel$cachedSongs$3(4, CachePlaylistViewModel.Inputs.class, "<init>", "<init>(Ljava/util/List;ZZ)V", 4);

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return new CachePlaylistViewModel.Inputs((List) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue());
    }
}
