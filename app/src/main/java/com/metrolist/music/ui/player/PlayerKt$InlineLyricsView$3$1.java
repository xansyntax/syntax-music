package com.metrolist.music.ui.player;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.models.MediaMetadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerKt$InlineLyricsView$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $appInForeground$delegate;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MutableState $currentLyrics$delegate;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ MediaMetadata $mediaMetadata;
    public final /* synthetic */ MediaMetadata $nextMetadata;
    public final /* synthetic */ boolean $showLyrics;
    public int I$0;
    public /* synthetic */ Object L$0;
    public String L$1;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerKt$InlineLyricsView$3$1(boolean z, MediaMetadata mediaMetadata, MediaMetadata mediaMetadata2, MutableState mutableState, MutableState mutableState2, MusicDatabase musicDatabase, Context context, Continuation continuation) {
        super(2, continuation);
        this.$showLyrics = z;
        this.$nextMetadata = mediaMetadata;
        this.$mediaMetadata = mediaMetadata2;
        this.$appInForeground$delegate = mutableState;
        this.$currentLyrics$delegate = mutableState2;
        this.$database = musicDatabase;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PlayerKt$InlineLyricsView$3$1 playerKt$InlineLyricsView$3$1 = new PlayerKt$InlineLyricsView$3$1(this.$showLyrics, this.$nextMetadata, this.$mediaMetadata, this.$appInForeground$delegate, this.$currentLyrics$delegate, this.$database, this.$context, continuation);
        playerKt$InlineLyricsView$3$1.L$0 = obj;
        return playerKt$InlineLyricsView$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PlayerKt$InlineLyricsView$3$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MediaMetadata mediaMetadata;
        String str;
        int i;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        byte b = this.label;
        MutableState mutableState = this.$appInForeground$delegate;
        boolean z = this.$showLyrics;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            if (z && ((Boolean) mutableState.getValue()).booleanValue() && (mediaMetadata = this.$nextMetadata) != null) {
                LyricsEntity lyricsEntity = (LyricsEntity) this.$currentLyrics$delegate.getValue();
                int i2 = 0;
                MediaMetadata mediaMetadata2 = this.$mediaMetadata;
                if (lyricsEntity != null && (mediaMetadata2 == null || Intrinsics.areEqual(lyricsEntity.id, mediaMetadata2.id))) {
                    i2 = 1;
                }
                if (mediaMetadata2 == null || i2 != 0) {
                    String str2 = mediaMetadata.id;
                    this.L$0 = coroutineScope;
                    this.L$1 = str2;
                    this.I$0 = i2;
                    this.label = (byte) 1;
                    if (AwaitKt.delay(400L, this) != coroutineSingletons) {
                        str = str2;
                        i = i2;
                    }
                    return coroutineSingletons;
                }
            }
            return unit;
        }
        if (b != 1) {
            if (b == 2) {
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i = this.I$0;
        String str3 = this.L$1;
        ResultKt.throwOnFailure(obj);
        str = str3;
        if (z && ((Boolean) mutableState.getValue()).booleanValue() && AwaitKt.isActive(coroutineScope)) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(this.$database, str, this.$context, this.$nextMetadata, null, (byte) 9);
            this.L$0 = null;
            this.L$1 = null;
            this.I$0 = i;
            this.label = (byte) 2;
            if (AwaitKt.withContext(defaultIoScheduler, navHostKt$NavHost$29$1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return unit;
    }
}
