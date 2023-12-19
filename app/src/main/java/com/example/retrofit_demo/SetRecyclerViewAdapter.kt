package com.example.retrofit_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_demo.api.TaskDto
import com.example.retrofit_demo.api.TaskService

class SetRecyclerViewAdapter (private val context: Context, private val taskService: TaskService,
                              private val listener: OnItemClickListener):
    RecyclerView.Adapter<SetRecyclerViewAdapter.MyViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(task: TaskDto, position: Int)
    }

    private val tasks: MutableList<TaskDto> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.single_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = tasks[position].name
        holder.description.text = tasks[position].description

        holder.itemView.setOnLongClickListener {
            ConfirmPopup.showConfirmationDialog(context, "Confirmation", "Are you sure you want to remove this task?", object : ConfirmPopup.ConfirmationListener {
                override fun onConfirm() {
                    taskService.deleteTask(tasks[holder.adapterPosition].id) { success ->
                        if (success) {
                            tasks.removeAt(holder.adapterPosition)
                            notifyItemRemoved(holder.adapterPosition)
                            Toast.makeText(context, "Task deleted successfully", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Unable to delete task", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onCancel() {
                }
            })
            true
        }

        holder.itemView.setOnClickListener {
            listener.onItemClick(tasks[position], position)
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    class MyViewHolder(itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val description: TextView = itemView.findViewById(R.id.description)
    }

    fun updateTask(task:TaskDto, position: Int) {
        tasks[position] = task
        notifyItemChanged(position)
    }

    fun addTask(task: TaskDto) {
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
    }

    fun updateTasks(newTasks: List<TaskDto>) {
        tasks.clear()
        tasks.addAll(newTasks)
        notifyDataSetChanged()
    }
}