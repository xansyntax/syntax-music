package androidx.compose.ui.window;

import android.os.IBinder;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PopupProperties {
    public final float blurBehindRadius;
    public final boolean dismissOnBackPress;
    public final boolean dismissOnClickOutside;
    public final boolean excludeFromSystemGesture;
    public final int flags;
    public final boolean inheritSecurePolicy;
    public final float scrimAlpha;
    public final IBinder windowToken;
    public final int windowType;

    /* JADX WARN: Illegal instructions before constructor call */
    public PopupProperties(boolean z, SecureFlagPolicy secureFlagPolicy, boolean z2, int i) {
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidPopup_androidKt.LocalPopupTestTag;
        int i2 = !z ? 262152 : 262144;
        i2 = secureFlagPolicy == SecureFlagPolicy.SecureOn ? i2 | 8192 : i2;
        this(z2 ? i2 : i2 | 512, secureFlagPolicy == SecureFlagPolicy.Inherit, 1002, (IBinder) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupProperties)) {
            return false;
        }
        PopupProperties popupProperties = (PopupProperties) obj;
        if (this.flags != popupProperties.flags || this.inheritSecurePolicy != popupProperties.inheritSecurePolicy || this.dismissOnBackPress != popupProperties.dismissOnBackPress || this.dismissOnClickOutside != popupProperties.dismissOnClickOutside || this.excludeFromSystemGesture != popupProperties.excludeFromSystemGesture || this.windowType != popupProperties.windowType || !Intrinsics.areEqual(this.windowToken, popupProperties.windowToken) || !Dp.m796equalsimpl0(this.blurBehindRadius, popupProperties.blurBehindRadius)) {
            return false;
        }
        float f = popupProperties.scrimAlpha;
        float f2 = this.scrimAlpha;
        return (Float.isNaN(f2) && Float.isNaN(f)) || f2 == f;
    }

    public final int hashCode() {
        int iM = (IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.flags * 31, this.inheritSecurePolicy, 31), this.dismissOnBackPress, 31), this.dismissOnClickOutside, 31), this.excludeFromSystemGesture, 31), false, 31) + this.windowType) * 31;
        IBinder iBinder = this.windowToken;
        return Float.hashCode(this.scrimAlpha) + IntIntPair$$ExternalSyntheticOutline0.m(this.blurBehindRadius, (iM + (iBinder != null ? iBinder.hashCode() : 0)) * 31, 31);
    }

    public PopupProperties(int i, boolean z, int i2, IBinder iBinder) {
        this.flags = i;
        this.inheritSecurePolicy = z;
        this.dismissOnBackPress = true;
        this.dismissOnClickOutside = true;
        this.excludeFromSystemGesture = true;
        this.windowType = i2;
        this.windowToken = iBinder;
        this.blurBehindRadius = Float.NaN;
        this.scrimAlpha = Float.NaN;
    }

    public PopupProperties(boolean z, int i) {
        this((i & 1) != 0 ? false : z, SecureFlagPolicy.Inherit, (i & 8) != 0, 1536);
    }
}
