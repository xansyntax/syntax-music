package io.ktor.http.content;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "", "isEmpty", "(Lio/ktor/http/content/OutgoingContent;)Z", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OutgoingContentKt {
    public static final boolean isEmpty(OutgoingContent outgoingContent) {
        outgoingContent.getClass();
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            return true;
        }
        if (outgoingContent instanceof OutgoingContent.ContentWrapper) {
            return isEmpty(((OutgoingContent.ContentWrapper) outgoingContent).getDelegate());
        }
        return false;
    }
}
