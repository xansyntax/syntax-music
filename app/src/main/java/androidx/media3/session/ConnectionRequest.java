package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionRequest {
    public static final String FIELD_CONNECTION_HINTS;
    public static final String FIELD_CONTROLLER_INTERFACE_VERSION;
    public static final String FIELD_LIBRARY_VERSION;
    public static final String FIELD_MAX_COMMANDS_FOR_MEDIA_ITEM;
    public static final String FIELD_PACKAGE_NAME;
    public static final String FIELD_PID;
    public final Bundle connectionHints;
    public final int controllerInterfaceVersion;
    public final int libraryVersion;
    public final int maxCommandsForMediaItems;
    public final String packageName;
    public final int pid;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_LIBRARY_VERSION = Integer.toString(0, 36);
        FIELD_PACKAGE_NAME = Integer.toString(1, 36);
        FIELD_PID = Integer.toString(2, 36);
        FIELD_CONNECTION_HINTS = Integer.toString(3, 36);
        FIELD_CONTROLLER_INTERFACE_VERSION = Integer.toString(4, 36);
        FIELD_MAX_COMMANDS_FOR_MEDIA_ITEM = Integer.toString(5, 36);
    }

    public ConnectionRequest(String str, int i, Bundle bundle) {
        this(1010001300, 9, str, i, new Bundle(bundle), 0);
    }

    public static ConnectionRequest fromBundle(Bundle bundle) {
        int i = bundle.getInt(FIELD_LIBRARY_VERSION, 0);
        int i2 = bundle.getInt(FIELD_CONTROLLER_INTERFACE_VERSION, 0);
        String string = bundle.getString(FIELD_PACKAGE_NAME);
        string.getClass();
        String str = FIELD_PID;
        UtilsKt.checkArgument(bundle.containsKey(str));
        int i3 = bundle.getInt(str);
        Bundle bundle2 = bundle.getBundle(FIELD_CONNECTION_HINTS);
        int i4 = bundle.getInt(FIELD_MAX_COMMANDS_FOR_MEDIA_ITEM, 0);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new ConnectionRequest(i, i2, string, i3, bundle2, i4);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_LIBRARY_VERSION, this.libraryVersion);
        bundle.putString(FIELD_PACKAGE_NAME, this.packageName);
        bundle.putInt(FIELD_PID, this.pid);
        bundle.putBundle(FIELD_CONNECTION_HINTS, this.connectionHints);
        bundle.putInt(FIELD_CONTROLLER_INTERFACE_VERSION, this.controllerInterfaceVersion);
        bundle.putInt(FIELD_MAX_COMMANDS_FOR_MEDIA_ITEM, this.maxCommandsForMediaItems);
        return bundle;
    }

    public ConnectionRequest(int i, int i2, String str, int i3, Bundle bundle, int i4) {
        this.libraryVersion = i;
        this.controllerInterfaceVersion = i2;
        this.packageName = str;
        this.pid = i3;
        this.connectionHints = bundle;
        this.maxCommandsForMediaItems = i4;
    }
}
