package org.slf4j.helpers;

import androidx.datastore.preferences.PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Reporter {
    public static final int INTERNAL_VERBOSITY;
    public static final int TARGET_CHOICE;

    static {
        int i;
        String[] strArr = {"System.out", "stdout", "sysout"};
        String property = System.getProperty("slf4j.internal.report.stream");
        int i2 = 2;
        if (property != null && !property.isEmpty()) {
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    i = 1;
                    break;
                } else {
                    if (strArr[i3].equalsIgnoreCase(property)) {
                        i = 2;
                        break;
                    }
                    i3++;
                }
            }
        } else {
            i = 1;
            break;
        }
        TARGET_CHOICE = i;
        String property2 = System.getProperty("slf4j.internal.verbosity");
        if (property2 != null && !property2.isEmpty()) {
            if (property2.equalsIgnoreCase("DEBUG")) {
                i2 = 1;
            } else if (property2.equalsIgnoreCase("ERROR")) {
                i2 = 4;
            } else if (property2.equalsIgnoreCase("WARN")) {
                i2 = 3;
            }
        }
        INTERNAL_VERBOSITY = i2;
    }

    public static final void error(String str, Throwable th) {
        getTarget().println("SLF4J(E): ".concat(str));
        getTarget().println("SLF4J(E): Reported exception:");
        th.printStackTrace(getTarget());
    }

    public static PrintStream getTarget() {
        return PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(TARGET_CHOICE) != 1 ? System.err : System.out;
    }

    public static final void warn(String str) {
        if (Cookie$$ExternalSyntheticOutline0.getLevelInt(3) >= Cookie$$ExternalSyntheticOutline0.getLevelInt(INTERNAL_VERBOSITY)) {
            getTarget().println("SLF4J(W): " + str);
        }
    }
}
