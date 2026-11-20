package com.metrolist.music.ui.menu;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.SetVideoIdEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.utils.SyncUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongMenuKt$SongMenu$14$1$3$1$6$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ boolean $isEpisodeSaved;
    public final /* synthetic */ Song $song;
    public final /* synthetic */ SyncUtils $syncUtils;
    public int I$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SongMenuKt$SongMenu$14$1$3$1$6$1$1(boolean z, MusicDatabase musicDatabase, Song song, SyncUtils syncUtils, Continuation continuation) {
        super(2, continuation);
        this.$isEpisodeSaved = z;
        this.$database = musicDatabase;
        this.$song = song;
        this.$syncUtils = syncUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SongMenuKt$SongMenu$14$1$3$1$6$1$1(this.$isEpisodeSaved, this.$database, this.$song, this.$syncUtils, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SongMenuKt$SongMenu$14$1$3$1$6$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        ?? r2;
        Song song = this.$song;
        SongEntity songEntity = song.song;
        boolean z = this.label;
        String str = null;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            boolean z2 = this.$isEpisodeSaved;
            boolean z3 = !z2;
            SongMenuKt$$ExternalSyntheticLambda59 songMenuKt$$ExternalSyntheticLambda59 = new SongMenuKt$$ExternalSyntheticLambda59(song, z3, (byte) 1);
            MusicDatabase musicDatabase = this.$database;
            musicDatabase.query(songMenuKt$$ExternalSyntheticLambda59);
            if (z2) {
                String str2 = songEntity.id;
                this.I$0 = z3 ? 1 : 0;
                this.label = true;
                obj = musicDatabase.$$delegate_0.getSetVideoId(str2, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    r2 = z3;
                    return coroutineSingletons;
                }
                r2 = z3;
                i = z3 ? 1 : 0;
            }
            r2 = z3;
            this.$syncUtils.saveEpisode(songEntity.id, str, r2 != 0);
            return Unit.INSTANCE;
        }
        if (!z) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i = this.I$0;
        ResultKt.throwOnFailure(obj);
        SetVideoIdEntity setVideoIdEntity = (SetVideoIdEntity) obj;
        str = setVideoIdEntity != null ? setVideoIdEntity.setVideoId : null;
        r2 = i;
        r2 = z3;
        this.$syncUtils.saveEpisode(songEntity.id, str, r2 != 0);
        return Unit.INSTANCE;
    }
}
