package io.ktor.util.pipeline;

import io.ktor.http.ContentType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/util/pipeline/InvalidPhaseException;", "", "", ContentType.Message.TYPE, "<init>", "(Ljava/lang/String;)V", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InvalidPhaseException extends Throwable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidPhaseException(String str) {
        super(str);
        str.getClass();
    }
}
