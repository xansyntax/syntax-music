package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
public final class CookieUtilsKt$tryParseTime$minute$1$1 implements Function1 {
    public static final CookieUtilsKt$tryParseTime$minute$1$1 INSTANCE = new CookieUtilsKt$tryParseTime$minute$1$1();

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Character) obj).charValue());
    }

    public final Boolean invoke(char c) {
        return Boolean.valueOf(CookieUtilsKt.isDigit(c));
    }
}
