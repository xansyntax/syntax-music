package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.collections.ReversedListReadOnly;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MatcherMatchResult implements MatchResult {
    public ReversedListReadOnly groupValues_;
    public final MatcherMatchResult$groups$1 groups;
    public final CharSequence input;
    public final Matcher matcher;

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        charSequence.getClass();
        this.matcher = matcher;
        this.input = charSequence;
        this.groups = new MatcherMatchResult$groups$1((byte) 0, this);
    }

    public final List getGroupValues() {
        ReversedListReadOnly reversedListReadOnly = this.groupValues_;
        if (reversedListReadOnly != null) {
            return reversedListReadOnly;
        }
        ReversedListReadOnly reversedListReadOnly2 = new ReversedListReadOnly((byte) 2, this);
        this.groupValues_ = reversedListReadOnly2;
        return reversedListReadOnly2;
    }

    public final IntRange getRange() {
        Matcher matcher = this.matcher;
        return UuidKt.until(matcher.start(), matcher.end());
    }

    public final String getValue() {
        String strGroup = this.matcher.group();
        strGroup.getClass();
        return strGroup;
    }

    public final MatcherMatchResult next() {
        Matcher matcher = this.matcher;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.input;
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        matcher2.getClass();
        return RegexKt.findNext(matcher2, iEnd, charSequence);
    }
}
