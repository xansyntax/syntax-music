package kotlin.text;

import io.ktor.http.LinkHeader;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements Function1 {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2(1, MatchResult.class, LinkHeader.Rel.Next, "next()Lkotlin/text/MatchResult;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        MatchResult matchResult = (MatchResult) obj;
        matchResult.getClass();
        return ((MatcherMatchResult) matchResult).next();
    }
}
