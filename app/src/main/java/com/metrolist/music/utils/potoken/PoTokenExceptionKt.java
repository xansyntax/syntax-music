package com.metrolist.music.utils.potoken;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"buildExceptionForJsError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class PoTokenExceptionKt {
    public static final Exception buildExceptionForJsError(String str) {
        str.getClass();
        return StringsKt.contains(str, "SyntaxError", false) ? new BadWebViewException(str) : new PoTokenException(str);
    }
}
