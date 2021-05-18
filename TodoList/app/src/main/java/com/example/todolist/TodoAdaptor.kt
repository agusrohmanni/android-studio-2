package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdaptor (private val todos: MutableList<Todo>): RecyclerView.Adapter<TodoAdaptor.TodoViewHolder>()
{
    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_todo,
                        parent,
                        false
                )
        )
    }


    fun addTodo(todo:Todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }


    fun deleteTodo(){
        todos.removeAll { todo ->
            todo.isChek
        }
        notifyDataSetChanged()
    }


    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean){
        if(isChecked){
            tvTodoTitle.paintFlags= tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvTodoTitle.paintFlags= tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo= todos[position]
        holder.itemView.apply {
            tvTodoTitle.text= curTodo.title
            cbDone.isChecked= curTodo.isChek
            toggleStrikeThrough(tvTodoTitle,curTodo.isChek)
            cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvTodoTitle,isChecked)
                curTodo.isChek != curTodo.isChek
            }

        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}