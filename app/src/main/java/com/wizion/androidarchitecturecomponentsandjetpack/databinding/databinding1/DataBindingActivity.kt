package com.wizion.androidarchitecturecomponentsandjetpack.databinding.databinding1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    lateinit var binding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)

        /*
            What is Data-Binding ?
            *Data binding in Android is a way to connect the user interface (UI) elements of your app with the underlying data sources, such as variables, objects, or collections. It simplifies the process of updating UI components when the data changes, reducing boilerplate code and making your code more maintainable and readable.

            Some benefits of using data binding in Android include:
            *Reduced boilerplate code
            *Improved code readability and maintainability
            *Improved testability of your code
            *No need to call findViewById
            *Null Pointer Exception can handle at compile time
            *Performance & No Memory Leaks

            Example :
            val emailTextView = findViewById<TextView>(R.id.email_text_view)
            emailTextView.text = model.emailAddress

            above code can be replaced by this code
            <TextView android:text="@{model.emailAddress}"/>

            Type of Data-Binding
            1.One Way ==>> Only setting data to views --> LiveData
            2.Two Way ==>> setting and updating data through views(EditText) <--> LiveData
         */

        val quoteObj = Quote("Do or do not. There is no try","Yoda")
        binding.quote=quoteObj

    }
}