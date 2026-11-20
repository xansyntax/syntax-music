package okhttp3.internal.ws;

import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.jvm.functions.Function0;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RealWebSocket$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ RealWebSocket$$ExternalSyntheticLambda1(Object obj, long j, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        WebSocketWriter webSocketWriter;
        boolean z;
        switch (this.$r8$classId) {
            case 0:
                RealWebSocket realWebSocket = (RealWebSocket) this.f$0;
                long j = this.f$1;
                synchronized (realWebSocket) {
                    try {
                        if (!realWebSocket.failed && (webSocketWriter = realWebSocket.writer) != null) {
                            int i = realWebSocket.awaitingPong ? realWebSocket.sentPingCount : -1;
                            realWebSocket.sentPingCount++;
                            realWebSocket.awaitingPong = true;
                            if (i != -1) {
                                StringBuilder sb = new StringBuilder("sent ping but didn't receive pong within ");
                                sb.append(realWebSocket.pingIntervalMillis);
                                sb.append("ms (after ");
                                RealWebSocket.failWebSocket$default(realWebSocket, new SocketTimeoutException(Fragment$5$$ExternalSyntheticOutline0.m(sb, i - 1, " successful ping/pongs)")), null, 2);
                            } else {
                                try {
                                    ByteString byteString = ByteString.EMPTY;
                                    byteString.getClass();
                                    webSocketWriter.writeControlFrame(9, byteString);
                                } catch (IOException e) {
                                    RealWebSocket.failWebSocket$default(realWebSocket, e, null, 2);
                                }
                            }
                            break;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return Long.valueOf(j);
            case 1:
                return ((ShaderBrush) ((Brush) this.f$0)).mo474createShaderuvyYCjk(this.f$1);
            case 2:
                return Long.valueOf(((ParcelableSnapshotMutableLongState) this.f$0).getLongValue() + this.f$1);
            default:
                Http2Connection http2Connection = (Http2Connection) this.f$0;
                long j2 = this.f$1;
                synchronized (http2Connection) {
                    long j3 = http2Connection.intervalPongsReceived;
                    long j4 = http2Connection.intervalPingsSent;
                    if (j3 < j4) {
                        z = true;
                    } else {
                        http2Connection.intervalPingsSent = j4 + 1;
                        z = false;
                    }
                }
                if (!z) {
                    try {
                        http2Connection.writer.ping(1, false, 0);
                    } catch (IOException e2) {
                        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                        http2Connection.close$okhttp(errorCode, errorCode, e2);
                    }
                    break;
                } else {
                    ErrorCode errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    http2Connection.close$okhttp(errorCode2, errorCode2, null);
                    j2 = -1;
                }
                return Long.valueOf(j2);
        }
    }
}
