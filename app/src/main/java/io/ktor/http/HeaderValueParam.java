package io.ktor.http;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u00020\rH\u0096\u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014¨\u0006\u001d"}, d2 = {"Lio/ktor/http/HeaderValueParam;", "", "", ContentDisposition.Parameters.Name, "value", "", "escapeValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "(Ljava/lang/String;Ljava/lang/String;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Z", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/ktor/http/HeaderValueParam;", "toString", "Ljava/lang/String;", "getName", "getValue", "Z", "getEscapeValue", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class HeaderValueParam {
    private final boolean escapeValue;
    private final String name;
    private final String value;

    public HeaderValueParam(String str, String str2, boolean z) {
        str.getClass();
        str2.getClass();
        this.name = str;
        this.value = str2;
        this.escapeValue = z;
    }

    public static /* synthetic */ HeaderValueParam copy$default(HeaderValueParam headerValueParam, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headerValueParam.name;
        }
        if ((i & 2) != 0) {
            str2 = headerValueParam.value;
        }
        if ((i & 4) != 0) {
            z = headerValueParam.escapeValue;
        }
        return headerValueParam.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEscapeValue() {
        return this.escapeValue;
    }

    public final HeaderValueParam copy(String name, String value, boolean escapeValue) {
        name.getClass();
        value.getClass();
        return new HeaderValueParam(name, value, escapeValue);
    }

    public boolean equals(Object other) {
        if (!(other instanceof HeaderValueParam)) {
            return false;
        }
        HeaderValueParam headerValueParam = (HeaderValueParam) other;
        return StringsKt__StringsJVMKt.equals(headerValueParam.name, this.name, true) && StringsKt__StringsJVMKt.equals(headerValueParam.value, this.value, true);
    }

    public final boolean getEscapeValue() {
        return this.escapeValue;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.value.toLowerCase(locale);
        lowerCase2.getClass();
        return lowerCase2.hashCode() + (iHashCode * 31) + iHashCode;
    }

    public String toString() {
        return "HeaderValueParam(name=" + this.name + ", value=" + this.value + ", escapeValue=" + this.escapeValue + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeaderValueParam(String str, String str2) {
        this(str, str2, false);
        str.getClass();
        str2.getClass();
    }
}
