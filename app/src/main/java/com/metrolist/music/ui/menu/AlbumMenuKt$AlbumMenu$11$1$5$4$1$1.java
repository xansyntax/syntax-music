package com.metrolist.music.ui.menu;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.viewmodels.AlbumViewModel$1$$ExternalSyntheticLambda0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumMenuKt$AlbumMenu$11$1$5$4$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Album $album;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ byte $r8$classId = 1;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumMenuKt$AlbumMenu$11$1$5$4$1$1(MusicDatabase musicDatabase, Album album, Continuation continuation) {
        super(2, continuation);
        this.$database = musicDatabase;
        this.$album = album;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Album album = this.$album;
        MusicDatabase musicDatabase = this.$database;
        switch (b) {
            case 0:
                return new AlbumMenuKt$AlbumMenu$11$1$5$4$1$1(album, musicDatabase, continuation);
            default:
                return new AlbumMenuKt$AlbumMenu$11$1$5$4$1$1(musicDatabase, album, continuation);
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
        }
        return ((AlbumMenuKt$AlbumMenu$11$1$5$4$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM996album0E7RQCE;
        byte b = this.$r8$classId;
        Album album = this.$album;
        MusicDatabase musicDatabase = this.$database;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube = YouTube.INSTANCE;
                    String str = album.album.id;
                    this.label = true;
                    objM996album0E7RQCE = YouTube.INSTANCE.m996album0E7RQCE(str, true, this);
                    if (objM996album0E7RQCE == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM996album0E7RQCE = ((Result) obj).value;
                }
                if (!(objM996album0E7RQCE instanceof Result.Failure)) {
                    musicDatabase.transaction(new AlbumViewModel$1$$ExternalSyntheticLambda0(album, (AlbumPage) objM996album0E7RQCE, (byte) 1));
                }
                return Unit.INSTANCE;
            default:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowAlbumWithSongs = musicDatabase.albumWithSongs(album.album.id);
                this.label = true;
                Object objFirstOrNull = StateFlowKt.firstOrNull(flowAlbumWithSongs, this);
                return objFirstOrNull == coroutineSingletons ? coroutineSingletons : objFirstOrNull;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumMenuKt$AlbumMenu$11$1$5$4$1$1(Album album, MusicDatabase musicDatabase, Continuation continuation) {
        super(2, continuation);
        this.$album = album;
        this.$database = musicDatabase;
    }
}
