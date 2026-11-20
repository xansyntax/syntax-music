package com.metrolist.innertube;

import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.metrolist.innertubex.InnerTube$uploadSong$9;
import io.ktor.client.statement.HttpResponse;
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
public final class InnerTube$uploadSong$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ YouTube$$ExternalSyntheticLambda3 $content;
    public final /* synthetic */ long $contentLength;
    public final /* synthetic */ String $filename;
    public InnerTube L$0;
    public byte label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$uploadSong$2(InnerTube innerTube, String str, long j, YouTube$$ExternalSyntheticLambda3 youTube$$ExternalSyntheticLambda3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = innerTube;
        this.$filename = str;
        this.$contentLength = j;
        this.$content = youTube$$ExternalSyntheticLambda3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InnerTube$uploadSong$2(this.this$0, this.$filename, this.$contentLength, this.$content, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((InnerTube$uploadSong$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InnerTube innerTube;
        byte b = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            innerTube = this.this$0;
            com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
            ImageLoader$Builder$$ExternalSyntheticLambda1 imageLoader$Builder$$ExternalSyntheticLambda1 = new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 4, this.$content);
            this.L$0 = innerTube;
            this.label = (byte) 1;
            innerTube2.getClass();
            long j = this.$contentLength;
            if (j <= 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Upload content must not be empty");
                return null;
            }
            if (j >= 314572800) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Upload content must be smaller than 300 MiB");
                return null;
            }
            com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot = innerTube2.sessionSnapshot();
            obj = innerTube2.withSessionBoundRequest(sessionSnapshot, new InnerTube$uploadSong$9(innerTube2, sessionSnapshot, j, this.$filename, imageLoader$Builder$$ExternalSyntheticLambda1, null), this);
            if (obj != coroutineSingletons) {
            }
        }
        if (b != 1) {
            if (b == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        innerTube = this.L$0;
        ResultKt.throwOnFailure(obj);
        this.L$0 = null;
        this.label = (byte) 2;
        Object objRequireSuccess = innerTube.requireSuccess((HttpResponse) obj, "uploadSong", this);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }
}
