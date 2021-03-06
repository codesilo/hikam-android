package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;
import com.google.firebase.FirebaseException;

public class FirebaseAuthException extends FirebaseException {
    private final String aTP;

    public FirebaseAuthException(@NonNull String str, @NonNull String str2) {
        super(str2);
        this.aTP = zzac.zzhz(str);
    }

    @NonNull
    public String getErrorCode() {
        return this.aTP;
    }
}
