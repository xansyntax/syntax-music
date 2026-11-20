package io.ktor.serialization;

import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J?\u0010\n\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lio/ktor/serialization/Configuration;", "", "Lio/ktor/serialization/ContentConverter;", "T", "Lio/ktor/http/ContentType;", "contentType", "converter", "Lkotlin/Function1;", "", "configuration", "register", "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lkotlin/jvm/functions/Function1;)V", "ktor-serialization"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface Configuration {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void register$default(Configuration configuration, ContentType contentType, ContentConverter contentConverter, Function1 function1, int i, Object obj) {
        if (obj != null) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Super calls with default arguments not supported in this target, function: register");
            return;
        }
        if ((i & 4) != 0) {
            function1 = new InstantKt$$ExternalSyntheticLambda0((byte) 4);
        }
        configuration.register(contentType, contentConverter, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit register$lambda$0(ContentConverter contentConverter) {
        contentConverter.getClass();
        return Unit.INSTANCE;
    }

    <T extends ContentConverter> void register(ContentType contentType, T converter, Function1 configuration);
}
