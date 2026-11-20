package kotlin.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class HexFormat {
    public static final HexFormat Default;
    public final BytesHexFormat bytes;
    public final NumberHexFormat number;
    public final boolean upperCase;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class BytesHexFormat {
        public static final BytesHexFormat Default = new BytesHexFormat();
        public final boolean noLineAndGroupSeparator = true;
        public final boolean shortByteSeparatorNoPrefixAndSuffix = true;

        public BytesHexFormat() {
            if (HexFormatKt.isCaseSensitive("  ") || HexFormatKt.isCaseSensitive("") || HexFormatKt.isCaseSensitive("")) {
                return;
            }
            HexFormatKt.isCaseSensitive("");
        }

        public final void appendOptionsTo$kotlin_stdlib(StringBuilder sb, String str) {
            sb.append(str);
            sb.append("bytesPerLine = ");
            sb.append(Integer.MAX_VALUE);
            sb.append(",");
            sb.append('\n');
            sb.append(str);
            sb.append("bytesPerGroup = ");
            sb.append(Integer.MAX_VALUE);
            sb.append(",");
            sb.append('\n');
            sb.append(str);
            sb.append("groupSeparator = \"");
            sb.append("  ");
            sb.append("\",");
            sb.append('\n');
            sb.append(str);
            sb.append("byteSeparator = \"");
            sb.append("");
            sb.append("\",");
            sb.append('\n');
            IntIntPair$$ExternalSyntheticOutline0.m6m(sb, str, "bytePrefix = \"", "", "\",");
            sb.append('\n');
            sb.append(str);
            sb.append("byteSuffix = \"");
            sb.append("");
            sb.append("\"");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(\n");
            appendOptionsTo$kotlin_stdlib(sb, "    ");
            sb.append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NumberHexFormat {
        public static final NumberHexFormat Default;

        static {
            NumberHexFormat numberHexFormat = new NumberHexFormat();
            if (!HexFormatKt.isCaseSensitive("")) {
                HexFormatKt.isCaseSensitive("");
            }
            Default = numberHexFormat;
        }

        public final void appendOptionsTo$kotlin_stdlib(StringBuilder sb, String str) {
            IntIntPair$$ExternalSyntheticOutline0.m6m(sb, str, "prefix = \"", "", "\",");
            sb.append('\n');
            sb.append(str);
            sb.append("suffix = \"");
            sb.append("");
            sb.append("\",");
            sb.append('\n');
            sb.append(str);
            sb.append("removeLeadingZeros = ");
            sb.append(false);
            sb.append(',');
            sb.append('\n');
            sb.append(str);
            sb.append("minLength = ");
            sb.append(1);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(\n");
            appendOptionsTo$kotlin_stdlib(sb, "    ");
            sb.append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    static {
        BytesHexFormat bytesHexFormat = BytesHexFormat.Default;
        NumberHexFormat numberHexFormat = NumberHexFormat.Default;
        Default = new HexFormat(false, bytesHexFormat, numberHexFormat);
        new HexFormat(true, bytesHexFormat, numberHexFormat);
    }

    public HexFormat(boolean z, BytesHexFormat bytesHexFormat, NumberHexFormat numberHexFormat) {
        bytesHexFormat.getClass();
        numberHexFormat.getClass();
        this.upperCase = z;
        this.bytes = bytesHexFormat;
        this.number = numberHexFormat;
    }

    public final String toString() {
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("HexFormat(\n    upperCase = ");
        sbM.append(this.upperCase);
        sbM.append(",\n    bytes = BytesHexFormat(\n");
        this.bytes.appendOptionsTo$kotlin_stdlib(sbM, "        ");
        sbM.append('\n');
        sbM.append("    ),");
        sbM.append('\n');
        sbM.append("    number = NumberHexFormat(");
        sbM.append('\n');
        this.number.appendOptionsTo$kotlin_stdlib(sbM, "        ");
        sbM.append('\n');
        sbM.append("    )");
        sbM.append('\n');
        sbM.append(")");
        return sbM.toString();
    }
}
