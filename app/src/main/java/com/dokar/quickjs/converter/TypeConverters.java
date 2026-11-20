package com.dokar.quickjs.converter;

import com.dokar.quickjs.QuickJsException;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TypeConverters {
    public final ArrayList converters = new ArrayList();
    public final LinkedHashMap classTypeMap = new LinkedHashMap();

    public final void convert(Object obj, KType kType, TypeReference typeReference) throws QuickJsException {
        if (kType.equals(typeReference)) {
            return;
        }
        ArrayList arrayList = this.converters;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            PathKt$$ExternalSyntheticBUOutline0.m();
            return;
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            it2.next().getClass();
            PathKt$$ExternalSyntheticBUOutline0.m();
            return;
        }
        throw new QuickJsException("No such type converter to convert '" + kType + "' to '" + typeReference + "'", null, 2, null);
    }
}
