package com.metrolist.music.lyrics;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.NextResult;
import java.util.concurrent.CancellationException;
import kotlin.Result;
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
public final class YouTubeLyricsProvider$getLyrics$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $id;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTubeLyricsProvider$getLyrics$2(String str, Continuation continuation) {
        super(2, continuation);
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new YouTubeLyricsProvider$getLyrics$2(this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((YouTubeLyricsProvider$getLyrics$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (r7 == r4) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Exception {
        Object failure;
        Object objM1024next0E7RQCE;
        Object objM1017lyricsgIAlus;
        byte b = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                YouTube youTube = YouTube.INSTANCE;
                WatchEndpoint watchEndpoint = new WatchEndpoint(62, this.$id, null, null);
                this.label = (byte) 1;
                objM1024next0E7RQCE = youTube.m1024next0E7RQCE(watchEndpoint, null, this);
                if (objM1024next0E7RQCE == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (b == 1) {
                ResultKt.throwOnFailure(obj);
                objM1024next0E7RQCE = ((Result) obj).value;
            } else {
                if (b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objM1017lyricsgIAlus = ((Result) obj).value;
            }
            ResultKt.throwOnFailure(objM1017lyricsgIAlus);
            failure = (String) objM1017lyricsgIAlus;
            if (failure != null) {
                return new Result(failure);
            }
            throw new IllegalStateException("Lyrics unavailable");
            ResultKt.throwOnFailure(objM1024next0E7RQCE);
            YouTube youTube2 = YouTube.INSTANCE;
            BrowseEndpoint browseEndpoint = ((NextResult) objM1024next0E7RQCE).lyricsEndpoint;
            if (browseEndpoint == null) {
                throw new IllegalStateException("Lyrics endpoint not found");
            }
            this.label = (byte) 2;
            objM1017lyricsgIAlus = youTube2.m1017lyricsgIAlus(browseEndpoint, this);
        } catch (Exception e) {
            if (e instanceof CancellationException) {
                throw e;
            }
            failure = new Result.Failure(e);
        }
    }
}
