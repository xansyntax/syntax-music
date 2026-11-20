package kotlinx.serialization.json;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonConfiguration {
    public final boolean allowSpecialFloatingPointValues;
    public final boolean allowStructuredMapKeys;
    public final String classDiscriminator;
    public final ClassDiscriminatorMode classDiscriminatorMode;
    public final boolean encodeDefaults;
    public final boolean exceptionsWithDebugInfo;
    public final boolean explicitNulls;
    public final boolean ignoreUnknownKeys;
    public final boolean isLenient;
    public final boolean prettyPrint;
    public final String prettyPrintIndent;
    public final boolean useAlternativeNames;

    public JsonConfiguration(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, String str2, boolean z7, boolean z8, ClassDiscriminatorMode classDiscriminatorMode, boolean z9) {
        str.getClass();
        str2.getClass();
        classDiscriminatorMode.getClass();
        this.encodeDefaults = z;
        this.ignoreUnknownKeys = z2;
        this.isLenient = z3;
        this.allowStructuredMapKeys = z4;
        this.prettyPrint = z5;
        this.explicitNulls = z6;
        this.prettyPrintIndent = str;
        this.classDiscriminator = str2;
        this.allowSpecialFloatingPointValues = z7;
        this.useAlternativeNames = z8;
        this.classDiscriminatorMode = classDiscriminatorMode;
        this.exceptionsWithDebugInfo = z9;
    }

    public final String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.encodeDefaults + ", ignoreUnknownKeys=" + this.ignoreUnknownKeys + ", isLenient=" + this.isLenient + ", allowStructuredMapKeys=" + this.allowStructuredMapKeys + ", prettyPrint=" + this.prettyPrint + ", explicitNulls=" + this.explicitNulls + ", prettyPrintIndent='" + this.prettyPrintIndent + "', coerceInputValues=false, useArrayPolymorphism=false, classDiscriminator='" + this.classDiscriminator + "', allowSpecialFloatingPointValues=" + this.allowSpecialFloatingPointValues + ", useAlternativeNames=" + this.useAlternativeNames + ", namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=" + this.classDiscriminatorMode + ", exceptionsWithDebugInfo=" + this.exceptionsWithDebugInfo + ')';
    }
}
