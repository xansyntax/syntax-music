package androidx.room.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewInfo {
    public final String name;
    public final String sql;

    public ViewInfo(String str, String str2) {
        str.getClass();
        this.name = str;
        this.sql = str2;
    }

    public final boolean equals(Object obj) {
        boolean zAreEqual;
        if (this != obj) {
            if (obj instanceof ViewInfo) {
                ViewInfo viewInfo = (ViewInfo) obj;
                if (Intrinsics.areEqual(this.name, viewInfo.name)) {
                    String str = viewInfo.sql;
                    String str2 = this.sql;
                    if (str2 != null) {
                        zAreEqual = Intrinsics.areEqual(str2, str);
                    } else {
                        zAreEqual = str == null;
                    }
                    if (zAreEqual) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.sql;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return StringsKt__IndentKt.trimMargin$default("\n            |ViewInfo {\n            |   name = '" + this.name + "',\n            |   sql = '" + this.sql + "'\n            |}\n        ");
    }
}
