package com.metrolist.music.recognition;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioResampler$resample$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AudioResampler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioResampler$resample$1(AudioResampler audioResampler, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = audioResampler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM1452resample0E7RQCE = this.this$0.m1452resample0E7RQCE(null, 0, this);
        return objM1452resample0E7RQCE == CoroutineSingletons.COROUTINE_SUSPENDED ? objM1452resample0E7RQCE : new Result(objM1452resample0E7RQCE);
    }
}
