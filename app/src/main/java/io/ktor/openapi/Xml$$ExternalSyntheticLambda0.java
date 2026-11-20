package io.ktor.openapi;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.util.NonceKt;
import io.ktor.util.StatelessHmacNonceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Xml$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ Xml$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return Xml._childSerializers$_anonymous_();
            case 1:
                return Operation._childSerializers$_anonymous_$4();
            case 2:
                return Operation._childSerializers$_anonymous_$5();
            case 3:
                return Parameter._childSerializers$_anonymous_();
            case 4:
                return Parameter._childSerializers$_anonymous_$0();
            case 5:
                return Parameter._childSerializers$_anonymous_$1();
            case 6:
                return Parameter._childSerializers$_anonymous_$2();
            case 7:
                return Parameter._childSerializers$_anonymous_$3();
            case 8:
                return Parameter._childSerializers$_anonymous_$4();
            case 9:
                return ParameterType._init_$_anonymous_();
            case 10:
                return Parameters._childSerializers$_anonymous_();
            case 11:
                return PathItem._childSerializers$_anonymous_();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return PathItem._childSerializers$_anonymous_$0();
            case 13:
                return PathItem._childSerializers$_anonymous_$1();
            case 14:
                return RequestBody._childSerializers$_anonymous_();
            case 15:
                return RequestBody._childSerializers$_anonymous_$0();
            case 16:
                return Response._childSerializers$_anonymous_();
            case 17:
                return Response._childSerializers$_anonymous_$0();
            case 18:
                return Response._childSerializers$_anonymous_$1();
            case 19:
                return Response._childSerializers$_anonymous_$2();
            case 20:
                return Responses._childSerializers$_anonymous_();
            case 21:
                return Responses._childSerializers$_anonymous_$0();
            case 22:
                return Responses._childSerializers$_anonymous_$1();
            case 23:
                return Security._childSerializers$_anonymous_();
            case 24:
                return SecuritySchemeIn._init_$_anonymous_();
            case 25:
                return SecuritySchemeType._init_$_anonymous_();
            case 26:
                return Server._childSerializers$_anonymous_();
            case 27:
                return Servers._childSerializers$_anonymous_();
            case 28:
                return NonceKt.lookupSecureRandom();
            default:
                return StatelessHmacNonceManager.DEFAULT_LEGACY_NONCE_GENERATOR$lambda$0();
        }
    }
}
