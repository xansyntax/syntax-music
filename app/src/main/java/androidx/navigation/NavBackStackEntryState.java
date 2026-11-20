package androidx.navigation;

import android.os.Bundle;
import kotlinx.serialization.json.internal.JsonPath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavBackStackEntryState {
    public final JsonPath impl;

    public NavBackStackEntryState(Bundle bundle) {
        bundle.getClass();
        bundle.setClassLoader(NavBackStackEntryState.class.getClassLoader());
        this.impl = new JsonPath(bundle);
    }

    public NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        this.impl = new JsonPath(navBackStackEntry, navBackStackEntry.destination.impl.size);
    }
}
