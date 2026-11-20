package com.metrolist.innertubex.extraction.strategy;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClientRequestCapabilities {
    public final boolean cookies;
    public final boolean embedded;
    public final boolean encryptedHostFlags;
    public final JavaScriptRequirement nTransform;
    public final JavaScriptRequirement signatureCipher;
    public final boolean signatureTimestamp;
    public final WebViewRequirement webView;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ClientRequestCapabilities(int i, boolean z, boolean z2) {
        int i2 = i & 2;
        JavaScriptRequirement javaScriptRequirement = JavaScriptRequirement.NEVER;
        JavaScriptRequirement javaScriptRequirement2 = JavaScriptRequirement.RESPONSE_DEPENDENT;
        this(z, i2 != 0 ? javaScriptRequirement : javaScriptRequirement2, (i & 4) != 0 ? javaScriptRequirement : javaScriptRequirement2, (i & 8) != 0 ? WebViewRequirement.NONE : WebViewRequirement.OPTIONAL_TOKEN_MINTING, (i & 16) == 0, (i & 32) != 0 ? false : z2, false);
    }

    public static ClientRequestCapabilities copy$default(ClientRequestCapabilities clientRequestCapabilities, WebViewRequirement webViewRequirement, int i) {
        boolean z = clientRequestCapabilities.signatureTimestamp;
        JavaScriptRequirement javaScriptRequirement = clientRequestCapabilities.signatureCipher;
        JavaScriptRequirement javaScriptRequirement2 = clientRequestCapabilities.nTransform;
        if ((i & 8) != 0) {
            webViewRequirement = clientRequestCapabilities.webView;
        }
        WebViewRequirement webViewRequirement2 = webViewRequirement;
        boolean z2 = (i & 16) != 0 ? clientRequestCapabilities.cookies : false;
        boolean z3 = (i & 32) != 0 ? clientRequestCapabilities.embedded : true;
        boolean z4 = (i & 64) != 0 ? clientRequestCapabilities.encryptedHostFlags : true;
        javaScriptRequirement.getClass();
        javaScriptRequirement2.getClass();
        webViewRequirement2.getClass();
        return new ClientRequestCapabilities(z, javaScriptRequirement, javaScriptRequirement2, webViewRequirement2, z2, z3, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientRequestCapabilities)) {
            return false;
        }
        ClientRequestCapabilities clientRequestCapabilities = (ClientRequestCapabilities) obj;
        return this.signatureTimestamp == clientRequestCapabilities.signatureTimestamp && this.signatureCipher == clientRequestCapabilities.signatureCipher && this.nTransform == clientRequestCapabilities.nTransform && this.webView == clientRequestCapabilities.webView && this.cookies == clientRequestCapabilities.cookies && this.embedded == clientRequestCapabilities.embedded && this.encryptedHostFlags == clientRequestCapabilities.encryptedHostFlags;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.encryptedHostFlags) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((this.webView.hashCode() + ((this.nTransform.hashCode() + ((this.signatureCipher.hashCode() + (Boolean.hashCode(this.signatureTimestamp) * 31)) * 31)) * 31)) * 31, this.cookies, 31), this.embedded, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ClientRequestCapabilities(signatureTimestamp=");
        sb.append(this.signatureTimestamp);
        sb.append(", signatureCipher=");
        sb.append(this.signatureCipher);
        sb.append(", nTransform=");
        sb.append(this.nTransform);
        sb.append(", webView=");
        sb.append(this.webView);
        sb.append(", cookies=");
        Fragment$5$$ExternalSyntheticOutline0.m(sb, this.cookies, ", embedded=", this.embedded, ", encryptedHostFlags=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.encryptedHostFlags, ")");
    }

    public ClientRequestCapabilities(boolean z, JavaScriptRequirement javaScriptRequirement, JavaScriptRequirement javaScriptRequirement2, WebViewRequirement webViewRequirement, boolean z2, boolean z3, boolean z4) {
        javaScriptRequirement.getClass();
        javaScriptRequirement2.getClass();
        webViewRequirement.getClass();
        this.signatureTimestamp = z;
        this.signatureCipher = javaScriptRequirement;
        this.nTransform = javaScriptRequirement2;
        this.webView = webViewRequirement;
        this.cookies = z2;
        this.embedded = z3;
        this.encryptedHostFlags = z4;
    }
}
