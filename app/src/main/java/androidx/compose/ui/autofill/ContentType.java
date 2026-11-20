package androidx.compose.ui.autofill;

import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ContentType {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final AndroidContentType EmailAddress;
        public static final AndroidContentType Password;
        public static final AndroidContentType PhoneNumber;

        static {
            MathKt.ContentType("username");
            Password = MathKt.ContentType("password");
            EmailAddress = MathKt.ContentType("emailAddress");
            MathKt.ContentType("newUsername");
            MathKt.ContentType("newPassword");
            MathKt.ContentType("postalAddress");
            MathKt.ContentType("postalCode");
            MathKt.ContentType("creditCardNumber");
            MathKt.ContentType("creditCardSecurityCode");
            MathKt.ContentType("creditCardExpirationDate");
            MathKt.ContentType("creditCardExpirationMonth");
            MathKt.ContentType("creditCardExpirationYear");
            MathKt.ContentType("creditCardExpirationDay");
            MathKt.ContentType("addressCountry");
            MathKt.ContentType("addressRegion");
            MathKt.ContentType("addressLocality");
            MathKt.ContentType("streetAddress");
            MathKt.ContentType("extendedAddress");
            MathKt.ContentType("extendedPostalCode");
            MathKt.ContentType("personName");
            MathKt.ContentType("personGivenName");
            MathKt.ContentType("personFamilyName");
            MathKt.ContentType("personMiddleName");
            MathKt.ContentType("personMiddleInitial");
            MathKt.ContentType("personNamePrefix");
            MathKt.ContentType("personNameSuffix");
            PhoneNumber = MathKt.ContentType("phoneNumber");
            MathKt.ContentType("phoneNumberDevice");
            MathKt.ContentType("phoneCountryCode");
            MathKt.ContentType("phoneNational");
            MathKt.ContentType("gender");
            MathKt.ContentType("birthDateFull");
            MathKt.ContentType("birthDateDay");
            MathKt.ContentType("birthDateMonth");
            MathKt.ContentType("birthDateYear");
            MathKt.ContentType("smsOTPCode");
        }
    }
}
