package com.metrolist.innertube;

import com.metrolist.innertube.models.AlbumItem;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTube$albumSongs$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public AlbumItem L$1;
    public List L$5;
    public Set L$7;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ YouTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTube$albumSongs$1(YouTube youTube, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = youTube;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM997albumSongs0E7RQCE = this.this$0.m997albumSongs0E7RQCE(null, null, this);
        return objM997albumSongs0E7RQCE == CoroutineSingletons.COROUTINE_SUSPENDED ? objM997albumSongs0E7RQCE : new Result(objM997albumSongs0E7RQCE);
    }
}
