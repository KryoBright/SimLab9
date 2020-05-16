package com.example.simulationlab9

import java.util.ArrayList
import kotlin.random.Random

class ExperimentWorker {
    companion object{
        var outcomeSet:MutableList<Outcome> = ArrayList<Outcome>()
        var numberOfExp=0f

        fun makeExperiment() {
            var alpha= Random.nextDouble().toFloat()
            var oIndex=0
            while ((alpha> outcomeSet[oIndex].prob)&&(oIndex< outcomeSet.size-1))
            {
                alpha-=outcomeSet[oIndex].prob
                oIndex++
            }
            outcomeSet[oIndex].quan++
            numberOfExp++
        }

    }
}