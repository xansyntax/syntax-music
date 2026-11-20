package androidx.navigation;

import android.os.Bundle;
import coil3.util.FileSystemsKt;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntNavType extends NavType {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntNavType(byte b, boolean z) {
        super(z);
        this.$r8$classId = b;
    }

    @Override // androidx.navigation.NavType
    public final Object get(String str, Bundle bundle) {
        switch (this.$r8$classId) {
            case 0:
                bundle.getClass();
                return Integer.valueOf(MathKt.m1876getIntimpl(str, bundle));
            case 1:
                bundle.getClass();
                if (!bundle.containsKey(str) || MathKt.m1879isNullimpl(str, bundle)) {
                    return null;
                }
                boolean z = bundle.getBoolean(str, false);
                if (z || !bundle.getBoolean(str, true)) {
                    return Boolean.valueOf(z);
                }
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
            case 2:
                bundle.getClass();
                float f = bundle.getFloat(str, Float.MIN_VALUE);
                if (f != Float.MIN_VALUE || bundle.getFloat(str, Float.MAX_VALUE) != Float.MAX_VALUE) {
                    return Float.valueOf(f);
                }
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
            case 3:
                bundle.getClass();
                long j = bundle.getLong(str, Long.MIN_VALUE);
                if (j != Long.MIN_VALUE || bundle.getLong(str, Long.MAX_VALUE) != Long.MAX_VALUE) {
                    return Long.valueOf(j);
                }
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
            default:
                bundle.getClass();
                if (!bundle.containsKey(str) || MathKt.m1879isNullimpl(str, bundle)) {
                    return null;
                }
                String string = bundle.getString(str);
                if (string != null) {
                    return string;
                }
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
        }
    }

    @Override // androidx.navigation.NavType
    public final String getName() {
        switch (this.$r8$classId) {
            case 0:
                return "integer";
            case 1:
                return "boolean";
            case 2:
                return "float";
            case 3:
                return "long";
            default:
                return "string";
        }
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: parseValue */
    public final Object mo842parseValue(String str) {
        int i;
        long j;
        boolean z = true;
        switch (this.$r8$classId) {
            case 0:
                if (StringsKt__StringsJVMKt.startsWith(str, "0x", false)) {
                    String strSubstring = str.substring(2);
                    CharsKt.checkRadix(16);
                    i = Integer.parseInt(strSubstring, 16);
                } else {
                    i = Integer.parseInt(str);
                }
                return Integer.valueOf(i);
            case 1:
                if (!str.equals("true")) {
                    if (!str.equals("false")) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("A boolean NavType only accepts \"true\" or \"false\" values.");
                        return null;
                    }
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                return Float.valueOf(Float.parseFloat(str));
            case 3:
                String strSubstring2 = StringsKt__StringsJVMKt.endsWith(str, "L", false) ? str.substring(0, str.length() - 1) : str;
                if (StringsKt__StringsJVMKt.startsWith(str, "0x", false)) {
                    String strSubstring3 = strSubstring2.substring(2);
                    CharsKt.checkRadix(16);
                    j = Long.parseLong(strSubstring3, 16);
                } else {
                    j = Long.parseLong(strSubstring2);
                }
                return Long.valueOf(j);
            default:
                if (str.equals("null")) {
                    return null;
                }
                return str;
        }
    }

    @Override // androidx.navigation.NavType
    public final void put(Bundle bundle, String str, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                str.getClass();
                bundle.putInt(str, iIntValue);
                break;
            case 1:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                str.getClass();
                bundle.putBoolean(str, zBooleanValue);
                break;
            case 2:
                float fFloatValue = ((Number) obj).floatValue();
                str.getClass();
                bundle.putFloat(str, fFloatValue);
                break;
            case 3:
                long jLongValue = ((Number) obj).longValue();
                str.getClass();
                bundle.putLong(str, jLongValue);
                break;
            default:
                String str2 = (String) obj;
                str.getClass();
                if (str2 == null) {
                    bundle.putString(str, null);
                } else {
                    bundle.putString(str, str2);
                }
                break;
        }
    }
}
