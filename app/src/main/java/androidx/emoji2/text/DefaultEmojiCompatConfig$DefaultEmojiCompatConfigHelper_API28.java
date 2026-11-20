package androidx.emoji2.text;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.collection.internal.Lock;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28 extends Lock {
    @Override // androidx.collection.internal.Lock
    public final Signature[] getSigningSignatures(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
