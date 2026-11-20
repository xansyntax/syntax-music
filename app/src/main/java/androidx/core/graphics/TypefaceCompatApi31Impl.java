package androidx.core.graphics;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceCompatApi31Impl extends TypefaceCompatApi29Impl {
    @Override // androidx.core.graphics.TypefaceCompatApi29Impl
    public final Font getFontFromSystemFont(FontsContractCompat$FontInfo fontsContractCompat$FontInfo) {
        Font fontGuessPrimaryFont;
        Uri uri = fontsContractCompat$FontInfo.mUri;
        boolean zEquals = Objects.equals(uri.getScheme(), "systemfont");
        String str = fontsContractCompat$FontInfo.mVariationSettings;
        String authority = zEquals ? uri.getAuthority() : null;
        if (authority != null) {
            Typeface typefaceCreate = Typeface.create(authority, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                typefaceCreate = null;
            }
            if (typefaceCreate != null && (fontGuessPrimaryFont = TypefaceCompat.guessPrimaryFont(typefaceCreate)) != null) {
                if (TextUtils.isEmpty(str)) {
                    return fontGuessPrimaryFont;
                }
                try {
                    return new Font.Builder(fontGuessPrimaryFont).setFontVariationSettings(str).build();
                } catch (IOException unused) {
                    Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
                    return null;
                }
            }
        }
        return null;
    }
}
