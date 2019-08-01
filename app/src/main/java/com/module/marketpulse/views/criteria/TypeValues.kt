package com.module.marketpulse.views.criteria


import androidx.annotation.StringDef

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

class TypeValues {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef(TypeValuesString.PLAINTEXT, TypeValuesString.VARIABLE)
    annotation class TypeValuesString {
        companion object {

            const val PLAINTEXT = "plain_text"

            const val VARIABLE = "variable"

        }

    }
}