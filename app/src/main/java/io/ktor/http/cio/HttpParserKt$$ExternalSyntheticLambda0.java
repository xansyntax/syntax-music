package io.ktor.http.cio;

import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;
import io.ktor.client.plugins.websocket.BuildersKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.cio.internals.AsciiCharTree;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.openapi.ApiKeySecurityScheme;
import io.ktor.openapi.Components;
import io.ktor.openapi.Encoding;
import io.ktor.openapi.ExampleObject;
import io.ktor.openapi.Header;
import io.ktor.openapi.HttpSecurityScheme;
import io.ktor.openapi.Link;
import io.ktor.openapi.MediaType;
import io.ktor.openapi.OAuth2SecurityScheme;
import io.ktor.openapi.OAuthFlow;
import io.ktor.openapi.OAuthFlows;
import io.ktor.openapi.OpenApiDoc;
import io.ktor.openapi.OpenApiInfo;
import io.ktor.openapi.OpenIdConnectSecurityScheme;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HttpParserKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ HttpParserKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return Boolean.valueOf(HttpParserKt.parseHttpMethod$lambda$0(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            case 1:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.listen_together_join_room, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.listen_together_username, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.person, 0, gapComposer3), (String) null, (Modifier) null, 0L, gapComposer3, 56, 12);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.description, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.replay, 0, gapComposer5), "Reset", (Modifier) null, ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, gapComposer5, 56, 4);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(1 & iIntValue6, (iIntValue6 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.remove, 0, gapComposer6), "Decrease", (Modifier) null, 0L, gapComposer6, 56, 12);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(1 & iIntValue7, (iIntValue7 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.add, 0, gapComposer7), "Increase", (Modifier) null, 0L, gapComposer7, 56, 12);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 8:
                return BuildersKt.webSocket$lambda$0$0((URLBuilder) obj, (URLBuilder) obj2);
            case 9:
                return BuildersKt.webSocketSession$lambda$0$0((URLBuilder) obj, (URLBuilder) obj2);
            case 10:
                return Character.valueOf(ConnectionOptions.knownTypes$lambda$1((Pair) obj, ((Integer) obj2).intValue()));
            case 11:
                return Boolean.valueOf(ConnectionOptions.Companion.parseSlow$lambda$0(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return Boolean.valueOf(ConnectionOptions.Companion.parse$lambda$0(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            case 13:
                return Boolean.valueOf(HttpParserKt.parseVersion$lambda$1(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            case 14:
                return Character.valueOf(AsciiCharTree.Companion.build$lambda$1((CharSequence) obj, ((Integer) obj2).intValue()));
            case 15:
                return Character.valueOf(CharsKt.DefaultHttpMethods$lambda$1((HttpMethod) obj, ((Integer) obj2).intValue()));
            case 16:
                return ApiKeySecurityScheme.Companion.Serializer._init_$lambda$0((ApiKeySecurityScheme) obj, (Map) obj2);
            case 17:
                return Components.Companion.Serializer._init_$lambda$0((Components) obj, (Map) obj2);
            case 18:
                return Encoding.Companion.Serializer._init_$lambda$0((Encoding) obj, (Map) obj2);
            case 19:
                return ExampleObject.Companion.Serializer._init_$lambda$0((ExampleObject) obj, (Map) obj2);
            case 20:
                return Header.Companion.Serializer._init_$lambda$0((Header) obj, (Map) obj2);
            case 21:
                return HttpSecurityScheme.Companion.Serializer._init_$lambda$0((HttpSecurityScheme) obj, (Map) obj2);
            case 22:
                return Link.Companion.Serializer._init_$lambda$0((Link) obj, (Map) obj2);
            case 23:
                return MediaType.Companion.Serializer._init_$lambda$0((MediaType) obj, (Map) obj2);
            case 24:
                return OAuth2SecurityScheme.Companion.Serializer._init_$lambda$0((OAuth2SecurityScheme) obj, (Map) obj2);
            case 25:
                return OAuthFlow.Companion.Serializer._init_$lambda$0((OAuthFlow) obj, (Map) obj2);
            case 26:
                return OAuthFlows.Companion.Serializer._init_$lambda$0((OAuthFlows) obj, (Map) obj2);
            case 27:
                return OpenApiDoc.Companion.Serializer._init_$lambda$0((OpenApiDoc) obj, (Map) obj2);
            case 28:
                return OpenApiInfo.Companion.Serializer._init_$lambda$0((OpenApiInfo) obj, (Map) obj2);
            default:
                return OpenIdConnectSecurityScheme.Companion.Serializer._init_$lambda$0((OpenIdConnectSecurityScheme) obj, (Map) obj2);
        }
    }
}
