package androidx.compose.material3.internal;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda44;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AccessibilityUtilKt {
    public static final Modifier IncreaseHorizontalSemanticsBounds;
    public static final Modifier IncreaseVerticalSemanticsBounds;

    static {
        MainActivity$$ExternalSyntheticLambda44 mainActivity$$ExternalSyntheticLambda44 = new MainActivity$$ExternalSyntheticLambda44((byte) 5);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        IncreaseHorizontalSemanticsBounds = OffsetKt.m137paddingVpY3zN4$default(SemanticsModifierKt.semantics(RulerKt.layout(companion, mainActivity$$ExternalSyntheticLambda44), true, new TextKt$$ExternalSyntheticLambda0((byte) 19)), 10.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
        IncreaseVerticalSemanticsBounds = OffsetKt.m137paddingVpY3zN4$default(SemanticsModifierKt.semantics(RulerKt.layout(companion, new MainActivity$$ExternalSyntheticLambda44((byte) 6)), true, new TextKt$$ExternalSyntheticLambda0((byte) 20)), CropImageView.DEFAULT_ASPECT_RATIO, 10.0f, 1);
    }
}
