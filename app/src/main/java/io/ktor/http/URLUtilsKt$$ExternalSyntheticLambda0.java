package io.ktor.http;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.http.auth.HttpAuthHeaderKt;
import io.ktor.http.cio.CIOHeaders;
import io.ktor.http.cio.ConnectionOptions;
import io.ktor.http.cio.internals.AsciiCharTree;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.network.sockets.BuildersKt;
import io.ktor.network.sockets.DatagramSendChannelBaseKt;
import io.ktor.network.sockets.SocketOptions;
import io.ktor.network.sockets.TcpSocketBuilder;
import io.ktor.network.sockets.UDPSocketBuilder;
import io.ktor.openapi.ExtensibleMixinSerializer;
import io.ktor.openapi.Header;
import io.ktor.openapi.JsonSchemaInferenceKt;
import io.ktor.openapi.MediaType;
import io.ktor.openapi.Parameter;
import io.ktor.openapi.RequestBody;
import io.ktor.openapi.Response;
import io.ktor.openapi.Responses;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class URLUtilsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ URLUtilsKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return URLUtilsKt.appendUrlFullPath$lambda$1((Pair) obj);
            case 1:
                return HttpUrlEncodedKt.formUrlEncodeTo$lambda$0((Pair) obj);
            case 2:
                return Boolean.valueOf(RangesSpecifier.isValid$lambda$0((String) obj));
            case 3:
                return URLBuilderKt.set$lambda$0((URLBuilder) obj);
            case 4:
                return HttpAuthHeaderKt.unescaped$lambda$0((MatchResult) obj);
            case 5:
                return CIOHeaders.getAll$lambda$0((CharSequence) obj);
            case 6:
                return Integer.valueOf(ConnectionOptions.knownTypes$lambda$0((Pair) obj));
            case 7:
                return Integer.valueOf(AsciiCharTree.Companion.build$lambda$0((CharSequence) obj));
            case 8:
                return Integer.valueOf(CharsKt.DefaultHttpMethods$lambda$0((HttpMethod) obj));
            case 9:
                return BuildersKt.tcpNoDelay$lambda$0((SocketOptions) obj);
            case 10:
                return DatagramSendChannelBaseKt.CLOSED$lambda$0((Throwable) obj);
            case 11:
                return DatagramSendChannelBaseKt.CLOSED_INVOKED$lambda$0((Throwable) obj);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return TcpSocketBuilder.connect$lambda$0((SocketOptions.TCPClientSocketOptions) obj);
            case 13:
                return TcpSocketBuilder.bind$lambda$1((SocketOptions.AcceptorOptions) obj);
            case 14:
                return TcpSocketBuilder.connect$lambda$1((SocketOptions.TCPClientSocketOptions) obj);
            case 15:
                return TcpSocketBuilder.bind$lambda$0((SocketOptions.AcceptorOptions) obj);
            case 16:
                return UDPSocketBuilder.bind$lambda$1((SocketOptions.UDPSocketOptions) obj);
            case 17:
                return UDPSocketBuilder.bind$lambda$0((SocketOptions.UDPSocketOptions) obj);
            case 18:
                return UDPSocketBuilder.connect$lambda$0((SocketOptions.UDPSocketOptions) obj);
            case 19:
                return Boolean.valueOf(ExtensibleMixinSerializer._init_$lambda$0((String) obj));
            case 20:
                return Header.Builder.invoke$lambda$0((MediaType.Builder) obj);
            case 21:
                return JsonSchemaInferenceKt.KotlinxSerializerDefaultFormats$lambda$0((SerialDescriptor) obj);
            case 22:
                return Parameter.Builder.invoke$lambda$0((MediaType.Builder) obj);
            case 23:
                return io.ktor.openapi.Parameters.Builder.path$lambda$0((Parameter.Builder) obj);
            case 24:
                return io.ktor.openapi.Parameters.Builder.header$lambda$0((Parameter.Builder) obj);
            case 25:
                return io.ktor.openapi.Parameters.Builder.query$lambda$0((Parameter.Builder) obj);
            case 26:
                return io.ktor.openapi.Parameters.Builder.cookie$lambda$0((Parameter.Builder) obj);
            case 27:
                return RequestBody.Builder.invoke$lambda$0((MediaType.Builder) obj);
            case 28:
                return Response.Builder.invoke$lambda$0((MediaType.Builder) obj);
            default:
                return Responses.Builder.invoke$lambda$0((Response.Builder) obj);
        }
    }
}
