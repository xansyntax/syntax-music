package androidx.navigation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.util.UtilsKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavigatorProvider {
    public static final LinkedHashMap annotationNames = new LinkedHashMap();
    public final LinkedHashMap _navigators = new LinkedHashMap();

    public final void addNavigator(Navigator navigator) {
        navigator.getClass();
        String nameForNavigator$navigation_common_release = UtilsKt.getNameForNavigator$navigation_common_release(navigator.getClass());
        if (nameForNavigator$navigation_common_release.length() <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("navigator name cannot be an empty string");
            return;
        }
        LinkedHashMap linkedHashMap = this._navigators;
        Navigator navigator2 = (Navigator) linkedHashMap.get(nameForNavigator$navigation_common_release);
        if (Intrinsics.areEqual(navigator2, navigator)) {
            return;
        }
        if (navigator2 != null && navigator2.isAttached) {
            PathKt$$ExternalSyntheticBUOutline0.m("Navigator ", navigator, " is replacing an already attached ", navigator2);
        } else if (navigator.isAttached) {
            PathKt$$ExternalSyntheticBUOutline0.m("Navigator ", navigator, " is already attached to another NavController");
        }
    }

    public final Navigator getNavigator(String str) {
        str.getClass();
        if (str.length() <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("navigator name cannot be an empty string");
            return null;
        }
        Navigator navigator = (Navigator) this._navigators.get(str);
        if (navigator != null) {
            return navigator;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m("Could not find Navigator with name \"", str, "\". You must call NavController.addNavigator() for each navigation type."));
        return null;
    }
}
