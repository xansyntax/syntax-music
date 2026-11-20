package io.ktor.websocket;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\f\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0007\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/websocket/Frame;", "", "validateSize", "(Lio/ktor/websocket/Frame;)V", "", "", "index", "utf8ByteCountAt", "(Ljava/lang/String;I)I", "utf8Size", "(Ljava/lang/String;)I", "maxSize", "utf8Truncate", "(Ljava/lang/String;I)Ljava/lang/String;", "MAX_CONTROL_FRAME_PAYLOAD_SIZE", "I", "MAX_CLOSE_REASON_MESSAGE_SIZE", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ControlFramesKt {
    public static final int MAX_CLOSE_REASON_MESSAGE_SIZE = 123;
    public static final int MAX_CONTROL_FRAME_PAYLOAD_SIZE = 125;

    private static final int utf8ByteCountAt(String str, int i) {
        int i2;
        char cCharAt = str.charAt(i);
        if (cCharAt < 128) {
            return 1;
        }
        if (cCharAt < 2048) {
            return 2;
        }
        return (Character.isHighSurrogate(str.charAt(i)) && (i2 = i + 1) < str.length() && Character.isLowSurrogate(str.charAt(i2))) ? 4 : 3;
    }

    public static final int utf8Size(String str) {
        str.getClass();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int iUtf8ByteCountAt = utf8ByteCountAt(str, i);
            i2 += iUtf8ByteCountAt;
            i += iUtf8ByteCountAt == 4 ? 2 : 1;
        }
        return i2;
    }

    public static final String utf8Truncate(String str, int i) {
        int iUtf8ByteCountAt;
        str.getClass();
        int i2 = 0;
        int iUtf8ByteCountAt2 = 0;
        while (i2 < str.length() && (iUtf8ByteCountAt2 = iUtf8ByteCountAt2 + (iUtf8ByteCountAt = utf8ByteCountAt(str, i2))) <= i) {
            i2 += iUtf8ByteCountAt == 4 ? 2 : 1;
        }
        return i2 == str.length() ? str : str.substring(0, i2);
    }

    public static final void validateSize(Frame frame) {
        frame.getClass();
        if (!frame.getFrameType().getControlFrame() || frame.getData().length <= 125) {
            return;
        }
        StringBuilder sb = new StringBuilder("Control frames must not exceed 125 bytes per RFC 6455, but ");
        sb.append(frame.getFrameType());
        sb.append(" frame has ");
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(sb, frame.getData().length, " bytes"));
    }
}
