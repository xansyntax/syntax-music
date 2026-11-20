package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\t\u0010\u0007J/\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010!\u001a\u0004\u0018\u00010\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020'0&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+À\u0006\u0003"}, d2 = {"Lio/ktor/openapi/OpenApiDocDsl;", "", "Lkotlin/Function1;", "Lio/ktor/openapi/Servers$Builder;", "", "configure", "servers", "(Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/openapi/Security$Builder;", "security", "", ContentDisposition.Parameters.Name, "description", "Lio/ktor/openapi/ExternalDocs;", "externalDocs", "tag", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/ExternalDocs;)V", "getOpenapiVersion", "()Ljava/lang/String;", "setOpenapiVersion", "(Ljava/lang/String;)V", "openapiVersion", "Lio/ktor/openapi/OpenApiInfo;", "getInfo", "()Lio/ktor/openapi/OpenApiInfo;", "setInfo", "(Lio/ktor/openapi/OpenApiInfo;)V", "info", "Lio/ktor/openapi/Components;", "getComponents", "()Lio/ktor/openapi/Components;", "setComponents", "(Lio/ktor/openapi/Components;)V", "components", "getExternalDocs", "()Lio/ktor/openapi/ExternalDocs;", "setExternalDocs", "(Lio/ktor/openapi/ExternalDocs;)V", "", "Lio/ktor/openapi/GenericElement;", "getExtensions", "()Ljava/util/Map;", "extensions", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface OpenApiDocDsl {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void tag$default(OpenApiDocDsl openApiDocDsl, String str, String str2, ExternalDocs externalDocs, int i, Object obj) {
        if (obj != null) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Super calls with default arguments not supported in this target, function: tag");
            return;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            externalDocs = null;
        }
        openApiDocDsl.tag(str, str2, externalDocs);
    }

    Components getComponents();

    Map<String, GenericElement> getExtensions();

    ExternalDocs getExternalDocs();

    OpenApiInfo getInfo();

    String getOpenapiVersion();

    void security(Function1 configure);

    void servers(Function1 configure);

    void setComponents(Components components);

    void setExternalDocs(ExternalDocs externalDocs);

    void setInfo(OpenApiInfo openApiInfo);

    void setOpenapiVersion(String str);

    void tag(String name, String description, ExternalDocs externalDocs);
}
