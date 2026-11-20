package com.metrolist.music.lyrics;

import coil3.ImageLoader$Builder;
import com.metrolist.music.utils.SyncUtils$special$$inlined$map$1;
import com.metrolist.music.viewmodels.HomeViewModel$2$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsHelper$special$$inlined$map$1 implements Flow {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;
    public final /* synthetic */ ImageLoader$Builder this$0;

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsHelper$special$$inlined$map$1$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LyricsHelper$special$$inlined$map$1.this.collect(null, this);
        }
    }

    public /* synthetic */ LyricsHelper$special$$inlined$map$1(Flow flow, ImageLoader$Builder imageLoader$Builder, byte b) {
        this.$r8$classId = b;
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = imageLoader$Builder;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0098  */
    /* JADX WARN: Code duplicated, block: B:9:0x0024  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1 lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1;
        LyricsHelper$getLyrics$$inlined$map$1$1 lyricsHelper$getLyrics$$inlined$map$1$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ImageLoader$Builder imageLoader$Builder = this.this$0;
        Flow flow = this.$this_unsafeTransform$inlined;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                if (continuation instanceof AnonymousClass1) {
                    anonymousClass1 = (AnonymousClass1) continuation;
                    int i = anonymousClass1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        anonymousClass1.label = i - Integer.MIN_VALUE;
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
                Object obj = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    SyncUtils$special$$inlined$map$1.AnonymousClass2 anonymousClass2 = new SyncUtils$special$$inlined$map$1.AnonymousClass2(flowCollector, imageLoader$Builder, (byte) 3);
                    anonymousClass1.label = 1;
                    return flow.collect(anonymousClass2, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                if (continuation instanceof LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1) {
                    lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1 = (LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1) continuation;
                    int i3 = lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1 = new LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1 = new LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj2 = lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1.result;
                int i4 = lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    HomeViewModel$2$1 homeViewModel$2$1 = new HomeViewModel$2$1(flowCollector, imageLoader$Builder, (byte) 4);
                    lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1.label = 1;
                    return flow.collect(homeViewModel$2$1, lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof LyricsHelper$getLyrics$$inlined$map$1$1) {
                    lyricsHelper$getLyrics$$inlined$map$1$1 = (LyricsHelper$getLyrics$$inlined$map$1$1) continuation;
                    int i5 = lyricsHelper$getLyrics$$inlined$map$1$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        lyricsHelper$getLyrics$$inlined$map$1$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        lyricsHelper$getLyrics$$inlined$map$1$1 = new LyricsHelper$getLyrics$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    lyricsHelper$getLyrics$$inlined$map$1$1 = new LyricsHelper$getLyrics$$inlined$map$1$1(this, continuation);
                }
                Object obj3 = lyricsHelper$getLyrics$$inlined$map$1$1.result;
                int i6 = lyricsHelper$getLyrics$$inlined$map$1$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    SyncUtils$special$$inlined$map$1.AnonymousClass2 anonymousClass3 = new SyncUtils$special$$inlined$map$1.AnonymousClass2(flowCollector, imageLoader$Builder, (byte) 2);
                    lyricsHelper$getLyrics$$inlined$map$1$1.label = 1;
                    return flow.collect(anonymousClass3, lyricsHelper$getLyrics$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
