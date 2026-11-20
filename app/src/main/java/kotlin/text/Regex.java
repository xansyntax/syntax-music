package kotlin.text;

import io.ktor.http.Url$$ExternalSyntheticLambda1;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.GeneratorSequence;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Regex implements Serializable {
    public final Pattern nativePattern;

    public Regex(String str, int i) {
        str.getClass();
        Pattern patternCompile = Pattern.compile(str, 66);
        patternCompile.getClass();
        this.nativePattern = patternCompile;
    }

    public static MatcherMatchResult find$default(Regex regex, CharSequence charSequence) {
        regex.getClass();
        charSequence.getClass();
        Matcher matcher = regex.nativePattern.matcher(charSequence);
        matcher.getClass();
        return RegexKt.findNext(matcher, 0, charSequence);
    }

    public static GeneratorSequence findAll$default(Regex regex, String str) {
        regex.getClass();
        str.getClass();
        if (str.length() >= 0) {
            return new GeneratorSequence(new Url$$ExternalSyntheticLambda1(regex, str, (byte) 3), Regex$findAll$2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: 0, input length: " + str.length());
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        charSequence.getClass();
        return this.nativePattern.matcher(charSequence).find();
    }

    public final MatcherMatchResult matchAt(int i, String str) {
        Matcher matcherRegion = this.nativePattern.matcher(str).useAnchoringBounds(false).useTransparentBounds(true).region(i, str.length());
        if (matcherRegion.lookingAt()) {
            return new MatcherMatchResult(matcherRegion, str);
        }
        return null;
    }

    public final MatcherMatchResult matchEntire(String str) {
        str.getClass();
        Matcher matcher = this.nativePattern.matcher(str);
        matcher.getClass();
        if (matcher.matches()) {
            return new MatcherMatchResult(matcher, str);
        }
        return null;
    }

    public final boolean matches(CharSequence charSequence) {
        charSequence.getClass();
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final String replace(String str, Function1 function1) {
        str.getClass();
        Matcher matcher = this.nativePattern.matcher(str);
        matcher.getClass();
        int i = 0;
        MatcherMatchResult matcherMatchResultFindNext = RegexKt.findNext(matcher, 0, str);
        if (matcherMatchResultFindNext == null) {
            return str.toString();
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append((CharSequence) str, i, matcherMatchResultFindNext.getRange().first);
            sb.append((CharSequence) function1.invoke(matcherMatchResultFindNext));
            i = matcherMatchResultFindNext.getRange().last + 1;
            matcherMatchResultFindNext = matcherMatchResultFindNext.next();
            if (i >= length) {
                break;
            }
        } while (matcherMatchResultFindNext != null);
        if (i < length) {
            sb.append((CharSequence) str, i, length);
        }
        return sb.toString();
    }

    public final String replaceFirst(CharSequence charSequence) {
        charSequence.getClass();
        String strReplaceFirst = this.nativePattern.matcher(charSequence).replaceFirst("");
        strReplaceFirst.getClass();
        return strReplaceFirst;
    }

    public final String toString() {
        String string = this.nativePattern.toString();
        string.getClass();
        return string;
    }

    public Regex(String str) {
        str.getClass();
        Pattern patternCompile = Pattern.compile(str);
        patternCompile.getClass();
        this.nativePattern = patternCompile;
    }

    public final String replace(CharSequence charSequence, String str) {
        charSequence.getClass();
        String strReplaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        strReplaceAll.getClass();
        return strReplaceAll;
    }
}
