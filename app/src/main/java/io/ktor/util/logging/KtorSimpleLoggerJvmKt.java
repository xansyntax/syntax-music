package io.ktor.util.logging;

import androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda2;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.SynchronizedLazyImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.spi.LoggingEventBuilder;
import org.slf4j.spi.NOPLoggingEventBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", ContentDisposition.Parameters.Name, "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "KtorSimpleLogger", "(Ljava/lang/String;)Lorg/slf4j/Logger;", "", "isAndroid", "Z", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class KtorSimpleLoggerJvmKt {
    private static final boolean isAndroid;

    static {
        boolean z;
        try {
            Class.forName("android.os.Build");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        isAndroid = z;
    }

    public static final Logger KtorSimpleLogger(String str) {
        str.getClass();
        return !isAndroid ? LoggerFactory.getLogger(str) : new AnonymousClass1(str);
    }

    /* JADX INFO: renamed from: io.ktor.util.logging.KtorSimpleLoggerJvmKt$KtorSimpleLogger$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\n\u0010\u000fJ-\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\n\u0010\u0012J1\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\n\u0010\u0015J#\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\n\u0010\u0018J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u0006\u0010\u001bJ#\u0010\n\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u001cJ-\u0010\n\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\n\u0010\u001dJ7\u0010\n\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\n\u0010\u001eJ;\u0010\n\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\n\u0010 J-\u0010\n\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\n\u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0007J\u0019\u0010#\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b#\u0010\u000bJ#\u0010#\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b#\u0010\u000fJ-\u0010#\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b#\u0010\u0012J1\u0010#\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b#\u0010\u0015J#\u0010#\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b#\u0010\u0018J\u0019\u0010\"\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\"\u0010\u001bJ#\u0010#\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b#\u0010\u001cJ-\u0010#\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b#\u0010\u001dJ7\u0010#\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b#\u0010\u001eJ;\u0010#\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b#\u0010 J-\u0010#\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b#\u0010!J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u0007J\u0019\u0010%\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b%\u0010\u000bJ#\u0010%\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b%\u0010\u000fJ-\u0010%\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b%\u0010\u0012J1\u0010%\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b%\u0010\u0015J#\u0010%\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b%\u0010\u0018J\u0019\u0010$\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b$\u0010\u001bJ#\u0010%\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b%\u0010\u001cJ-\u0010%\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b%\u0010\u001dJ7\u0010%\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b%\u0010\u001eJ;\u0010%\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b%\u0010 J-\u0010%\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b%\u0010!J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0007J\u0019\u0010'\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b'\u0010\u000bJ#\u0010'\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b'\u0010\u000fJ1\u0010'\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b'\u0010\u0015J-\u0010'\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b'\u0010\u0012J#\u0010'\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b'\u0010\u0018J\u0019\u0010&\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b&\u0010\u001bJ#\u0010'\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b'\u0010\u001cJ-\u0010'\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b'\u0010\u001dJ7\u0010'\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b'\u0010\u001eJ;\u0010'\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b'\u0010 J-\u0010'\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b'\u0010!J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0007J\u0019\u0010)\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b)\u0010\u000bJ#\u0010)\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b)\u0010\u000fJ-\u0010)\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b)\u0010\u0012J1\u0010)\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b)\u0010\u0015J#\u0010)\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b)\u0010\u0018J\u0019\u0010(\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b(\u0010\u001bJ#\u0010)\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b)\u0010\u001cJ-\u0010)\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b)\u0010\u001dJ7\u0010)\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b)\u0010\u001eJ;\u0010)\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b)\u0010 J-\u0010)\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b)\u0010!R#\u0010/\u001a\n **\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"io/ktor/util/logging/KtorSimpleLoggerJvmKt$KtorSimpleLogger$1", "Lorg/slf4j/Logger;", "", "getName", "()Ljava/lang/String;", "", "isTraceEnabled", "()Z", "msg", "", "trace", "(Ljava/lang/String;)V", "format", "", "arg", "(Ljava/lang/String;Ljava/lang/Object;)V", "arg1", "arg2", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "", "arguments", "(Ljava/lang/String;[Ljava/lang/Object;)V", "", "t", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Lorg/slf4j/Marker;", "marker", "(Lorg/slf4j/Marker;)Z", "(Lorg/slf4j/Marker;Ljava/lang/String;)V", "(Lorg/slf4j/Marker;Ljava/lang/String;Ljava/lang/Object;)V", "(Lorg/slf4j/Marker;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "argArray", "(Lorg/slf4j/Marker;Ljava/lang/String;[Ljava/lang/Object;)V", "(Lorg/slf4j/Marker;Ljava/lang/String;Ljava/lang/Throwable;)V", "isDebugEnabled", "debug", "isInfoEnabled", "info", "isWarnEnabled", "warn", "isErrorEnabled", "error", "kotlin.jvm.PlatformType", "logger$delegate", "Lkotlin/Lazy;", "getLogger", "()Lorg/slf4j/Logger;", "logger", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 implements Logger {

        /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
        private final Lazy logger;

        public AnonymousClass1(String str) {
            this.logger = new SynchronizedLazyImpl(new NavDestinationImpl$$ExternalSyntheticLambda2(str, (byte) 8));
        }

        private final Logger getLogger() {
            return (Logger) this.logger.getValue();
        }

        public LoggingEventBuilder atDebug() {
            return isDebugEnabled() ? makeLoggingEventBuilder(Level.DEBUG) : NOPLoggingEventBuilder.SINGLETON;
        }

        public LoggingEventBuilder atError() {
            return isErrorEnabled() ? makeLoggingEventBuilder(Level.ERROR) : NOPLoggingEventBuilder.SINGLETON;
        }

        public LoggingEventBuilder atInfo() {
            return isInfoEnabled() ? makeLoggingEventBuilder(Level.INFO) : NOPLoggingEventBuilder.SINGLETON;
        }

        public LoggingEventBuilder atLevel(Level level) {
            return isEnabledForLevel(level) ? makeLoggingEventBuilder(level) : NOPLoggingEventBuilder.SINGLETON;
        }

        public LoggingEventBuilder atTrace() {
            return isTraceEnabled() ? makeLoggingEventBuilder(Level.TRACE) : NOPLoggingEventBuilder.SINGLETON;
        }

        public LoggingEventBuilder atWarn() {
            return isWarnEnabled() ? makeLoggingEventBuilder(Level.WARN) : NOPLoggingEventBuilder.SINGLETON;
        }

        @Override // org.slf4j.Logger
        public void debug(String format, Object... arguments) {
            arguments.getClass();
            getLogger().debug(format, Arrays.copyOf(arguments, arguments.length));
        }

        @Override // org.slf4j.Logger
        public void error(String format, Object... arguments) {
            arguments.getClass();
            getLogger().error(format, Arrays.copyOf(arguments, arguments.length));
        }

        @Override // org.slf4j.Logger
        public String getName() {
            String name = getLogger().getName();
            name.getClass();
            return name;
        }

        @Override // org.slf4j.Logger
        public void info(String format, Object... arguments) {
            arguments.getClass();
            getLogger().info(format, Arrays.copyOf(arguments, arguments.length));
        }

        @Override // org.slf4j.Logger
        public boolean isDebugEnabled() {
            return getLogger().isDebugEnabled();
        }

        @Override // org.slf4j.Logger
        public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level level) {
            return super.isEnabledForLevel(level);
        }

        @Override // org.slf4j.Logger
        public boolean isErrorEnabled() {
            return getLogger().isErrorEnabled();
        }

        @Override // org.slf4j.Logger
        public boolean isInfoEnabled() {
            return getLogger().isInfoEnabled();
        }

        @Override // org.slf4j.Logger
        public boolean isTraceEnabled() {
            return getLogger().isTraceEnabled();
        }

        @Override // org.slf4j.Logger
        public boolean isWarnEnabled() {
            return getLogger().isWarnEnabled();
        }

        @Override // org.slf4j.Logger
        public LoggingEventBuilder makeLoggingEventBuilder(Level level) {
            return new NOPLoggingEventBuilder();
        }

        @Override // org.slf4j.Logger
        public void trace(String format, Object... arguments) {
            arguments.getClass();
            getLogger().trace(format, Arrays.copyOf(arguments, arguments.length));
        }

        @Override // org.slf4j.Logger
        public void warn(String format, Object... arguments) {
            arguments.getClass();
            getLogger().warn(format, Arrays.copyOf(arguments, arguments.length));
        }

        @Override // org.slf4j.Logger
        public boolean isDebugEnabled(Marker marker) {
            return getLogger().isDebugEnabled(marker);
        }

        @Override // org.slf4j.Logger
        public boolean isErrorEnabled(Marker marker) {
            return getLogger().isErrorEnabled(marker);
        }

        @Override // org.slf4j.Logger
        public boolean isInfoEnabled(Marker marker) {
            return getLogger().isInfoEnabled(marker);
        }

        @Override // org.slf4j.Logger
        public boolean isTraceEnabled(Marker marker) {
            return getLogger().isTraceEnabled(marker);
        }

        @Override // org.slf4j.Logger
        public boolean isWarnEnabled(Marker marker) {
            return getLogger().isWarnEnabled(marker);
        }

        @Override // org.slf4j.Logger
        public void debug(String format, Object arg) {
            getLogger().debug(format, arg);
        }

        @Override // org.slf4j.Logger
        public void error(String format, Object arg) {
            getLogger().error(format, arg);
        }

        @Override // org.slf4j.Logger
        public void info(String format, Object arg) {
            getLogger().info(format, arg);
        }

        @Override // org.slf4j.Logger
        public void trace(String format, Object arg) {
            getLogger().trace(format, arg);
        }

        @Override // org.slf4j.Logger
        public void warn(String format, Object arg) {
            getLogger().warn(format, arg);
        }

        @Override // org.slf4j.Logger
        public void debug(String format, Object arg1, Object arg2) {
            getLogger().debug(format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void error(String format, Object arg1, Object arg2) {
            getLogger().error(format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void info(String format, Object arg1, Object arg2) {
            getLogger().info(format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void trace(String format, Object arg1, Object arg2) {
            getLogger().trace(format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void warn(String msg) {
            getLogger().warn(msg);
        }

        @Override // org.slf4j.Logger
        public void debug(String msg) {
            getLogger().debug(msg);
        }

        @Override // org.slf4j.Logger
        public void error(String msg) {
            getLogger().error(msg);
        }

        @Override // org.slf4j.Logger
        public void info(String msg) {
            getLogger().info(msg);
        }

        @Override // org.slf4j.Logger
        public void trace(String msg) {
            getLogger().trace(msg);
        }

        @Override // org.slf4j.Logger
        public void warn(String format, Object arg1, Object arg2) {
            getLogger().warn(format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void debug(String msg, Throwable t) {
            getLogger().debug(msg, t);
        }

        @Override // org.slf4j.Logger
        public void error(String msg, Throwable t) {
            getLogger().error(msg, t);
        }

        @Override // org.slf4j.Logger
        public void info(String msg, Throwable t) {
            getLogger().info(msg, t);
        }

        @Override // org.slf4j.Logger
        public void trace(String msg, Throwable t) {
            getLogger().trace(msg, t);
        }

        @Override // org.slf4j.Logger
        public void warn(String msg, Throwable t) {
            getLogger().warn(msg, t);
        }

        @Override // org.slf4j.Logger
        public void debug(Marker marker, String msg) {
            getLogger().debug(marker, msg);
        }

        @Override // org.slf4j.Logger
        public void error(Marker marker, String msg) {
            getLogger().error(marker, msg);
        }

        @Override // org.slf4j.Logger
        public void info(Marker marker, String msg) {
            getLogger().info(marker, msg);
        }

        @Override // org.slf4j.Logger
        public void trace(Marker marker, String msg) {
            getLogger().trace(marker, msg);
        }

        @Override // org.slf4j.Logger
        public void warn(Marker marker, String msg) {
            getLogger().warn(marker, msg);
        }

        @Override // org.slf4j.Logger
        public void debug(Marker marker, String format, Object arg) {
            getLogger().debug(marker, format, arg);
        }

        @Override // org.slf4j.Logger
        public void error(Marker marker, String format, Object arg) {
            getLogger().error(marker, format, arg);
        }

        @Override // org.slf4j.Logger
        public void info(Marker marker, String format, Object arg) {
            getLogger().info(marker, format, arg);
        }

        @Override // org.slf4j.Logger
        public void trace(Marker marker, String format, Object arg) {
            getLogger().trace(marker, format, arg);
        }

        @Override // org.slf4j.Logger
        public void warn(Marker marker, String format, Object arg) {
            getLogger().warn(marker, format, arg);
        }

        @Override // org.slf4j.Logger
        public void debug(Marker marker, String format, Object arg1, Object arg2) {
            getLogger().debug(marker, format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void error(Marker marker, String format, Object arg1, Object arg2) {
            getLogger().error(marker, format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void info(Marker marker, String format, Object arg1, Object arg2) {
            getLogger().info(marker, format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void trace(Marker marker, String format, Object arg1, Object arg2) {
            getLogger().trace(marker, format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void warn(Marker marker, String format, Object arg1, Object arg2) {
            getLogger().warn(marker, format, arg1, arg2);
        }

        @Override // org.slf4j.Logger
        public void debug(Marker marker, String format, Object... arguments) {
            arguments.getClass();
            getLogger().debug(marker, format, Arrays.copyOf(arguments, arguments.length));
        }

        @Override // org.slf4j.Logger
        public void error(Marker marker, String format, Object... arguments) {
            arguments.getClass();
            getLogger().error(marker, format, Arrays.copyOf(arguments, arguments.length));
        }

        @Override // org.slf4j.Logger
        public void info(Marker marker, String format, Object... arguments) {
            arguments.getClass();
            getLogger().info(marker, format, Arrays.copyOf(arguments, arguments.length));
        }

        @Override // org.slf4j.Logger
        public void trace(Marker marker, String format, Object... argArray) {
            argArray.getClass();
            getLogger().trace(marker, format, Arrays.copyOf(argArray, argArray.length));
        }

        @Override // org.slf4j.Logger
        public void warn(Marker marker, String format, Object... arguments) {
            arguments.getClass();
            getLogger().warn(marker, format, Arrays.copyOf(arguments, arguments.length));
        }

        @Override // org.slf4j.Logger
        public void debug(Marker marker, String msg, Throwable t) {
            getLogger().debug(marker, msg, t);
        }

        @Override // org.slf4j.Logger
        public void error(Marker marker, String msg, Throwable t) {
            getLogger().error(marker, msg, t);
        }

        @Override // org.slf4j.Logger
        public void info(Marker marker, String msg, Throwable t) {
            getLogger().info(marker, msg, t);
        }

        @Override // org.slf4j.Logger
        public void trace(Marker marker, String msg, Throwable t) {
            getLogger().trace(marker, msg, t);
        }

        @Override // org.slf4j.Logger
        public void warn(Marker marker, String msg, Throwable t) {
            getLogger().warn(marker, msg, t);
        }
    }
}
