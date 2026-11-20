package com.google.common.base;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CharMatcher implements Predicate {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class And extends CharMatcher {
        public final CharMatcher first;
        public final CharMatcher second;

        public And(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.first = charMatcher;
            charMatcher2.getClass();
            this.second = charMatcher2;
        }

        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return matches(((Character) obj).charValue());
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            return this.first.matches(c) && this.second.matches(c);
        }

        public final String toString() {
            return this.first + ".and(" + this.second + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Any extends FastMatcher {
        public static final Any INSTANCE = new Any("CharMatcher.any()", (byte) 0);
        public static final Any INSTANCE$1 = new Any("CharMatcher.ascii()", (byte) 1);
        public static final Any INSTANCE$2 = new Any("CharMatcher.javaIsoControl()", (byte) 2);
        public static final Any INSTANCE$3 = new Any("CharMatcher.none()", (byte) 3);
        public final /* synthetic */ byte $r8$classId;
        public final String description;

        public Any(String str, byte b) {
            this.$r8$classId = b;
            this.description = str;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            switch (this.$r8$classId) {
                case 0:
                    return true;
                case 1:
                    return c <= 127;
                case 2:
                    return c <= 31 || (c >= 127 && c <= 159);
                default:
                    return false;
            }
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            switch (this.$r8$classId) {
                case 0:
                    return INSTANCE$3;
                case 3:
                    return INSTANCE;
                default:
                    return super.negate();
            }
        }

        public final String toString() {
            return this.description;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class FastMatcher extends CharMatcher {
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return matches(((Character) obj).charValue());
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Is extends FastMatcher {
        public final /* synthetic */ byte $r8$classId;
        public final char match;

        public /* synthetic */ Is(char c, byte b) {
            this.$r8$classId = b;
            this.match = c;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            switch (this.$r8$classId) {
                case 0:
                    return c == this.match;
                default:
                    return c != this.match;
            }
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public final CharMatcher negate() {
            switch (this.$r8$classId) {
                case 0:
                    return new Is(this.match, (byte) 1);
                default:
                    return new Is(this.match, (byte) 0);
            }
        }

        public final String toString() {
            byte b = this.$r8$classId;
            char c = this.match;
            switch (b) {
                case 0:
                    return "CharMatcher.is('" + CharMatcher.showCharacter(c) + "')";
                default:
                    return "CharMatcher.isNot('" + CharMatcher.showCharacter(c) + "')";
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class IsEither extends FastMatcher {
        public final char match1;
        public final char match2;

        public IsEither(char c, char c2) {
            this.match1 = c;
            this.match2 = c2;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            return c == this.match1 || c == this.match2;
        }

        public final String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(this.match1) + CharMatcher.showCharacter(this.match2) + "\")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NegatedFastMatcher extends AnyOf {
    }

    public static CharMatcher anyOf(String str) {
        int length = str.length();
        if (length == 0) {
            return Any.INSTANCE$3;
        }
        byte b = 0;
        if (length != 1) {
            return length != 2 ? new AnyOf(str) : new IsEither(str.charAt(0), str.charAt(1));
        }
        return new Is(str.charAt(0), b);
    }

    public static String showCharacter(char c) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public abstract boolean matches(char c);

    public CharMatcher negate() {
        return new AnyOf(this);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class AnyOf extends CharMatcher {
        public final /* synthetic */ byte $r8$classId = 1;
        public final Object chars;

        public AnyOf(String str) {
            char[] charArray = str.toString().toCharArray();
            this.chars = charArray;
            Arrays.sort(charArray);
        }

        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return matches(((Character) obj).charValue());
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            byte b = this.$r8$classId;
            Object obj = this.chars;
            switch (b) {
                case 0:
                    return Arrays.binarySearch((char[]) obj, c) >= 0;
                default:
                    return !((CharMatcher) obj).matches(c);
            }
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            switch (this.$r8$classId) {
                case 1:
                    return (CharMatcher) this.chars;
                default:
                    return super.negate();
            }
        }

        public final String toString() {
            byte b = this.$r8$classId;
            Object obj = this.chars;
            switch (b) {
                case 0:
                    StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
                    for (char c : (char[]) obj) {
                        sb.append(CharMatcher.showCharacter(c));
                    }
                    sb.append("\")");
                    return sb.toString();
                default:
                    return ((CharMatcher) obj) + ".negate()";
            }
        }

        public AnyOf(CharMatcher charMatcher) {
            this.chars = charMatcher;
        }
    }
}
