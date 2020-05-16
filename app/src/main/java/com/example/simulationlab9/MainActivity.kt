package com.example.simulationlab9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerProbs.layoutManager= LinearLayoutManager(this)
        recyclerProbs.adapter=OutcomeListAdapter(this)
        var i=0
        while (i<6){
            ExperimentWorker.outcomeSet.add(Outcome())
            i++
        }

        button.setOnClickListener {
            var j=0
            while (j<ExperimentWorker.outcomeSet.size)
            {
                ExperimentWorker.outcomeSet[j].quan=0f
                j++
            }
            ExperimentWorker.numberOfExp=0f
            var maxExperiments=("0"+editNumberOfExperiments.text.toString()).toInt()
            var i=0
            while (i<maxExperiments)
            {
                ExperimentWorker.makeExperiment()
                i++
            }
         //   recyclerProbs.invalidate()
         //   (recyclerProbs.adapter as OutcomeListAdapter).notifyItemRangeChanged(0,ExperimentWorker.outcomeSet.size)
            recyclerProbs.adapter=OutcomeListAdapter(this)
        }
    }
}
