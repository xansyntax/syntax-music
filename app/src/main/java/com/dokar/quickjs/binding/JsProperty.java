package com.dokar.quickjs.binding;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/dokar/quickjs/binding/JsProperty;", "", ContentDisposition.Parameters.Name, "", "configurable", "", "writable", "enumerable", "<init>", "(Ljava/lang/String;ZZZ)V", "getName", "()Ljava/lang/String;", "getConfigurable", "()Z", "getWritable", "getEnumerable", "quickjs-kt:quickjs_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class JsProperty {
    private final boolean configurable;
    private final boolean enumerable;
    private final String name;
    private final boolean writable;

    public JsProperty(String str, boolean z, boolean z2, boolean z3) {
        str.getClass();
        this.name = str;
        this.configurable = z;
        this.writable = z2;
        this.enumerable = z3;
    }

    public final boolean getConfigurable() {
        return this.configurable;
    }

    public final boolean getEnumerable() {
        return this.enumerable;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getWritable() {
        return this.writable;
    }
}
