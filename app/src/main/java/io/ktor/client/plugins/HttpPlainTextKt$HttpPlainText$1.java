package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class HttpPlainTextKt$HttpPlainText$1 extends FunctionReferenceImpl implements Function0 {
    public static final HttpPlainTextKt$HttpPlainText$1 INSTANCE = new HttpPlainTextKt$HttpPlainText$1();

    public HttpPlainTextKt$HttpPlainText$1() {
        super(0, HttpPlainTextConfig.class, "<init>", "<init>()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final HttpPlainTextConfig invoke() {
        return new HttpPlainTextConfig();
    }
}
