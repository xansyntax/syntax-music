package io.ktor.openapi;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Response$Builder$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ JsonSchema f$0;

    public /* synthetic */ Response$Builder$$ExternalSyntheticLambda1(JsonSchema jsonSchema, byte b) {
        this.$r8$classId = b;
        this.f$0 = jsonSchema;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        JsonSchema jsonSchema = this.f$0;
        MediaType.Builder builder = (MediaType.Builder) obj;
        switch (b) {
            case 0:
                return Response.Builder._set_schema_$lambda$0(jsonSchema, builder);
            default:
                return RequestBody.Builder._set_schema_$lambda$0(jsonSchema, builder);
        }
    }
}
