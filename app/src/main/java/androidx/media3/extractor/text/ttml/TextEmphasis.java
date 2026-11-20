package androidx.media3.extractor.text.ttml;

import com.google.common.collect.ImmutableSet;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextEmphasis {
    public final int markFill;
    public final int markShape;
    public final int position;
    public static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    public static final ImmutableSet SINGLE_STYLE_VALUES = ImmutableSet.construct(2, "auto", "none");
    public static final ImmutableSet MARK_SHAPE_VALUES = ImmutableSet.construct(3, "dot", "sesame", "circle");
    public static final ImmutableSet MARK_FILL_VALUES = ImmutableSet.construct(2, "filled", "open");
    public static final ImmutableSet POSITION_VALUES = ImmutableSet.construct(3, "after", "before", "outside");

    public TextEmphasis(int i, int i2, int i3) {
        this.markShape = i;
        this.markFill = i2;
        this.position = i3;
    }
}
