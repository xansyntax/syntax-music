package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.plugins.sse.SSEKt$$ExternalSyntheticLambda0;
import io.ktor.http.BadContentTypeFormatException;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValue;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.LinesSequence;
import kotlin.sequences.EmptySequence;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.FlatteningSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt$flatMap$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\nJ1\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentTypeMergeStrategy;", "", "", "Lio/ktor/http/ContentType;", "registeredContentTypes", "", "acceptHeaders", "Lkotlin/sequences/Sequence;", "mergeContentTypes", "(Ljava/util/List;Ljava/util/List;)Lkotlin/sequences/Sequence;", "Companion", "ktor-client-content-negotiation"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ContentTypeMergeStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentTypeMergeStrategy$Companion;", "", "<init>", "()V", "Lio/ktor/client/plugins/contentnegotiation/ContentTypeMergeStrategy;", "Default", "Lio/ktor/client/plugins/contentnegotiation/ContentTypeMergeStrategy;", "getDefault", "()Lio/ktor/client/plugins/contentnegotiation/ContentTypeMergeStrategy;", "SkipIfPresent", "getSkipIfPresent", "ktor-client-content-negotiation"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ContentTypeMergeStrategy Default = new PathKt$$ExternalSyntheticBUOutline0(21);
        private static final ContentTypeMergeStrategy SkipIfPresent = new PathKt$$ExternalSyntheticBUOutline0(22);

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Sequence Default$lambda$0(List list, List list2) {
            list.getClass();
            list2.getClass();
            byte b = 2;
            return new FilteringSequence(new LinesSequence(b, list), true, new MimesKt$$ExternalSyntheticLambda0((byte) 24, new FlatteningSequence(new LinesSequence(b, list2), new SSEKt$$ExternalSyntheticLambda0((byte) 5), SequencesKt___SequencesKt$flatMap$1.INSTANCE)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Iterable Default$lambda$0$0(String str) {
            str.getClass();
            return HttpHeaderValueParserKt.parseHeaderValue(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean Default$lambda$0$1(Sequence sequence, ContentType contentType) {
            boolean zMatch;
            contentType.getClass();
            Iterator it = sequence.iterator();
            while (it.hasNext()) {
                HeaderValue headerValue = (HeaderValue) it.next();
                try {
                    ContentType contentType2 = ContentType.INSTANCE.parse(headerValue.getValue());
                    zMatch = new ContentType(contentType2.getContentType(), contentType2.getContentSubtype(), headerValue.getParams()).match(contentType);
                } catch (BadContentTypeFormatException unused) {
                    zMatch = false;
                }
                if (zMatch) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Sequence SkipIfPresent$lambda$0(List list, List list2) {
            list.getClass();
            list2.getClass();
            return !list2.isEmpty() ? EmptySequence.INSTANCE : Default.mergeContentTypes(list, list2);
        }

        public final ContentTypeMergeStrategy getDefault() {
            return Default;
        }

        public final ContentTypeMergeStrategy getSkipIfPresent() {
            return SkipIfPresent;
        }
    }

    Sequence mergeContentTypes(List<ContentType> registeredContentTypes, List<String> acceptHeaders);
}
