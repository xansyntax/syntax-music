package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import kotlin.Metadata;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.StringFormat;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/serialization/Configuration;", "Lio/ktor/http/ContentType;", "contentType", "Lkotlinx/serialization/BinaryFormat;", "format", "", "serialization", "(Lio/ktor/serialization/Configuration;Lio/ktor/http/ContentType;Lkotlinx/serialization/BinaryFormat;)V", "Lkotlinx/serialization/StringFormat;", "(Lio/ktor/serialization/Configuration;Lio/ktor/http/ContentType;Lkotlinx/serialization/StringFormat;)V", "ktor-serialization-kotlinx"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class KotlinxSerializationConverterKt {
    public static final void serialization(Configuration configuration, ContentType contentType, BinaryFormat binaryFormat) {
        configuration.getClass();
        contentType.getClass();
        binaryFormat.getClass();
        Configuration.register$default(configuration, contentType, new KotlinxSerializationConverter(binaryFormat), null, 4, null);
    }

    public static final void serialization(Configuration configuration, ContentType contentType, StringFormat stringFormat) {
        configuration.getClass();
        contentType.getClass();
        stringFormat.getClass();
        Configuration.register$default(configuration, contentType, new KotlinxSerializationConverter(stringFormat), null, 4, null);
    }
}
