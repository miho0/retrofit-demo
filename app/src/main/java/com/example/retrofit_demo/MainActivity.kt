package com.example.retrofit_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_demo.api.TaskAddUpdateDto
import com.example.retrofit_demo.api.TaskDto
import com.example.retrofit_demo.api.TaskService
import com.example.retrofit_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SetRecyclerViewAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val taskService: TaskService = TaskService()
    private lateinit var adapter: SetRecyclerViewAdapter
    private var isEditing = false
    private var editingId = ""
    private var editingPosition:Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameInput = binding.nameInput
        val descriptionInput = binding.descriptionInput
        val submitButton = binding.submitButton

        submitButton.setOnClickListener {
            if (!isEditing) {
                if (nameInput.text.isBlank() || descriptionInput.text.isBlank()) {
                    Toast.makeText(this, "Please input the data", Toast.LENGTH_SHORT).show()
                } else {
                    val taskAddDto = TaskAddUpdateDto(nameInput.text.toString(), descriptionInput.text.toString())
                    taskService.addTask(taskAddDto)
                    taskService.getTasks { tasks ->
                        tasks?.let {
                            adapter.updateTasks(tasks)
                        }
                    }
                }
            } else {
                if (nameInput.text.isBlank() || descriptionInput.text.isBlank()) {
                    Toast.makeText(this, "Please input the data", Toast.LENGTH_SHORT).show()
                } else {
                    val task = TaskAddUpdateDto(nameInput.text.toString(), descriptionInput.text.toString())
                    taskService.updateTask(editingId, task)
                    adapter.updateTask(TaskDto(editingId, nameInput.text.toString(), descriptionInput.text.toString()), editingPosition)
                    reset()
                }
            }

        }

        adapter = SetRecyclerViewAdapter(this, taskService, this)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        taskService.getTasks { tasks ->
            tasks?.let {
                adapter.updateTasks(tasks)
            }
        }
    }

    override fun onItemClick(task: TaskDto, position: Int) {
        isEditing = true
        editingId = task.id
        editingPosition = position
        binding.submitButton.text = "Edit"
        binding.nameInput.setText(task.name)
        binding.descriptionInput.setText(task.description)
    }

    private fun reset() {
        isEditing = false
        editingId = ""
        editingPosition = -1
        binding.submitButton.text = "Save"
        binding.nameInput.setText("")
        binding.descriptionInput.setText("")
    }
}