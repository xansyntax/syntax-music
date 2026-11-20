package com.metrolist.music.ui.menu;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Artist $artist;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1(PlayerConnection playerConnection, Artist artist, MusicDatabase musicDatabase, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$playerConnection = playerConnection;
        this.$artist = artist;
        this.$database = musicDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1(this.$playerConnection, this.$artist, this.$database, continuation, (byte) 0);
            default:
                return new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1(this.$playerConnection, this.$artist, this.$database, continuation, (byte) 1);
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
        return ((ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objWithContext;
        Object objWithContext2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PlayerConnection playerConnection = this.$playerConnection;
        MusicDatabase musicDatabase = this.$database;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Artist artist = this.$artist;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1 artistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1 = new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1(musicDatabase, artist, null, (byte) 0);
                    this.label = true;
                    objWithContext = AwaitKt.withContext(defaultIoScheduler, artistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1, this);
                    if (objWithContext == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objWithContext = obj;
                }
                playerConnection.playQueue(new ListQueue(artist.artist.name, (List) objWithContext, 0, 0L, 12, null));
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                    ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1 artistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$2 = new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$1(musicDatabase, artist, null, (byte) 1);
                    this.label = true;
                    objWithContext2 = AwaitKt.withContext(defaultIoScheduler2, artistMenuKt$ArtistMenu$1$1$1$1$1$1$1$songs$2, this);
                    if (objWithContext2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objWithContext2 = obj;
                }
                playerConnection.playQueue(new ListQueue(artist.artist.name, (List) objWithContext2, 0, 0L, 12, null));
                return unit;
        }
    }
}
