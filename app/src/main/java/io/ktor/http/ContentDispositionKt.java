package io.ktor.http;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "key", "value", "encodeContentDispositionAttribute", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContentDispositionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodeContentDispositionAttribute(String str, String str2) {
        if (!Intrinsics.areEqual(str, ContentDisposition.Parameters.FileNameAsterisk) || StringsKt__StringsJVMKt.startsWith(str2, "utf-8''", true)) {
            return str2;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!CodecsKt.getATTRIBUTE_CHARACTERS().contains(str2.charAt(i))) {
                return Fragment$5$$ExternalSyntheticOutline0.m("utf-8''", CodecsKt.percentEncode(str2, CodecsKt.getATTRIBUTE_CHARACTERS()));
            }
        }
        return str2;
    }
}
