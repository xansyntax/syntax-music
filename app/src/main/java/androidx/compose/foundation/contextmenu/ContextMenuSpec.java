package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.text.font.FontWeight;
import com.google.common.math.IntMath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContextMenuSpec {
    public static final BiasAlignment.Vertical LabelVerticalTextAlignment = Alignment.Companion.CenterVertically;
    public static final byte LabelHorizontalTextAlignment = 5;
    public static final float HorizontalPadding = 12.0f;
    public static final float VerticalPadding = 8.0f;
    public static final float IconSize = 24.0f;
    public static final float DividerHeight = 1.0f;
    public static final float DividerVerticalPadding = 8.0f;
    public static final long FontSize = IntMath.getSp(14);
    public static final FontWeight FontWeight = FontWeight.Medium;
    public static final long LineHeight = IntMath.getSp(20);
    public static final long LetterSpacing = IntMath.pack(4294967296L, 0.1f);
}
