package com.kotlin.academy.ui.reader

/**
 *@author Rizki Rian Anandita
 * Create By rizki
 */
interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}