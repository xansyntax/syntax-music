package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FontVariation implements PlatformResolveInterceptor, PlatformTypefaces {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SettingInt {
        public final int value;

        public SettingInt(int i) {
            this.value = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SettingInt) && this.value == ((SettingInt) obj).value;
        }

        public final String getAxisName() {
            return "wght";
        }

        public final int hashCode() {
            return 113071012 + this.value;
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(this.value, "FontVariation.Setting(axisName='wght', value=", ")");
        }

        public final float toVariationValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Settings {
        public final List settings;

        public Settings(List list) {
            this.settings = list;
            int size = list.size();
            int i = 0;
            while (i < size) {
                String axisName = ((SettingInt) list.get(i)).getAxisName();
                i++;
                int size2 = list.size();
                for (int i2 = i; i2 < size2; i2++) {
                    if (Intrinsics.areEqual(axisName, ((SettingInt) list.get(i2)).getAxisName())) {
                        ArrayList arrayList = new ArrayList();
                        int size3 = list.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            if (Intrinsics.areEqual(((SettingInt) list.get(i3)).getAxisName(), axisName)) {
                                arrayList.add(list.get(i3));
                            }
                        }
                        InlineClassHelperKt.throwIllegalArgumentException("'" + axisName + "' must be unique. Actual [" + arrayList + "]");
                    }
                }
            }
            int size4 = this.settings.size();
            for (int i4 = 0; i4 < size4; i4++) {
                ((SettingInt) this.settings.get(i4)).getClass();
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Settings) {
                return Intrinsics.areEqual(this.settings, ((Settings) obj).settings);
            }
            return false;
        }

        public final int hashCode() {
            return this.settings.hashCode();
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("Settings(settings=", ")", this.settings);
        }
    }

    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
    public static Typeface m754createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int i) {
        if (i == 0 && Intrinsics.areEqual(fontWeight, FontWeight.Normal) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        int iM1061getAndroidTypefaceStyleFO1MlWM = DatabaseDao_Impl.AnonymousClass17.m1061getAndroidTypefaceStyleFO1MlWM(fontWeight, i);
        return (str == null || str.length() == 0) ? Typeface.defaultFromStyle(iM1061getAndroidTypefaceStyleFO1MlWM) : Typeface.create(str, iM1061getAndroidTypefaceStyleFO1MlWM);
    }

    public static SettingInt weight(int i) {
        if (1 > i || i >= 1001) {
            InlineClassHelperKt.throwIllegalArgumentException("'wght' value must be in [1, 1000]. Actual: " + i);
        }
        return new SettingInt(i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createDefault-FO1MlWM, reason: not valid java name */
    public Typeface mo755createDefaultFO1MlWM(FontWeight fontWeight, int i) {
        return m754createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createNamed-RetOiIg, reason: not valid java name */
    public Typeface mo756createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
        String strConcat = genericFontFamily.name;
        int i2 = fontWeight.weight / 100;
        if (i2 >= 0 && i2 < 2) {
            strConcat = strConcat.concat("-thin");
        } else if (2 <= i2 && i2 < 4) {
            strConcat = strConcat.concat("-light");
        } else if (i2 != 4) {
            if (i2 == 5) {
                strConcat = strConcat.concat("-medium");
            } else if ((6 > i2 || i2 >= 8) && 8 <= i2 && i2 < 11) {
                strConcat = strConcat.concat("-black");
            }
        }
        Typeface typeface = null;
        if (strConcat.length() != 0) {
            Typeface typefaceM754createAndroidTypefaceUsingTypefaceStyleRetOiIg = m754createAndroidTypefaceUsingTypefaceStyleRetOiIg(strConcat, fontWeight, i);
            if (!Intrinsics.areEqual(typefaceM754createAndroidTypefaceUsingTypefaceStyleRetOiIg, Typeface.create(Typeface.DEFAULT, DatabaseDao_Impl.AnonymousClass17.m1061getAndroidTypefaceStyleFO1MlWM(fontWeight, i))) && !Intrinsics.areEqual(typefaceM754createAndroidTypefaceUsingTypefaceStyleRetOiIg, m754createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i))) {
                typeface = typefaceM754createAndroidTypefaceUsingTypefaceStyleRetOiIg;
            }
        }
        return typeface == null ? m754createAndroidTypefaceUsingTypefaceStyleRetOiIg(genericFontFamily.name, fontWeight, i) : typeface;
    }
}
