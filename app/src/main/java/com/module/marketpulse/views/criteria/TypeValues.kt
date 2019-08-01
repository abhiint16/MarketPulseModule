package com.module.marketpulse.views.criteria


import androidx.annotation.StringDef

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

class TypeValues {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef(TypeVariableString.PLAINTEXT, TypeVariableString.VARIABLE)
    annotation class TypeVariableString {
        companion object {

            const val PLAINTEXT = "plain_text"

            const val VARIABLE = "variable"

        }

    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef(TypeValueString.VALUE, TypeValueString.INDICATOR)
    annotation class TypeValueString {
        companion object {

            const val VALUE = "value"

            const val INDICATOR = "indicator"

        }

    }
}