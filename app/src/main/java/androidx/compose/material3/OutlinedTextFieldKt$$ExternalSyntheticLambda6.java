package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Shape;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OutlinedTextFieldKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MutableInteractionSourceImpl f$2;
    public final /* synthetic */ TextFieldColors f$3;
    public final /* synthetic */ Shape f$4;

    public /* synthetic */ OutlinedTextFieldKt$$ExternalSyntheticLambda6(boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, TextFieldColors textFieldColors, Shape shape, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$2 = mutableInteractionSourceImpl;
        this.f$3 = textFieldColors;
        this.f$4 = shape;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextFieldDefaults.INSTANCE$3.m350Container4EFweAY(this.f$0, this.f$2, null, this.f$3, this.f$4, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer, 100663296, 200);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextFieldDefaults.INSTANCE$3.m350Container4EFweAY(this.f$0, this.f$2, null, this.f$3, this.f$4, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2, 100663296, 200);
                }
                break;
        }
        return unit;
    }
}
