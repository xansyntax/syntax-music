package androidx.media3.session;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionCommand {
    public static final String FIELD_COMMAND_CODE;
    public static final String FIELD_CUSTOM_ACTION;
    public static final String FIELD_CUSTOM_EXTRAS;
    public static final RegularImmutableList LIBRARY_COMMANDS;
    public static final RegularImmutableList SESSION_COMMANDS = ImmutableList.of((Object) 40010);
    public final int commandCode;
    public final String customAction;
    public final Bundle customExtras;

    static {
        Object[] objArr = {50000, 50001, 50002, 50003, 50004, 50005, 50006};
        Maps.checkElementsNotNull(7, objArr);
        LIBRARY_COMMANDS = ImmutableList.asImmutableList(7, objArr);
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_COMMAND_CODE = Integer.toString(0, 36);
        FIELD_CUSTOM_ACTION = Integer.toString(1, 36);
        FIELD_CUSTOM_EXTRAS = Integer.toString(2, 36);
    }

    public SessionCommand(int i) {
        UtilsKt.checkArgument("commandCode shouldn't be COMMAND_CODE_CUSTOM", i != 0);
        this.commandCode = i;
        this.customAction = "";
        this.customExtras = Bundle.EMPTY;
    }

    public static SessionCommand fromBundle(Bundle bundle) {
        int i = bundle.getInt(FIELD_COMMAND_CODE, 0);
        if (i != 0) {
            return new SessionCommand(i);
        }
        String string = bundle.getString(FIELD_CUSTOM_ACTION);
        string.getClass();
        Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle.getBundle(FIELD_CUSTOM_EXTRAS));
        if (bundleConvertToNullIfInvalid == null) {
            bundleConvertToNullIfInvalid = Bundle.EMPTY;
        }
        return new SessionCommand(string, bundleConvertToNullIfInvalid);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SessionCommand)) {
            return false;
        }
        SessionCommand sessionCommand = (SessionCommand) obj;
        return this.commandCode == sessionCommand.commandCode && TextUtils.equals(this.customAction, sessionCommand.customAction);
    }

    public final int hashCode() {
        return Objects.hash(this.customAction, Integer.valueOf(this.commandCode));
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_COMMAND_CODE, this.commandCode);
        bundle.putString(FIELD_CUSTOM_ACTION, this.customAction);
        bundle.putBundle(FIELD_CUSTOM_EXTRAS, this.customExtras);
        return bundle;
    }

    public SessionCommand(String str, Bundle bundle) {
        this.commandCode = 0;
        str.getClass();
        this.customAction = str;
        bundle.getClass();
        this.customExtras = new Bundle(bundle);
    }
}
