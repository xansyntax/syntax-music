package io.ktor.util;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b*8\b\u0007\u0010\u0011\u001a\u0004\b\u0000\u0010\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0018\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\b\u000f\u0012\u0006\b\n0\u00008\u0010¨\u0006\u0012"}, d2 = {"", "T", "", ContentDisposition.Parameters.Name, "Lio/ktor/util/AttributeKey;", "AttributeKey", "(Ljava/lang/String;)Lio/ktor/util/AttributeKey;", "Lio/ktor/util/Attributes;", "other", "", "putAll", "(Lio/ktor/util/Attributes;Lio/ktor/util/Attributes;)V", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "Please use `AttributeKey` class instead", "level", "ERROR", "EquatableAttributeKey", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AttributesKt {
    public static final <T> AttributeKey<T> AttributeKey(String str) {
        str.getClass();
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public static final void putAll(Attributes attributes, Attributes attributes2) {
        attributes.getClass();
        attributes2.getClass();
        Iterator<T> it = attributes2.getAllKeys().iterator();
        while (it.hasNext()) {
            AttributeKey attributeKey = (AttributeKey) it.next();
            attributeKey.getClass();
            attributes.put(attributeKey, attributes2.get(attributeKey));
        }
    }

    @Deprecated
    public static /* synthetic */ void EquatableAttributeKey$annotations() {
    }
}
