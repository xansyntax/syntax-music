package com.metrolist.music.playback;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences$Key;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.playback.queues.Queue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.utils.UtilsKt;
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
public final class MusicService$startRadioSeamlessly$1$initialStatus$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ YouTubeQueue $radioQueue;
    public boolean label;
    public final /* synthetic */ MusicService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicService$startRadioSeamlessly$1$initialStatus$1(YouTubeQueue youTubeQueue, MusicService musicService, Continuation continuation) {
        super(2, continuation);
        this.$radioQueue = youTubeQueue;
        this.this$0 = musicService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MusicService$startRadioSeamlessly$1$initialStatus$1(this.$radioQueue, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MusicService$startRadioSeamlessly$1$initialStatus$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            this.label = true;
            obj = this.$radioQueue.getInitialStatus(this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
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
        MusicService musicService = this.this$0;
        DataStore dataStore = UtilsKt.getDataStore(musicService);
        Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
        Boolean bool = Boolean.FALSE;
        return ((Queue.Status) obj).filterExplicit(((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue()).filterVideoSongs(((Boolean) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue());
    }
}
