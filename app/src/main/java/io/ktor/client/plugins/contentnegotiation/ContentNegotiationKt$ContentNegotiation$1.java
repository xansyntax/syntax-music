package io.ktor.client.plugins.contentnegotiation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ContentNegotiationKt$ContentNegotiation$1 extends FunctionReferenceImpl implements Function0 {
    public static final ContentNegotiationKt$ContentNegotiation$1 INSTANCE = new ContentNegotiationKt$ContentNegotiation$1();

    public ContentNegotiationKt$ContentNegotiation$1() {
        super(0, ContentNegotiationConfig.class, "<init>", "<init>()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final ContentNegotiationConfig invoke() {
        return new ContentNegotiationConfig();
    }
}
