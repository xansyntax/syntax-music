package com.metrolist.music.lyrics;

import coil3.ImageLoader$Builder;
import com.metrolist.music.models.MediaMetadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsHelper$getLyrics$1 extends ContinuationImpl {
    public MediaMetadata L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ImageLoader$Builder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsHelper$getLyrics$1(ImageLoader$Builder imageLoader$Builder, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = imageLoader$Builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLyrics(null, this);
    }
}
