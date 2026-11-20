package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OriginalLyricsKt$OriginalLyrics$performSmoothPageScroll$1 extends ContinuationImpl {
    public MutableState L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OriginalLyricsKt.OriginalLyrics$performSmoothPageScroll(null, null, null, false, 0, 0, this);
    }
}
