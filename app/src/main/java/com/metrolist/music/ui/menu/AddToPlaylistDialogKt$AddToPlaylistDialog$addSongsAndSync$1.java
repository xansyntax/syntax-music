package com.metrolist.music.ui.menu;

import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.utils.SyncUtils;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AddToPlaylistDialogKt$AddToPlaylistDialog$addSongsAndSync$1 extends ContinuationImpl {
    public SyncUtils L$2;
    public Playlist L$3;
    public List L$4;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AlbumMenuKt.AddToPlaylistDialog$addSongsAndSync(null, null, null, null, null, this);
    }
}
