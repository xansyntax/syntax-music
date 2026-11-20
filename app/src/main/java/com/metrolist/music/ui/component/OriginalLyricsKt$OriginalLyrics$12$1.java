package com.metrolist.music.ui.component;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import java.util.List;
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
public final class OriginalLyricsKt$OriginalLyrics$12$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ParcelableSnapshotMutableIntState $currentLineIndex$delegate;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $deferredCurrentLineIndex$delegate;
    public final /* synthetic */ MutableState $initialScrollDone$delegate;
    public final /* synthetic */ MutableState $isAnimating$delegate;
    public final /* synthetic */ MutableState $isAppMinimized$delegate;
    public final /* synthetic */ MutableState $isAutoScrollEnabled$delegate;
    public final /* synthetic */ boolean $isLyricsProviderShown;
    public final /* synthetic */ MutableState $isSeeking$delegate;
    public final /* synthetic */ boolean $isSynced;
    public final /* synthetic */ ParcelableSnapshotMutableLongState $lastPreviewTime$delegate;
    public final /* synthetic */ LazyListState $lazyListState;
    public final /* synthetic */ List $lines;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $previousLineIndex$delegate;
    public final /* synthetic */ MutableState $scrollLyrics$delegate;
    public final /* synthetic */ MutableState $shouldScrollToFirstLine$delegate;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalLyricsKt$OriginalLyrics$12$1(boolean z, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState2, MutableState mutableState3, LazyListState lazyListState, MutableState mutableState4, List list, boolean z2, MutableState mutableState5, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2, MutableState mutableState6, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3, MutableState mutableState7, Continuation continuation) {
        super(2, continuation);
        this.$isSynced = z;
        this.$isAutoScrollEnabled$delegate = mutableState;
        this.$currentLineIndex$delegate = parcelableSnapshotMutableIntState;
        this.$shouldScrollToFirstLine$delegate = mutableState2;
        this.$initialScrollDone$delegate = mutableState3;
        this.$lazyListState = lazyListState;
        this.$isAnimating$delegate = mutableState4;
        this.$lines = list;
        this.$isLyricsProviderShown = z2;
        this.$isAppMinimized$delegate = mutableState5;
        this.$deferredCurrentLineIndex$delegate = parcelableSnapshotMutableIntState2;
        this.$isSeeking$delegate = mutableState6;
        this.$lastPreviewTime$delegate = parcelableSnapshotMutableLongState;
        this.$previousLineIndex$delegate = parcelableSnapshotMutableIntState3;
        this.$scrollLyrics$delegate = mutableState7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OriginalLyricsKt$OriginalLyrics$12$1(this.$isSynced, this.$isAutoScrollEnabled$delegate, this.$currentLineIndex$delegate, this.$shouldScrollToFirstLine$delegate, this.$initialScrollDone$delegate, this.$lazyListState, this.$isAnimating$delegate, this.$lines, this.$isLyricsProviderShown, this.$isAppMinimized$delegate, this.$deferredCurrentLineIndex$delegate, this.$isSeeking$delegate, this.$lastPreviewTime$delegate, this.$previousLineIndex$delegate, this.$scrollLyrics$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((OriginalLyricsKt$OriginalLyrics$12$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        if (com.metrolist.music.ui.component.OriginalLyricsKt.OriginalLyrics$performSmoothPageScroll(r15.$lazyListState, r15.$isAnimating$delegate, r2, r15.$isLyricsProviderShown, r4, 800, r15) == r12) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d1, code lost:
    
        if (com.metrolist.music.ui.component.OriginalLyricsKt.OriginalLyrics$performSmoothPageScroll(r15.$lazyListState, r15.$isAnimating$delegate, r2, r15.$isLyricsProviderShown, r0, com.yalantis.ucrop.view.CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, r15) == r12) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0115, code lost:
    
        if (com.metrolist.music.ui.component.OriginalLyricsKt.OriginalLyrics$performSmoothPageScroll(r15.$lazyListState, r15.$isAnimating$delegate, r2, r15.$isLyricsProviderShown, r4, 1500, r15) == r12) goto L46;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        byte b = this.label;
        MutableState mutableState = this.$initialScrollDone$delegate;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.$previousLineIndex$delegate;
        MutableState mutableState2 = this.$shouldScrollToFirstLine$delegate;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = this.$currentLineIndex$delegate;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$isSynced) {
                return unit;
            }
            int i = OriginalLyricsKt.$r8$clinit;
            if (((Boolean) this.$isAutoScrollEnabled$delegate.getValue()).booleanValue()) {
                int intValue = parcelableSnapshotMutableIntState2.getIntValue();
                List list = this.$lines;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if ((intValue == 0 && ((Boolean) mutableState2.getValue()).booleanValue()) || !((Boolean) mutableState.getValue()).booleanValue()) {
                    mutableState2.setValue(Boolean.FALSE);
                    int iMax = Math.max(0, parcelableSnapshotMutableIntState2.getIntValue());
                    this.label = (byte) 1;
                } else if (parcelableSnapshotMutableIntState2.getIntValue() != -1) {
                    this.$deferredCurrentLineIndex$delegate.setIntValue(parcelableSnapshotMutableIntState2.getIntValue());
                    if (((Boolean) this.$isSeeking$delegate.getValue()).booleanValue()) {
                        int iMax2 = Math.max(0, parcelableSnapshotMutableIntState2.getIntValue());
                        this.label = (byte) 2;
                    } else if ((this.$lastPreviewTime$delegate.getLongValue() == 0 || parcelableSnapshotMutableIntState2.getIntValue() != parcelableSnapshotMutableIntState.getIntValue()) && ((Boolean) this.$scrollLyrics$delegate.getValue()).booleanValue() && parcelableSnapshotMutableIntState2.getIntValue() != parcelableSnapshotMutableIntState.getIntValue()) {
                        int intValue2 = parcelableSnapshotMutableIntState2.getIntValue();
                        this.label = (byte) 3;
                    }
                }
                return coroutineSingletons;
            }
        } else if (b == 1) {
            ResultKt.throwOnFailure(obj);
            int i2 = OriginalLyricsKt.$r8$clinit;
            if (!((Boolean) this.$isAppMinimized$delegate.getValue()).booleanValue()) {
                mutableState.setValue(Boolean.TRUE);
            }
        } else {
            if (b != 2 && b != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        int i3 = OriginalLyricsKt.$r8$clinit;
        if (parcelableSnapshotMutableIntState2.getIntValue() > 0) {
            mutableState2.setValue(Boolean.TRUE);
        }
        parcelableSnapshotMutableIntState.setIntValue(parcelableSnapshotMutableIntState2.getIntValue());
        return unit;
    }
}
