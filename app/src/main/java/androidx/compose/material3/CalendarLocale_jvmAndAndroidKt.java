package androidx.compose.material3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CalendarLocale_jvmAndAndroidKt {
    public static final WeakHashMap cachedFormatters = new WeakHashMap();

    public static String toLocalString$default(int i, int i2) {
        int i3 = (i2 & 1) == 0 ? 2 : 1;
        Locale locale = Locale.getDefault();
        String str = i3 + ".40.false." + locale.toLanguageTag();
        WeakHashMap weakHashMap = cachedFormatters;
        Object obj = weakHashMap.get(str);
        Object obj2 = obj;
        if (obj == null) {
            NumberFormat integerInstance = NumberFormat.getIntegerInstance(locale);
            integerInstance.setGroupingUsed(false);
            integerInstance.setMinimumIntegerDigits(i3);
            integerInstance.setMaximumIntegerDigits(40);
            weakHashMap.put(str, integerInstance);
            obj2 = integerInstance;
        }
        return ((NumberFormat) obj2).format(Integer.valueOf(i));
    }
}
