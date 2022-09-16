package br.senai.sp.jandira.imc20.utils

import android.content.Context
import br.senai.sp.jandira.imc20.R
import kotlin.math.pow

fun getBmi(weight: Int, height: Float): Float {
    return weight / height.pow(2)
}



fun getStatus(bmi: Double, context: Context): String{

     var situation = ""
    if(bmi <= 18.5){
       situation =  context.getString(R.string.under_weight)
    }else if(bmi > 18.5 && bmi < 25.0 ){
        situation =  context.getString(R.string.ideal_weight)
    }else if(bmi >= 25.0 && bmi < 30.0){
        situation =  context.getString(R.string.slightly_over)
    }else if (bmi >= 30.0 && bmi < 35.0){
       situation =  context.getString(R.string.gradeI_obesity)
    }else if(bmi >= 35.0 && bmi <40){
        situation =  context.getString(R.string.gradeII_obesity)
    }else{
        situation = context.getString(R.string.gradeIII_obesity)
    }

    return situation
}