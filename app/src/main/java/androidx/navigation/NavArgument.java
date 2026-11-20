package androidx.navigation;

import kotlin.jvm.internal.Reflection;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavArgument {
    public final Object defaultValue;
    public final boolean isDefaultValuePresent;
    public final boolean isNullable;
    public final NavType type;

    public NavArgument(NavType navType, boolean z, Boolean bool, boolean z2) {
        if (!navType.isNullableAllowed && z) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) navType.getName().concat(" does not allow nullable values"));
            throw null;
        }
        if (!z && z2 && bool == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("Argument with type ", navType.getName(), " has null value but is not nullable.");
            throw null;
        }
        this.type = navType;
        this.isNullable = z;
        this.defaultValue = bool;
        this.isDefaultValuePresent = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavArgument.class != obj.getClass()) {
            return false;
        }
        NavArgument navArgument = (NavArgument) obj;
        if (this.isNullable != navArgument.isNullable || this.isDefaultValuePresent != navArgument.isDefaultValuePresent || !this.type.equals(navArgument.type)) {
            return false;
        }
        Object obj2 = navArgument.defaultValue;
        Object obj3 = this.defaultValue;
        if (obj3 != null) {
            return obj3.equals(obj2);
        }
        return obj2 == null;
    }

    public final int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + (this.isNullable ? 1 : 0)) * 31) + (this.isDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.defaultValue;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(NavArgument.class).getSimpleName());
        sb.append(" Type: " + this.type);
        sb.append(" Nullable: " + this.isNullable);
        if (this.isDefaultValuePresent) {
            sb.append(" DefaultValue: " + this.defaultValue);
        }
        return sb.toString();
    }
}
