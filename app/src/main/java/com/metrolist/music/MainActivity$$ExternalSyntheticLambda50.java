package com.metrolist.music;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.metrolist.music.ui.component.BottomSheetState;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda50 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda50(Object obj, boolean z, boolean z2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = z;
        this.f$2 = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        float f = 1.0f;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$2;
        boolean z2 = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                int i = MainActivity.$r8$clinit;
                reusableGraphicsLayerScope.getClass();
                if (((BottomSheetState) obj2).getProgress() > CropImageView.DEFAULT_ASPECT_RATIO || (z2 && !z)) {
                    f = 0.0f;
                }
                reusableGraphicsLayerScope.setAlpha(f);
                break;
            case 1:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                int i2 = MainActivity.$r8$clinit;
                reusableGraphicsLayerScope2.getClass();
                if (((BottomSheetState) obj2).getProgress() > CropImageView.DEFAULT_ASPECT_RATIO || (z2 && !z)) {
                    f = 0.0f;
                }
                reusableGraphicsLayerScope2.setAlpha(f);
                break;
            default:
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                long jMo194provideF1C5BW0 = ((OffsetProvider) obj2).mo194provideF1C5BW0();
                semanticsPropertyReceiver.set(SelectionHandlesKt.SelectionHandleInfoKey, new SelectionHandleInfo(z2 ? Handle.SelectionStart : Handle.SelectionEnd, jMo194provideF1C5BW0, z ? SelectionHandleAnchor.Left : SelectionHandleAnchor.Right, (9223372034707292159L & jMo194provideF1C5BW0) != 9205357640488583168L));
                break;
        }
        return unit;
    }
}
