package io.ktor.client.plugins;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.ContentType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\u00048\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/ClientRequestException;", "Lio/ktor/client/plugins/ResponseException;", "Lio/ktor/client/statement/HttpResponse;", "response", "", "cachedResponseText", "<init>", "(Lio/ktor/client/statement/HttpResponse;Ljava/lang/String;)V", ContentType.Message.TYPE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ClientRequestException extends ResponseException {
    private final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientRequestException(HttpResponse httpResponse, String str) {
        super(httpResponse, str);
        httpResponse.getClass();
        str.getClass();
        StringBuilder sb = new StringBuilder("Client request(");
        sb.append(httpResponse.getCall().getRequest().getMethod().getValue());
        sb.append(' ');
        sb.append(httpResponse.getCall().getRequest().getUrl());
        sb.append(") invalid: ");
        sb.append(httpResponse.getStatus());
        sb.append(". Text: \"");
        this.message = Format$$ExternalSyntheticOutline0.m(sb, str, '\"');
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
