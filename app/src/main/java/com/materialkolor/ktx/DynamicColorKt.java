package com.materialkolor.ktx;

import com.materialkolor.dynamiccolor.ColorSpec$SpecVersion;
import com.materialkolor.dynamiccolor.ColorSpecs;
import com.materialkolor.dynamiccolor.DynamicColor;
import com.materialkolor.hct.Hct;
import com.materialkolor.scheme.DynamicScheme;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"getColor", "Landroidx/compose/ui/graphics/Color;", "Lcom/materialkolor/dynamiccolor/DynamicColor;", "scheme", "Lcom/materialkolor/scheme/DynamicScheme;", "(Lcom/materialkolor/dynamiccolor/DynamicColor;Lcom/materialkolor/scheme/DynamicScheme;)J", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class DynamicColorKt {
    public static final long getColor(DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        dynamicColor.getClass();
        dynamicScheme.getClass();
        Function1 function1 = dynamicColor.opacity;
        HashMap map = dynamicColor.hctCache;
        Hct hct = (Hct) map.get(dynamicScheme);
        if (hct == null) {
            hct = (dynamicScheme.specVersion == ColorSpec$SpecVersion.SPEC_2025 ? ColorSpecs.SPEC_2025 : ColorSpecs.SPEC_2021).getHct(dynamicColor, dynamicScheme);
            if (map.size() > 4) {
                map.clear();
            }
            map.put(dynamicScheme, hct);
        }
        int iCoerceIn = hct.argb;
        Double d = function1 != null ? (Double) function1.invoke(dynamicScheme) : null;
        if (function1 != null && d != null) {
            iCoerceIn = (iCoerceIn & 16777215) | (UuidKt.coerceIn((int) Math.rint(d.doubleValue() * 255.0d), 0, 255) << 24);
        }
        return ((long) iCoerceIn) << 32;
    }
}
