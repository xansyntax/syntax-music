package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import com.metrolist.innertube.YouTube;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistMenuKt$PlaylistMenu$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ Playlist $playlist;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $songs$delegate;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaylistMenuKt$PlaylistMenu$1$1(MusicDatabase musicDatabase, Playlist playlist, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 0;
        this.$database = musicDatabase;
        this.$playlist = playlist;
        this.$songs$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new PlaylistMenuKt$PlaylistMenu$1$1(this.$database, this.$playlist, this.$songs$delegate, continuation);
            case 1:
                return new PlaylistMenuKt$PlaylistMenu$1$1(this.$playlist, this.$songs$delegate, this.$database, continuation, (byte) 1);
            default:
                return new PlaylistMenuKt$PlaylistMenu$1$1(this.$playlist, this.$songs$delegate, this.$database, continuation, (byte) 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((PlaylistMenuKt$PlaylistMenu$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1035removeThumbnailPlaylistgIAlus;
        Object objM1035removeThumbnailPlaylistgIAlus2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MusicDatabase musicDatabase = this.$database;
        MutableState mutableState = this.$songs$delegate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Playlist playlist = this.$playlist;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Object obj2 = Boolean.FALSE;
                if (!obj2.equals(obj2)) {
                    mutableState.setValue(EmptyList.INSTANCE);
                    return unit;
                }
                Flow flowPlaylistSongs = musicDatabase.playlistSongs(playlist.playlist.id);
                AlbumMenuKt$AlbumMenu$1$1$1 albumMenuKt$AlbumMenu$1$1$1 = new AlbumMenuKt$AlbumMenu$1$1$1(mutableState, (byte) 1);
                this.label = true;
                return flowPlaylistSongs.collect(albumMenuKt$AlbumMenu$1$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube = YouTube.INSTANCE;
                    String str = playlist.playlist.browseId;
                    this.label = true;
                    objM1035removeThumbnailPlaylistgIAlus = youTube.m1035removeThumbnailPlaylistgIAlus(str, this);
                    if (objM1035removeThumbnailPlaylistgIAlus == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1035removeThumbnailPlaylistgIAlus = ((Result) obj).value;
                }
                if (objM1035removeThumbnailPlaylistgIAlus instanceof Result.Failure) {
                    return unit;
                }
                String str2 = (String) objM1035removeThumbnailPlaylistgIAlus;
                mutableState.setValue(str2);
                musicDatabase.query(new PlaylistMenuKt$$ExternalSyntheticLambda21(playlist, str2, (byte) 2));
                return unit;
            default:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube2 = YouTube.INSTANCE;
                    String str3 = playlist.playlist.browseId;
                    this.label = true;
                    objM1035removeThumbnailPlaylistgIAlus2 = youTube2.m1035removeThumbnailPlaylistgIAlus(str3, this);
                    if (objM1035removeThumbnailPlaylistgIAlus2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1035removeThumbnailPlaylistgIAlus2 = ((Result) obj).value;
                }
                if (objM1035removeThumbnailPlaylistgIAlus2 instanceof Result.Failure) {
                    return unit;
                }
                String str4 = (String) objM1035removeThumbnailPlaylistgIAlus2;
                mutableState.setValue(str4);
                musicDatabase.query(new PlaylistMenuKt$$ExternalSyntheticLambda21(playlist, str4, (byte) 3));
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaylistMenuKt$PlaylistMenu$1$1(Playlist playlist, MutableState mutableState, MusicDatabase musicDatabase, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$playlist = playlist;
        this.$songs$delegate = mutableState;
        this.$database = musicDatabase;
    }
}
