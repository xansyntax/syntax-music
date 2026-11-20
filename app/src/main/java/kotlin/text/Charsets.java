package kotlin.text;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Charsets {
    public static final Charsets INSTANCE = new Charsets();
    public static final Charset ISO_8859_1;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;
    public static volatile Charset utf_32be;
    public static volatile Charset utf_32le;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        charsetForName.getClass();
        UTF_8 = charsetForName;
        Charset.forName("UTF-16").getClass();
        Charset charsetForName2 = Charset.forName("UTF-16BE");
        charsetForName2.getClass();
        UTF_16BE = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16LE");
        charsetForName3.getClass();
        UTF_16LE = charsetForName3;
        Charset.forName("US-ASCII").getClass();
        Charset charsetForName4 = Charset.forName("ISO-8859-1");
        charsetForName4.getClass();
        ISO_8859_1 = charsetForName4;
    }
}
