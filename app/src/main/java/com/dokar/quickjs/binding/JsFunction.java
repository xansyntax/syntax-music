package com.dokar.quickjs.binding;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/dokar/quickjs/binding/JsFunction;", "", ContentDisposition.Parameters.Name, "", "isAsync", "", "<init>", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "()Z", "quickjs-kt:quickjs_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class JsFunction {
    private final boolean isAsync;
    private final String name;

    public JsFunction(String str, boolean z) {
        str.getClass();
        this.name = str;
        this.isAsync = z;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: isAsync, reason: from getter */
    public final boolean getIsAsync() {
        return this.isAsync;
    }
}
