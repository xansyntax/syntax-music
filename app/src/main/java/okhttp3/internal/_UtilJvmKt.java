package okhttp3.internal;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.http.HttpHeaders;
import io.ktor.sse.ServerSentEventKt;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class _UtilJvmKt {
    public static final TimeZone UTC;
    public static final String okHttpName;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        timeZone.getClass();
        UTC = timeZone;
        okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix(OkHttpClient.class.getName(), "okhttp3."), "Client");
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        httpUrl.getClass();
        return Intrinsics.areEqual(httpUrl.host, httpUrl2.host) && httpUrl.port == httpUrl2.port && Intrinsics.areEqual(httpUrl.scheme, httpUrl2.scheme);
    }

    public static final int checkDuration(String str, long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) str.concat(" < 0"));
            return 0;
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) str.concat(" too large"));
            return 0;
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) str.concat(" too small"));
        return 0;
    }

    public static final void closeQuietly(Socket socket) {
        socket.getClass();
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            if (!Intrinsics.areEqual(e2.getMessage(), "bio == null")) {
                throw e2;
            }
        } catch (Exception unused) {
        }
    }

    public static final String format(String str, Object... objArr) {
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final long headersContentLength(Response response) {
        String str = response.headers.get(HttpHeaders.ContentLength);
        if (str == null) {
            return -1L;
        }
        byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) {
        bufferedSource.getClass();
        charset.getClass();
        int iSelect = bufferedSource.select(_UtilCommonKt.UNICODE_BOMS);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            return Charsets.UTF_8;
        }
        if (iSelect == 1) {
            return Charsets.UTF_16BE;
        }
        if (iSelect == 2) {
            Charsets charsets = Charsets.INSTANCE;
            Charset charset2 = Charsets.utf_32le;
            if (charset2 != null) {
                return charset2;
            }
            Charset charsetForName = Charset.forName("UTF-32LE");
            charsetForName.getClass();
            Charsets.utf_32le = charsetForName;
            return charsetForName;
        }
        if (iSelect == 3) {
            return Charsets.UTF_16LE;
        }
        if (iSelect != 4) {
            throw new AssertionError();
        }
        Charsets charsets2 = Charsets.INSTANCE;
        Charset charset3 = Charsets.utf_32be;
        if (charset3 != null) {
            return charset3;
        }
        Charset charsetForName2 = Charset.forName("UTF-32BE");
        charsetForName2.getClass();
        Charsets.utf_32be = charsetForName2;
        return charsetForName2;
    }

    public static final boolean skipAll(Source source, int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return true;
            }
            source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return false;
            }
            source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public static final Headers toHeaders(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            ByteString byteString = header.name;
            ByteString byteString2 = header.value;
            String strUtf8 = byteString.utf8();
            String strUtf9 = byteString2.utf8();
            arrayList.add(strUtf8);
            arrayList.add(StringsKt.trim(strUtf9).toString());
        }
        return new Headers((String[]) arrayList.toArray(new String[0]));
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z) {
        int i;
        httpUrl.getClass();
        int i2 = httpUrl.port;
        String strM = httpUrl.host;
        if (StringsKt.contains(strM, ServerSentEventKt.COLON, false)) {
            strM = Format$$ExternalSyntheticOutline0.m(']', "[", strM);
        }
        if (!z) {
            String str = httpUrl.scheme;
            str.getClass();
            if (str.equals("http")) {
                i = 80;
            } else {
                i = str.equals("https") ? 443 : -1;
            }
            if (i2 == i) {
                return strM;
            }
        }
        return strM + ':' + i2;
    }

    public static final List toImmutableList(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        if (list.size() == 1) {
            List listSingletonList = Collections.singletonList(list.get(0));
            listSingletonList.getClass();
            return listSingletonList;
        }
        Object[] array = list.toArray();
        array.getClass();
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        List listUnmodifiableList = Collections.unmodifiableList(listAsList);
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    public static final List toImmutableList(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            if (objArr.length == 1) {
                List listSingletonList = Collections.singletonList(objArr[0]);
                listSingletonList.getClass();
                return listSingletonList;
            }
            List listUnmodifiableList = Collections.unmodifiableList(ArraysKt.asList((Object[]) objArr.clone()));
            listUnmodifiableList.getClass();
            return listUnmodifiableList;
        }
        return EmptyList.INSTANCE;
    }
}
