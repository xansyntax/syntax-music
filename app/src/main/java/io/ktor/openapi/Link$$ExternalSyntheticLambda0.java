package io.ktor.openapi;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Link$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ Link$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return Link._childSerializers$_anonymous_();
            case 1:
                return JsonSchema._childSerializers$_anonymous_$4();
            case 2:
                return JsonSchema._childSerializers$_anonymous_$5();
            case 3:
                return JsonSchema.SchemaType.AnyOf._childSerializers$_anonymous_();
            case 4:
                return JsonSchemaDiscriminator._childSerializers$_anonymous_();
            case 5:
                return Link._childSerializers$_anonymous_$0();
            case 6:
                return Link._childSerializers$_anonymous_$1();
            case 7:
                return MediaType._childSerializers$_anonymous_();
            case 8:
                return MediaType._childSerializers$_anonymous_$0();
            case 9:
                return MediaType._childSerializers$_anonymous_$1();
            case 10:
                return MediaType._childSerializers$_anonymous_$2();
            case 11:
                return OAuth2SecurityScheme._childSerializers$_anonymous_();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return OAuth2SecurityScheme._childSerializers$_anonymous_$0();
            case 13:
                return OAuthFlow._childSerializers$_anonymous_();
            case 14:
                return OAuthFlow._childSerializers$_anonymous_$0();
            case 15:
                return OAuthFlows._childSerializers$_anonymous_();
            case 16:
                return OpenApiDoc._childSerializers$_anonymous_();
            case 17:
                return OpenApiDoc._childSerializers$_anonymous_$0();
            case 18:
                return OpenApiDoc._childSerializers$_anonymous_$1();
            case 19:
                return OpenApiDoc._childSerializers$_anonymous_$2();
            case 20:
                return OpenApiDoc._childSerializers$_anonymous_$3();
            case 21:
                return OpenApiDoc._childSerializers$_anonymous_$4();
            case 22:
                return OpenApiInfo._childSerializers$_anonymous_();
            case 23:
                return OpenIdConnectSecurityScheme._childSerializers$_anonymous_();
            case 24:
                return OpenIdConnectSecurityScheme._childSerializers$_anonymous_$0();
            case 25:
                return Operation._childSerializers$_anonymous_();
            case 26:
                return Operation._childSerializers$_anonymous_$0();
            case 27:
                return Operation._childSerializers$_anonymous_$1();
            case 28:
                return Operation._childSerializers$_anonymous_$2();
            default:
                return Operation._childSerializers$_anonymous_$3();
        }
    }
}
