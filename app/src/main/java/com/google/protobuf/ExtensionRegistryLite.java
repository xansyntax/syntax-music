package com.google.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExtensionRegistryLite {
    public static final ExtensionRegistryLite EMPTY_REGISTRY_LITE;
    public static volatile ExtensionRegistryLite emptyRegistry;

    static {
        ExtensionRegistryLite extensionRegistryLite = new ExtensionRegistryLite();
        Map map = Collections.EMPTY_MAP;
        EMPTY_REGISTRY_LITE = extensionRegistryLite;
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        ExtensionRegistryLite extensionRegistryLite;
        Class cls = Android.MEMORY_CLASS;
        ExtensionRegistryLite extensionRegistryLite2 = emptyRegistry;
        if (extensionRegistryLite2 != null) {
            return extensionRegistryLite2;
        }
        synchronized (ExtensionRegistryLite.class) {
            try {
                extensionRegistryLite = emptyRegistry;
                if (extensionRegistryLite == null) {
                    Class cls2 = ExtensionRegistryFactory.EXTENSION_REGISTRY_CLASS;
                    ExtensionRegistryLite extensionRegistryLite3 = null;
                    if (cls2 != null) {
                        try {
                            extensionRegistryLite3 = (ExtensionRegistryLite) cls2.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    extensionRegistryLite = extensionRegistryLite3 != null ? extensionRegistryLite3 : EMPTY_REGISTRY_LITE;
                    emptyRegistry = extensionRegistryLite;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return extensionRegistryLite;
    }
}
