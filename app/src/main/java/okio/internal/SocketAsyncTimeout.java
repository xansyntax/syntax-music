package okio.internal;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SocketAsyncTimeout extends AsyncTimeout {
    public final Socket socket;

    public SocketAsyncTimeout(Socket socket) {
        this.socket = socket;
    }

    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    public final void timedOut() {
        Socket socket = this.socket;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (!_JavaIoKt.isAndroidGetsocknameError(e)) {
                throw e;
            }
            _JavaIoKt.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
        } catch (Exception e2) {
            _JavaIoKt.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
        }
    }
}
