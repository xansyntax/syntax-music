package com.metrolist.paxsenix;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Paxsenix$fetchLyricsForTrack$1 extends ContinuationImpl {
    public Paxsenix L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Paxsenix this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Paxsenix$fetchLyricsForTrack$1(Paxsenix paxsenix, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = paxsenix;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Serializable serializableM1531fetchLyricsForTrackgIAlus = this.this$0.m1531fetchLyricsForTrackgIAlus(null, this);
        return serializableM1531fetchLyricsForTrackgIAlus == CoroutineSingletons.COROUTINE_SUSPENDED ? serializableM1531fetchLyricsForTrackgIAlus : new Result(serializableM1531fetchLyricsForTrackgIAlus);
    }
}
