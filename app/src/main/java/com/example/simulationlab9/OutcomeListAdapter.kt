package com.example.simulationlab9

import android.content.Context
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prob_item.view.*
import android.text.Editable



class OutcomeListAdapter (val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.prob_item,parent,false))
    }

    override fun getItemCount(): Int {
        return ExperimentWorker.outcomeSet.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).probLbl.text="Prob"+(position+1).toString()
        if (position==ExperimentWorker.outcomeSet.size-1)
            (holder as ViewHolder).probEd.setText("Auto")
        else
        {
            var num=position
            (holder as ViewHolder).probEd.setText(ExperimentWorker.outcomeSet[position].prob.toString())
            holder.probEd.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                    ExperimentWorker.outcomeSet[num].prob = s.toString().toFloat()
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    //  ExperimentWorker.outcomeSet[num].prob = s.toString().toFloat()
                }
            })
        }
        if ((ExperimentWorker.outcomeSet[position].quan/ExperimentWorker.numberOfExp).toString()=="NaN")
            (holder as ViewHolder).probExp.text="Not yet counted"
        else (holder as ViewHolder).probExp.text=(ExperimentWorker.outcomeSet[position].quan/ExperimentWorker.numberOfExp).toString()

    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val probLbl=view.textViewProbLabel
    val probEd=view.probEdit
    val probExp=view.textViewExperement
}
