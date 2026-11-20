package androidx.media3.extractor.text.webvtt;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WebvttCssStyle {
    public int backgroundColor;
    public int bold;
    public boolean combineUpright;
    public int fontColor;
    public String fontFamily;
    public float fontSize;
    public int fontSizeUnit;
    public boolean hasBackgroundColor;
    public boolean hasFontColor;
    public int italic;
    public int linethrough;
    public int rubyPosition;
    public Set targetClasses;
    public String targetId;
    public String targetTag;
    public String targetVoice;
    public int underline;

    public static int updateScoreForMatch(int i, int i2, String str, String str2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }
}
