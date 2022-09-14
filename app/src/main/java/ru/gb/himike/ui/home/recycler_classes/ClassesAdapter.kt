package ru.gb.himike.ui.home.recycler_classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gb.himike.databinding.ItemClassBinding
import ru.gb.himike.entity.Lesson

class ClassesAdapter(private val lessonsList: List<Lesson>) : RecyclerView.Adapter<ClassesAdapter.ClassesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClassesViewHolder(ItemClassBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.bind(lessonsList[position])
    }

    override fun getItemCount(): Int = lessonsList.size

    inner class ClassesViewHolder(private val binding: ItemClassBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lesson: Lesson) {
            binding.nameLesson.text = lesson.name
            binding.timeLesson.text = lesson.time
        }
    }
}