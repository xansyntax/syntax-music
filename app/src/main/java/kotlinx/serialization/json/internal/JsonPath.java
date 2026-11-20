package kotlinx.serialization.json.internal;

import android.os.Bundle;
import android.os.HandlerThread;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.internal.NavBackStackEntryImpl;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.json.JsonConfiguration;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class JsonPath {
    public final /* synthetic */ byte $r8$classId;
    public final Object configuration;
    public int currentDepth;
    public Object currentObjectPath;
    public Object indicies;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes2.dex */
    public final class Tombstone {
        public static final Tombstone INSTANCE$1 = new Tombstone();
        public static final Tombstone INSTANCE = new Tombstone();
    }

    public JsonPath(Bundle bundle) {
        this.$r8$classId = (byte) 2;
        bundle.getClass();
        String string = bundle.getString("nav-entry-state:id");
        if (string == null) {
            FileSystemsKt.keyOrValueNotFoundError("nav-entry-state:id");
            throw null;
        }
        this.configuration = string;
        this.currentDepth = MathKt.m1876getIntimpl("nav-entry-state:destination-id", bundle);
        Bundle bundle2 = bundle.getBundle("nav-entry-state:args");
        if (bundle2 == null) {
            FileSystemsKt.keyOrValueNotFoundError("nav-entry-state:args");
            throw null;
        }
        this.currentObjectPath = bundle2;
        Bundle bundle3 = bundle.getBundle("nav-entry-state:saved-state");
        if (bundle3 != null) {
            this.indicies = bundle3;
        } else {
            FileSystemsKt.keyOrValueNotFoundError("nav-entry-state:saved-state");
            throw null;
        }
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.currentDepth + 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = ((Object[]) this.currentObjectPath)[i2];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                boolean zAreEqual = Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind$MAP.INSTANCE$2);
                int[] iArr = (int[]) this.indicies;
                if (!zAreEqual) {
                    int i3 = iArr[i2];
                    if (i3 >= 0) {
                        sb.append(".");
                        sb.append(serialDescriptor.getElementName(i3));
                    }
                } else if (iArr[i2] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.indicies)[i2]);
                    sb.append("]");
                }
            } else if (obj == Tombstone.INSTANCE$1) {
                sb.append("[<debug info disabled>]");
            } else if (obj != Tombstone.INSTANCE) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        return sb.toString();
    }

    public void releaseLooper() {
        HandlerThread handlerThread;
        synchronized (this.configuration) {
            try {
                UtilsKt.checkState(this.currentDepth > 0);
                int i = this.currentDepth - 1;
                this.currentDepth = i;
                if (i == 0 && (handlerThread = (HandlerThread) this.indicies) != null) {
                    handlerThread.quit();
                    this.indicies = null;
                    this.currentObjectPath = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void resize() {
        int i = this.currentDepth * 2;
        this.currentObjectPath = Arrays.copyOf((Object[]) this.currentObjectPath, i);
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = -1;
        }
        ArraysKt.copyInto$default(0, 0, 14, (int[]) this.indicies, iArr);
        this.indicies = iArr;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return getPath();
            default:
                return super.toString();
        }
    }

    public JsonPath(NavBackStackEntry navBackStackEntry, int i) {
        this.$r8$classId = (byte) 2;
        this.configuration = navBackStackEntry.id;
        this.currentDepth = i;
        NavBackStackEntryImpl navBackStackEntryImpl = navBackStackEntry.impl;
        this.currentObjectPath = navBackStackEntryImpl.getArguments$navigation_common_release();
        Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        this.indicies = bundleBundleOf;
        navBackStackEntryImpl.savedStateRegistryController.performSave(bundleBundleOf);
    }

    public JsonPath(JsonConfiguration jsonConfiguration) {
        this.$r8$classId = (byte) 0;
        this.configuration = jsonConfiguration;
        this.currentObjectPath = new Object[8];
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        this.indicies = iArr;
        this.currentDepth = -1;
    }

    public JsonPath() {
        this.$r8$classId = (byte) 1;
        this.configuration = new Object();
        this.currentObjectPath = null;
        this.indicies = null;
        this.currentDepth = 0;
    }
}
