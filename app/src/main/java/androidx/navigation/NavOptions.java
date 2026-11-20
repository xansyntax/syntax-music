package androidx.navigation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavOptions {
    public final int enterAnim;
    public final int exitAnim;
    public final int popUpToId;
    public final boolean popUpToInclusive;
    public String popUpToRoute;
    public final boolean popUpToSaveState;
    public final boolean restoreState;
    public final boolean singleTop;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public int enterAnim;
        public int exitAnim;
        public String popUpToRoute;

        public Builder(String str, int i, int i2, int i3, long j) {
            this.popUpToRoute = str;
            this.exitAnim = i;
            this.enterAnim = i2;
        }
    }

    public NavOptions(boolean z, boolean z2, int i, boolean z3, boolean z4, int i2, int i3) {
        this.singleTop = z;
        this.restoreState = z2;
        this.popUpToId = i;
        this.popUpToInclusive = z3;
        this.popUpToSaveState = z4;
        this.enterAnim = i2;
        this.exitAnim = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavOptions)) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        return this.singleTop == navOptions.singleTop && this.restoreState == navOptions.restoreState && this.popUpToId == navOptions.popUpToId && Intrinsics.areEqual(this.popUpToRoute, navOptions.popUpToRoute) && this.popUpToInclusive == navOptions.popUpToInclusive && this.popUpToSaveState == navOptions.popUpToSaveState && this.enterAnim == navOptions.enterAnim && this.exitAnim == navOptions.exitAnim;
    }

    public final int hashCode() {
        int i = (((((this.singleTop ? 1 : 0) * 31) + (this.restoreState ? 1 : 0)) * 31) + this.popUpToId) * 31;
        String str = this.popUpToRoute;
        return ((((((((((((i + (str != null ? str.hashCode() : 0)) * 29791) + (this.popUpToInclusive ? 1 : 0)) * 31) + (this.popUpToSaveState ? 1 : 0)) * 31) + this.enterAnim) * 31) + this.exitAnim) * 31) - 1) * 31) - 1;
    }

    public final String toString() {
        String str = this.popUpToRoute;
        StringBuilder sb = new StringBuilder("NavOptions(");
        if (this.singleTop) {
            sb.append("launchSingleTop ");
        }
        if (this.restoreState) {
            sb.append("restoreState ");
        }
        if ((str != null || this.popUpToId != -1) && str != null) {
            sb.append("popUpTo(");
            sb.append(str);
            if (this.popUpToInclusive) {
                sb.append(" inclusive");
            }
            if (this.popUpToSaveState) {
                sb.append(" saveState");
            }
            sb.append(")");
        }
        int i = this.exitAnim;
        int i2 = this.enterAnim;
        if (i2 != -1 || i != -1) {
            sb.append("anim(enterAnim=0x");
            sb.append(Integer.toHexString(i2));
            sb.append(" exitAnim=0x");
            sb.append(Integer.toHexString(i));
            sb.append(" popEnterAnim=0x");
            sb.append(Integer.toHexString(-1));
            sb.append(" popExitAnim=0x");
            sb.append(Integer.toHexString(-1));
            sb.append(")");
        }
        return sb.toString();
    }
}
