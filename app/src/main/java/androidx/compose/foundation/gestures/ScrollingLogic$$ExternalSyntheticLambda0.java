package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScrollingLogic$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ScrollingLogic f$0;

    public /* synthetic */ ScrollingLogic$$ExternalSyntheticLambda0(ScrollingLogic scrollingLogic) {
        this.$r8$classId = (byte) 0;
        this.f$0 = scrollingLogic;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        boolean canScrollForward = false;
        ScrollingLogic scrollingLogic = this.f$0;
        switch (b) {
            case 0:
                return new Offset(scrollingLogic.m103performScroll3eAAhYA(scrollingLogic.outerStateScope, ((Offset) obj).packedValue, scrollingLogic.latestScrollSource));
            case 1:
                float fReverseIfNeeded = scrollingLogic.reverseIfNeeded(ProvidableModifierLocal.m627decodeToFloatsgRZ0Mg(((ScrollValue) obj).bits));
                if (fReverseIfNeeded < CropImageView.DEFAULT_ASPECT_RATIO) {
                    canScrollForward = scrollingLogic.scrollableState.getCanScrollBackward();
                } else if (fReverseIfNeeded > CropImageView.DEFAULT_ASPECT_RATIO) {
                    canScrollForward = scrollingLogic.scrollableState.getCanScrollForward();
                }
                return Boolean.valueOf(canScrollForward);
            default:
                float fReverseIfNeeded2 = scrollingLogic.reverseIfNeeded(ProvidableModifierLocal.m627decodeToFloatsgRZ0Mg(((ScrollValue) obj).bits));
                if (fReverseIfNeeded2 < CropImageView.DEFAULT_ASPECT_RATIO) {
                    canScrollForward = scrollingLogic.scrollableState.getCanScrollBackward();
                } else if (fReverseIfNeeded2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                    canScrollForward = scrollingLogic.scrollableState.getCanScrollForward();
                }
                return Boolean.valueOf(canScrollForward);
        }
    }

    public /* synthetic */ ScrollingLogic$$ExternalSyntheticLambda0(ScrollingLogic scrollingLogic, ProvidableModifierLocal providableModifierLocal, byte b) {
        this.$r8$classId = b;
        this.f$0 = scrollingLogic;
    }
}
