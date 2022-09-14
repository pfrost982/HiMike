package ru.gb.himike.ui.home.recycler_classes

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gb.himike.R
import ru.gb.himike.databinding.ItemHomeworkBinding
import ru.gb.himike.entity.Homework

class HomeworkAdapter(private val homeworksList: List<Homework>) : RecyclerView.Adapter<HomeworkAdapter.ClassesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClassesViewHolder(ItemHomeworkBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.bind(homeworksList[position])
    }

    override fun getItemCount(): Int = homeworksList.size

    inner class ClassesViewHolder(private val binding: ItemHomeworkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(homework: Homework) {
            binding.nameLesson.text = homework.name
            binding.description.text = homework.description
            binding.imageLesson.setImageResource(homework.icon)
            binding.daysLeft.text = "${homework.daysLeft} days left"
            if(homework.daysLeft < 3) {
                binding.daysLeftClock.setImageResource(R.drawable.ic_time_red_24)
                binding.daysLeft.setTextColor(Color.RED)
            }
        }
    }
}