package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionCommands {
    public static final SessionCommands EMPTY = new SessionCommands(new HashSet());
    public static final String FIELD_SESSION_COMMANDS;
    public final ImmutableSet commands;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_SESSION_COMMANDS = Integer.toString(0, 36);
    }

    public SessionCommands(HashSet hashSet) {
        this.commands = ImmutableSet.copyOf((Collection) hashSet);
    }

    public static SessionCommands fromBundle(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_SESSION_COMMANDS);
        if (parcelableArrayList == null) {
            Log.w("SessionCommands", "Missing commands. Creating an empty SessionCommands");
            return EMPTY;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            hashSet.add(SessionCommand.fromBundle((Bundle) parcelableArrayList.get(i)));
        }
        return new SessionCommands(hashSet);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionCommands) {
            return this.commands.equals(((SessionCommands) obj).commands);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.commands);
    }
}
