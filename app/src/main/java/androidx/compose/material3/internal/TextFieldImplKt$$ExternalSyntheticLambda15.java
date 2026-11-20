package androidx.compose.material3.internal;

import androidx.compose.ui.unit.Dp;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldImplKt$$ExternalSyntheticLambda15 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 f$0;

    public /* synthetic */ TextFieldImplKt$$ExternalSyntheticLambda15(TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, byte b) {
        this.$r8$classId = b;
        this.f$0 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 = this.f$0;
        switch (b) {
            case 0:
                break;
        }
        return new Dp(LifecyclesKt.lerp(24.0f, 16.0f, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0.invoke()) + CropImageView.DEFAULT_ASPECT_RATIO);
    }
}
