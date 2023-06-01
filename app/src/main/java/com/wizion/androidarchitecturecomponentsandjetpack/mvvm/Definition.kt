package com.wizion.androidarchitecturecomponentsandjetpack.mvvm

class Definition {

    /**
     * Repository Pattern
     * ->Not specific to Android - It is a common design pattern.
     * ->Reusable solution to a commonly problem in software design.
     *
     * Important points
     * ->Repository mediates between the domain layers & data mapping layers.
     * ->Client constructs the query & submits it to the repository.
     * ->Repository encapsulates all of this logic of resolving that query.
     *
     * Need of Architecture
     * ->Scalability & Maintainability of an application.
     * ->To achieve this- we implement architecture patterns - MVC, MVP, MVVM etc.
     * ->Architecture patterns mainly focus on-
     *  1.Separation of Concerns
     *  2.Unit Testing
     *
     * MVC->(MODEL-VIEW-CONTROLLER) It is a default android architecture.
     * View <--> Controller <--> Model
     * 1.View -> Layout Files(XML)
     * 2.Controller -> Activity/Fragment
     * 3.Model -> Data Classes,POJO etc.
     *
     * MVP->(Model-View-Presenter)
     * View <--> Presenter <--> Model
     * 1.View -> Layout Files(XML)/Activity/Fragment
     * 2.Presenter -> Simple Class Presentation Logic
     * 3.Model -> Data Classes, POJO etc.
     *
     * MVVM ->(Model-View-View Model)
     * View <--> ViewModel <--> Model(Repository--> API Calling or Room DB)
     * 1.View -> Layout Files(XML)/Activity/Fragment
     * 2.ViewModel -> Simple Class Presentation Logic(Observables)
     * 3.Model -> Data Classes, POJO etc.
     *
     * Main Components of MVVM
     * ->Room Database and/or Retrofit Setup
     * ->Repository
     * ->LiveData, ViewModel with ViewModelFactory
     * ->Activity/Fragment with Data Binding
     *
     * Question : What is DiffUtil?
     * Answer : DiffUtil is a utility class provided by the Android Jetpack library that helps in calculating the differences between two lists or arrays.DiffUtil is a useful tool for optimizing the performance of RecyclerViews by efficiently calculating the differences between two lists and applying targeted updates to the UI.
     *
     * Question : what is Work Manager?
     * Answer : Schedule tasks that can run even if app exists or device restarts.
     * Simply, run background jobs using Work Manager
     * Example - Sync Data From Server
     */
}