package com.metrolist.music.ui.menu;

import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.models.MediaMetadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ SongItem $firstSong;
    public final /* synthetic */ MediaMetadata $firstSongMedia;
    public final /* synthetic */ int $index;
    public final /* synthetic */ String[] $resolvedSongIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1(MusicDatabase musicDatabase, MediaMetadata mediaMetadata, String[] strArr, int i, SongItem songItem, Continuation continuation) {
        super(2, continuation);
        this.$database = musicDatabase;
        this.$firstSongMedia = mediaMetadata;
        this.$resolvedSongIds = strArr;
        this.$index = i;
        this.$firstSong = songItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1(this.$database, this.$firstSongMedia, this.$resolvedSongIds, this.$index, this.$firstSong, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1 addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1 = (AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        try {
            this.$database.insert(this.$firstSongMedia, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
        } catch (Exception e) {
            Timber.Forest.tag("Exception");
            e.toString();
            ConnectionPool.e(new Object[0]);
        }
        this.$resolvedSongIds[this.$index] = this.$firstSong.id;
        return Unit.INSTANCE;
    }
}
