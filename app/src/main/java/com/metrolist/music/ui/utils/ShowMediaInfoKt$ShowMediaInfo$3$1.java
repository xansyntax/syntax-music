package com.metrolist.music.ui.utils;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.ui.menu.AlbumMenuKt$AlbumMenu$1$1$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShowMediaInfoKt$ShowMediaInfo$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $song$delegate;
    public final /* synthetic */ String $videoId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShowMediaInfoKt$ShowMediaInfo$3$1(MusicDatabase musicDatabase, String str, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$database = musicDatabase;
        this.$videoId = str;
        this.$song$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ShowMediaInfoKt$ShowMediaInfo$3$1(this.$database, this.$videoId, this.$song$delegate, continuation, (byte) 0);
            default:
                return new ShowMediaInfoKt$ShowMediaInfo$3$1(this.$database, this.$videoId, this.$song$delegate, continuation, (byte) 1);
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
        return ((ShowMediaInfoKt$ShowMediaInfo$3$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$song$delegate;
        String str = this.$videoId;
        MusicDatabase musicDatabase = this.$database;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
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
                Flow flowSong = musicDatabase.$$delegate_0.song(str);
                AlbumMenuKt$AlbumMenu$1$1$1 albumMenuKt$AlbumMenu$1$1$1 = new AlbumMenuKt$AlbumMenu$1$1$1(mutableState, (byte) 2);
                this.label = true;
                return flowSong.collect(albumMenuKt$AlbumMenu$1$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flow = musicDatabase.$$delegate_0.format(str);
                AlbumMenuKt$AlbumMenu$1$1$1 albumMenuKt$AlbumMenu$1$1$2 = new AlbumMenuKt$AlbumMenu$1$1$1(mutableState, (byte) 3);
                this.label = true;
                return flow.collect(albumMenuKt$AlbumMenu$1$1$2, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
