package com.metrolist.music.playback;

import android.content.Intent;
import com.metrolist.music.playback.queues.Queue;
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
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicService$handlePlaylistWidgetPlay$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Intent $intent;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ MusicService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MusicService$handlePlaylistWidgetPlay$1(MusicService musicService, Intent intent, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = musicService;
        this.$intent = intent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Intent intent = this.$intent;
        MusicService musicService = this.this$0;
        switch (b) {
            case 0:
                return new MusicService$handlePlaylistWidgetPlay$1(musicService, intent, continuation, (byte) 0);
            default:
                return new MusicService$handlePlaylistWidgetPlay$1(musicService, intent, continuation, (byte) 1);
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
        return ((MusicService$handlePlaylistWidgetPlay$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Continuation continuation = null;
        byte b = 1;
        switch (this.$r8$classId) {
            case 0:
                Unit unit = Unit.INSTANCE;
                Intent intent = this.$intent;
                MusicService musicService = this.this$0;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z = this.label;
                try {
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                        MusicService$handlePlaylistWidgetPlay$1 musicService$handlePlaylistWidgetPlay$1 = new MusicService$handlePlaylistWidgetPlay$1(musicService, intent, continuation, b);
                        this.label = true;
                        obj = AwaitKt.withContext(defaultIoScheduler, musicService$handlePlaylistWidgetPlay$1, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Queue queue = (Queue) obj;
                    if (queue == null) {
                        boolean z2 = MusicService.isRunning;
                        musicService.openPlaylistWidgetTarget(intent);
                    } else {
                        boolean z3 = MusicService.isRunning;
                        musicService.playQueue(queue, true, false);
                        MusicService.updateWidgetUI$default(musicService, true);
                    }
                } catch (Throwable unused) {
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.e$1(new Object[0]);
                    boolean z4 = MusicService.isRunning;
                    musicService.openPlaylistWidgetTarget(intent);
                }
                return unit;
            default:
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
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
                MusicService musicService2 = this.this$0;
                Intent intent2 = this.$intent;
                this.label = true;
                boolean z6 = MusicService.isRunning;
                Object objBuildPlaylistWidgetQueue = musicService2.buildPlaylistWidgetQueue(intent2, this);
                return objBuildPlaylistWidgetQueue == coroutineSingletons2 ? coroutineSingletons2 : objBuildPlaylistWidgetQueue;
        }
    }
}
