package com.materialkolor.ktx;

import androidx.compose.animation.core.TransitionInstance;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorSchemeKt$animateFixedColors$$inlined$animateColor$1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TransitionInstance $this_animateValue;

    public /* synthetic */ ColorSchemeKt$animateFixedColors$$inlined$animateColor$1(TransitionInstance transitionInstance, byte b) {
        this.$r8$classId = b;
        this.$this_animateValue = transitionInstance;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        TransitionInstance transitionInstance = this.$this_animateValue;
        switch (b) {
            case 0:
                return transitionInstance.targetState$delegate.getValue();
            case 1:
                return transitionInstance.getSegment();
            case 2:
                return transitionInstance.targetState$delegate.getValue();
            case 3:
                return transitionInstance.getSegment();
            case 4:
                return transitionInstance.targetState$delegate.getValue();
            case 5:
                return transitionInstance.getSegment();
            case 6:
                return transitionInstance.targetState$delegate.getValue();
            case 7:
                return transitionInstance.getSegment();
            case 8:
                return transitionInstance.targetState$delegate.getValue();
            case 9:
                return transitionInstance.getSegment();
            case 10:
                return transitionInstance.targetState$delegate.getValue();
            case 11:
                return transitionInstance.getSegment();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return transitionInstance.targetState$delegate.getValue();
            case 13:
                return transitionInstance.getSegment();
            case 14:
                return transitionInstance.targetState$delegate.getValue();
            case 15:
                return transitionInstance.getSegment();
            case 16:
                return transitionInstance.targetState$delegate.getValue();
            case 17:
                return transitionInstance.getSegment();
            case 18:
                return transitionInstance.targetState$delegate.getValue();
            case 19:
                return transitionInstance.getSegment();
            case 20:
                return transitionInstance.targetState$delegate.getValue();
            case 21:
                return transitionInstance.getSegment();
            case 22:
                return transitionInstance.targetState$delegate.getValue();
            case 23:
                return transitionInstance.getSegment();
            case 24:
                return transitionInstance.getSegment();
            case 25:
                return transitionInstance.targetState$delegate.getValue();
            case 26:
                return transitionInstance.getSegment();
            case 27:
                return transitionInstance.targetState$delegate.getValue();
            case 28:
                return transitionInstance.getSegment();
            default:
                return transitionInstance.targetState$delegate.getValue();
        }
    }
}
