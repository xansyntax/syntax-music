package com.metrolist.innertube;

import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$getMediaInfo$1 extends ContinuationImpl {
    public String L$0;
    public InnerTube L$1;
    public YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer L$2;
    public YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$getMediaInfo$1(InnerTube innerTube, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = innerTube;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM985getMediaInfogIAlus = this.this$0.m985getMediaInfogIAlus(null, this);
        return objM985getMediaInfogIAlus == CoroutineSingletons.COROUTINE_SUSPENDED ? objM985getMediaInfogIAlus : new Result(objM985getMediaInfogIAlus);
    }
}
