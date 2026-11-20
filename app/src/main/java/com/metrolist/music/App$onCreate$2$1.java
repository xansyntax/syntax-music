package com.metrolist.music;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.music.utils.InnerTubeXPlayer;
import com.yalantis.ucrop.view.CropImageView;
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
public final class App$onCreate$2$1 extends SuspendLambda implements Function2 {
    public int I$0;
    public /* synthetic */ Object L$0;
    public byte label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        App$onCreate$2$1 app$onCreate$2$1 = new App$onCreate$2$1(2, continuation);
        app$onCreate$2$1.L$0 = obj;
        return app$onCreate$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((App$onCreate$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062 A[Catch: all -> 0x0071, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0071, blocks: (B:7:0x0014, B:25:0x0062), top: B:32:0x000c }] */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(2500, r9) == r6) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(500, r9) == r6) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
    
        if (r10.prewarm(r9) == r6) goto L27;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005c -> B:24:0x005f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        byte b = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (b != 0) {
                if (b == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (b == 2) {
                        i = this.I$0;
                        ResultKt.throwOnFailure(obj);
                        i += CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION;
                        YouTube youTube = YouTube.INSTANCE;
                        if (((InnerTube.SessionSnapshot) YouTube.innerTube.innerTubeX.session.get()).visitorData == null || i >= 12000) {
                            InnerTubeXPlayer innerTubeXPlayer = InnerTubeXPlayer.INSTANCE;
                            this.L$0 = null;
                            this.I$0 = i;
                            this.label = (byte) 3;
                        } else {
                            this.L$0 = coroutineScope;
                            this.I$0 = i;
                            this.label = (byte) 2;
                        }
                        return coroutineSingletons;
                    }
                    if (b != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = coroutineScope;
            this.label = (byte) 1;
            i = 0;
            YouTube youTube2 = YouTube.INSTANCE;
            if (((InnerTube.SessionSnapshot) YouTube.innerTube.innerTubeX.session.get()).visitorData == null) {
                InnerTubeXPlayer innerTubeXPlayer2 = InnerTubeXPlayer.INSTANCE;
                this.L$0 = null;
                this.I$0 = i;
                this.label = (byte) 3;
            } else {
                InnerTubeXPlayer innerTubeXPlayer3 = InnerTubeXPlayer.INSTANCE;
                this.L$0 = null;
                this.I$0 = i;
                this.label = (byte) 3;
            }
            return coroutineSingletons;
        } catch (Throwable unused) {
        }
    }
}
