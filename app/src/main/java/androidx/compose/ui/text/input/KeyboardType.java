package androidx.compose.ui.text.input;

import io.ktor.http.HttpHeaders;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyboardType {
    public final int value;

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m761toStringimpl(int i) {
        if (i == 0) {
            return "Unspecified";
        }
        if (i == 1) {
            return "Text";
        }
        if (i == 2) {
            return "Ascii";
        }
        if (i == 3) {
            return "Number";
        }
        if (i == 4) {
            return "Phone";
        }
        if (i == 5) {
            return "Uri";
        }
        if (i == 6) {
            return "Email";
        }
        if (i == 7) {
            return "Password";
        }
        if (i == 8) {
            return "NumberPassword";
        }
        if (i == 9) {
            return "Decimal";
        }
        if (i == 10) {
            return "PasswordVisible";
        }
        if (i == 11) {
            return "PostalAddress";
        }
        if (i == 12) {
            return "PersonName";
        }
        if (i == 13) {
            return "EmailSubject";
        }
        if (i == 14) {
            return "ShortMessage";
        }
        if (i == 15) {
            return "LongMessage";
        }
        if (i == 16) {
            return "Filter";
        }
        if (i == 17) {
            return "Phonetic";
        }
        if (i == 18) {
            return "DateTime";
        }
        if (i == 19) {
            return HttpHeaders.Date;
        }
        if (i == 20) {
            return "Time";
        }
        if (i == 21) {
            return "NumberSigned";
        }
        if (i == 22) {
            return "DecimalSigned";
        }
        if (i == 23) {
            return "DecimalPassword";
        }
        if (i == 24) {
            return "NumberPasswordSigned";
        }
        return i == 25 ? "DecimalPasswordSigned" : "Invalid";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof KeyboardType) {
            return this.value == ((KeyboardType) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m761toStringimpl(this.value);
    }
}
