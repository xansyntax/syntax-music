package androidx.compose.foundation.text;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSize {
    public Density density;
    public FontFamily.Resolver fontFamilyResolver;
    public LayoutDirection layoutDirection;
    public TextStyle resolvedStyle;
    public Object typeface;
    public final ParcelableSnapshotMutableState dirty$delegate = Stack.mutableStateOf$default(Boolean.TRUE);
    public long minSize = 0;

    public TextFieldSize(LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, TextStyle textStyle, Object obj) {
        this.layoutDirection = layoutDirection;
        this.density = density;
        this.fontFamilyResolver = resolver;
        this.resolvedStyle = textStyle;
        this.typeface = obj;
    }

    public static void update$default(TextFieldSize textFieldSize, LayoutDirection layoutDirection, Density density, TextStyle textStyle, int i) {
        if ((i & 1) != 0) {
            layoutDirection = textFieldSize.layoutDirection;
        }
        if ((i & 2) != 0) {
            density = textFieldSize.density;
        }
        FontFamily.Resolver resolver = textFieldSize.fontFamilyResolver;
        if ((i & 8) != 0) {
            textStyle = textFieldSize.resolvedStyle;
        }
        Object obj = textFieldSize.typeface;
        LayoutDirection layoutDirection2 = textFieldSize.layoutDirection;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldSize.dirty$delegate;
        if (layoutDirection == layoutDirection2 && Intrinsics.areEqual(density, textFieldSize.density) && Intrinsics.areEqual(resolver, textFieldSize.fontFamilyResolver) && Intrinsics.areEqual(textStyle, textFieldSize.resolvedStyle)) {
            if (Intrinsics.areEqual(obj, textFieldSize.typeface)) {
                return;
            }
            textFieldSize.typeface = obj;
            parcelableSnapshotMutableState.setValue(Boolean.TRUE);
            return;
        }
        textFieldSize.layoutDirection = layoutDirection;
        textFieldSize.density = density;
        textFieldSize.fontFamilyResolver = resolver;
        textFieldSize.resolvedStyle = textStyle;
        parcelableSnapshotMutableState.setValue(Boolean.TRUE);
    }
}
