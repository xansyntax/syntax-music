package com.metrolist.music.ui.menu;

import com.metrolist.music.db.entities.Song;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongMenuKt$SongMenu$4$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Song $song;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SongMenuKt$SongMenu$4$1(Song song, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$song = song;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        Song song = this.$song;
        switch (b) {
            case 0:
                return new SongMenuKt$SongMenu$4$1(song, continuation, (byte) 0);
            default:
                return new SongMenuKt$SongMenu$4$1(song, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((SongMenuKt$SongMenu$4$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Song song = this.$song;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                break;
        }
        return CollectionsKt__IterablesKt.listOf(song.song.id);
    }
}
