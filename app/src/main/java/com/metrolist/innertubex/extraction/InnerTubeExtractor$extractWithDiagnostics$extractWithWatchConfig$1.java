package com.metrolist.innertubex.extraction;

import androidx.media3.exoplayer.DefaultMediaClock;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTubeExtractor$extractWithDiagnostics$extractWithWatchConfig$1 extends ContinuationImpl {
    public InnerTubeExtractor L$0;
    public DefaultMediaClock L$6;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return InnerTubeExtractor.extractWithDiagnostics$extractWithWatchConfig(null, null, null, null, null, 0L, null, null, null, false, this);
    }
}
