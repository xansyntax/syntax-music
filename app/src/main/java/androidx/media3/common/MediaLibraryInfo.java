package androidx.media3.common;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaLibraryInfo {
    public static final HashSet registeredModules = new HashSet();
    public static String registeredModulesString = "media3.common";

    public static synchronized void registerModule(String str) {
        if (registeredModules.add(str)) {
            registeredModulesString += ", " + str;
        }
    }
}
