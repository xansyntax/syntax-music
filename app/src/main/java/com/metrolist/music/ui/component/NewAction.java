package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NewAction {
    public final long backgroundColor;
    public final long contentColor;
    public final Function2 icon;
    public final ComposableLambdaImpl onClick;
    public final String text;

    public NewAction(Function2 function2, String str, ComposableLambdaImpl composableLambdaImpl) {
        Rgb rgb = ColorSpaces.Unspecified;
        long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        function2.getClass();
        str.getClass();
        this.icon = function2;
        this.text = str;
        this.onClick = composableLambdaImpl;
        this.backgroundColor = jColor;
        this.contentColor = jColor2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewAction) {
            NewAction newAction = (NewAction) obj;
            if (Intrinsics.areEqual(this.icon, newAction.icon) && Intrinsics.areEqual(this.text, newAction.text) && this.onClick == newAction.onClick && ULong.m1869equalsimpl0(this.backgroundColor, newAction.backgroundColor) && ULong.m1869equalsimpl0(this.contentColor, newAction.contentColor)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.contentColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((this.onClick.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.icon.hashCode() * 31, 31, this.text)) * 31, true, 31), 31, this.backgroundColor);
    }

    public final String toString() {
        String strM486toStringimpl = Color.m486toStringimpl(this.backgroundColor);
        String strM486toStringimpl2 = Color.m486toStringimpl(this.contentColor);
        StringBuilder sb = new StringBuilder("NewAction(icon=");
        sb.append(this.icon);
        sb.append(", text=");
        sb.append(this.text);
        sb.append(", onClick=");
        sb.append(this.onClick);
        sb.append(", enabled=true, backgroundColor=");
        sb.append(strM486toStringimpl);
        sb.append(", contentColor=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, strM486toStringimpl2, ")");
    }
}
