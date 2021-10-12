package com.example.wellcome

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.example.wellcome.models.Assistance
import com.example.wellcome.models.Hosting
import com.example.wellcome.models.Host
import com.example.wellcome.models.Lesson
import com.example.wellcome.utils.WellcomeDbContext
import com.example.wellcome.utils.WellcomeDbHelper
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SQLiteTest {
    private lateinit var dbContext: WellcomeDbContext
    private lateinit var context:Context

    @Before
    fun setup(){
        context = InstrumentationRegistry.getInstrumentation().targetContext
        dbContext = WellcomeDbContext(context)
    }

     @After
     fun clean(){
         context.deleteDatabase(WellcomeDbHelper.DATABASE_NAME)
     }

     @Test
     fun createLogementTest(){
         val host = Host(
             "title",
             "description",
             "9 rue du puits grenet Ermont 95120",
             "0668319800",
             listOf("baby", "handicape"),
             "3",
            "2"
         )
         val id = dbContext.insertLogement(host)
         Assert.assertNotNull(id)
     }

     @Test
     fun createCoursTest(){
         val cours = Lesson(
             "title",
             "description",
             "9 rue du puits grenet Ermont 95120",
             "0668319800",
             listOf("baby", "handicape"),
             "3"
         )
         val id = dbContext.insertCours(cours)
         Assert.assertNotNull(id)
     }

     @Test
     fun createAssistanceTest(){
         val assistance = Assistance(
             "title",
             "description",
             "9 rue du puits grenet Ermont 95120",
             "0668319800",
             listOf("baby", "handicape"),
             "urgent"
         )
         val id = dbContext.insertAssistance(assistance)
         Assert.assertNotNull(id)
     }
}