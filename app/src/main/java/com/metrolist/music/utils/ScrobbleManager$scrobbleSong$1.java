package com.metrolist.music.utils;

import com.metrolist.lastfm.LastFM;
import com.metrolist.music.models.MediaMetadata;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrobbleManager$scrobbleSong$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MediaMetadata $metadata;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ ScrobbleManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrobbleManager$scrobbleSong$1(MediaMetadata mediaMetadata, ScrobbleManager scrobbleManager, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 0;
        this.$metadata = mediaMetadata;
        this.this$0 = scrobbleManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        MediaMetadata mediaMetadata = this.$metadata;
        ScrobbleManager scrobbleManager = this.this$0;
        switch (b) {
            case 0:
                return new ScrobbleManager$scrobbleSong$1(mediaMetadata, scrobbleManager, continuation);
            case 1:
                return new ScrobbleManager$scrobbleSong$1(scrobbleManager, mediaMetadata, continuation, (byte) 1);
            default:
                return new ScrobbleManager$scrobbleSong$1(scrobbleManager, mediaMetadata, continuation, (byte) 2);
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
        return ((ScrobbleManager$scrobbleSong$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MediaMetadata mediaMetadata = this.$metadata;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ScrobbleManager scrobbleManager = this.this$0;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = ((Result) obj).value;
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                LastFM lastFM = LastFM.INSTANCE;
                String strJoinToString$default = CollectionsKt.joinToString$default(mediaMetadata.artists, null, null, null, new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 25), 31);
                String str = mediaMetadata.title;
                int i = mediaMetadata.duration;
                long j = scrobbleManager.songStartedAt;
                MediaMetadata.Album album = mediaMetadata.album;
                String str2 = album != null ? album.title : null;
                Integer num = new Integer(i);
                this.label = true;
                return lastFM.m1051scrobblebMdYcbs(strJoinToString$default, str, j, str2, num, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    long j2 = scrobbleManager.scrobbleRemainingMillis;
                    this.label = true;
                    if (AwaitKt.delay(j2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                AwaitKt.launch$default(scrobbleManager.scope, null, null, new ScrobbleManager$scrobbleSong$1(mediaMetadata, scrobbleManager, null), 3);
                scrobbleManager.scrobbleJob = null;
                return unit;
            default:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    long j3 = scrobbleManager.scrobbleRemainingMillis;
                    this.label = true;
                    if (AwaitKt.delay(j3, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                AwaitKt.launch$default(scrobbleManager.scope, null, null, new ScrobbleManager$scrobbleSong$1(mediaMetadata, scrobbleManager, null), 3);
                scrobbleManager.scrobbleJob = null;
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrobbleManager$scrobbleSong$1(ScrobbleManager scrobbleManager, MediaMetadata mediaMetadata, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = scrobbleManager;
        this.$metadata = mediaMetadata;
    }
}
