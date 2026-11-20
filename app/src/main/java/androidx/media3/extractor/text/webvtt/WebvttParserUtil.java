package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import io.ktor.sse.ServerSentEventKt;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WebvttParserUtil {
    static {
        Pattern.compile("^NOTE([ \t].*)?$");
    }

    public static float parsePercentage(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long parseTimestampUs(String str) {
        String str2 = Util.DEVICE_DEBUG_INFO;
        String[] strArrSplit = str.split("\\.", 2);
        long j = 0;
        for (String str3 : strArrSplit[0].split(ServerSentEventKt.COLON, -1)) {
            j = (j * 60) + Long.parseLong(str3);
        }
        long j2 = j * 1000;
        if (strArrSplit.length == 2) {
            String strTrim = strArrSplit[1].trim();
            if (strTrim.length() != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Expected 3 decimal places, got: ".concat(strTrim));
                return 0L;
            }
            j2 += Long.parseLong(strTrim);
        }
        return j2 * 1000;
    }

    public static void validateWebvttHeaderLine(ParsableByteArray parsableByteArray) {
        int i = parsableByteArray.position;
        Charset charset = StandardCharsets.UTF_8;
        String line = parsableByteArray.readLine(charset);
        if (line == null || !line.startsWith("WEBVTT")) {
            parsableByteArray.setPosition(i);
            throw ParserException.createForMalformedContainer(null, "Expected WEBVTT. Got " + parsableByteArray.readLine(charset));
        }
    }
}
