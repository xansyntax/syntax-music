package com.metrolist.music.utils;

import android.net.ConnectivityManager;
import com.metrolist.innertubex.extraction.ContentHints;
import com.metrolist.music.constants.AudioQuality;
import java.util.Set;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTubeXPlayer$playerResponseForPlayback$1 extends ContinuationImpl {
    public String L$0;
    public AudioQuality L$2;
    public ConnectivityManager L$3;
    public ContentHints L$5;
    public Set L$6;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InnerTubeXPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTubeXPlayer$playerResponseForPlayback$1(InnerTubeXPlayer innerTubeXPlayer, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = innerTubeXPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM1519playerResponseForPlaybackbMdYcbs = this.this$0.m1519playerResponseForPlaybackbMdYcbs(null, null, null, null, false, this);
        return objM1519playerResponseForPlaybackbMdYcbs == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1519playerResponseForPlaybackbMdYcbs : new Result(objM1519playerResponseForPlaybackbMdYcbs);
    }
}
