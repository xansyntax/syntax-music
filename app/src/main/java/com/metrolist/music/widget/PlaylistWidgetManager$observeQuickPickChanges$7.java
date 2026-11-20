package com.metrolist.music.widget;

import android.content.pm.PackageManager;
import androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1;
import com.metrolist.music.db.MusicDatabase;
import java.time.LocalDateTime;
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
public final class PlaylistWidgetManager$observeQuickPickChanges$7 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ PlaylistWidgetManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaylistWidgetManager$observeQuickPickChanges$7(PlaylistWidgetManager playlistWidgetManager, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = playlistWidgetManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        PlaylistWidgetManager playlistWidgetManager = this.this$0;
        switch (b) {
            case 0:
                return new PlaylistWidgetManager$observeQuickPickChanges$7(playlistWidgetManager, continuation, (byte) 0);
            case 1:
                return new PlaylistWidgetManager$observeQuickPickChanges$7(playlistWidgetManager, continuation, (byte) 1);
            case 2:
                return new PlaylistWidgetManager$observeQuickPickChanges$7(playlistWidgetManager, continuation, (byte) 2);
            case 3:
                return new PlaylistWidgetManager$observeQuickPickChanges$7(playlistWidgetManager, continuation, (byte) 3);
            case 4:
                return new PlaylistWidgetManager$observeQuickPickChanges$7(playlistWidgetManager, continuation, (byte) 4);
            default:
                return new PlaylistWidgetManager$observeQuickPickChanges$7(playlistWidgetManager, continuation, (byte) 5);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((PlaylistWidgetManager$observeQuickPickChanges$7) create((PlaylistWidgetManager.QuickPickSnapshot) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((PlaylistWidgetManager$observeQuickPickChanges$7) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((PlaylistWidgetManager$observeQuickPickChanges$7) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                return ((PlaylistWidgetManager$observeQuickPickChanges$7) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 4:
                return ((PlaylistWidgetManager$observeQuickPickChanges$7) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((PlaylistWidgetManager$observeQuickPickChanges$7) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PackageManager.NameNotFoundException {
        switch (this.$r8$classId) {
            case 0:
                Unit unit = Unit.INSTANCE;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    PlaylistWidgetManager playlistWidgetManager = this.this$0;
                    this.label = true;
                    PlaylistWidgetManager.WidgetState widgetState = playlistWidgetManager.lastWidgetState;
                    Object objUpdateWidgets = playlistWidgetManager.updateWidgets(widgetState.title, widgetState.artist, widgetState.artworkUri, widgetState.isPlaying, widgetState.isLiked, widgetState.duration, widgetState.currentPosition, this);
                    if (objUpdateWidgets != coroutineSingletons) {
                        objUpdateWidgets = unit;
                    }
                    if (objUpdateWidgets == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            case 1:
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
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
                Flow flowDownloadedSongsByCreateDateAsc = this.this$0.database.$$delegate_0.downloadedSongsByCreateDateAsc();
                this.label = true;
                Object objFirst = StateFlowKt.first(flowDownloadedSongsByCreateDateAsc, this);
                return objFirst == coroutineSingletons2 ? coroutineSingletons2 : objFirst;
            case 2:
                CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowLikedSongsByCreateDateAsc = this.this$0.database.$$delegate_0.likedSongsByCreateDateAsc();
                this.label = true;
                Object objFirst2 = StateFlowKt.first(flowLikedSongsByCreateDateAsc, this);
                return objFirst2 == coroutineSingletons3 ? coroutineSingletons3 : objFirst2;
            case 3:
                CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowPlaylistsByCreateDateAsc = this.this$0.database.$$delegate_0.playlistsByCreateDateAsc();
                this.label = true;
                Object objFirst3 = StateFlowKt.first(flowPlaylistsByCreateDateAsc, this);
                return objFirst3 == coroutineSingletons4 ? coroutineSingletons4 : objFirst3;
            case 4:
                CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                FlowUtil$createFlow$$inlined$map$1 all = this.this$0.database.delegate.getSpeedDialDao().getAll();
                this.label = true;
                Object objFirst4 = StateFlowKt.first(all, this);
                return objFirst4 == coroutineSingletons5 ? coroutineSingletons5 : objFirst4;
            default:
                CoroutineSingletons coroutineSingletons6 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z6 = this.label;
                if (z6) {
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                MusicDatabase musicDatabase = this.this$0.database;
                LocalDateTime localDateTimeOf = LocalDateTime.of(1970, 1, 1, 0, 0);
                localDateTimeOf.getClass();
                LocalDateTime localDateTimeNow = LocalDateTime.now();
                musicDatabase.getClass();
                Flow flowMostPlayedSongs = musicDatabase.$$delegate_0.mostPlayedSongs(localDateTimeOf, 50, 0, localDateTimeNow);
                this.label = true;
                Object objFirst5 = StateFlowKt.first(flowMostPlayedSongs, this);
                return objFirst5 == coroutineSingletons6 ? coroutineSingletons6 : objFirst5;
        }
    }
}
