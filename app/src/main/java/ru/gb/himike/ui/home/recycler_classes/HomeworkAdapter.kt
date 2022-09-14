package ru.gb.himike.ui.home.recycler_classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gb.himike.databinding.ItemHomeworkBinding
import ru.gb.himike.entity.Lesson

class HomeworkAdapter(private val lessonsList: List<Lesson>) : RecyclerView.Adapter<HomeworkAdapter.ClassesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClassesViewHolder(ItemHomeworkBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.bind(lessonsList[position])
    }

    override fun getItemCount(): Int = lessonsList.size

    inner class ClassesViewHolder(private val binding: ItemHomeworkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lesson: Lesson) {
            binding.nameLesson.text = lesson.name
            binding.timeLesson.text = lesson.time
            binding.imageLesson.setImageResource(lesson.icon)
        }
    }
}