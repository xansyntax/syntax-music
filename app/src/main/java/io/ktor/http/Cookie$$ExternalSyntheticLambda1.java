package io.ktor.http;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.HeadersUtilsKt;
import io.ktor.openapi.ApiKeySecurityScheme;
import io.ktor.openapi.Callback;
import io.ktor.openapi.Components;
import io.ktor.util.date.DateJvmKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Cookie$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ Cookie$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return Cookie._childSerializers$_anonymous_();
            case 1:
                return HttpRequestBuilder.setCapability$lambda$0();
            case 2:
                return Unit.INSTANCE;
            case 3:
                return Unit.INSTANCE;
            case 4:
                return Unit.INSTANCE;
            case 5:
                return Unit.INSTANCE;
            case 6:
                return Unit.INSTANCE;
            case 7:
                return HeadersUtilsKt.dropCompressionHeaders$lambda$0();
            case 8:
                return Cookie._childSerializers$_anonymous_$0();
            case 9:
                return CookieDateParser.parse$lambda$4();
            case 10:
                return CookieDateParser.parse$lambda$5();
            case 11:
                return CookieDateParser.parse$lambda$6();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return CookieDateParser.parse$lambda$7();
            case 13:
                return CookieDateParser.parse$lambda$8();
            case 14:
                return FileContentTypeKt.contentTypesByExtensions_delegate$lambda$0();
            case 15:
                return FileContentTypeKt.extensionsByContentType_delegate$lambda$0();
            case 16:
                return HttpHeaderValueParserKt.parseHeaderValue$lambda$0();
            case 17:
                return HttpHeaderValueParserKt.parseHeaderValueItem$lambda$0();
            case 18:
                return MimesKt.loadMimes();
            case 19:
                return Long.valueOf(DateJvmKt.getTimeMillis());
            case 20:
                return ApiKeySecurityScheme._childSerializers$_anonymous_();
            case 21:
                return ApiKeySecurityScheme._childSerializers$_anonymous_$0();
            case 22:
                return ApiKeySecurityScheme._childSerializers$_anonymous_$1();
            case 23:
                return Callback._childSerializers$_anonymous_();
            case 24:
                return Components._childSerializers$_anonymous_();
            case 25:
                return Components._childSerializers$_anonymous_$7();
            case 26:
                return Components._childSerializers$_anonymous_$8();
            case 27:
                return Components._childSerializers$_anonymous_$9();
            case 28:
                return Components._childSerializers$_anonymous_$10();
            default:
                return Components._childSerializers$_anonymous_$0();
        }
    }
}
