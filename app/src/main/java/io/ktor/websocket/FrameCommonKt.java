package io.ktor.websocket;

import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt__Strings_jvmKt;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.text.Charsets;
import kotlinx.io.Buffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/websocket/Frame$Text;", "", "readText", "(Lio/ktor/websocket/Frame$Text;)Ljava/lang/String;", "Lio/ktor/websocket/Frame;", "", "readBytes", "(Lio/ktor/websocket/Frame;)[B", "Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/CloseReason;", "readReason", "(Lio/ktor/websocket/Frame$Close;)Lio/ktor/websocket/CloseReason;", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FrameCommonKt {
    public static final byte[] readBytes(Frame frame) {
        frame.getClass();
        byte[] data = frame.getData();
        return Arrays.copyOf(data, data.length);
    }

    public static final CloseReason readReason(Frame.Close close) {
        close.getClass();
        if (close.getData().length < 2) {
            return null;
        }
        Buffer buffer = new Buffer();
        BytePacketBuilderKt.writeFully$default(buffer, close.getData(), 0, 0, 6, null);
        return new CloseReason(buffer.readShort(), StringsKt__Strings_jvmKt.readText$default(buffer, null, 0, 3, null));
    }

    public static final String readText(Frame.Text text) {
        text.getClass();
        if (!text.getFin()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Text could be only extracted from non-fragmented frame");
            return null;
        }
        CharsetDecoder charsetDecoderNewDecoder = Charsets.UTF_8.newDecoder();
        charsetDecoderNewDecoder.getClass();
        Buffer buffer = new Buffer();
        BytePacketBuilderKt.writeFully$default(buffer, text.getData(), 0, 0, 6, null);
        return EncodingKt.decode$default(charsetDecoderNewDecoder, buffer, 0, 2, null);
    }
}
